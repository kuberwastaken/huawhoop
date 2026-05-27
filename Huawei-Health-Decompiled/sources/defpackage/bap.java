package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class bap {
    private static final String d = "marketInstall" + File.separator + "download" + File.separator + "hiSpace.apk";

    public static String d(Context context) {
        return context.getFilesDir() + File.separator + d;
    }
}
