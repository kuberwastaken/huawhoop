package com.huawei.ui.homewear21.home.datasync;

import defpackage.rzg;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface DataSyncSwitchContract {

    public interface Presenter extends BasePresenter {
        void onDestroy();

        void startQueryData(String str);
    }

    public interface View extends BaseView<Presenter> {
        void refreshList(List<rzg> list);
    }
}
