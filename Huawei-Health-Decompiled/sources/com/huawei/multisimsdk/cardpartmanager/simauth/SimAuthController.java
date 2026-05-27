package com.huawei.multisimsdk.cardpartmanager.simauth;

import android.content.Context;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes6.dex */
public class SimAuthController {
    private Context c;
    private final TelephonyManager d;
    private final SubscriptionManager e;

    public String d(String str) {
        return str;
    }

    public SimAuthController(Context context) {
        this.c = context;
        this.d = (TelephonyManager) context.getSystemService("phone");
        this.e = SubscriptionManager.from(this.c);
    }

    public String e() {
        String strSubstring;
        String strSubstring2;
        String subscriberId = this.d.getSubscriberId();
        if (subscriberId != null) {
            strSubstring = subscriberId.substring(0, 3);
            strSubstring2 = subscriberId.substring(3, 5);
        } else {
            strSubstring = null;
            strSubstring2 = null;
        }
        return "0" + subscriberId + "@nai.epc.mnc0" + strSubstring2 + ".mcc" + strSubstring + ".3gppnetwork.org";
    }
}
