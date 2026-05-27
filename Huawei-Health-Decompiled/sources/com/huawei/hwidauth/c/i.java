package com.huawei.hwidauth.c;

import android.content.Context;
import defpackage.mli;
import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
public class i extends k {
    private Context e;

    public i(Context context) {
        this.e = context;
    }

    @Override // com.huawei.hwidauth.c.k
    public String b() {
        return "/oauth2/v3/x509?client_id=104589299&hms_version=" + mli.e(this.e) + "&sdkVersion=6.12.0.303";
    }

    @Override // com.huawei.hwidauth.c.k
    public String c() {
        return "";
    }

    @Override // com.huawei.hwidauth.c.k
    public String a_() {
        return "";
    }

    @Override // com.huawei.hwidauth.c.k
    public String a() throws IllegalStateException, IOException, IllegalArgumentException {
        return "";
    }
}
