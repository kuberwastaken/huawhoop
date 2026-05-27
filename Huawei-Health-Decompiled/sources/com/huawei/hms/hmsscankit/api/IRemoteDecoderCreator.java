package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;

/* JADX INFO: loaded from: classes10.dex */
public interface IRemoteDecoderCreator extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator";

    public static class Default implements IRemoteDecoderCreator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator
        public IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException {
            return null;
        }
    }

    IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteDecoderCreator {
        static final int TRANSACTION_newRemoteFrameDecoderDelegate = 1;

        public Stub() {
            attachInterface(this, IRemoteDecoderCreator.DESCRIPTOR);
        }

        public static IRemoteDecoderCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteDecoderCreator.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteDecoderCreator)) ? new Proxy(iBinder) : (IRemoteDecoderCreator) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IRemoteDecoderCreator.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IRemoteDecoderCreator.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            IRemoteFrameDecoderDelegate iRemoteFrameDecoderDelegateNewRemoteFrameDecoderDelegate = newRemoteFrameDecoderDelegate();
            parcel2.writeNoException();
            parcel2.writeStrongInterface(iRemoteFrameDecoderDelegateNewRemoteFrameDecoderDelegate);
            return true;
        }

        static class Proxy implements IRemoteDecoderCreator {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator
            public IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteDecoderCreator.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return IRemoteFrameDecoderDelegate.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IRemoteDecoderCreator.DESCRIPTOR;
            }
        }
    }
}
