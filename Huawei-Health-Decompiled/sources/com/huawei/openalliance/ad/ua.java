package com.huawei.openalliance.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ua implements ty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7806a;

    @Override // com.huawei.openalliance.ad.ty
    public boolean a() {
        return true;
    }

    @Override // com.huawei.openalliance.ad.ty
    public void a(Activity activity, uc ucVar, ue ueVar) {
        if (activity == null || activity.getApplicationContext() == null) {
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(ucVar.c() == null ? "" : ucVar.c());
        sb.append(ucVar.d() != null ? ucVar.d() : "");
        this.f7806a = sb.toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        List<Intent> listA = a(applicationContext.getPackageManager().queryIntentActivities(intent, 131072), ueVar.d());
        Intent intentCreateChooser = Intent.createChooser(listA.remove(0), ucVar.b() != null ? ucVar.b() : "text/plain");
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) listA.toArray(new Parcelable[0]));
        intentCreateChooser.setFlags(268435456);
        applicationContext.startActivity(intentCreateChooser);
    }

    private List<Intent> a(List<ResolveInfo> list, List<String> list2) {
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            if (list2.contains(resolveInfo.activityInfo.packageName)) {
                hq.a("MoreShareProcessor", "%s Not showing", resolveInfo.activityInfo.packageName);
            } else {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", this.f7806a);
                intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                arrayList.add(intent);
            }
        }
        return arrayList;
    }
}
