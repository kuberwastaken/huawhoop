package com.huawei.harmonyos.interwork;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends IInterface {
    void a(String str) throws RemoteException;

    void a(String str, int i) throws RemoteException;

    public static abstract class a extends Binder implements e {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.huawei.harmonyos.interwork.IInitCallBack");
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.harmonyos.interwork.IInitCallBack");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof e)) {
                return (e) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.huawei.harmonyos.interwork.IInitCallBack");
                a(parcel.readString());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.huawei.harmonyos.interwork.IInitCallBack");
                a(parcel.readString(), parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString("com.huawei.harmonyos.interwork.IInitCallBack");
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static final class c implements e {
            public static e c;
            private IBinder b;

            c(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }

            @Override // com.huawei.harmonyos.interwork.e
            public final void a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.harmonyos.interwork.IInitCallBack");
                    parcelObtain.writeString(str);
                    if (this.b.transact(1, parcelObtain, null, 1) || a.a() == null) {
                        return;
                    }
                    a.a().a(str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.harmonyos.interwork.e
            public final void a(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.harmonyos.interwork.IInitCallBack");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.b.transact(2, parcelObtain, null, 1) || a.a() == null) {
                        return;
                    }
                    a.a().a(str, i);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static e a() {
            return c.c;
        }
    }
}
