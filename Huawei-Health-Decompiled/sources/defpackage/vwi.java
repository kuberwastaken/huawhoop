package defpackage;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public final class vwi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f18815a = null;
    private static int b = 3;
    private static int c = 204800;
    private static String d = null;
    private static boolean e = false;
    private static BufferedWriter h = null;
    private static boolean i = false;

    public static void b(int i2, String str, int i3, boolean z) throws IOException {
        i = z;
        if (i2 > 0) {
            c = i2;
        }
        if (i3 > 0) {
            if (i3 > 50) {
                i3 = 50;
            }
            b = i3;
        }
        if (str != null) {
            f18815a = str;
            e = true;
        } else {
            e = false;
        }
        Log.i("LogWrite", "fileLoggerEnable: " + e);
        if (e) {
            File file = new File(f18815a);
            if (!file.exists() && !file.mkdirs()) {
                Log.e("LogWrite", "createFolder fail");
            } else {
                d(f18815a, e());
            }
        }
    }

    private static void d(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e("LogWrite", "createNewLogFile Exception");
            return;
        }
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length >= b) {
            try {
                Arrays.sort(fileArrListFiles, new e());
            } catch (IllegalArgumentException unused) {
                Log.e("LogWrite", "Arrays sort IllegalArgumentException");
            }
            d(fileArrListFiles);
        }
        synchronized (vwi.class) {
            BufferedWriter bufferedWriter = h;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException unused2) {
                    Log.e("LogWrite", "createNewLogFile close IOException");
                }
                try {
                    fileOutputStream = new FileOutputStream(new File(str, str2));
                } catch (Exception unused3) {
                    Log.e("LogWrite", "createNewLogFile IOException");
                }
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                    try {
                        h = new BufferedWriter(outputStreamWriter);
                        d = str2;
                        outputStreamWriter.close();
                        fileOutputStream.close();
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                fileOutputStream = new FileOutputStream(new File(str, str2));
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(fileOutputStream, "UTF-8");
                h = new BufferedWriter(outputStreamWriter2);
                d = str2;
                outputStreamWriter2.close();
                fileOutputStream.close();
            }
        }
    }

    private static boolean d(File[] fileArr) {
        if (fileArr == null || fileArr.length <= 0) {
            return false;
        }
        return fileArr[0].delete();
    }

    private static void a(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e("LogWrite", "openLogFile Exception");
            return;
        }
        synchronized (vwi.class) {
            BufferedWriter bufferedWriter = h;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException unused) {
                    Log.e("LogWrite", "createNewLogFile close IOException");
                }
                try {
                    fileOutputStream = new FileOutputStream(new File(str, str2), true);
                    try {
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                        try {
                            h = new BufferedWriter(outputStreamWriter);
                            d = str2;
                            outputStreamWriter.close();
                            fileOutputStream.close();
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    Log.e("LogWrite", "openLogFile  Exception");
                }
            } else {
                fileOutputStream = new FileOutputStream(new File(str, str2), true);
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(fileOutputStream, "UTF-8");
                h = new BufferedWriter(outputStreamWriter2);
                d = str2;
                outputStreamWriter2.close();
                fileOutputStream.close();
            }
        }
    }

    private static String e() {
        String str = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(Calendar.getInstance().getTime());
        return Process.myPid() + "_" + str + ".log";
    }

    public static void a() {
        synchronized (vwi.class) {
            BufferedWriter bufferedWriter = h;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException unused) {
                    Log.e("LogWrite", "shutdown IOException");
                }
                h = null;
            } else {
                h = null;
            }
        }
    }

    public static void a(String str, String str2, String str3, Throwable th) {
        synchronized (vwi.class) {
            try {
                try {
                } catch (IOException unused) {
                    Log.e("LogWrite", "wtf IOException");
                }
                if (!TextUtils.isEmpty(f18815a) && !TextUtils.isEmpty(d)) {
                    if (new File(f18815a, d).length() > c) {
                        d(f18815a, e());
                    } else if (h == null) {
                        a(f18815a, d);
                    }
                    h.append((CharSequence) String.format(Locale.ENGLISH, "%s: %s/%s: %s", c(), str, str2, str3 + '\n' + Log.getStackTraceString(th)));
                    h.flush();
                    return;
                }
                Log.e("LogWrite", "wtf Exception");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static String c() {
        return new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    static class e implements Comparator<File>, Serializable {
        private static final long serialVersionUID = 1;

        private e() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }
}
