package com.huawei.wearengine.device;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes11.dex */
public interface ConnectionCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.device.ConnectionCallback";

    void onConnected(String str) throws RemoteException;

    void onDisconnected(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements ConnectionCallback {
        static final int TRANSACTION_onConnected = 1;
        static final int TRANSACTION_onDisconnected = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ConnectionCallback.DESCRIPTOR);
        }

        public static ConnectionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ConnectionCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ConnectionCallback)) {
                return (ConnectionCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ConnectionCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ConnectionCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onConnected(parcel.readString());
                parcel2.writeNoException();
            } else if (i == 2) {
                onDisconnected(parcel.readString());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class d implements ConnectionCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f11757a;

            d(IBinder iBinder) {
                this.f11757a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11757a;
            }

            @Override // com.huawei.wearengine.device.ConnectionCallback
            public void onConnected(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ConnectionCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.f11757a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.device.ConnectionCallback
            public void onDisconnected(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ConnectionCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.f11757a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
