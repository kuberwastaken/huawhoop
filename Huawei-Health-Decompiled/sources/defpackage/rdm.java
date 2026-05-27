package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class rdm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("hasMore")
    private boolean f17302a;

    @SerializedName("audioWorkoutList")
    private List<rdj> b;

    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private int c;

    @SerializedName("resultCode")
    private String d;

    @SerializedName("recommendMore")
    private List<rdu> e;

    @SerializedName("subTitle")
    private String f;

    @SerializedName("topicBackImgUrl")
    private String g;

    @SerializedName("topicDesc")
    private String h;

    @SerializedName("topicBackLargeImgUrl")
    private String i;

    @SerializedName("resultDesc")
    private String j;

    @SerializedName("topicName")
    private String n;

    @SerializedName("total")
    private int o;

    public String d() {
        return this.n;
    }

    public String a() {
        return this.d;
    }

    public String e() {
        return this.j;
    }

    public int c() {
        return this.o;
    }

    public List<rdj> b() {
        return this.b;
    }

    public String toString() {
        return "AudioWorkoutByTopicIdRsp{resultCode='" + this.d + "', resultDesc='" + this.j + "', total=" + this.o + ", pageSize=" + this.c + ", hasMore=" + this.f17302a + ", topicName=" + this.n + ", topicDesc=" + this.h + ", subTitle=" + this.f + ", topicBackImgUrl=" + this.g + ", topicBackLargeImgUrl=" + this.i + ", audioWorkoutList=" + this.b + ", recommendMore=" + this.e + '}';
    }
}
