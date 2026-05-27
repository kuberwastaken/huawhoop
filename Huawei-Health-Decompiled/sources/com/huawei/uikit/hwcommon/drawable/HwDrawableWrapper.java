package com.huawei.uikit.hwcommon.drawable;

import android.content.res.ColorStateList;
import android.graphics.drawable.DrawableWrapper;
import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public class HwDrawableWrapper extends DrawableWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f11120a;
    private ColorStateList c;
    private OnStateChangedListener d;

    public interface OnStateChangedListener {
        void onStateChanged(int[] iArr, int[] iArr2, int i, int i2);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.c.isStateful();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (getDrawable() != null) {
            int colorForState = this.c.getColorForState(iArr, 0);
            int colorForState2 = this.c.getColorForState(this.f11120a, 0);
            OnStateChangedListener onStateChangedListener = this.d;
            if (onStateChangedListener != null) {
                onStateChangedListener.onStateChanged(iArr, this.f11120a, colorForState, colorForState2);
            }
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        int[] state = getState();
        this.f11120a = Arrays.copyOf(state, state.length);
        return super.setState(iArr);
    }
}
