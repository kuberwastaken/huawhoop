package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class tyh {

    @SerializedName("mImageUrl")
    private String c;

    @SerializedName("mHuid")
    private long d;

    public void b(long j) {
        this.d = j;
    }

    public long e() {
        return this.d;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.c;
    }
}
