package com.huawei.health;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IResultCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.IResultCallback";

    void onFailed(Bundle bundle) throws RemoteException;

    void onServiceException(Bundle bundle) throws RemoteException;

    void onSuccess(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IResultCallback {
        static final int TRANSACTION_onFailed = 2;
        static final int TRANSACTION_onServiceException = 3;
        static final int TRANSACTION_onSuccess = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IResultCallback.DESCRIPTOR);
        }

        public static IResultCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IResultCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IResultCallback)) {
                return (IResultCallback) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IResultCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IResultCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess((Bundle) a.Cq_(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else if (i == 2) {
                onFailed((Bundle) a.Cq_(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else if (i == 3) {
                onServiceException((Bundle) a.Cq_(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        /* JADX INFO: loaded from: classes3.dex */
        static class c implements IResultCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f2213a;

            c(IBinder iBinder) {
                this.f2213a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2213a;
            }

            @Override // com.huawei.health.IResultCallback
            public void onSuccess(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IResultCallback.DESCRIPTOR);
                    a.Cr_(parcelObtain, bundle, 0);
                    this.f2213a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IResultCallback
            public void onFailed(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IResultCallback.DESCRIPTOR);
                    a.Cr_(parcelObtain, bundle, 0);
                    this.f2213a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IResultCallback
            public void onServiceException(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IResultCallback.DESCRIPTOR);
                    a.Cr_(parcelObtain, bundle, 0);
                    this.f2213a.transact(3, parcelObtain, parcelObtain2, 0);
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
        public static <T> T Cq_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void Cr_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
