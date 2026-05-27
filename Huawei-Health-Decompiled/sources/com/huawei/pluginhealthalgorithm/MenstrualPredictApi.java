package com.huawei.pluginhealthalgorithm;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* JADX INFO: loaded from: classes7.dex */
public interface MenstrualPredictApi {
    void getSwitchState(String str, IBaseResponseCallback iBaseResponseCallback);

    void updateSwitchState(String str, String str2, IBaseResponseCallback iBaseResponseCallback);
}
