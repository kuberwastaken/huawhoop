package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes11.dex */
public class pcw {
    public static String b(String str) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 2);
        }
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf == -1 ? "" : str.substring(0, iLastIndexOf);
    }
}
