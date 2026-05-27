package com.huawei.phoneservice.faq.base.tracker;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    private static WeakReference<Context> c;

    private static void a(Context context, boolean z) {
        c = new WeakReference<>(context.getApplicationContext());
    }

    public static void c(Context context, boolean z) {
        a(context, z);
    }
}
