package com.huawei.hms.network.embedded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class v4 extends w4 {
    public static final String b = "AllDetectImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, List<y4>> f5726a = new HashMap();

    public String toString() {
        return "AllDetectImpl{allDetectMap=" + this.f5726a + '}';
    }

    @Override // com.huawei.hms.network.embedded.w4
    public y4 b(int i) {
        List<y4> list = this.f5726a.get(Integer.valueOf(i));
        return (list == null || list.isEmpty()) ? new x4() : list.get(list.size() - 1);
    }

    @Override // com.huawei.hms.network.embedded.w4
    public long b() {
        if (this.f5726a.isEmpty()) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<Integer> it = this.f5726a.keySet().iterator();
        while (it.hasNext()) {
            y4 y4VarB = b(it.next().intValue());
            if (y4VarB != null && y4VarB.b() > 0) {
                jCurrentTimeMillis = Math.min(jCurrentTimeMillis, y4VarB.b());
            }
        }
        return jCurrentTimeMillis;
    }

    @Override // com.huawei.hms.network.embedded.w4
    public void a(y4 y4Var) {
        synchronized (this) {
            int iD = y4Var.d();
            if (this.f5726a.get(Integer.valueOf(iD)) == null) {
                this.f5726a.put(Integer.valueOf(iD), new ArrayList());
            }
            this.f5726a.get(Integer.valueOf(iD)).add(y4Var);
        }
    }

    @Override // com.huawei.hms.network.embedded.w4
    public Map<Integer, List<y4>> a() {
        return this.f5726a;
    }

    @Override // com.huawei.hms.network.embedded.w4
    public List<y4> a(int i) {
        return this.f5726a.get(Integer.valueOf(i));
    }
}
