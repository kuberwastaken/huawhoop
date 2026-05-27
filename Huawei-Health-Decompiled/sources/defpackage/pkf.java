package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.ui.main.stories.recommendcloud.constants.RecommendConstants;
import com.tencent.open.SocialOperation;

/* JADX INFO: loaded from: classes7.dex */
public class pkf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(SocialOperation.GAME_SIGNATURE)
    private String f16744a;

    @SerializedName(RecommendConstants.VER)
    private String b;

    @SerializedName(RecommendConstants.FILE_ID)
    private String d;

    @SerializedName(RecommendConstants.DOWNLOAD_URL)
    private String e;

    public String b() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public String c() {
        return this.d;
    }
}
