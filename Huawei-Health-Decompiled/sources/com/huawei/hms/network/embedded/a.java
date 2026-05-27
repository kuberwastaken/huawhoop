package com.huawei.hms.network.embedded;

import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements Closeable {
    public static final String o = "journal";
    public static final String p = "journal.tmp";
    public static final String q = "journal.bkp";
    public static final String r = "libcore.io.DiskLruCache";
    public static final String s = "1";
    public static final long t = -1;
    public static final String u = "CLEAN";
    public static final String v = "DIRTY";
    public static final String w = "REMOVE";
    public static final String x = "READ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f5331a;
    public final File b;
    public final File c;
    public final File d;
    public final int e;
    public long f;
    public final int g;
    public Writer i;
    public int k;
    public long h = 0;
    public final LinkedHashMap<String, d> j = new LinkedHashMap<>(0, 0.75f, true);
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    public final Callable<Void> n = new CallableC0155a();

    public long w() {
        long j;
        synchronized (this) {
            j = this.h;
        }
        return j;
    }

    public boolean v() {
        boolean z;
        synchronized (this) {
            z = this.i == null;
        }
        return z;
    }

    public long u() {
        long j;
        synchronized (this) {
            j = this.f;
        }
        return j;
    }

    public File t() {
        return this.f5331a;
    }

    public void s() throws IOException {
        close();
        com.huawei.hms.network.embedded.c.a(this.f5331a);
    }

    public void j(long j) {
        synchronized (this) {
            this.f = j;
            this.m.submit(this.n);
        }
    }

    public void flush() throws IOException {
        synchronized (this) {
            x();
            C();
            b(this.i);
        }
    }

    public boolean d(String str) throws IOException {
        synchronized (this) {
            x();
            d dVar = this.j.get(str);
            if (dVar != null && dVar.f == null) {
                for (int i = 0; i < this.g; i++) {
                    File fileA = dVar.a(i);
                    if (fileA.exists() && !fileA.delete()) {
                        throw new IOException("failed to delete " + fileA);
                    }
                    this.h -= dVar.b[i];
                    dVar.b[i] = 0;
                }
                this.k++;
                this.i.append((CharSequence) "REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence) str);
                this.i.append('\n');
                this.j.remove(str);
                if (y()) {
                    this.m.submit(this.n);
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            if (this.i == null) {
                return;
            }
            for (d dVar : new ArrayList(this.j.values())) {
                if (dVar.f != null) {
                    dVar.f.a();
                }
            }
            C();
            a(this.i);
            this.i = null;
        }
    }

    public e c(String str) throws IOException {
        synchronized (this) {
            x();
            d dVar = this.j.get(str);
            if (dVar == null) {
                return null;
            }
            if (!dVar.e) {
                return null;
            }
            for (File file : dVar.c) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.k++;
            this.i.append((CharSequence) "READ");
            this.i.append(' ');
            this.i.append((CharSequence) str);
            this.i.append('\n');
            if (y()) {
                this.m.submit(this.n);
            }
            return new e(this, str, dVar.g, dVar.c, dVar.b, null);
        }
    }

    public c b(String str) throws IOException {
        return a(str, -1L);
    }

    private void z() throws IOException {
        a(this.c);
        Iterator<d> it = this.j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.g) {
                    this.h += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.g) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    private void x() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void e(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        d dVar = this.j.get(strSubstring);
        CallableC0155a callableC0155a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0155a);
            this.j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.e = true;
            dVar.f = null;
            dVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f = new c(this, dVar, callableC0155a);
        } else {
            if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public static void b(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5334a;
        public final long[] b;
        public File[] c;
        public File[] d;
        public boolean e;
        public c f;
        public long g;

        public File b(int i) {
            return this.d[i];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File a(int i) {
            return this.c[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.g) {
                throw a(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public /* synthetic */ d(a aVar, String str, CallableC0155a callableC0155a) {
            this(str);
        }

        public d(String str) {
            this.f5334a = str;
            this.b = new long[a.this.g];
            this.c = new File[a.this.g];
            this.d = new File[a.this.g];
            StringBuilder sb = new StringBuilder(str);
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            int length = sb.length();
            for (int i = 0; i < a.this.g; i++) {
                sb.append(i);
                this.c[i] = new File(a.this.f5331a, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(a.this.f5331a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    public static String b(InputStream inputStream) throws IOException {
        return com.huawei.hms.network.embedded.c.a((Reader) new InputStreamReader(inputStream, com.huawei.hms.network.embedded.c.b));
    }

    public static void a(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f5333a;
        public final boolean[] b;
        public boolean c;

        public void c() throws IOException {
            a.this.a(this, true);
            this.c = true;
        }

        public void b() {
            if (this.c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public String b(int i) throws IOException {
            InputStream inputStreamC = c(i);
            if (inputStreamC != null) {
                return a.b(inputStreamC);
            }
            return null;
        }

        public void a(int i, String str) throws Throwable {
            Throwable th;
            OutputStreamWriter outputStreamWriter;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(a(i)), com.huawei.hms.network.embedded.c.b);
                try {
                    outputStreamWriter.write(str);
                    com.huawei.hms.network.embedded.c.a(outputStreamWriter);
                } catch (Throwable th2) {
                    th = th2;
                    com.huawei.hms.network.embedded.c.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = null;
            }
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }

        public File a(int i) throws IOException {
            File fileB;
            synchronized (a.this) {
                if (this.f5333a.f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f5333a.e) {
                    this.b[i] = true;
                }
                fileB = this.f5333a.b(i);
                a.this.f5331a.mkdirs();
            }
            return fileB;
        }

        private InputStream c(int i) throws IOException {
            synchronized (a.this) {
                if (this.f5333a.f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f5333a.e) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f5333a.a(i));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0155a callableC0155a) {
            this(dVar);
        }

        public c(d dVar) {
            this.f5333a = dVar;
            this.b = dVar.e ? null : new boolean[a.this.g];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, boolean z) throws IOException {
        synchronized (this) {
            d dVar = cVar.f5333a;
            if (dVar.f != cVar) {
                throw new IllegalStateException();
            }
            if (z && !dVar.e) {
                for (int i = 0; i < this.g; i++) {
                    if (!cVar.b[i]) {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!dVar.b(i).exists()) {
                        cVar.a();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < this.g; i2++) {
                File fileB = dVar.b(i2);
                if (!z) {
                    a(fileB);
                } else if (fileB.exists()) {
                    File fileA = dVar.a(i2);
                    fileB.renameTo(fileA);
                    long j = dVar.b[i2];
                    long length = fileA.length();
                    dVar.b[i2] = length;
                    this.h = (this.h - j) + length;
                }
            }
            this.k++;
            dVar.f = null;
            if (!(dVar.e | z)) {
                this.j.remove(dVar.f5334a);
                this.i.append((CharSequence) "REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence) dVar.f5334a);
                this.i.append('\n');
            } else {
                dVar.e = true;
                this.i.append((CharSequence) "CLEAN");
                this.i.append(' ');
                this.i.append((CharSequence) dVar.f5334a);
                this.i.append((CharSequence) dVar.a());
                this.i.append('\n');
                if (z) {
                    long j2 = this.l;
                    this.l = 1 + j2;
                    dVar.g = j2;
                }
            }
            b(this.i);
            if (this.h > this.f || y()) {
                this.m.submit(this.n);
            }
        }
    }

    public static a a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j);
        if (aVar.b.exists()) {
            try {
                aVar.A();
                aVar.z();
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.s();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j);
        aVar2.B();
        return aVar2;
    }

    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5335a;
        public final long b;
        public final long[] c;
        public final File[] d;

        public String c(int i) throws IOException {
            return a.b(new FileInputStream(this.d[i]));
        }

        public long b(int i) {
            return this.c[i];
        }

        public File a(int i) {
            return this.d[i];
        }

        public c a() throws IOException {
            return a.this.a(this.f5335a, this.b);
        }

        public /* synthetic */ e(a aVar, String str, long j, File[] fileArr, long[] jArr, CallableC0155a callableC0155a) {
            this(str, j, fileArr, jArr);
        }

        public e(String str, long j, File[] fileArr, long[] jArr) {
            this.f5335a = str;
            this.b = j;
            this.d = fileArr;
            this.c = jArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(String str, long j) throws IOException {
        synchronized (this) {
            x();
            d dVar = this.j.get(str);
            CallableC0155a callableC0155a = null;
            if (j != -1 && (dVar == null || dVar.g != j)) {
                return null;
            }
            if (dVar == null) {
                dVar = new d(this, str, callableC0155a);
                this.j.put(str, dVar);
            } else if (dVar.f != null) {
                return null;
            }
            c cVar = new c(this, dVar, callableC0155a);
            dVar.f = cVar;
            this.i.append((CharSequence) "DIRTY");
            this.i.append(' ');
            this.i.append((CharSequence) str);
            this.i.append('\n');
            b(this.i);
            return cVar;
        }
    }

    /* JADX INFO: renamed from: com.huawei.hms.network.embedded.a$a, reason: collision with other inner class name */
    public class CallableC0155a implements Callable<Void> {
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.i == null) {
                    return null;
                }
                a.this.C();
                if (a.this.y()) {
                    a.this.B();
                    a.this.k = 0;
                }
                return null;
            }
        }

        public CallableC0155a() {
        }
    }

    public static final class b implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread;
            synchronized (this) {
                thread = new Thread(runnable, "glide-disk-lru-cache-thread");
                thread.setPriority(1);
            }
            return thread;
        }

        public /* synthetic */ b(CallableC0155a callableC0155a) {
            this();
        }

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() throws IOException {
        while (this.h > this.f) {
            d(this.j.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() throws IOException {
        StringBuilder sb;
        synchronized (this) {
            Writer writer = this.i;
            if (writer != null) {
                a(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), com.huawei.hms.network.embedded.c.f5383a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.j.values()) {
                    if (dVar.f != null) {
                        sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(dVar.f5334a);
                    } else {
                        sb = new StringBuilder();
                        sb.append("CLEAN ");
                        sb.append(dVar.f5334a);
                        sb.append(dVar.a());
                    }
                    sb.append('\n');
                    bufferedWriter.write(sb.toString());
                }
                a(bufferedWriter);
                if (this.b.exists()) {
                    a(this.b, this.d, true);
                }
                a(this.c, this.b, false);
                this.d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), com.huawei.hms.network.embedded.c.f5383a));
            } catch (Throwable th) {
                a(bufferedWriter);
                throw th;
            }
        }
    }

    private void A() throws IOException {
        com.huawei.hms.network.embedded.b bVar = new com.huawei.hms.network.embedded.b(new FileInputStream(this.b), com.huawei.hms.network.embedded.c.f5383a);
        try {
            String strT = bVar.t();
            String strT2 = bVar.t();
            String strT3 = bVar.t();
            String strT4 = bVar.t();
            String strT5 = bVar.t();
            if (!"libcore.io.DiskLruCache".equals(strT) || !"1".equals(strT2) || !Integer.toString(this.e).equals(strT3) || !Integer.toString(this.g).equals(strT4) || !"".equals(strT5)) {
                throw new IOException("unexpected journal header: [" + strT + ", " + strT2 + ", " + strT4 + ", " + strT5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    e(bVar.t());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (bVar.s()) {
                        B();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), com.huawei.hms.network.embedded.c.f5383a));
                    }
                    com.huawei.hms.network.embedded.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.huawei.hms.network.embedded.c.a(bVar);
            throw th;
        }
    }

    public a(File file, int i, int i2, long j) {
        this.f5331a = file;
        this.e = i;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
    }
}
