package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import com.huawei.health.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public class vny extends Drawable {
    private TextPaint c;
    private Paint e;
    private int f;
    private float g;
    private float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private int n;
    private int o;
    private Context q;
    private int d = 0;
    private int b = 99;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18686a = "";
    private int m = 2;

    public vny() {
        j();
    }

    private void d(Context context) {
        float f = context.getResources().getConfiguration().fontScale;
        this.h = f;
        if (Float.compare(f, 1.75f) < 0 || !vpc.c(this.q)) {
            return;
        }
        this.f = context.getResources().getDimensionPixelSize(R.dimen._2131364308_res_0x7f0a09d4);
        this.c.setTextSize(context.getResources().getDimensionPixelSize(R.dimen._2131362722_res_0x7f0a03a2));
        this.k = context.getResources().getDimensionPixelSize(R.dimen._2131364308_res_0x7f0a09d4);
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        if (this.m != i) {
            this.m = i;
            if (Float.compare(this.h, 1.75f) >= 0 && this.m == 2 && vpc.c(this.q)) {
                this.f = this.q.getResources().getDimensionPixelSize(R.dimen._2131364308_res_0x7f0a09d4);
                this.c.setTextSize(this.q.getResources().getDimensionPixelSize(R.dimen._2131362722_res_0x7f0a03a2));
                this.k = this.q.getResources().getDimensionPixelSize(R.dimen._2131364308_res_0x7f0a09d4);
            } else {
                this.f = this.q.getResources().getDimensionPixelSize(R.dimen._2131364306_res_0x7f0a09d2);
                this.c.setTextSize(this.q.getResources().getDimensionPixelSize(R.dimen._2131362720_res_0x7f0a03a0));
                this.k = this.q.getResources().getDimensionPixelSize(R.dimen._2131364307_res_0x7f0a09d3);
            }
            d();
        }
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.e.setColor(i);
        invalidateSelf();
    }

    public int c() {
        return this.m;
    }

    public void c(int i) {
        if (this.c.getColor() != i) {
            this.c.setColor(i);
            invalidateSelf();
        }
    }

    public void d() {
        int i = this.k;
        this.n = i;
        this.o = i;
        int i2 = this.m;
        if (i2 == 1) {
            int i3 = this.f;
            this.n = i3;
            this.o = i3;
        } else if (i2 == 2) {
            float fMeasureText = this.c.measureText(this.f18686a);
            float fDescent = this.c.descent();
            float fAscent = this.c.ascent();
            int i4 = this.d;
            if (i4 > 0 && i4 < 10) {
                int i5 = this.k;
                this.n = i5;
                this.o = i5;
            } else if (i4 >= 10) {
                this.n = Math.round((this.l * 2.0f) + fMeasureText);
                this.o = this.k;
            } else {
                Log.e("HwEventBadgeDrawable", "invalid badge count");
            }
            this.i = (this.n - fMeasureText) / 2.0f;
            this.g = ((this.o - (fDescent - fAscent)) / 2.0f) - this.c.ascent();
        } else {
            Log.e("HwEventBadgeDrawable", "invalid badge mode");
        }
        invalidateSelf();
    }

    public void d(int i) {
        a(i, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds;
        if (canvas != null && (bounds = getBounds()) != null && bounds.right > bounds.left && bounds.bottom > bounds.top && this.d > 0) {
            canvas.save();
            int i = this.m;
            if (i == 1) {
                canvas.drawCircle(bounds.left + (bounds.width() / 2.0f), bounds.top + (bounds.height() / 2.0f), this.o / 2.0f, this.e);
            } else if (i == 2) {
                canvas.translate((bounds.width() - this.n) / 2.0f, (bounds.height() - this.o) / 2.0f);
                RectF rectF = new RectF(bounds.left, bounds.top, r1 + this.n, r3 + this.o);
                float f = this.j;
                canvas.drawRoundRect(rectF, f, f, this.e);
                canvas.drawText(this.f18686a, bounds.left + this.i, bounds.top + this.g, this.c);
            } else {
                Log.e("HwEventBadgeDrawable", "invalid badge mode");
            }
            canvas.restore();
        }
    }

    public TextPaint eBe_() {
        return this.c;
    }

    public void eBf_(Context context, AttributeSet attributeSet, int i) {
        eBg_(context, attributeSet, i, R.style.Widget_Emui_HwEventBadge);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return getAlpha() == 0 ? -2 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
        this.c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
        this.c.setColorFilter(colorFilter);
    }

    public void a(int i, int i2) {
        if (i < 0) {
            Log.w("HwEventBadgeDrawable", "setBadgeCount method: param count must be equals or bigger than zero");
            return;
        }
        if (this.d != i) {
            this.d = i;
        }
        if (this.b != i2) {
            this.b = i2;
        }
        if (this.d <= i2) {
            this.f18686a = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(this.d));
        } else {
            this.f18686a = String.format(Locale.getDefault(), "%d+", Integer.valueOf(i2));
        }
        d();
    }

    public void eBg_(Context context, AttributeSet attributeSet, int i, int i2) {
        if (context == null) {
            return;
        }
        this.q = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100480_res_0x7f060340, R.attr._2131100481_res_0x7f060341, R.attr._2131100482_res_0x7f060342, R.attr._2131100483_res_0x7f060343, R.attr._2131100485_res_0x7f060345, R.attr._2131100486_res_0x7f060346, R.attr._2131100487_res_0x7f060347, R.attr._2131100488_res_0x7f060348}, i, i2);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, context.getResources().getDimensionPixelSize(R.dimen._2131364306_res_0x7f0a09d2));
        this.m = typedArrayObtainStyledAttributes.getInt(3, 2);
        this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, context.getResources().getDimensionPixelSize(R.dimen._2131364307_res_0x7f0a09d3));
        this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, context.getResources().getDimensionPixelSize(R.dimen._2131364309_res_0x7f0a09d5));
        this.c.setColor(typedArrayObtainStyledAttributes.getColor(4, ContextCompat.getColor(context, R.color._2131297641_res_0x7f090569)));
        this.c.setTextSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(7, context.getResources().getDimensionPixelSize(R.dimen._2131362720_res_0x7f0a03a0)));
        this.e.setColor(typedArrayObtainStyledAttributes.getColor(0, ContextCompat.getColor(context, R.color._2131297498_res_0x7f0904da)));
        d();
        this.j = typedArrayObtainStyledAttributes.getDimension(6, this.o / 2.0f);
        d(context);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void j() {
        TextPaint textPaint = new TextPaint();
        this.c = textPaint;
        textPaint.setAntiAlias(true);
        this.c.setFilterBitmap(true);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
    }
}
