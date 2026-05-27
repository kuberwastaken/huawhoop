package com.huawei.phdkit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes11.dex */
public interface DataReceiveListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.phdkit.DataReceiveListener";

    public static class Default implements DataReceiveListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.phdkit.DataReceiveListener
        public void onDataChanged(DeviceData deviceData) throws RemoteException {
        }
    }

    void onDataChanged(DeviceData deviceData) throws RemoteException;

    public static abstract class Stub extends Binder implements DataReceiveListener {
        static final int TRANSACTION_onDataChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DataReceiveListener.DESCRIPTOR);
        }

        public static DataReceiveListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DataReceiveListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof DataReceiveListener)) {
                return (DataReceiveListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(DataReceiveListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(DataReceiveListener.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            DeviceData deviceData = (DeviceData) a.ciV_(parcel, DeviceData.CREATOR);
            onDataChanged(deviceData);
            parcel2.writeNoException();
            a.ciW_(parcel2, deviceData, 1);
            return true;
        }

        static class Proxy implements DataReceiveListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.phdkit.DataReceiveListener
            public void onDataChanged(DeviceData deviceData) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DataReceiveListener.DESCRIPTOR);
                    a.ciW_(parcelObtain, deviceData, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        deviceData.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return DataReceiveListener.DESCRIPTOR;
            }
        }
    }

    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T ciV_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void ciW_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
