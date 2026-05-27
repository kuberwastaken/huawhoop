package com.huawei.phoneservice.feedback.photolibrary.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.phoneservice.faq.base.util.h;

/* JADX INFO: loaded from: classes6.dex */
public class BadgeHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8570a;
    private float b;
    private final RectF c;
    private int d;
    private Paint e;
    private int f;
    private int g;
    private boolean j;

    public void setBadgeNumber(int i) {
        this.d = i;
        if (this.j) {
            setVisibility(i == 0 ? 4 : 0);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = this.f;
        if (i4 <= 0 || (i3 = this.g) <= 0) {
            throw new IllegalStateException("如果你自定义了小红点的宽高,就不能设置其宽高小于0!");
        }
        setMeasuredDimension(i4, i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.c;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getWidth();
        this.c.bottom = getHeight();
        canvas.drawRoundRect(this.c, getWidth() / 2.0f, getWidth() / 2.0f, this.e);
    }

    public BadgeHelper e(boolean z, boolean z2) throws Throwable {
        if (!z && z2) {
            h.d("BadgeHelper", "只有重叠模式isOverlap=true时，设置mIgnoreTargetPadding才生效");
        }
        return this;
    }

    public BadgeHelper b(boolean z) {
        return e(z, false);
    }

    public BadgeHelper ckY_(View view) {
        a();
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view == null) {
            return this;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            ckX_(view, viewGroup, iIndexOfChild);
            this.j = true;
        } else if (view.getParent() == null) {
            throw new IllegalStateException("目标View不能没有父布局!");
        }
        setVisibility(this.d == 0 ? 4 : 0);
        return this;
    }

    private void ckX_(View view, ViewGroup viewGroup, int i) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        frameLayout.setLayoutParams(layoutParams);
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        viewGroup.addView(frameLayout, i, layoutParams);
        frameLayout.addView(view);
        frameLayout.addView(this);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams2.gravity = 8388661;
        setLayoutParams(layoutParams2);
    }

    private void a() {
        this.b = getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e.setFlags(1);
        this.e.setColor(this.f8570a);
        this.g = Math.round(this.b * 7.0f);
        this.f = Math.round(this.b * 7.0f);
    }

    public BadgeHelper(Context context) {
        super(context);
        this.c = new RectF();
        this.f8570a = -2936293;
    }
}
