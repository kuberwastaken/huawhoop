package com.huawei.phoneservice.feedbackcommon.utils;

import com.huawei.nfc.PluginPayAdapter;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

/* JADX INFO: loaded from: classes6.dex */
public class m {
    public static String e(String str, String str2, String str3) throws UnsupportedEncodingException {
        b bVar;
        String strB;
        StringBuilder sb = new StringBuilder(512);
        String strSubstring = "";
        try {
            if (str.contains("?")) {
                strSubstring = str.substring(0, str.indexOf(63));
                bVar = str.substring(str.indexOf("?")).length() > 1 ? new b(str.substring(str.indexOf("?") + 1)) : new b(null);
            } else {
                try {
                    bVar = new b(null);
                    strSubstring = str;
                } catch (Exception e) {
                    e = e;
                    strSubstring = str;
                    com.huawei.phoneservice.faq.base.util.h.a("HeaderUtils", "getAuthorizationHeader failed because of request format error. " + e.getMessage());
                    bVar = null;
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        sb.append("POST&");
        if (!str.contains("/platform")) {
            strB = bVar != null ? bVar.b("appID") : null;
            sb.append(strSubstring.substring(strSubstring.indexOf("/")));
            sb.append("&");
            sb.append(bVar);
            sb.append("&");
            sb.append(str2);
            sb.append("&appID=");
            sb.append(strB);
            String strD = g.d(sb.toString(), str3);
            com.huawei.phoneservice.faq.base.util.h.a("FeedBackPresenter1", strD);
            return MessageFormat.format("HMAC-SHA256 appID={0}, signature=\"{1}\"", strB, strD);
        }
        strB = bVar != null ? bVar.b(PluginPayAdapter.KEY_OPEN_CHANNEL_ID) : null;
        String strValueOf = String.valueOf(System.currentTimeMillis());
        sb.append(strSubstring);
        sb.append("&");
        sb.append(bVar);
        sb.append("&");
        sb.append(str2);
        sb.append("&channelID=");
        sb.append(strB);
        sb.append("&timestamp=");
        sb.append(strValueOf);
        return MessageFormat.format("HMAC-SHA256 channelID={0}, timestamp={1}, signature=\"{2}\"", strB, strValueOf, g.d(sb.toString(), str3));
    }
}
