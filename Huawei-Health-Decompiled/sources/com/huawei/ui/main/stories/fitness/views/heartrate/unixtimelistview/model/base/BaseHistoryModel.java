package com.huawei.ui.main.stories.fitness.views.heartrate.unixtimelistview.model.base;

import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.ui.main.stories.fitness.views.heartrate.unixtimelistview.common.UserView;
import com.huawei.ui.main.stories.fitness.views.heartrate.unixtimelistview.model.icommon.IHistoryModel;
import java.util.Calendar;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseHistoryModel implements IHistoryModel {
    private static final String TAG = "BaseHistoryModel";

    @Override // com.huawei.ui.main.stories.fitness.views.heartrate.unixtimelistview.model.icommon.IHistoryModel
    public abstract long queryModelEndTime();

    @Override // com.huawei.ui.main.stories.fitness.views.heartrate.unixtimelistview.model.icommon.IHistoryModel
    public abstract long queryModelStartTime();

    @Override // com.huawei.ui.main.stories.fitness.views.heartrate.unixtimelistview.model.icommon.IHistoryModel
    public boolean hasSameDirectParent(IHistoryModel iHistoryModel) {
        UserView userViewQueryUserView = iHistoryModel.queryUserView();
        if (userViewQueryUserView != queryUserView()) {
            return false;
        }
        UserView userViewUpper = userViewQueryUserView.upper();
        return iHistoryModel.generateViewFlag(userViewUpper) == generateViewFlag(userViewUpper);
    }

    @Override // com.huawei.ui.main.stories.fitness.views.heartrate.unixtimelistview.model.icommon.IHistoryModel
    public long generateViewFlag(UserView userView) {
        long jQueryModelStartTime = queryModelStartTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jQueryModelStartTime);
        calendar.set(14, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(11, 0);
        calendar.set(5, 1);
        if (userView == UserView.MONTH_DATAS) {
            return calendar.getTimeInMillis();
        }
        calendar.set(2, 0);
        if (userView == UserView.YEAR_DATAS) {
            return calendar.getTimeInMillis();
        }
        calendar.set(1, 0);
        if (userView == UserView.ALL_DATAS) {
            return calendar.getTimeInMillis();
        }
        LogUtil.j(TAG, "generateViewFlag not compat");
        return -1L;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IHistoryModel)) {
            return true;
        }
        IHistoryModel iHistoryModel = (IHistoryModel) obj;
        return queryModelStartTime() == iHistoryModel.queryModelStartTime() && queryModelEndTime() == iHistoryModel.queryModelEndTime();
    }
}
