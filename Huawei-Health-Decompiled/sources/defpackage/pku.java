package defpackage;

import android.graphics.drawable.Drawable;
import com.huawei.ui.commonui.listener.OnClickSectionListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class pku {
    public static int b(Map map, String str, int i) {
        Object objC = c(map, str, Integer.valueOf(i));
        return objC instanceof Integer ? ((Integer) objC).intValue() : i;
    }

    public static float e(Map map, String str, float f) {
        Object objC = c(map, str, Float.valueOf(f));
        return objC instanceof Float ? ((Float) objC).floatValue() : f;
    }

    public static long a(Map map, String str, long j) {
        Object objC = c(map, str, Long.valueOf(j));
        return objC instanceof Long ? ((Long) objC).longValue() : j;
    }

    public static boolean a(Map map, String str, boolean z) {
        Object objC = c(map, str, Boolean.valueOf(z));
        return objC instanceof Boolean ? ((Boolean) objC).booleanValue() : z;
    }

    public static String a(Map map, String str, String str2) {
        Object objC = c(map, str, str2);
        return objC instanceof String ? (String) objC : str2;
    }

    public static CharSequence c(Map map, String str, CharSequence charSequence) {
        Object objC = c(map, str, charSequence);
        return objC instanceof CharSequence ? (CharSequence) objC : charSequence;
    }

    public static <T> List<T> b(Map map, String str, Class<T> cls, List<T> list) {
        Object objC = c(map, str, list);
        if (!(objC instanceof List)) {
            return list;
        }
        List<T> list2 = (List) objC;
        return (list2.size() <= 0 || !mgx.e(list2, cls)) ? list : list2;
    }

    public static Drawable cVA_(Map map, String str, Drawable drawable) {
        Object objC = c(map, str, drawable);
        return objC instanceof Drawable ? (Drawable) objC : drawable;
    }

    public static OnClickSectionListener d(Map map, String str, OnClickSectionListener onClickSectionListener) {
        Object objC = c(map, str, onClickSectionListener);
        return objC instanceof OnClickSectionListener ? (OnClickSectionListener) objC : onClickSectionListener;
    }

    public static <T> Object c(Map map, String str, T t) {
        return (map == null || map.isEmpty()) ? t : map.get(str);
    }

    public static <T> T a(Map map, String str, Class<T> cls, T t) {
        T t2 = (T) c(map, str, t);
        return cls.isInstance(t2) ? t2 : t;
    }
}
