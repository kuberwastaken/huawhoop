package defpackage;

import android.text.TextUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes7.dex */
public class nxq {
    public static boolean a(String str) {
        return TextUtils.isEmpty(str);
    }

    public static void c(ExecutorService executorService) {
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
