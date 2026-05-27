package com.huawei.devicesdk.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.devicesdk.entity.DeviceDataFrameParcel;
import com.huawei.unitedevice.entity.UniteDevice;

/* JADX INFO: loaded from: classes3.dex */
public interface FrameReceiver extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.devicesdk.callback.FrameReceiver";

    void onChannelResult(int i, UniteDevice uniteDevice, String str) throws RemoteException;

    void onFrameReceived(int i, UniteDevice uniteDevice, DeviceDataFrameParcel deviceDataFrameParcel) throws RemoteException;

    public static abstract class Stub extends Binder implements FrameReceiver {
        static final int TRANSACTION_onChannelResult = 2;
        static final int TRANSACTION_onFrameReceived = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, FrameReceiver.DESCRIPTOR);
        }

        public static FrameReceiver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(FrameReceiver.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof FrameReceiver)) {
                return (FrameReceiver) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(FrameReceiver.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(FrameReceiver.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onFrameReceived(parcel.readInt(), (UniteDevice) d.sJ_(parcel, UniteDevice.CREATOR), (DeviceDataFrameParcel) d.sJ_(parcel, DeviceDataFrameParcel.CREATOR));
                parcel2.writeNoException();
            } else if (i == 2) {
                onChannelResult(parcel.readInt(), (UniteDevice) d.sJ_(parcel, UniteDevice.CREATOR), parcel.readString());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class d implements FrameReceiver {
            private IBinder e;

            d(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.devicesdk.callback.FrameReceiver
            public void onFrameReceived(int i, UniteDevice uniteDevice, DeviceDataFrameParcel deviceDataFrameParcel) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(FrameReceiver.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    d.sK_(parcelObtain, uniteDevice, 0);
                    d.sK_(parcelObtain, deviceDataFrameParcel, 0);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.devicesdk.callback.FrameReceiver
            public void onChannelResult(int i, UniteDevice uniteDevice, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(FrameReceiver.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    d.sK_(parcelObtain, uniteDevice, 0);
                    parcelObtain.writeString(str);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T sJ_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void sK_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
