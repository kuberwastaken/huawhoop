package com.huawei.agconnect.common.aaid;

import android.content.Context;
import com.huawei.agconnect.common.api.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class HMSInstanceIdWrapper {
    private static final String b = "HMSInstanceIdWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f1732a;

    public String d() {
        try {
            Logger.d(b, "call hms wrapper : getId");
            return (String) this.f1732a.getClass().getDeclaredMethod("getId", new Class[0]).invoke(this.f1732a, new Object[0]);
        } catch (Throwable unused) {
            Logger.e(b, "get id fail");
            return null;
        }
    }

    public long c() {
        try {
            Logger.d(b, "call hms wrapper : getCreationTime");
            return ((Long) this.f1732a.getClass().getDeclaredMethod("getCreationTime", new Class[0]).invoke(this.f1732a, new Object[0])).longValue();
        } catch (Throwable unused) {
            Logger.e(b, "get create time fail");
            return 0L;
        }
    }

    public void b() {
        try {
            Logger.d(b, "call hms wrapper : deleteAAID");
            this.f1732a.getClass().getDeclaredMethod("deleteAAID", new Class[0]).invoke(this.f1732a, new Object[0]);
        } catch (Throwable unused) {
            Logger.e(b, "delete aaid fail");
        }
    }

    public boolean a() {
        return this.f1732a != null;
    }

    public HMSInstanceIdWrapper(Context context) {
        try {
            this.f1732a = Class.forName("com.huawei.hms.aaid.HmsInstanceId").getDeclaredMethod("getInstance", Context.class).invoke(null, context);
        } catch (Throwable unused) {
            Logger.w(b, "not find package HmsInstanceId");
        }
    }
}
