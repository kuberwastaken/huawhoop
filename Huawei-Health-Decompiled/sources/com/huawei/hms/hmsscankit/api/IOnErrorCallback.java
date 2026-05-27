package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IOnErrorCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IOnErrorCallback";

    /* JADX INFO: loaded from: classes10.dex */
    public static class Default implements IOnErrorCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IOnErrorCallback
        public void onError(int i) throws RemoteException {
        }
    }

    void onError(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IOnErrorCallback {
        static final int TRANSACTION_onError = 1;

        public Stub() {
            attachInterface(this, IOnErrorCallback.DESCRIPTOR);
        }

        public static IOnErrorCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IOnErrorCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOnErrorCallback)) ? new Proxy(iBinder) : (IOnErrorCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnErrorCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOnErrorCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            onError(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        static class Proxy implements IOnErrorCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hms.hmsscankit.api.IOnErrorCallback
            public void onError(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOnErrorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IOnErrorCallback.DESCRIPTOR;
            }
        }
    }
}
