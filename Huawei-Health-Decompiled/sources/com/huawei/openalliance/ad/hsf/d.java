package com.huawei.openalliance.ad.hsf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.openalliance.ad.hq;
import com.huawei.openalliance.ad.hsf.c;

/* JADX INFO: loaded from: classes6.dex */
public interface d extends IInterface {
    void a(String str, String str2, c cVar, int i);

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: com.huawei.openalliance.ad.hsf.d$a$a, reason: collision with other inner class name */
        static class C0206a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7175a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7175a;
            }

            @Override // com.huawei.openalliance.ad.hsf.d
            public void a(String str, String str2, c cVar, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hsf.pm.service.IPackageManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.f7175a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            C0206a(IBinder iBinder) {
                this.f7175a = iBinder;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.huawei.hsf.pm.service.IPackageManager");
                return true;
            }
            parcel.enforceInterface("com.huawei.hsf.pm.service.IPackageManager");
            a(parcel.readString(), parcel.readString(), c.a.a(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hsf.pm.service.IPackageManager");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new C0206a(iBinder) : (d) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                hq.c("IPackageManager", "IPackageManager err: " + th.getClass().getSimpleName());
                return null;
            }
        }
    }
}
