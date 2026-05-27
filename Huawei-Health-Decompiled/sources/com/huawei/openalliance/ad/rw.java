package com.huawei.openalliance.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.ad.db.bean.ContentRecord;

/* JADX INFO: loaded from: classes6.dex */
public abstract class rw {
    private static final String[] e = {"com.huawei.openalliance.ad.views.reward", "com.huawei.openalliance.ad.activity", "com.huawei.openalliance.ad.utils", "com.huawei.openalliance.ad.views", "com.huawei.openalliance.ad.views.dsa", "java.lang.reflect", "com.android.internal.os", "android.app", "android.os", "android.view", "com.android.internal.policy", "dalvik.system", "java.lang", "com.huawei.hms.ads.uiengine.views.template", "com.huawei.hms.ads", "com.android.tools.profiler.support.event", "huawei.android.widget", "android.widget", "androidx.recyclerview.widget", "android.app.servertransaction", "com.huawei.hms.ads.uiengine.remote"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f7780a;
    protected ContentRecord b;
    protected bo c;
    protected rw d;

    public abstract boolean a();

    public void a(rw rwVar) {
        this.d = rwVar;
    }

    public static boolean a(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null || TextUtils.isEmpty(stackTraceElement.toString()) || TextUtils.isEmpty(stackTraceElement.getClassName())) {
            return true;
        }
        String strH = com.huawei.openalliance.ad.utils.dd.h(stackTraceElement.getFileName(), stackTraceElement.getClassName());
        if (TextUtils.isEmpty(strH)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = e;
            if (i >= strArr.length) {
                return false;
            }
            if (strH.equals(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public static boolean a(View view) {
        if (view != null) {
            return !(view.getContext() instanceof Activity) || com.huawei.openalliance.ad.utils.dh.c((Activity) view.getContext());
        }
        return false;
    }

    public rw(Context context, ContentRecord contentRecord) {
        this.f7780a = context;
        this.b = contentRecord;
        this.c = new bo(context);
    }

    public rw() {
    }
}
