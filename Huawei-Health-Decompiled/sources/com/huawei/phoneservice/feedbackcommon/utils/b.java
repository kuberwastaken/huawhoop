package com.huawei.phoneservice.feedbackcommon.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SortedMap<String, String> f8641a = new TreeMap();

    public String toString() {
        StringBuilder sb = new StringBuilder(512);
        for (Map.Entry<String, String> entry : this.f8641a.entrySet()) {
            String key = entry.getKey();
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(key);
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public String b(String str) throws UnsupportedEncodingException {
        String str2 = this.f8641a.get(URLEncoder.encode(str, "UTF-8"));
        if (str2 == null) {
            return null;
        }
        return URLDecoder.decode(str2, "UTF-8");
    }

    public b(String str) {
        if (str == null) {
            return;
        }
        for (String str2 : str.split("&")) {
            int iIndexOf = str2.indexOf("=");
            this.f8641a.put(str2.substring(0, iIndexOf), str2.substring(iIndexOf + 1));
        }
    }
}
