package com.huawei.hwstressmgr.interfaces;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public interface StressWearAppInterface {
    boolean getDeviceSupportStressReport();

    void setStressMeasureStatus(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback);
}
