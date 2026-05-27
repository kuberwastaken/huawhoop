package defpackage;

import android.os.Process;
import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes8.dex */
public class vwd {
    public static void d(String str, String str2) {
        if (vwk.d(2)) {
            vwf.e().b(new vwe("I", str + Constants.LEFT_BRACKET_ONLY + Process.myTid() + Constants.RIGHT_BRACKET_ONLY, str2));
        }
    }

    public static void e(String str, String str2) {
        vwk.b(str, str2);
    }
}
