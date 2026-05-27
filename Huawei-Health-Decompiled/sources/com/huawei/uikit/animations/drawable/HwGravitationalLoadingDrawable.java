package com.huawei.uikit.animations.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.media3.extractor.ts.TsExtractor;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes8.dex */
public class HwGravitationalLoadingDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f11069a;
    private final c b;
    public g c;
    private final c d;
    private final c e;
    private Animator f;
    private final c g;
    private Animator h;
    private boolean i = false;
    private float j = 0.0f;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final float[] f11070a = {16.0f, 40.0f, 76.0f};
        private static final float[] e = {2.8f, 1.9f, 1.2f};
        private static final float[] c = {0.5f, 0.2f, 0.1f};
        private static final float[] d = {3.0f, 3.0f, 2.0f};
        private static final float[] b = {3.0f, 3.0f, 2.2f};

        a() {
        }

        static c a(float f) {
            return c(d, f);
        }

        static c c(float f) {
            return c(c, f);
        }

        static c d(float f) {
            return c(b, f);
        }

        static c e(float f) {
            return c(e, f);
        }

        static c c(float[] fArr, float f) {
            return new c(euY_(evb_(fArr), f), euY_(eva_(fArr), f), euY_(euZ_(fArr), f));
        }

        private static PointF eva_(float[] fArr) {
            return euX_(1, fArr);
        }

        private static PointF evb_(float[] fArr) {
            return euX_(0, fArr);
        }

        private static PointF euZ_(float[] fArr) {
            return euX_(2, fArr);
        }

        private static PointF euX_(int i, float[] fArr) {
            if (i >= 0) {
                float[] fArr2 = f11070a;
                if (i < fArr2.length && i < fArr.length) {
                    return new PointF(fArr2[i], fArr[i]);
                }
            }
            return new PointF();
        }

        private static PointF euY_(PointF pointF, float f) {
            pointF.x *= f;
            pointF.y *= f;
            return pointF;
        }
    }

    static abstract class aijfr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Camera f11071a;
        private final Matrix b;

        class d extends aijfr {
            d(float f) {
                super(f, null);
            }

            @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable.aijfr
            protected void b(float f) {
                this.f11071a.rotateY(f);
            }
        }

        /* synthetic */ aijfr(float f, l lVar) {
            this(f);
        }

        PointF a(PointF pointF, float f) {
            PointF pointF2 = new PointF();
            b(f);
            a(pointF, pointF2);
            a();
            return pointF2;
        }

        abstract void b(float f);

        void c(float f) {
            Camera camera = this.f11071a;
            camera.setLocation(f, camera.getLocationY(), this.f11071a.getLocationZ());
        }

        void d(float f) {
            Camera camera = this.f11071a;
            camera.setLocation(camera.getLocationX(), f, this.f11071a.getLocationZ());
        }

        void e(float f) {
            Camera camera = this.f11071a;
            camera.setLocation(camera.getLocationX(), this.f11071a.getLocationY(), f);
        }

        private aijfr(float f) {
            Camera camera = new Camera();
            this.f11071a = camera;
            this.b = new Matrix();
            b(f);
            camera.save();
        }

        void a(PointF pointF, PointF pointF2, float f) {
            b(f);
            a(pointF, pointF2);
            a();
        }

        private void a(PointF pointF, PointF pointF2) {
            float[] fArrA = a(pointF);
            this.f11071a.getMatrix(this.b);
            this.b.mapPoints(fArrA);
            pointF2.x = fArrA[0];
            pointF2.y = fArrA[1];
        }

        private static float[] a(PointF pointF) {
            return new float[]{pointF.x, pointF.y};
        }

        private void a() {
            this.f11071a.restore();
            this.f11071a.save();
        }

        static aijfr a(float f) {
            return new d(f);
        }
    }

    interface avpbg {
        void a(Paint paint);
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e("HwLoadingAnim", "onAnimationUpdate: null animator");
                return;
            }
            HwGravitationalLoadingDrawable.this.f11069a.e(((Float) valueAnimator.getAnimatedValue("degrees")).floatValue(), ((Integer) valueAnimator.getAnimatedValue("alpha")).intValue(), ((Float) valueAnimator.getAnimatedValue("scale")).floatValue());
            HwGravitationalLoadingDrawable.this.invalidateSelf();
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PointF f11072a;
        private final PointF d;
        private final PointF e;

        c(PointF pointF, PointF pointF2, PointF pointF3) {
            a(pointF.x, "start.x");
            a(pointF.y, "start.y");
            a(pointF2.y, "middle.y");
            a(pointF3.y, "end.y");
            if (Float.compare(pointF.x, pointF2.x) >= 0) {
                throw new IllegalArgumentException("start.x >= middle.x");
            }
            if (Float.compare(pointF2.x, pointF3.x) >= 0) {
                throw new IllegalArgumentException("middle.x >= end.x");
            }
            this.d = pointF;
            this.e = pointF2;
            this.f11072a = pointF3;
        }

        private static void a(float f, String str) {
            if (f >= 0.0f) {
                return;
            }
            throw new IllegalArgumentException(str + " is negative");
        }

        private float e(float f, float f2, float f3) {
            return (f * (f3 - f2)) + f2;
        }

        float e(float f) {
            if (Float.compare(f, this.d.x) <= 0) {
                return this.d.y;
            }
            if (Float.compare(f, this.f11072a.x) >= 0) {
                return this.f11072a.y;
            }
            if (Float.compare(f, this.d.x) <= 0 || Float.compare(f, this.e.x) > 0) {
                PointF pointF = this.e;
                float f2 = pointF.x;
                PointF pointF2 = this.f11072a;
                return e((f - f2) / (pointF2.x - f2), pointF.y, pointF2.y);
            }
            PointF pointF3 = this.d;
            float f3 = pointF3.x;
            PointF pointF4 = this.e;
            return e((f - f3) / (pointF4.x - f3), pointF3.y, pointF4.y);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f11073a;
        private final n b;
        private final e c;
        private final boolean d;
        private final o e;

        d(n nVar, o oVar, f fVar, boolean z) {
            this(nVar, oVar, fVar, null, z);
        }

        public static d euV_(Context context, AttributeSet attributeSet, int i, int i2) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100630_res_0x7f0603d6, R.attr._2131100631_res_0x7f0603d7, R.attr._2131100632_res_0x7f0603d8, R.attr._2131100633_res_0x7f0603d9, R.attr._2131100634_res_0x7f0603da, R.attr._2131100635_res_0x7f0603db, R.attr._2131100636_res_0x7f0603dc, R.attr._2131100637_res_0x7f0603dd, R.attr._2131100638_res_0x7f0603de, R.attr._2131100639_res_0x7f0603df, R.attr._2131100640_res_0x7f0603e0, R.attr._2131100641_res_0x7f0603e1, R.attr._2131100642_res_0x7f0603e2, R.attr._2131100643_res_0x7f0603e3, R.attr._2131100644_res_0x7f0603e4}, i, i2);
            n nVarB = n.b(context, typedArrayObtainStyledAttributes);
            o oVarEvq_ = o.evq_(context, typedArrayObtainStyledAttributes);
            f fVarEvf_ = f.evf_(typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
            return new d(nVarB, oVarEvq_, fVarEvf_, false);
        }

        public static d euW_(Context context, AttributeSet attributeSet, int i, int i2) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100630_res_0x7f0603d6, R.attr._2131100631_res_0x7f0603d7, R.attr._2131100632_res_0x7f0603d8, R.attr._2131100633_res_0x7f0603d9, R.attr._2131100634_res_0x7f0603da, R.attr._2131100635_res_0x7f0603db, R.attr._2131100636_res_0x7f0603dc, R.attr._2131100637_res_0x7f0603dd, R.attr._2131100638_res_0x7f0603de, R.attr._2131100639_res_0x7f0603df, R.attr._2131100640_res_0x7f0603e0, R.attr._2131100641_res_0x7f0603e1, R.attr._2131100642_res_0x7f0603e2, R.attr._2131100643_res_0x7f0603e3, R.attr._2131100644_res_0x7f0603e4}, i, i2);
            n nVarB = n.b(context, typedArrayObtainStyledAttributes);
            e eVarEvd_ = e.evd_(context, typedArrayObtainStyledAttributes);
            o oVarEvq_ = o.evq_(context, typedArrayObtainStyledAttributes);
            f fVarEvf_ = f.evf_(typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
            return new d(nVarB, oVarEvq_, fVarEvf_, eVarEvd_, true);
        }

        d(n nVar, o oVar, f fVar, e eVar, boolean z) {
            this.b = nVar;
            this.e = oVar;
            this.f11073a = fVar;
            this.d = z;
            this.c = eVar;
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11074a;
        private final float b;
        private final float d;

        e(float f, float f2, int i) {
            this.b = f;
            this.d = f2;
            this.f11074a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static e evd_(Context context, TypedArray typedArray) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new e(typedArray.getDimension(2, HwGravitationalLoadingDrawable.euU_(3.0f, displayMetrics)), typedArray.getDimension(1, HwGravitationalLoadingDrawable.euU_(2.0f, displayMetrics)), typedArray.getInt(0, TsExtractor.TS_STREAM_TYPE_E_AC3));
        }
    }

    static final class f {
        private final int c;
        private final float d;
        private final int e;

        f(int i, int i2, float f) {
            this.e = i;
            this.c = i2;
            this.d = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static f evf_(TypedArray typedArray) {
            int integer = typedArray.getInteger(5, 20);
            int i = integer >= 0 ? integer : 20;
            int integer2 = typedArray.getInteger(6, 60);
            int i2 = integer2 > 0 ? integer2 : 60;
            float fraction = typedArray.getFraction(4, 1, 1, 0.82f);
            return new f(i, i2, fraction >= 0.0f ? fraction : 0.82f);
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Paint f11075a;
        private final k b;
        private final boolean c;
        private final k d;
        private final float e;
        private float f;
        private float g;
        private Bitmap h;
        private float i;
        private Canvas j;

        g(float f, k kVar, boolean z) {
            this(f, kVar, null, z);
        }

        g(float f, k kVar, k kVar2, boolean z) {
            this.f11075a = new Paint(1);
            this.g = 1.0f;
            this.f = 1.0f;
            this.e = f;
            this.d = kVar;
            this.b = kVar2;
            this.c = z;
            e(300);
            d();
        }

        private void e(int i) {
            this.h = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            this.j = new Canvas(this.h);
            this.i = i;
        }

        void a(int i) {
            this.d.c(i);
            k kVar = this.b;
            if (kVar != null) {
                kVar.c(i);
            }
            c();
            d();
        }

        void c(int i) {
            if (this.h == null || i > this.i) {
                e(i);
            } else {
                c();
            }
            this.f = i / this.e;
            d();
        }

        private void c() {
            this.h.eraseColor(0);
        }

        public void c(float f) {
            this.g = f;
        }

        void a(Canvas canvas, Rect rect) {
            canvas.save();
            float f = this.g;
            canvas.scale(f, f, rect.exactCenterX(), rect.exactCenterY());
            canvas.drawBitmap(this.h, rect.left, rect.top, this.f11075a);
            canvas.restore();
        }

        private void d() {
            this.j.save();
            Canvas canvas = this.j;
            float f = this.f;
            canvas.scale(f, f);
            float fB = HwGravitationalLoadingDrawable.b(this.e);
            k kVar = this.b;
            if (kVar != null) {
                kVar.evr_(this.j, fB, fB);
            }
            this.d.evr_(this.j, fB, fB);
            this.j.restore();
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f11076a;
        private final float b;
        private final float d;
        private final b e;
        private float f;
        private Bitmap g;
        private float h;
        private Canvas i;
        private float k;
        private final Paint c = new Paint(1);
        private float j = 1.0f;

        static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final PointF f11077a;
            private final PointF c;
            private final aijfr d;
            private final Paint e = new Paint(1);

            b(aijfr aijfrVar, PointF pointF, int i) {
                this.d = aijfrVar;
                this.f11077a = pointF;
                this.c = new PointF(pointF.x, pointF.y);
                c(i);
            }

            private void c(int i) {
                this.e.setStyle(Paint.Style.FILL);
                this.e.setColor(i);
            }

            void d(float f) {
                this.d.a(this.f11077a, this.c, f);
            }

            void evn_(Canvas canvas, float f) {
                PointF pointF = this.c;
                canvas.drawCircle(pointF.x, pointF.y, f, this.e);
            }
        }

        static class c {
            private static final FloatEvaluator c = new FloatEvaluator();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f11078a;
            private final aijfr b;
            private final PointF d = new PointF();

            c(aijfr aijfrVar, int i) {
                this.b = aijfrVar;
                this.f11078a = i;
            }

            void evl_(Canvas canvas, Paint paint, float f) {
                int i = this.f11078a;
                if (i == 0) {
                    return;
                }
                paint.setAlpha(i);
                PointF pointF = this.d;
                canvas.drawCircle(pointF.x, pointF.y, f, paint);
            }

            void a(float f, PointF pointF, float f2, float f3) {
                this.b.a(pointF, this.d, c.evaluate(f, (Number) Float.valueOf(f2), (Number) Float.valueOf(f2 - f3)).floatValue());
            }
        }

        static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f11079a;
            private final int b;
            private final Paint c = new Paint(1);
            private final PointF d;
            private final c[] e;
            private float g;
            private int i;

            d(PointF pointF, aijfr aijfrVar, f fVar, int i) {
                this.d = pointF;
                int i2 = fVar.e;
                this.b = i2;
                this.f11079a = fVar.c;
                this.g = fVar.c;
                this.e = new c[i2];
                float f = fVar.d;
                int i3 = 0;
                while (true) {
                    c[] cVarArr = this.e;
                    if (i3 >= cVarArr.length) {
                        c(i);
                        return;
                    }
                    if (i3 == 0) {
                        cVarArr[i3] = new c(aijfrVar, e(255, f));
                    } else {
                        cVarArr[i3] = new c(aijfrVar, e(cVarArr[i3 - 1].f11078a, f));
                    }
                    i3++;
                }
            }

            private int e(int i, float f) {
                return (int) (i * f);
            }

            void c(float f) {
                this.g = Math.min(f, this.f11079a);
            }

            private void c(int i) {
                this.c.setColor(i);
                this.c.setStyle(Paint.Style.FILL);
            }

            void b() {
                this.g = this.f11079a;
            }

            void a(float f) {
                int i = this.f11079a;
                int i2 = 0;
                if (i <= 0) {
                    this.i = 0;
                    return;
                }
                this.i = (int) ((this.g / i) * this.b);
                while (true) {
                    int i3 = this.i;
                    if (i2 >= i3) {
                        return;
                    }
                    int i4 = i2 + 1;
                    this.e[i2].a(i4 / i3, this.d, f, this.g);
                    i2 = i4;
                }
            }

            void evk_(Canvas canvas, float f) {
                for (int i = 0; i < this.i; i++) {
                    this.e[i].evl_(canvas, this.c, f);
                }
            }
        }

        h(int i, float f, float f2, float f3, f fVar) {
            this.b = f;
            d(300);
            this.h = f2;
            this.k = f2;
            PointF pointF = new PointF(f3, 0.0f);
            aijfr aijfrVarA = aijfr.a(-90.0f);
            aijfrVarA.d(1.0f);
            this.d = aijfrVarA.a(pointF, 0.0f).y;
            this.e = new b(aijfrVarA, pointF, i);
            this.f11076a = new d(pointF, aijfrVarA, fVar, i);
        }

        void b(int i) {
            float f = i;
            if (f > this.f) {
                d(i);
            }
            this.j = f / this.b;
        }

        private void d(int i) {
            this.g = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            this.i = new Canvas(this.g);
            this.f = i;
        }

        public void a(float f) {
            this.f11076a.c(f);
        }

        void a(int i) {
            this.e.e.setColor(i);
            this.f11076a.c.setColor(i);
        }

        void a(Canvas canvas, Rect rect, float f) {
            this.g.eraseColor(0);
            this.i.save();
            Canvas canvas2 = this.i;
            float f2 = this.j;
            canvas2.scale(f2, f2);
            float fB = HwGravitationalLoadingDrawable.b(this.b);
            this.i.translate(fB, fB);
            this.i.rotate(-f, 0.0f, 0.0f);
            this.i.translate(0.0f, -this.d);
            this.e.evn_(this.i, this.k);
            this.f11076a.evk_(this.i, this.k);
            canvas.drawBitmap(this.g, rect.left, rect.top, this.c);
            this.i.restore();
        }

        void e(float f, int i, float f2) {
            d(f);
            this.c.setAlpha(i);
            this.k = this.h * f2;
        }

        public void d(float f) {
            this.e.d(f);
            this.f11076a.a(f);
        }
    }

    static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f11080a;
        private final int b;
        private final Paint c;
        private float d;
        private final int e;

        k(int i, float f, float f2) {
            this(i, f, f2, 255);
        }

        k(int i, float f, float f2, int i2) {
            this.c = new Paint(1);
            this.e = i;
            this.f11080a = f;
            this.d = f2;
            this.b = i2;
            b();
        }

        private void b() {
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeWidth(this.d);
            this.c.setColor(this.e);
            this.c.setAlpha(this.b);
        }

        void c(int i) {
            this.c.setColor(i);
            this.c.setAlpha(this.b);
        }

        void d(float f) {
            this.d = f;
            this.c.setStrokeWidth(f);
        }

        void b(avpbg avpbgVar) {
            avpbgVar.a(this.c);
        }

        void evr_(Canvas canvas, float f, float f2) {
            canvas.drawCircle(f, f2, this.f11080a, this.c);
        }
    }

    class l implements ValueAnimator.AnimatorUpdateListener {
        l() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e("HwLoadingAnim", "onAnimationUpdate:null animator");
                return;
            }
            HwGravitationalLoadingDrawable.this.j = ((Float) valueAnimator.getAnimatedValue(TypedValues.CycleType.S_WAVE_OFFSET)).floatValue() * HwGravitationalLoadingDrawable.this.c.f;
            HwGravitationalLoadingDrawable.this.invalidateSelf();
        }
    }

    static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11081a;
        private final float b;
        private final float c;
        private final float d;
        private final float e;

        n(float f, float f2, int i, float f3, float f4) {
            this.c = f;
            this.d = f2;
            this.f11081a = i;
            this.e = f3;
            this.b = f4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static n b(Context context, TypedArray typedArray) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float dimension = typedArray.getDimension(13, HwGravitationalLoadingDrawable.euU_(10.5f, displayMetrics));
            float dimension2 = typedArray.getDimension(14, HwGravitationalLoadingDrawable.euU_(1.9f, displayMetrics));
            int integer = typedArray.getInteger(11, 200);
            float dimension3 = typedArray.getDimension(12, HwGravitationalLoadingDrawable.euU_(0.2f, displayMetrics));
            float f = displayMetrics.density * 40.0f;
            float dimension4 = typedArray.getDimension(7, f);
            return new n(dimension, dimension2, integer, dimension3, dimension4 <= 0.0f ? f : dimension4);
        }
    }

    static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f11082a;
        private final float b;
        private final float c;

        o(float f, float f2, float f3) {
            this.b = f;
            this.c = f2;
            this.f11082a = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static o evq_(Context context, TypedArray typedArray) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float dimension = typedArray.getDimension(3, HwGravitationalLoadingDrawable.euU_(3.0f, displayMetrics));
            float dimension2 = typedArray.getDimension(10, HwGravitationalLoadingDrawable.euU_(17.0f, displayMetrics));
            float f = displayMetrics.density * 40.0f;
            float dimension3 = typedArray.getDimension(7, f);
            if (dimension3 > 0.0f) {
                f = dimension3;
            }
            return new o(dimension, dimension2, f);
        }
    }

    public HwGravitationalLoadingDrawable(g gVar, h hVar, int i2, float f2) {
        this.c = gVar;
        this.f11069a = hVar;
        d(i2);
        c(i2);
        this.b = a.e(f2);
        this.d = a.c(f2);
        this.e = a.a(f2);
        this.g = a.d(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float b(float f2) {
        return f2 / 2.0f;
    }

    private void c(int i2) {
        this.h = i.evg_(i2, 35.0f, new b());
    }

    private void d(int i2) {
        this.f = i.a(i2, this.c.d.f11080a * 2.0f, new l());
    }

    private void e(int i2) {
        float f2 = i2;
        this.c.d.d(this.b.e(f2));
        this.f11069a.h = this.g.e(f2);
        h hVar = this.f11069a;
        hVar.k = hVar.h;
        if (this.c.c) {
            this.c.d.b(j.a(this.d.e(f2)));
            if (this.c.b != null) {
                this.c.b.d(this.e.e(f2));
            }
        }
    }

    public void b(int i2) {
        int iA = a(i2);
        this.f11069a.a(iA);
        this.c.a(iA);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.j);
        this.c.a(canvas, getBounds());
        this.f11069a.a(canvas, getBounds(), 23.3f);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (rect == null) {
            return;
        }
        super.onBoundsChange(rect);
        int iMin = Math.min(rect.width(), rect.height());
        e(iMin);
        this.c.c(iMin);
        this.f11069a.b(iMin);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        c(true);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        d();
    }

    static class j implements avpbg {
        private final float d;
        private final BlurMaskFilter.Blur e;

        j(float f, BlurMaskFilter.Blur blur) {
            this.d = f;
            this.e = blur;
        }

        @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable.avpbg
        public void a(Paint paint) {
            paint.setMaskFilter(null);
            paint.setMaskFilter(new BlurMaskFilter(this.d, this.e));
        }

        static j a(float f) {
            return new j(f, BlurMaskFilter.Blur.NORMAL);
        }
    }

    public static g c(int i2, d dVar) {
        if (dVar.d && dVar.c == null) {
            throw new IllegalArgumentException("create for night mode, but BackgroundRingParams is null");
        }
        return dVar.d ? b(i2, dVar.b, dVar.c) : c(i2, dVar.b);
    }

    public void c(boolean z) {
        if (this.i) {
            return;
        }
        if (z) {
            this.f11069a.f11076a.b();
        }
        this.h.start();
        this.f.start();
        this.i = true;
    }

    static class i {
        i() {
        }

        static Animator a(long j, float f, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            float f2 = f * 0.06f;
            ValueAnimator valueAnimatorEvi_ = evi_(j, f2);
            valueAnimatorEvi_.addUpdateListener(animatorUpdateListener);
            ValueAnimator valueAnimatorEvh_ = evh_(j, f2);
            valueAnimatorEvh_.addUpdateListener(animatorUpdateListener);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(valueAnimatorEvi_, valueAnimatorEvh_);
            return animatorSet;
        }

        private static ValueAnimator evi_(long j, float f) {
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(TypedValues.CycleType.S_WAVE_OFFSET, 0.0f, -f));
            valueAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.67f, 1.0f));
            valueAnimatorOfPropertyValuesHolder.setDuration(j / 4);
            return valueAnimatorOfPropertyValuesHolder;
        }

        private static ValueAnimator evh_(long j, float f) {
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(TypedValues.CycleType.S_WAVE_OFFSET, -f, f));
            valueAnimatorOfPropertyValuesHolder.setDuration(j / 2);
            valueAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
            valueAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            valueAnimatorOfPropertyValuesHolder.setRepeatMode(2);
            return valueAnimatorOfPropertyValuesHolder;
        }

        static ValueAnimator evg_(int i, float f, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("scale", Keyframe.ofFloat(0.0f, 0.93f), Keyframe.ofFloat(0.4f, 0.65f), Keyframe.ofFloat(0.9f, 1.0f), Keyframe.ofFloat(1.0f, 0.93f)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofInt(0.0f, 255), Keyframe.ofInt(0.4f, 51), Keyframe.ofInt(0.8f, 255), Keyframe.ofInt(1.0f, 255)), PropertyValuesHolder.ofFloat("degrees", f, 360.0f + f));
            valueAnimatorOfPropertyValuesHolder.setDuration(i);
            valueAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            valueAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            valueAnimatorOfPropertyValuesHolder.setRepeatMode(1);
            valueAnimatorOfPropertyValuesHolder.addUpdateListener(animatorUpdateListener);
            return valueAnimatorOfPropertyValuesHolder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float euU_(float f2, DisplayMetrics displayMetrics) {
        return f2 * displayMetrics.density;
    }

    void d() {
        if (this.i) {
            this.h.end();
            this.f.end();
            this.i = false;
        }
    }

    private static g c(int i2, n nVar) {
        return new g(nVar.b, new k(i2, nVar.c, nVar.d, nVar.f11081a), false);
    }

    private static g b(int i2, n nVar, e eVar) {
        k kVar = new k(i2, nVar.c, eVar.b, eVar.f11074a);
        kVar.b(j.a(eVar.d));
        k kVar2 = new k(i2, nVar.c, nVar.d);
        kVar2.b(j.a(nVar.e));
        return new g(nVar.b, kVar2, kVar, true);
    }

    public static h a(int i2, d dVar) {
        return new h(i2, dVar.e.f11082a, dVar.e.b, dVar.e.c, dVar.f11073a);
    }

    public static int a(int i2) {
        return ColorUtils.setAlphaComponent(i2, 255);
    }
}
