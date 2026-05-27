package defpackage;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
public class pw {
    public static Context c = null;
    private static boolean d = true;

    public static class d {
        public static void c(String str, String str2) {
            Log.w(str, str2);
        }

        public static void b(String str, String str2) {
            Log.i(str, str2);
        }

        public static void d(String str, String str2) {
            Log.e(str, str2);
        }

        public static void a(String str, String str2) {
            if (pw.d) {
                Log.d(str, str2);
            }
        }
    }

    public static boolean e() {
        return d;
    }

    public static void c(String str, String str2) throws Throwable {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream;
        if (d) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    Context context = c;
                    if (context != null && context.getCacheDir() != null) {
                        File file = new File(c.getCacheDir().getAbsolutePath() + "/" + str);
                        StringBuilder sb = new StringBuilder("writeFile file path:");
                        sb.append(file.getAbsolutePath());
                        d.a("Util", sb.toString());
                        if (file.exists()) {
                            file.delete();
                        }
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(str2.getBytes());
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream2 = fileOutputStream;
                            d.d("Util", e.toString());
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e4) {
                e = e4;
            }
            try {
                fileOutputStream2.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static String a(File file) throws Throwable {
        BufferedReader bufferedReader;
        if (file == null || !file.exists()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        } catch (Exception e) {
                            e = e;
                            bufferedReader2 = bufferedReader;
                            e.printStackTrace();
                            bufferedReader2.close();
                        } catch (Throwable th) {
                            th = th;
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    }
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return sb.toString();
    }
}
