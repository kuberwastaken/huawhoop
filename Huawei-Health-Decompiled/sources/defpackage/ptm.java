package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ptm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("description")
    private String f16871a;

    @SerializedName("permissions")
    private List<e> d;

    @SerializedName("title")
    private String e;

    public String a() {
        return this.e;
    }

    public List<e> d() {
        return this.d;
    }

    public String b() {
        return this.f16871a;
    }

    public String toString() {
        return "PermissionsNote{title='" + this.e + "', description='" + this.f16871a + "', permissions=" + this.d + '}';
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("description")
        private String f16872a;

        @SerializedName("name")
        private String d;

        public String a() {
            return this.d;
        }

        public String c() {
            return this.f16872a;
        }

        public String toString() {
            return "PermissionsBean{name='" + this.d + "', description='" + this.f16872a + "'}";
        }
    }
}
