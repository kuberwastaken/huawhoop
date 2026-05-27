package com.huawei.phdkit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes6.dex */
public interface DeviceStateListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.phdkit.DeviceStateListener";

    /* JADX INFO: loaded from: classes11.dex */
    public static class Default implements DeviceStateListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.phdkit.DeviceStateListener
        public void onDeviceStateChanged(DvLiteDevice dvLiteDevice, int i) throws RemoteException {
        }

        @Override // com.huawei.phdkit.DeviceStateListener
        public void onServiceDied() throws RemoteException {
        }
    }

    void onDeviceStateChanged(DvLiteDevice dvLiteDevice, int i) throws RemoteException;

    void onServiceDied() throws RemoteException;

    public static abstract class Stub extends Binder implements DeviceStateListener {
        static final int TRANSACTION_onDeviceStateChanged = 1;
        static final int TRANSACTION_onServiceDied = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DeviceStateListener.DESCRIPTOR);
        }

        public static DeviceStateListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DeviceStateListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof DeviceStateListener)) {
                return (DeviceStateListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(DeviceStateListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(DeviceStateListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                DvLiteDevice dvLiteDevice = (DvLiteDevice) e.cja_(parcel, DvLiteDevice.CREATOR);
                onDeviceStateChanged(dvLiteDevice, parcel.readInt());
                parcel2.writeNoException();
                e.cjb_(parcel2, dvLiteDevice, 1);
            } else if (i == 2) {
                onServiceDied();
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class Proxy implements DeviceStateListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.phdkit.DeviceStateListener
            public void onDeviceStateChanged(DvLiteDevice dvLiteDevice, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DeviceStateListener.DESCRIPTOR);
                    e.cjb_(parcelObtain, dvLiteDevice, 0);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        dvLiteDevice.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.phdkit.DeviceStateListener
            public void onServiceDied() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DeviceStateListener.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return DeviceStateListener.DESCRIPTOR;
            }
        }
    }

    public static class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T cja_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void cjb_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
