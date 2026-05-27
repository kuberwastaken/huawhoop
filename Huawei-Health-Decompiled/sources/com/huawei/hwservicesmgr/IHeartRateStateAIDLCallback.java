package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes6.dex */
public interface IHeartRateStateAIDLCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hwservicesmgr.IHeartRateStateAIDLCallback";

    void heartRateResponse(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IHeartRateStateAIDLCallback {
        static final int TRANSACTION_heartRateResponse = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IHeartRateStateAIDLCallback.DESCRIPTOR);
        }

        public static IHeartRateStateAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IHeartRateStateAIDLCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IHeartRateStateAIDLCallback)) {
                return (IHeartRateStateAIDLCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IHeartRateStateAIDLCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IHeartRateStateAIDLCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                heartRateResponse(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class d implements IHeartRateStateAIDLCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6612a;

            d(IBinder iBinder) {
                this.f6612a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6612a;
            }

            @Override // com.huawei.hwservicesmgr.IHeartRateStateAIDLCallback
            public void heartRateResponse(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHeartRateStateAIDLCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.f6612a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
