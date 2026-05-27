package com.huawei.health.hwhealthlinkage.linkage.parsedata;

import defpackage.dtc;
import defpackage.mxh;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface LinkageDataHandler {
    void handle(double d, mxh mxhVar);

    void reset();

    default dtc packageSamplePointInfo(JSONObject jSONObject, String str, int i) {
        return new dtc();
    }
}
