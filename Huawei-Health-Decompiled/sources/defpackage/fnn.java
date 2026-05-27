package defpackage;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class fnn implements Serializable {

    @SerializedName("start")
    private int b;

    @SerializedName(TtmlNode.END)
    private int d;

    public int a() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public String toString() {
        return "CpRelation{start='" + this.b + ", end=" + this.d + '}';
    }
}
