package defpackage;

import com.huawei.hwidauth.api.Result;

/* JADX INFO: loaded from: classes.dex */
public class mjq implements Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15685a;
    private mjs c;

    public mjq(String str, mjs mjsVar) {
        this.f15685a = str;
        this.c = mjsVar;
    }

    public String e() {
        return this.f15685a;
    }

    @Override // com.huawei.hwidauth.api.Result
    public mjs getStatus() {
        return this.c;
    }

    public boolean d() {
        return this.c.b();
    }
}
