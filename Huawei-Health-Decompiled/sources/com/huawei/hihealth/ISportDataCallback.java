package com.huawei.hihealth;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ISportDataCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hihealth.ISportDataCallback";

    public static class Default implements ISportDataCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hihealth.ISportDataCallback
        public void onDataChanged(int i, Bundle bundle) throws RemoteException {
        }

        @Override // com.huawei.hihealth.ISportDataCallback
        public void onResult(int i) throws RemoteException {
        }
    }

    void onDataChanged(int i, Bundle bundle) throws RemoteException;

    void onResult(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ISportDataCallback {
        static final int TRANSACTION_onDataChanged = 2;
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISportDataCallback.DESCRIPTOR);
        }

        public static ISportDataCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISportDataCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISportDataCallback)) {
                return (ISportDataCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISportDataCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISportDataCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResult(parcel.readInt());
                parcel2.writeNoException();
            } else if (i == 2) {
                int i3 = parcel.readInt();
                Bundle bundle = (Bundle) _Parcel.bBK_(parcel, Bundle.CREATOR);
                onDataChanged(i3, bundle);
                parcel2.writeNoException();
                _Parcel.bBL_(parcel2, bundle, 1);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class Proxy implements ISportDataCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f4208a;

            Proxy(IBinder iBinder) {
                this.f4208a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4208a;
            }

            @Override // com.huawei.hihealth.ISportDataCallback
            public void onResult(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISportDataCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.f4208a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hihealth.ISportDataCallback
            public void onDataChanged(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISportDataCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    _Parcel.bBL_(parcelObtain, bundle, 0);
                    this.f4208a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        bundle.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T bBK_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void bBL_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
