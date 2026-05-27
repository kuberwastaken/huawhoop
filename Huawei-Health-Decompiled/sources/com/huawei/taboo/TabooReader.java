package com.huawei.taboo;

import android.content.Context;
import com.amap.api.services.district.DistrictSearchQuery;
import defpackage.pac;
import defpackage.pag;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class TabooReader {
    private static pac.c c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private pag f9075a = null;
    private pag d = null;

    public enum ParamType {
        LANGUAGE_NAME("lang", "langs"),
        REGION_NAME("region", "regions"),
        BLACK_LANG("black_lang", ""),
        CITY_NAME(DistrictSearchQuery.KEYWORDS_CITY, "citys"),
        BLACK_CITY("black_city", "");

        private String prefix;
        private String scopeName;

        ParamType(String str, String str2) {
            this.prefix = str;
            this.scopeName = str2;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public String getScopeName() {
            return this.scopeName;
        }
    }

    public String c(ParamType paramType, Locale locale, String str, Context context) {
        String strB;
        String strB2;
        if (context == null || paramType == null) {
            return null;
        }
        b(context);
        if (this.d == null) {
            return null;
        }
        int i = AnonymousClass2.d[paramType.ordinal()];
        if (i == 1) {
            return a(this.d, paramType.getPrefix(), true);
        }
        if (i == 2) {
            return a(this.d, paramType.getPrefix(), true);
        }
        if (i == 3) {
            String strE = pac.e(str);
            if (strE == null || !a(paramType, strE, context)) {
                return null;
            }
            strB = b(this.d, locale, paramType.getPrefix() + "_" + strE);
        } else if (i == 4) {
            if (locale == null || str == null || str.isEmpty()) {
                return null;
            }
            if (a(paramType, str, context)) {
                strB2 = b(this.d, locale, paramType.getPrefix() + "_" + str);
            } else {
                strB2 = null;
            }
            if (strB2 != null) {
                return strB2;
            }
            String strE2 = pac.e(str, context);
            if (!a(paramType, strE2, context)) {
                return null;
            }
            strB = b(this.d, locale, paramType.getPrefix() + "_" + strE2);
        } else {
            if (str == null || !a(paramType, str, context)) {
                return null;
            }
            strB = b(this.d, locale, paramType.getPrefix() + "_" + str);
        }
        return strB;
    }

    /* JADX INFO: renamed from: com.huawei.taboo.TabooReader$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[ParamType.values().length];
            d = iArr;
            try {
                iArr[ParamType.BLACK_LANG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[ParamType.BLACK_CITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[ParamType.CITY_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[ParamType.LANGUAGE_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[ParamType.REGION_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public boolean a(ParamType paramType, String str, Context context) {
        b(context);
        if (this.d == null) {
            return false;
        }
        int i = AnonymousClass2.d[paramType.ordinal()];
        if (i == 3) {
            return this.d.c().e().contains(str);
        }
        if (i == 4) {
            return this.d.c().c().contains(str);
        }
        if (i != 5) {
            return false;
        }
        return this.d.c().a().contains(str);
    }

    private String b(pag pagVar, Locale locale, String str) {
        List<String> listA;
        if (locale != null && (listA = pagVar.a()) != null && !listA.isEmpty()) {
            List<Map.Entry<String, Integer>> listA2 = pac.a(listA, locale, pagVar.e());
            if (listA2.get(0).getValue().intValue() != -1) {
                String key = listA2.get(0).getKey();
                Iterator<String> it = pac.e(c, str).iterator();
                while (it.hasNext()) {
                    String strB = pagVar.b(key, it.next());
                    if (strB != null && !strB.isEmpty()) {
                        return strB;
                    }
                }
            }
        }
        return null;
    }

    private String a(pag pagVar, String str, boolean z) {
        if (z) {
            Iterator<String> it = pac.e(c, str).iterator();
            while (it.hasNext()) {
                String strD = pagVar.c().d(it.next());
                if (strD != null && !strD.isEmpty()) {
                    return strD;
                }
            }
            return null;
        }
        return pagVar.c().d(str);
    }

    private void b(Context context) {
        pag pagVarD;
        if (this.d == null && (pagVarD = pag.d(context)) != null) {
            this.d = pagVarD;
        }
        if (c == null) {
            c = pac.c.b(context);
        }
    }
}
