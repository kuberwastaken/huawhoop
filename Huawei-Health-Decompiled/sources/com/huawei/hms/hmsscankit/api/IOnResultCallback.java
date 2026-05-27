package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.ml.scan.HmsScan;

/* JADX INFO: loaded from: classes5.dex */
public interface IOnResultCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IOnResultCallback";

    /* JADX INFO: loaded from: classes10.dex */
    public static class Default implements IOnResultCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IOnResultCallback
        public void onResult(HmsScan[] hmsScanArr) throws RemoteException {
        }
    }

    void onResult(HmsScan[] hmsScanArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IOnResultCallback {
        static final int TRANSACTION_onResult = 1;

        public Stub() {
            attachInterface(this, IOnResultCallback.DESCRIPTOR);
        }

        public static IOnResultCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IOnResultCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOnResultCallback)) ? new Proxy(iBinder) : (IOnResultCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnResultCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOnResultCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            onResult((HmsScan[]) parcel.createTypedArray(HmsScan.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        static class Proxy implements IOnResultCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hms.hmsscankit.api.IOnResultCallback
            public void onResult(HmsScan[] hmsScanArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOnResultCallback.DESCRIPTOR);
                    parcelObtain.writeTypedArray(hmsScanArr, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IOnResultCallback.DESCRIPTOR;
            }
        }
    }
}
