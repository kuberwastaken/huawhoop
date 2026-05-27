package com.huawei.wearengine.monitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface MonitorCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.monitor.MonitorCallback";

    /* JADX INFO: loaded from: classes11.dex */
    public static class Default implements MonitorCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.wearengine.monitor.MonitorCallback
        public void onChanged(int i, MonitorMessage monitorMessage) throws RemoteException {
        }
    }

    void onChanged(int i, MonitorMessage monitorMessage) throws RemoteException;

    public static abstract class Stub extends Binder implements MonitorCallback {
        static final int TRANSACTION_onChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, MonitorCallback.DESCRIPTOR);
        }

        public static MonitorCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(MonitorCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof MonitorCallback)) {
                return (MonitorCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(MonitorCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(MonitorCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                int i3 = parcel.readInt();
                MonitorMessage monitorMessage = (MonitorMessage) d.fBX_(parcel, MonitorMessage.CREATOR);
                onChanged(i3, monitorMessage);
                parcel2.writeNoException();
                d.fBY_(parcel2, monitorMessage, 1);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class Proxy implements MonitorCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.wearengine.monitor.MonitorCallback
            public void onChanged(int i, MonitorMessage monitorMessage) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(MonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    d.fBY_(parcelObtain, monitorMessage, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        monitorMessage.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return MonitorCallback.DESCRIPTOR;
            }
        }
    }

    public static class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fBX_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fBY_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
