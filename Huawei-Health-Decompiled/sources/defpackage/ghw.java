package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ghw extends ShareDataInfo implements Serializable {
    private static final long serialVersionUID = -3011399402555708073L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("backgroundImage")
    private int f13464a;

    @SerializedName("thumbnailUrl")
    private String b;

    @SerializedName("sticker")
    private int c;

    @SerializedName("thumbnailSize")
    private int d;

    @SerializedName("dataWatermark")
    private int e;

    public int d() {
        return this.f13464a;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.c;
    }

    public String e() {
        return this.b;
    }

    public int a() {
        return this.d;
    }
}
