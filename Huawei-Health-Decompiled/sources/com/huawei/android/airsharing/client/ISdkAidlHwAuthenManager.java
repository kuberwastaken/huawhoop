package com.huawei.android.airsharing.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ISdkAidlHwAuthenManager extends IInterface {
    IBinder checkPermission() throws RemoteException;

    public static abstract class Stub extends Binder implements ISdkAidlHwAuthenManager {
        private static final String DESCRIPTOR = "com.huawei.android.airsharing.client.ISdkAidlHwAuthenManager";
        static final int TRANSACTION_checkPermission = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISdkAidlHwAuthenManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISdkAidlHwAuthenManager)) {
                return (ISdkAidlHwAuthenManager) iInterfaceQueryLocalInterface;
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
            IBinder iBinderCheckPermission = checkPermission();
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderCheckPermission);
            return true;
        }

        static class e implements ISdkAidlHwAuthenManager {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static ISdkAidlHwAuthenManager f1859a;
            private IBinder e;

            e(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.android.airsharing.client.ISdkAidlHwAuthenManager
            public IBinder checkPermission() throws RemoteException {
                IBinder strongBinder;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.e.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        strongBinder = Stub.getDefaultImpl().checkPermission();
                    } else {
                        parcelObtain2.readException();
                        strongBinder = parcelObtain2.readStrongBinder();
                    }
                    return strongBinder;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ISdkAidlHwAuthenManager iSdkAidlHwAuthenManager) {
            if (e.f1859a != null || iSdkAidlHwAuthenManager == null) {
                return false;
            }
            e.f1859a = iSdkAidlHwAuthenManager;
            return true;
        }

        public static ISdkAidlHwAuthenManager getDefaultImpl() {
            return e.f1859a;
        }
    }
}
