package com.huawei.uikit.hwfloatingactionbutton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.huawei.health.R;
import com.huawei.hwfabengine.FloatingActionButtonAnimationListener;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import defpackage.mfy;
import defpackage.vnx;
import defpackage.vpb;
import defpackage.vpd;
import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public class HwFloatingActionButton extends FloatingActionButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private vnx f11162a;
    private int[] b;
    private int[] c;
    private int[] d;
    private boolean e;
    private mfy f;
    private float g;
    private FloatingActionButtonAnimationListener h;
    private String i;
    private float j;
    private final FloatingActionButtonAnimationListener l;

    class e implements FloatingActionButtonAnimationListener {
        e() {
        }

        @Override // com.huawei.hwfabengine.FloatingActionButtonAnimationListener
        public void onAnimationEnd() {
            if (HwFloatingActionButton.this.h != null) {
                HwFloatingActionButton.this.h.onAnimationEnd();
            }
        }

        @Override // com.huawei.hwfabengine.FloatingActionButtonAnimationListener
        public void onAnimationUpdate(float f) {
            if (HwFloatingActionButton.this.h != null) {
                HwFloatingActionButton.this.h.onAnimationUpdate(f);
            }
            HwFloatingActionButton.this.setAnimatorValue(f);
        }
    }

    public HwFloatingActionButton(Context context) {
        this(context, null);
    }

    public static HwFloatingActionButton b(Context context) {
        Object objC = vpb.c(context, vpb.d(context, HwFloatingActionButton.class, vpb.e(context, 1, 1)), HwFloatingActionButton.class);
        if (objC instanceof HwFloatingActionButton) {
            return (HwFloatingActionButton) objC;
        }
        return null;
    }

    private HwTextView getLabelView() {
        if (getTag(R.id.hwfab_label) instanceof HwTextView) {
            return (HwTextView) getTag(R.id.hwfab_label);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimatorValue(float f) {
        this.g = f;
        invalidate();
    }

    public String getTitle() {
        return this.i;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        eBk_(getParent());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        eBj_(canvas);
        super.onDraw(canvas);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (this.f == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f.b();
        } else if (action == 1 || action == 3) {
            this.f.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        a(z);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        if (drawable2 instanceof mfy) {
            ((mfy) drawable2).b(null);
        }
        if (drawable instanceof mfy) {
            mfy mfyVar = (mfy) drawable;
            this.f = mfyVar;
            this.h = mfyVar.e();
            this.f.b(this.l);
        }
        super.setImageDrawable(drawable);
    }

    public void setShadowColors(int[] iArr) {
        if (iArr == null || iArr.length != this.b.length) {
            return;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        this.b = iArrCopyOf;
        if (iArrCopyOf[0] == 0 || iArrCopyOf[1] == 0) {
            return;
        }
        this.e = true;
        b(iArrCopyOf);
    }

    public void setTitle(String str) {
        this.i = str;
        HwTextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(this.i);
            labelView.setAutoTextInfo(9, 1, 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return this.f11162a == drawable || super.verifyDrawable(drawable);
    }

    public HwFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100510_res_0x7f06035e);
    }

    public HwFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(e(context, i), attributeSet, i);
        this.e = false;
        this.b = new int[]{0, 0};
        this.c = new int[]{0, 0};
        this.d = new int[]{0, 0};
        this.j = 0.0f;
        this.g = 1.0f;
        this.l = new e();
        a(super.getContext(), attributeSet, i);
    }

    private static Context e(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwFloatingActionButton);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100491_res_0x7f06034b, R.attr._2131100492_res_0x7f06034c, R.attr._2131100503_res_0x7f060357, R.attr._2131100504_res_0x7f060358, R.attr._2131100505_res_0x7f060359, R.attr._2131100506_res_0x7f06035a}, i, R.style.Widget_Emui_HwFloatingActionButton);
        this.i = typedArrayObtainStyledAttributes.getString(5);
        eBi_(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void eBi_(TypedArray typedArray) {
        this.b[0] = typedArray.getColor(4, 0);
        this.b[1] = typedArray.getColor(3, 0);
        int[] iArr = this.b;
        if (iArr[0] == 0 || iArr[1] == 0) {
            return;
        }
        this.e = true;
        b(iArr);
        this.c[0] = typedArray.getColor(1, 0);
        this.c[1] = typedArray.getColor(0, 0);
    }

    private void b(int[] iArr) {
        int i = iArr[0];
        int[] iArr2 = this.d;
        if (i == iArr2[0] || iArr[1] == iArr2[1]) {
            return;
        }
        this.f11162a = new vnx(iArr, 4, 19);
        this.d = Arrays.copyOf(iArr, iArr.length);
        int customSize = (int) ((getCustomSize() + 38) * this.g);
        this.f11162a.setBounds(new Rect(0, 0, customSize, customSize));
    }

    private void eBj_(Canvas canvas) {
        int customSize;
        Bitmap bitmapEBh_;
        int i;
        int i2;
        if (this.e && (bitmapEBh_ = eBh_(this.f11162a, (customSize = (int) ((getCustomSize() + 38) * this.g)), customSize)) != null) {
            int width = getWidth() >> 1;
            int height = getHeight() >> 1;
            if (this.j != 0.0f) {
                canvas.translate(width, height);
                canvas.rotate(-this.j);
                i = width;
                i2 = height;
            } else {
                i = 0;
                i2 = 0;
            }
            int i3 = (int) (((this.g - 1.0f) * customSize) / 2.0f);
            canvas.drawBitmap(bitmapEBh_, ((0 - ((int) (r8 * 19.0f))) - i3) - i, (0 - i3) - i2, (Paint) null);
            float f = this.j;
            if (f != 0.0f) {
                canvas.rotate(f);
                canvas.translate(-width, -height);
            }
        }
    }

    private Bitmap eBh_(Drawable drawable, int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, i2, i);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void eBk_(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    private void a(boolean z) {
        if (this.e) {
            if (z) {
                b(this.b);
            } else {
                b(this.c);
            }
        }
    }
}
