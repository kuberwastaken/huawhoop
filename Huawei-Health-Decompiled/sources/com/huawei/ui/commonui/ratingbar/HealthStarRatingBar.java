package com.huawei.ui.commonui.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.huawei.health.R;
import com.huawei.ui.commonui.R$styleable;

/* JADX INFO: loaded from: classes7.dex */
public class HealthStarRatingBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f9286a;
    private Drawable b;
    private Drawable d;
    private int e;

    public HealthStarRatingBar(Context context) {
        super(context);
        cPy_(context, null);
    }

    public HealthStarRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cPy_(context, attributeSet);
    }

    public HealthStarRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cPy_(context, attributeSet);
    }

    private void cPy_(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        setGravity(17);
        if (attributeSet == null) {
            this.e = 5;
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HealthStarRatingBar);
            this.e = typedArrayObtainStyledAttributes.getInteger(R$styleable.HealthStarRatingBar_starCount, 5);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.b = ContextCompat.getDrawable(context, R.mipmap._2131821631_res_0x7f11043f);
        this.f9286a = ContextCompat.getDrawable(context, R.mipmap._2131821633_res_0x7f110441);
        this.d = ContextCompat.getDrawable(context, R.mipmap._2131821632_res_0x7f110440);
        for (int i = 0; i < this.e; i++) {
            addView(getStarImageView());
        }
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageDrawable(this.b);
        return imageView;
    }

    public void setStar(int i) {
        int i2 = this.e * 2;
        if (i >= i2) {
            i = i2;
        }
        if (i <= 0) {
            i = 0;
        }
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            cPz_(getChildAt(i4), this.d);
        }
        for (int i5 = i3; i5 < this.e; i5++) {
            cPz_(getChildAt(i5), this.b);
        }
        if (i % 2 == 1) {
            cPz_(getChildAt(i3), this.f9286a);
        }
    }

    private void cPz_(View view, Drawable drawable) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(drawable);
        }
    }
}
