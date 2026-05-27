package defpackage;

import android.graphics.Canvas;
import android.util.Log;
import android.widget.ImageView;
import com.huawei.uikit.hwimageview.widget.HwParallaxStyle;

/* JADX INFO: loaded from: classes11.dex */
public class vob implements HwParallaxStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18689a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean h = false;

    private void eBy_(ImageView imageView) {
        this.f18689a = imageView.getDrawable().getIntrinsicWidth();
        this.c = imageView.getDrawable().getIntrinsicHeight();
        this.d = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        this.b = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        this.h = true;
    }

    private boolean eBz_(ImageView imageView) {
        if (!this.h) {
            eBy_(imageView);
        }
        if (imageView.getScaleType() != ImageView.ScaleType.CENTER_CROP) {
            Log.e("HwVerticalOffsetStyle", "isSupportable: Unsupported ImageView Scale Type, parallax only support CENTER_CROP.");
        }
        if (this.f18689a <= 0 || this.c <= 0) {
            Log.e("HwVerticalOffsetStyle", "isSupportable: Unsupported ImagView: ImageView's height and width should greater than 0.");
        }
        return this.f18689a * this.b < this.c * this.d;
    }

    @Override // com.huawei.uikit.hwimageview.widget.HwParallaxStyle
    public void onAttachedToImageView(ImageView imageView) {
    }

    @Override // com.huawei.uikit.hwimageview.widget.HwParallaxStyle
    public void onDetachedFromImageView(ImageView imageView) {
    }

    @Override // com.huawei.uikit.hwimageview.widget.HwParallaxStyle
    public void transform(ImageView imageView, Canvas canvas, int[] iArr, int[] iArr2) {
        if (imageView == null || canvas == null || iArr == null || iArr2 == null) {
            Log.w("HwVerticalOffsetStyle", "transform: input params contains null");
            return;
        }
        if (iArr.length <= 1 || iArr2.length <= 1) {
            return;
        }
        int i = iArr[1];
        this.e = iArr2[1];
        if (eBz_(imageView)) {
            if (i < 0) {
                i = 0;
            } else {
                int i2 = this.e - this.b;
                if (i > i2) {
                    i = i2;
                } else {
                    Log.w("HwVerticalOffsetStyle", "transform: do not handle");
                }
            }
            int i3 = this.f18689a;
            float fAbs = Math.abs(((this.c * (i3 == 0 ? 1.0f : this.d / i3)) - this.b) * 0.5f);
            int i4 = this.b - this.e;
            if (i4 != 0) {
                canvas.translate(0.0f, (fAbs * ((i * 2) - (r0 - r7))) / i4);
            }
        }
    }
}
