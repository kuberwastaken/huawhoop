package com.huawei.health.routeradapter;

import android.content.Context;
import com.huawei.haf.router.facade.service.ExtrasFormatService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class HealthRouterExtras implements ExtrasFormatService {
    public static boolean a(int i) {
        return (i & 1) == 1;
    }

    public static boolean d(int i) {
        return (i & 3) == 3;
    }

    public static boolean e(int i) {
        return (i & 2) == 2;
    }

    @Override // com.huawei.haf.router.facade.template.ServiceProvider
    public void init(Context context) {
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.huawei.health.h5.diet-diary");
        arrayList.add("com.huawei.health.h5.ai-weight");
        return arrayList;
    }

    @Override // com.huawei.haf.router.facade.service.ExtrasFormatService
    public String formatCustomString(int i) {
        StringBuilder sb = new StringBuilder(32);
        if (a(i)) {
            e(sb, "SPORT_TRACK_INIT");
        }
        if (e(i)) {
            e(sb, "CHECK_SYSTEM_VERSION");
        }
        if (d(i)) {
            e(sb, "SYNC_ALL_DEVICE_DATA");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    @Override // com.huawei.haf.router.facade.service.ExtrasFormatService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int fromExtrasString(java.lang.String r6) {
        /*
            r5 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = -1174394145(0xffffffffba002adf, float:-4.889201E-4)
            r2 = 0
            r3 = 1
            r4 = 2
            if (r0 == r1) goto L30
            r1 = -29980527(0xfffffffffe368891, float:-6.0657147E37)
            if (r0 == r1) goto L25
            r1 = 2067343727(0x7b39296f, float:9.614153E35)
            if (r0 == r1) goto L1a
            goto L38
        L1a:
            java.lang.String r0 = "SPORT_TRACK_INIT"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L23
            goto L38
        L23:
            r6 = r4
            goto L3b
        L25:
            java.lang.String r0 = "SYNC_ALL_DEVICE_DATA"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L2e
            goto L38
        L2e:
            r6 = r3
            goto L3b
        L30:
            java.lang.String r0 = "CHECK_SYSTEM_VERSION"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L3a
        L38:
            r6 = -1
            goto L3b
        L3a:
            r6 = r2
        L3b:
            if (r6 == 0) goto L46
            if (r6 == r3) goto L44
            if (r6 == r4) goto L42
            goto L47
        L42:
            r2 = r3
            goto L47
        L44:
            r2 = 3
            goto L47
        L46:
            r2 = r4
        L47:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.health.routeradapter.HealthRouterExtras.fromExtrasString(java.lang.String):int");
    }

    private static void e(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('|');
        }
        sb.append(str);
    }
}
