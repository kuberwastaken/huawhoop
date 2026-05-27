package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.db.bean.ContentResource;
import com.huawei.ui.main.stories.recommendcloud.constants.RecommendConstants;
import com.huawei.watchface.utils.constants.WatchFaceConstant;

/* JADX INFO: loaded from: classes7.dex */
public class oha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(RecommendConstants.DOWNLOAD_URL)
    private String f16369a;

    @SerializedName("algorithmName")
    private String b;

    @SerializedName("fileType")
    private String c;

    @SerializedName(WatchFaceConstant.HASHCODE)
    private String d;

    @SerializedName(ContentResource.FILE_NAME)
    private String e;

    @SerializedName("size")
    private String i;

    public String a() {
        return this.f16369a;
    }

    public String c() {
        return this.i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(255);
        stringBuffer.append("BriefFileInfo{fileName=");
        stringBuffer.append(this.e);
        stringBuffer.append(", fileType=").append(this.c);
        stringBuffer.append(", size=").append(this.i);
        stringBuffer.append(", algorithmName=").append(this.b);
        stringBuffer.append(", hashCode=").append(this.d);
        stringBuffer.append(", downloadUrl=").append(this.f16369a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
