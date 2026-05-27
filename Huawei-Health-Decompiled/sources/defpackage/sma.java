package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.utils.Constants;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes11.dex */
public class sma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("audioUrl")
    private String f17748a;

    @SerializedName("audioType")
    private int b;

    @SerializedName("backGroundImg")
    private String c;

    @SerializedName("detailJumpUrl")
    private String d;

    @SerializedName("heatCount")
    private int e;

    @SerializedName("id")
    private int f;

    @SerializedName("imgIcon")
    private String g;

    @SerializedName("labelType")
    private int h;

    @SerializedName(ParsedFieldTag.TASK_MODIFY_TIME)
    private long i;

    @SerializedName("infoType")
    private String j;

    @SerializedName("shareIcon")
    private String k;

    @SerializedName(Constants.SHARE_TITLE)
    private String l;

    @SerializedName("name")
    private String m;

    @SerializedName("shareDescription")
    private String n;

    @SerializedName("status")
    private int o;

    @SerializedName("weight")
    private int p;

    @SerializedName("isVip")
    private int s;

    public String d() {
        return this.d;
    }

    public int a() {
        return this.e;
    }

    public String c() {
        return this.g;
    }

    public int j() {
        return this.h;
    }

    public String i() {
        return this.m;
    }

    public int g() {
        return this.s;
    }

    public String b() {
        return this.j;
    }

    public int e() {
        return this.f;
    }

    public String toString() {
        return "SleepAudiosModel{mAudioType=" + this.b + ", mAudioUrl='" + this.f17748a + "', mBackGroundImg='" + this.c + "', mHeatCount=" + this.e + ", mId=" + this.f + ", mImgIcon='" + this.g + "', mLabelType=" + this.h + ", mModifyTime=" + this.i + ", mName='" + this.m + "', mShareDescription='" + this.n + "', mShareIcon='" + this.k + "', mShareTitle='" + this.l + "', mStatus=" + this.o + ", mWeight=" + this.p + ", mDetailJumpUrl='" + this.d + "', mInfoType='" + this.j + "'}";
    }
}
