package com.huawei.wearengine.notify;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface NotifyHanrmonyCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.notify.NotifyHanrmonyCallback";

    void onError(NotificationHarmony notificationHarmony, int i) throws RemoteException;

    void onResult(NotificationHarmony notificationHarmony, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements NotifyHanrmonyCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, NotifyHanrmonyCallback.DESCRIPTOR);
        }

        public static NotifyHanrmonyCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(NotifyHanrmonyCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof NotifyHanrmonyCallback)) {
                return (NotifyHanrmonyCallback) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(NotifyHanrmonyCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(NotifyHanrmonyCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                NotificationHarmony notificationHarmony = (NotificationHarmony) e.fCp_(parcel, NotificationHarmony.CREATOR);
                onResult(notificationHarmony, parcel.readInt());
                parcel2.writeNoException();
                e.fCq_(parcel2, notificationHarmony, 1);
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                NotificationHarmony notificationHarmony2 = (NotificationHarmony) e.fCp_(parcel, NotificationHarmony.CREATOR);
                onError(notificationHarmony2, parcel.readInt());
                parcel2.writeNoException();
                e.fCq_(parcel2, notificationHarmony2, 1);
            }
            return true;
        }

        static class c implements NotifyHanrmonyCallback {
            private IBinder b;

            c(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.huawei.wearengine.notify.NotifyHanrmonyCallback
            public void onResult(NotificationHarmony notificationHarmony, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(NotifyHanrmonyCallback.DESCRIPTOR);
                    e.fCq_(parcelObtain, notificationHarmony, 0);
                    parcelObtain.writeInt(i);
                    this.b.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        notificationHarmony.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.notify.NotifyHanrmonyCallback
            public void onError(NotificationHarmony notificationHarmony, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(NotifyHanrmonyCallback.DESCRIPTOR);
                    e.fCq_(parcelObtain, notificationHarmony, 0);
                    parcelObtain.writeInt(i);
                    this.b.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        notificationHarmony.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fCp_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fCq_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
