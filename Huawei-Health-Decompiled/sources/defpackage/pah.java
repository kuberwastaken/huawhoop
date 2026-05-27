package defpackage;

import android.content.Context;
import android.icu.util.ULocale;
import android.util.Log;
import com.huawei.android.provider.SettingsEx;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.taboo.TabooReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class pah {
    public static String d(Locale locale, Locale locale2, Context context) {
        if (d(context, locale) && d(locale, locale2)) {
            return a(locale, locale2);
        }
        String displayCountry = locale.getDisplayCountry(locale2);
        Locale locale3 = new Locale("my", "MM");
        if (locale.getCountry().equals("ZG")) {
            displayCountry = locale3.getDisplayCountry(locale2) + "(Zawgyi)";
        }
        String strC = new TabooReader().c(TabooReader.ParamType.REGION_NAME, locale2, locale.getCountry(), context);
        return strC != null ? strC : displayCountry;
    }

    public static ArrayList<String> b(Context context, Locale locale) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (d(context, locale)) {
            arrayList = a(context, locale);
        } else if (pae.a(context)) {
            arrayList = e(context, locale);
        } else {
            arrayList.addAll(c(context, locale));
        }
        arrayList.add("EH");
        arrayList.add("XK");
        return arrayList;
    }

    private static String a(Locale locale, Locale locale2) {
        return (String) pae.c("com.huawei.android.app.LocaleHelperEx", "getDisplayCountry", new Class[]{Locale.class, Locale.class}, new Object[]{locale, locale2});
    }

    private static ArrayList<String> a(Context context, Locale locale) {
        return (ArrayList) pae.c("com.huawei.android.app.LocaleHelperEx", "getBlackRegions", new Class[]{Context.class, Locale.class}, new Object[]{context, locale});
    }

    private static boolean d(Locale locale, Locale locale2) {
        return pae.e("com.huawei.android.app.LocaleHelperEx", "getDisplayCountry", new Class[]{Locale.class, Locale.class}, new Object[]{locale, locale2});
    }

    private static ArrayList<String> c(Context context, Locale locale) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, String> mapC = paf.c(context);
        String country = locale.getCountry();
        if (mapC != null && !country.isEmpty()) {
            for (Map.Entry<String, String> entry : mapC.entrySet()) {
                String value = entry.getValue();
                List arrayList2 = new ArrayList();
                if (value.contains(",")) {
                    arrayList2 = Arrays.asList(value.split(","));
                } else {
                    arrayList2.add(value);
                }
                if (arrayList2.contains(country)) {
                    String key = entry.getKey();
                    if (key.contains(",")) {
                        arrayList.addAll(Arrays.asList(key.split(",")));
                    } else {
                        arrayList.add(key);
                    }
                }
            }
        }
        return arrayList;
    }

    private static boolean d(Context context, Locale locale) {
        return pae.e("com.huawei.android.app.LocaleHelperEx", "getBlackRegions", new Class[]{Context.class, Locale.class}, new Object[]{context, locale});
    }

    private static ArrayList<String> e(Context context, Locale locale) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(c(context));
        ULocale uLocaleAddLikelySubtags = ULocale.addLikelySubtags(ULocale.forLocale(locale));
        String language = uLocaleAddLikelySubtags.getLanguage();
        String script = uLocaleAddLikelySubtags.getScript();
        Iterator<String> it = d(context).iterator();
        while (it.hasNext()) {
            ULocale uLocaleAddLikelySubtags2 = ULocale.addLikelySubtags(ULocale.forLanguageTag(it.next()));
            String language2 = uLocaleAddLikelySubtags2.getLanguage();
            String script2 = uLocaleAddLikelySubtags2.getScript();
            String country = uLocaleAddLikelySubtags2.getCountry();
            if (language.equals(language2) && script.equals(script2)) {
                arrayList.add(country);
            }
        }
        return arrayList;
    }

    private static ArrayList<String> d(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        String strE = e(context);
        if (strE != null) {
            for (String str : strE.split(",")) {
                String strTrim = str.trim();
                if (!strTrim.startsWith("*") && !strTrim.endsWith("*") && strTrim.split(Constants.LINK).length >= 2) {
                    arrayList.add(strTrim);
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<String> c(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        String strE = e(context);
        if (strE != null) {
            for (String str : strE.split(",")) {
                String strTrim = str.trim();
                if (strTrim.startsWith("*")) {
                    arrayList.add(strTrim.split(Constants.LINK)[1]);
                }
            }
        }
        return arrayList;
    }

    private static String e(Context context) {
        String string;
        if (pae.a(context)) {
            try {
                string = SettingsEx.Systemex.getString(context.getContentResolver(), "black_languages");
            } catch (Throwable unused) {
                Log.e("TabooLocaleHelper", "Could not load default locales");
                string = null;
            }
        } else {
            string = null;
        }
        String strC = new TabooReader().c(TabooReader.ParamType.BLACK_LANG, null, null, context);
        if (strC != null) {
            string = strC;
        }
        return string != null ? string.replace("tl", "fil").replace("_", Constants.LINK) : string;
    }
}
