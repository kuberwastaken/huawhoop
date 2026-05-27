package com.huawei.haf.language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class DefaultLanguageInfo implements LanguageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f2154a = new HashMap<>();
    private static final HashSet<String> e = new HashSet<>();

    private DefaultLanguageInfo() {
        HashMap<String, String> map = f2154a;
        if (map.isEmpty()) {
            LanguageInfoHelper.c(map, e);
        }
    }

    static LanguageInfo a() {
        DefaultLanguageInfo defaultLanguageInfo;
        synchronized (DefaultLanguageInfo.class) {
            defaultLanguageInfo = new DefaultLanguageInfo();
        }
        return defaultLanguageInfo;
    }

    @Override // com.huawei.haf.language.LanguageInfo
    public String getLanguageUuid(Locale locale) {
        String strA = a(locale);
        String strE = e(locale, strA);
        String strB = b(locale, strE, strA);
        HashMap<String, String> map = f2154a;
        String str = map.get(strB);
        return str != null ? str : map.get(strE);
    }

    @Override // com.huawei.haf.language.LanguageInfo
    public String getLanguageName(String str, Locale locale) {
        if (str != null) {
            for (Map.Entry<String, String> entry : f2154a.entrySet()) {
                if (str.equals(entry.getValue())) {
                    return entry.getKey();
                }
            }
        }
        return locale != null ? e(locale, a(locale)) : "";
    }

    @Override // com.huawei.haf.language.LanguageInfo
    public List<String> getAllLanguageUuid(boolean z) {
        HashMap<String, String> map = f2154a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!z || !isCloudPresetLanguage(entry.getValue())) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.haf.language.LanguageInfo
    public boolean isStorePresetLanguage(String str) {
        return "en".equals(getLanguageName(str, null));
    }

    @Override // com.huawei.haf.language.LanguageInfo
    public boolean isCloudPresetLanguage(String str) {
        if (str != null) {
            return e.contains(str);
        }
        return true;
    }

    @Override // com.huawei.haf.language.LanguageInfo
    public boolean isCloudSecondLanguage(String str) {
        return LanguageInfoHelper.b(str);
    }

    private static String a(Locale locale) {
        return locale.getScript();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.util.Locale r5, java.lang.String r6) {
        /*
            java.lang.String r5 = r5.getLanguage()
            r5.hashCode()
            int r0 = r5.hashCode()
            r1 = 3404(0xd4c, float:4.77E-42)
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L43
            r1 = 3500(0xdac, float:4.905E-42)
            if (r0 == r1) goto L37
            r1 = 3679(0xe5f, float:5.155E-42)
            if (r0 == r1) goto L2b
            r1 = 101385(0x18c09, float:1.4207E-40)
            if (r0 == r1) goto L20
            goto L4c
        L20:
            java.lang.String r0 = "fil"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L29
            goto L4c
        L29:
            r0 = r2
            goto L4f
        L2b:
            java.lang.String r0 = "sr"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L35
            goto L4c
        L35:
            r0 = r3
            goto L4f
        L37:
            java.lang.String r0 = "my"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L41
            goto L4c
        L41:
            r0 = r4
            goto L4f
        L43:
            java.lang.String r0 = "jv"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L4e
        L4c:
            r0 = -1
            goto L4f
        L4e:
            r0 = 0
        L4f:
            if (r0 == 0) goto L6a
            if (r0 == r4) goto L5f
            if (r0 == r3) goto L5c
            if (r0 == r2) goto L58
            goto L6c
        L58:
            java.lang.String r5 = "tl"
            goto L6c
        L5c:
            java.lang.String r5 = "b+sr+Latn"
            goto L6c
        L5f:
            java.lang.String r0 = "Qaag"
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L6c
            java.lang.String r5 = "b+my+Qaag"
            goto L6c
        L6a:
            java.lang.String r5 = "b+jv+Latn"
        L6c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.haf.language.DefaultLanguageInfo.e(java.util.Locale, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(java.util.Locale r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.haf.language.DefaultLanguageInfo.b(java.util.Locale, java.lang.String, java.lang.String):java.lang.String");
    }
}
