package com.huawei.agconnect.common.server;

import android.text.TextUtils;
import com.huawei.agconnect.datastore.annotation.SharedPreference;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class SiteUrl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f1781a;
    private String b;

    @SharedPreference(fileName = "agc_site", isDynamic = true, key = "backup")
    String backUrl;

    @SharedPreference(fileName = "agc_site", isDynamic = true, key = "main")
    String mainUrl;

    @SharedPreference(fileName = "agc_site", isDynamic = true, key = HwPayConstant.KEY_VALIDTIME)
    long validTime;

    public int hashCode() {
        return a(this.mainUrl, this.backUrl);
    }

    public boolean g() {
        return (TextUtils.isEmpty(this.mainUrl) && TextUtils.isEmpty(this.backUrl)) ? false : true;
    }

    public String f() {
        return this.f1781a.booleanValue() ? this.backUrl : this.mainUrl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SiteUrl siteUrl = (SiteUrl) obj;
        return a(this.mainUrl, siteUrl.mainUrl) && a(this.backUrl, siteUrl.backUrl);
    }

    public long e() {
        return this.validTime;
    }

    public String d() {
        return this.b;
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(this.mainUrl)) {
            SiteUrlPreference.b().e(this, str);
        }
        if (TextUtils.isEmpty(this.backUrl)) {
            return;
        }
        SiteUrlPreference.b().d(this, str);
    }

    public String c() {
        return this.mainUrl;
    }

    public Boolean b() {
        return this.f1781a;
    }

    public void a(String str, boolean z) {
        this.b = str;
        this.f1781a = Boolean.valueOf(z);
    }

    public void a(Boolean bool) {
        this.f1781a = bool;
    }

    public String a() {
        return this.backUrl;
    }

    public static void b(String str) {
        SiteUrlPreference.b().b(str);
        SiteUrlPreference.b().a(str);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(String str, long j) {
        SiteUrl siteUrl = new SiteUrl();
        siteUrl.validTime = j;
        SiteUrlPreference.b().f(siteUrl, str);
    }

    public static SiteUrl a(String str) {
        SiteUrl siteUrl = new SiteUrl();
        SiteUrlPreference.b().b(siteUrl, str);
        SiteUrlPreference.b().a(siteUrl, str);
        SiteUrlPreference.b().c(siteUrl, str);
        return siteUrl;
    }

    private int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public SiteUrl(String str, String str2) {
        this.validTime = 0L;
        this.f1781a = Boolean.FALSE;
        this.b = null;
        this.mainUrl = str;
        this.backUrl = str2;
        if (TextUtils.isEmpty(str)) {
            this.f1781a = Boolean.TRUE;
        }
    }

    private SiteUrl() {
        this.validTime = 0L;
        this.f1781a = Boolean.FALSE;
        this.b = null;
    }
}
