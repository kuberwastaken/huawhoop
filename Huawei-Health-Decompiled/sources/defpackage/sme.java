package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class sme {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("moreFavoritesUrl")
    private String f17751a;

    @SerializedName("pageNo")
    private int b;

    @SerializedName("resultCode")
    private int c;

    @SerializedName("priority")
    private int d;

    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private int e;

    @SerializedName("resultDesc")
    private String g;

    @SerializedName("totalCount")
    private int h;

    @SerializedName("sleepAudios")
    private List<sma> i;

    public int e() {
        return this.d;
    }

    public String d() {
        return this.f17751a;
    }

    public int c() {
        return this.c;
    }

    public List<sma> b() {
        return this.i;
    }

    public String toString() {
        return "SleepFavoritesModel{mPageSize=" + this.e + ", mPageNo=" + this.b + ", mResultCode=" + this.c + ", mResultDesc='" + this.g + "', mTotalCount=" + this.h + ", mSleepAudios=" + this.i + ", mMoreFavoritesUrl='" + this.f17751a + "'}";
    }
}
