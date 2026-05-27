package com.huawei.uikit.hwfloatingactionbutton.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.health.R;
import com.huawei.hianalytics.visual.autocollect.instrument.ViewClickInstrumentation;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import defpackage.vpd;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes11.dex */
public class HwFloatingActionsMenu extends ViewGroup {
    private static final boolean c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11164a;
    private int b;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float k;
    private HwFloatingActionButton l;
    private boolean m;
    private int n;
    private int o;
    private OnFloatingActionsMenuUpdateListener p;
    private ColorStateList q;
    private float r;
    private View s;
    private Context t;
    private int u;
    private AnimatorSet v;
    private int w;
    private int x;
    private AnimatorSet y;

    public interface OnFloatingActionsMenuUpdateListener {
        void onMenuHide();

        void onMenuShow();
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HwFloatingActionsMenu.this.d();
            ViewClickInstrumentation.clickOnView(view);
        }
    }

    class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HwFloatingActionsMenu.this.c();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AnimatorSet f11165a;
        private AnimatorSet b;
        private AnimatorSet c;
        private AnimatorSet d;

        d(Context context) {
            b(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eBn_(View view) {
            this.f11165a.setTarget(view);
            this.b.setTarget(view);
            HwFloatingActionsMenu.this.v.play(this.f11165a);
            HwFloatingActionsMenu.this.y.play(this.b);
        }

        private void b(Context context) {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, HwFloatingActionsMenu.c ? R.animator._2131034146_res_0x7f050022 : R.anim._2130772051_res_0x7f010053);
            Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(context, HwFloatingActionsMenu.c ? R.animator._2131034145_res_0x7f050021 : R.anim._2130772050_res_0x7f010052);
            Animator animatorLoadAnimator3 = AnimatorInflater.loadAnimator(context, HwFloatingActionsMenu.c ? R.animator._2131034143_res_0x7f05001f : R.anim._2130772048_res_0x7f010050);
            Animator animatorLoadAnimator4 = AnimatorInflater.loadAnimator(context, HwFloatingActionsMenu.c ? R.animator._2131034144_res_0x7f050020 : R.anim._2130772049_res_0x7f010051);
            if ((animatorLoadAnimator instanceof AnimatorSet) && (animatorLoadAnimator2 instanceof AnimatorSet) && (animatorLoadAnimator3 instanceof AnimatorSet) && (animatorLoadAnimator4 instanceof AnimatorSet)) {
                this.d = (AnimatorSet) animatorLoadAnimator;
                this.f11165a = (AnimatorSet) animatorLoadAnimator2;
                this.c = (AnimatorSet) animatorLoadAnimator3;
                this.b = (AnimatorSet) animatorLoadAnimator4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eBm_(View view) {
            this.d.setTarget(view);
            this.c.setTarget(view);
            HwFloatingActionsMenu.this.v.play(this.d);
            HwFloatingActionsMenu.this.y.play(this.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(long j) {
            this.f11165a.setStartDelay(j);
            this.d.setStartDelay(j);
            long j2 = 100 - j;
            this.b.setStartDelay(j2);
            this.c.setStartDelay(j2);
        }
    }

    class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HwFloatingActionsMenu.this.j();
        }
    }

    static {
        c = l() || o();
    }

    public HwFloatingActionsMenu(Context context) {
        this(context, null);
    }

    private void f() {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f);
        for (int i = 0; i < this.h; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.s && (childAt instanceof HwFloatingActionButton)) {
                HwFloatingActionButton hwFloatingActionButton = (HwFloatingActionButton) childAt;
                String title = hwFloatingActionButton.getTitle();
                if (hwFloatingActionButton != this.l && hwFloatingActionButton.getTag(R.id.hwfab_label) == null) {
                    HwTextView hwTextViewB = HwTextView.b(contextThemeWrapper);
                    if (hwTextViewB == null) {
                        return;
                    }
                    if (title != null) {
                        hwTextViewB.setText(title);
                    }
                    hwTextViewB.setTextAppearance(getContext(), this.f);
                    hwTextViewB.setAutoTextInfo(9, 1, 2);
                    addView(hwTextViewB);
                    this.h++;
                    hwFloatingActionButton.setTag(R.id.hwfab_label, hwTextViewB);
                }
            }
        }
    }

    private void g() {
        Context context = this.t;
        boolean z = c;
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, z ? R.animator._2131034145_res_0x7f050021 : R.anim._2130772050_res_0x7f010052);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(this.t, z ? R.animator._2131034144_res_0x7f050020 : R.anim._2130772049_res_0x7f010051);
        if ((animatorLoadAnimator instanceof AnimatorSet) && (animatorLoadAnimator2 instanceof AnimatorSet)) {
            AnimatorSet animatorSet = (AnimatorSet) animatorLoadAnimator;
            AnimatorSet animatorSet2 = (AnimatorSet) animatorLoadAnimator2;
            this.s.setAlpha(0.0f);
            animatorSet.setTarget(this.s);
            animatorSet2.setTarget(this.s);
            this.v.play(animatorSet);
            this.y.play(animatorSet2);
        }
    }

    private int getMaxLabelWidth() {
        int measuredWidth = 0;
        for (int i = 0; i < this.h; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 && childAt != this.s && !(childAt instanceof HwTextView)) {
                if (childAt != this.l) {
                    this.e = this.f11164a - ((this.i - childAt.getMeasuredWidth()) / 2);
                }
                Object tag = childAt.getTag(R.id.hwfab_label);
                if (tag instanceof HwTextView) {
                    HwTextView hwTextView = (HwTextView) tag;
                    if (this.g == 0) {
                        if ((this.x - this.i) - this.e < hwTextView.getMeasuredWidth()) {
                            int i2 = (this.x - this.i) - this.e;
                            if (measuredWidth <= i2) {
                                measuredWidth = i2;
                            }
                            hwTextView.setMaxWidth(measuredWidth - this.f11164a);
                        } else if (measuredWidth <= hwTextView.getMeasuredWidth()) {
                            measuredWidth = hwTextView.getMeasuredWidth();
                        }
                    } else if (((this.x - this.i) / 2) - this.e < hwTextView.getMeasuredWidth()) {
                        int i3 = ((this.x - this.i) / 2) - this.e;
                        if (measuredWidth <= i3) {
                            measuredWidth = i3;
                        }
                        hwTextView.setMaxWidth(measuredWidth - this.f11164a);
                    } else if (measuredWidth <= hwTextView.getMeasuredWidth()) {
                        measuredWidth = hwTextView.getMeasuredWidth();
                    }
                }
            }
        }
        return measuredWidth;
    }

    private void h() {
        for (int i = this.h - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (childAt != this.l && (childAt instanceof HwFloatingActionButton)) {
                int i2 = this.u + 50;
                this.u = i2;
                if (i2 >= 100) {
                    break;
                }
            }
        }
        int i3 = 0;
        for (int i4 = this.h - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            if (childAt2 != this.l && (childAt2 instanceof HwFloatingActionButton)) {
                d dVar = new d(this.t);
                dVar.eBm_(childAt2);
                childAt2.setScaleX(0.0f);
                childAt2.setScaleY(0.0f);
                Object tag = childAt2.getTag(R.id.hwfab_label);
                if (tag instanceof View) {
                    View view = (View) tag;
                    view.setAlpha(0.0f);
                    dVar.eBn_(view);
                }
                int i5 = this.u;
                if (i3 > i5) {
                    i3 = i5;
                }
                dVar.d(i3);
                i3 += 50;
            }
        }
    }

    private void i() {
        if (!this.m || this.v.isRunning()) {
            return;
        }
        this.y.start();
        OnFloatingActionsMenuUpdateListener onFloatingActionsMenuUpdateListener = this.p;
        if (onFloatingActionsMenuUpdateListener != null) {
            onFloatingActionsMenuUpdateListener.onMenuHide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.m = true;
        for (int i = 0; i < this.h; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.l) {
                childAt.setVisibility(0);
                Object tag = childAt.getTag(R.id.hwfab_label);
                if (tag instanceof View) {
                    ((View) tag).setVisibility(0);
                }
            }
        }
    }

    private int k() {
        int measuredHeight = 0;
        for (int i = 0; i < this.h; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 && childAt != this.s && !(childAt instanceof HwTextView)) {
                int measuredWidth = childAt.getMeasuredWidth() + this.d + childAt.getPaddingLeft();
                int i2 = this.i;
                if (i2 > measuredWidth) {
                    measuredWidth = i2;
                }
                this.i = measuredWidth;
                measuredHeight += childAt.getMeasuredHeight();
            }
        }
        return measuredHeight;
    }

    private static boolean l() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
            Boolean bool = Boolean.FALSE;
            if (declaredMethod.invoke(null, "ro.build.hw_emui_lite.enable", bool) instanceof Boolean) {
                return ((Boolean) declaredMethod.invoke(null, "ro.build.hw_emui_lite.enable", bool)).booleanValue();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            Log.e("HwFabMenu", "isEmuiLite ClassNotFoundException info");
            return false;
        } catch (IllegalAccessException unused2) {
            Log.e("HwFabMenu", "isEmuiLite IllegalAccessException info");
            return false;
        } catch (NoSuchMethodException unused3) {
            Log.e("HwFabMenu", "isEmuiLite NoSuchMethodException info");
            return false;
        } catch (InvocationTargetException unused4) {
            Log.e("HwFabMenu", "isEmuiLite InvocationTargetException info");
            return false;
        }
    }

    private void m() {
        if (this.m || this.y.isRunning()) {
            return;
        }
        this.v.start();
        OnFloatingActionsMenuUpdateListener onFloatingActionsMenuUpdateListener = this.p;
        if (onFloatingActionsMenuUpdateListener != null) {
            onFloatingActionsMenuUpdateListener.onMenuShow();
        }
    }

    private void n() {
        Context context = this.t;
        boolean z = c;
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, z ? R.animator._2131034147_res_0x7f050023 : R.anim._2130772052_res_0x7f010054);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(this.t, z ? R.animator._2131034142_res_0x7f05001e : R.anim._2130772047_res_0x7f01004f);
        if ((animatorLoadAnimator instanceof AnimatorSet) && (animatorLoadAnimator2 instanceof AnimatorSet)) {
            AnimatorSet animatorSet = (AnimatorSet) animatorLoadAnimator;
            AnimatorSet animatorSet2 = (AnimatorSet) animatorLoadAnimator2;
            animatorSet.setTarget(this.l);
            animatorSet2.setTarget(this.l);
            this.v.play(animatorSet);
            this.y.play(animatorSet2);
        }
    }

    private static boolean o() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
            Boolean bool = Boolean.FALSE;
            if (declaredMethod.invoke(null, "ro.config.hw_nova_performance", bool) instanceof Boolean) {
                return ((Boolean) declaredMethod.invoke(null, "ro.config.hw_nova_performance", bool)).booleanValue();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            Log.e("HwFabMenu", "isNovaPerformance ClassNotFoundException info");
            return false;
        } catch (IllegalAccessException unused2) {
            Log.e("HwFabMenu", "isNovaPerformance IllegalAccessException info");
            return false;
        } catch (NoSuchMethodException unused3) {
            Log.e("HwFabMenu", "isNovaPerformance NoSuchMethodException info");
            return false;
        } catch (InvocationTargetException unused4) {
            Log.e("HwFabMenu", "isNovaPerformance InvocationTargetException info");
            return false;
        }
    }

    private void setDrawableBackground(Context context) {
        this.s = new View(context);
        addView(this.s, new ViewGroup.LayoutParams(-1, -1));
        this.s.setBackground(getResources().getDrawable(R.drawable.hwfab_background));
    }

    public void d() {
        if (this.m) {
            i();
        } else {
            m();
        }
    }

    public ColorStateList getFabBackgroundColor() {
        return this.q;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.l);
        this.h = getChildCount();
        if (this.f != 0) {
            f();
        }
        n();
        g();
        h();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.s.layout(i, i2, i5, i6);
        a(i6 - this.l.getMeasuredHeight(), this.g == 0 ? (i5 - (this.l.getMeasuredWidth() / 2)) - this.d : i5 / 2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        this.x = getResources().getDisplayMetrics().widthPixels;
        this.w = getResources().getDisplayMetrics().heightPixels;
        this.i = 0;
        c(k(), getMaxLabelWidth());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setFabBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        this.q = colorStateList;
        this.l.setBackgroundTintList(colorStateList);
    }

    public void setOnFloatingActionsMenuUpdateListener(OnFloatingActionsMenuUpdateListener onFloatingActionsMenuUpdateListener) {
        this.p = onFloatingActionsMenuUpdateListener;
    }

    public void setmButtonMarginBottom(int i) {
        this.j = i;
    }

    public void setmButtonMarginRight(int i) {
        this.d = i;
    }

    public HwFloatingActionsMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100511_res_0x7f06035f);
    }

    private void a() {
        this.y.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        for (int i = 0; i < this.h; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.l) {
                childAt.setVisibility(8);
                Object tag = childAt.getTag(R.id.hwfab_label);
                if (tag instanceof View) {
                    ((View) tag).setVisibility(8);
                }
            }
        }
        this.m = false;
    }

    private void c(int i, int i2) {
        int i3 = this.i;
        int i4 = i2 > 0 ? i2 + this.e : 0;
        int i5 = this.j;
        int paddingTop = this.l.getPaddingTop();
        if (this.m) {
            setMeasuredDimension(this.x, this.w);
        } else {
            setMeasuredDimension(i3 + i4, i + i5 + paddingTop);
        }
    }

    public HwFloatingActionsMenu(Context context, AttributeSet attributeSet, int i) {
        super(c(context, i), attributeSet, i);
        this.m = false;
        this.u = -50;
        this.v = new AnimatorSet();
        this.y = new AnimatorSet();
        eBl_(super.getContext(), attributeSet, i);
    }

    private static Context c(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwFloatingActionButton);
    }

    private void eBl_(Context context, AttributeSet attributeSet, int i) {
        this.t = context;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen._2131364310_res_0x7f0a09d6);
        this.f11164a = dimensionPixelSize;
        this.d = getResources().getDimensionPixelSize(R.dimen._2131362646_res_0x7f0a0356);
        this.j = dimensionPixelSize;
        this.b = getResources().getDimensionPixelSize(R.dimen._2131364311_res_0x7f0a09d7);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100489_res_0x7f060349, R.attr._2131100493_res_0x7f06034d, R.attr._2131100494_res_0x7f06034e, R.attr._2131100495_res_0x7f06034f, R.attr._2131100499_res_0x7f060353, R.attr._2131100501_res_0x7f060355, R.attr._2131100502_res_0x7f060356}, i, R.style.Widget_Emui_HwFloatingActionsMenu);
        this.f = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.g = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.q = typedArrayObtainStyledAttributes.getColorStateList(0);
        this.n = typedArrayObtainStyledAttributes.getColor(6, 0);
        this.o = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.k = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        this.r = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        e(context);
        setDrawableBackground(context);
    }

    private void e() {
        this.v.addListener(new e());
        a();
    }

    private void e(Context context) {
        HwFloatingActionButton hwFloatingActionButtonB = HwFloatingActionButton.b(context);
        this.l = hwFloatingActionButtonB;
        if (hwFloatingActionButtonB == null) {
            return;
        }
        hwFloatingActionButtonB.setImageResource(this.o);
        this.l.setRippleColor(this.n);
        this.l.setCompatElevation(this.k);
        this.l.setCompatPressedTranslationZ(this.r);
        this.l.setId(R.id.hwfab_expand_menu_button);
        this.l.setSize(0);
        ColorStateList colorStateList = this.q;
        if (colorStateList != null) {
            this.l.setBackgroundTintList(colorStateList);
        }
        this.l.setOnClickListener(new a());
        addView(this.l, super.generateDefaultLayoutParams());
        this.h++;
    }

    private void a(int i, int i2) {
        int measuredWidth = i2 - (this.l.getMeasuredWidth() / 2);
        int i3 = i - this.j;
        boolean z = getLayoutDirection() == 1;
        if (z) {
            if (this.g == 0) {
                HwFloatingActionButton hwFloatingActionButton = this.l;
                int i4 = this.d;
                hwFloatingActionButton.layout(i4, i3, hwFloatingActionButton.getMeasuredWidth() + i4, this.l.getMeasuredHeight() + i3);
            } else {
                HwFloatingActionButton hwFloatingActionButton2 = this.l;
                hwFloatingActionButton2.layout(measuredWidth, i3, hwFloatingActionButton2.getMeasuredWidth() + measuredWidth, this.l.getMeasuredHeight() + i3);
            }
        } else {
            HwFloatingActionButton hwFloatingActionButton3 = this.l;
            hwFloatingActionButton3.layout(measuredWidth, i3, hwFloatingActionButton3.getMeasuredWidth() + measuredWidth, this.l.getMeasuredHeight() + i3);
        }
        a(i2, z, i2 - ((this.i / 2) + this.e), i);
    }

    private void a(int i, boolean z, int i2, int i3) {
        int i4 = (i3 - this.b) - this.j;
        for (int i5 = this.h - 1; i5 >= 0; i5--) {
            View childAt = getChildAt(i5);
            if (childAt != this.l && childAt.getVisibility() != 8 && childAt != this.s && !(childAt instanceof HwTextView)) {
                int measuredWidth = i - (childAt.getMeasuredWidth() / 2);
                int measuredHeight = i4 - childAt.getMeasuredHeight();
                if (z) {
                    childAt.layout((this.x - measuredWidth) - childAt.getMeasuredWidth(), measuredHeight, this.x - measuredWidth, childAt.getMeasuredHeight() + measuredHeight);
                } else {
                    childAt.layout(measuredWidth, measuredHeight, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + measuredHeight);
                }
                Object tag = childAt.getTag(R.id.hwfab_label);
                if (tag instanceof HwTextView) {
                    HwTextView hwTextView = (HwTextView) tag;
                    int measuredWidth2 = i2 - hwTextView.getMeasuredWidth();
                    if (measuredWidth2 <= 0) {
                        measuredWidth2 = 0;
                    }
                    int measuredHeight2 = ((childAt.getMeasuredHeight() - hwTextView.getMeasuredHeight()) / 2) + measuredHeight;
                    if (z) {
                        hwTextView.layout((this.x - measuredWidth2) - hwTextView.getMeasuredWidth(), measuredHeight2, this.x - measuredWidth2, hwTextView.getMeasuredHeight() + measuredHeight2);
                    } else {
                        hwTextView.layout(measuredWidth2, measuredHeight2, i2, hwTextView.getMeasuredHeight() + measuredHeight2);
                    }
                }
                i4 = measuredHeight - this.b;
            }
        }
    }
}
