package com.huawei.hianalytics.visual.autocollect.instrument;

import android.app.Activity;
import android.view.View;
import com.huawei.health.R;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.visual.autocollect.ParamCollector;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ParamCollectorInstrumentation {
    public static ParamCollector a(Object obj) {
        try {
            Object objNewInstance = Class.forName(obj.getClass().getName() + "$ParamCollector").getConstructor(obj.getClass()).newInstance(obj);
            if (objNewInstance instanceof ParamCollector) {
                return (ParamCollector) objNewInstance;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            HiLog.w("FLInst", "newCollectorInstance fail");
            return null;
        }
    }

    public static Map<String, String> getClickParams(View view) {
        return getParamsByTag(view, 1);
    }

    public static Map<String, String> getPageParams(View view) {
        return getParamsByTag(view, 2);
    }

    public static Map<String, String> getParamsByTag(View view, int i) {
        HashMap map = new HashMap();
        while (view != null) {
            Object tag = view.getTag(R.id.hianalytics_event_param_collector);
            if (tag instanceof ParamCollector) {
                map.putAll(((ParamCollector) tag).toMap(i));
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return map;
    }

    public static void onQuickCardClick(View view, String str, Map<String, Object> map) {
        try {
            Object tag = view.getTag(R.id.hianalytics_view_custom_property_tag);
            JSONObject jSONObject = tag instanceof JSONObject ? (JSONObject) tag : new JSONObject();
            jSONObject.put("clickMethod", str);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    jSONObject.put(str2, map.get(str2));
                }
            }
            view.setTag(R.id.hianalytics_view_custom_property_tag, jSONObject);
        } catch (JSONException unused) {
            HiLog.w("FLInst", "onQuickCardClick JSONException");
        }
    }

    public static void setActivityTag(Activity activity) {
        ParamCollector paramCollectorA;
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || activity.getWindow().getDecorView().getRootView() == null || (paramCollectorA = a(activity)) == null) {
            return;
        }
        activity.getWindow().getDecorView().getRootView().setTag(R.id.hianalytics_event_param_collector, paramCollectorA);
    }

    public static void setViewTag(View view, ParamCollector paramCollector) {
        if (view == null || paramCollector == null) {
            return;
        }
        view.setTag(R.id.hianalytics_event_param_collector, paramCollector);
    }

    public static void setViewTag(View view, Object obj) {
        ParamCollector paramCollectorA;
        if (view == null || obj == null || (paramCollectorA = a(obj)) == null) {
            return;
        }
        view.setTag(R.id.hianalytics_event_param_collector, paramCollectorA);
    }
}
