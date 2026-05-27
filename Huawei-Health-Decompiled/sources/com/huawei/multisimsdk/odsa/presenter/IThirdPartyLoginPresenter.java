package com.huawei.multisimsdk.odsa.presenter;

/* JADX INFO: loaded from: classes6.dex */
public interface IThirdPartyLoginPresenter {
    void getWsTokenAndNonce(String str);

    void onDestroy();

    void onStart();

    void onStop();

    void startLogin();
}
