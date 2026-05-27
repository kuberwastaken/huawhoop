package com.huawei.openalliance.ad.hsf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes6.dex */
public interface c extends IInterface {
    void a(String str, int i);

    public static abstract class a extends Binder implements c {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX INFO: renamed from: com.huawei.openalliance.ad.hsf.c$a$a, reason: collision with other inner class name */
        static class C0205a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7174a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7174a;
            }

            @Override // com.huawei.openalliance.ad.hsf.c
            public void a(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hsf.pm.service.IPackageInstalledCallback");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.f7174a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            C0205a(IBinder iBinder) {
                this.f7174a = iBinder;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.huawei.hsf.pm.service.IPackageInstalledCallback");
                a(parcel.readString(), parcel.readInt());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.huawei.hsf.pm.service.IPackageInstalledCallback");
            return true;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hsf.pm.service.IPackageInstalledCallback");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0205a(iBinder) : (c) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                hq.c("IPackageInstalledCallback", "IPackageInstalledCallback err: " + th.getClass().getSimpleName());
                return null;
            }
        }

        public a() {
            attachInterface(this, "com.huawei.hsf.pm.service.IPackageInstalledCallback");
        }
    }
}
