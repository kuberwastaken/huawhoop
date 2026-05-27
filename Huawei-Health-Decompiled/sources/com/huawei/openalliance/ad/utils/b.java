package com.huawei.openalliance.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    private static Activity b(Context context) {
        if (context == null) {
            hq.d("ActivityUtils", "ana_tag getActivity context is null, return");
            return null;
        }
        int i = 0;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            i++;
            if (i > 5) {
                hq.d("ActivityUtils", "ana_tag getActivity loop too much times, return");
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static String a(Object obj) {
        String str;
        if (obj == null) {
            str = "ana_tag getActivityName obj is null, return";
        } else {
            if (obj instanceof View) {
                return a(((View) obj).getContext());
            }
            str = "ana_tag  getActivityName activityname is not view";
        }
        hq.d("ActivityUtils", str);
        return null;
    }

    public static String a(Context context) {
        Activity activityB = b(context);
        if (activityB != null) {
            hq.a("ActivityUtils", "ana_tag  getActivityLocalClassName LocalClassName = %s", activityB.getLocalClassName());
            return activityB.getLocalClassName();
        }
        hq.d("ActivityUtils", "ana_tag  getActivityLocalClassName LocalClassName is null");
        return "";
    }
}
