package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f6013a = new HashMap();

    m() {
    }

    int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry entry : this.f6013a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > iIntValue) {
                iIntValue = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add((Integer) entry.getKey());
            } else if (((Integer) entry.getValue()).intValue() == iIntValue) {
                arrayList.add((Integer) entry.getKey());
            }
        }
        return n5.a(arrayList);
    }

    void a(int i) {
        Integer num = (Integer) this.f6013a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f6013a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
