package com.huawei.appgallery.agd.api;

import android.content.Intent;
import com.huawei.secure.android.common.intent.SafeIntent;

/* JADX INFO: loaded from: classes10.dex */
public class StartAbilityResult extends BaseServiceResult {
    private int c;
    private String d;
    private String h;

    interface StartResultCode {
        public static final int ABILITY_START_FAILED = 1;
        public static final int ABILITY_START_INVALID = -1;
        public static final int ABILITY_START_SUCCESS = 0;
    }

    public String toString() {
        return "StartAbilityResult{loadResult=" + this.b + ", startResult=" + this.c + ", bundleName='" + this.e + "', moduleNameName='" + this.d + "', abilityNameName='" + this.h + "', callerContext='" + this.f1896a + "'}";
    }

    public String getStartResultDesc() {
        int i = this.c;
        if (i == -1) {
            return "ABILITY_START_INVALID";
        }
        if (i == 0) {
            return "ABILITY_START_SUCCESS";
        }
        if (i == 1) {
            return "ABILITY_START_FAILED";
        }
        return "unknown result " + this.c;
    }

    public int getStartResult() {
        return this.c;
    }

    public String getModuleName() {
        return this.d;
    }

    public String getAbilityName() {
        return this.h;
    }

    public static StartAbilityResult from(Intent intent) {
        if (intent == null) {
            return null;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        StartAbilityResult startAbilityResult = new StartAbilityResult();
        startAbilityResult.b = safeIntent.getIntExtra("loadResultCode", -1);
        startAbilityResult.c = safeIntent.getIntExtra("startResultCode", -1);
        startAbilityResult.e = safeIntent.getStringExtra("bundleName");
        startAbilityResult.d = safeIntent.getStringExtra("moduleName");
        startAbilityResult.h = safeIntent.getStringExtra("abilityName");
        startAbilityResult.f1896a = safeIntent.getStringExtra("callerContext");
        return startAbilityResult;
    }

    private StartAbilityResult() {
    }
}
