package com.huawei.phoneservice.faq.base.util;

import android.app.Dialog;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    public static void cjx_(Dialog dialog) {
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        dialog.show();
    }
}
