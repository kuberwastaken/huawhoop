package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lay {
    private String b;
    private int e = 0;
    private int d = 0;

    public String b() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public int c() {
        return this.e;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof lay)) {
            return false;
        }
        lay layVar = (lay) obj;
        if (layVar.e == this.e && this.d == layVar.d && (str = this.b) != null) {
            return str.equals(layVar.b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.b;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.e) * 31) + this.d;
    }
}
