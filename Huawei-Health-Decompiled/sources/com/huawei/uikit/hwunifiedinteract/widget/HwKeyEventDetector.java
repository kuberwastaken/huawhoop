package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public class HwKeyEventDetector {
    private View b = null;
    private OnEditEventListener d = null;
    private OnSearchEventListener c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnNextTabEventListener f11271a = null;
    private OnGlobalNextTabEventListener e = null;
    private View.OnUnhandledKeyEventListener g = null;

    public interface OnEditEventListener {
        boolean onCopy(int i, KeyEvent keyEvent);

        boolean onCut(int i, KeyEvent keyEvent);

        boolean onDelete(int i, KeyEvent keyEvent);

        boolean onPaste(int i, KeyEvent keyEvent);

        boolean onSelectAll(int i, KeyEvent keyEvent);

        boolean onUndo(int i, KeyEvent keyEvent);
    }

    public interface OnGlobalNextTabEventListener {
        boolean onGlobalNextTab(int i, KeyEvent keyEvent);
    }

    public interface OnNextTabEventListener {
        boolean onNextTab(int i, KeyEvent keyEvent);
    }

    public interface OnSearchEventListener {
        boolean onSearch(int i, KeyEvent keyEvent);
    }

    class c implements View.OnUnhandledKeyEventListener {
        c() {
        }

        @Override // android.view.View.OnUnhandledKeyEventListener
        public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            return HwKeyEventDetector.this.eGn_(view, keyEvent);
        }
    }

    public HwKeyEventDetector(Context context) {
    }

    private boolean b(int i, int i2, KeyEvent keyEvent) {
        OnEditEventListener onEditEventListener;
        if (i != 112 || (onEditEventListener = this.d) == null) {
            return false;
        }
        return onEditEventListener.onDelete(i2, keyEvent);
    }

    public OnSearchEventListener a() {
        return this.c;
    }

    public void a(OnEditEventListener onEditEventListener) {
        this.d = onEditEventListener;
    }

    public void a(OnSearchEventListener onSearchEventListener) {
        this.c = onSearchEventListener;
    }

    public void b(OnNextTabEventListener onNextTabEventListener) {
        this.f11271a = onNextTabEventListener;
    }

    public OnEditEventListener c() {
        return this.d;
    }

    public void e() {
        c(false);
    }

    public boolean eGo_(int i, KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (!keyEvent.isCtrlPressed()) {
            return b(i, action, keyEvent);
        }
        if (eGm_(i, action, keyEvent)) {
            return true;
        }
        OnNextTabEventListener onNextTabEventListener = this.f11271a;
        if (onNextTabEventListener != null && i == 61 && onNextTabEventListener.onNextTab(action, keyEvent)) {
            return true;
        }
        OnSearchEventListener onSearchEventListener = this.c;
        return onSearchEventListener != null && i == 34 && onSearchEventListener.onSearch(action, keyEvent);
    }

    public void eGp_(View view, OnGlobalNextTabEventListener onGlobalNextTabEventListener) {
        this.b = view;
        this.e = onGlobalNextTabEventListener;
        c(onGlobalNextTabEventListener != null);
    }

    private void c(boolean z) {
        if (Build.VERSION.SDK_INT < 28) {
            Log.w("HwKeyEventDetector", "unhandledKeyEventListenerProc: need minimum sdk version 28.");
            return;
        }
        View view = this.b;
        if (view == null) {
            return;
        }
        if (z) {
            if (this.g == null) {
                c cVar = new c();
                this.g = cVar;
                this.b.addOnUnhandledKeyEventListener(cVar);
                return;
            }
            return;
        }
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = this.g;
        if (onUnhandledKeyEventListener != null) {
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            this.g = null;
        }
    }

    private boolean eGm_(int i, int i2, KeyEvent keyEvent) {
        OnEditEventListener onEditEventListener = this.d;
        if (onEditEventListener == null) {
            return false;
        }
        if (i != 29) {
            if (i != 31) {
                if (i != 50) {
                    if (i != 52) {
                        if (i == 54 && onEditEventListener.onUndo(i2, keyEvent)) {
                            return true;
                        }
                    } else if (onEditEventListener.onCut(i2, keyEvent)) {
                        return true;
                    }
                } else if (onEditEventListener.onPaste(i2, keyEvent)) {
                    return true;
                }
            } else if (onEditEventListener.onCopy(i2, keyEvent)) {
                return true;
            }
        } else if (onEditEventListener.onSelectAll(i2, keyEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eGn_(View view, KeyEvent keyEvent) {
        return this.e != null && keyEvent.getKeyCode() == 61 && keyEvent.isCtrlPressed() && this.e.onGlobalNextTab(keyEvent.getAction(), keyEvent);
    }
}
