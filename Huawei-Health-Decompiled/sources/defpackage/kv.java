package defpackage;

import android.content.Context;
import com.alipay.sdk.m.c.b;

/* JADX INFO: loaded from: classes9.dex */
public class kv implements b {
    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zB = mu.b();
        lf.d("getOAID", "isSupported", Boolean.valueOf(zB));
        if (zB) {
            return mu.a(context);
        }
        return null;
    }
}
