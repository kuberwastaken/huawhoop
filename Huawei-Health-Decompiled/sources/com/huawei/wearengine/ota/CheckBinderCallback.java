package com.huawei.wearengine.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.wearengine.device.Device;

/* JADX INFO: loaded from: classes11.dex */
public interface CheckBinderCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.ota.CheckBinderCallback";

    void onCheckComplete(Device device, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements CheckBinderCallback {
        static final int TRANSACTION_onCheckComplete = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, CheckBinderCallback.DESCRIPTOR);
        }

        public static CheckBinderCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(CheckBinderCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof CheckBinderCallback)) {
                return (CheckBinderCallback) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(CheckBinderCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(CheckBinderCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            Device device = (Device) e.fCy_(parcel, Device.CREATOR);
            onCheckComplete(device, parcel.readString());
            parcel2.writeNoException();
            e.fCz_(parcel2, device, 1);
            return true;
        }

        static class c implements CheckBinderCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f11758a;

            c(IBinder iBinder) {
                this.f11758a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11758a;
            }

            @Override // com.huawei.wearengine.ota.CheckBinderCallback
            public void onCheckComplete(Device device, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(CheckBinderCallback.DESCRIPTOR);
                    e.fCz_(parcelObtain, device, 0);
                    parcelObtain.writeString(str);
                    this.f11758a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        device.readFromParcel(parcelObtain2);
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
        public static <T> T fCy_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fCz_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
