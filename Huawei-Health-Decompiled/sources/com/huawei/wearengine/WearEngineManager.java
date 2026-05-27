package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.wearengine.connect.ServiceConnectCallback;

/* JADX INFO: loaded from: classes11.dex */
public interface WearEngineManager extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.WearEngineManager";

    int registerConnectCallback(ServiceConnectCallback serviceConnectCallback) throws RemoteException;

    int releaseConnection() throws RemoteException;

    int unregisterConnectCallback(ServiceConnectCallback serviceConnectCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements WearEngineManager {
        static final int TRANSACTION_registerConnectCallback = 1;
        static final int TRANSACTION_releaseConnection = 3;
        static final int TRANSACTION_unregisterConnectCallback = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, WearEngineManager.DESCRIPTOR);
        }

        public static WearEngineManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(WearEngineManager.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof WearEngineManager)) {
                return (WearEngineManager) iInterfaceQueryLocalInterface;
            }
            return new e(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(WearEngineManager.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(WearEngineManager.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                int iRegisterConnectCallback = registerConnectCallback(ServiceConnectCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(iRegisterConnectCallback);
            } else if (i == 2) {
                int iUnregisterConnectCallback = unregisterConnectCallback(ServiceConnectCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(iUnregisterConnectCallback);
            } else if (i == 3) {
                int iReleaseConnection = releaseConnection();
                parcel2.writeNoException();
                parcel2.writeInt(iReleaseConnection);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class e implements WearEngineManager {
            private IBinder d;

            e(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.wearengine.WearEngineManager
            public int registerConnectCallback(ServiceConnectCallback serviceConnectCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(WearEngineManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(serviceConnectCallback);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.WearEngineManager
            public int unregisterConnectCallback(ServiceConnectCallback serviceConnectCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(WearEngineManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(serviceConnectCallback);
                    this.d.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.WearEngineManager
            public int releaseConnection() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(WearEngineManager.DESCRIPTOR);
                    this.d.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
