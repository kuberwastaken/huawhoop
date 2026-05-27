package com.huawei.uikit.hwspinner.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes11.dex */
public class HwCheckedTextView extends CheckedTextView {
    public HwCheckedTextView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean isClickable() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        return !(accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) && super.isClickable();
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        boolean zIsPressed = isPressed();
        super.setSelected(z);
        if (z || zIsPressed == isPressed()) {
            return;
        }
        setPressed(zIsPressed);
    }

    public HwCheckedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HwCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
