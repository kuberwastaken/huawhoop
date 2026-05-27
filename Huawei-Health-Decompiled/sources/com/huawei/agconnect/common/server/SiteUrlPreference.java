package com.huawei.agconnect.common.server;

import com.huawei.agconnect.datastore.annotation.DefaultCrypto;
import com.huawei.agconnect.datastore.core.CryptoUtil;
import com.huawei.agconnect.datastore.core.SharedPrefUtil;

/* JADX INFO: loaded from: classes3.dex */
public class SiteUrlPreference {
    private static SiteUrlPreference c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPrefUtil f1782a = SharedPrefUtil.getInstance();
    private CryptoUtil b;

    public void a() {
    }

    public void a(SiteUrl siteUrl) {
    }

    public void b(SiteUrl siteUrl) {
    }

    public void f(SiteUrl siteUrl, String str) {
        if (siteUrl == null || str == null) {
            return;
        }
        this.f1782a.put("agc_site", "validTime_" + str, Long.class, Long.valueOf(siteUrl.validTime), DefaultCrypto.class);
    }

    public void e(SiteUrl siteUrl, String str) {
        if (siteUrl == null || str == null) {
            return;
        }
        this.f1782a.put("agc_site", "main_" + str, String.class, siteUrl.mainUrl, DefaultCrypto.class);
    }

    public void d(SiteUrl siteUrl, String str) {
        if (siteUrl == null || str == null) {
            return;
        }
        this.f1782a.put("agc_site", "backup_" + str, String.class, siteUrl.backUrl, DefaultCrypto.class);
    }

    public void c(String str) {
        this.f1782a.remove("agc_site", "validTime_" + str);
    }

    public void c(SiteUrl siteUrl, String str) {
        if (siteUrl == null || str == null) {
            return;
        }
        siteUrl.validTime = ((Long) this.f1782a.get("agc_site", "validTime_" + str, Long.class, null, DefaultCrypto.class)).longValue();
    }

    public void b(String str) {
        this.f1782a.remove("agc_site", "main_" + str);
    }

    public void b(SiteUrl siteUrl, String str) {
        if (siteUrl == null || str == null) {
            return;
        }
        siteUrl.mainUrl = (String) this.f1782a.get("agc_site", "main_" + str, String.class, null, DefaultCrypto.class);
    }

    public void a(String str) {
        this.f1782a.remove("agc_site", "backup_" + str);
    }

    public void a(SiteUrl siteUrl, String str) {
        if (siteUrl == null || str == null) {
            return;
        }
        siteUrl.backUrl = (String) this.f1782a.get("agc_site", "backup_" + str, String.class, null, DefaultCrypto.class);
    }

    public static SiteUrlPreference b() {
        SiteUrlPreference siteUrlPreference;
        synchronized (SiteUrlPreference.class) {
            if (c == null) {
                c = new SiteUrlPreference();
            }
            siteUrlPreference = c;
        }
        return siteUrlPreference;
    }

    private SiteUrlPreference() {
    }
}
