package com.huawei.devicesdk.callback;

import com.huawei.unitedevice.entity.UniteDevice;
import defpackage.ced;

/* JADX INFO: loaded from: classes3.dex */
public interface ConnectFilter {
    int onFilter(UniteDevice uniteDevice, String str, ced cedVar);

    String preProcess(UniteDevice uniteDevice, String str);
}
