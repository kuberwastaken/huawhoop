package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class pkq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("configs")
    private List<b> f16748a;

    @SerializedName("name")
    private String b;

    @SerializedName("versions")
    private List<String> e;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("platforms")
        private List<Integer> f16749a;

        @SerializedName("configName")
        private String b;

        @SerializedName("scopes")
        private List<Integer> d;

        @SerializedName("periods")
        private List<e> e;
    }

    public static class e {

        @SerializedName("startTime")
        private String c;

        @SerializedName("endTime")
        private String e;
    }

    public String toString() {
        return "GrayingBasicConfig{name='" + this.b + "', versionList=" + this.e + ", configs=" + this.f16748a + '}';
    }
}
