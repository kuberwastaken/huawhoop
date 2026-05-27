package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated
public class wzi {
    public String c;
    public String d;
    public String e;

    public String d() throws wzb {
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.d)) {
            throw new wzb(2001L, "Get AppAuthtication signStr error");
        }
        return this.e + "." + this.d;
    }

    public String e() throws wzb {
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.c)) {
            throw new wzb(2001L, "get  AppAuthtication JWS is empty...");
        }
        return d() + "." + this.c;
    }
}
