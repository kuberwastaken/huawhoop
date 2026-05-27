package defpackage;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class ixn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14353a;
    private String d;
    private String e;

    public ixn(String str, String str2, String str3) {
        this.e = str;
        this.d = str2;
        this.f14353a = str3;
    }

    public String d() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public String e() {
        return this.f14353a;
    }

    public int hashCode() {
        return Objects.hash(this.e, this.d, this.f14353a);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ixn)) {
            return false;
        }
        ixn ixnVar = (ixn) obj;
        String str = this.d;
        return str != null && this.e != null && this.f14353a != null && str.equals(ixnVar.d()) && this.e.equals(ixnVar.b()) && this.f14353a.equals(ixnVar.e());
    }
}
