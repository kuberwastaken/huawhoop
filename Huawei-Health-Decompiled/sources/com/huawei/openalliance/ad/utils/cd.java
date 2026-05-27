package com.huawei.openalliance.ad.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.huawei.openalliance.ad.hq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PackageManager f7939a;

    public boolean a(String str) {
        ApplicationInfo applicationInfo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            applicationInfo = this.f7939a.getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            hq.a("PackageManagerHelper", "isAppInstalledStatusEnable package not find! package:%s", str);
            applicationInfo = null;
        } catch (Exception e) {
            hq.c("PackageManagerHelper", "getApplicationInfo " + e.getClass().getSimpleName());
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return applicationInfo.enabled;
        }
        return false;
    }

    public String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        List<ResolveInfo> listQueryIntentActivities = this.f7939a.queryIntentActivities(intent, 0);
        int size = listQueryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            String str = listQueryIntentActivities.get(i).activityInfo.packageName;
            if (b(str)) {
                return str;
            }
        }
        return null;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f7939a.getPreferredActivities(arrayList, arrayList2, str);
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            hq.a("PackageManagerHelper", " preferredCompents pkg: %s", ((ComponentName) arrayList2.get(i)).getPackageName());
        }
        return arrayList2.size() > 0;
    }

    public cd(Context context) {
        this.f7939a = context.getPackageManager();
    }
}
