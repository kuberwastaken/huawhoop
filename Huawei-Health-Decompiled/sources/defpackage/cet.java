package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class cet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("matcher")
    private String f617a;

    @SerializedName("type")
    private int c;

    protected cet(a aVar) {
        this.c = aVar.f618a;
        this.f617a = aVar.c;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f618a = 0;
        private String c;

        public a a(int i) {
            this.f618a = i;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public cet e() {
            return new cet(this);
        }
    }

    public int a() {
        return this.c;
    }

    public String d() {
        return this.f617a;
    }
}
