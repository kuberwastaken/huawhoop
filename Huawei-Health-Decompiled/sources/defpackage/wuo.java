package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes11.dex */
public class wuo {
    public static int b(Exception exc) {
        if (exc instanceof IllegalStateException) {
            String message = exc.getMessage();
            if (!TextUtils.isEmpty(message)) {
                try {
                    return Integer.parseInt(message);
                } catch (NumberFormatException unused) {
                    return 1;
                }
            }
        }
        return 12;
    }
}
