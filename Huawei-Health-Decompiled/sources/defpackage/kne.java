package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class kne {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("VideoPath")
    private String f14769a;

    @SerializedName("ImagePath")
    private String b;

    @SerializedName("VideoId")
    private String c;

    @SerializedName("ImageId")
    private String d;

    public kne(b bVar) {
        this.b = bVar.b;
        this.f14769a = bVar.f14770a;
        this.d = bVar.d;
        this.c = bVar.c;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f14770a;
        private String b;
        private String c;
        private String d;

        public b a(String str) {
            this.b = str;
            return this;
        }

        public b b(String str) {
            this.f14770a = str;
            return this;
        }

        public b c(String str) {
            this.d = str;
            return this;
        }

        public b d(String str) {
            this.c = str;
            return this;
        }

        public kne c() {
            return new kne(this);
        }
    }
}
