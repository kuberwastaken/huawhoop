package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.ml.scan.HmsScan;

/* JADX INFO: loaded from: classes5.dex */
public interface IRemoteHmsDecoderDelegate extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate";

    /* JADX INFO: loaded from: classes10.dex */
    public static class Default implements IRemoteHmsDecoderDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
        public HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
        public HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
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

    HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteHmsDecoderDelegate {
        static final int TRANSACTION_decodeInBitmap = 1;
        static final int TRANSACTION_detectWithByteBuffer = 2;

        public Stub() {
            attachInterface(this, IRemoteHmsDecoderDelegate.DESCRIPTOR);
        }

        public static IRemoteHmsDecoderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteHmsDecoderDelegate.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteHmsDecoderDelegate)) ? new Proxy(iBinder) : (IRemoteHmsDecoderDelegate) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IRemoteHmsDecoderDelegate.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IRemoteHmsDecoderDelegate.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                HmsScan[] hmsScanArrDecodeInBitmap = decodeInBitmap((DetailRect) _Parcel.readTypedObject(parcel, DetailRect.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeTypedArray(hmsScanArrDecodeInBitmap, 1);
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                HmsScan[] hmsScanArrDetectWithByteBuffer = detectWithByteBuffer((DetailRect) _Parcel.readTypedObject(parcel, DetailRect.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeTypedArray(hmsScanArrDetectWithByteBuffer, 1);
            }
            return true;
        }

        static class Proxy implements IRemoteHmsDecoderDelegate {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
            public HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteHmsDecoderDelegate.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, detailRect, 0);
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
            public HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteHmsDecoderDelegate.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, detailRect, 0);
                    parcelObtain.writeStrongInterface(iObjectWrapper);
                    parcelObtain.writeStrongInterface(iObjectWrapper2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (HmsScan[]) parcelObtain2.createTypedArray(HmsScan.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IRemoteHmsDecoderDelegate.DESCRIPTOR;
            }
        }
    }
}
