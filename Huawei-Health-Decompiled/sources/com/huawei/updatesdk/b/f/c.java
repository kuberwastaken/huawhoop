package com.huawei.updatesdk.b.f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f11343a = new c();
    private static com.huawei.updatesdk.b.f.a b = new a();

    public void c(com.huawei.updatesdk.a.b.b.b bVar) {
        b.a(2, bVar);
    }

    public void b(com.huawei.updatesdk.a.b.b.b bVar) {
        b.a(0, bVar);
    }

    static final class a implements com.huawei.updatesdk.b.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b> f11344a = new ArrayList();

        @Override // com.huawei.updatesdk.b.f.a
        public void b(b bVar) {
            synchronized (this.f11344a) {
                try {
                    this.f11344a.remove(bVar);
                } catch (UnsupportedOperationException unused) {
                    com.huawei.updatesdk.a.a.c.a.a.a.b("InstallObserverManager", "unRegisterObserver UnsupportedOperationException");
                }
            }
        }

        @Override // com.huawei.updatesdk.b.f.a
        public void a(b bVar) {
            String str;
            synchronized (this.f11344a) {
                if (bVar == null) {
                    return;
                }
                if (!this.f11344a.contains(bVar)) {
                    try {
                        this.f11344a.add(bVar);
                    } catch (ClassCastException unused) {
                        str = "registerObserver ClassCastException";
                        com.huawei.updatesdk.a.a.c.a.a.a.b("InstallObserverManager", str);
                    } catch (IllegalArgumentException unused2) {
                        str = "registerObserver IllegalArgumentException";
                        com.huawei.updatesdk.a.a.c.a.a.a.b("InstallObserverManager", str);
                    } catch (UnsupportedOperationException unused3) {
                        str = "registerObserver UnsupportedOperationException";
                        com.huawei.updatesdk.a.a.c.a.a.a.b("InstallObserverManager", str);
                    }
                }
            }
        }

        @Override // com.huawei.updatesdk.b.f.a
        public void a(int i, com.huawei.updatesdk.a.b.b.b bVar) {
            synchronized (this.f11344a) {
                Iterator<b> it = this.f11344a.iterator();
                while (it.hasNext()) {
                    it.next().a(i, bVar);
                }
            }
        }

        a() {
        }
    }

    public void a(com.huawei.updatesdk.a.b.b.b bVar) {
        b.a(1, bVar);
    }

    public static c b() {
        return f11343a;
    }

    public static com.huawei.updatesdk.b.f.a a() {
        return b;
    }

    private c() {
    }
}
