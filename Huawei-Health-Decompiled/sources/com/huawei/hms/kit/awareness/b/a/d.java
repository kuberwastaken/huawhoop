package com.huawei.hms.kit.awareness.b.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5015a = "^[a-zA-Z0-9]+-dr([a-zA-Z]+)\\.dt\\.(hicloud.com|dbankcloud.cn)";
    private static final Pattern b = Pattern.compile(f5015a);

    public static String b(String str) {
        Matcher matcherA = a(str);
        return matcherA.find() ? matcherA.group(1) : "";
    }

    public static boolean a(String str, String str2) {
        String str3 = str == null ? str2 : str;
        if (str3 == null) {
            return true;
        }
        return str3.equals(str2) && str3.equals(str);
    }

    public static Matcher a(String str) {
        return b.matcher(str);
    }
}
