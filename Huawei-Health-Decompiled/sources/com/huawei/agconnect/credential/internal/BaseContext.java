package com.huawei.agconnect.credential.internal;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;

/* JADX INFO: loaded from: classes3.dex */
public class BaseContext {
    public static final String b = "4D5480E9";
    private static final BaseContext c = new BaseContext();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1808a;

    public Context a() {
        if (this.f1808a == null) {
            this.f1808a = AGConnectInstance.getInstance().getContext();
        }
        return this.f1808a;
    }

    public static String d() {
        return "80fedfd8941a368fafdae46750a4d367";
    }

    public static String c() {
        return "1C4DE4EC";
    }

    public static BaseContext b() {
        return c;
    }

    public static void a(Context context) {
        synchronized (BaseContext.class) {
            Context applicationContext = context.getApplicationContext();
            BaseContext baseContext = c;
            if (applicationContext != null) {
                context = applicationContext;
            }
            baseContext.f1808a = context;
        }
    }

    private BaseContext() {
    }
}
