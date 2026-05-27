package com.huawei.wearengine.connect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes11.dex */
public interface ServiceConnectCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.connect.ServiceConnectCallback";

    void onServiceDisconnect() throws RemoteException;

    public static abstract class Stub extends Binder implements ServiceConnectCallback {
        static final int TRANSACTION_onServiceDisconnect = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ServiceConnectCallback.DESCRIPTOR);
        }

        public static ServiceConnectCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ServiceConnectCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ServiceConnectCallback)) {
                return (ServiceConnectCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ServiceConnectCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ServiceConnectCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onServiceDisconnect();
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class d implements ServiceConnectCallback {
            private IBinder d;

            d(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.wearengine.connect.ServiceConnectCallback
            public void onServiceDisconnect() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ServiceConnectCallback.DESCRIPTOR);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
