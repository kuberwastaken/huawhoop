package com.huawei.uikit.hwcolumnsystem.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes8.dex */
public class HwColumnSplitManager {
    private static HwColumnSplitManager d = new HwColumnSplitManager();
    private SplitModeConfigListener c;

    public interface SplitModeConfigListener {
        boolean isSplitMode(Context context);
    }

    private HwColumnSplitManager() {
    }

    public static HwColumnSplitManager e() {
        return d;
    }

    public boolean b(Context context) {
        Object objInvoke;
        SplitModeConfigListener splitModeConfigListener = this.c;
        if (splitModeConfigListener != null) {
            boolean zIsSplitMode = splitModeConfigListener.isSplitMode(context);
            Log.d("HwColumnSplitManager", "isConfigSplitMode: " + zIsSplitMode);
            return zIsSplitMode;
        }
        Activity activityEzf_ = ezf_(context);
        if (activityEzf_ == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.IHwActivitySplitterImplEx");
            objInvoke = cls.getMethod("isSplitMode", new Class[0]).invoke(cls.getDeclaredConstructor(Activity.class, Boolean.TYPE).newInstance(activityEzf_, Boolean.TRUE), new Object[0]);
        } catch (ClassNotFoundException unused) {
            Log.w("HwColumnSplitManager", "isSplitMode: class not found");
        } catch (IllegalAccessException unused2) {
            Log.w("HwColumnSplitManager", "isSplitMode: illegal access exception");
        } catch (InstantiationException unused3) {
            Log.w("HwColumnSplitManager", "isSplitMode: instantiation exception");
        } catch (NoSuchMethodException unused4) {
            Log.w("HwColumnSplitManager", "isSplitMode: method not found");
        } catch (InvocationTargetException unused5) {
            Log.w("HwColumnSplitManager", "isSplitMode: invocation target exception");
        }
        if (!(objInvoke instanceof Boolean)) {
            Log.w("HwColumnSplitManager", "isSplitMode: object is not Boolean");
            return false;
        }
        boolean zBooleanValue = ((Boolean) objInvoke).booleanValue();
        Log.d("HwColumnSplitManager", "isReflectSplitMode: " + zBooleanValue);
        return zBooleanValue;
    }

    public Activity ezf_(Context context) {
        if (context == null) {
            return null;
        }
        Activity activity = null;
        while (activity == null && context != null) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        return activity;
    }

    public boolean ezg_(Activity activity) {
        return (activity == null || activity.getWindow() == null || activity.getWindow().getAttributes() == null) ? false : true;
    }
}
