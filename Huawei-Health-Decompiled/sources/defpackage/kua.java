package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class kua {

    @SerializedName("data")
    private e b;

    @SerializedName("code")
    private int c;

    @SerializedName("message")
    private String d;

    @SerializedName("success")
    private boolean e;

    public int b() {
        return this.c;
    }

    public e c() {
        return this.b;
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("deviceNo")
        private String f14909a;

        @SerializedName("deviceSecret")
        private String c;

        @SerializedName("productId")
        private String d;

        @SerializedName("deviceId")
        private String e;

        public String d() {
            return this.e;
        }

        public String c() {
            return this.f14909a;
        }

        public String e() {
            return this.d;
        }

        public String a() {
            return this.c;
        }
    }
}
