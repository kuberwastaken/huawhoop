package com.huawei.agconnect.abtest.internal;

import android.content.Context;
import android.os.Bundle;
import com.huawei.agconnect.common.api.HaBridge;
import com.huawei.agconnect.common.api.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class ABTestHAEventCallbackImpl {
    public void a(Context context) {
    }

    public void a(String str, Bundle bundle, Bundle bundle2) {
        boolean z = false;
        for (String str2 : ExperimentStorage.a()) {
            for (ABTestExperimentInfo aBTestExperimentInfo : ExperimentStorage.a(str2)) {
                if (aBTestExperimentInfo.b() != null && !aBTestExperimentInfo.d() && aBTestExperimentInfo.b().equals(str)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("$ABTaskId", aBTestExperimentInfo.a());
                    bundle3.putString("$ABVarId", aBTestExperimentInfo.c());
                    bundle3.putString("$ABChannel", str2);
                    Logger.d("ABTest", "report trigger ab test event");
                    new HaBridge(HaBridge.HA_SERVICE_TAG_ABTEST).onEvent("$JoinABTask", bundle3);
                    z = true;
                    aBTestExperimentInfo.a(true);
                }
            }
        }
        if (z) {
            ExperimentStorage.c();
        }
    }
}
