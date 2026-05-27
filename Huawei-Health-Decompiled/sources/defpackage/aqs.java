package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class aqs {
    private static boolean a() {
        return true;
    }

    public static Context c(Context context) {
        return a() ? context.createDeviceProtectedStorageContext() : context;
    }
}
