package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class ize {
    public static String b(String str) {
        return c("common", str);
    }

    private static String c(String str, String str2) {
        return iin.e("3dMarker") + str + File.separator + str2;
    }

    public static String e(String str) {
        return iin.e("3dMarker") + "numbers" + File.separator + "number_" + str + ".gltf";
    }
}
