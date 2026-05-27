package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ewo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("deliver")
    private int f12806a;

    @SerializedName("labelThresholdValue")
    private List<e> c;

    @SerializedName("chooseNum")
    private int e;

    public List<e> d() {
        return this.c;
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("thresholdValue")
        private String f12807a;

        @SerializedName("technologyCaliber")
        private String c;

        @SerializedName("displayName")
        private String d;

        @SerializedName("description")
        private String e;

        public String a() {
            return this.f12807a;
        }

        public String e() {
            return this.c;
        }
    }
}
