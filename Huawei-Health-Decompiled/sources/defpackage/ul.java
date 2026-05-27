package defpackage;

import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
class ul {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18356a;
    private boolean b;
    private final boolean c;
    private HashMap<String, String> d;
    private String e;

    ul(boolean z) {
        this.c = z;
    }

    ul e(String str) {
        this.e = str;
        return this;
    }

    ul c(String str) {
        this.f18356a = str.substring(0, Math.min(str.length(), 32));
        return this;
    }

    HashMap<String, String> c() {
        return this.d;
    }

    String a() {
        return this.e;
    }

    String e() {
        return this.f18356a;
    }

    public boolean b() {
        return this.c;
    }

    boolean d() {
        return this.b;
    }
}
