package com.huawei.uikit.phone.hwedittext.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.huawei.uikit.phone.hwunifiedinteract.widget.HwKeyEventDetector;

/* JADX INFO: loaded from: classes8.dex */
public class HwEditText extends com.huawei.uikit.hwedittext.widget.HwEditText {
    private static final String e = "HwEditText";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11285a;
    private boolean b;
    private boolean c;
    private int d;

    public HwEditText(Context context) {
        super(context);
        this.c = false;
        this.d = 0;
    }

    private boolean a(boolean z, boolean z2) {
        return (this.f11285a && this.b) != (z && z2);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent != null && !(this.d == 1 && isDirectionalNavigationKey(keyEvent.getKeyCode())) && super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.huawei.uikit.hwedittext.widget.HwEditText, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11285a = hasFocus();
        boolean zHasWindowFocus = hasWindowFocus();
        this.b = zHasWindowFocus;
        this.c = this.f11285a && zHasWindowFocus;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            Log.d(e, "onDraw: canvas is null.");
            return;
        }
        super.onDraw(canvas);
        if (this.d == 1 && this.c) {
            drawFocusLayer(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (a(z, this.b)) {
            this.c = z;
        }
        this.f11285a = z;
        if (z && this.d == 0) {
            if (isInTouchMode()) {
                this.d = 3;
                setCursorVisible(true);
            } else {
                this.d = 1;
                setCursorVisible(false);
            }
        }
        if (z) {
            return;
        }
        if (this.d != 3) {
            hideSoftInput();
        }
        this.d = 0;
    }

    @Override // com.huawei.uikit.hwedittext.widget.HwEditText, android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        if (i == 4 || i == 3 || i == 124) {
            return super.onKeyPreIme(i, keyEvent);
        }
        if (this.d == 3 && i != 746) {
            this.d = 2;
            hideSoftInput();
        }
        if (this.d != 1) {
            a(i, keyEvent);
            if (this.d != 2 || i != 111) {
                return super.onKeyPreIme(i, keyEvent);
            }
            this.d = 1;
            setCursorVisible(false);
            return true;
        }
        if (isDirectionalNavigationKey(i) || i == 111) {
            return false;
        }
        if (i == 61 && keyEvent.getAction() == 0) {
            handleTabKeyEvent(keyEvent);
        }
        if (isConfirmKey(i) && keyEvent.getAction() == 1) {
            this.d = 2;
            setCursorVisible(true);
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Log.d(e, "onRestoreInstanceState()");
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        try {
            this.d = bundle.getInt("ViewState");
            setCursorVisible(bundle.getBoolean("CursorState"));
            Parcelable parcelable2 = bundle.getParcelable("InstanceState");
            if (parcelable2 != null) {
                super.onRestoreInstanceState(parcelable2);
            }
        } catch (BadParcelableException unused) {
            Log.e(e, "Parcelable, onRestoreInstanceState error");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        try {
            bundle.putParcelable("InstanceState", super.onSaveInstanceState());
            bundle.putInt("ViewState", this.d);
            bundle.putBoolean("CursorState", isCursorVisible());
        } catch (BadParcelableException unused) {
            Log.e(e, "Parcelable, onSaveInstanceState error.");
        }
        return bundle;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            setCursorVisible(true);
            this.d = 3;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (a(this.f11285a, z)) {
            this.c = z;
            if (getFocusedDrawable() != null) {
                invalidate();
            }
        }
        this.b = z;
    }

    public void requestFocusInTouchMode() {
        this.d = 3;
        requestFocus();
    }

    private void a(int i, KeyEvent keyEvent) {
        if (this.d == 4 && keyEvent.getAction() == 1 && isAltKey(i)) {
            this.d = 3;
        } else {
            if (!isShiftKey(i) || (keyEvent.getMetaState() & 2) == 0) {
                return;
            }
            this.d = 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.uikit.hwedittext.widget.HwEditText
    public HwKeyEventDetector createKeyEventDetector() {
        return new HwKeyEventDetector(getContext());
    }

    public HwEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.d = 0;
    }

    public HwEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.d = 0;
    }
}
