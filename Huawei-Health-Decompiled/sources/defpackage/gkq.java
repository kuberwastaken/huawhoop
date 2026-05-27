package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class gkq {
    private List<String> b;
    private String e;

    public String e() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public List<String> c() {
        return this.b;
    }

    public void a(List<String> list) {
        this.b = list;
    }

    public int hashCode() {
        String str = this.e;
        int iHashCode = str != null ? str.hashCode() : 0;
        List<String> list = this.b;
        return (iHashCode * 31) + (list != null ? list.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof gkq)) {
            return false;
        }
        gkq gkqVar = (gkq) obj;
        String str = this.e;
        return str != null && this.b != null && str.equals(gkqVar.e()) && this.b.equals(gkqVar.c());
    }
}
