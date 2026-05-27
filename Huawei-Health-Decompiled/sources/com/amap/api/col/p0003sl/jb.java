package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.VastAttribute;
import com.huawei.operation.utils.CloudParamKeys;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1127a = 1;
    public static int b = 2;
    private String c;
    private int d;
    private long e = System.currentTimeMillis();
    private String f;

    private jb(int i, String str, String str2) {
        this.c = str2;
        this.d = i;
        this.f = str;
    }

    public static jb a(String str, String str2) {
        return new jb(f1127a, str, str2);
    }

    public static jb b(String str, String str2) {
        return new jb(b, str, str2);
    }

    public final int a() {
        return this.d;
    }

    public final String b() {
        new JSONObject();
        return this.c;
    }

    private String d() {
        return this.f;
    }

    public final String c() {
        return a(this.d);
    }

    public static String a(int i) {
        return i == b ? VastAttribute.ERROR : CloudParamKeys.INFO;
    }

    public static boolean a(jb jbVar) {
        return (jbVar == null || TextUtils.isEmpty(jbVar.b())) ? false : true;
    }

    private static String b(jb jbVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CloudParamKeys.INFO, jbVar.b());
            jSONObject.put("session", jbVar.d());
            jSONObject.put("timestamp", jbVar.e);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(List<jb> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<jb> it = list.iterator();
            while (it.hasNext()) {
                String strB = b(it.next());
                if (!TextUtils.isEmpty(strB)) {
                    jSONArray.put(strB);
                }
            }
            return jSONArray.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
