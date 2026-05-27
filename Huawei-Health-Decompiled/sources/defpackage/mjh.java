package defpackage;

import com.huawei.hwidauth.api.Result;

/* JADX INFO: loaded from: classes.dex */
public class mjh implements Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private mjs f15681a;
    private String c;

    public mjh(String str, mjs mjsVar) {
        this.c = str;
        this.f15681a = mjsVar;
    }

    @Override // com.huawei.hwidauth.api.Result
    public mjs getStatus() {
        return this.f15681a;
    }
}
