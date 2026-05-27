package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ISendDataCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hihealth.ISendDataCallback";

    public static class Default implements ISendDataCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hihealth.ISendDataCallback
        public void onFinish(int i, String str) throws RemoteException {
        }

        @Override // com.huawei.hihealth.ISendDataCallback
        public void onSend(int i, String str, long j) throws RemoteException {
        }
    }

    void onFinish(int i, String str) throws RemoteException;

    void onSend(int i, String str, long j) throws RemoteException;

    public static abstract class Stub extends Binder implements ISendDataCallback {
        static final int TRANSACTION_onFinish = 2;
        static final int TRANSACTION_onSend = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISendDataCallback.DESCRIPTOR);
        }

        public static ISendDataCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISendDataCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISendDataCallback)) {
                return (ISendDataCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISendDataCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISendDataCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSend(parcel.readInt(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
            } else if (i == 2) {
                onFinish(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class Proxy implements ISendDataCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f4207a;

            Proxy(IBinder iBinder) {
                this.f4207a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4207a;
            }

            @Override // com.huawei.hihealth.ISendDataCallback
            public void onSend(int i, String str, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISendDataCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    this.f4207a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hihealth.ISendDataCallback
            public void onFinish(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISendDataCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.f4207a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
