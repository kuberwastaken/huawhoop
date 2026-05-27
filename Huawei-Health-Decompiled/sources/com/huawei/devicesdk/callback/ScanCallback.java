package com.huawei.devicesdk.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.unitedevice.entity.UniteDevice;

/* JADX INFO: loaded from: classes3.dex */
public interface ScanCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.devicesdk.callback.ScanCallback";

    void onScanResult(int i, UniteDevice uniteDevice, byte[] bArr, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements ScanCallback {
        static final int TRANSACTION_onScanResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ScanCallback.DESCRIPTOR);
        }

        public static ScanCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ScanCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ScanCallback)) {
                return (ScanCallback) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ScanCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ScanCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onScanResult(parcel.readInt(), (UniteDevice) d.sN_(parcel, UniteDevice.CREATOR), parcel.createByteArray(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class a implements ScanCallback {
            private IBinder c;

            a(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.devicesdk.callback.ScanCallback
            public void onScanResult(int i, UniteDevice uniteDevice, byte[] bArr, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ScanCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    d.sO_(parcelObtain, uniteDevice, 0);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeString(str);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
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
        public static <T> T sN_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void sO_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
