package defpackage;

import android.content.Context;
import com.huawei.secure.android.common.util.SafeString;

/* JADX INFO: loaded from: classes6.dex */
public class mlf {

    static class e {
        public static mlf e = new mlf();
    }

    private mlf() {
    }

    public static mlf e() {
        return e.e;
    }

    public String c(Context context) {
        String strB = b(context);
        return (strB == null || strB.length() < 3) ? "" : SafeString.substring(strB, 0, 3);
    }

    private String b(Context context) {
        return "";
    }
}
