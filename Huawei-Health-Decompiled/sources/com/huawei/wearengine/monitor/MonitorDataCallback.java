package com.huawei.wearengine.monitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface MonitorDataCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.monitor.MonitorDataCallback";

    /* JADX INFO: loaded from: classes11.dex */
    public static class Default implements MonitorDataCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.wearengine.monitor.MonitorDataCallback
        public void onChanged(int i, MonitorItem monitorItem, MonitorData monitorData) throws RemoteException {
        }
    }

    void onChanged(int i, MonitorItem monitorItem, MonitorData monitorData) throws RemoteException;

    public static abstract class Stub extends Binder implements MonitorDataCallback {
        static final int TRANSACTION_onChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, MonitorDataCallback.DESCRIPTOR);
        }

        public static MonitorDataCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(MonitorDataCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof MonitorDataCallback)) {
                return (MonitorDataCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(MonitorDataCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(MonitorDataCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                int i3 = parcel.readInt();
                MonitorItem monitorItem = (MonitorItem) a.fCc_(parcel, MonitorItem.CREATOR);
                MonitorData monitorData = (MonitorData) a.fCc_(parcel, MonitorData.CREATOR);
                onChanged(i3, monitorItem, monitorData);
                parcel2.writeNoException();
                a.fCd_(parcel2, monitorItem, 1);
                a.fCd_(parcel2, monitorData, 1);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class Proxy implements MonitorDataCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.wearengine.monitor.MonitorDataCallback
            public void onChanged(int i, MonitorItem monitorItem, MonitorData monitorData) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(MonitorDataCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    a.fCd_(parcelObtain, monitorItem, 0);
                    a.fCd_(parcelObtain, monitorData, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        monitorItem.readFromParcel(parcelObtain2);
                    }
                    if (parcelObtain2.readInt() != 0) {
                        monitorData.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return MonitorDataCallback.DESCRIPTOR;
            }
        }
    }

    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fCc_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fCd_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
