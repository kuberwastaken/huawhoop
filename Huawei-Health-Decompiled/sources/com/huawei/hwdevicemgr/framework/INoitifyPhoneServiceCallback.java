package com.huawei.hwdevicemgr.framework;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.health.devicemgr.business.entity.DeviceInfo;

/* JADX INFO: loaded from: classes6.dex */
public interface INoitifyPhoneServiceCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hwdevicemgr.framework.INoitifyPhoneServiceCallback";

    void executeResponse(String str, int i, DeviceInfo deviceInfo, int i2, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements INoitifyPhoneServiceCallback {
        static final int TRANSACTION_executeResponse = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, INoitifyPhoneServiceCallback.DESCRIPTOR);
        }

        public static INoitifyPhoneServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(INoitifyPhoneServiceCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof INoitifyPhoneServiceCallback)) {
                return (INoitifyPhoneServiceCallback) iInterfaceQueryLocalInterface;
            }
            return new e(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(INoitifyPhoneServiceCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(INoitifyPhoneServiceCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                executeResponse(parcel.readString(), parcel.readInt(), (DeviceInfo) e.bWm_(parcel, DeviceInfo.CREATOR), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class e implements INoitifyPhoneServiceCallback {
            private IBinder d;

            e(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.hwdevicemgr.framework.INoitifyPhoneServiceCallback
            public void executeResponse(String str, int i, DeviceInfo deviceInfo, int i2, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INoitifyPhoneServiceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    e.bWn_(parcelObtain, deviceInfo, 0);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str2);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T bWm_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void bWn_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
