package ohos.ace.adapter.capability.keyboard;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.PopupWindow;
import java.util.HashMap;
import java.util.Map;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class KeyboardHeightProvider extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final String LOG_TAG = "KeyboardHeightProvider";
    private Activity activity;
    private Map<Integer, Integer> bottomMaxMap;
    private int lastKeyboardHeight;
    private int lastPortraitVisibleHeight;
    private int navigationBarHeight;
    private float navigationBarMaxHeightRate;
    private KeyboardHeightObserver observer;
    private View parentView;
    private View popupView;
    private Map<Integer, Integer> screenSizeYMap;

    public KeyboardHeightProvider(Activity activity) {
        super(activity);
        this.lastKeyboardHeight = 0;
        this.lastPortraitVisibleHeight = -1;
        this.navigationBarHeight = 0;
        this.navigationBarMaxHeightRate = 0.1f;
        this.bottomMaxMap = null;
        this.screenSizeYMap = null;
        this.activity = activity;
        this.popupView = new View(activity);
        this.bottomMaxMap = new HashMap();
        this.screenSizeYMap = new HashMap();
        setContentView(this.popupView);
        setSoftInputMode(16);
        setInputMethodMode(1);
        setWidth(0);
        setHeight(-1);
        this.popupView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view = this.popupView;
        if (view != null) {
            view.post(new Runnable() { // from class: ohos.ace.adapter.capability.keyboard.KeyboardHeightProvider.1
                @Override // java.lang.Runnable
                public void run() {
                    KeyboardHeightProvider.this.handleOnGlobalLayout();
                }
            });
        }
    }

    private int getScreenOrientation() {
        return this.activity.getResources().getConfiguration().orientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnGlobalLayout() {
        Point point = new Point();
        this.activity.getWindowManager().getDefaultDisplay().getSize(point);
        int screenOrientation = getScreenOrientation();
        Integer numValueOf = this.screenSizeYMap.get(Integer.valueOf(screenOrientation));
        int i = 0;
        if (numValueOf == null || numValueOf.intValue() < point.y) {
            if (numValueOf != null) {
                this.navigationBarHeight = 0;
            }
            numValueOf = Integer.valueOf(point.y);
            this.screenSizeYMap.put(Integer.valueOf(screenOrientation), numValueOf);
        }
        int iIntValue = (int) (numValueOf.intValue() * this.navigationBarMaxHeightRate);
        if (numValueOf.intValue() > point.y) {
            if (numValueOf.intValue() - point.y > iIntValue) {
                return;
            }
            this.navigationBarHeight = numValueOf.intValue() - point.y;
            numValueOf = Integer.valueOf(point.y);
            this.screenSizeYMap.put(Integer.valueOf(screenOrientation), numValueOf);
        }
        Integer num = this.bottomMaxMap.get(Integer.valueOf(screenOrientation));
        int iIntValue2 = num != null ? num.intValue() : 0;
        Rect rect = new Rect();
        this.popupView.getWindowVisibleDisplayFrame(rect);
        if (rect.bottom < 0) {
            return;
        }
        if (screenOrientation == 2) {
            if (rect.bottom > rect.right) {
                return;
            }
            if (iIntValue2 < rect.bottom) {
                iIntValue2 = rect.bottom;
                this.bottomMaxMap.put(Integer.valueOf(screenOrientation), Integer.valueOf(iIntValue2));
            }
            if (iIntValue2 < numValueOf.intValue()) {
                iIntValue2 = numValueOf.intValue();
                this.bottomMaxMap.put(Integer.valueOf(screenOrientation), Integer.valueOf(iIntValue2));
            }
        } else if (iIntValue2 < rect.bottom) {
            iIntValue2 = rect.bottom;
            this.bottomMaxMap.put(Integer.valueOf(screenOrientation), Integer.valueOf(iIntValue2));
        }
        if (this.navigationBarHeight > 0 && iIntValue2 - rect.bottom == this.navigationBarHeight) {
            iIntValue2 = rect.bottom;
            this.bottomMaxMap.put(Integer.valueOf(screenOrientation), Integer.valueOf(iIntValue2));
        }
        int i2 = iIntValue2 - rect.bottom;
        if (i2 > numValueOf.intValue()) {
            return;
        }
        if (i2 < iIntValue) {
            iIntValue2 -= i2;
            this.bottomMaxMap.put(Integer.valueOf(screenOrientation), Integer.valueOf(iIntValue2));
        } else {
            i = i2;
        }
        int i3 = rect.bottom - rect.top;
        if (screenOrientation == 1) {
            if ((i > iIntValue2 / 2 && i3 != this.popupView.getHeight()) || i3 <= this.lastPortraitVisibleHeight) {
                return;
            } else {
                this.lastPortraitVisibleHeight = -1;
            }
        }
        if (screenOrientation == 2) {
            this.lastPortraitVisibleHeight = i3;
            if (i3 == 0) {
                this.lastPortraitVisibleHeight = this.popupView.getHeight();
            }
        }
        if (this.lastKeyboardHeight != i) {
            notifyKeyboardHeightChanged(i);
            this.lastKeyboardHeight = i;
        }
    }

    private void notifyKeyboardHeightChanged(int i) {
        KeyboardHeightObserver keyboardHeightObserver = this.observer;
        if (keyboardHeightObserver != null) {
            keyboardHeightObserver.onKeyboardHeightChanged(i);
        }
    }

    public void setKeyboardHeightObserver(KeyboardHeightObserver keyboardHeightObserver) {
        this.observer = keyboardHeightObserver;
    }

    public void start() {
        this.parentView = this.activity.getWindow().getDecorView();
        if (isShowing() || this.parentView.getWindowToken() == null) {
            return;
        }
        setBackgroundDrawable(new ColorDrawable(0));
        this.parentView.post(new Runnable() { // from class: ohos.ace.adapter.capability.keyboard.KeyboardHeightProvider.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    KeyboardHeightProvider keyboardHeightProvider = KeyboardHeightProvider.this;
                    keyboardHeightProvider.showAtLocation(keyboardHeightProvider.parentView, 0, 0, 0);
                } catch (WindowManager.BadTokenException unused) {
                    ALog.e(KeyboardHeightProvider.LOG_TAG, "showAtLocation failed.");
                }
            }
        });
    }

    public void close() {
        this.observer = null;
        dismiss();
    }
}
