package com.huawei.openalliance.ad.beans.inner;

import android.content.Context;
import com.hihonor.common.grs.HihonorGrsApp;
import com.huawei.openalliance.ad.hq;
import java.security.InvalidParameterException;

/* JADX INFO: loaded from: classes11.dex */
public class HonorGrsCountryCodeBean {
    private static final String TAG = "HonorGrsCountryCodeBean";
    private static final String UNKNOWN = "UNKNOWN";
    private String countryCode = "UNKNOWN";

    public String a(Context context) {
        try {
            String issueCountryCode = HihonorGrsApp.getInstance().getIssueCountryCode(context);
            this.countryCode = issueCountryCode;
            return issueCountryCode;
        } catch (Throwable th) {
            hq.c(TAG, "getIssueCountryCode via grs sdk: %s", th.getClass().getSimpleName());
            throw new InvalidParameterException();
        }
    }
}
