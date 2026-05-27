package com.huawei.openalliance.ad.beans.inner;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.openalliance.ad.exception.b;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes6.dex */
public class GrsCountryCodeBean {
    private static final String TAG = "GrsCountryCodeBean";
    private static final String UNKNOWN = "UNKNOWN";
    private String countryCode = "UNKNOWN";

    public String a(Context context) {
        try {
            String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(context);
            this.countryCode = issueCountryCode;
            return issueCountryCode;
        } catch (Throwable th) {
            hq.c(TAG, "getIssueCountryCode via grs sdk: %s", th.getClass().getSimpleName());
            throw new b();
        }
    }
}
