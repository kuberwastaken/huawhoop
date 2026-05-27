package com.huawei.haf.common.os;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.huawei.haf.application.BaseApplication;

/* JADX INFO: loaded from: classes.dex */
public class KeyboardUtils {
    public static void yP_(View view) {
        Object systemService = BaseApplication.a().getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
