package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes6.dex */
public final class nng {
    public static void cmr_(Context context, Intent intent) {
        if (context == null || intent == null) {
            nni.b("ActivityUtils", "startActivity params is null");
            return;
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            nni.c("ActivityUtils", "startActivity Exception: ", e);
        }
    }

    public static void cms_(Activity activity, Intent intent, int i) {
        if (activity == null || intent == null) {
            nni.b("ActivityUtils", "startActivityForResult params is null");
            return;
        }
        try {
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException e) {
            nni.c("ActivityUtils", "startActivityForResult Exception: ", e);
        }
    }
}
