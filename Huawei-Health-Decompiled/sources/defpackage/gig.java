package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class gig extends ShareDataInfo implements Serializable {
    private static final long serialVersionUID = 216593960253233605L;

    @SerializedName("thumbnailUrl")
    private String b;

    @SerializedName("thumbnailPath")
    private String d;

    @SerializedName("thumbnailSize")
    private int e;

    public String c() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public int a() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public String d() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }
}
