package com.amap.api.col.p0003sl;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class jr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile jq f1152a;
    private static Properties b;

    private jr() {
    }

    public static jq a() {
        if (f1152a == null) {
            synchronized (jr.class) {
                if (f1152a == null) {
                    try {
                        jq jqVarA = a(Build.MANUFACTURER);
                        if ("".equals(jqVarA.a())) {
                            Iterator it = Arrays.asList(jq.MIUI.a(), jq.Flyme.a(), jq.RH.a(), jq.ColorOS.a(), jq.FuntouchOS.a(), jq.SmartisanOS.a(), jq.AmigoOS.a(), jq.Sense.a(), jq.LG.a(), jq.Google.a(), jq.NubiaUI.a()).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    jq jqVarA2 = a((String) it.next());
                                    if (!"".equals(jqVarA2.a())) {
                                        jqVarA = jqVarA2;
                                        break;
                                    }
                                } else {
                                    jqVarA = jq.Other;
                                    break;
                                }
                            }
                        }
                        f1152a = jqVarA;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return f1152a;
    }

    private static jq a(String str) {
        if (str == null || str.length() <= 0) {
            return jq.Other;
        }
        if (str.equalsIgnoreCase(jq.MIUI.a())) {
            jq jqVar = jq.MIUI;
            if (a(jqVar)) {
                return jqVar;
            }
        } else if (str.equalsIgnoreCase(jq.Flyme.a())) {
            jq jqVar2 = jq.Flyme;
            if (b(jqVar2)) {
                return jqVar2;
            }
        } else if (str.equalsIgnoreCase(jq.RH.a())) {
            jq jqVar3 = jq.RH;
            if (c(jqVar3)) {
                return jqVar3;
            }
        } else if (str.equalsIgnoreCase(jq.ColorOS.a())) {
            jq jqVar4 = jq.ColorOS;
            if (d(jqVar4)) {
                return jqVar4;
            }
        } else if (str.equalsIgnoreCase(jq.FuntouchOS.a())) {
            jq jqVar5 = jq.FuntouchOS;
            if (e(jqVar5)) {
                return jqVar5;
            }
        } else if (str.equalsIgnoreCase(jq.SmartisanOS.a())) {
            jq jqVar6 = jq.SmartisanOS;
            if (f(jqVar6)) {
                return jqVar6;
            }
        } else if (str.equalsIgnoreCase(jq.AmigoOS.a())) {
            jq jqVar7 = jq.AmigoOS;
            if (g(jqVar7)) {
                return jqVar7;
            }
        } else if (str.equalsIgnoreCase(jq.EUI.a())) {
            jq jqVar8 = jq.EUI;
            if (h(jqVar8)) {
                return jqVar8;
            }
        } else if (str.equalsIgnoreCase(jq.Sense.a())) {
            jq jqVar9 = jq.Sense;
            if (i(jqVar9)) {
                return jqVar9;
            }
        } else if (str.equalsIgnoreCase(jq.LG.a())) {
            jq jqVar10 = jq.LG;
            if (j(jqVar10)) {
                return jqVar10;
            }
        } else if (str.equalsIgnoreCase(jq.Google.a())) {
            jq jqVar11 = jq.Google;
            if (k(jqVar11)) {
                return jqVar11;
            }
        } else if (str.equalsIgnoreCase(jq.NubiaUI.a())) {
            jq jqVar12 = jq.NubiaUI;
            if (l(jqVar12)) {
                return jqVar12;
            }
        }
        return jq.Other;
    }

    private static void a(jq jqVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String strGroup = matcher.group(1);
                jqVar.a(strGroup);
                jqVar.a(Integer.parseInt(strGroup.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String b(String str) {
        Properties properties = b;
        String property = null;
        if (properties != null) {
            property = properties.getProperty("[" + str + "]", null);
        }
        if (TextUtils.isEmpty(property)) {
            return c(str);
        }
        return property.replace("[", "").replace("]", "");
    }

    private static String c(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return line;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean a(jq jqVar) {
        if (TextUtils.isEmpty(b("ro.miui.ui.version.name"))) {
            return false;
        }
        String strB = b("ro.build.version.incremental");
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }

    private static boolean b(jq jqVar) {
        String strB = b("ro.flyme.published");
        String strB2 = b("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(strB) && TextUtils.isEmpty(strB2)) {
            return false;
        }
        String strB3 = b("ro.build.display.id");
        a(jqVar, strB3);
        jqVar.b(strB3);
        return true;
    }

    private static boolean c(jq jqVar) {
        String strB = b("ro.build.version.emui");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }

    private static boolean d(jq jqVar) {
        String strB = b("ro.build.version.opporom");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }

    private static boolean e(jq jqVar) {
        String strB = b("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }

    private static boolean f(jq jqVar) {
        String strB = b("ro.smartisan.version");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }

    private static boolean g(jq jqVar) {
        String strB = b("ro.build.display.id");
        if (TextUtils.isEmpty(strB) || !strB.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }

    private static boolean h(jq jqVar) {
        String strB = b("ro.letv.release.version");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }

    private static boolean i(jq jqVar) {
        String strB = b("ro.build.sense.version");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }

    private static boolean j(jq jqVar) {
        String strB = b("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }

    private static boolean k(jq jqVar) {
        if (!"android-google".equals(b("ro.com.google.clientidbase"))) {
            return false;
        }
        String strB = b("ro.build.version.release");
        jqVar.a(Build.VERSION.SDK_INT);
        jqVar.b(strB);
        return true;
    }

    private static boolean l(jq jqVar) {
        String strB = b("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(jqVar, strB);
        jqVar.b(strB);
        return true;
    }
}
