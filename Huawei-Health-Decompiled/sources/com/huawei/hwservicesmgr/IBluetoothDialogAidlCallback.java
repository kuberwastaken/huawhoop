package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.hwbtsdk.btdatatype.datatype.BluetoothDeviceNode;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface IBluetoothDialogAidlCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hwservicesmgr.IBluetoothDialogAidlCallback";

    void onScanFinished() throws RemoteException;

    void onSetList(List<BluetoothDeviceNode> list, boolean z, int i) throws RemoteException;

    void onSetNameFilter(List<String> list) throws RemoteException;

    public static abstract class Stub extends Binder implements IBluetoothDialogAidlCallback {
        static final int TRANSACTION_onScanFinished = 2;
        static final int TRANSACTION_onSetList = 1;
        static final int TRANSACTION_onSetNameFilter = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IBluetoothDialogAidlCallback.DESCRIPTOR);
        }

        public static IBluetoothDialogAidlCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IBluetoothDialogAidlCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IBluetoothDialogAidlCallback)) {
                return (IBluetoothDialogAidlCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IBluetoothDialogAidlCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IBluetoothDialogAidlCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSetList(parcel.createTypedArrayList(BluetoothDeviceNode.CREATOR), parcel.readInt() != 0, parcel.readInt());
                parcel2.writeNoException();
            } else if (i == 2) {
                onScanFinished();
                parcel2.writeNoException();
            } else if (i == 3) {
                onSetNameFilter(parcel.createStringArrayList());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class d implements IBluetoothDialogAidlCallback {
            private IBinder c;

            d(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.hwservicesmgr.IBluetoothDialogAidlCallback
            public void onSetList(List<BluetoothDeviceNode> list, boolean z, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBluetoothDialogAidlCallback.DESCRIPTOR);
                    a.bYM_(parcelObtain, list, 0);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(i);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.IBluetoothDialogAidlCallback
            public void onScanFinished() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBluetoothDialogAidlCallback.DESCRIPTOR);
                    this.c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.IBluetoothDialogAidlCallback
            public void onSetNameFilter(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBluetoothDialogAidlCallback.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    this.c.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class a {
        private static <T extends Parcelable> void bYN_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void bYM_(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                bYN_(parcel, list.get(i2), i);
            }
        }
    }
}
