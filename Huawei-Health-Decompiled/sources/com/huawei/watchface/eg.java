package com.huawei.watchface;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.watchface.environment.Environment;
import com.huawei.watchface.utils.DensityUtil;

/* JADX INFO: loaded from: classes8.dex */
public final class eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f11512a = new Handler(Looper.getMainLooper());
    private static Toast b;

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(str, 0);
    }

    private static void b(final CharSequence charSequence, final int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(charSequence, i);
        } else {
            f11512a.post(new Runnable() { // from class: com.huawei.watchface.eg.1
                @Override // java.lang.Runnable
                public void run() {
                    eg.c(charSequence, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(CharSequence charSequence, int i) {
        Toast toast = b;
        if (toast != null) {
            toast.cancel();
        }
        Context contextA = Environment.a();
        if (contextA != null) {
            Toast toastMakeText = Toast.makeText(contextA, charSequence, i);
            b = toastMakeText;
            toastMakeText.show();
        }
    }

    private static void a(int i, int i2) {
        b(DensityUtil.getStringById(i), i2);
    }

    public static void a(int i) {
        a(i, 0);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(str, 1);
    }
}
