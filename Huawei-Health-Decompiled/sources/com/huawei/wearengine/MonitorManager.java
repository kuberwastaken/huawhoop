package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.monitor.MonitorData;
import com.huawei.wearengine.monitor.MonitorDataCallback;
import com.huawei.wearengine.monitor.MonitorItem;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface MonitorManager extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.MonitorManager";

    MonitorData query(Device device, MonitorItem monitorItem) throws RemoteException;

    int registerListListener(Device device, String str, List<MonitorItem> list, MonitorDataCallback monitorDataCallback, int i) throws RemoteException;

    int registerListener(Device device, String str, MonitorItem monitorItem, MonitorDataCallback monitorDataCallback, int i) throws RemoteException;

    int unregisterListener(MonitorDataCallback monitorDataCallback, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements MonitorManager {
        static final int TRANSACTION_query = 4;
        static final int TRANSACTION_registerListListener = 2;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_unregisterListener = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, MonitorManager.DESCRIPTOR);
        }

        public static MonitorManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(MonitorManager.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof MonitorManager)) {
                return (MonitorManager) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(MonitorManager.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(MonitorManager.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                int iRegisterListener = registerListener((Device) c.fBb_(parcel, Device.CREATOR), parcel.readString(), (MonitorItem) c.fBb_(parcel, MonitorItem.CREATOR), MonitorDataCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(iRegisterListener);
            } else if (i == 2) {
                int iRegisterListListener = registerListListener((Device) c.fBb_(parcel, Device.CREATOR), parcel.readString(), parcel.createTypedArrayList(MonitorItem.CREATOR), MonitorDataCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(iRegisterListListener);
            } else if (i == 3) {
                int iUnregisterListener = unregisterListener(MonitorDataCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(iUnregisterListener);
            } else if (i == 4) {
                MonitorData monitorDataQuery = query((Device) c.fBb_(parcel, Device.CREATOR), (MonitorItem) c.fBb_(parcel, MonitorItem.CREATOR));
                parcel2.writeNoException();
                c.fBd_(parcel2, monitorDataQuery, 1);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class a implements MonitorManager {
            private IBinder d;

            a(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.wearengine.MonitorManager
            public int registerListener(Device device, String str, MonitorItem monitorItem, MonitorDataCallback monitorDataCallback, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(MonitorManager.DESCRIPTOR);
                    c.fBd_(parcelObtain, device, 0);
                    parcelObtain.writeString(str);
                    c.fBd_(parcelObtain, monitorItem, 0);
                    parcelObtain.writeStrongInterface(monitorDataCallback);
                    parcelObtain.writeInt(i);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.MonitorManager
            public int registerListListener(Device device, String str, List<MonitorItem> list, MonitorDataCallback monitorDataCallback, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(MonitorManager.DESCRIPTOR);
                    c.fBd_(parcelObtain, device, 0);
                    parcelObtain.writeString(str);
                    c.fBc_(parcelObtain, list, 0);
                    parcelObtain.writeStrongInterface(monitorDataCallback);
                    parcelObtain.writeInt(i);
                    this.d.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.MonitorManager
            public int unregisterListener(MonitorDataCallback monitorDataCallback, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(MonitorManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(monitorDataCallback);
                    parcelObtain.writeInt(i);
                    this.d.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.MonitorManager
            public MonitorData query(Device device, MonitorItem monitorItem) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(MonitorManager.DESCRIPTOR);
                    c.fBd_(parcelObtain, device, 0);
                    c.fBd_(parcelObtain, monitorItem, 0);
                    this.d.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (MonitorData) c.fBb_(parcelObtain2, MonitorData.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fBb_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fBd_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fBc_(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                fBd_(parcel, list.get(i2), i);
            }
        }
    }
}
