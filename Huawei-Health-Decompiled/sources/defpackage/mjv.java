package defpackage;

import com.huawei.hwidauth.api.Result;

/* JADX INFO: loaded from: classes.dex */
public class mjv implements Result {
    private mjs e;

    public mjv(mjs mjsVar) {
        this.e = mjsVar;
    }

    @Override // com.huawei.hwidauth.api.Result
    public mjs getStatus() {
        return this.e;
    }
}
