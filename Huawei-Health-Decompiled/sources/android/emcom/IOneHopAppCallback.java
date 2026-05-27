package android.emcom;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IOneHopAppCallback extends IInterface {

    /* JADX INFO: loaded from: classes9.dex */
    public static class Default implements IOneHopAppCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.emcom.IOneHopAppCallback
        public void onOneHopReceived(String str) throws RemoteException {
        }
    }

    void onOneHopReceived(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IOneHopAppCallback {
        private static final String DESCRIPTOR = "android.emcom.IOneHopAppCallback";
        static final int TRANSACTION_onOneHopReceived = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOneHopAppCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IOneHopAppCallback)) {
                return (IOneHopAppCallback) iInterfaceQueryLocalInterface;
            }
            return new e(iBinder);
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
            onOneHopReceived(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: loaded from: classes9.dex */
        static class e implements IOneHopAppCallback {
            public static IOneHopAppCallback c;
            private IBinder b;

            e(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // android.emcom.IOneHopAppCallback
            public void onOneHopReceived(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onOneHopReceived(str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOneHopAppCallback iOneHopAppCallback) {
            if (e.c != null || iOneHopAppCallback == null) {
                return false;
            }
            e.c = iOneHopAppCallback;
            return true;
        }

        public static IOneHopAppCallback getDefaultImpl() {
            return e.c;
        }
    }
}
