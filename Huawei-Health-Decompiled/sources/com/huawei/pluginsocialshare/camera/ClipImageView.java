package com.huawei.pluginsocialshare.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.IoUtils;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class ClipImageView extends ImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8834a;
    private int b;
    private Context c;
    private int d;
    private GestureDetector e;
    private ScaleGestureDetector f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private final float[] l;
    private float m;
    private float n;
    private float o;
    private float p;
    private int r;
    private float s;
    private final Matrix t;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public ClipImageView(Context context) {
        this(context, null);
    }

    public ClipImageView(c cVar) {
        this(cVar.e);
        this.c = cVar.e;
        this.n = cVar.b;
        this.p = cVar.d;
        this.r = cVar.i;
        this.b = cVar.c;
        this.s = cVar.h;
        this.g = cVar.f8835a;
        b();
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new float[9];
        this.t = new Matrix();
        this.n = 4.0f;
        this.p = 2.0f;
        this.s = 1.0f;
        this.j = true;
        this.f = null;
    }

    private void b() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.e = new GestureDetector(this.c, new GestureDetector.SimpleOnGestureListener() { // from class: com.huawei.pluginsocialshare.camera.ClipImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (ClipImageView.this.h) {
                    return true;
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (ClipImageView.this.getScale() < ClipImageView.this.p) {
                    ClipImageView clipImageView = ClipImageView.this;
                    clipImageView.postDelayed(clipImageView.new e(clipImageView.p, x, y), 16L);
                    ClipImageView.this.h = true;
                } else {
                    ClipImageView clipImageView2 = ClipImageView.this;
                    clipImageView2.postDelayed(clipImageView2.new e(clipImageView2.s, x, y), 16L);
                    ClipImageView.this.h = true;
                }
                return true;
            }
        });
        this.f = new ScaleGestureDetector(this.c, this);
        setOnTouchListener(this);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8835a;
        private Context e;
        private float b = 4.0f;
        private float d = 2.0f;
        private float h = 1.0f;
        private int i = 1;
        private int c = 1;

        public c(Context context, int i) {
            this.f8835a = i;
            this.e = context;
        }

        public c c(float f) {
            if (f < 0.0f) {
                return this;
            }
            this.b = f;
            return this;
        }

        public c d(float f) {
            if (f < 0.0f) {
                return this;
            }
            this.d = f;
            return this;
        }

        public c e(float f) {
            if (f < 0.0f) {
                return this;
            }
            this.h = f;
            return this;
        }

        public c d(int i) {
            if (i < 0) {
                return this;
            }
            this.i = i;
            return this;
        }

        public c a(int i) {
            if (i < 0) {
                return this;
            }
            this.c = i;
            return this;
        }

        public c b(int i) {
            if (i < 0) {
                return this;
            }
            this.f8835a = i;
            return this;
        }

        public c c(Context context) {
            if (context == null) {
                return this;
            }
            this.e = context;
            return this;
        }

        public ClipImageView d() {
            return new ClipImageView(this);
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() == null) {
            return true;
        }
        float f = this.n;
        boolean z = false;
        boolean z2 = scale < f && scaleFactor > 1.0f;
        float f2 = this.s;
        if (scale > f2 && scaleFactor < 1.0f) {
            z = true;
        }
        if (z2 || z) {
            if (scaleFactor * scale < f2) {
                scaleFactor = f2 / scale;
            }
            if (scaleFactor * scale > f) {
                scaleFactor = f / scale;
            }
            this.t.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            if (e()) {
                setImageMatrix(this.t);
            }
        }
        return true;
    }

    private RectF getMatrixRectF() {
        RectF rectF = new RectF();
        if (getDrawable() != null) {
            rectF.set(0.0f, 0.0f, r1.getIntrinsicWidth(), r1.getIntrinsicHeight());
            this.t.mapRect(rectF);
        }
        return rectF;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            android.view.GestureDetector r7 = r6.e
            boolean r7 = r7.onTouchEvent(r8)
            r0 = 1
            if (r7 == 0) goto La
            return r0
        La:
            android.view.ScaleGestureDetector r7 = r6.f
            r7.onTouchEvent(r8)
            int r7 = r8.getPointerCount()
            r1 = 0
            r2 = 0
            r3 = r1
            r4 = r2
        L17:
            if (r4 >= r7) goto L26
            float r5 = r8.getX(r4)
            float r1 = r1 + r5
            float r5 = r8.getY(r4)
            float r3 = r3 + r5
            int r4 = r4 + 1
            goto L17
        L26:
            float r4 = (float) r7
            float r1 = r1 / r4
            float r3 = r3 / r4
            int r4 = r6.k
            if (r7 == r4) goto L33
            r6.i = r2
            r6.o = r1
            r6.m = r3
        L33:
            r6.k = r7
            int r7 = r8.getAction()
            if (r7 == r0) goto L46
            r8 = 2
            if (r7 == r8) goto L42
            r8 = 3
            if (r7 == r8) goto L46
            goto L48
        L42:
            r6.d(r1, r3)
            goto L48
        L46:
            r6.k = r2
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginsocialshare.camera.ClipImageView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void d(float f, float f2) {
        float f3 = f - this.o;
        float f4 = f2 - this.m;
        if (!this.i) {
            this.i = b(f3, f4);
        } else if (getDrawable() != null) {
            RectF matrixRectF = getMatrixRectF();
            if (matrixRectF.left + f3 >= this.g || matrixRectF.right + f3 <= getWidth() - this.g) {
                f3 = 0.0f;
            }
            if (matrixRectF.top + f4 >= getVerticalPadding() || matrixRectF.bottom + f4 <= getHeight() - getVerticalPadding()) {
                f4 = 0.0f;
            }
            this.t.postTranslate(f3, f4);
            setImageMatrix(this.t);
        }
        this.o = f;
        this.m = f2;
    }

    public final float getScale() {
        this.t.getValues(this.l);
        return this.l[0];
    }

    private float getTransX() {
        this.t.getValues(this.l);
        return this.l[2];
    }

    private float getTransY() {
        this.t.getValues(this.l);
        return this.l[5];
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        if (!this.j || (drawable = getDrawable()) == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int width = getWidth() - (this.g * 2);
        this.f8834a = width;
        int i = (this.b * width) / this.r;
        this.d = i;
        float fMax = Math.max((width * 1.0f) / intrinsicWidth, (i * 1.0f) / intrinsicHeight);
        this.s = fMax;
        this.p = fMax * 2.0f;
        this.n = fMax * 4.0f;
        this.t.postTranslate((getWidth() - intrinsicWidth) / 2.0f, (getHeight() - intrinsicHeight) / 2.0f);
        Matrix matrix = this.t;
        float f = this.s;
        matrix.postScale(f, f, getWidth() / 2.0f, getHeight() / 2.0f);
        setImageMatrix(this.t);
        this.j = false;
    }

    public Bitmap cwM_() {
        try {
            return cwL_();
        } catch (IllegalArgumentException unused) {
            LogUtil.j("Share_ClipImageView", "clip:IllegalArgumentException");
            return null;
        } catch (IllegalStateException unused2) {
            LogUtil.j("Share_ClipImageView", "clip:IllegalStateException");
            return null;
        } catch (OutOfMemoryError unused3) {
            LogUtil.j("Share_ClipImageView", "clip:OutOfMemoryError");
            return null;
        }
    }

    private Bitmap cwL_() {
        if (!(getDrawable() instanceof BitmapDrawable) || !(getDrawable() instanceof BitmapDrawable)) {
            return null;
        }
        Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        int transX = (int) ((this.g - getTransX()) / getScale());
        int verticalPadding = (int) ((getVerticalPadding() - getTransY()) / getScale());
        int scale = (int) (this.f8834a / getScale());
        int scale2 = (int) (this.d / getScale());
        if (transX < 0) {
            transX = 0;
        }
        if (verticalPadding < 0) {
            verticalPadding = 0;
        }
        if (transX + scale > bitmap.getWidth()) {
            transX = bitmap.getWidth() - scale;
        }
        if (verticalPadding + scale2 > bitmap.getHeight()) {
            verticalPadding = bitmap.getHeight() - scale2;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, transX, verticalPadding, (int) (this.f8834a / getScale()), (int) (this.d / getScale()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            LogUtil.b("Share_ClipImageView", "after rawClip bitmap size:", Double.valueOf((((double) byteArrayOutputStream.toByteArray().length) / 1024.0d) / 1024.0d), "M");
            return bitmapCreateBitmap;
        } finally {
            IoUtils.a(byteArrayOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        RectF matrixRectF = getMatrixRectF();
        int width = getWidth();
        int height = getHeight();
        if (matrixRectF.width() < this.f8834a) {
            return false;
        }
        float f = matrixRectF.left > ((float) this.g) ? (-matrixRectF.left) + this.g : 0.0f;
        float f2 = matrixRectF.right;
        float f3 = width - this.g;
        if (f2 < f3) {
            f = f3 - matrixRectF.right;
        }
        if (matrixRectF.height() < this.d) {
            return false;
        }
        float verticalPadding = matrixRectF.top > ((float) getVerticalPadding()) ? getVerticalPadding() + (-matrixRectF.top) : 0.0f;
        if (matrixRectF.bottom < height - getVerticalPadding()) {
            verticalPadding = (height - getVerticalPadding()) - matrixRectF.bottom;
        }
        this.t.postTranslate(f, verticalPadding);
        return true;
    }

    private boolean b(float f, float f2) {
        return Math.sqrt((double) ((f * f) + (f2 * f2))) >= 0.0d;
    }

    private int getVerticalPadding() {
        return (getHeight() - this.d) / 2;
    }

    class e implements Runnable {
        private float b;
        private float c;
        private float d;
        private float e;

        e(float f, float f2, float f3) {
            this.b = f;
            this.e = f2;
            this.c = f3;
            if (ClipImageView.this.getScale() < this.b) {
                this.d = 1.07f;
            } else {
                this.d = 0.93f;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = ClipImageView.this.t;
            float f = this.d;
            matrix.postScale(f, f, this.e, this.c);
            if (ClipImageView.this.e()) {
                ClipImageView clipImageView = ClipImageView.this;
                clipImageView.setImageMatrix(clipImageView.t);
            }
            float scale = ClipImageView.this.getScale();
            float f2 = this.d;
            boolean z = f2 > 1.0f && scale < this.b;
            boolean z2 = f2 < 1.0f && this.b < scale;
            if (z || z2) {
                ClipImageView.this.postDelayed(this, 16L);
                return;
            }
            float f3 = this.b / scale;
            ClipImageView.this.t.postScale(f3, f3, this.e, this.c);
            if (ClipImageView.this.e()) {
                ClipImageView clipImageView2 = ClipImageView.this;
                clipImageView2.setImageMatrix(clipImageView2.t);
                ClipImageView.this.h = false;
            }
        }
    }
}
