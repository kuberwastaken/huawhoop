package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.group.constants.GroupActivityBo;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cmo extends CloudCommonReponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private int f672a;

    @SerializedName("groupActivityList")
    private List<GroupActivityBo> b;

    @SerializedName("currentTime")
    private String c;

    @SerializedName("pageNo")
    private int d;

    @SerializedName("totalCount")
    private int e;

    public List<GroupActivityBo> c() {
        return this.b;
    }
}
