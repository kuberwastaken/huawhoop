package com.huawei.ui.device.activity.selectcontact.selectmvp;

import android.content.Context;
import com.huawei.datatype.Contact;
import com.huawei.ui.main.stories.fitness.activity.bloodoxygen.base.CommonBaseView;
import defpackage.prr;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface ContactSelectActivityView extends CommonBaseView {
    void changeHealthToolBarState(boolean z);

    void dismissLoadingView();

    void finishSelect(List<Contact> list);

    Context getContext();

    void initHealthToolBar();

    void initListView();

    void initSideBarView();

    void initTitleBar();

    void setAdapter(List<prr> list);

    void setCustomTitleBar(int i);

    void showUpperLimitMessage(int i);
}
