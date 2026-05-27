package defpackage;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import lib.android.paypal.com.magnessdk.g;
import lib.android.paypal.com.magnessdk.log.a;

/* JADX INFO: loaded from: classes11.dex */
public final class xuw {
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x003f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:22:0x003f */
    public static String a(File file) throws Throwable {
        BufferedReader bufferedReader;
        Closeable closeable;
        StringBuilder sb = new StringBuilder();
        Closeable closeable2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (IOException e) {
                        e = e;
                        sb.append(g.d);
                        a.d(xuw.class, 3, e);
                    }
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                xuv.d(xuw.class, closeable2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            xuv.d(xuw.class, closeable2);
            throw th;
        }
        xuv.d(xuw.class, bufferedReader);
        if (sb.toString().isEmpty()) {
            return null;
        }
        return sb.toString();
    }

    public static String c(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(bArr);
            String str = new String(bArr, "UTF-8");
            xuv.d(xuw.class, randomAccessFile);
            return str;
        } catch (Exception e2) {
            e = e2;
            randomAccessFile2 = randomAccessFile;
            a.d(xuw.class, 3, e);
            xuv.d(xuw.class, randomAccessFile2);
            return "";
        } catch (Throwable th2) {
            th = th2;
            xuv.d(xuw.class, randomAccessFile);
            throw th;
        }
    }

    public static boolean d(String[] strArr, String str) {
        if (strArr != null && str != null) {
            boolean zIsEmpty = str.isEmpty();
            for (String str2 : strArr) {
                if ((zIsEmpty ^ true ? new File(str2, str) : new File(str2)).exists()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
            fileOutputStream = fileOutputStream2;
        }
        try {
            fileOutputStream.write(str.getBytes("UTF-8"));
            xuv.d(xuw.class, fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            a.d(xuw.class, 3, e);
            xuv.d(xuw.class, fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            xuv.d(xuw.class, fileOutputStream);
            throw th;
        }
    }

    public static boolean b(File file) {
        try {
            if (file.exists()) {
                a.c(xuw.class, 0, "deleting CachedConfigDataFromDisk");
                return file.delete();
            }
        } catch (Exception e) {
            a.d(xuw.class, 3, e);
        }
        return false;
    }

    private xuw() {
    }
}
