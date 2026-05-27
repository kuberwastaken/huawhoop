package com.huawei.phdkit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes6.dex */
public interface DataContentListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.phdkit.DataContentListener";

    /* JADX INFO: loaded from: classes11.dex */
    public static class Default implements DataContentListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.phdkit.DataContentListener
        public void getResult(String str, String str2) throws RemoteException {
        }

        @Override // com.huawei.phdkit.DataContentListener
        public void getStatus(DeviceData deviceData) throws RemoteException {
        }
    }

    void getResult(String str, String str2) throws RemoteException;

    void getStatus(DeviceData deviceData) throws RemoteException;

    public static abstract class Stub extends Binder implements DataContentListener {
        static final int TRANSACTION_getResult = 1;
        static final int TRANSACTION_getStatus = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DataContentListener.DESCRIPTOR);
        }

        public static DataContentListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DataContentListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof DataContentListener)) {
                return (DataContentListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(DataContentListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(DataContentListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                getResult(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                DeviceData deviceData = (DeviceData) b.ciR_(parcel, DeviceData.CREATOR);
                getStatus(deviceData);
                parcel2.writeNoException();
                b.ciS_(parcel2, deviceData, 1);
            }
            return true;
        }

        static class Proxy implements DataContentListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.phdkit.DataContentListener
            public void getResult(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DataContentListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.phdkit.DataContentListener
            public void getStatus(DeviceData deviceData) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DataContentListener.DESCRIPTOR);
                    b.ciS_(parcelObtain, deviceData, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
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
                return DataContentListener.DESCRIPTOR;
            }
        }
    }

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T ciR_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void ciS_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
