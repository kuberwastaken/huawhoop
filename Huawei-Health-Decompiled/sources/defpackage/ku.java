package defpackage;

import android.content.Context;
import com.alipay.sdk.m.c.b;

/* JADX INFO: loaded from: classes9.dex */
public class ku implements b {
    public com.alipay.sdk.m.u0.b b;
    public boolean d = false;
    public boolean c = false;

    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.d) {
            com.alipay.sdk.m.u0.b bVar = new com.alipay.sdk.m.u0.b();
            this.b = bVar;
            this.c = bVar.b(context, null) == 1;
            this.d = true;
        }
        lf.d("getOAID", "isSupported", Boolean.valueOf(this.c));
        if (this.c && this.b.d()) {
            return this.b.c();
        }
        return null;
    }
}
