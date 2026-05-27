package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.hihealth.model.Notification;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ISubScribeCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hihealth.ISubScribeCallback";

    public static class Default implements ISubScribeCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hihealth.ISubScribeCallback
        public void onDataChanged(Notification notification) throws RemoteException {
        }

        @Override // com.huawei.hihealth.ISubScribeCallback
        public void onResult(List<Notification> list, List<Notification> list2) throws RemoteException {
        }
    }

    void onDataChanged(Notification notification) throws RemoteException;

    void onResult(List<Notification> list, List<Notification> list2) throws RemoteException;

    public static abstract class Stub extends Binder implements ISubScribeCallback {
        static final int TRANSACTION_onDataChanged = 2;
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISubScribeCallback.DESCRIPTOR);
        }

        public static ISubScribeCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISubScribeCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISubScribeCallback)) {
                return (ISubScribeCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISubScribeCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISubScribeCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResult(parcel.createTypedArrayList(Notification.CREATOR), parcel.createTypedArrayList(Notification.CREATOR));
                parcel2.writeNoException();
            } else if (i == 2) {
                onDataChanged((Notification) _Parcel.bBP_(parcel, Notification.CREATOR));
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class Proxy implements ISubScribeCallback {
            private IBinder e;

            Proxy(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.hihealth.ISubScribeCallback
            public void onResult(List<Notification> list, List<Notification> list2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISubScribeCallback.DESCRIPTOR);
                    _Parcel.bBQ_(parcelObtain, list, 0);
                    _Parcel.bBQ_(parcelObtain, list2, 0);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hihealth.ISubScribeCallback
            public void onDataChanged(Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISubScribeCallback.DESCRIPTOR);
                    _Parcel.bBR_(parcelObtain, notification, 0);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T bBP_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void bBR_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void bBQ_(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                bBR_(parcel, list.get(i2), i);
            }
        }
    }
}
