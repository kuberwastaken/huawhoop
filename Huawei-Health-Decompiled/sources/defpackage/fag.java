package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class fag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f12870a;
    private String c;
    private String d;
    private String e;

    public fag(String str, String str2) {
        this.c = str;
        this.e = str2;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.e;
    }

    public Map<String, Object> d() {
        return this.f12870a;
    }

    public void a(Map<String, Object> map) {
        this.f12870a = map;
    }

    public String c() {
        return this.d;
    }

    public void e(String str) {
        this.d = str;
    }
}
