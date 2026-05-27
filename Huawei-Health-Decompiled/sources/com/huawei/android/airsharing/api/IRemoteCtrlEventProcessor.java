package com.huawei.android.airsharing.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IRemoteCtrlEventProcessor extends IInterface {
    int process(int i, int i2, byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteCtrlEventProcessor {
        private static final String DESCRIPTOR = "com.huawei.android.airsharing.api.IRemoteCtrlEventProcessor";
        static final int TRANSACTION_process = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteCtrlEventProcessor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteCtrlEventProcessor)) {
                return (IRemoteCtrlEventProcessor) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
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
            int iProcess = process(parcel.readInt(), parcel.readInt(), parcel.createByteArray());
            parcel2.writeNoException();
            parcel2.writeInt(iProcess);
            return true;
        }

        static class c implements IRemoteCtrlEventProcessor {
            public static IRemoteCtrlEventProcessor d;
            private IBinder e;

            c(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.android.airsharing.api.IRemoteCtrlEventProcessor
            public int process(int i, int i2, byte[] bArr) throws RemoteException {
                int iProcess;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeByteArray(bArr);
                    if (!this.e.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        iProcess = Stub.getDefaultImpl().process(i, i2, bArr);
                    } else {
                        parcelObtain2.readException();
                        iProcess = parcelObtain2.readInt();
                    }
                    return iProcess;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemoteCtrlEventProcessor iRemoteCtrlEventProcessor) {
            if (c.d != null || iRemoteCtrlEventProcessor == null) {
                return false;
            }
            c.d = iRemoteCtrlEventProcessor;
            return true;
        }

        public static IRemoteCtrlEventProcessor getDefaultImpl() {
            return c.d;
        }
    }
}
