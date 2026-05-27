package com.huawei.haf.router.core;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.haf.router.facade.model.RouteMeta;
import com.huawei.haf.router.facade.template.ServiceProvider;

/* JADX INFO: loaded from: classes.dex */
public class AppRouterPostcard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2184a;
    private ServiceProvider b;
    private boolean c;
    private int d;
    private final String e;
    private RouteMeta f;
    private Object g;
    private final Uri i;

    public AppRouterPostcard(String str, String str2, Uri uri) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("path parameter invalid!");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("group parameter invalid!");
        }
        this.f2184a = str;
        this.e = str2;
        this.i = uri;
    }

    public String m() {
        return this.f2184a;
    }

    public String j() {
        return this.e;
    }

    public Uri Bs_() {
        return this.i;
    }

    protected void e(RouteMeta routeMeta) {
        this.f = routeMeta;
        this.d = routeMeta.getExtra();
    }

    protected RouteMeta n() {
        return this.f;
    }

    protected void e(ServiceProvider serviceProvider) {
        this.b = serviceProvider;
    }

    protected ServiceProvider k() {
        return this.b;
    }

    protected void s() {
        this.c = true;
    }

    protected boolean p() {
        return this.c;
    }

    protected void b(Object obj) {
        this.g = obj;
    }

    protected Object l() {
        return this.g;
    }

    public int f() {
        RouteMeta routeMeta = this.f;
        return routeMeta == null ? this.d : routeMeta.getExtra();
    }

    public void b(int i) {
        this.d = i;
    }
}
