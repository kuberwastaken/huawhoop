package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class lbd extends lbb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15055a;
    private String b;
    private List<lbf> c;
    private String d;
    private String e = null;

    public lbd(Map<String, String> map, List<lbf> list, String str) {
        e(map.get("issuerid"));
        d(map.get("appletId"));
        c(map.get("cplc"));
        a(map.get("transactionId"));
        b(map.get("commandId"));
        e(list);
        b(list.size());
        g(str);
    }

    public String b() {
        return this.e;
    }

    private void b(String str) {
        this.e = str;
    }

    public int e() {
        return this.f15055a;
    }

    private void b(int i) {
        this.f15055a = i;
    }

    public List<lbf> a() {
        return this.c;
    }

    private void e(List<lbf> list) {
        this.c = list;
    }

    public String d() {
        return this.d;
    }

    private void g(String str) {
        this.d = str;
    }

    public String c() {
        return this.b;
    }
}
