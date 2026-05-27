package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginfitnessadvice.course.EssenceVideoInfo;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class nzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("resultCode")
    private int f16242a;

    @SerializedName("resultDesc")
    private String c;

    @SerializedName("essenceVideos")
    private List<EssenceVideoInfo> d;

    @SerializedName("totalCount")
    private int e;

    public String toString() {
        return "EssenceVideoResourceRsp{resultCode=" + this.f16242a + ", resultDesc='" + this.c + "', totalCount=" + this.e + ", essenceVideos=" + this.d + '}';
    }
}
