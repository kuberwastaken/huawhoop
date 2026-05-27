package com.huawei.openalliance.ad.views.viewpager;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes6.dex */
public class i extends ViewGroup.LayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f8454a = {R.attr.layout_gravity};
    public boolean b;
    public int c;
    float d;
    boolean e;
    int f;
    int g;

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f8454a);
        this.c = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
    }

    public i() {
        super(-1, -1);
        this.d = 0.0f;
    }
}
