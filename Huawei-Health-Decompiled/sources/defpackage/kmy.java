package defpackage;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.db.bean.ContentResource;
import com.huawei.ui.main.stories.recommendcloud.constants.RecommendConstants;

/* JADX INFO: loaded from: classes11.dex */
public class kmy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("uploadUrl")
    private String f14765a;

    @SerializedName(ContentResource.FILE_NAME)
    private String b;

    @SerializedName("uploadMethod")
    private String c;

    @SerializedName("uploadHeaders")
    private JsonObject d;

    @SerializedName(RecommendConstants.FILE_ID)
    private String e;

    public String d() {
        return this.b;
    }

    public String e() {
        return this.e;
    }

    public String b() {
        return this.f14765a;
    }

    public String c() {
        return this.c;
    }

    public JsonObject a() {
        return this.d;
    }
}
