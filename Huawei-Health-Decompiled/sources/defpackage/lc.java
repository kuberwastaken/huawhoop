package defpackage;

import android.content.Context;
import com.alipay.sdk.m.c.b;

/* JADX INFO: loaded from: classes9.dex */
public class lc implements b {
    public boolean c = false;

    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.c) {
            ms.d(context);
            this.c = true;
        }
        boolean zE = ms.e();
        lf.d("getOAID", "isSupported", Boolean.valueOf(zE));
        if (zE) {
            return ms.e(context);
        }
        return null;
    }
}
