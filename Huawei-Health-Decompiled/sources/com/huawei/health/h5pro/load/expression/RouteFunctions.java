package com.huawei.health.h5pro.load.expression;

import android.text.TextUtils;
import com.huawei.health.h5pro.utils.LogUtil;
import com.huawei.health.h5pro.vengine.H5ProInstance;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class RouteFunctions {
    @ExpressionFunction(alias = "getUrlByRoute")
    public String getUrlByRoute(H5ProInstance h5ProInstance, String str) {
        LogUtil.i("H5PRO_RouteFunctions", "getUrlByRoute: cloudPath -> " + str);
        Matcher matcher = Pattern.compile("\\{\\{(.*?)\\}\\}").matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            str = str.replace(strGroup, a(h5ProInstance.getPath(), strGroup.replace("{{", "").replace("}}", "")));
        }
        LogUtil.i("H5PRO_RouteFunctions", "getUrlByRoute: cloudPath(end) -> " + str);
        return str;
    }

    @ExpressionFunction(alias = "getKeyByRoute")
    public String getKeyByRoute(H5ProInstance h5ProInstance, String str) {
        LogUtil.i("H5PRO_RouteFunctions", "getKeyByRoute: paramName -> " + str);
        String strA = h5ProInstance != null ? a(h5ProInstance.getPath(), str) : "";
        LogUtil.i("H5PRO_RouteFunctions", "getKeyByRoute: paramValue -> " + strA);
        return strA;
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.contains("?")) {
            LogUtil.w("H5PRO_RouteFunctions", "getParamValue: return,empty");
            return "";
        }
        for (String str3 : str.substring(str.indexOf("?")).replace("?", "").split("&")) {
            String[] strArrSplit = str3.split("=");
            if (strArrSplit.length == 2 && strArrSplit[0].equals(str2)) {
                return strArrSplit[1];
            }
        }
        return "";
    }
}
