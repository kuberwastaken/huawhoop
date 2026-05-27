package defpackage;

import android.content.Context;
import com.alipay.sdk.m.c.b;

/* JADX INFO: loaded from: classes9.dex */
public class lb implements b {
    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zC = nc.c();
        lf.d("getOAID", "isSupported", Boolean.valueOf(zC));
        if (zC) {
            return nc.b(context);
        }
        return null;
    }
}
