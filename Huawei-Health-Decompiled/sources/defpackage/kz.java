package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes9.dex */
public class kz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kz f15013a = new kz();

    public String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return "0.0.0";
        }
    }

    public static kz a() {
        return f15013a;
    }
}
