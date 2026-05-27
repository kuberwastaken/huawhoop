package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class rwf {

    @SerializedName("responseData")
    private a b;

    @SerializedName("responseDesc")
    private String c;

    @SerializedName("responseCode")
    private String e;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("languageCode")
        private String f17573a;

        @SerializedName("isChildren")
        private String b;

        @SerializedName("isSupport")
        private String d;

        @SerializedName("siteCode")
        private String e;

        @SerializedName("url")
        private String j;

        public a() {
        }

        public String a() {
            return this.d;
        }

        public String d() {
            return this.e;
        }

        public String b() {
            return this.f17573a;
        }

        public String e() {
            return this.j;
        }
    }

    public a b() {
        if (this.b == null) {
            this.b = new a();
        }
        return this.b;
    }
}
