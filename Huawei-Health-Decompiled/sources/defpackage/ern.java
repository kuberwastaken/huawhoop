package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.h5pro.jsmodules.complaint.ComplaintConstants;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ern {

    @SerializedName("courseList")
    private List<erm> mCourseInfoList;

    @SerializedName(ComplaintConstants.GROUP_NAME_PARAM_KEY)
    private String mGroupName;

    public String getGroupName() {
        return this.mGroupName;
    }

    public List<erm> getCourseInfoList() {
        return this.mCourseInfoList;
    }
}
