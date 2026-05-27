package com.huawei.unitedevice.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface P2pSendCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.unitedevice.p2p.P2pSendCallback";

    void onFileTransferReport(String str) throws RemoteException;

    void onSendProgress(long j) throws RemoteException;

    void onSendResult(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements P2pSendCallback {
        static final int TRANSACTION_onFileTransferReport = 3;
        static final int TRANSACTION_onSendProgress = 2;
        static final int TRANSACTION_onSendResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, P2pSendCallback.DESCRIPTOR);
        }

        public static P2pSendCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(P2pSendCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof P2pSendCallback)) {
                return (P2pSendCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(P2pSendCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(P2pSendCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSendResult(parcel.readInt());
                parcel2.writeNoException();
            } else if (i == 2) {
                onSendProgress(parcel.readLong());
                parcel2.writeNoException();
            } else if (i == 3) {
                onFileTransferReport(parcel.readString());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class d implements P2pSendCallback {
            private IBinder e;

            d(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.unitedevice.p2p.P2pSendCallback
            public void onSendResult(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(P2pSendCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.unitedevice.p2p.P2pSendCallback
            public void onSendProgress(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(P2pSendCallback.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.unitedevice.p2p.P2pSendCallback
            public void onFileTransferReport(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(P2pSendCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.e.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
