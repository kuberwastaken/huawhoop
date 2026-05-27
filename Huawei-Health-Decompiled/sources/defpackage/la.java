package defpackage;

import android.content.Context;
import com.alipay.sdk.m.c.b;

/* JADX INFO: loaded from: classes9.dex */
public class la implements b {
    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zD = oh.d(context);
        lf.d("getOAID", "isSupported", Boolean.valueOf(zD));
        if (zD) {
            return oh.e(context);
        }
        return null;
    }
}
