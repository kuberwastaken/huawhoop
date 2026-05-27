package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.ui.main.stories.recommendcloud.constants.RecommendConstants;

/* JADX INFO: loaded from: classes7.dex */
public class ohk extends ghx {
    private static final long serialVersionUID = 1;

    @SerializedName(RecommendConstants.DOWNLOAD_URL)
    private String b;

    @SerializedName("isDownload")
    private boolean d;

    @SerializedName("isLoading")
    private boolean e;

    public void a(boolean z) {
        this.d = z;
    }

    public String b() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public boolean c() {
        return this.e;
    }

    public void d(boolean z) {
        this.e = z;
    }
}
