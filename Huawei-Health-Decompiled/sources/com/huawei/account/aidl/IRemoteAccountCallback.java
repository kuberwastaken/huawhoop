package com.huawei.account.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public interface IRemoteAccountCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.account.aidl.IRemoteAccountCallback";

    void onResponse(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteAccountCallback {
        static final int TRANSACTION_onResponse = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IRemoteAccountCallback.DESCRIPTOR);
        }

        public static IRemoteAccountCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteAccountCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteAccountCallback)) {
                return (IRemoteAccountCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IRemoteAccountCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IRemoteAccountCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResponse(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class d implements IRemoteAccountCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f1704a;

            d(IBinder iBinder) {
                this.f1704a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1704a;
            }

            @Override // com.huawei.account.aidl.IRemoteAccountCallback
            public void onResponse(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteAccountCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.f1704a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
