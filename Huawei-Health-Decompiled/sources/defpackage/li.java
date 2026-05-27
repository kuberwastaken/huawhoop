package defpackage;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public class li {
    public static boolean d() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState == null || externalStorageState.length() <= 0) {
            return false;
        }
        return (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) && Environment.getExternalStorageDirectory() != null;
    }

    public static void b(String str, String str2) {
        try {
            if (d()) {
                File file = new File(Environment.getExternalStorageDirectory(), str);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String c(String str) {
        try {
            if (!d()) {
                return null;
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), str);
            if (!file.exists()) {
                return null;
            }
            file.delete();
            return "";
        } catch (Exception unused) {
            return null;
        }
    }
}
