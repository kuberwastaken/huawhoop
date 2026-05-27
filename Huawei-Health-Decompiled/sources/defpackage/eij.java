package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class eij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("cardType")
    private int f12608a;

    @SerializedName("cardId")
    private long c;

    @SerializedName("cardSize")
    private int d;

    public long b() {
        return this.c;
    }

    public void c(long j) {
        this.c = j;
    }

    public void a(int i) {
        this.f12608a = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public boolean e() {
        return this.f12608a == 1;
    }

    public String toString() {
        return "FaForm{mId=" + this.c + ", mType=" + this.f12608a + ", mCardSize=" + this.d + '}';
    }
}
