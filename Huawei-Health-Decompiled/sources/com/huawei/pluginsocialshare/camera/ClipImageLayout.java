package com.huawei.pluginsocialshare.camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.huawei.pluginsocialshare.camera.ClipImageMaskView;
import com.huawei.pluginsocialshare.camera.ClipImageView;

/* JADX INFO: loaded from: classes7.dex */
public class ClipImageLayout extends RelativeLayout {
    private ClipImageView b;
    private ClipImageMaskView d;
    private Context e;

    public ClipImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = context;
    }

    public void cwJ_(Intent intent) {
        float fApplyDimension;
        int intExtra = intent.getIntExtra("height", -1);
        int intExtra2 = intent.getIntExtra("width", -1);
        float floatExtra = intent.getFloatExtra("scaleRatio", -1.0f);
        float floatExtra2 = intent.getFloatExtra("maxScaleRation", -1.0f);
        float floatExtra3 = intent.getFloatExtra("midScaleRation", -1.0f);
        int intExtra3 = intent.getIntExtra("HorizontalPadding", -1);
        if (intExtra3 != -1) {
            fApplyDimension = TypedValue.applyDimension(1, intExtra3, getResources().getDisplayMetrics());
        } else {
            fApplyDimension = TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics());
        }
        int i = (int) fApplyDimension;
        this.b = new ClipImageView.c(this.e, i).c(this.e).a(intExtra).d(intExtra2).e(floatExtra).c(floatExtra2).d(floatExtra3).b(i).d();
        this.d = new ClipImageMaskView.c(this.e, i).b(intExtra).c(intExtra2).d(i).b();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.b, layoutParams);
        addView(this.d, layoutParams);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.b.setImageBitmap(bitmap);
    }

    public Bitmap cwI_() {
        return this.b.cwM_();
    }
}
