package com.huawei.wearengine.device;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface FoundListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.device.FoundListener";

    /* JADX INFO: loaded from: classes11.dex */
    public static class Default implements FoundListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.wearengine.device.FoundListener
        public void onDeviceFound(List<Device> list) throws RemoteException {
        }
    }

    void onDeviceFound(List<Device> list) throws RemoteException;

    public static abstract class Stub extends Binder implements FoundListener {
        static final int TRANSACTION_onDeviceFound = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, FoundListener.DESCRIPTOR);
        }

        public static FoundListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(FoundListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof FoundListener)) {
                return (FoundListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(FoundListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(FoundListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Device.CREATOR);
                onDeviceFound(arrayListCreateTypedArrayList);
                parcel2.writeNoException();
                b.fBP_(parcel2, arrayListCreateTypedArrayList, 1);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class Proxy implements FoundListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.wearengine.device.FoundListener
            public void onDeviceFound(List<Device> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(FoundListener.DESCRIPTOR);
                    b.fBP_(parcelObtain, list, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.readTypedList(list, Device.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return FoundListener.DESCRIPTOR;
            }
        }
    }

    public static class b {
        private static <T extends Parcelable> void fBQ_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fBP_(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                fBQ_(parcel, list.get(i2), i);
            }
        }
    }
}
