package com.huawei.watchface;

import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.watchface.utils.HwLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes8.dex */
public class eo {

    public interface b {
        boolean a(String str, byte[] bArr);

        void b();

        void c();
    }

    public static boolean a(byte[] bArr, b... bVarArr) throws IOException {
        for (b bVar : bVarArr) {
            bVar.b();
        }
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bArr));
        int i = 0;
        boolean z = false;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                if (!nextEntry.isDirectory()) {
                    String name = nextEntry.getName();
                    if (name != null && name.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
                        HwLog.e("ZipFileUtil", "unzip  fileName is Invalid");
                        break;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    a(zipInputStream, byteArrayOutputStream, 0);
                    i++;
                    if (i > 2048) {
                        HwLog.e("ZipFileUtil", "unzip  entries over than top size");
                        break;
                    }
                    boolean zA = true;
                    for (b bVar2 : bVarArr) {
                        zA &= bVar2.a(name, byteArrayOutputStream.toByteArray());
                    }
                    if (zA) {
                        HwLog.i("ZipFileUtil", "finish zip action earlier");
                        break;
                    }
                }
                z = true;
            } catch (Throwable th) {
                try {
                    zipInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        z = true;
        zipInputStream.close();
        for (b bVar3 : bVarArr) {
            bVar3.c();
        }
        return z;
    }

    public static abstract class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Set<String> f11518a;

        public d() {
            this.f11518a = new HashSet();
        }

        public d(String str) {
            this();
            this.f11518a.add(str);
        }
    }

    public static class c extends d {
        private Map<String, byte[]> b;

        @Override // com.huawei.watchface.eo.b
        public void c() {
        }

        public Map<String, byte[]> a() {
            return this.b;
        }

        public c(String str) {
            super(str);
        }

        @Override // com.huawei.watchface.eo.b
        public void b() {
            this.b = new HashMap();
        }

        @Override // com.huawei.watchface.eo.b
        public boolean a(String str, byte[] bArr) {
            if (this.f11518a.contains(str)) {
                this.b.put(str, bArr);
            }
            return this.b.size() >= this.f11518a.size();
        }
    }

    public static class a extends d {
        private byte[] b;
        private ByteArrayOutputStream c;
        private ZipOutputStream d;

        public a(String str) {
            super(str);
        }

        public byte[] a() {
            return this.b;
        }

        @Override // com.huawei.watchface.eo.b
        public void b() {
            this.c = new ByteArrayOutputStream();
            this.d = new ZipOutputStream(this.c);
        }

        @Override // com.huawei.watchface.eo.b
        public void c() {
            try {
                this.d.close();
            } catch (IOException unused) {
                HwLog.e("ZipFileUtil", "DeleteAction finish: ignore Exception");
            }
            this.b = this.c.toByteArray();
        }

        @Override // com.huawei.watchface.eo.b
        public boolean a(String str, byte[] bArr) {
            if (this.f11518a.contains(str)) {
                return false;
            }
            try {
                this.d.putNextEntry(new ZipEntry(str));
                this.d.write(bArr);
            } catch (IOException unused) {
                HwLog.e("ZipFileUtil", "DeleteAction accept: ignore Exception");
            }
            return false;
        }
    }

    private static void a(ZipInputStream zipInputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[5120];
        while (true) {
            int i2 = zipInputStream.read(bArr, 0, 5120);
            if (i2 <= 0) {
                return;
            }
            i += i2;
            if (i > 209715200) {
                HwLog.e("ZipFileUtil", "unzip  over than top size");
                return;
            }
            outputStream.write(bArr, 0, i2);
        }
    }
}
