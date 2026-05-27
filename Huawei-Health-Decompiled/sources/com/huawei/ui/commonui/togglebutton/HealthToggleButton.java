package com.huawei.ui.commonui.togglebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.huawei.ui.commonui.R$styleable;
import com.huawei.uikit.phone.hwtoggle.widget.HwToggleButton;

/* JADX INFO: loaded from: classes7.dex */
public class HealthToggleButton extends HwToggleButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f9323a;
    private final CharSequence c;
    private boolean d;

    public HealthToggleButton(Context context) {
        super(context);
        this.d = false;
        this.c = getTextOn();
        this.f9323a = getTextOff();
        cRQ_(context, null);
    }

    public HealthToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.c = getTextOn();
        this.f9323a = getTextOff();
        cRQ_(context, attributeSet);
    }

    public HealthToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.c = getTextOn();
        this.f9323a = getTextOff();
        cRQ_(context, attributeSet);
    }

    private void cRQ_(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HealthToggleButton);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HealthToggleButton_showOnOffText, false);
        this.d = z;
        a(z);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a(boolean z) {
        this.d = z;
        if (z) {
            setTextOn(this.c);
            setTextOff(this.f9323a);
        } else {
            setTextOn(null);
            setTextOff(null);
        }
        requestLayout();
    }
}
