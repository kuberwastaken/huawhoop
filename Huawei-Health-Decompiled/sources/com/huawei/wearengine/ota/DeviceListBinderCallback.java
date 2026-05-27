package com.huawei.wearengine.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.wearengine.device.Device;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface DeviceListBinderCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.ota.DeviceListBinderCallback";

    void onDeviceListObtain(List<Device> list) throws RemoteException;

    public static abstract class Stub extends Binder implements DeviceListBinderCallback {
        static final int TRANSACTION_onDeviceListObtain = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DeviceListBinderCallback.DESCRIPTOR);
        }

        public static DeviceListBinderCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DeviceListBinderCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof DeviceListBinderCallback)) {
                return (DeviceListBinderCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(DeviceListBinderCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(DeviceListBinderCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Device.CREATOR);
                onDeviceListObtain(arrayListCreateTypedArrayList);
                parcel2.writeNoException();
                d.fCB_(parcel2, arrayListCreateTypedArrayList, 1);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class d implements DeviceListBinderCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f11759a;

            d(IBinder iBinder) {
                this.f11759a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11759a;
            }

            @Override // com.huawei.wearengine.ota.DeviceListBinderCallback
            public void onDeviceListObtain(List<Device> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DeviceListBinderCallback.DESCRIPTOR);
                    d.fCB_(parcelObtain, list, 0);
                    this.f11759a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.readTypedList(list, Device.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class d {
        private static <T extends Parcelable> void fCC_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fCB_(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                fCC_(parcel, list.get(i2), i);
            }
        }
    }
}
