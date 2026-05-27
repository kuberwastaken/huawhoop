package com.huawei.health.device.api;

import android.content.ContentValues;
import android.content.Context;
import com.huawei.health.userprofilemgr.model.BaseResponseCallback;
import com.huawei.pluginbase.PluginBaseAdapter;
import defpackage.dgk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface PluginDeviceApi {
    void checkAutoTrackStatus();

    void checkCancelConnectScale(String str);

    void connectScaleDevice(String str);

    PluginBaseAdapter getAdapter();

    ArrayList<ContentValues> getBondedDevice();

    ContentValues getDeviceInfoByDeviceName(String str);

    ContentValues getDeviceInfoByUniqueId(String str);

    List<dgk> getThirdDeviceList();

    void init(Context context);

    void sendWspData(String str, String str2, String str3, BaseResponseCallback<byte[]> baseResponseCallback);

    void setAdapter(PluginBaseAdapter pluginBaseAdapter);
}
