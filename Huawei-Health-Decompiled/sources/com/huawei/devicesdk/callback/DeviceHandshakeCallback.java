package com.huawei.devicesdk.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.devicesdk.entity.CommandMessageParcel;
import com.huawei.unitedevice.entity.UniteDevice;

/* JADX INFO: loaded from: classes3.dex */
public interface DeviceHandshakeCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.devicesdk.callback.DeviceHandshakeCallback";

    int onProcess(UniteDevice uniteDevice, String str, CommandMessageParcel commandMessageParcel) throws RemoteException;

    String preProcess(UniteDevice uniteDevice, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements DeviceHandshakeCallback {
        static final int TRANSACTION_onProcess = 1;
        static final int TRANSACTION_preProcess = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DeviceHandshakeCallback.DESCRIPTOR);
        }

        public static DeviceHandshakeCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DeviceHandshakeCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof DeviceHandshakeCallback)) {
                return (DeviceHandshakeCallback) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(DeviceHandshakeCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(DeviceHandshakeCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                UniteDevice uniteDevice = (UniteDevice) a.sF_(parcel, UniteDevice.CREATOR);
                String string = parcel.readString();
                CommandMessageParcel commandMessageParcel = (CommandMessageParcel) a.sF_(parcel, CommandMessageParcel.CREATOR);
                int iOnProcess = onProcess(uniteDevice, string, commandMessageParcel);
                parcel2.writeNoException();
                parcel2.writeInt(iOnProcess);
                a.sG_(parcel2, commandMessageParcel, 1);
            } else if (i == 2) {
                String strPreProcess = preProcess((UniteDevice) a.sF_(parcel, UniteDevice.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strPreProcess);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class a implements DeviceHandshakeCallback {
            private IBinder e;

            a(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.devicesdk.callback.DeviceHandshakeCallback
            public int onProcess(UniteDevice uniteDevice, String str, CommandMessageParcel commandMessageParcel) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DeviceHandshakeCallback.DESCRIPTOR);
                    a.sG_(parcelObtain, uniteDevice, 0);
                    parcelObtain.writeString(str);
                    a.sG_(parcelObtain, commandMessageParcel, 0);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i = parcelObtain2.readInt();
                    if (parcelObtain2.readInt() != 0) {
                        commandMessageParcel.readFromParcel(parcelObtain2);
                    }
                    return i;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.devicesdk.callback.DeviceHandshakeCallback
            public String preProcess(UniteDevice uniteDevice, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DeviceHandshakeCallback.DESCRIPTOR);
                    a.sG_(parcelObtain, uniteDevice, 0);
                    parcelObtain.writeString(str);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T sF_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void sG_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
