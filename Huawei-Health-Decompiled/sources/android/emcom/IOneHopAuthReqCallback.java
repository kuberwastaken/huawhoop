package android.emcom;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IOneHopAuthReqCallback extends IInterface {

    /* JADX INFO: loaded from: classes9.dex */
    public static class Default implements IOneHopAuthReqCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.emcom.IOneHopAuthReqCallback
        public void onAuthResult(boolean z) throws RemoteException {
        }
    }

    void onAuthResult(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IOneHopAuthReqCallback {
        private static final String DESCRIPTOR = "android.emcom.IOneHopAuthReqCallback";
        static final int TRANSACTION_onAuthResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOneHopAuthReqCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IOneHopAuthReqCallback)) {
                return (IOneHopAuthReqCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
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
            onAuthResult(parcel.readInt() != 0);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: loaded from: classes9.dex */
        static class d implements IOneHopAuthReqCallback {
            public static IOneHopAuthReqCallback e;
            private IBinder d;

            d(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // android.emcom.IOneHopAuthReqCallback
            public void onAuthResult(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.d.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAuthResult(z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOneHopAuthReqCallback iOneHopAuthReqCallback) {
            if (d.e != null || iOneHopAuthReqCallback == null) {
                return false;
            }
            d.e = iOneHopAuthReqCallback;
            return true;
        }

        public static IOneHopAuthReqCallback getDefaultImpl() {
            return d.e;
        }
    }
}
