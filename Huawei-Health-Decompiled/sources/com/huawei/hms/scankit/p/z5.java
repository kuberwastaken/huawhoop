package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class z5 implements g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f6120a = new ArrayList();

    public void a(g4 g4Var) {
        if (this.f6120a == null) {
            this.f6120a = new ArrayList();
        }
        this.f6120a.add(g4Var);
    }

    @Override // com.huawei.hms.scankit.p.g4
    public void a(w5 w5Var) {
        Iterator it = this.f6120a.iterator();
        while (it.hasNext()) {
            ((g4) it.next()).a(w5Var);
        }
    }
}
