package com.huawei.hms.ads.uiengine.common;

import android.os.Bundle;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.jm;

/* JADX INFO: loaded from: classes5.dex */
public interface IInterstitialView extends jm {
    void bindData(String str);

    void destroyView();

    ViewGroup getContentContainer();

    void onAppStatusChanged(String str);

    void onBtnClick(Bundle bundle);

    void onCallBack(String str, Bundle bundle);

    void pauseView();

    void resumeVideoView();

    void setIsNeedRemindData(boolean z);

    void setProxy(InterstitialApi interstitialApi);
}
