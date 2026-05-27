package com.huawei.wearengine.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.wearengine.device.Device;

/* JADX INFO: loaded from: classes11.dex */
public interface UpgradeStatusBinderCallBack extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.ota.UpgradeStatusBinderCallBack";

    void onStatus(Device device, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements UpgradeStatusBinderCallBack {
        static final int TRANSACTION_onStatus = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, UpgradeStatusBinderCallBack.DESCRIPTOR);
        }

        public static UpgradeStatusBinderCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(UpgradeStatusBinderCallBack.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof UpgradeStatusBinderCallBack)) {
                return (UpgradeStatusBinderCallBack) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(UpgradeStatusBinderCallBack.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(UpgradeStatusBinderCallBack.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            Device device = (Device) b.fCJ_(parcel, Device.CREATOR);
            onStatus(device, parcel.readString());
            parcel2.writeNoException();
            b.fCK_(parcel2, device, 1);
            return true;
        }

        static class a implements UpgradeStatusBinderCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f11760a;

            a(IBinder iBinder) {
                this.f11760a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11760a;
            }

            @Override // com.huawei.wearengine.ota.UpgradeStatusBinderCallBack
            public void onStatus(Device device, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(UpgradeStatusBinderCallBack.DESCRIPTOR);
                    b.fCK_(parcelObtain, device, 0);
                    parcelObtain.writeString(str);
                    this.f11760a.transact(1, parcelObtain, parcelObtain2, 0);
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

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fCJ_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fCK_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
