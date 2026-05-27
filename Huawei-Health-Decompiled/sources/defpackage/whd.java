package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.secure.android.common.intent.IntentUtils;

/* JADX INFO: loaded from: classes11.dex */
public class whd {
    public static void fxE_(Context context, Intent intent) {
        fxF_(context, intent, null, null);
    }

    public static void fxF_(Context context, Intent intent, Bundle bundle, String str) {
        if (context == null) {
            vwc.a("CommonBase:SafeStartActivityUtil", "startActivity context ==  null .", false);
            return;
        }
        if (intent == null) {
            vwc.a("CommonBase:SafeStartActivityUtil", "startActivity intent ==  null .", false);
            return;
        }
        intent.addFlags(268435456);
        if (IntentUtils.safeStartActivity(context, intent, bundle)) {
            return;
        }
        vwc.a("CommonBase:SafeStartActivityUtil", "safeStartActivityForResultStatic fail", false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        vwc.a("CommonBase:SafeStartActivityUtil", "startActivity err tag:" + str, false);
    }

    public static void fxC_(Activity activity, Intent intent) {
        fxD_(activity, intent, null, null);
    }

    public static void fxD_(Activity activity, Intent intent, Bundle bundle, String str) {
        if (activity == null) {
            vwc.a("CommonBase:SafeStartActivityUtil", "startActivity activity ==  null .", false);
            return;
        }
        if (intent == null) {
            vwc.a("CommonBase:SafeStartActivityUtil", "startActivity intent ==  null .", false);
            return;
        }
        if (IntentUtils.safeStartActivity(activity, intent, bundle)) {
            return;
        }
        vwc.a("CommonBase:SafeStartActivityUtil", "safeStartActivityForResultStatic fail", false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        vwc.a("CommonBase:SafeStartActivityUtil", "startActivity err tag:" + str, false);
    }
}
