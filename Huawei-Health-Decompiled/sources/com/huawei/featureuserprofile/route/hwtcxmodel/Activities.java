package com.huawei.featureuserprofile.route.hwtcxmodel;

import com.huawei.featureuserprofile.route.hwgpxmodel.xmlparser.Tag;
import com.huawei.health.marketing.datatype.SingleDailyMomentContent;

/* JADX INFO: loaded from: classes3.dex */
@Tag("Activities")
public class Activities {

    @Tag(SingleDailyMomentContent.ACTIVITY_TYPE)
    private Activity mActivity;

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public Activity getActivity() {
        return this.mActivity;
    }
}
