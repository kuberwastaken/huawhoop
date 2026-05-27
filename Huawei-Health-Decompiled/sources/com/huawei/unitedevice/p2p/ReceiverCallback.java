package com.huawei.unitedevice.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.devicesdk.entity.DeviceInfo;

/* JADX INFO: loaded from: classes8.dex */
public interface ReceiverCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.unitedevice.p2p.ReceiverCallback";

    void onReceiveMessage(DeviceInfo deviceInfo, MessageParcel messageParcel) throws RemoteException;

    public static abstract class Stub extends Binder implements ReceiverCallback {
        static final int TRANSACTION_onReceiveMessage = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ReceiverCallback.DESCRIPTOR);
        }

        public static ReceiverCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ReceiverCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ReceiverCallback)) {
                return (ReceiverCallback) iInterfaceQueryLocalInterface;
            }
            return new e(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ReceiverCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ReceiverCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            DeviceInfo deviceInfo = (DeviceInfo) b.eIc_(parcel, DeviceInfo.CREATOR);
            MessageParcel messageParcel = (MessageParcel) b.eIc_(parcel, MessageParcel.CREATOR);
            onReceiveMessage(deviceInfo, messageParcel);
            parcel2.writeNoException();
            b.eId_(parcel2, deviceInfo, 1);
            b.eId_(parcel2, messageParcel, 1);
            return true;
        }

        static class e implements ReceiverCallback {
            private IBinder c;

            e(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.unitedevice.p2p.ReceiverCallback
            public void onReceiveMessage(DeviceInfo deviceInfo, MessageParcel messageParcel) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ReceiverCallback.DESCRIPTOR);
                    b.eId_(parcelObtain, deviceInfo, 0);
                    b.eId_(parcelObtain, messageParcel, 0);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        deviceInfo.readFromParcel(parcelObtain2);
                    }
                    if (parcelObtain2.readInt() != 0) {
                        messageParcel.readFromParcel(parcelObtain2);
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
        public static <T> T eIc_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void eId_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
