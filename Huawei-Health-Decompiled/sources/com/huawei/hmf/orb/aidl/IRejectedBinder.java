package com.huawei.hmf.orb.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public interface IRejectedBinder extends IInterface {

    public static class Default implements IRejectedBinder {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hmf.orb.aidl.IRejectedBinder
        public int getCode() throws RemoteException {
            return 0;
        }
    }

    int getCode() throws RemoteException;

    public static abstract class Stub extends Binder implements IRejectedBinder {
        private static final String DESCRIPTOR = "com.huawei.hmf.orb.aidl.IRejectedBinder";
        static final int TRANSACTION_getCode = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRejectedBinder asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRejectedBinder)) {
                return (IRejectedBinder) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            int code = getCode();
            parcel2.writeNoException();
            parcel2.writeInt(code);
            return true;
        }

        static class Proxy implements IRejectedBinder {
            public static IRejectedBinder sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hmf.orb.aidl.IRejectedBinder
            public int getCode() throws RemoteException {
                int code;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        code = Stub.getDefaultImpl().getCode();
                    } else {
                        parcelObtain2.readException();
                        code = parcelObtain2.readInt();
                    }
                    return code;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public static boolean setDefaultImpl(IRejectedBinder iRejectedBinder) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRejectedBinder == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRejectedBinder;
            return true;
        }

        public static IRejectedBinder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
