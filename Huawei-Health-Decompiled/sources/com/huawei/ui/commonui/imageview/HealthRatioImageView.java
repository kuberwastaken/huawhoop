package com.huawei.ui.commonui.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.ui.commonui.R$styleable;

/* JADX INFO: loaded from: classes11.dex */
public class HealthRatioImageView extends AppCompatImageView {
    private float b;

    public HealthRatioImageView(Context context) {
        super(context);
    }

    public HealthRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cLn_(context, attributeSet);
    }

    public HealthRatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cLn_(context, attributeSet);
    }

    private void cLn_(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HealthRatioImageView);
        this.b = typedArrayObtainStyledAttributes.getFloat(R$styleable.HealthRatioImageView_widthHeightRatio, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public float getWidthHeightRatio() {
        return this.b;
    }

    public void setWidthHeightRatio(float f) {
        this.b = f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b <= 0.0f) {
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, (int) (size / this.b));
    }
}
