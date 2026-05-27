package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes6.dex */
public class FaqHwFrameworkUtil {

    public interface b {
        void a(int i);
    }

    class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8531a;
        final /* synthetic */ Activity d;

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
                Class<?> cls2 = Class.forName("com.huawei.android.view.DisplaySideRegionEx");
                Object objC = FaqRefectUtils.c(cls, this.d.getWindow().getAttributes());
                if (objC != null) {
                    Object objInvoke = cls.getMethod("getDisplaySideRegion", WindowInsets.class).invoke(objC, windowInsets);
                    if (objInvoke == null) {
                        this.f8531a.a(1);
                    } else {
                        Rect rect = (Rect) cls2.getMethod("getSafeInsets", new Class[0]).invoke(objInvoke, new Object[0]);
                        if (rect.left > 0 && rect.right > 0) {
                            this.f8531a.a(3);
                        } else if (rect.top > 0) {
                            this.f8531a.a(2);
                        }
                    }
                }
            } catch (Throwable unused) {
                this.f8531a.a(1);
                h.e("setForRing", "Exception");
            }
            return view.onApplyWindowInsets(windowInsets);
        }

        a(Activity activity, b bVar) {
            this.d = activity;
            this.f8531a = bVar;
        }
    }

    public static void cjz_(Activity activity, int i) throws Throwable {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            FaqRefectUtils.a("com.huawei.android.view.WindowManagerEx$LayoutParamsEx", "setDisplaySideMode", activity.getWindow().getAttributes(), new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
            h.a("FaqHwFrameworkUtil", "setDisplaySideMode,time:%s", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th) {
            h.d("FaqHwFrameworkUtil", th, "setDisplaySideMode error", new Object[0]);
        }
    }

    public static void cjy_(Activity activity, b bVar) {
        activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new a(activity, bVar));
    }
}
