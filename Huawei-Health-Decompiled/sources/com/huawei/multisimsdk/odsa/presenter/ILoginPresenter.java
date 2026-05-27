package com.huawei.multisimsdk.odsa.presenter;

import android.content.Intent;

/* JADX INFO: loaded from: classes6.dex */
public interface ILoginPresenter {
    String getTokenValue(String str);

    void onDestroy();

    void onStart();

    void onStop();

    void processAuthResult(int i, int i2, Intent intent);

    void processAuthResultFromWebView(String str);

    void setUrlWithAuthorizationCodeFromWebView(String str);

    void startLogin();
}
