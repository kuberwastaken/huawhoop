package defpackage;

import com.huawei.ads.adsrec.ICABackFlowCallback;
import com.huawei.ads.adsrec.IDsRelationCallback;
import com.huawei.ads.adsrec.IEventReportCallback;
import com.huawei.ads.adsrec.IUtilCallback;

/* JADX INFO: loaded from: classes3.dex */
public class aoy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile IDsRelationCallback f247a;
    private static volatile IUtilCallback b;
    private static volatile IEventReportCallback d;
    private static volatile ICABackFlowCallback e;

    public static void a(IUtilCallback iUtilCallback) {
        b = iUtilCallback;
    }

    public static void b(IEventReportCallback iEventReportCallback) {
        d = iEventReportCallback;
    }

    public static IUtilCallback d() {
        return b;
    }

    public static ICABackFlowCallback b() {
        return e;
    }

    public static IEventReportCallback e() {
        return d;
    }

    public static IDsRelationCallback c() {
        return f247a;
    }
}
