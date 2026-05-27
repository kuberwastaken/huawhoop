package com.huawei.ui.main.stories.template.health.module.nodevice;

import com.huawei.ui.main.stories.template.BasePresenter;
import com.huawei.ui.main.stories.template.BaseView;
import defpackage.dam;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class HealthNoDeviceContract {

    public interface Presenter extends BasePresenter {
        void requestActivityInfo(int i);
    }

    public interface View extends BaseView {
        void onResponsePageModule(List<dam> list);
    }
}
