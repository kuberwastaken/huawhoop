package defpackage;

import com.huawei.hwidauth.api.Result;

/* JADX INFO: loaded from: classes11.dex */
public class mjn implements Result {
    private mjs b;

    public mjn(mjs mjsVar) {
        this.b = mjsVar;
    }

    @Override // com.huawei.hwidauth.api.Result
    public mjs getStatus() {
        return this.b;
    }
}
