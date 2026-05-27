package defpackage;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("notifyTime")
    private long f16287a;

    @SerializedName("memberHuid")
    private long b;

    @SerializedName(TtmlNode.TAG_INFORMATION)
    private String c;

    @SerializedName("huid")
    private long d;

    @SerializedName("pushType")
    private int e;

    public int e() {
        return this.e;
    }

    public long a() {
        return this.b;
    }

    public String d() {
        return this.c;
    }
}
