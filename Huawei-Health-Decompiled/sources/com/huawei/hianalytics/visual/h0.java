package com.huawei.hianalytics.visual;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import com.huawei.health.R;
import com.huawei.hianalytics.core.log.HiLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4063a = "";

    public static Activity a(Context context, View view) {
        Activity activity;
        Activity activity2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (!(context instanceof Activity)) {
                if (context instanceof ContextWrapper) {
                    while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                    }
                }
                if (activity2 != null && view != null) {
                    Object tag = view.getTag(R.id.hianalytics_activity_view_user_tag);
                    return tag instanceof Activity ? (Activity) tag : activity2;
                }
            }
            activity = (Activity) context;
            activity2 = activity;
            return activity2 != null ? activity2 : activity2;
        } catch (Exception e) {
            HiLog.w("PageUtils", "fail to acquire activity from context, ex: " + e.getMessage());
            return activity2;
        }
    }

    public static JSONObject b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        if (activity == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("$page_name", activity.getClass().getCanonicalName());
            jSONObject.put("$page_title", a(activity));
        } catch (Exception e) {
            HiLog.w("PageUtils", "fail to acquire page name and title, ex: " + e.getMessage());
        }
        return jSONObject;
    }

    public static String a(Activity activity) {
        Class<?> clsA;
        Object objInvoke;
        CharSequence charSequence;
        if (activity == null) {
            return "";
        }
        String string = TextUtils.isEmpty(activity.getTitle()) ? "" : activity.getTitle().toString();
        String string2 = null;
        try {
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                if (!TextUtils.isEmpty(actionBar.getTitle())) {
                    string2 = actionBar.getTitle().toString();
                }
            } else {
                try {
                    clsA = n0.a("android.support.v7.app.AppCompatActivity");
                } catch (Exception unused) {
                    clsA = null;
                }
                if (clsA == null) {
                    try {
                        clsA = n0.a("androidx.appcompat.app.AppCompatActivity");
                    } catch (Exception unused2) {
                    }
                }
                if (clsA != null && clsA.isInstance(activity) && (objInvoke = activity.getClass().getMethod("getSupportActionBar", new Class[0]).invoke(activity, new Object[0])) != null && (charSequence = (CharSequence) objInvoke.getClass().getMethod("getTitle", new Class[0]).invoke(objInvoke, new Object[0])) != null) {
                    string2 = charSequence.toString();
                }
            }
        } catch (Exception unused3) {
        }
        if (!TextUtils.isEmpty(string2)) {
            string = string2;
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            PackageManager packageManager = activity.getPackageManager();
            if (packageManager == null) {
                return string;
            }
            ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 0);
            return !TextUtils.isEmpty(activityInfo.loadLabel(packageManager)) ? activityInfo.loadLabel(packageManager).toString() : string;
        } catch (Exception e) {
            HiLog.w("PageUtils", "fail to acquire activity title, ex: " + e.getMessage());
            return string;
        }
    }
}
