package com.huawei.appmarket.service.externalservice.distribution.download;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public interface IDownloadCallback extends IInterface {
    String getDownloadRegisterKey() throws RemoteException;

    void refreshAppStatus(String str, int i, int i2, int i3) throws RemoteException;

    public static abstract class Stub extends Binder implements IDownloadCallback {
        private static final String DESCRIPTOR = "com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback";
        static final int TRANSACTION_getDownloadRegisterKey = 1;
        static final int TRANSACTION_refreshAppStatus = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                String downloadRegisterKey = getDownloadRegisterKey();
                parcel2.writeNoException();
                parcel2.writeString(downloadRegisterKey);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            refreshAppStatus(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        static class d implements IDownloadCallback {
            public static IDownloadCallback b;
            private IBinder e;

            @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
            public void refreshAppStatus(String str, int i, int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (this.e.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().refreshAppStatus(str, i, i2, i3);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
            public String getDownloadRegisterKey() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.e.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getDownloadRegisterKey();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            d(IBinder iBinder) {
                this.e = iBinder;
            }
        }

        public static boolean setDefaultImpl(IDownloadCallback iDownloadCallback) {
            if (d.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDownloadCallback == null) {
                return false;
            }
            d.b = iDownloadCallback;
            return true;
        }

        public static IDownloadCallback getDefaultImpl() {
            return d.b;
        }

        public static IDownloadCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownloadCallback)) ? new d(iBinder) : (IDownloadCallback) iInterfaceQueryLocalInterface;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }
    }
}
