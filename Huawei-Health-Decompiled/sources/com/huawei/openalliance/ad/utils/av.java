package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.hq;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes6.dex */
public class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7880a = a("ro.build.version.emui", "");

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f7881a = av.a("ro.build.hw_emui_api_level", 0);
        public static final int b = av.a("ro.build.magic_api_level", 0);
    }

    public static String a(String str, String str2) {
        StringBuilder sb;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getDeclaredMethod("get", String.class, String.class).invoke(cls, str, str2);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            sb = new StringBuilder("An exception occurred while reading SystemProperties: ");
            sb.append(str);
            hq.d("HwBuildEx", sb.toString());
        } catch (Throwable unused2) {
            sb = new StringBuilder("An throwable occurred while reading SystemProperties: ");
            sb.append(str);
            hq.d("HwBuildEx", sb.toString());
        }
        return str2;
    }

    public static int a(String str, int i) {
        StringBuilder sb;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(cls, str, Integer.valueOf(i));
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            sb = new StringBuilder("An exception occurred while reading SystemProperties: ");
            sb.append(str);
            hq.d("HwBuildEx", sb.toString());
        } catch (Throwable unused2) {
            sb = new StringBuilder("An Throwable occurred while reading SystemProperties: ");
            sb.append(str);
            hq.d("HwBuildEx", sb.toString());
        }
        return i;
    }
}
