package defpackage;

import com.huawei.operation.jsoperation.JsUtil;

/* JADX INFO: loaded from: classes6.dex */
public final class mqn {
    public static int c(int i) {
        if (i == 0) {
            return 10;
        }
        return i;
    }

    public static int d(int i) {
        if (i == 2) {
            return 0;
        }
        return i;
    }

    public static int b(String str) {
        if ("beating".equals(str)) {
            return 10;
        }
        if ("timer".equals(str) || "run_time".equals(str)) {
            return 1;
        }
        if ("run_distance".equals(str)) {
            return 0;
        }
        return JsUtil.SCORE.equals(str) ? 101 : -1;
    }

    public static String a(int i) {
        return i != 0 ? i != 1 ? i != 10 ? i != 101 ? "" : JsUtil.SCORE : "beating" : "run_time" : "run_distance";
    }
}
