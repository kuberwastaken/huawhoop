package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class gjj {

    @SerializedName("lang")
    private String c;

    @SerializedName("workoutPackageId")
    private String e;

    private gjj(d dVar) {
        this.c = dVar.e;
        this.e = dVar.d;
    }

    public static final class d {
        private String d;
        private String e;

        public d(String str) {
            this.d = str;
        }

        public d a(String str) {
            this.e = str;
            return this;
        }

        public gjj e() {
            return new gjj(this);
        }
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.e;
    }
}
