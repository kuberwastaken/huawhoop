package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes6.dex */
public class k {
    public static void d(Context context, String str) {
        try {
            Toast toastMakeText = Toast.makeText(context, (CharSequence) null, 0);
            toastMakeText.setText(str);
            toastMakeText.show();
        } catch (Throwable unused) {
            h.e("FaqToastUtils", "toast makeText exception");
        }
    }
}
