package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5780a = "PingNet";
    public static final String b = "\n";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e5 A[PHI: r3 r4 r9 r11 r12
      0x00e5: PHI (r3v3 com.huawei.hms.network.embedded.a6) = (r3v1 com.huawei.hms.network.embedded.a6), (r3v4 com.huawei.hms.network.embedded.a6) binds: [B:49:0x00c1, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]
      0x00e5: PHI (r4v6 java.io.InputStreamReader) = (r4v4 java.io.InputStreamReader), (r4v7 java.io.InputStreamReader) binds: [B:49:0x00c1, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]
      0x00e5: PHI (r9v13 ??) = (r9v16 ??), (r9v17 ??) binds: [B:49:0x00c1, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]
      0x00e5: PHI (r11v5 java.io.BufferedReader) = (r11v3 java.io.BufferedReader), (r11v6 java.io.BufferedReader) binds: [B:49:0x00c1, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]
      0x00e5: PHI (r12v10 ??) = (r12v20 ??), (r12v21 ??) binds: [B:49:0x00c1, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f5  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.StringBuffer] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.ProcessBuilder] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.network.embedded.a6 a(java.lang.String r9, int r10, int r11, java.lang.StringBuffer r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.z5.a(java.lang.String, int, int, java.lang.StringBuffer):com.huawei.hms.network.embedded.a6");
    }

    public static String[] a(a6 a6Var) {
        return new String[]{r3.r, "-c", String.valueOf(a6Var.d()), "-w", String.valueOf(a6Var.f()), a6Var.b()};
    }

    public static void a(StringBuffer stringBuffer, String str) {
        if (stringBuffer != null) {
            stringBuffer.append(str).append("\n");
        }
    }

    public static String a(String str) {
        String strSubstring = null;
        for (String str2 : str.split("\n")) {
            if (str2.contains("time=")) {
                strSubstring = str2.substring(str2.indexOf("time=") + 5);
                Logger.v(f5780a, "the ping time is : " + strSubstring);
            }
        }
        return strSubstring;
    }

    public static a6 a(String str, a6 a6Var) {
        String strA = a(str);
        if (strA != null) {
            a6Var.d(strA);
            Logger.v(f5780a, "ping time:" + strA);
        }
        if (str.contains("avg")) {
            int iIndexOf = str.indexOf("/", 20);
            int iIndexOf2 = str.indexOf(".", iIndexOf);
            StringBuilder sb = new StringBuilder("ping avg time:");
            int i = iIndexOf + 1;
            sb.append(str.substring(i, iIndexOf2));
            sb.append("ms");
            Logger.v(f5780a, sb.toString());
            a6Var.a(str.substring(i, iIndexOf2) + "ms");
        }
        if (str.contains("packet loss")) {
            int iIndexOf3 = str.indexOf("%");
            StringBuilder sb2 = new StringBuilder("packet loss rate:");
            int i2 = iIndexOf3 - 2;
            sb2.append(str.substring(i2, iIndexOf3));
            Logger.v(f5780a, sb2.toString());
            a6Var.c(str.substring(i2, iIndexOf3));
        }
        return a6Var;
    }
}
