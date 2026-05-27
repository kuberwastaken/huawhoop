package com.huawei.hms.support.hwid.common.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hwid.common.e.c;
import com.huawei.hms.support.hwid.common.e.g;
import com.huawei.hms.support.hwid.common.e.j;
import com.huawei.up.request.HttpRequestBase;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a {
    protected String d;
    private String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f6184a = 200;
    protected int b = -1;
    protected int c = -1;
    private int e = 0;
    private EnumC0169a g = EnumC0169a.XMLType;

    /* JADX INFO: renamed from: com.huawei.hms.support.hwid.common.c.a$a, reason: collision with other inner class name */
    public enum EnumC0169a {
        XMLType,
        URLType,
        JSONType,
        Stream,
        FileType
    }

    public abstract String a();

    protected abstract String a(Context context);

    public Bundle b() {
        return c();
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt("responseCode", this.f6184a);
        bundle.putInt("resultCode", this.b);
        bundle.putInt("errorCode", this.c);
        bundle.putString(HttpRequestBase.TAG_ERROR_DESC, this.d);
        return bundle;
    }

    public void a(String str, int i) {
        this.e = i;
        String strA = a();
        String str2 = "https://" + str + HttpRequestBase.UP_SERVER_URL_CHINA;
        g.a("HttpRequest", "setGlobalSiteId, AsUrl::=" + str2, false);
        this.f = str2 + strA;
        int i2 = this.e;
        this.f = j.a(this.f, new String[]{"\\{0\\}", (i2 < 1 || i2 > 999) ? "" : String.valueOf(i)});
        g.a("HttpRequest", "Set mGlobalHostUrl::=" + this.f, false);
    }

    public String d() {
        if (TextUtils.isEmpty(this.f)) {
            return a() + "?Version=66300&cVersion=" + c.a();
        }
        return this.f + "?Version=66300&cVersion=" + c.a();
    }
}
