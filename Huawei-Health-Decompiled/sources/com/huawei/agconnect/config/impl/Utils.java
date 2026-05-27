package com.huawei.agconnect.config.impl;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Utils {
    private static final int BUFF_SIZE = 4096;
    public static final String DEFAULT_NAME = "DEFAULT_INSTANCE";
    private static final String TAG = "Utils";

    public static String toString(InputStream inputStream, String str) throws IOException {
        StringWriter stringWriter = new StringWriter();
        copy(new java.io.InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.agconnect.AGCRoutePolicy getRoutePolicyFromJson(java.lang.String r4, java.lang.String r5) {
        /*
            if (r4 == 0) goto L60
            r4.hashCode()
            int r5 = r4.hashCode()
            r0 = 2155(0x86b, float:3.02E-42)
            r1 = 3
            r2 = 2
            r3 = 1
            if (r5 == r0) goto L3e
            r0 = 2177(0x881, float:3.05E-42)
            if (r5 == r0) goto L33
            r0 = 2627(0xa43, float:3.681E-42)
            if (r5 == r0) goto L28
            r0 = 2644(0xa54, float:3.705E-42)
            if (r5 == r0) goto L1d
            goto L46
        L1d:
            java.lang.String r5 = "SG"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L26
            goto L46
        L26:
            r4 = r1
            goto L49
        L28:
            java.lang.String r5 = "RU"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L31
            goto L46
        L31:
            r4 = r2
            goto L49
        L33:
            java.lang.String r5 = "DE"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L3c
            goto L46
        L3c:
            r4 = r3
            goto L49
        L3e:
            java.lang.String r5 = "CN"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L48
        L46:
            r4 = -1
            goto L49
        L48:
            r4 = 0
        L49:
            if (r4 == 0) goto L5d
            if (r4 == r3) goto L5a
            if (r4 == r2) goto L57
            if (r4 == r1) goto L54
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.UNKNOWN
            return r4
        L54:
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.SINGAPORE
            return r4
        L57:
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.RUSSIA
            return r4
        L5a:
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.GERMANY
            return r4
        L5d:
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.CHINA
            return r4
        L60:
            if (r5 == 0) goto L8e
            java.lang.String r4 = "connect-drcn"
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L6d
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.CHINA
            return r4
        L6d:
            java.lang.String r4 = "connect-dre"
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L78
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.GERMANY
            return r4
        L78:
            java.lang.String r4 = "connect-drru"
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L83
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.RUSSIA
            return r4
        L83:
            java.lang.String r4 = "connect-dra"
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L8e
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.SINGAPORE
            return r4
        L8e:
            com.huawei.agconnect.AGCRoutePolicy r4 = com.huawei.agconnect.AGCRoutePolicy.UNKNOWN
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.Utils.getRoutePolicyFromJson(java.lang.String, java.lang.String):com.huawei.agconnect.AGCRoutePolicy");
    }

    public static String fixPath(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return "/" + str.substring(i);
    }

    public static Map<String, String> fixKeyPathMap(Map<String, String> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map2.put(fixPath(entry.getKey()), entry.getValue());
        }
        return map2;
    }

    public static void copy(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int i = reader.read(cArr);
            if (-1 == i) {
                return;
            } else {
                writer.write(cArr, 0, i);
            }
        }
    }

    public static void copy(Reader reader, Writer writer) throws IOException {
        copy(reader, writer, new char[4096]);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e("Utils", "Exception when closing the 'Closeable'.");
            }
        }
    }
}
