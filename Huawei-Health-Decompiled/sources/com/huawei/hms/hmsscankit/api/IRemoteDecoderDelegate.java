package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanResult;

/* JADX INFO: loaded from: classes5.dex */
public interface IRemoteDecoderDelegate extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate";

    /* JADX INFO: loaded from: classes10.dex */
    public static class Default implements IRemoteDecoderDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public HmsScanResult decodeWithBuffer(byte[] bArr, int i, int i2, IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException;

    void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException;

    HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    HmsScanResult decodeWithBuffer(byte[] bArr, int i, int i2, IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteDecoderDelegate {
        static final int TRANSACTION_buildBitmap = 4;
        static final int TRANSACTION_buildBitmapLog = 3;
        static final int TRANSACTION_decodeWithBitmap = 1;
        static final int TRANSACTION_decodeWithBuffer = 2;
        static final int TRANSACTION_queryDeepLinkInfo = 5;

        public Stub() {
            attachInterface(this, IRemoteDecoderDelegate.DESCRIPTOR);
        }

        public static IRemoteDecoderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteDecoderDelegate.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteDecoderDelegate)) ? new Proxy(iBinder) : (IRemoteDecoderDelegate) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IRemoteDecoderDelegate.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IRemoteDecoderDelegate.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                HmsScan[] hmsScanArrDecodeWithBitmap = decodeWithBitmap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeTypedArray(hmsScanArrDecodeWithBitmap, 1);
            } else if (i == 2) {
                HmsScanResult hmsScanResultDecodeWithBuffer = decodeWithBuffer(parcel.createByteArray(), parcel.readInt(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, hmsScanResultDecodeWithBuffer, 1);
            } else if (i == 3) {
                buildBitmapLog(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i == 4) {
                IObjectWrapper iObjectWrapperBuildBitmap = buildBitmap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongInterface(iObjectWrapperBuildBitmap);
            } else {
                if (i != 5) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                IObjectWrapper iObjectWrapperQueryDeepLinkInfo = queryDeepLinkInfo(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongInterface(iObjectWrapperQueryDeepLinkInfo);
            }
            return true;
        }

        static class Proxy implements IRemoteDecoderDelegate {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteDecoderDelegate.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iObjectWrapper);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteDecoderDelegate.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iObjectWrapper);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteDecoderDelegate.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iObjectWrapper);
                    parcelObtain.writeStrongInterface(iObjectWrapper2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (HmsScan[]) parcelObtain2.createTypedArray(HmsScan.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public HmsScanResult decodeWithBuffer(byte[] bArr, int i, int i2, IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteDecoderDelegate.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongInterface(iObjectWrapper);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (HmsScanResult) _Parcel.readTypedObject(parcelObtain2, HmsScanResult.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteDecoderDelegate.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iObjectWrapper);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IRemoteDecoderDelegate.DESCRIPTOR;
            }
        }
    }
}
