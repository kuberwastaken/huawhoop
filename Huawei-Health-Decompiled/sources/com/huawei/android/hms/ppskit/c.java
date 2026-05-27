package com.huawei.android.hms.ppskit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends IInterface {
    void a(boolean z, int i);

    public static abstract class a extends Binder implements c {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.huawei.android.hms.ppskit.IPPSInstallationServiceCallback");
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.huawei.android.hms.ppskit.IPPSInstallationServiceCallback");
            a(parcel.readInt() != 0, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        static class d implements c {
            public static c b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f1877a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1877a;
            }

            @Override // com.huawei.android.hms.ppskit.c
            public void a(boolean z, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSInstallationServiceCallback");
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(i);
                    if (this.f1877a.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().a(z, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            d(IBinder iBinder) {
                this.f1877a = iBinder;
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hms.ppskit.IPPSInstallationServiceCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new d(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        public static c a() {
            return d.b;
        }

        public a() {
            attachInterface(this, "com.huawei.android.hms.ppskit.IPPSInstallationServiceCallback");
        }
    }
}
