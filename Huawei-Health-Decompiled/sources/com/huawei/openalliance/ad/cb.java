package com.huawei.openalliance.ad;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile cq f6915a;
    private static final byte[] b = new byte[0];

    public static cq a(Context context) {
        if (f6915a == null) {
            synchronized (b) {
                if (f6915a == null) {
                    f6915a = bz.e(context) ? ch.b(context) : cl.b(context);
                }
            }
        }
        return f6915a;
    }
}
