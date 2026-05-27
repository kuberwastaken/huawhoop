package defpackage;

import com.huawei.hwidauth.api.Result;

/* JADX INFO: loaded from: classes.dex */
public class mjr implements Result {
    private mjs b;

    public mjr(mjs mjsVar) {
        this.b = mjsVar;
    }

    @Override // com.huawei.hwidauth.api.Result
    public mjs getStatus() {
        return this.b;
    }
}
