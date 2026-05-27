package com.huawei.browse;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface BrowsingBiEvent {
    void loginBeforeBiEvent(String str);

    void loginSuccessBiEvent();

    void showFullServiceDialog(Context context);

    void showFullServiceDialog(Context context, View.OnClickListener onClickListener);

    void updateCountryCodeAndUserId();
}
