package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class htn implements Serializable {
    private static final long serialVersionUID = 6945617213218402229L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("phoneNumber")
    private String f13967a;

    @SerializedName("contactVersion")
    private String b;

    @SerializedName("name")
    private String c;

    @SerializedName("uri")
    private String d;

    @SerializedName("fromSystem")
    private boolean e = true;

    public String a() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String d() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public boolean c() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public String e() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String b() {
        return this.f13967a;
    }

    public void a(String str) {
        this.f13967a = str;
    }

    public String toString() {
        return "ContactInfo{uri='" + this.d + "', contactVersion='" + this.b + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        htn htnVar = (htn) obj;
        return this.b.equals(htnVar.b) && Objects.equals(this.d, htnVar.d);
    }

    public int hashCode() {
        return Objects.hash(this.d, this.b);
    }
}
