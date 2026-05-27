package defpackage;

import com.huawei.route.CpInfo;
import com.huawei.route.RouteType;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class vtc {
    public static <T> boolean a(List<T> list, int i, CpInfo cpInfo, T t) {
        return cpInfo != null && i == RouteType.EXP.routeType() && list.contains(t);
    }

    public static boolean e(int i, CpInfo cpInfo) {
        return cpInfo != null && i == RouteType.DEFAULT.routeType();
    }

    public static boolean c(double d, double d2) {
        return (Math.abs(d - d2) < 1.0E-6d && Math.abs(d2 * d) < 1.0E-6d) || d2 > 180.0d || d2 <= -180.0d || d <= -90.0d || d >= 90.0d;
    }
}
