package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class nok extends nof {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16067a;
    private String b;
    private Map<String, Object> c;
    private String d;
    private int e;
    private int g;

    public nok() {
        super(13);
    }

    public String e() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public int a() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int b() {
        return this.g;
    }

    public void e(int i) {
        this.g = i;
    }

    public void d(String str) {
        this.f16067a = str;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public Map<String, Object> d() {
        return this.c;
    }

    public void b(Map<String, Object> map) {
        this.c = map;
    }

    public String toString() {
        return "KakaUpdateReturnBody{rewardKaka=" + this.e + ", totalKaka=" + this.g + ", resultDes='" + this.f16067a + "', results=" + this.c + '}';
    }
}
