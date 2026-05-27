package com.huawei.hms.iapfull;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.PermissionChecker;
import com.huawei.health.R;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.secure.android.common.util.SafeBase64;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class a1 {
    public static String a(Context context, String str, String str2, String str3) {
        String str4 = (TextUtils.isEmpty(str3) || "CNY".equals(str3)) ? "¥" : "";
        if (context == null) {
            y0.a("PayPresenter", "context is null");
            return str;
        }
        String string = context.getString(R.string._2130852450_res_0x7f023a62, str4, str);
        if ("string_cny_normal".equals(str2)) {
            return string;
        }
        if (!"string_cny_discount".equals(str2)) {
            return "string_cny_confirm".equals(str2) ? context.getString(R.string._2130852448_res_0x7f023a60, string) : str4;
        }
        return "-\u200e" + string;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo = (context == null || PermissionChecker.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) ? null : connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r7, java.lang.Object r8, org.json.JSONObject r9) throws org.json.JSONException, java.lang.IllegalAccessException {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.iapfull.a1.a(java.lang.String, java.lang.Object, org.json.JSONObject):boolean");
    }

    public static String a() {
        String str;
        try {
            str = System.currentTimeMillis() + "_" + String.format(Locale.ROOT, "%06d", Integer.valueOf(SecureRandom.getInstanceStrong().nextInt(1000000)));
        } catch (NoSuchAlgorithmException unused) {
            y0.a("getStrongNoiseTamp", "getStrongNoiseTamp NoSuchAlgorithmException.");
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return System.currentTimeMillis() + "_" + String.format(Locale.ROOT, "%06d", Integer.valueOf(new SecureRandom().nextInt(1000000)));
    }

    public static String a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                if (!HwPayConstant.KEY_SIGN.equals(next)) {
                    Object string = jSONObject.get(next);
                    if (string instanceof Integer) {
                        if (((Integer) string).intValue() >= 0) {
                            string = ((Integer) string) + "";
                        }
                    }
                    if (string instanceof ArrayList) {
                        StringBuilder sb = new StringBuilder();
                        for (Map map2 : (List) string) {
                            if (sb.length() > 0) {
                                sb.append("#");
                            }
                            sb.append(a((Map<String, String>) map2));
                        }
                        string = sb.toString();
                    }
                    if (string instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) string;
                        StringBuilder sb2 = new StringBuilder();
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            if (sb2.length() > 0) {
                                sb2.append("#");
                            }
                            sb2.append(a(jSONObject2));
                        }
                        string = sb2.toString();
                    }
                    if (string != null) {
                        map.put(next, string.toString());
                    }
                }
            } catch (JSONException unused) {
                y0.a("SignUtils", "json exception");
            }
        }
        return a(map);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r2, java.lang.String r3) {
        /*
            java.security.PrivateKey r2 = com.huawei.hms.iapfull.y0.b(r2)
            java.lang.String r0 = "SignUtils"
            if (r2 == 0) goto L2f
            java.security.interfaces.RSAPrivateKey r2 = (java.security.interfaces.RSAPrivateKey) r2     // Catch: java.lang.Exception -> L28
            java.math.BigInteger r2 = r2.getModulus()     // Catch: java.lang.Exception -> L28
            int r2 = r2.bitLength()     // Catch: java.lang.Exception -> L28
            r1 = 512(0x200, float:7.17E-43)
            if (r2 > r1) goto L17
            goto L2f
        L17:
            java.lang.String r2 = "RSA256PSS"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L25
            java.lang.String r3 = "getSignTypByBuildVersion."
            com.huawei.hms.iapfull.y0.b(r0, r3)
            return r2
        L25:
            java.lang.String r2 = "getSignTypByBuildVersion. Using Default Configuration RSA256"
            goto L31
        L28:
            java.lang.String r2 = "SignUtil"
            java.lang.String r3 = "getPrivateKeyLength, Exception"
            com.huawei.hms.iapfull.y0.a(r2, r3)
        L2f:
            java.lang.String r2 = "getSignTypByBuildVersion. If the key length is less than 512 bytes, use RSA256."
        L31:
            com.huawei.hms.iapfull.y0.b(r0, r2)
            java.lang.String r2 = "RSA256"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.iapfull.a1.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                PrivateKey privateKeyB = y0.b(str);
                if (TextUtils.isEmpty(str2) || privateKeyB == null) {
                    y0.a("RSASign", "content or key is null");
                } else {
                    try {
                        Signature signature = Signature.getInstance(HwPayConstant.SIGNTYPE_RSA256PSS.equals(str3) ? "SHA256WithRSA/PSS" : "SHA256WithRSA");
                        signature.initSign(privateKeyB);
                        signature.update(str2.getBytes("UTF-8"));
                        return SafeBase64.encodeToString(signature.sign(), 0);
                    } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | SignatureException unused) {
                    }
                }
            } else {
                y0.a("RSASign", "sign content or key is null");
            }
        }
        return "";
    }

    private static boolean b(String str) {
        return (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str)) ? false : true;
    }

    public static String b(b1 b1Var) {
        StringBuilder sb;
        String message;
        if (b1Var == null) {
            y0.a("JsonUtil", "createJsonString error, the input IMessageEntity is null");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Class<?> superclass = b1Var.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                for (Field field : superclass.getDeclaredFields()) {
                    boolean zIsAccessible = field.isAccessible();
                    field.setAccessible(true);
                    String name = field.getName();
                    Object obj = field.get(b1Var);
                    field.setAccessible(zIsAccessible);
                    a(name, obj, jSONObject);
                }
            } catch (IllegalAccessException e) {
                sb = new StringBuilder("catch IllegalAccessException ");
                message = e.getMessage();
                sb.append(message);
                y0.a("JsonUtil", sb.toString());
                return jSONObject.toString();
            } catch (JSONException e2) {
                sb = new StringBuilder("catch JSONException ");
                message = e2.getMessage();
                sb.append(message);
                y0.a("JsonUtil", sb.toString());
                return jSONObject.toString();
            }
        }
        return jSONObject.toString();
    }

    public static String b() {
        String str = Build.MODEL;
        if (!b(str)) {
            str = Build.DEVICE;
        }
        if (!b(str)) {
            str = Build.PRODUCT;
        }
        return !b(str) ? "0" : str;
    }

    public static boolean a(Intent intent) {
        boolean z;
        if (intent == null) {
            z = true;
        } else {
            try {
                intent.getStringExtra("ANYTHING");
                z = false;
            } catch (Exception unused) {
                z = true;
            }
        }
        y0.b("UIUtil", "checkIntent4DDOS: " + z);
        return z;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public static void a(Activity activity, int i, int i2) {
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new f1(activity, i, i2));
    }

    public static Map<String, String> a(String str, String str2, boolean z) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        for (String str3 : str.split(str2)) {
            String[] strArrSplit = str3.split("=");
            if (strArrSplit.length > 1) {
                String str4 = strArrSplit[0];
                String strSubstring = str3.substring(str4.length() + 1);
                if (z) {
                    strSubstring = a(strSubstring);
                }
                map.put(str4, strSubstring);
            }
        }
        return map;
    }

    public static String a(Map<String, String> map) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        int i = 0;
        while (i < arrayList.size()) {
            String str2 = (String) arrayList.get(i);
            if (!HwPayConstant.KEY_SIGN.equals(str2) && (str = map.get(str2)) != null && !str.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(i == 0 ? "" : "&");
                sb.append(str2);
                sb.append("=");
                sb.append(str);
                stringBuffer.append(sb.toString());
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                str2 = "WebFormerUtil decodeUrl UnsupportedEncodingException.";
                y0.a("decodeUrl", str2);
                return str;
            } catch (IllegalArgumentException unused2) {
                str2 = "WebFormerUtil decodeUrl IllegalArgumentException.";
                y0.a("decodeUrl", str2);
                return str;
            }
        }
        return str;
    }

    private static String a(b1 b1Var) throws IllegalAccessException, JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Class<?> superclass = b1Var.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                boolean zIsAccessible = field.isAccessible();
                field.setAccessible(true);
                String name = field.getName();
                Object obj = field.get(b1Var);
                field.setAccessible(zIsAccessible);
                a(name, obj, jSONObject);
            }
        }
        return jSONObject.toString();
    }
}
