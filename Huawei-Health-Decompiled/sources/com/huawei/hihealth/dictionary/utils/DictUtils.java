package com.huawei.hihealth.dictionary.utils;

import android.content.Context;
import android.text.TextUtils;
import health.compact.a.util.LogUtil;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class DictUtils {
    private static Pattern e = Pattern.compile("[0-9]{3}-[0-9]{5}");
    private static Pattern c = Pattern.compile("[a-zA-Z0-9_]{3,64}");

    public static String d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            try {
                String strE = e(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return strE;
            } finally {
            }
        } catch (IOException unused) {
            LogUtil.d("HiH_LOG_TAG", "read file error.");
            return null;
        }
    }

    public static int a(int i, String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        return (i * 1000) + Math.abs(str.hashCode() % 1000);
    }

    public static boolean e(String str) {
        if (str == null) {
            return false;
        }
        return c.matcher(str).matches();
    }

    public static <T> List<T> b(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Field field : cls.getFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && field.get(null) != null) {
                    arrayList.add(field.get(null));
                }
            }
        } catch (Exception unused) {
            LogUtil.d("HiH_LOG_TAG", "getConstantFields failed.");
        }
        return arrayList;
    }

    private static String e(InputStream inputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    String line = bufferedReader.readLine();
                    int i = 0;
                    while (line != null) {
                        if (line.length() < 8192 && i < 8192) {
                            stringBuffer.append(line);
                        }
                        line = bufferedReader.readLine();
                        i++;
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    return stringBuffer.toString();
                } finally {
                }
            } finally {
            }
        } catch (FileNotFoundException unused) {
            LogUtil.d("HiH_LOG_TAG", "file does not exist.");
            return null;
        } catch (Exception unused2) {
            LogUtil.d("HiH_LOG_TAG", "read file error.");
            return null;
        }
    }
}
