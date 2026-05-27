package com.huawei.appgallery.agd.api;

import android.content.Intent;
import com.huawei.appmarket.service.externalservice.distribution.opendetail.ModuleInfo;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class OpenDetailResult extends BaseServiceResult {
    private List<ModuleInfo> c;
    private int d;

    /* JADX INFO: loaded from: classes10.dex */
    interface DisplayResultCode {
        public static final int FA_DISPLAY_FAILED = 1;
        public static final int FA_DISPLAY_INVALID = -1;
        public static final int FA_DISPLAY_SUCCESS = 0;
        public static final int FA_FILTER_EMPTY = 2;
    }

    public String toString() {
        return "OpenDetailResult{loadResult=" + this.b + ", displayResult=" + this.d + ", bundleName='" + this.e + "', callerContext='" + this.f1896a + "', addToDeskModuleInfo=" + this.c + '}';
    }

    public List<ModuleInfo> getModules() {
        return this.c;
    }

    public String getDisplayResultDesc() {
        int i = this.d;
        if (i == -1) {
            return "FA_DISPLAY_INVALID";
        }
        if (i == 0) {
            return "FA_DISPLAY_SUCCESS";
        }
        if (i == 1) {
            return "FA_DISPLAY_FAILED";
        }
        if (i == 2) {
            return "FA_FILTER_EMPTY";
        }
        return "unknown result " + this.d;
    }

    public int getDisplayResult() {
        return this.d;
    }

    public static OpenDetailResult from(Intent intent) {
        if (intent == null) {
            return null;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        OpenDetailResult openDetailResult = new OpenDetailResult();
        if (safeIntent.hasExtra("result")) {
            c(safeIntent, openDetailResult);
        } else {
            b(safeIntent, openDetailResult);
        }
        openDetailResult.e = safeIntent.getStringExtra("bundleName");
        openDetailResult.f1896a = safeIntent.getStringExtra("callerContext");
        return openDetailResult;
    }

    private static void c(SafeIntent safeIntent, OpenDetailResult openDetailResult) {
        int i;
        openDetailResult.b = safeIntent.getIntExtra("result", -1);
        int i2 = openDetailResult.b;
        if (i2 == 100) {
            i = 0;
        } else {
            if (i2 != 101) {
                openDetailResult.d = -1;
                openDetailResult.c = safeIntent.getParcelableArrayListExtra("module_list");
            }
            i = 1;
        }
        openDetailResult.d = i;
        openDetailResult.c = safeIntent.getParcelableArrayListExtra("module_list");
    }

    private static void b(SafeIntent safeIntent, OpenDetailResult openDetailResult) {
        openDetailResult.b = safeIntent.getIntExtra("loadResultCode", -1);
        openDetailResult.d = safeIntent.getIntExtra("displayResultCode", -1);
        openDetailResult.c = safeIntent.getParcelableArrayListExtra("moduleList");
    }

    private OpenDetailResult() {
    }
}
