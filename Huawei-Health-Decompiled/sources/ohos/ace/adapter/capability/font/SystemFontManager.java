package ohos.ace.adapter.capability.font;

import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class SystemFontManager {
    private static final String CLASS_FONT = "android.graphics.fonts.Font";
    private static final String CLASS_FONT_STYLE = "android.graphics.fonts.FontStyle";
    private static final String CLASS_SYSTEM_FONTS = "android.graphics.fonts.SystemFonts";
    private static final String LOG_TAG = "SystemFontManager";
    private static final String METHOD_FONT_GET_FILE = "getFile";
    private static final String METHOD_FONT_GET_STYLE = "getStyle";
    private static final String METHOD_FONT_STYLE_GET_SLANT = "getSlant";
    private static final String METHOD_FONT_STYLE_GET_WEIGHT = "getWeight";
    private static final String METHOD_SYSTEM_FONTS_GET_AVAILABLE_FONTS = "getAvailableFonts";
    private Class<?> fontClazz;
    private Class<?> fontStyleClazz;
    private Method getAvailableFontsMethod;
    private Method getFileMethod;
    private Method getSlantMethod;
    private Method getStyleMethod;
    private Method getWeightMethod;
    private Class<?> systemFontsClazz;

    public native void nativeInit();

    public SystemFontManager() {
        nativeInit();
        prepareReflection();
    }

    void prepareReflection() {
        try {
            Class<?> cls = Class.forName(CLASS_SYSTEM_FONTS);
            this.systemFontsClazz = cls;
            this.getAvailableFontsMethod = cls.getMethod(METHOD_SYSTEM_FONTS_GET_AVAILABLE_FONTS, new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            ALog.w(LOG_TAG, "SystemFonts class or method not found");
        }
        try {
            Class<?> cls2 = Class.forName(CLASS_FONT);
            this.fontClazz = cls2;
            this.getFileMethod = cls2.getMethod(METHOD_FONT_GET_FILE, new Class[0]);
            this.getStyleMethod = this.fontClazz.getMethod(METHOD_FONT_GET_STYLE, new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused2) {
            ALog.w(LOG_TAG, "Font class or method not found");
        }
        try {
            Class<?> cls3 = Class.forName(CLASS_FONT_STYLE);
            this.fontStyleClazz = cls3;
            this.getWeightMethod = cls3.getMethod(METHOD_FONT_STYLE_GET_WEIGHT, new Class[0]);
            this.getSlantMethod = this.fontStyleClazz.getMethod(METHOD_FONT_STYLE_GET_SLANT, new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused3) {
            ALog.w(LOG_TAG, "FontStyle class or method not found");
        }
    }

    private Set<Object> getSystemFonts() {
        try {
            return (Set) this.getAvailableFontsMethod.invoke(this.systemFontsClazz, new Object[0]);
        } catch (IllegalAccessException | NullPointerException | InvocationTargetException unused) {
            ALog.e(LOG_TAG, "get system available font object set failed");
            return null;
        }
    }

    private void getFontInfoFromFile(File file, SystemFontInfo systemFontInfo) {
        if (file == null || systemFontInfo == null) {
            return;
        }
        try {
            systemFontInfo.setPath(file.getCanonicalPath());
        } catch (IOException unused) {
            ALog.e(LOG_TAG, "get system font info getCanonicalPath failed");
        }
        String name = file.getName();
        systemFontInfo.setName(name.substring(0, name.lastIndexOf(".")).replaceAll("[-_]", " "));
    }

    private void getFontInfoFromStyle(Object obj, SystemFontInfo systemFontInfo) {
        if (obj == null || systemFontInfo == null) {
            return;
        }
        try {
            systemFontInfo.setWeight(((Integer) this.getWeightMethod.invoke(obj, new Object[0])).intValue());
            systemFontInfo.setItalic(((Integer) this.getSlantMethod.invoke(obj, new Object[0])).intValue() > 0);
        } catch (IllegalAccessException | NullPointerException | InvocationTargetException unused) {
            ALog.e(LOG_TAG, "get system font info from font style failed");
        }
    }

    private List<SystemFontInfo> getFontInfoList(Set<Object> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (Object obj : set) {
                SystemFontInfo systemFontInfo = new SystemFontInfo();
                getFontInfoFromFile((File) this.getFileMethod.invoke(obj, new Object[0]), systemFontInfo);
                getFontInfoFromStyle(this.getStyleMethod.invoke(obj, new Object[0]), systemFontInfo);
                arrayList.add(systemFontInfo);
            }
        } catch (IllegalAccessException | NullPointerException | InvocationTargetException unused) {
            ALog.e(LOG_TAG, "get system font info list failed");
        }
        return arrayList;
    }

    public SystemFontInfo[] getSystemFontInfoList() {
        if (Build.VERSION.SDK_INT < 29) {
            ALog.e(LOG_TAG, "sdk build version not support get system font info list");
            return null;
        }
        List<SystemFontInfo> fontInfoList = getFontInfoList(getSystemFonts());
        if (fontInfoList == null) {
            return null;
        }
        SystemFontInfo[] systemFontInfoArr = new SystemFontInfo[fontInfoList.size()];
        fontInfoList.toArray(systemFontInfoArr);
        return systemFontInfoArr;
    }
}
