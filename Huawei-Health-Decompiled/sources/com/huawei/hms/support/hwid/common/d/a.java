package com.huawei.hms.support.hwid.common.d;

import android.content.Context;

/* JADX INFO: loaded from: classes10.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f6186a;

    public a(Context context, String str) {
        super(context, str);
    }

    public static a a(Context context) {
        if (f6186a == null) {
            synchronized (a.class) {
                if (f6186a == null) {
                    f6186a = new a(context, "SiteDomain");
                }
            }
        }
        return f6186a;
    }
}
