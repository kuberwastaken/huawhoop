package defpackage;

import health.compact.a.LogUtil;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes7.dex */
public class pkz {
    public static Field[] a(Class<?> cls, Object obj) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Field[] fieldArr = new Field[declaredFields.length];
        int i = 0;
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.getType() == cls) {
                fieldArr[i] = field;
                i++;
            }
        }
        return fieldArr;
    }

    public static void c(Object obj, Field field, Object obj2) {
        if (field == null) {
            return;
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            LogUtil.b("ReflectUtils", LogUtil.c(e));
        }
    }
}
