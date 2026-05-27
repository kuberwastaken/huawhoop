package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes6.dex */
public interface LinkageDeviceCommandListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hwservicesmgr.LinkageDeviceCommandListener";

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void resumeLinkage(int i, int i2) throws RemoteException;

    void start(int i) throws RemoteException;

    void startLinkage(int i, int i2) throws RemoteException;

    void stop() throws RemoteException;

    void stopLinkage() throws RemoteException;

    public static abstract class Stub extends Binder implements LinkageDeviceCommandListener {
        static final int TRANSACTION_pause = 5;
        static final int TRANSACTION_resume = 6;
        static final int TRANSACTION_resumeLinkage = 2;
        static final int TRANSACTION_start = 4;
        static final int TRANSACTION_startLinkage = 1;
        static final int TRANSACTION_stop = 7;
        static final int TRANSACTION_stopLinkage = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, LinkageDeviceCommandListener.DESCRIPTOR);
        }

        public static LinkageDeviceCommandListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(LinkageDeviceCommandListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof LinkageDeviceCommandListener)) {
                return (LinkageDeviceCommandListener) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(LinkageDeviceCommandListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(LinkageDeviceCommandListener.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    startLinkage(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    resumeLinkage(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    stopLinkage();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    start(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    resume();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    stop();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        static class c implements LinkageDeviceCommandListener {
            private IBinder e;

            c(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.hwservicesmgr.LinkageDeviceCommandListener
            public void startLinkage(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LinkageDeviceCommandListener.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.LinkageDeviceCommandListener
            public void resumeLinkage(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LinkageDeviceCommandListener.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.LinkageDeviceCommandListener
            public void stopLinkage() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LinkageDeviceCommandListener.DESCRIPTOR);
                    this.e.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.LinkageDeviceCommandListener
            public void start(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LinkageDeviceCommandListener.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.e.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.LinkageDeviceCommandListener
            public void pause() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LinkageDeviceCommandListener.DESCRIPTOR);
                    this.e.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.LinkageDeviceCommandListener
            public void resume() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LinkageDeviceCommandListener.DESCRIPTOR);
                    this.e.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwservicesmgr.LinkageDeviceCommandListener
            public void stop() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LinkageDeviceCommandListener.DESCRIPTOR);
                    this.e.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
