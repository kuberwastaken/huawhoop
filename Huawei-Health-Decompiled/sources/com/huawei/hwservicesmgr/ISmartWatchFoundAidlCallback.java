package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface ISmartWatchFoundAidlCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hwservicesmgr.ISmartWatchFoundAidlCallback";

    void onResponse(List<String> list) throws RemoteException;

    public static abstract class Stub extends Binder implements ISmartWatchFoundAidlCallback {
        static final int TRANSACTION_onResponse = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISmartWatchFoundAidlCallback.DESCRIPTOR);
        }

        public static ISmartWatchFoundAidlCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISmartWatchFoundAidlCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISmartWatchFoundAidlCallback)) {
                return (ISmartWatchFoundAidlCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISmartWatchFoundAidlCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISmartWatchFoundAidlCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResponse(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class d implements ISmartWatchFoundAidlCallback {
            private IBinder c;

            d(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.hwservicesmgr.ISmartWatchFoundAidlCallback
            public void onResponse(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISmartWatchFoundAidlCallback.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
