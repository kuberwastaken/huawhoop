package com.huawei.health.main.api;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes4.dex */
public interface WeChatApi {
    void dismissJumpToHwPublicDialog();

    void go2WeChatHandle(Context context);

    boolean isUserBind(Context context);

    String isUserBinded(Context context);

    void jumpWechatHelp(Context context);

    void launchWxMiniProgram(String str, String str2, int i);

    void setWeChatHandler(Handler handler);

    void showDeviceAlreadyBinded(Context context);

    void showSportPrivacySettingDialog(Context context, int i);
}
