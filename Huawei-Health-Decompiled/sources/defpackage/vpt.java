package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.health.R;
import com.huawei.openalliance.ad.constant.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes8.dex */
public class vpt {
    private static final Method b;
    private static final Method c;
    private static final Method e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f18720a;
    private Context l;
    private int d = 0;
    private final Rect i = new Rect();
    private final Rect g = new Rect();
    private int j = 0;
    private boolean f = false;
    private boolean h = false;
    private boolean k = false;
    private boolean n = false;
    private boolean o = false;
    private boolean m = true;
    private final Runnable t = new b();

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            vpt.this.f18720a.requestLayout();
        }
    }

    /* JADX WARN: Finally extract failed */
    static {
        if (Build.VERSION.SDK_INT < 28) {
            b = null;
            e = null;
            return;
        }
        try {
            try {
                try {
                    e = Class.forName("huawei.android.widget.RadiusSizeUtils").getDeclaredMethod("getRadiusSize", Context.class);
                } catch (ClassNotFoundException unused) {
                    Log.w("HwWidgetSafeInsets", "getRadiusSize ClassNotFoundException");
                    e = null;
                    try {
                        try {
                            try {
                                try {
                                    b = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getDeclaredMethod("getDisplaySafeInsets", WindowInsets.class);
                                } catch (ClassNotFoundException unused2) {
                                    Log.w("HwWidgetSafeInsets", "getDisplaySafeInsets ClassNotFoundException");
                                    c = Class.forName("com.huawei.android.app.WindowManagerEx").getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
                                }
                            } catch (NoSuchMethodException unused3) {
                                Log.w("HwWidgetSafeInsets", "getDisplaySafeInsets NoSuchMethodException");
                                c = Class.forName("com.huawei.android.app.WindowManagerEx").getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
                            }
                            c = Class.forName("com.huawei.android.app.WindowManagerEx").getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
                        } catch (ClassNotFoundException unused4) {
                            Log.w("HwWidgetSafeInsets", "getDisplaySideSafeInsets ClassNotFoundException");
                        }
                    } finally {
                        c = null;
                    }
                }
            } catch (NoSuchMethodException unused5) {
                Log.w("HwWidgetSafeInsets", "getRadiusSize NoSuchMethodException");
                e = null;
                b = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getDeclaredMethod("getDisplaySafeInsets", WindowInsets.class);
                c = Class.forName("com.huawei.android.app.WindowManagerEx").getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
            }
            try {
                b = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getDeclaredMethod("getDisplaySafeInsets", WindowInsets.class);
                try {
                    c = Class.forName("com.huawei.android.app.WindowManagerEx").getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
                } catch (NoSuchMethodException unused6) {
                    Log.w("HwWidgetSafeInsets", "getDisplaySideSafeInsets NoSuchMethodException");
                }
            } finally {
                b = null;
            }
        } catch (Throwable th) {
            e = null;
            throw th;
        }
    }

    public vpt(View view) {
        this.l = null;
        this.f18720a = view;
        this.l = view.getContext();
    }

    private boolean e() {
        Activity activityEGK_ = eGK_(this.l);
        if (activityEGK_ == null) {
            return false;
        }
        try {
            return ((Integer) Class.forName("com.huawei.android.app.ActivityManagerEx").getMethod("getActivityWindowMode", Activity.class).invoke(null, activityEGK_)).intValue() == 102;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            Log.e("HwWidgetSafeInsets", "Exception occurred in isInMultiWindowMode.");
            return false;
        }
    }

    private Activity eGK_(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return eGK_(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b() {
        View view = this.f18720a;
        if (view != null) {
            view.removeCallbacks(this.t);
            this.f18720a.post(this.t);
        }
    }

    public void c(boolean z) {
        this.m = z;
    }

    public boolean d() {
        return this.d == 2;
    }

    public void e(int i, int i2, int i3, int i4) {
        eGR_(new Rect(i, i2, i3, i4));
    }

    public void e(boolean z) {
        this.k = z;
    }

    public void eGM_(View view, Rect rect, boolean z) {
        if (view == null || rect == null || d()) {
            return;
        }
        int i = this.j;
        if ((i & 2) == 0) {
            return;
        }
        this.j = i | 1;
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        this.j &= -2;
        if (z) {
            b();
            this.j &= -3;
        }
    }

    public Rect eGN_(View view) {
        return eGO_(view, this.g);
    }

    public Rect eGP_() {
        return this.i;
    }

    public void eGQ_(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            Log.w("HwWidgetSafeInsets", "parse cutout mode error");
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100453_res_0x7f060325});
        this.d = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void eGS_(WindowInsets windowInsets) {
        if (!e() && Build.VERSION.SDK_INT >= 28) {
            Rect rectEGI_ = b != null ? eGI_(windowInsets) : eGG_(windowInsets);
            if (rectEGI_ == null) {
                rectEGI_ = new Rect();
            }
            boolean zEGL_ = eGL_(this.f18720a);
            this.f18720a.getLocationInWindow(new int[2]);
            if (this.m) {
                if (this.i.equals(rectEGI_) && this.f == zEGL_) {
                    return;
                }
                this.i.set(rectEGI_);
                this.j |= 2;
                this.f = zEGL_;
                b();
            }
        }
    }

    private void a(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
        if (this.d == 1) {
            Rect rect5 = this.i;
            int i = rect5.left;
            if (i > 0) {
                rect2.left = rect.left + i;
            }
            int i2 = rect5.right;
            if (i2 > 0) {
                rect2.right = rect.right + i2;
                return;
            }
            return;
        }
        Rect rect6 = this.i;
        int i3 = rect6.left;
        if (i3 > 0 && rect3.left < i3) {
            rect2.left = rect.left + i3;
        }
        int i4 = rect6.right;
        if (i4 <= 0 || rect4.right - i4 >= rect3.right) {
            return;
        }
        rect2.right = rect.right + i4;
    }

    public Rect eGO_(View view, Rect rect) {
        int iEGF_;
        int i;
        Rect rect2 = new Rect();
        if (view != null && rect != null) {
            rect2.set(rect);
            boolean z = (this.k || this.h || a()) ? false : true;
            if (!d() && !z) {
                Rect rect3 = new Rect();
                Rect rect4 = new Rect();
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i2 = iArr[0];
                rect3.set(i2, iArr[1], view.getWidth() + i2, iArr[1] + view.getHeight());
                View rootView = view.getRootView();
                if (rootView != null) {
                    rootView.getLocationInWindow(iArr);
                    int i3 = iArr[0];
                    rect4.set(i3, iArr[1], rootView.getWidth() + i3, iArr[1] + rootView.getHeight());
                    a(rect, rect2, rect3, rect4);
                    boolean zB = b(view.getContext());
                    if (this.h) {
                        if (zB && (i = this.i.top) > 0 && rect3.top < i) {
                            int i4 = rect3.top;
                            int paddingTop = view.getPaddingTop();
                            int paddingTop2 = this.i.top;
                            if (i4 + paddingTop >= paddingTop2) {
                                paddingTop2 = view.getPaddingTop();
                            }
                            rect2.top = paddingTop2;
                        } else if (this.n) {
                            rect2.top = view.getPaddingTop();
                        }
                    }
                    if (this.k && zB && (iEGF_ = eGF_(view)) > 0) {
                        rect2.bottom = rect.bottom + iEGF_;
                    }
                }
            }
        }
        return rect2;
    }

    public void eGR_(Rect rect) {
        if (eGJ_(this.f18720a) && (this.j & 1) == 0) {
            if (this.o) {
                this.n = true;
                return;
            }
            this.g.set(rect);
            this.o = true;
            this.j |= 2;
        }
    }

    private boolean eGL_(View view) {
        return view != null && Settings.Global.getInt(view.getContext().getContentResolver(), Constants.NAVIGATIONBAR_IS_MIN, 0) == 0;
    }

    private boolean b(Context context) {
        WindowManager windowManager;
        int rotation = (context == null || (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) == null) ? 0 : windowManager.getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    public void d(boolean z) {
        if ((this.j & 2) == 0) {
            return;
        }
        View view = this.f18720a;
        eGM_(view, eGN_(view), z);
    }

    private static Rect eGI_(WindowInsets windowInsets) {
        int i;
        Rect rect = new Rect();
        if (windowInsets != null && Build.VERSION.SDK_INT >= 28) {
            try {
                Method method = b;
                if (method != null) {
                    Object objInvoke = method.invoke(null, windowInsets);
                    if (objInvoke instanceof Rect) {
                        rect = (Rect) objInvoke;
                    }
                }
                Method method2 = c;
                if (method2 != null) {
                    Object objInvoke2 = method2.invoke(null, new Object[0]);
                    if (!(objInvoke2 instanceof Rect)) {
                        return rect;
                    }
                    Rect rect2 = (Rect) objInvoke2;
                    int i2 = rect2.left;
                    if (i2 != 0 && (i = rect2.right) != 0) {
                        rect.left = i2;
                        rect.right = i;
                    }
                }
            } catch (IllegalAccessException unused) {
                Log.e("HwWidgetSafeInsets", "getWindowDisplaySafeInsets IllegalAccessException");
            } catch (InvocationTargetException unused2) {
                Log.e("HwWidgetSafeInsets", "getWindowDisplaySafeInsets InvocationTargetException");
            }
        }
        return rect;
    }

    private int eGF_(View view) {
        Context context;
        int iD;
        if (view == null || (context = view.getContext()) == null || (iD = d(context)) <= 0) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        WindowManager windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return ((iArr[1] + view.getMeasuredHeight()) + iD) - displayMetrics.heightPixels;
    }

    private static Rect eGG_(WindowInsets windowInsets) {
        DisplayCutout displayCutout;
        Rect rect = new Rect();
        if (windowInsets != null && Build.VERSION.SDK_INT == 28 && (displayCutout = windowInsets.getDisplayCutout()) != null) {
            rect.set(displayCutout.getSafeInsetLeft(), 0, displayCutout.getSafeInsetRight(), 0);
        }
        return rect;
    }

    private static int d(Context context) {
        try {
            Method method = e;
            if (method != null) {
                return ((Integer) method.invoke(null, context)).intValue();
            }
        } catch (IllegalAccessException unused) {
            Log.w("HwWidgetSafeInsets", "getRadiusSize IllegalAccessException");
        } catch (InvocationTargetException unused2) {
            Log.w("HwWidgetSafeInsets", "getRadiusSize InvocationTargetException");
        }
        return 0;
    }

    private boolean eGJ_(View view) {
        if (view == null) {
            return false;
        }
        return view.isAttachedToWindow();
    }

    private boolean a() {
        Rect rect = this.i;
        if (rect == null) {
            return false;
        }
        return rect.left > 0 || rect.right > 0;
    }
}
