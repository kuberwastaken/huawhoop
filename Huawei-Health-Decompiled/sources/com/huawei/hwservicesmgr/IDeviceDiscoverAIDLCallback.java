package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.health.devicemgr.business.entity.DeviceInfo;

/* JADX INFO: loaded from: classes11.dex */
public interface IDeviceDiscoverAIDLCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hwservicesmgr.IDeviceDiscoverAIDLCallback";

    void onDeviceDiscovered(DeviceInfo deviceInfo) throws RemoteException;

    void onDeviceDiscoveryCanceled() throws RemoteException;

    void onDeviceDiscoveryFinished() throws RemoteException;

    void onFailure(int i, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IDeviceDiscoverAIDLCallback {
        static final int TRANSACTION_onDeviceDiscovered = 1;
        static final int TRANSACTION_onDeviceDiscoveryCanceled = 3;
        static final int TRANSACTION_onDeviceDiscoveryFinished = 2;
        static final int TRANSACTION_onFailure = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IDeviceDiscoverAIDLCallback.DESCRIPTOR);
        }

        public static IDeviceDiscoverAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDeviceDiscoverAIDLCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDeviceDiscoverAIDLCallback)) {
                return (IDeviceDiscoverAIDLCallback) iInterfaceQueryLocalInterface;
            }
            return new e(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDeviceDiscoverAIDLCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDeviceDiscoverAIDLCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onDeviceDiscovered((DeviceInfo) a.bYQ_(parcel, DeviceInfo.CREATOR));
                parcel2.writeNoException();
            } else if (i == 2) {
                onDeviceDiscoveryFinished();
                parcel2.writeNoException();
            } else if (i == 3) {
                onDeviceDiscoveryCanceled();
                parcel2.writeNoException();
            } else if (i == 4) {
                onFailure(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class e implements IDeviceDiscoverAIDLCallback {
            private IBinder e;

            e(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.hwservicesmgr.IDeviceDiscoverAIDLCallback
            public void onDeviceDiscovered(DeviceInfo deviceInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeviceDiscoverAIDLCallback.DESCRIPTOR);
                    a.bYR_(parcelObtain, deviceInfo, 0);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.IDeviceDiscoverAIDLCallback
            public void onDeviceDiscoveryFinished() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeviceDiscoverAIDLCallback.DESCRIPTOR);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.IDeviceDiscoverAIDLCallback
            public void onDeviceDiscoveryCanceled() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeviceDiscoverAIDLCallback.DESCRIPTOR);
                    this.e.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.IDeviceDiscoverAIDLCallback
            public void onFailure(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeviceDiscoverAIDLCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.e.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T bYQ_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void bYR_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
