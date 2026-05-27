package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Bundle;
import com.huawei.openalliance.ad.activity.SafeIntent;
import com.huawei.openalliance.ad.hq;
import com.huawei.ui.openservice.db.model.ChildServiceTable;

/* JADX INFO: loaded from: classes6.dex */
public class i {
    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        hq.a("AnalyticsKitUtils", "ana_tag_kit broadcastEvent sourcePkg = %s", str);
        SafeIntent safeIntent = new SafeIntent("com.huawei.hms.analytics.pps.event");
        safeIntent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        bundle.putString("event_type", str2);
        bundle.putString(ChildServiceTable.COLUMN_SUB_TYPE, str3);
        bundle.putString("slot_id", str4);
        if (str5 == null) {
            bundle.putString("activity_name", "");
        } else {
            bundle.putString("activity_name", str5);
        }
        safeIntent.putExtra("event_detail", bundle);
        context.sendBroadcast(safeIntent);
        hq.a("AnalyticsKitUtils", "ana_tag sendBroadcast successfully!");
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        hq.a("AnalyticsKitUtils", "ana_tag_kit broadcastEvent sourcePkg = %s", str);
        SafeIntent safeIntent = new SafeIntent("com.huawei.hms.analytics.pps.event");
        safeIntent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        bundle.putString("event_type", str2);
        bundle.putString("slot_id", str3);
        if (str4 == null) {
            bundle.putString("activity_name", "");
        } else {
            bundle.putString("activity_name", str4);
        }
        safeIntent.putExtra("event_detail", bundle);
        context.sendBroadcast(safeIntent);
        hq.a("AnalyticsKitUtils", "ana_tag sendBroadcast successfully!");
    }
}
