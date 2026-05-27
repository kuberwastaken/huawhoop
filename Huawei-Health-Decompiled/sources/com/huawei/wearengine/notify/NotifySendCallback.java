package com.huawei.wearengine.notify;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface NotifySendCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.notify.NotifySendCallback";

    /* JADX INFO: loaded from: classes11.dex */
    public static class Default implements NotifySendCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.wearengine.notify.NotifySendCallback
        public void onError(NotificationParcel notificationParcel, int i) throws RemoteException {
        }

        @Override // com.huawei.wearengine.notify.NotifySendCallback
        public void onResult(NotificationParcel notificationParcel, int i) throws RemoteException {
        }
    }

    void onError(NotificationParcel notificationParcel, int i) throws RemoteException;

    void onResult(NotificationParcel notificationParcel, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements NotifySendCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, NotifySendCallback.DESCRIPTOR);
        }

        public static NotifySendCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(NotifySendCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof NotifySendCallback)) {
                return (NotifySendCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(NotifySendCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(NotifySendCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                NotificationParcel notificationParcel = (NotificationParcel) b.fCt_(parcel, NotificationParcel.CREATOR);
                onResult(notificationParcel, parcel.readInt());
                parcel2.writeNoException();
                b.fCu_(parcel2, notificationParcel, 1);
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                NotificationParcel notificationParcel2 = (NotificationParcel) b.fCt_(parcel, NotificationParcel.CREATOR);
                onError(notificationParcel2, parcel.readInt());
                parcel2.writeNoException();
                b.fCu_(parcel2, notificationParcel2, 1);
            }
            return true;
        }

        static class Proxy implements NotifySendCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.wearengine.notify.NotifySendCallback
            public void onResult(NotificationParcel notificationParcel, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(NotifySendCallback.DESCRIPTOR);
                    b.fCu_(parcelObtain, notificationParcel, 0);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        notificationParcel.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.notify.NotifySendCallback
            public void onError(NotificationParcel notificationParcel, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(NotifySendCallback.DESCRIPTOR);
                    b.fCu_(parcelObtain, notificationParcel, 0);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        notificationParcel.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return NotifySendCallback.DESCRIPTOR;
            }
        }
    }

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fCt_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fCu_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
