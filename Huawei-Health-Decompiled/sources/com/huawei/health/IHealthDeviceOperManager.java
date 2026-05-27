package com.huawei.health;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IHealthDeviceOperManager extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.IHealthDeviceOperManager";

    void holdDevice(String str) throws RemoteException;

    void releaseDevice(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IHealthDeviceOperManager {
        static final int TRANSACTION_holdDevice = 1;
        static final int TRANSACTION_releaseDevice = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IHealthDeviceOperManager.DESCRIPTOR);
        }

        public static IHealthDeviceOperManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IHealthDeviceOperManager.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IHealthDeviceOperManager)) {
                return (IHealthDeviceOperManager) iInterfaceQueryLocalInterface;
            }
            return new e(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IHealthDeviceOperManager.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IHealthDeviceOperManager.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                holdDevice(parcel.readString());
                parcel2.writeNoException();
            } else if (i == 2) {
                releaseDevice(parcel.readString());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        /* JADX INFO: loaded from: classes3.dex */
        static class e implements IHealthDeviceOperManager {
            private IBinder d;

            e(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.health.IHealthDeviceOperManager
            public void holdDevice(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHealthDeviceOperManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IHealthDeviceOperManager
            public void releaseDevice(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHealthDeviceOperManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
