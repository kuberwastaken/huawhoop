package com.huawei.watchface;

import android.text.TextUtils;
import com.huawei.secure.android.common.anonymization.Anonymizer;

/* JADX INFO: loaded from: classes8.dex */
public class fd {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strMaskCommonString = Anonymizer.maskCommonString(str, 0, str.length());
        return TextUtils.isEmpty(strMaskCommonString) ? strMaskCommonString : strMaskCommonString.replaceAll("\\*+", "*");
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? str : Anonymizer.maskCommonString(str, 5, 5);
    }

    public static String c(String str) {
        String strMaskCommonString;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.indexOf("@") > 0) {
            strMaskCommonString = Anonymizer.maskCommonString(str, str.indexOf("@") + 1, 1);
        } else {
            strMaskCommonString = Anonymizer.maskCommonString(str, 0, str.length());
        }
        return TextUtils.isEmpty(strMaskCommonString) ? strMaskCommonString : strMaskCommonString.replaceAll("\\*+", "*");
    }
}
