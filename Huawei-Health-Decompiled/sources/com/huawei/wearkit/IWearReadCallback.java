package com.huawei.wearkit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes9.dex */
public interface IWearReadCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearkit.IWearReadCallback";

    void onResult(int i, String str, byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IWearReadCallback {
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IWearReadCallback.DESCRIPTOR);
        }

        public static IWearReadCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWearReadCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IWearReadCallback)) {
                return (IWearReadCallback) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWearReadCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IWearReadCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                int i3 = parcel.readInt();
                String string = parcel.readString();
                int i4 = parcel.readInt();
                byte[] bArr = i4 < 0 ? null : new byte[i4];
                onResult(i3, string, bArr);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArr);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class a implements IWearReadCallback {
            private IBinder e;

            a(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.wearkit.IWearReadCallback
            public void onResult(int i, String str, byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearReadCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(bArr.length);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.readByteArray(bArr);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
