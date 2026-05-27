package android.emcom;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IHandoffSdkCallback extends IInterface {

    /* JADX INFO: loaded from: classes9.dex */
    public static class Default implements IHandoffSdkCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.emcom.IHandoffSdkCallback
        public void handoffDataEvent(String str) throws RemoteException {
        }

        @Override // android.emcom.IHandoffSdkCallback
        public void handoffStateChg(int i) throws RemoteException {
        }
    }

    void handoffDataEvent(String str) throws RemoteException;

    void handoffStateChg(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IHandoffSdkCallback {
        private static final String DESCRIPTOR = "android.emcom.IHandoffSdkCallback";
        static final int TRANSACTION_handoffDataEvent = 2;
        static final int TRANSACTION_handoffStateChg = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IHandoffSdkCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IHandoffSdkCallback)) {
                return (IHandoffSdkCallback) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                handoffStateChg(parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                handoffDataEvent(parcel.readString());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: loaded from: classes9.dex */
        static class d implements IHandoffSdkCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IHandoffSdkCallback f245a;
            private IBinder e;

            d(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // android.emcom.IHandoffSdkCallback
            public void handoffStateChg(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.e.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().handoffStateChg(i);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.emcom.IHandoffSdkCallback
            public void handoffDataEvent(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.e.transact(2, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().handoffDataEvent(str);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IHandoffSdkCallback iHandoffSdkCallback) {
            if (d.f245a != null || iHandoffSdkCallback == null) {
                return false;
            }
            d.f245a = iHandoffSdkCallback;
            return true;
        }

        public static IHandoffSdkCallback getDefaultImpl() {
            return d.f245a;
        }
    }
}
