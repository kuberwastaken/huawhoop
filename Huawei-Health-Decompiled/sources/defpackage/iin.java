package defpackage;

import android.text.TextUtils;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.hwlogsmodel.LogUtil;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class iin {
    private static final String d = ody.b + "dynamic_track_map_resource" + File.separator;

    public static String c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append(d);
        sb.append("language");
        sb.append(File.separator);
        sb.append(str);
        sb.append(File.separator);
        sb.append(str2);
        sb.append(File.separator);
        sb.append(str3);
        sb.append(".json");
        return sb.toString();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append(d);
        sb.append(NetworkService.Constants.CONFIG_SERVICE);
        sb.append(File.separator);
        sb.append(str);
        sb.append(File.separator);
        sb.append(str2);
        sb.append(".json");
        return sb.toString();
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append(d);
        sb.append(str);
        sb.append(File.separator);
        return sb.toString();
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append(d);
        sb.append("image");
        sb.append(File.separator);
        sb.append(str);
        sb.append(File.separator);
        sb.append(str2);
        sb.append(".png");
        return sb.toString();
    }

    public static String d(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append(d);
        sb.append(str2);
        sb.append(File.separator);
        sb.append(str);
        sb.append(File.separator);
        if (i == 1) {
            sb.append("10.0");
            sb.append(File.separator);
        }
        sb.append(str3);
        sb.append(File.separator);
        if (i == 1) {
            sb.append("style.data");
        } else {
            sb.append(str3);
            sb.append(".json");
        }
        return sb.toString();
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append(d);
        sb.append(str2);
        sb.append(File.separator);
        sb.append(str);
        sb.append(File.separator);
        sb.append("10.0");
        sb.append(File.separator);
        sb.append(str3);
        sb.append(File.separator);
        sb.append("style_extra.data");
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r4) {
        /*
            r4.hashCode()
            int r0 = r4.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1542515789: goto L2f;
                case -1534824874: goto L24;
                case -1497224444: goto L19;
                case -1216698124: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L3a
        Le:
            java.lang.String r0 = "mark_config"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L17
            goto L3a
        L17:
            r0 = r1
            goto L3b
        L19:
            java.lang.String r0 = "huawei_map"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L22
            goto L3a
        L22:
            r0 = r2
            goto L3b
        L24:
            java.lang.String r0 = "google_map"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L2d
            goto L3a
        L2d:
            r0 = r3
            goto L3b
        L2f:
            java.lang.String r0 = "gaode_map"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L38
            goto L3a
        L38:
            r0 = 0
            goto L3b
        L3a:
            r0 = -1
        L3b:
            if (r0 == 0) goto L5a
            if (r0 == r3) goto L57
            if (r0 == r2) goto L54
            if (r0 == r1) goto L51
            java.lang.String r0 = "mapType is exception "
            java.lang.Object[] r4 = new java.lang.Object[]{r0, r4}
            java.lang.String r0 = "DynamicCustomMapConfigParam"
            com.huawei.hwlogsmodel.LogUtil.j(r0, r4)
            java.lang.String r4 = ""
            goto L5c
        L51:
            java.lang.String r4 = "CustomMarkStyle"
            goto L5c
        L54:
            java.lang.String r4 = "HmsCustomStyle"
            goto L5c
        L57:
            java.lang.String r4 = "GoogleMapCustomStyle"
            goto L5c
        L5a:
            java.lang.String r4 = "GaoDeMapCustomStyle"
        L5c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iin.a(java.lang.String):java.lang.String");
    }

    public static String d(int i) {
        if (i == 1) {
            return "gaode_map";
        }
        if (i == 2) {
            return "google_map";
        }
        if (i == 3) {
            return "huawei_map";
        }
        LogUtil.j("DynamicCustomMapConfigParam", "getMapFileName is exception ", Integer.valueOf(i));
        return "";
    }
}
