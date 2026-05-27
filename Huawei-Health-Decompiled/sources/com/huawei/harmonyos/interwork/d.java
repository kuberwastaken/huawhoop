package com.huawei.harmonyos.interwork;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends IInterface {
    void a(String str, int i) throws RemoteException;

    void b(String str, int i) throws RemoteException;

    public static abstract class a extends Binder implements d {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.huawei.harmonyos.interwork.IDeviceStateCallback");
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.harmonyos.interwork.IDeviceStateCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof d)) {
                return (d) iInterfaceQueryLocalInterface;
            }
            return new b(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.huawei.harmonyos.interwork.IDeviceStateCallback");
                a(parcel.readString(), parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.huawei.harmonyos.interwork.IDeviceStateCallback");
                b(parcel.readString(), parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString("com.huawei.harmonyos.interwork.IDeviceStateCallback");
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static final class b implements d {
            public static d b;
            private IBinder d;

            b(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.harmonyos.interwork.d
            public final void a(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.harmonyos.interwork.IDeviceStateCallback");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.d.transact(1, parcelObtain, null, 1) || a.a() == null) {
                        return;
                    }
                    a.a().a(str, i);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.harmonyos.interwork.d
            public final void b(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.harmonyos.interwork.IDeviceStateCallback");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.d.transact(2, parcelObtain, null, 1) || a.a() == null) {
                        return;
                    }
                    a.a().b(str, i);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static d a() {
            return b.b;
        }
    }
}
