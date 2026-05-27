package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.ui.main.stories.recommendcloud.constants.RecommendConstants;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class epd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("country")
    private String f12709a;

    @SerializedName("featureList")
    private List<eoy> b;

    @SerializedName(RecommendConstants.VER)
    private int c;

    @SerializedName("name")
    protected String d;

    public List<eoy> d() {
        return this.b;
    }

    public int c() {
        return this.c;
    }
}
