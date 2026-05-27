package com.huawei.hwcloudjs.e.b;

import com.huawei.hwcloudjs.e.b.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c<T extends d> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b<T>> f6419a = new ArrayList();

    @Override // com.huawei.hwcloudjs.e.b.a
    public void b(b<T> bVar) {
        synchronized (this.f6419a) {
            if (bVar == null) {
                return;
            }
            if (!this.f6419a.contains(bVar)) {
                this.f6419a.add(bVar);
            }
        }
    }

    @Override // com.huawei.hwcloudjs.e.b.a
    public void a(T t) {
        synchronized (this.f6419a) {
            ArrayList arrayList = new ArrayList();
            for (b<T> bVar : this.f6419a) {
                if (!bVar.onReceive(t)) {
                    arrayList.add(bVar);
                }
            }
            if (arrayList.size() > 0) {
                this.f6419a.removeAll(arrayList);
            }
        }
    }

    @Override // com.huawei.hwcloudjs.e.b.a
    public void a(b<T> bVar) {
        synchronized (this.f6419a) {
            this.f6419a.remove(bVar);
        }
    }
}
