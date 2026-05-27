package com.huawei.ads.fund;

import com.huawei.hihealth.HiDataFilter;
import com.huawei.openplatform.abl.log.HiAdLog;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static Field[] a(Class cls) {
        Field[] fieldArrA = cls.getSuperclass() != null ? a(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (fieldArrA == null || fieldArrA.length <= 0) {
            return declaredFields;
        }
        Field[] fieldArr = new Field[declaredFields.length + fieldArrA.length];
        System.arraycopy(fieldArrA, 0, fieldArr, 0, fieldArrA.length);
        System.arraycopy(declaredFields, 0, fieldArr, fieldArrA.length, declaredFields.length);
        return fieldArr;
    }

    public static Field a(Field field, boolean z) {
        field.setAccessible(z);
        return field;
    }

    public static Class a(Field field, int i) {
        Type[] actualTypeArguments;
        String str;
        Type genericType = field.getGenericType();
        if ((genericType instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) != null && actualTypeArguments.length > i) {
            try {
                Type type = actualTypeArguments[i];
                if (type instanceof Class) {
                    return (Class) type;
                }
                String string = type.toString();
                int iIndexOf = string.indexOf("class ");
                if (iIndexOf < 0) {
                    iIndexOf = 0;
                }
                int iIndexOf2 = string.indexOf(HiDataFilter.DataFilterExpression.LESS_THAN);
                if (iIndexOf2 < 0) {
                    iIndexOf2 = string.length();
                }
                return Class.forName(string.substring(iIndexOf, iIndexOf2));
            } catch (ClassNotFoundException unused) {
                str = "getType ClassNotFoundException";
                HiAdLog.w("ReflectAPI", str);
                return null;
            } catch (Exception unused2) {
                str = "getType Exception";
                HiAdLog.w("ReflectAPI", str);
                return null;
            }
        }
        return null;
    }

    public static Class a(Field field) {
        int i;
        if (Map.class.isAssignableFrom(field.getType())) {
            i = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i = 0;
        }
        return a(field, i);
    }
}
