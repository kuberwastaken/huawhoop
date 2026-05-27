package com.huawei.ui.commonui.scrollview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Scroller;
import androidx.core.view.GestureDetectorCompat;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.ui.commonui.R$color;
import defpackage.mgx;
import defpackage.nwp;
import health.compact.a.LanguageUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ScrollScaleView extends View {
    private static final int e = Color.rgb(251, 101, 34);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9307a;
    private Paint aa;
    private float ab;
    private int ac;
    private int ad;
    private int ae;
    private int ag;
    private Scroller ah;
    private int ai;
    private int b;
    protected int c;
    private int d;
    private int f;
    private GestureDetectorCompat g;
    private List<String> h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private float r;
    private float s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private OnSelectedListener y;
    private int z;

    public interface OnSelectedListener {
        void onSelected(List<String> list, int i);
    }

    public ScrollScaleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = true;
        this.ac = 24;
        int i2 = e;
        this.ag = i2;
        this.d = i2;
        this.ai = 10;
        this.l = true;
        this.j = true;
        this.p = true;
        this.w = -1;
        this.z = 10;
        this.n = true;
        this.f9307a = context;
        this.f = context.getResources().getColor(R$color.scale_unselected_color);
        Paint paint = new Paint(1);
        this.aa = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aa.setColor(-16777216);
        this.g = new GestureDetectorCompat(getContext(), new a());
        this.ah = new Scroller(getContext());
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 40; i3++) {
            arrayList.add(Integer.toString(i3));
        }
        c(arrayList, 5, 40);
        this.j = false;
        this.i = true;
    }

    public void setCustomStartColor(int i) {
        this.d = i;
        this.ag = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i = this.ai / 2;
        int i2 = this.ae / 2;
        int i3 = 1;
        while (i3 <= i + 1 && i3 <= i2) {
            int i4 = this.c;
            int i5 = i4 - i3;
            int i6 = i5 < 0 ? (this.ae + i4) - i3 : i5;
            if (this.j || i5 >= 0) {
                cQF_(canvas, i6, -i3, 0, true);
            }
            int i7 = this.c;
            int i8 = this.ae;
            int i9 = i7 + i3;
            int i10 = i9 >= i8 ? i9 - i8 : i9;
            if (this.j) {
                cQF_(canvas, i10, i3, 0, true);
            } else if (i9 < i8) {
                cQF_(canvas, i10, i3, 0, true);
            }
            i3++;
        }
        int i11 = this.c;
        if (i11 - 3 > 0) {
            cQF_(canvas, i11, -3, 1, false);
        }
        int i12 = this.c;
        if (i12 - 2 > 0) {
            cQF_(canvas, i12, -2, 2, false);
        }
        int i13 = this.c;
        if (i13 - 1 > 0) {
            cQF_(canvas, i13, -1, 3, false);
        }
        cQF_(canvas, this.c, 0, 4, true);
        int i14 = this.c;
        if (i14 + 1 < this.ae) {
            cQF_(canvas, i14, 1, 3, false);
        }
        int i15 = this.c;
        if (i15 + 2 < this.ae) {
            cQF_(canvas, i15, 2, 2, false);
        }
        int i16 = this.c;
        if (i16 + 3 < this.ae) {
            cQF_(canvas, i16, 3, 1, false);
        }
    }

    public void setNoScroll(boolean z) {
        this.p = z;
        if (z) {
            int color = this.d;
            if (color == 0) {
                color = this.f9307a.getResources().getColor(R$color.scale_selected_color);
            }
            this.ag = color;
        } else {
            this.ag = -7829368;
        }
        invalidate();
    }

    private void cQF_(Canvas canvas, int i, int i2, int i3, boolean z) {
        this.aa.setTextAlign(Paint.Align.CENTER);
        this.aa.setTextSize(this.ac);
        int i4 = this.b;
        int i5 = this.q;
        float f = i4 + (i2 * i5) + (i5 / 2);
        float f2 = this.ab;
        c(i2);
        cQH_(canvas, f + f2, i3, i, z);
    }

    private void cQH_(Canvas canvas, float f, int i, int i2, boolean z) {
        if (i == 0) {
            cQG_(canvas, f);
        } else if (i == 1) {
            cQE_(canvas, f, 5, 32);
        } else if (i == 2) {
            cQE_(canvas, f, 6, 30);
        } else if (i == 3) {
            cQE_(canvas, f, 7, 28);
        } else if (i == 4) {
            cQE_(canvas, f, 10, 25);
        }
        if (i2 % this.z == 0 && z) {
            Context context = BaseApplication.getContext();
            this.aa.setTextSize(nwp.a(context, 11.0f));
            int i3 = this.z;
            if (i3 <= 0) {
                return;
            }
            int i4 = i2 / i3;
            if (this.n && mgx.a(this.h, i4)) {
                canvas.drawText(this.h.get(i4), f, nwp.a(context, 23.0f), this.aa);
            }
        }
    }

    private void cQG_(Canvas canvas, float f) {
        Context context = BaseApplication.getContext();
        int iA = nwp.a(context, 1.0f);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(iA);
        paint.setColor(this.f);
        int i = (int) f;
        int i2 = iA / 2;
        Point point = new Point(i, nwp.a(context, 33.0f) + i2);
        Point point2 = new Point(i, nwp.a(context, 43.0f) - i2);
        canvas.drawLine(point.x, point.y, point2.x, point2.y, paint);
    }

    private void cQE_(Canvas canvas, float f, int i, int i2) {
        Context context = BaseApplication.getContext();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.ag);
        paint.setStrokeWidth(i);
        int i3 = i / 2;
        int i4 = (int) f;
        Point point = new Point(i4, nwp.a(context, i2) + i3);
        Point point2 = new Point(i4, nwp.a(context, 43.0f) - i3);
        float f2 = i3;
        canvas.drawCircle(point.x, point.y, f2, paint);
        canvas.drawCircle(point2.x, point2.y, f2, paint);
        canvas.drawLine(point.x, point.y, point2.x, point2.y, paint);
    }

    private void c(int i) {
        int iD = this.f;
        if (i == -1 || i == 1) {
            if ((i != -1 || this.ab >= 0.0f) && (i != 1 || this.ab <= 0.0f)) {
                iD = d(this.ag, this.f, (this.q - Math.abs(this.ab)) / this.q);
            }
        } else if (i == 0) {
            iD = d(this.ag, this.f, Math.abs(this.ab) / this.q);
        }
        this.aa.setColor(iD);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.ad = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.v = measuredHeight;
        int i3 = this.ai;
        this.t = measuredHeight / i3;
        int i4 = this.ad / i3;
        this.q = i4;
        this.b = (i3 / 2) * i4;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        this.g.onTouchEvent(motionEvent);
        if (!this.p) {
            return false;
        }
        boolean z = this.n;
        this.n = true;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            cQI_(motionEvent, !z);
        } else if (actionMasked == 1) {
            if (this.k) {
                this.s = motionEvent.getX();
            } else {
                this.r = motionEvent.getY();
            }
            c();
        } else if (actionMasked == 2) {
            if (this.k) {
                if (Math.abs(motionEvent.getX() - this.s) < 0.1f) {
                    return true;
                }
                this.ab += motionEvent.getX() - this.s;
                this.s = motionEvent.getX();
            } else {
                if (Math.abs(motionEvent.getY() - this.r) < 0.1f) {
                    return true;
                }
                this.ab += motionEvent.getY() - this.r;
                this.r = motionEvent.getY();
            }
            b();
            invalidate();
        }
        return true;
    }

    private void cQI_(MotionEvent motionEvent, boolean z) {
        ViewParent parent;
        if (this.i && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        a();
        if (this.k) {
            this.s = motionEvent.getX();
        } else {
            this.r = motionEvent.getY();
        }
        if (z) {
            this.w = -1;
            e();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.ah.computeScrollOffset()) {
            if (this.k) {
                this.ab = (this.ab + this.ah.getCurrX()) - this.u;
                this.u = this.ah.getCurrX();
            } else {
                this.ab = (this.ab + this.ah.getCurrY()) - this.x;
                this.x = this.ah.getCurrY();
            }
            b();
            invalidate();
            return;
        }
        if (this.o) {
            this.o = false;
            c();
        } else if (this.m) {
            this.m = false;
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.o = false;
        this.m = false;
        this.ah.abortAnimation();
    }

    private void b() {
        int i;
        if (this.k) {
            i = this.q;
        } else {
            i = this.t;
        }
        float f = this.ab;
        float f2 = i;
        if (f >= f2) {
            int i2 = this.c - 1;
            this.c = i2;
            if (i2 < 0) {
                if (this.j) {
                    this.c = this.ae - 1;
                    this.ab = 0.0f;
                } else {
                    this.c = 0;
                    this.ab = f2;
                    d();
                }
            } else {
                this.ab = 0.0f;
            }
        } else {
            float f3 = -i;
            if (f <= f3) {
                int i3 = this.c + 1;
                this.c = i3;
                int i4 = this.ae;
                if (i3 >= i4) {
                    if (this.j) {
                        this.c = 0;
                        this.ab = 0.0f;
                    } else {
                        this.c = i4 - 1;
                        this.ab = f3;
                        d();
                    }
                } else {
                    this.ab = 0.0f;
                }
            }
        }
        e();
    }

    private void d() {
        if (this.o) {
            this.ah.forceFinished(true);
        }
        if (this.m) {
            e(this.ab, 0);
        }
    }

    private void c() {
        int i;
        if (!this.ah.isFinished() || this.o) {
            return;
        }
        a();
        if (this.k) {
            i = this.q;
        } else {
            i = this.t;
        }
        LogUtil.b("ScrollScaleView", "value", Integer.toString(i));
        float f = this.ab;
        if (f > 0.0f) {
            if (f < ((float) (((double) i) / 2.0d))) {
                e(f, 0);
                return;
            } else {
                e(f, i);
                return;
            }
        }
        if ((-f) < ((float) (((double) i) / 2.0d))) {
            e(f, 0);
        } else {
            e(f, -i);
        }
    }

    private void e(float f, int i) {
        if (this.k) {
            int i2 = (int) f;
            this.u = i2;
            this.m = true;
            this.ah.startScroll(i2, 0, 0, 0);
            this.ah.setFinalX(i);
            invalidate();
            return;
        }
        int i3 = (int) f;
        this.x = i3;
        this.m = true;
        this.ah.startScroll(0, i3, 0, 0);
        this.ah.setFinalY(i);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(float f, float f2) {
        if (this.k) {
            int i = (int) f;
            this.u = i;
            this.o = true;
            int i2 = this.q;
            this.ah.fling(i, 0, (int) f2, 0, i2 * (-1000), i2 * 1000, 0, 0);
            invalidate();
            return;
        }
        int i3 = (int) f;
        this.x = i3;
        this.o = true;
        int i4 = this.t;
        this.ah.fling(0, i3, 0, (int) f2, 0, 0, i4 * (-10), i4 * 10);
        invalidate();
    }

    private void e() {
        int i = this.w;
        int i2 = this.c;
        if (i == i2) {
            return;
        }
        this.w = i2;
        if (this.y != null) {
            if (LanguageUtil.ay(this.f9307a)) {
                this.y.onSelected(this.h, ((this.h.size() - 1) * this.z) - this.c);
                return;
            }
            this.y.onSelected(this.h, this.c);
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!ScrollScaleView.this.l) {
                return true;
            }
            ScrollScaleView.this.a();
            if (ScrollScaleView.this.k) {
                ScrollScaleView scrollScaleView = ScrollScaleView.this;
                scrollScaleView.d(scrollScaleView.ab, f);
                return true;
            }
            ScrollScaleView scrollScaleView2 = ScrollScaleView.this;
            scrollScaleView2.d(scrollScaleView2.ab, f2);
            return true;
        }
    }

    private void c(List<String> list, int i, int i2) {
        if (list == null) {
            this.h = new ArrayList();
        }
        LogUtil.b("ScrollScaleView", "ratio = ", Integer.valueOf(i), "; avaliablecount=", Integer.valueOf(i2));
        if (!LanguageUtil.ay(this.f9307a)) {
            LogUtil.b("ScrollScaleView", "is not RT language");
            this.h = list;
        } else if (list != null) {
            this.h = a(list);
        }
        this.z = i;
        List<String> list2 = this.h;
        if (list2 == null || list2.size() == 0) {
            this.h = new ArrayList();
            this.ae = 0;
        } else {
            this.ae = ((this.h.size() - 1) * i) + 1;
        }
        LogUtil.b("ScrollScaleView", "mSumScale==", Integer.valueOf(this.ae));
        this.ai = i2;
        if (i2 < 0) {
            this.ai = 0;
        }
        invalidate();
    }

    public void setData(List<String> list, int i, int i2) {
        if (list == null) {
            this.h = new ArrayList();
        }
        if (!LanguageUtil.ay(this.f9307a)) {
            this.h = list;
        } else if (list != null) {
            this.h = a(list);
        }
        this.z = i;
        List<String> list2 = this.h;
        if (list2 == null || list2.size() == 0) {
            this.h = new ArrayList();
            this.ae = 0;
        } else {
            this.ae = ((this.h.size() - 1) * i) + 1;
        }
        this.ai = i2;
        if (i2 < 0) {
            this.ai = 0;
        }
        invalidate();
    }

    private List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayList.add(list.get(size));
        }
        return arrayList;
    }

    public void setSelectedPosition(int i) {
        if (LanguageUtil.ay(this.f9307a)) {
            i = ((this.h.size() - 1) * this.z) - i;
        }
        if (i < 0 || i > this.ae - 1 || i == this.c) {
            return;
        }
        this.c = i;
        invalidate();
        e();
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.y = onSelectedListener;
    }

    private int d(int i, int i2, float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.argb(Math.round(Color.alpha(i) + ((Color.alpha(i2) - Color.alpha(i)) * f)), Math.round(Color.red(i) + ((Color.red(i2) - Color.red(i)) * f)), Math.round(Color.green(i) + ((Color.green(i2) - Color.green(i)) * f)), Math.round(Color.blue(i) + ((Color.blue(i2) - Color.blue(i)) * f)));
    }

    public void setIsShowText(boolean z) {
        this.n = z;
    }

    public boolean getIsShowText() {
        return this.n;
    }

    public int getSumScale() {
        return this.ae;
    }
}
