package defpackage;

import com.huawei.hwidauth.api.Result;

/* JADX INFO: loaded from: classes.dex */
public final class mjs implements Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15686a;
    private boolean b;
    private int c;
    private int e;

    @Override // com.huawei.hwidauth.api.Result
    public mjs getStatus() {
        return null;
    }

    public mjs(int i, String str) {
        this.c = i;
        this.f15686a = str;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void d(int i) {
        this.e = i;
    }

    public String d() {
        return this.f15686a;
    }
}
