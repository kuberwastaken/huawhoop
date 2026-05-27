package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class x5 implements f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f6107a = new ArrayList();

    public void a(f4 f4Var) {
        if (this.f6107a == null) {
            this.f6107a = new ArrayList();
        }
        this.f6107a.add(f4Var);
    }

    @Override // com.huawei.hms.scankit.p.f4
    public void a(w5 w5Var, long j) {
        Iterator it = this.f6107a.iterator();
        while (it.hasNext()) {
            ((f4) it.next()).a(w5Var, j);
        }
    }
}
