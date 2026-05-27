package com.huawei.wearengine.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes11.dex */
public interface ReceiverCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.p2p.ReceiverCallback";

    public static class Default implements ReceiverCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.wearengine.p2p.ReceiverCallback
        public void onReceiveFileMessage(MessageParcel messageParcel) throws RemoteException {
        }

        @Override // com.huawei.wearengine.p2p.ReceiverCallback
        public void onReceiveMessage(byte[] bArr) throws RemoteException {
        }
    }

    void onReceiveFileMessage(MessageParcel messageParcel) throws RemoteException;

    void onReceiveMessage(byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements ReceiverCallback {
        static final int TRANSACTION_onReceiveFileMessage = 2;
        static final int TRANSACTION_onReceiveMessage = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ReceiverCallback.DESCRIPTOR);
        }

        public static ReceiverCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ReceiverCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ReceiverCallback)) {
                return (ReceiverCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ReceiverCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ReceiverCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                byte[] bArrCreateByteArray = parcel.createByteArray();
                onReceiveMessage(bArrCreateByteArray);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrCreateByteArray);
            } else if (i == 2) {
                onReceiveFileMessage((MessageParcel) b.fCW_(parcel, MessageParcel.CREATOR));
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class Proxy implements ReceiverCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.wearengine.p2p.ReceiverCallback
            public void onReceiveMessage(byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ReceiverCallback.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.readByteArray(bArr);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.p2p.ReceiverCallback
            public void onReceiveFileMessage(MessageParcel messageParcel) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ReceiverCallback.DESCRIPTOR);
                    b.fCX_(parcelObtain, messageParcel, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ReceiverCallback.DESCRIPTOR;
            }
        }
    }

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fCW_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fCX_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
