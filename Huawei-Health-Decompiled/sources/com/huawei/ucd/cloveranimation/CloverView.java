package com.huawei.ucd.cloveranimation;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.media3.common.C;
import com.huawei.health.R;
import com.huawei.hms.ads.jsb.constant.Constant;
import defpackage.pcc;
import defpackage.pcd;
import defpackage.pce;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class CloverView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AddFrameListener f9082a;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private int ae;
    private RectF af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private float aj;
    private float ak;
    private float al;
    private float am;
    private float an;
    private float ao;
    private float ap;
    private pce aq;
    private float ar;
    private float as;
    private float at;
    private float au;
    private float av;
    private ValueAnimator aw;
    private float ax;
    private float ay;
    private float az;
    private int b;
    private float ba;
    private float bb;
    private ValueAnimator bc;
    private Paint bd;
    private Handler be;
    private float bf;
    private float bg;
    private float bh;
    private float bi;
    private float bj;
    private Paint bk;
    private Bitmap bl;
    private Paint bm;
    private float bn;
    private ValueAnimator bo;
    private float bp;
    private float bq;
    private float br;
    private float bs;
    private float bt;
    private Bitmap[] bu;
    private ValueAnimator bv;
    private int bw;
    private float bx;
    private Bitmap[] by;
    private float bz;
    private boolean c;
    private float ca;
    private Bitmap[] cb;
    private float cc;
    private float cd;
    private ValueAnimator ce;
    private float cf;
    private float cg;
    private AddFrameListener ch;
    private Runnable ci;
    private OnPetalClickListener cl;
    private float d;
    private AddFrameListener e;
    private boolean f;
    private boolean g;
    private float h;
    private float i;
    private Runnable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public interface OnPetalClickListener {
        void onLeftClick();

        void onRightClick();

        void onTopClick();
    }

    static /* synthetic */ int e(CloverView cloverView) {
        int i = cloverView.bw;
        cloverView.bw = i + 1;
        return i;
    }

    public void setPetalClickListener(OnPetalClickListener onPetalClickListener) {
        this.cl = onPetalClickListener;
    }

    public void setMaxOutsideScale(float f) {
        if (f < 0.88f) {
            this.cf = 0.88f;
        } else {
            this.cf = f;
        }
    }

    public void setDefaultOutsideScale() {
        this.cf = 0.88f;
    }

    public CloverView(Context context) {
        this(context, null);
    }

    public CloverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0.58f;
        this.bg = 1.0f;
        this.ar = 1.0f;
        this.an = 1.0f;
        this.at = 0.0f;
        this.ao = 0.0f;
        this.ap = 0.0f;
        this.as = 0.0f;
        this.bs = 0.0f;
        this.bt = 0.0f;
        this.bx = 0.0f;
        this.al = 0.0f;
        this.aj = 0.0f;
        this.am = 0.0f;
        this.ca = 0.0f;
        this.bh = 0.0f;
        this.bq = 0.0f;
        this.ak = 0.0f;
        this.bz = 0.0f;
        this.bf = 0.0f;
        this.bp = 0.0f;
        this.cd = 0.0f;
        this.bj = 0.0f;
        this.bn = 0.0f;
        this.ay = 0.0f;
        this.br = 1.0f;
        this.av = 0.0f;
        this.ba = 1.0f;
        this.ax = 0.0f;
        this.az = 1.0f;
        this.au = 0.0f;
        this.bb = 1.0f;
        this.ac = false;
        this.s = false;
        this.p = false;
        this.n = false;
        this.m = false;
        this.q = false;
        this.x = true;
        this.o = false;
        this.k = false;
        this.w = false;
        this.bw = 0;
        this.bu = null;
        this.by = null;
        this.cb = null;
        this.aa = false;
        this.t = false;
        this.ad = false;
        this.ah = false;
        this.ag = false;
        this.ai = false;
        this.l = false;
        this.ab = true;
        this.y = true;
        this.r = false;
        this.b = 1;
        this.v = false;
        this.f = false;
        this.z = false;
        this.cf = 0.88f;
        this.c = false;
        this.ci = new Runnable() { // from class: com.huawei.ucd.cloveranimation.CloverView.5
            @Override // java.lang.Runnable
            public void run() {
                CloverView.this.aa = true;
                if (CloverView.this.bw >= 119) {
                    CloverView.this.aa = false;
                    return;
                }
                CloverView.this.be.postDelayed(CloverView.this.ci, 17L);
                if (CloverView.this.r) {
                    CloverView.this.postInvalidate();
                    CloverView.e(CloverView.this);
                }
            }
        };
        this.j = new Runnable() { // from class: com.huawei.ucd.cloveranimation.CloverView.2
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap[] bitmapArrCGo_;
                final Bitmap[] bitmapArrCGo_2;
                final Bitmap[] bitmapArrCGo_3;
                if (CloverView.this.b == 120) {
                    bitmapArrCGo_ = CloverView.this.cGd_(CloverView.this.cGc_(R.drawable._2131428594_res_0x7f0b04f2));
                    bitmapArrCGo_2 = CloverView.this.cGd_(CloverView.this.cGc_(R.drawable._2131428592_res_0x7f0b04f0));
                    bitmapArrCGo_3 = CloverView.this.cGd_(CloverView.this.cGc_(R.drawable._2131428593_res_0x7f0b04f1));
                } else {
                    bitmapArrCGo_ = CloverView.this.cGo_(R.drawable._2131428603_res_0x7f0b04fb);
                    bitmapArrCGo_2 = CloverView.this.cGo_(R.drawable._2131428601_res_0x7f0b04f9);
                    bitmapArrCGo_3 = CloverView.this.cGo_(R.drawable._2131428602_res_0x7f0b04fa);
                }
                CloverView.this.be.post(new Runnable() { // from class: com.huawei.ucd.cloveranimation.CloverView.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        CloverView.this.bu = bitmapArrCGo_;
                        CloverView.this.by = bitmapArrCGo_2;
                        CloverView.this.cb = bitmapArrCGo_3;
                        CloverView.this.r = true;
                        CloverView.this.postInvalidate();
                        if (CloverView.this.f9082a != null) {
                            CloverView.this.f9082a.onFinished();
                        }
                    }
                });
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100910_res_0x7f0604ee, R.attr._2131100913_res_0x7f0604f1});
        this.g = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.u = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        f();
    }

    private void l() {
        this.bg = Math.min(getWidth(), getHeight()) / (Math.max(this.aq.g(), this.aq.h()) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap[] cGd_(Bitmap bitmap) {
        Bitmap[] bitmapArr = new Bitmap[this.b];
        Matrix matrix = new Matrix();
        if (this.bg <= 0.0f) {
            l();
        }
        float f = this.bg;
        if (f <= 0.0f) {
            for (int i = 0; i < this.b; i++) {
                bitmapArr[i] = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
            }
        } else {
            matrix.preScale(f, f);
            int width = bitmap.getWidth() / 10;
            int height = bitmap.getHeight() / 12;
            for (int i2 = 0; i2 < this.b; i2++) {
                try {
                    bitmapArr[i2] = Bitmap.createBitmap(bitmap, ((i2 % 10) * bitmap.getWidth()) / 10, ((i2 / 10) * bitmap.getHeight()) / 12, width, height, matrix, true);
                } catch (IllegalArgumentException | OutOfMemoryError unused) {
                    bitmapArr[i2] = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
                }
            }
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap[] cGo_(int i) {
        Bitmap[] bitmapArr = new Bitmap[this.b];
        Bitmap bitmapCGc_ = cGc_(i);
        Matrix matrix = new Matrix();
        if (this.bg <= 0.0f) {
            l();
        }
        float f = this.bg;
        if (f <= 0.0f) {
            bitmapArr[0] = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
        } else {
            matrix.preScale(f, f);
            try {
                bitmapArr[0] = Bitmap.createBitmap(bitmapCGc_, 0, 0, bitmapCGc_.getWidth(), bitmapCGc_.getHeight(), matrix, true);
            } catch (IllegalArgumentException | OutOfMemoryError unused) {
                bitmapArr[0] = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
            }
        }
        if (bitmapCGc_ != null && !bitmapCGc_.isRecycled()) {
            bitmapCGc_.recycle();
        }
        return bitmapArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap cGc_(int i) {
        byte[] bArrC;
        int memoryClass = ((ActivityManager) getContext().getSystemService("activity")).getMemoryClass();
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (memoryClass < 32) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        options.inPurgeable = true;
        options.inInputShareable = true;
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getResources().openRawResource(i), null, options);
        if ((bitmapDecodeStream == null || bitmapDecodeStream.getWidth() <= 0 || bitmapDecodeStream.getHeight() <= 0) && (bArrC = c(getResources().openRawResource(i))) != null) {
            bitmapDecodeStream = BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length);
        }
        return (bitmapDecodeStream == null || bitmapDecodeStream.getWidth() <= 0 || bitmapDecodeStream.getHeight() <= 0) ? Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888) : bitmapDecodeStream;
    }

    private byte[] c(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public void setAddFrameListener(AddFrameListener addFrameListener) {
        this.f9082a = addFrameListener;
    }

    public void setAnimEndListener(AddFrameListener addFrameListener) {
        this.e = addFrameListener;
    }

    public void setValueEndListener(AddFrameListener addFrameListener) {
        this.ch = addFrameListener;
    }

    public void setContentsRunIcon(boolean z) {
        this.l = z;
    }

    public void setInvalid(boolean z) {
        this.x = z;
        invalidate();
    }

    public void setAllFull(boolean z) {
        this.f = z;
    }

    public void setPlayRunAnimAnimator(boolean z) {
        this.ab = z;
    }

    public void setPlayEncourageAnimAnimator(boolean z) {
        this.y = z;
    }

    public pce getCloverData() {
        return this.aq;
    }

    private void f() {
        this.aq = new pce();
        this.bm = new Paint(1);
        this.af = new RectF();
        this.b = 1;
        if (this.u || this.g) {
            this.bk = new Paint(1);
            this.bd = new Paint(1);
            this.be = new Handler();
            int iMax = Math.max((int) this.aq.g(), (int) this.aq.h()) * 2;
            this.bi = (iMax / 2.0f) - (this.aq.g() / 2.0f);
            if (this.g) {
                this.bl = Bitmap.createBitmap(iMax, iMax, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.bl);
                this.bk.setColor(-16777216);
                this.bk.setFilterBitmap(true);
                canvas.save();
                canvas.translate(this.bi, 0.0f);
                canvas.drawPath(this.aq.cFp_(), this.bk);
                canvas.restore();
                this.bk.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            }
        }
        if (this.g) {
            return;
        }
        setMaxOutsideScale(1.0f);
    }

    private void i() {
        new Thread(this.j).start();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        float f = i;
        float f2 = i2;
        this.af.set(0.0f, 0.0f, f, f2);
        if (i >= i2) {
            this.d = 0.58f;
        } else {
            this.d = (((i2 - i) / 2.0f) + (0.58f * f)) / f2;
        }
        this.cc = (f / 2.0f) - (this.aq.g() / 2.0f);
        this.cg = (f2 * this.d) - this.aq.h();
        this.bg = Math.min(i, i2) / (Math.max(this.aq.g(), this.aq.h()) * 2.0f);
        if (this.u) {
            i();
        }
        if (this.g) {
            this.b = 120;
            i();
        }
    }

    private void h() {
        this.ca = 0.0f;
        this.bh = 0.0f;
        this.bq = 0.0f;
        this.at = 1.0f;
        this.ar = 1.0f;
        this.al = 1.0f;
        this.aj = 1.0f;
        this.am = 1.0f;
        this.an = 1.0f;
        this.bz = 0.0f;
        this.bf = 0.0f;
        this.bp = 0.0f;
        this.bs = 1.0f;
        this.bt = 1.0f;
        this.bx = 1.0f;
        this.ay = 0.0f;
        this.br = 1.0f;
        this.av = 0.0f;
        this.ba = 1.0f;
        this.ax = 0.0f;
        this.az = 1.0f;
        this.au = 0.0f;
        this.bb = 1.0f;
        this.s = false;
        this.p = false;
    }

    public void setCutValuesWithAnim(float f, float f2, float f3) {
        j();
        h();
        if (Float.compare(f, this.ca) != 0 || Float.compare(f2, this.bh) != 0 || Float.compare(f3, this.bq) != 0) {
            this.ah = false;
            this.ag = false;
            this.ai = false;
            if (f != this.ca) {
                this.ag = true;
            }
            if (f2 != this.bh) {
                this.ah = true;
            }
            if (f3 != this.bq) {
                this.ai = true;
            }
            this.n = true;
            this.m = true;
            this.q = true;
            if (this.ah || this.ag || this.ai) {
                b();
            }
            this.ac = true;
            c(f, f2, f3);
            return;
        }
        invalidate();
    }

    public void setValuesWithAnim(float f, float f2, float f3, AddFrameListener addFrameListener) {
        if (this.t) {
            this.e = addFrameListener;
        } else {
            this.e = null;
            setValuesWithAnim(f, f2, f3);
        }
    }

    public void setValuesWithAnim(float f, float f2, float f3) {
        if (this.t) {
            return;
        }
        j();
        if (Float.compare(f, this.ca) == 0 && Float.compare(f2, this.bh) == 0 && Float.compare(f3, this.bq) == 0) {
            return;
        }
        this.ah = false;
        this.ag = false;
        this.ai = false;
        if (f != this.ca) {
            this.ag = true;
        }
        if (f2 != this.bh) {
            this.ah = true;
        }
        if (f3 != this.bq) {
            this.ai = true;
        }
        this.n = true;
        this.m = true;
        this.q = true;
        if (this.ah || this.ag || this.ai) {
            b();
        }
        this.ac = true;
        c(f, f2, f3);
    }

    public void d(float f) {
        this.ak = f;
        this.k = true;
        this.y = true;
        this.ab = true;
        this.l = true;
        e(f, f, f);
    }

    public void d() {
        this.k = false;
        j();
    }

    public void e(final float f, final float f2, final float f3) {
        j();
        this.t = true;
        this.ac = false;
        c();
        this.ca = f;
        this.bh = f2;
        this.bq = f3;
        k();
        b(f, f2, f3);
        this.be.postDelayed(new Runnable() { // from class: com.huawei.ucd.cloveranimation.CloverView.4
            @Override // java.lang.Runnable
            public void run() {
                CloverView.this.ah = false;
                CloverView.this.ag = false;
                CloverView.this.ai = false;
                if (f > 0.0f) {
                    CloverView.this.ag = true;
                }
                if (f2 > 0.0f) {
                    CloverView.this.ah = true;
                }
                if (f3 > 0.0f) {
                    CloverView.this.ai = true;
                }
                if (CloverView.this.ah || CloverView.this.ag || CloverView.this.ai) {
                    CloverView.this.b();
                }
            }
        }, 400L);
    }

    private void j() {
        ValueAnimator valueAnimator = this.bo;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.bo.cancel();
            this.bo.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.bv;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.bv.cancel();
            this.bv.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.ce;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllListeners();
            this.ce.cancel();
            this.ce.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.bc;
        if (valueAnimator4 != null) {
            valueAnimator4.removeAllListeners();
            this.bc.cancel();
            this.bc.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.aw;
        if (valueAnimator5 != null) {
            valueAnimator5.removeAllListeners();
            this.aw.cancel();
            this.aw.removeAllUpdateListeners();
        }
    }

    public void setPlayAllFrameAnimation(boolean z) {
        this.w = z;
    }

    public void b() {
        if (!this.aa && this.ab && this.b == 120) {
            this.bw = 0;
            this.be.postDelayed(this.ci, 17L);
        }
    }

    public void c() {
        this.ca = 0.0f;
        this.bh = 0.0f;
        this.bq = 0.0f;
        this.ar = 0.0f;
        this.an = 0.0f;
        this.at = 0.0f;
        this.ao = 0.0f;
        this.ap = 0.0f;
        this.as = 0.0f;
        this.al = 0.0f;
        this.aj = 0.0f;
        this.am = 0.0f;
        this.cd = 0.0f;
        this.bj = 0.0f;
        this.bn = 0.0f;
        this.ay = 0.0f;
        this.br = 1.0f;
        this.av = 0.0f;
        this.ba = 1.0f;
        this.ax = 0.0f;
        this.az = 1.0f;
        this.au = 0.0f;
        this.bb = 1.0f;
        this.s = false;
        this.p = false;
        this.bs = 0.0f;
        this.bt = 0.0f;
        this.bx = 0.0f;
        this.n = true;
        this.m = true;
        this.q = true;
        this.x = false;
        this.o = true;
    }

    public void setValuesWithoutAnim(float f, float f2, float f3) {
        this.ca = f;
        this.bh = f2;
        this.bq = f3;
        this.ar = 1.0f;
        this.an = 1.0f;
        this.at = 1.0f;
        this.ao = 1.0f;
        this.ap = 1.0f;
        this.as = 1.0f;
        this.al = 1.0f;
        this.aj = 1.0f;
        this.am = 1.0f;
        this.cd = 1.0f;
        this.bj = 1.0f;
        this.bn = 1.0f;
        this.ay = 1.0f;
        this.br = 1.0f;
        this.av = 0.0f;
        this.ba = 1.0f;
        this.ax = 0.0f;
        this.az = 1.0f;
        this.au = 0.0f;
        this.bb = 1.0f;
        this.s = Float.compare(f, 1.0f) == 0 && Float.compare(f2, 1.0f) == 0 && Float.compare(f3, 1.0f) == 0;
        this.p = Float.compare(f, 1.0f) == 0 && Float.compare(f2, 1.0f) == 0 && Float.compare(f3, 1.0f) == 0;
        this.bs = 1.0f;
        this.bt = 1.0f;
        this.bx = 1.0f;
        this.n = false;
        this.m = false;
        this.q = false;
        this.x = false;
        this.o = false;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.bm.setShader(null);
        this.bm.setAlpha((int) (this.an * 255.0f));
        if (!this.s) {
            cFS_(canvas);
        }
        if (this.x) {
            return;
        }
        this.bm.setAlpha(255);
        if (this.p) {
            cFW_(canvas, this.ay);
            cFT_(canvas);
            cFR_(canvas, this.ay);
            cGb_(canvas, this.ay);
            cFX_(canvas, this.ba, this.av);
            cFX_(canvas, this.az, this.ax);
            cFX_(canvas, this.bb, this.au);
            cFY_(canvas, this.ba, this.av);
            cFY_(canvas, this.az, this.ax);
            cFY_(canvas, this.bb, this.au);
        } else {
            cFR_(canvas, 1.0f);
            cGb_(canvas, 1.0f);
            cFW_(canvas, 1.0f);
        }
        if (this.s && this.o) {
            cFN_(canvas);
            cFX_(canvas, this.ba, this.av);
            cFX_(canvas, this.az, this.ax);
            cFX_(canvas, this.bb, this.au);
            cFY_(canvas, this.ba, this.av);
            cFY_(canvas, this.az, this.ax);
            cFY_(canvas, this.bb, this.au);
        }
        cFO_(canvas);
    }

    private void cFZ_(Canvas canvas, int i, int i2, float f) {
        canvas.save();
        canvas.rotate((this.al * 90.0f) - 90.0f, getWidth() / 2.0f, getHeight() * this.d);
        this.bd.setAlpha((int) (this.bs * 255.0f));
        int i3 = (this.ca <= 0.0f || !this.ag) ? 0 : this.bw;
        if (this.w) {
            i3 = this.bw;
        }
        Bitmap bitmap = this.bu[i3];
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, (getWidth() - i) / 2.0f, ((getHeight() * this.d) - i2) - f, this.bd);
        canvas.restore();
    }

    public void b(boolean z) {
        this.z = z;
        if (z) {
            setValuesWithoutAnim(1.0f, 1.0f, 1.0f);
        } else {
            invalidate();
        }
    }

    private void cFT_(Canvas canvas) {
        if (this.g || !this.z) {
            return;
        }
        Paint paint = new Paint(1);
        canvas.save();
        Bitmap bitmapCGc_ = cGc_(R.drawable._2131431676_res_0x7f0b10fc);
        Matrix matrix = new Matrix();
        float fMin = Math.min(getWidth(), getHeight());
        float width = fMin / bitmapCGc_.getWidth();
        matrix.preScale(width, width);
        canvas.drawBitmap(Bitmap.createBitmap(bitmapCGc_, 0, 0, bitmapCGc_.getWidth(), bitmapCGc_.getHeight(), matrix, true), (getWidth() - fMin) / 2.0f, ((getHeight() * this.d) + (Math.min(getWidth(), getHeight()) * (1.0f - this.d))) - (r2.getHeight() * 0.95f), paint);
        canvas.restore();
    }

    private void cFP_(Canvas canvas, int i, int i2, float f) {
        int i3 = (this.bh <= 0.0f || !this.ah) ? 0 : this.bw;
        if (this.w) {
            i3 = this.bw;
        }
        if (this.cb[i3] == null) {
            return;
        }
        canvas.save();
        canvas.rotate((this.aj * 90.0f) - 90.0f, getWidth() / 2.0f, getHeight() * this.d);
        this.bd.setAlpha((int) (this.bt * 255.0f));
        canvas.drawBitmap(this.cb[i3], ((getWidth() / 2.0f) - i) - f, ((getHeight() * this.d) - (i2 * 0.211f)) + f, this.bd);
        canvas.restore();
    }

    private void cFU_(Canvas canvas, int i, float f) {
        int i2 = (this.bq <= 0.0f || !this.ai) ? 0 : this.bw;
        if (this.w) {
            i2 = this.bw;
        }
        if (this.by[i2] == null) {
            return;
        }
        canvas.save();
        canvas.rotate((this.am * 90.0f) - 90.0f, getWidth() / 2.0f, getHeight() * this.d);
        this.bd.setAlpha((int) (this.bx * 255.0f));
        canvas.drawBitmap(this.by[i2], (getWidth() / 2.0f) + f, ((getHeight() * this.d) - (i * 0.211f)) + f, this.bd);
        canvas.restore();
    }

    private void cFO_(Canvas canvas) {
        Bitmap[] bitmapArr;
        Bitmap bitmap;
        if (this.r) {
            if ((!this.l && !this.u) || (bitmapArr = this.bu) == null || (bitmap = bitmapArr[0]) == null) {
                return;
            }
            int width = bitmap.getWidth();
            int height = this.bu[0].getHeight();
            float height2 = getHeight() * 0.03f;
            cFZ_(canvas, width, height, height2);
            float f = height2 * 0.707f;
            cFU_(canvas, height, f);
            cFP_(canvas, width, height, f);
        }
    }

    private void cFW_(Canvas canvas, float f) {
        float f2 = this.bq;
        if (f2 <= 0.0f) {
            return;
        }
        if (f2 <= 0.3f) {
            f2 = 0.3f;
        }
        int iSaveLayer = canvas.saveLayer(this.af, null, 31);
        canvas.save();
        float f3 = this.cf;
        float f4 = this.as;
        float f5 = this.bg;
        float f6 = f2 * f3;
        float f7 = f4 * f6 * f5;
        if (this.ac) {
            f7 = this.bn * f6 * f5;
        }
        if (this.p) {
            f7 = f3 * f5 * f;
        }
        if (this.s) {
            f7 = f3 * f5 * this.br;
        }
        canvas.scale(f7, f7, getWidth() / 2.0f, getHeight() * this.d);
        canvas.translate(this.cc, this.cg);
        canvas.save();
        canvas.rotate((this.am * 90.0f) + 30.0f, this.aq.cFq_().x, this.aq.cFq_().y);
        setPetalPaintShader(this.aq.cFs_());
        if (this.f) {
            this.bm.setShader(this.aq.cFk_());
        } else {
            this.bm.setShader(this.aq.cFs_());
        }
        canvas.drawPath(this.aq.cFp_(), this.bm);
        canvas.restore();
        canvas.restore();
        cFV_(canvas);
        canvas.restoreToCount(iSaveLayer);
    }

    private void setPetalPaintShader(LinearGradient linearGradient) {
        if (this.f) {
            this.bm.setShader(this.aq.cFk_());
        } else {
            this.bm.setShader(linearGradient);
        }
    }

    private void cGb_(Canvas canvas, float f) {
        float f2 = this.ca;
        if (f2 <= 0.0f) {
            return;
        }
        if (f2 <= 0.3f) {
            f2 = 0.3f;
        }
        int iSaveLayer = canvas.saveLayer(this.af, null, 31);
        canvas.save();
        float f3 = this.cf;
        float f4 = this.ao;
        float f5 = this.bg;
        float f6 = f2 * f3;
        float f7 = f4 * f6 * f5;
        if (this.ac) {
            f7 = this.cd * f6 * f5;
        }
        if (this.p) {
            f7 = f3 * f5 * f;
        }
        if (this.s) {
            f7 = f3 * f5 * this.br;
        }
        canvas.scale(f7, f7, getWidth() / 2.0f, getHeight() * this.d);
        canvas.translate(this.cc, this.cg);
        canvas.save();
        canvas.rotate((this.al * 90.0f) - 90.0f, this.aq.cFq_().x, this.aq.cFq_().y);
        setPetalPaintShader(this.aq.cFo_());
        this.bm.setAlpha((int) (this.at * 255.0f));
        canvas.drawPath(this.aq.cFp_(), this.bm);
        canvas.restore();
        canvas.restore();
        cGa_(canvas);
        canvas.restoreToCount(iSaveLayer);
    }

    private void cFR_(Canvas canvas, float f) {
        float f2 = this.bh;
        if (f2 <= 0.0f) {
            return;
        }
        if (f2 <= 0.3f) {
            f2 = 0.3f;
        }
        float f3 = this.cf;
        float f4 = this.ap;
        float f5 = this.bg;
        float f6 = f2 * f3;
        float f7 = f4 * f6 * f5;
        if (this.ac) {
            f7 = this.bj * f6 * f5;
        }
        if (this.p) {
            f7 = f3 * f5 * f;
        }
        if (this.s) {
            f7 = f3 * f5 * this.br;
        }
        int iSaveLayer = canvas.saveLayer(this.af, null, 31);
        canvas.save();
        canvas.scale(f7, f7, getWidth() / 2.0f, getHeight() * this.d);
        canvas.translate(this.cc, this.cg);
        canvas.save();
        canvas.rotate((this.aj * 90.0f) - 210.0f, this.aq.cFq_().x, this.aq.cFq_().y);
        setPetalPaintShader(this.aq.cFm_());
        canvas.drawPath(this.aq.cFp_(), this.bm);
        canvas.restore();
        canvas.restore();
        cFQ_(canvas);
        canvas.restoreToCount(iSaveLayer);
    }

    private void setPetalBackgroundColor(LinearGradient linearGradient) {
        if (this.x) {
            this.bm.setShader(null);
            this.bm.setColor(this.aq.n());
        } else if (this.f) {
            this.bm.setShader(this.aq.cFj_());
        } else {
            this.bm.setShader(linearGradient);
        }
    }

    private void cFS_(Canvas canvas) {
        canvas.save();
        float f = this.ar * this.bg * this.cf;
        if (this.s || this.p) {
            f *= this.br;
        }
        canvas.scale(f, f, getWidth() / 2.0f, getHeight() * this.d);
        setPetalBackgroundColor(this.aq.cFl_());
        canvas.translate(this.cc, this.cg);
        canvas.save();
        canvas.rotate((this.ar * 60.0f) - 180.0f, this.aq.cFq_().x, this.aq.cFq_().y);
        canvas.drawPath(this.aq.cFp_(), this.bm);
        canvas.restore();
        canvas.save();
        canvas.rotate((this.ar * 60.0f) + 60.0f, this.aq.cFq_().x, this.aq.cFq_().y);
        setPetalBackgroundColor(this.aq.cFr_());
        canvas.drawPath(this.aq.cFp_(), this.bm);
        canvas.restore();
        canvas.rotate((this.ar * 60.0f) - 60.0f, this.aq.cFq_().x, this.aq.cFq_().y);
        setPetalBackgroundColor(this.aq.cFn_());
        canvas.drawPath(this.aq.cFp_(), this.bm);
        canvas.restore();
    }

    private void cGa_(Canvas canvas) {
        if (this.n) {
            canvas.save();
            float f = this.ar * this.bg * this.cf;
            float f2 = this.ao;
            float f3 = f2 > 1.0f ? f2 * f : f;
            float f4 = this.cd;
            if (f4 > 1.0f) {
                f3 = f * f4;
            }
            canvas.scale(f3, f3, getWidth() / 2.0f, getHeight() * this.d);
            canvas.translate(this.cc, this.cg);
            canvas.translate(-this.bi, 0.0f);
            canvas.rotate((this.ar * 60.0f) - 60.0f, this.bl.getWidth() / 2.0f, this.bl.getHeight() / 2.0f);
            canvas.drawBitmap(this.bl, 0.0f, 0.0f, this.bk);
            canvas.restore();
        }
    }

    private void cFQ_(Canvas canvas) {
        if (this.m) {
            canvas.save();
            float f = this.ar * this.bg * this.cf;
            float f2 = this.ap;
            float f3 = f2 > 1.0f ? f2 * f : f;
            float f4 = this.bj;
            if (f4 > 1.0f) {
                f3 = f * f4;
            }
            canvas.scale(f3, f3, getWidth() / 2.0f, getHeight() * this.d);
            canvas.translate(this.cc, this.cg);
            canvas.translate(-this.bi, 0.0f);
            canvas.rotate((this.ar * 60.0f) - 180.0f, this.bl.getWidth() / 2.0f, this.bl.getHeight() / 2.0f);
            canvas.drawBitmap(this.bl, 0.0f, 0.0f, this.bk);
            canvas.restore();
        }
    }

    private void cFV_(Canvas canvas) {
        if (this.q) {
            canvas.save();
            float f = this.ar * this.bg * this.cf;
            float f2 = this.as;
            float f3 = f2 > 1.0f ? f2 * f : f;
            float f4 = this.bn;
            if (f4 > 1.0f) {
                f3 = f * f4;
            }
            canvas.scale(f3, f3, getWidth() / 2.0f, getHeight() * this.d);
            canvas.translate(this.cc, this.cg);
            canvas.translate(-this.bi, 0.0f);
            canvas.rotate((this.ar * 60.0f) + 60.0f, this.bl.getWidth() / 2.0f, this.bl.getHeight() / 2.0f);
            canvas.drawBitmap(this.bl, 0.0f, 0.0f, this.bk);
            canvas.restore();
        }
    }

    private void cFX_(Canvas canvas, float f, float f2) {
        if (this.o && this.y) {
            canvas.save();
            float f3 = this.bg * this.cf * f;
            canvas.scale(f3, f3, getWidth() / 2.0f, getHeight() * this.d);
            if (this.p) {
                setPetalPaintShader(this.aq.cFm_());
            }
            if (this.s) {
                this.bm.setShader(this.aq.cFk_());
            }
            int i = (int) (f2 * 255.0f);
            this.bm.setAlpha(i);
            canvas.translate(this.cc, this.cg);
            canvas.save();
            canvas.rotate(-120.0f, this.aq.cFq_().x, this.aq.cFq_().y);
            canvas.drawPath(this.aq.cFp_(), this.bm);
            canvas.restore();
            canvas.save();
            canvas.rotate(120.0f, this.aq.cFq_().x, this.aq.cFq_().y);
            if (this.p) {
                setPetalPaintShader(this.aq.cFs_());
            }
            this.bm.setAlpha(i);
            canvas.drawPath(this.aq.cFp_(), this.bm);
            canvas.restore();
            canvas.rotate((this.ar * 60.0f) - 60.0f, this.aq.cFq_().x, this.aq.cFq_().y);
            if (this.p) {
                setPetalPaintShader(this.aq.cFo_());
            }
            this.bm.setAlpha(i);
            canvas.drawPath(this.aq.cFp_(), this.bm);
            canvas.restore();
        }
    }

    private void cFN_(Canvas canvas) {
        canvas.save();
        canvas.save();
        float f = this.cf * this.bg * this.ay * this.br;
        canvas.scale(f, f, getWidth() / 2.0f, getHeight() * this.d);
        canvas.translate(this.cc, this.cg);
        canvas.rotate(120.0f, this.aq.cFq_().x, this.aq.cFq_().y);
        this.bm.setShader(this.aq.cFk_());
        canvas.drawPath(this.aq.cFp_(), this.bm);
        canvas.restore();
        cFT_(canvas);
        float f2 = this.cf * this.bg * this.ay * this.br;
        canvas.scale(f2, f2, getWidth() / 2.0f, getHeight() * this.d);
        canvas.translate(this.cc, this.cg);
        canvas.rotate(-120.0f, this.aq.cFq_().x, this.aq.cFq_().y);
        this.bm.setShader(this.aq.cFk_());
        canvas.drawPath(this.aq.cFp_(), this.bm);
        canvas.restore();
        canvas.save();
        float f3 = this.cf * this.bg * this.ay * this.br;
        canvas.scale(f3, f3, getWidth() / 2.0f, getHeight() * this.d);
        canvas.translate(this.cc, this.cg);
        this.bm.setShader(this.aq.cFk_());
        this.bm.setAlpha((int) (this.at * 255.0f));
        canvas.drawPath(this.aq.cFp_(), this.bm);
        canvas.restore();
    }

    private void cFY_(Canvas canvas, float f, float f2) {
        if (this.o && this.y) {
            this.bm.setStrokeWidth(4.0f);
            this.bm.setStyle(Paint.Style.STROKE);
            if (this.s) {
                this.bm.setShader(this.aq.cFk_());
            }
            if (this.p) {
                setPetalPaintShader(this.aq.cFm_());
            }
            this.bm.setAlpha((int) (f2 * 255.0f));
            canvas.save();
            float f3 = this.cf * this.bg * f;
            canvas.scale(f3, f3, getWidth() / 2.0f, getHeight() * this.d);
            canvas.translate(this.cc, this.cg);
            canvas.rotate(-120.0f, this.aq.cFq_().x, this.aq.cFq_().y);
            canvas.drawPath(this.aq.cFp_(), this.bm);
            canvas.restore();
            canvas.save();
            if (this.p) {
                setPetalPaintShader(this.aq.cFo_());
            }
            float f4 = this.cf * this.bg * f;
            canvas.scale(f4, f4, getWidth() / 2.0f, getHeight() * this.d);
            canvas.translate(this.cc, this.cg);
            canvas.drawPath(this.aq.cFp_(), this.bm);
            canvas.restore();
            canvas.save();
            if (this.p) {
                setPetalPaintShader(this.aq.cFs_());
            }
            float f5 = this.cf * this.bg * f;
            canvas.scale(f5, f5, getWidth() / 2.0f, getHeight() * this.d);
            canvas.translate(this.cc, this.cg);
            canvas.rotate(120.0f, this.aq.cFq_().x, this.aq.cFq_().y);
            canvas.drawPath(this.aq.cFp_(), this.bm);
            canvas.restore();
            this.bm.setStyle(Paint.Style.FILL);
        }
    }

    private void k() {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.33333334f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.53333336f, 1.0f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("startAlpha", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat4), PropertyValuesHolder.ofKeyframe("topAlpha", keyframeOfFloat, keyframeOfFloat3, keyframeOfFloat4), PropertyValuesHolder.ofKeyframe("rotate", keyframeOfFloat, keyframeOfFloat4));
        this.bo = valueAnimatorOfPropertyValuesHolder;
        valueAnimatorOfPropertyValuesHolder.setInterpolator(new pcc());
        this.bo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.ucd.cloveranimation.CloverView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CloverView.this.an = ((Float) valueAnimator.getAnimatedValue("startAlpha")).floatValue();
                CloverView.this.at = ((Float) valueAnimator.getAnimatedValue("topAlpha")).floatValue();
                CloverView.this.ar = ((Float) valueAnimator.getAnimatedValue("rotate")).floatValue();
                CloverView.this.invalidate();
            }
        });
        this.bo.setDuration(750L);
        this.bo.start();
    }

    private PropertyValuesHolder cGp_(pcc pccVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.4375f, 1.0f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat3.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe("topAngel", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3);
    }

    private PropertyValuesHolder cGi_(pcc pccVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.16666667f, 0.0f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.25f, 1.0f);
        keyframeOfFloat3.setInterpolator(pccVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat4.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe("runAlpha", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4);
    }

    private PropertyValuesHolder cGq_(pcc pccVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.4375f, 1.05f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.65625f, 0.98f);
        keyframeOfFloat3.setInterpolator(pccVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.71875f, 1.01f);
        keyframeOfFloat4.setInterpolator(pccVar);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.8125f, 1.0f);
        keyframeOfFloat5.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe(Constant.MAP_KEY_TOP, keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, Keyframe.ofFloat(1.0f, 1.0f));
    }

    private PropertyValuesHolder cGe_(pcc pccVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.125f, 0.0f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.625f, 1.0f);
        keyframeOfFloat3.setInterpolator(pccVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat4.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe("leftAngel", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4);
    }

    private PropertyValuesHolder cGm_(pcc pccVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.29166666f, 0.0f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.375f, 1.0f);
        keyframeOfFloat3.setInterpolator(pccVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat4.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe("sleepAlpha", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4);
    }

    private PropertyValuesHolder cGf_(pcc pccVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.125f, 0.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.625f, 1.05f);
        keyframeOfFloat3.setInterpolator(pccVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.84375f, 0.98f);
        keyframeOfFloat4.setInterpolator(pccVar);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.90625f, 1.01f);
        keyframeOfFloat5.setInterpolator(pccVar);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat6.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe("left", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6);
    }

    private PropertyValuesHolder cGg_(pcc pccVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.0625f, 0.0f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.53125f, 1.0f);
        keyframeOfFloat3.setInterpolator(pccVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat4.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe("rightAngel", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4);
    }

    private PropertyValuesHolder cGn_(pcc pccVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.22916667f, 0.0f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.3125f, 1.0f);
        keyframeOfFloat3.setInterpolator(pccVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat4.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe("smileAlpha", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4);
    }

    private PropertyValuesHolder cGh_(pcc pccVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.0625f, 0.0f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.53125f, 1.05f);
        keyframeOfFloat3.setInterpolator(pccVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.75f, 0.98f);
        keyframeOfFloat4.setInterpolator(pccVar);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.8125f, 1.01f);
        keyframeOfFloat5.setInterpolator(pccVar);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(0.90625f, 1.0f);
        keyframeOfFloat6.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe("right", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6, Keyframe.ofFloat(1.0f, 1.0f));
    }

    private void g() {
        pcc pccVar = new pcc();
        PropertyValuesHolder propertyValuesHolderCGp_ = cGp_(pccVar);
        PropertyValuesHolder propertyValuesHolderCGi_ = cGi_(pccVar);
        PropertyValuesHolder propertyValuesHolderCGq_ = cGq_(pccVar);
        PropertyValuesHolder propertyValuesHolderCGe_ = cGe_(pccVar);
        PropertyValuesHolder propertyValuesHolderCGm_ = cGm_(pccVar);
        PropertyValuesHolder propertyValuesHolderCGf_ = cGf_(pccVar);
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderCGq_, propertyValuesHolderCGi_, propertyValuesHolderCGp_, cGg_(pccVar), propertyValuesHolderCGm_, cGh_(pccVar), propertyValuesHolderCGe_, cGn_(pccVar), propertyValuesHolderCGf_);
        this.bv = valueAnimatorOfPropertyValuesHolder;
        valueAnimatorOfPropertyValuesHolder.setInterpolator(new FastOutSlowInInterpolator());
        this.bv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.ucd.cloveranimation.CloverView.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CloverView.this.ao = ((Float) valueAnimator.getAnimatedValue(Constant.MAP_KEY_TOP)).floatValue();
                CloverView.this.bs = ((Float) valueAnimator.getAnimatedValue("runAlpha")).floatValue();
                CloverView.this.al = ((Float) valueAnimator.getAnimatedValue("topAngel")).floatValue();
                CloverView.this.ap = ((Float) valueAnimator.getAnimatedValue("left")).floatValue();
                CloverView.this.bt = ((Float) valueAnimator.getAnimatedValue("sleepAlpha")).floatValue();
                CloverView.this.aj = ((Float) valueAnimator.getAnimatedValue("leftAngel")).floatValue();
                CloverView.this.as = ((Float) valueAnimator.getAnimatedValue("right")).floatValue();
                CloverView.this.bx = ((Float) valueAnimator.getAnimatedValue("smileAlpha")).floatValue();
                CloverView.this.am = ((Float) valueAnimator.getAnimatedValue("rightAngel")).floatValue();
                CloverView.this.invalidate();
            }
        });
        this.bv.setDuration(2400L);
    }

    private void b(final float f, final float f2, final float f3) {
        g();
        this.bv.addListener(new Animator.AnimatorListener() { // from class: com.huawei.ucd.cloveranimation.CloverView.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CloverView.this.bz = f;
                CloverView.this.bf = f2;
                CloverView.this.bp = f3;
                if (CloverView.this.e != null) {
                    CloverView.this.e.onFinished();
                }
                if (CloverView.this.k) {
                    CloverView.this.ac = true;
                    CloverView.this.c(1.0f, 1.0f, 1.0f);
                    CloverView.this.t = false;
                } else {
                    if (!CloverView.this.y || Float.compare(f, 1.0f) != 0 || Float.compare(f2, 1.0f) != 0 || Float.compare(f3, 1.0f) != 0) {
                        CloverView.this.t = false;
                        return;
                    }
                    CloverView.this.p = true;
                    CloverView.this.s = false;
                    CloverView.this.n();
                    CloverView.this.m();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CloverView.this.t = false;
                if (CloverView.this.e != null) {
                    CloverView.this.e.onFinished();
                }
            }
        });
        this.bv.start();
    }

    private PropertyValuesHolder getValueScaleRotation() {
        pcc pccVar = new pcc();
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.3030303f, 1.05f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.6363636f, 0.98f);
        keyframeOfFloat3.setInterpolator(pccVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.8181818f, 1.01f);
        keyframeOfFloat4.setInterpolator(pccVar);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat5.setInterpolator(pccVar);
        return PropertyValuesHolder.ofKeyframe("valueScale", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleRatio(float f) {
        if (this.ag) {
            float f2 = this.bz;
            this.cd = f2 + ((1.0f - f2) * f);
        } else {
            this.cd = 1.0f;
        }
        if (this.ah) {
            float f3 = this.bf;
            this.bj = f3 + ((1.0f - f3) * f);
        } else {
            this.bj = 1.0f;
        }
        if (this.ai) {
            float f4 = this.bp;
            this.bn = f4 + ((1.0f - f4) * f);
        } else {
            this.bn = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final float f, final float f2, final float f3) {
        this.ad = true;
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(getValueScaleRotation());
        this.ce = valueAnimatorOfPropertyValuesHolder;
        valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.ucd.cloveranimation.CloverView.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CloverView.this.setScaleRatio(((Float) valueAnimator.getAnimatedValue("valueScale")).floatValue());
                CloverView.this.ca = f;
                CloverView.this.bh = f2;
                CloverView.this.bq = f3;
                CloverView.this.invalidate();
            }
        });
        this.ce.setDuration(825L);
        this.ce.addListener(new Animator.AnimatorListener() { // from class: com.huawei.ucd.cloveranimation.CloverView.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CloverView.this.bz = f;
                CloverView.this.bf = f2;
                CloverView.this.bp = f3;
                if (Float.compare(f, 1.0f) != 0 || Float.compare(f2, 1.0f) != 0 || Float.compare(f3, 1.0f) != 0) {
                    CloverView.this.ad = false;
                    return;
                }
                CloverView.this.p = true;
                CloverView.this.s = false;
                CloverView.this.n();
                CloverView.this.m();
            }
        });
        this.ce.start();
    }

    public void a() {
        j();
        this.p = false;
        this.s = true;
        n();
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        pcc pccVar = new pcc();
        pcd pcdVar = new pcd();
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.6666667f, 1.0f);
        keyframeOfFloat2.setInterpolator(pccVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.22222222f, 0.95f);
        keyframeOfFloat4.setInterpolator(pcdVar);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.6666667f, 1.02f);
        keyframeOfFloat5.setInterpolator(pcdVar);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat6.setInterpolator(pcdVar);
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("scaleIn", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("resilience", keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        this.bc = valueAnimatorOfPropertyValuesHolder;
        valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.ucd.cloveranimation.CloverView.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CloverView.this.ay = ((Float) valueAnimator.getAnimatedValue("scaleIn")).floatValue();
                CloverView.this.br = ((Float) valueAnimator.getAnimatedValue("resilience")).floatValue();
                CloverView.this.invalidate();
            }
        });
        this.bc.setDuration(675L);
        this.bc.start();
    }

    private PropertyValuesHolder getAlphaRotation() {
        return PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.09090909f, 0.3f), Keyframe.ofFloat(0.6818182f, 0.0f), Keyframe.ofFloat(1.0f, 0.0f));
    }

    private PropertyValuesHolder cGj_(FastOutSlowInInterpolator fastOutSlowInInterpolator) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.9f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.6818182f, 1.2f);
        keyframeOfFloat2.setInterpolator(fastOutSlowInInterpolator);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat3.setInterpolator(fastOutSlowInInterpolator);
        return PropertyValuesHolder.ofKeyframe("scale", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3);
    }

    private PropertyValuesHolder getAlphaRotation1() {
        return PropertyValuesHolder.ofKeyframe("alpha1", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.22727273f, 0.0f), Keyframe.ofFloat(0.3181818f, 0.3f), Keyframe.ofFloat(0.84090906f, 0.0f), Keyframe.ofFloat(1.0f, 0.0f));
    }

    private PropertyValuesHolder cGk_(FastOutSlowInInterpolator fastOutSlowInInterpolator) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.22727273f, 0.9f);
        keyframeOfFloat2.setInterpolator(fastOutSlowInInterpolator);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.84090906f, 1.2f);
        keyframeOfFloat3.setInterpolator(fastOutSlowInInterpolator);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        keyframeOfFloat4.setInterpolator(fastOutSlowInInterpolator);
        return PropertyValuesHolder.ofKeyframe("scale1", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4);
    }

    private PropertyValuesHolder getAlphaRotation2() {
        return PropertyValuesHolder.ofKeyframe("alpha2", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.45454547f, 0.0f), Keyframe.ofFloat(0.54545456f, 0.3f), Keyframe.ofFloat(1.0f, 0.0f));
    }

    private PropertyValuesHolder cGl_(FastOutSlowInInterpolator fastOutSlowInInterpolator) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.45454547f, 0.9f);
        keyframeOfFloat2.setInterpolator(fastOutSlowInInterpolator);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(1.0f, 1.2f);
        keyframeOfFloat3.setInterpolator(fastOutSlowInInterpolator);
        return PropertyValuesHolder.ofKeyframe("scale2", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncourageAnimValue(ValueAnimator valueAnimator) {
        this.av = ((Float) valueAnimator.getAnimatedValue("alpha")).floatValue();
        this.ba = ((Float) valueAnimator.getAnimatedValue("scale")).floatValue();
        this.ax = ((Float) valueAnimator.getAnimatedValue("alpha1")).floatValue();
        this.az = ((Float) valueAnimator.getAnimatedValue("scale1")).floatValue();
        this.au = ((Float) valueAnimator.getAnimatedValue("alpha2")).floatValue();
        this.bb = ((Float) valueAnimator.getAnimatedValue("scale2")).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.y) {
            FastOutSlowInInterpolator fastOutSlowInInterpolator = new FastOutSlowInInterpolator();
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(getAlphaRotation(), cGj_(fastOutSlowInInterpolator), getAlphaRotation1(), cGk_(fastOutSlowInInterpolator), getAlphaRotation2(), cGl_(fastOutSlowInInterpolator));
            this.aw = valueAnimatorOfPropertyValuesHolder;
            valueAnimatorOfPropertyValuesHolder.setInterpolator(new FastOutSlowInInterpolator());
            this.aw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.ucd.cloveranimation.CloverView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CloverView.this.setEncourageAnimValue(valueAnimator);
                }
            });
            this.aw.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            this.aw.addListener(new Animator.AnimatorListener() { // from class: com.huawei.ucd.cloveranimation.CloverView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CloverView.this.e();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (CloverView.this.ch != null) {
                        CloverView.this.ch.onFinished();
                    }
                }
            });
            this.aw.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.p) {
            this.ad = false;
            this.t = false;
            AddFrameListener addFrameListener = this.ch;
            if (addFrameListener != null) {
                addFrameListener.onFinished();
            }
        }
        if (this.k) {
            if (this.v) {
                d(this.ak);
            } else {
                a();
            }
            this.v = !this.v;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cl == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.h = motionEvent.getX();
            this.i = motionEvent.getY();
            this.ae = 0;
        } else if (action == 1) {
            int i = this.ae;
            if (i == 0 || (i == 2 && !this.c)) {
                e(motionEvent.getX(), motionEvent.getY());
            }
            this.c = false;
        } else if (action == 2) {
            if (!this.c && (Math.abs(motionEvent.getX() - this.h) > 10.0f || Math.abs(motionEvent.getY() - this.i) > 10.0f)) {
                this.c = true;
            }
            this.ae = 2;
        }
        return true;
    }

    public boolean cGr_(Path path, float f, float f2) {
        RectF rectF = new RectF();
        Region region = new Region();
        path.computeBounds(rectF, true);
        float f3 = this.bg * this.cf;
        region.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        return region.contains((int) (f / f3), (int) (f2 / f3));
    }

    private void e(float f, float f2) {
        float width = (getWidth() / 2.0f) - (((this.aq.g() * this.bg) * this.cf) / 2.0f);
        float height = (getHeight() * this.d) - ((this.aq.h() * this.bg) * this.cf);
        if (cGr_(this.aq.cFp_(), f - width, f2 - height)) {
            this.cl.onTopClick();
            return;
        }
        float width2 = getWidth() / 2.0f;
        float height2 = getHeight() * this.d;
        double d = width2;
        double d2 = f - width2;
        double d3 = f2 - height2;
        double d4 = height2;
        if (cGr_(this.aq.cFp_(), ((float) (((Math.cos(2.0943951023931953d) * d2) + d) - (Math.sin(2.0943951023931953d) * d3))) - width, ((float) ((Math.cos(2.0943951023931953d) * d3) + ((Math.sin(2.0943951023931953d) * d2) + d4))) - height)) {
            this.cl.onLeftClick();
            return;
        }
        if (cGr_(this.aq.cFp_(), ((float) ((d + (Math.cos(-2.0943951023931953d) * d2)) - (Math.sin(-2.0943951023931953d) * d3))) - width, ((float) ((d4 + (d2 * Math.sin(-2.0943951023931953d))) + (d3 * Math.cos(-2.0943951023931953d)))) - height)) {
            this.cl.onRightClick();
        }
    }
}
