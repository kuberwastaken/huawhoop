package defpackage;

import android.content.Context;
import android.icu.util.ULocale;
import android.util.Log;
import com.huawei.android.os.SystemPropertiesEx;
import com.huawei.hms.mlsdk.asr.MLAsrConstants;
import com.huawei.openalliance.ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class pac {
    private static final String[][] b = {new String[]{"zh-MO", "zh-Hant-HK"}};
    private static final String[][] e = {new String[]{"en-150", "en-001"}, new String[]{"en-AG", "en-001"}, new String[]{"en-AI", "en-001"}, new String[]{"en-AU", "en-001"}, new String[]{"en-BB", "en-001"}, new String[]{"en-BE", "en-001"}, new String[]{"en-BM", "en-001"}, new String[]{"en-BS", "en-001"}, new String[]{"en-BZ", "en-001"}, new String[]{"en-CC", "en-001"}, new String[]{"en-CK", "en-001"}, new String[]{"en-CX", "en-001"}, new String[]{"en-DG", "en-001"}, new String[]{"en-ER", "en-001"}, new String[]{"en-FK", "en-001"}, new String[]{"en-FM", "en-001"}, new String[]{"en-GB", "en-001"}, new String[]{"en-GD", "en-001"}, new String[]{"en-GG", "en-001"}, new String[]{"en-GI", "en-001"}, new String[]{"en-GY", "en-001"}, new String[]{"en-HK", "en-001"}, new String[]{"en-IE", "en-001"}, new String[]{"en-IM", "en-001"}, new String[]{MLAsrConstants.LAN_EN_IN, "en-001"}, new String[]{"en-IO", "en-001"}, new String[]{"en-JE", "en-001"}, new String[]{"en-KI", "en-001"}, new String[]{"en-KN", "en-001"}, new String[]{"en-KY", "en-001"}, new String[]{"en-LC", "en-001"}, new String[]{"en-LR", "en-001"}, new String[]{"en-LS", "en-001"}, new String[]{"en-MM", "en-001"}, new String[]{"en-MO", "en-001"}, new String[]{"en-MS", "en-001"}, new String[]{"en-MT", "en-001"}, new String[]{"en-MY", "en-001"}, new String[]{"en-NF", "en-001"}, new String[]{"en-NR", "en-001"}, new String[]{"en-NU", "en-001"}, new String[]{"en-NZ", "en-001"}, new String[]{"en-PG", "en-001"}, new String[]{"en-PK", "en-001"}, new String[]{"en-PN", "en-001"}, new String[]{"en-PW", "en-001"}, new String[]{"en-SB", "en-001"}, new String[]{"en-SC", "en-001"}, new String[]{"en-SD", "en-001"}, new String[]{"en-SG", "en-001"}, new String[]{"en-SH", "en-001"}, new String[]{"en-SL", "en-001"}, new String[]{"en-SS", "en-001"}, new String[]{"en-SX", "en-001"}, new String[]{"en-SZ", "en-001"}, new String[]{"en-TC", "en-001"}, new String[]{"en-TK", "en-001"}, new String[]{"en-TT", "en-001"}, new String[]{"en-TV", "en-001"}, new String[]{"en-VC", "en-001"}, new String[]{"en-VG", "en-001"}, new String[]{"en-WS", "en-001"}, new String[]{"en-ZG", "en-001"}, new String[]{"es-AR", "es-419"}, new String[]{"es-BO", "es-419"}, new String[]{"es-BR", "es-419"}, new String[]{"es-CL", "es-419"}, new String[]{"es-CO", "es-419"}, new String[]{"es-CR", "es-419"}, new String[]{"es-CU", "es-419"}, new String[]{"es-DO", "es-419"}, new String[]{"es-EC", "es-419"}, new String[]{"es-GT", "es-419"}, new String[]{"es-HN", "es-419"}, new String[]{"es-MX", "es-419"}, new String[]{"es-NI", "es-419"}, new String[]{"es-PA", "es-419"}, new String[]{"es-PE", "es-419"}, new String[]{"es-PR", "es-419"}, new String[]{"es-PY", "es-419"}, new String[]{"es-SV", "es-419"}, new String[]{"es-US", "es-419"}, new String[]{"es-UY", "es-419"}, new String[]{"es-VE", "es-419"}, new String[]{"pt-AO", "pt-PT"}, new String[]{"pt-CH", "pt-PT"}, new String[]{"pt-CV", "pt-PT"}, new String[]{"pt-GQ", "pt-PT"}, new String[]{"pt-GW", "pt-PT"}, new String[]{"pt-LU", "pt-PT"}, new String[]{"pt-MO", "pt-PT"}, new String[]{"pt-MZ", "pt-PT"}, new String[]{"pt-ST", "pt-PT"}, new String[]{"pt-TL", "pt-PT"}};

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f16584a;
        private String b;
        private String c;
        private List<String> d = new ArrayList();
        private String e;

        public static c b(Context context) {
            c cVar = new c();
            if (pae.a(context)) {
                try {
                    String str = SystemPropertiesEx.get("ro.config.hw_optb", "0");
                    String str2 = SystemPropertiesEx.get("ro.config.hw.region", "0");
                    String str3 = SystemPropertiesEx.get(CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP, "0");
                    if (str == null) {
                        str = null;
                    }
                    cVar.b = str;
                    cVar.c = str3 != null ? str3.toUpperCase(Locale.ENGLISH) : null;
                    cVar.e = str2 != null ? str2.toLowerCase(Locale.ENGLISH) : null;
                    cVar.d = pac.d();
                    String str4 = SystemPropertiesEx.get("hbc.country", "");
                    cVar.f16584a = str4 != null ? str4.toUpperCase(Locale.ENGLISH) : null;
                } catch (Throwable unused) {
                    Log.e("FindTargetRules", "getSystemParam error");
                }
            }
            return cVar;
        }
    }

    public static List<String> e(c cVar, String str) {
        ArrayList arrayList = new ArrayList();
        if (cVar != null && str != null) {
            Iterator it = cVar.d.iterator();
            while (it.hasNext()) {
                arrayList.add(str + "_mcc_" + ((String) it.next()));
            }
            if (cVar.b != null && !cVar.b.equals("0")) {
                arrayList.add(str + "_optb_" + cVar.b);
            }
            if (cVar.f16584a != null && !cVar.f16584a.equals("")) {
                arrayList.add(str + "_hc_" + cVar.f16584a);
            }
            if (cVar.c != null && !cVar.c.equals("0")) {
                arrayList.add(str + "_c_" + cVar.c);
            }
            if (cVar.e != null && !cVar.e.equals("0")) {
                arrayList.add(str + "_r_" + cVar.e);
            }
            arrayList.add(str + "_r_all");
        }
        return arrayList;
    }

    public static String e(String str) {
        return str == null ? str : str.replaceAll("[^a-zA-Z0-9]+", "_");
    }

    public static String e(String str, Context context) {
        if (str != null && !str.isEmpty()) {
            Locale localeForLanguageTag = Locale.forLanguageTag(str);
            if (localeForLanguageTag.getScript() == null || localeForLanguageTag.getScript().isEmpty()) {
                String script = ULocale.addLikelySubtags(ULocale.forLanguageTag(str)).getScript();
                StringBuffer stringBuffer = new StringBuffer();
                if (!"".equals(script)) {
                    stringBuffer.append(localeForLanguageTag.getLanguage()).append(Constants.LINK).append(script);
                }
                if (localeForLanguageTag.getCountry() != null && !localeForLanguageTag.getCountry().isEmpty()) {
                    stringBuffer.append(Constants.LINK).append(localeForLanguageTag.getCountry());
                }
                return stringBuffer.toString();
            }
        }
        return null;
    }

    public static List<Map.Entry<String, Integer>> a(List<String> list, Locale locale, Context context) {
        HashMap map = new HashMap();
        for (String str : list) {
            map.put(str, Integer.valueOf(e(locale, Locale.forLanguageTag(str), context)));
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: pac.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                if (entry2.getValue().compareTo(entry.getValue()) != 0) {
                    return entry2.getValue().compareTo(entry.getValue());
                }
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> d() {
        ArrayList arrayList = new ArrayList();
        for (String str : SystemPropertiesEx.get("persist.sys.mcc_match_fyrom").split(",")) {
            if (str != null && !str.equals("")) {
                arrayList.add(str.substring(0, 3));
            }
        }
        return arrayList;
    }

    private static int e(Locale locale, Locale locale2, Context context) {
        String language = locale.getLanguage();
        String script = locale.getScript();
        String languageTag = locale.toLanguageTag();
        String script2 = locale2.getScript();
        String languageTag2 = locale2.toLanguageTag();
        String language2 = locale2.getLanguage();
        if (language.isEmpty() || language2.isEmpty() || !d(language, language2)) {
            return -1;
        }
        HashMap<String, String> mapA = a();
        if (mapA.containsKey(languageTag) && languageTag2.equals(mapA.get(languageTag))) {
            return 8;
        }
        if (script.isEmpty()) {
            script = ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (script2.isEmpty()) {
            script2 = ULocale.addLikelySubtags(ULocale.forLocale(locale2)).getScript();
        }
        String country = locale2.getCountry();
        if ((!language.equals("en") || !e(script, script2)) && !script.equals(script2)) {
            return -1;
        }
        int i = country.isEmpty() ? 7 : 6;
        String country2 = locale.getCountry();
        return (country2.isEmpty() || !country2.equals(country)) ? i : i + 3;
    }

    private static HashMap<String, String> a() {
        HashMap<String, String> map = new HashMap<>();
        int length = b.length;
        int i = 0;
        while (true) {
            String str = "";
            if (i >= length) {
                break;
            }
            String[] strArr = b[i];
            String str2 = strArr[0];
            String str3 = strArr[1];
            map.put(str2, str3);
            String[] strArrSplit = str2.split(Constants.LINK);
            if (strArrSplit.length > 1) {
                str = strArrSplit[0] + "-Hant-" + strArrSplit[1];
            }
            map.put(str, str3);
            i++;
        }
        int length2 = e.length;
        for (int i2 = 0; i2 < length2; i2++) {
            String[] strArr2 = e[i2];
            String str4 = strArr2[0];
            String str5 = strArr2[1];
            map.put(str4, str5);
            String[] strArrSplit2 = str4.split(Constants.LINK);
            map.put(strArrSplit2.length > 1 ? strArrSplit2[0] + "-Latn-" + strArrSplit2[1] : "", str5);
            if (str4.contains("en-")) {
                map.put(strArrSplit2.length > 1 ? strArrSplit2[0] + "-Qaag-" + strArrSplit2[1] : "", str5);
            }
        }
        return map;
    }

    private static boolean e(String str, String str2) {
        return str.replace("Qaag", "Latn").equals(str2.replace("Qaag", "Latn"));
    }

    private static boolean d(String str, String str2) {
        return str.replace("tl", "fil").equals(str2.replace("tl", "fil"));
    }
}
