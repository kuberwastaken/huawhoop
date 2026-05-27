package com.huawei.wearengine.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface P2pCancelFileTransferCallBack extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.p2p.P2pCancelFileTransferCallBack";

    /* JADX INFO: loaded from: classes11.dex */
    public static class Default implements P2pCancelFileTransferCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.wearengine.p2p.P2pCancelFileTransferCallBack
        public void onCancelFileTransferResult(int i, String str) throws RemoteException {
        }
    }

    void onCancelFileTransferResult(int i, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements P2pCancelFileTransferCallBack {
        static final int TRANSACTION_onCancelFileTransferResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, P2pCancelFileTransferCallBack.DESCRIPTOR);
        }

        public static P2pCancelFileTransferCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(P2pCancelFileTransferCallBack.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof P2pCancelFileTransferCallBack)) {
                return (P2pCancelFileTransferCallBack) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(P2pCancelFileTransferCallBack.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(P2pCancelFileTransferCallBack.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onCancelFileTransferResult(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class Proxy implements P2pCancelFileTransferCallBack {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.wearengine.p2p.P2pCancelFileTransferCallBack
            public void onCancelFileTransferResult(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(P2pCancelFileTransferCallBack.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return P2pCancelFileTransferCallBack.DESCRIPTOR;
            }
        }
    }
}
