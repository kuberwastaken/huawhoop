package com.huawei.wearengine.auth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes11.dex */
public interface AuthListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.auth.AuthListener";

    void onCancel() throws RemoteException;

    void onOk(Permission[] permissionArr) throws RemoteException;

    public static abstract class Stub extends Binder implements AuthListener {
        static final int TRANSACTION_onCancel = 2;
        static final int TRANSACTION_onOk = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, AuthListener.DESCRIPTOR);
        }

        public static AuthListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(AuthListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof AuthListener)) {
                return (AuthListener) iInterfaceQueryLocalInterface;
            }
            return new b(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(AuthListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(AuthListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onOk((Permission[]) parcel.createTypedArray(Permission.CREATOR));
                parcel2.writeNoException();
            } else if (i == 2) {
                onCancel();
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class b implements AuthListener {
            private IBinder d;

            b(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.wearengine.auth.AuthListener
            public void onOk(Permission[] permissionArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AuthListener.DESCRIPTOR);
                    parcelObtain.writeTypedArray(permissionArr, 0);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.auth.AuthListener
            public void onCancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AuthListener.DESCRIPTOR);
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
