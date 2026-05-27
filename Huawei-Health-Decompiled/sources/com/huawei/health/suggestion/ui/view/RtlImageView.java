package com.huawei.health.suggestion.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes10.dex */
public class RtlImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3547a;

    public RtlImageView(Context context) {
        this(context, null);
    }

    public RtlImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setRotationY(float f) {
        super.setRotationY(getLayoutDirection() == 1 ? 180.0f + f : f);
        this.f3547a = f;
    }

    @Override // android.view.View
    public float getRotationY() {
        return this.f3547a;
    }
}
