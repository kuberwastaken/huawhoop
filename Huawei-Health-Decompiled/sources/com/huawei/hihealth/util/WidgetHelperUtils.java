package com.huawei.hihealth.util;

import com.huawei.hihealth.data.listener.FitnessListener;
import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class WidgetHelperUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile WidgetHelperUtils f4312a;
    private static final Object b = new Object();
    private FitnessListener c;

    public static WidgetHelperUtils b() {
        if (f4312a == null) {
            synchronized (b) {
                if (f4312a == null) {
                    f4312a = new WidgetHelperUtils();
                }
            }
        }
        return f4312a;
    }

    public void b(FitnessListener fitnessListener) {
        this.c = fitnessListener;
    }

    public void b(String str) {
        LogUtil.a("WidgetHelperUtils", "enter insertFitnessData");
        FitnessListener fitnessListener = this.c;
        if (fitnessListener != null) {
            fitnessListener.onResult(str);
        }
    }
}
