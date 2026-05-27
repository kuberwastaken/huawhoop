package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.embedded.k;
import com.huawei.hms.network.embedded.r3;
import com.huawei.up.request.HttpRequestBase;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    private static final String o = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, List<String>> f4727a;
    private byte[] b;
    private int c;
    private long d;
    private long e;
    private long f;
    private String g;
    private int h;
    private int i;
    private String j;
    private long k;
    private String l;
    private Exception m;
    private String n;

    private void d(String str) {
    }

    private void e(String str) {
    }

    public void a(int i) {
    }

    public boolean o() {
        return this.c == 200;
    }

    public boolean n() {
        return this.c == 503;
    }

    public boolean m() {
        return this.c == 304;
    }

    public String l() {
        return this.n;
    }

    public long k() {
        return this.k;
    }

    public String j() {
        return this.g;
    }

    public long i() {
        return this.d;
    }

    public long h() {
        return this.e;
    }

    public long g() {
        return this.f;
    }

    public int f() {
        return this.h;
    }

    public String e() {
        return this.l;
    }

    public Exception d() {
        return this.m;
    }

    public int c() {
        return this.i;
    }

    public void b(String str) {
        this.n = str;
    }

    public void b(long j) {
        this.e = j;
    }

    public int b() {
        return this.c;
    }

    public void a(String str) {
        this.l = str;
    }

    public void a(long j) {
        this.f = j;
    }

    public String a() {
        return this.j;
    }

    private void s() {
        q();
        p();
    }

    private Map<String, String> r() {
        HashMap map = new HashMap(16);
        Map<String, List<String>> map2 = this.f4727a;
        if (map2 == null || map2.size() <= 0) {
            Logger.v(o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return map;
        }
        for (Map.Entry<String, List<String>> entry : this.f4727a.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                map.put(key, it.next());
            }
        }
        return map;
    }

    private void q() {
        if (o() || n() || m()) {
            Map<String, String> mapR = r();
            if (mapR.size() <= 0) {
                Logger.w(o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(mapR);
                    a(mapR);
                }
                if (n()) {
                    c(mapR);
                }
            } catch (JSONException e) {
                Logger.w(o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
        }
    }

    private void p() {
        int i;
        if (m()) {
            Logger.i(o, "GRSSDK get httpcode{304} not any changed.");
            c(1);
            return;
        }
        if (!o()) {
            Logger.i(o, "GRSSDK parse server body all failed.");
            c(2);
            return;
        }
        try {
            String strByte2Str = StringUtils.byte2Str(this.b);
            JSONObject jSONObject = new JSONObject(strByte2Str);
            if (jSONObject.has(r3.A)) {
                if (jSONObject.getInt(r3.A) == 1) {
                }
            } else if (jSONObject.has("resultCode")) {
                i = jSONObject.getInt("resultCode") == 0 ? 1 : 2;
            } else {
                Logger.e(o, "sth. wrong because server errorcode's key.");
                i = -1;
            }
            if (i == 2) {
                Logger.i(o, "server responseBody:" + StringUtils.anonymizeMessage(strByte2Str));
            }
            if (i != 1 && jSONObject.has("services")) {
                i = 0;
            }
            c(i);
            if (i == 1 || i == 0) {
                f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : "");
                e(jSONObject.has("errorList") ? jSONObject.getJSONObject("errorList").toString() : "");
            } else {
                b(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : 9001);
                d(jSONObject.has(HttpRequestBase.TAG_ERROR_DESC) ? jSONObject.getString(HttpRequestBase.TAG_ERROR_DESC) : "");
            }
        } catch (JSONException e) {
            Logger.w(o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            c(2);
        }
    }

    private void f(String str) {
        this.g = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "Retry-After"
            boolean r1 = r5.containsKey(r0)
            if (r1 == 0) goto L21
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L21
            long r0 = java.lang.Long.parseLong(r5)     // Catch: java.lang.NumberFormatException -> L19
            goto L23
        L19:
            r5 = move-exception
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.d.o
            java.lang.String r1 = "getRetryAfter addHeadersToResult NumberFormatException"
            com.huawei.hms.framework.common.Logger.w(r0, r1, r5)
        L21:
            r0 = 0
        L23:
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            java.lang.String r5 = com.huawei.hms.framework.network.grs.g.d.o
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "convert retry-afterTime{%s}"
            com.huawei.hms.framework.common.Logger.v(r5, r3, r2)
            r4.c(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.d.c(java.util.Map):void");
    }

    private void c(String str) {
        this.j = str;
    }

    private void c(long j) {
        this.k = j;
    }

    private void c(int i) {
        this.h = i;
    }

    private void b(Map<String, String> map) {
        long time;
        if (map.containsKey(HttpHeaders.CACHE_CONTROL)) {
            String str = map.get(HttpHeaders.CACHE_CONTROL);
            if (TextUtils.isEmpty(str) || !str.contains("max-age=")) {
                time = 0;
            } else {
                try {
                    time = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.v(o, "Cache-Control value{%s}", Long.valueOf(time));
                    } catch (NumberFormatException e) {
                        e = e;
                        Logger.w(o, "getExpireTime addHeadersToResult NumberFormatException", e);
                    }
                } catch (NumberFormatException e2) {
                    e = e2;
                    time = 0;
                }
            }
        } else {
            if (map.containsKey(HttpHeaders.EXPIRES)) {
                String str2 = map.get(HttpHeaders.EXPIRES);
                Logger.v(o, "expires is{%s}", str2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
                String str3 = map.containsKey(HttpHeaders.DATE) ? map.get(HttpHeaders.DATE) : null;
                try {
                    time = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                } catch (ParseException e3) {
                    Logger.w(o, "getExpireTime ParseException.", e3);
                    time = 0;
                }
            } else {
                Logger.i(o, "response headers neither contains Cache-Control nor Expires.");
            }
            time = 0;
        }
        if (time <= 0 || time > 2592000) {
            time = k.b.m;
        }
        long j = time * 1000;
        Logger.i(o, "convert expireTime{%s}", Long.valueOf(j));
        c(String.valueOf(j + System.currentTimeMillis()));
    }

    private void b(int i) {
        this.i = i;
    }

    private void a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey(HttpHeaders.ETAG)) {
            String str3 = map.get(HttpHeaders.ETAG);
            if (!TextUtils.isEmpty(str3)) {
                Logger.i(o, "success get Etag from server");
                a(str3);
                return;
            } else {
                str = o;
                str2 = "The Response Heads Etag is Empty";
            }
        } else {
            str = o;
            str2 = "Response Heads has not Etag";
        }
        Logger.i(str, str2);
    }

    public d(Exception exc, long j) {
        this.c = 0;
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.m = exc;
        this.d = j;
    }

    public d(int i, Map<String, List<String>> map, byte[] bArr, long j) {
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.c = i;
        this.f4727a = map;
        this.b = ByteBuffer.wrap(bArr).array();
        this.d = j;
        s();
    }
}
