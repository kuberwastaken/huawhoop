package com.huawei.agconnect.abtest.internal;

import android.content.Context;
import android.os.Bundle;
import com.huawei.agconnect.abtest.ABTestException;
import com.huawei.agconnect.abtest.AGConnectABTesting;
import com.huawei.agconnect.common.api.HaBridge;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.agconnect.datastore.core.SharedPrefUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class AGConnectABTestingImpl extends AGConnectABTesting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1727a;
    private HaBridge b = new HaBridge(HaBridge.HA_SERVICE_TAG_ABTEST);

    @Override // com.huawei.agconnect.abtest.AGConnectABTesting
    public void replaceAllExperiments(List<Map<String, String>> list) throws ABTestException {
        if (list == null) {
            throw new IllegalArgumentException("The replacementExperiments list is null.");
        }
        if (list.isEmpty()) {
            removeAllExperiments();
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator<Map<String, String>> it = list.iterator();
        while (it.hasNext()) {
            ABTestExperimentInfo aBTestExperimentInfoA = ABTestExperimentInfo.a(it.next());
            arrayList.add(aBTestExperimentInfoA);
            hashSet.add(aBTestExperimentInfoA.a());
        }
        List<ABTestExperimentInfo> listA = ExperimentStorage.a(this.f1727a);
        HashSet hashSet2 = new HashSet();
        Iterator<ABTestExperimentInfo> it2 = listA.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().a());
        }
        b(b(listA, hashSet));
        a(a(arrayList, hashSet2));
        ExperimentStorage.c();
    }

    @Override // com.huawei.agconnect.abtest.AGConnectABTesting
    public void removeAllExperiments() {
        b(ExperimentStorage.a(this.f1727a));
        ExperimentStorage.c();
    }

    private void b(List<ABTestExperimentInfo> list) {
        Iterator<ABTestExperimentInfo> it = list.iterator();
        while (it.hasNext()) {
            ExperimentStorage.a(it.next());
        }
    }

    private ArrayList<ABTestExperimentInfo> b(List<ABTestExperimentInfo> list, Set<String> set) {
        ArrayList<ABTestExperimentInfo> arrayList = new ArrayList<>();
        for (ABTestExperimentInfo aBTestExperimentInfo : list) {
            if (!set.contains(aBTestExperimentInfo.a())) {
                arrayList.add(aBTestExperimentInfo);
            }
        }
        return arrayList;
    }

    private void a(List<ABTestExperimentInfo> list) {
        ArrayDeque arrayDeque = new ArrayDeque(ExperimentStorage.a(this.f1727a));
        for (ABTestExperimentInfo aBTestExperimentInfo : list) {
            while (arrayDeque.size() >= 25) {
                ABTestExperimentInfo aBTestExperimentInfo2 = (ABTestExperimentInfo) arrayDeque.pollFirst();
                if (aBTestExperimentInfo2 != null) {
                    ExperimentStorage.a(aBTestExperimentInfo2);
                }
            }
            a(aBTestExperimentInfo);
            arrayDeque.offer(aBTestExperimentInfo);
        }
    }

    private void a(ABTestExperimentInfo aBTestExperimentInfo) {
        if (aBTestExperimentInfo.b() == null || aBTestExperimentInfo.b().length() == 0) {
            Bundle bundle = new Bundle();
            bundle.putString("$ABTaskId", aBTestExperimentInfo.a());
            bundle.putString("$ABVarId", aBTestExperimentInfo.c());
            bundle.putString("$ABChannel", this.f1727a);
            Logger.d("ABTest", "report ab test event");
            this.b.onEvent("$JoinABTask", bundle);
            aBTestExperimentInfo.a(true);
        }
        ExperimentStorage.a(aBTestExperimentInfo, this.f1727a);
    }

    private ArrayList<ABTestExperimentInfo> a(List<ABTestExperimentInfo> list, Set<String> set) {
        ArrayList<ABTestExperimentInfo> arrayList = new ArrayList<>();
        for (ABTestExperimentInfo aBTestExperimentInfo : list) {
            if (!set.contains(aBTestExperimentInfo.a())) {
                arrayList.add(aBTestExperimentInfo);
            }
        }
        return arrayList;
    }

    public AGConnectABTestingImpl(Context context, String str) {
        this.f1727a = str;
        SharedPrefUtil.init(context);
        ExperimentStorage.b();
    }
}
