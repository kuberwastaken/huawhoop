package defpackage;

import com.huawei.hwidauth.api.Result;

/* JADX INFO: loaded from: classes6.dex */
public class mjo implements Result {
    private mjs c;

    public mjo(mjs mjsVar) {
        this.c = mjsVar;
    }

    @Override // com.huawei.hwidauth.api.Result
    public mjs getStatus() {
        return this.c;
    }
}
