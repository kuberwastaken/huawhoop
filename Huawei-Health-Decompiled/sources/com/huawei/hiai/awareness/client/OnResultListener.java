package com.huawei.hiai.awareness.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface OnResultListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hiai.awareness.client.OnResultListener";

    /* JADX INFO: loaded from: classes10.dex */
    public static class Default implements OnResultListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hiai.awareness.client.OnResultListener
        public void onResult(AwarenessResult awarenessResult) throws RemoteException {
        }
    }

    void onResult(AwarenessResult awarenessResult) throws RemoteException;

    public static abstract class Stub extends Binder implements OnResultListener {
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, OnResultListener.DESCRIPTOR);
        }

        public static OnResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(OnResultListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof OnResultListener)) {
                return (OnResultListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(OnResultListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(OnResultListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResult((AwarenessResult) _Parcel.readTypedObject(parcel, AwarenessResult.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class Proxy implements OnResultListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hiai.awareness.client.OnResultListener
            public void onResult(AwarenessResult awarenessResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OnResultListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, awarenessResult, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return OnResultListener.DESCRIPTOR;
            }
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
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
