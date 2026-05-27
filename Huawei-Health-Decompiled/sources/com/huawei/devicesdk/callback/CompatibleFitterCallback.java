package com.huawei.devicesdk.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface CompatibleFitterCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.devicesdk.callback.CompatibleFitterCallback";

    void adapterOperate(List<String> list) throws RemoteException;

    public static abstract class Stub extends Binder implements CompatibleFitterCallback {
        static final int TRANSACTION_adapterOperate = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, CompatibleFitterCallback.DESCRIPTOR);
        }

        public static CompatibleFitterCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(CompatibleFitterCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof CompatibleFitterCallback)) {
                return (CompatibleFitterCallback) iInterfaceQueryLocalInterface;
            }
            return new e(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(CompatibleFitterCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(CompatibleFitterCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                adapterOperate(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class e implements CompatibleFitterCallback {
            private IBinder e;

            e(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.devicesdk.callback.CompatibleFitterCallback
            public void adapterOperate(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(CompatibleFitterCallback.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
