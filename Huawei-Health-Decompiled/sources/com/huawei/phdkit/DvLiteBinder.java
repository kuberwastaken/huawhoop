package com.huawei.phdkit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.phdkit.DataContentListener;
import com.huawei.phdkit.DeviceStateListener;
import com.huawei.phdkit.DiscoveryListener;

/* JADX INFO: loaded from: classes.dex */
public interface DvLiteBinder extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.phdkit.DvLiteBinder";

    /* JADX INFO: loaded from: classes11.dex */
    public static class Default implements DvLiteBinder {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.phdkit.DvLiteBinder
        public void clearDataListener() throws RemoteException {
        }

        @Override // com.huawei.phdkit.DvLiteBinder
        public void clearOneDataListener(String str) throws RemoteException {
        }

        @Override // com.huawei.phdkit.DvLiteBinder
        public void connectDevice(String str, DataContentListener dataContentListener) throws RemoteException {
        }

        @Override // com.huawei.phdkit.DvLiteBinder
        public String getIdentify(String str) throws RemoteException {
            return null;
        }

        @Override // com.huawei.phdkit.DvLiteBinder
        public void sendBluetoothData(DvLiteCommand dvLiteCommand) throws RemoteException {
        }

        @Override // com.huawei.phdkit.DvLiteBinder
        public boolean startDiscovery(DiscoveryListener discoveryListener) throws RemoteException {
            return false;
        }

        @Override // com.huawei.phdkit.DvLiteBinder
        public void subscribeDevice(String str, DeviceStateListener deviceStateListener) throws RemoteException {
        }

        @Override // com.huawei.phdkit.DvLiteBinder
        public void unSubscribeDevice(String str, DeviceStateListener deviceStateListener) throws RemoteException {
        }
    }

    void clearDataListener() throws RemoteException;

    void clearOneDataListener(String str) throws RemoteException;

    void connectDevice(String str, DataContentListener dataContentListener) throws RemoteException;

    String getIdentify(String str) throws RemoteException;

    void sendBluetoothData(DvLiteCommand dvLiteCommand) throws RemoteException;

    boolean startDiscovery(DiscoveryListener discoveryListener) throws RemoteException;

    void subscribeDevice(String str, DeviceStateListener deviceStateListener) throws RemoteException;

    void unSubscribeDevice(String str, DeviceStateListener deviceStateListener) throws RemoteException;

    public static abstract class Stub extends Binder implements DvLiteBinder {
        static final int TRANSACTION_clearDataListener = 6;
        static final int TRANSACTION_clearOneDataListener = 7;
        static final int TRANSACTION_connectDevice = 3;
        static final int TRANSACTION_getIdentify = 8;
        static final int TRANSACTION_sendBluetoothData = 2;
        static final int TRANSACTION_startDiscovery = 1;
        static final int TRANSACTION_subscribeDevice = 4;
        static final int TRANSACTION_unSubscribeDevice = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DvLiteBinder.DESCRIPTOR);
        }

        public static DvLiteBinder asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DvLiteBinder.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof DvLiteBinder)) {
                return (DvLiteBinder) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(DvLiteBinder.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(DvLiteBinder.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    boolean zStartDiscovery = startDiscovery(DiscoveryListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zStartDiscovery ? 1 : 0);
                    return true;
                case 2:
                    sendBluetoothData((DvLiteCommand) d.cjh_(parcel, DvLiteCommand.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    connectDevice(parcel.readString(), DataContentListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    subscribeDevice(parcel.readString(), DeviceStateListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    unSubscribeDevice(parcel.readString(), DeviceStateListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    clearDataListener();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    clearOneDataListener(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    String identify = getIdentify(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(identify);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: loaded from: classes11.dex */
        static class Proxy implements DvLiteBinder {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.phdkit.DvLiteBinder
            public boolean startDiscovery(DiscoveryListener discoveryListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DvLiteBinder.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(discoveryListener);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.phdkit.DvLiteBinder
            public void sendBluetoothData(DvLiteCommand dvLiteCommand) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DvLiteBinder.DESCRIPTOR);
                    d.cji_(parcelObtain, dvLiteCommand, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.phdkit.DvLiteBinder
            public void connectDevice(String str, DataContentListener dataContentListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DvLiteBinder.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(dataContentListener);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.phdkit.DvLiteBinder
            public void subscribeDevice(String str, DeviceStateListener deviceStateListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DvLiteBinder.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(deviceStateListener);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.phdkit.DvLiteBinder
            public void unSubscribeDevice(String str, DeviceStateListener deviceStateListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DvLiteBinder.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(deviceStateListener);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.phdkit.DvLiteBinder
            public void clearDataListener() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DvLiteBinder.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.phdkit.DvLiteBinder
            public void clearOneDataListener(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DvLiteBinder.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.phdkit.DvLiteBinder
            public String getIdentify(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DvLiteBinder.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return DvLiteBinder.DESCRIPTOR;
            }
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T cjh_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void cji_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
