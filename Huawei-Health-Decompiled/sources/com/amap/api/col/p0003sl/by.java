package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class by {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f865a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f867a = false;
    }

    public interface c {
        void a();

        void a(long j);
    }

    public by(bv bvVar, bu buVar) {
        this.f865a = new b(bvVar, buVar);
    }

    public final void a() {
        b bVar = this.f865a;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void b() {
        b bVar = this.f865a;
        if (bVar != null) {
            a(bVar);
        }
    }

    private static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        final bu buVarD = bVar.d();
        if (buVarD != null) {
            buVarD.p();
        }
        String strA = bVar.a();
        String strB = bVar.b();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB)) {
            if (bVar.e().f867a) {
                if (buVarD != null) {
                    buVarD.r();
                    return;
                }
                return;
            } else {
                if (buVarD != null) {
                    buVarD.q();
                    return;
                }
                return;
            }
        }
        File file = new File(strA);
        if (!file.exists()) {
            if (bVar.e().f867a) {
                if (buVarD != null) {
                    buVarD.r();
                    return;
                }
                return;
            } else {
                if (buVarD != null) {
                    buVarD.q();
                    return;
                }
                return;
            }
        }
        File file2 = new File(strB);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        c cVar = new c() { // from class: com.amap.api.col.3sl.by.1
            @Override // com.amap.api.col.3sl.by.c
            public final void a(long j) {
                try {
                    bu buVar = buVarD;
                    if (buVar != null) {
                        buVar.a(j);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.amap.api.col.3sl.by.c
            public final void a() {
                bu buVar = buVarD;
                if (buVar != null) {
                    buVar.q();
                }
            }
        };
        try {
            if (bVar.e().f867a && buVarD != null) {
                buVarD.r();
            }
            a(file, file2, cVar, bVar);
            if (bVar.e().f867a) {
                if (buVarD != null) {
                    buVarD.r();
                }
            } else if (buVarD != null) {
                buVarD.b(bVar.c());
            }
        } catch (Throwable unused) {
            if (bVar.e().f867a) {
                if (buVarD != null) {
                    buVarD.r();
                }
            } else if (buVarD != null) {
                buVarD.q();
            }
        }
    }

    private static void a(File file, File file2, c cVar, b bVar) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        a aVarE = bVar.e();
        long size = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
            ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (aVarE != null && aVarE.f867a) {
                        zipInputStream.closeEntry();
                        zipInputStream.close();
                        checkedInputStream.close();
                        fileInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if (!a(nextEntry.getName())) {
                            cVar.a();
                            break;
                        }
                        stringBuffer.append(nextEntry.getName()).append(";");
                    }
                    size += nextEntry.getSize();
                    zipInputStream.closeEntry();
                } else {
                    break;
                }
            }
            bVar.a(stringBuffer.toString());
            zipInputStream.close();
            checkedInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        a(file2, zipInputStream2, size, cVar, aVarE);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static void a(File file, ZipInputStream zipInputStream, long j, c cVar, a aVar) throws Exception {
        int iA = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (aVar != null && aVar.f867a) {
                zipInputStream.closeEntry();
                return;
            }
            String str = file.getPath() + File.separator + nextEntry.getName();
            if (!a(nextEntry.getName())) {
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            } else {
                File file2 = new File(str);
                a(file2);
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    iA += a(file2, zipInputStream, iA, j, cVar, aVar);
                }
                zipInputStream.closeEntry();
            }
        }
    }

    private static boolean a(String str) {
        return (str.contains("..") || str.contains("/") || str.contains("\\") || str.contains("%")) ? false : true;
    }

    private static int a(File file, ZipInputStream zipInputStream, long j, long j2, c cVar, a aVar) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int i2 = zipInputStream.read(bArr, 0, 1024);
            if (i2 != -1) {
                if (aVar != null && aVar.f867a) {
                    bufferedOutputStream.close();
                    return i;
                }
                bufferedOutputStream.write(bArr, 0, i2);
                i += i2;
                if (j2 > 0 && cVar != null) {
                    long j3 = ((((long) i) + j) * 100) / j2;
                    if (aVar == null || !aVar.f867a) {
                        cVar.a(j3);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i;
            }
        }
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        a(parentFile);
        parentFile.mkdir();
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f868a;
        private String b;
        private bu c;
        private a d = new a();
        private String e;

        public b(bv bvVar, bu buVar) {
            this.c = null;
            this.f868a = bvVar.x();
            this.b = bvVar.y();
            this.c = buVar;
        }

        public final void a(String str) {
            if (str.length() > 1) {
                this.e = str;
            }
        }

        public final String a() {
            return this.f868a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.e;
        }

        public final bu d() {
            return this.c;
        }

        public final a e() {
            return this.d;
        }

        public final void f() {
            this.d.f867a = true;
        }
    }
}
