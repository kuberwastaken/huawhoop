package com.huawei.hwonesdk.process;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* JADX INFO: loaded from: classes6.dex */
public interface HiHealthProcess {
    public static final String TAG = "HiHealthProcess_";

    void doAction(String str, IBaseResponseCallback iBaseResponseCallback);

    String postProcess(Object obj, Object obj2);

    Object preProcess(String str);
}
