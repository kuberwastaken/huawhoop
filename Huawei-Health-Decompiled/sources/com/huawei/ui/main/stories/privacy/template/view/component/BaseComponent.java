package com.huawei.ui.main.stories.privacy.template.view.component;

import android.content.Context;
import android.view.View;
import com.huawei.ui.main.stories.privacy.template.contract.PrivacyDetailFragmentContract;

/* JADX INFO: loaded from: classes8.dex */
public interface BaseComponent {
    View getView(Context context);

    void setPresenter(PrivacyDetailFragmentContract.PrivacyFragmentPresenter privacyFragmentPresenter);
}
