package defpackage;

import com.huawei.hwidauth.api.Result;

/* JADX INFO: loaded from: classes6.dex */
public class mjl implements Result {
    private mjs c;

    public mjl(mjs mjsVar) {
        this.c = mjsVar;
    }

    @Override // com.huawei.hwidauth.api.Result
    public mjs getStatus() {
        return this.c;
    }

    public boolean e() {
        return this.c.b();
    }
}
