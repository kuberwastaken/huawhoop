package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes5.dex */
public interface IMapClientIdentity extends IInterface {
    void regestToProvierIdentity(com.huawei.hms.maps.model.maa maaVar);

    public static abstract class Stub extends Binder implements IMapClientIdentity {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        static class Proxy implements IMapClientIdentity {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5145a;

            @Override // com.huawei.hms.maps.internal.IMapClientIdentity
            public void regestToProvierIdentity(com.huawei.hms.maps.model.maa maaVar) {
                com.huawei.hms.maps.model.internal.mab.a(this.f5145a, "com.huawei.hms.maps.internal.IMapClientIdentity", 1, maaVar);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IMapClientIdentity";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5145a;
            }

            Proxy(IBinder iBinder) {
                this.f5145a = iBinder;
            }
        }

        public static IMapClientIdentity asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IMapClientIdentity");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMapClientIdentity)) ? new Proxy(iBinder) : (IMapClientIdentity) iInterfaceQueryLocalInterface;
        }
    }
}
