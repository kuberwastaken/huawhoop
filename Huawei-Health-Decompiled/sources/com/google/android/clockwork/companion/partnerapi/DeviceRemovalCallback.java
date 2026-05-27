package com.google.android.clockwork.companion.partnerapi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface DeviceRemovalCallback extends IInterface {
    public static final String DESCRIPTOR = "com.google.android.clockwork.companion.partnerapi.DeviceRemovalCallback";

    void onDeviceRemovalFailed(String str, int i) throws RemoteException;

    void onDeviceRemovalSucceeded(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements DeviceRemovalCallback {
        static final int TRANSACTION_onDeviceRemovalFailed = 2;
        static final int TRANSACTION_onDeviceRemovalSucceeded = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DeviceRemovalCallback.DESCRIPTOR);
        }

        public static DeviceRemovalCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DeviceRemovalCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof DeviceRemovalCallback)) {
                return (DeviceRemovalCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(DeviceRemovalCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(DeviceRemovalCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onDeviceRemovalSucceeded(parcel.readString());
            } else if (i == 2) {
                onDeviceRemovalFailed(parcel.readString(), parcel.readInt());
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class d implements DeviceRemovalCallback {
            private IBinder b;

            d(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.google.android.clockwork.companion.partnerapi.DeviceRemovalCallback
            public void onDeviceRemovalSucceeded(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DeviceRemovalCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.b.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.clockwork.companion.partnerapi.DeviceRemovalCallback
            public void onDeviceRemovalFailed(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DeviceRemovalCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.b.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
