package com.huawei.hiai.awareness.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface OnEnvelopeReceiver extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hiai.awareness.client.OnEnvelopeReceiver";

    /* JADX INFO: loaded from: classes10.dex */
    public static class Default implements OnEnvelopeReceiver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hiai.awareness.client.OnEnvelopeReceiver
        public void onReceive(AwarenessEnvelope awarenessEnvelope) throws RemoteException {
        }
    }

    void onReceive(AwarenessEnvelope awarenessEnvelope) throws RemoteException;

    public static abstract class Stub extends Binder implements OnEnvelopeReceiver {
        static final int TRANSACTION_onReceive = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, OnEnvelopeReceiver.DESCRIPTOR);
        }

        public static OnEnvelopeReceiver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(OnEnvelopeReceiver.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof OnEnvelopeReceiver)) {
                return (OnEnvelopeReceiver) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(OnEnvelopeReceiver.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(OnEnvelopeReceiver.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onReceive((AwarenessEnvelope) _Parcel.readTypedObject(parcel, AwarenessEnvelope.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class Proxy implements OnEnvelopeReceiver {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hiai.awareness.client.OnEnvelopeReceiver
            public void onReceive(AwarenessEnvelope awarenessEnvelope) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OnEnvelopeReceiver.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, awarenessEnvelope, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return OnEnvelopeReceiver.DESCRIPTOR;
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
