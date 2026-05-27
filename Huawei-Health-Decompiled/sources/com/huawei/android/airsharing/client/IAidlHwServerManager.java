package com.huawei.android.airsharing.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public interface IAidlHwServerManager extends IInterface {
    void deInit() throws RemoteException;

    void subscribServers(String str) throws RemoteException;

    void unsubscribServers() throws RemoteException;

    public static abstract class Stub extends Binder implements IAidlHwServerManager {
        private static final String DESCRIPTOR = "com.huawei.android.airsharing.client.IAidlHwServerManager";
        static final int TRANSACTION_deInit = 1;
        static final int TRANSACTION_subscribServers = 2;
        static final int TRANSACTION_unsubscribServers = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAidlHwServerManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IAidlHwServerManager)) {
                return (IAidlHwServerManager) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                deInit();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                subscribServers(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            unsubscribServers();
            parcel2.writeNoException();
            return true;
        }

        static class a implements IAidlHwServerManager {
            public static IAidlHwServerManager c;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f1855a;

            a(IBinder iBinder) {
                this.f1855a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1855a;
            }

            @Override // com.huawei.android.airsharing.client.IAidlHwServerManager
            public void deInit() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.f1855a.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().deInit();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.airsharing.client.IAidlHwServerManager
            public void subscribServers(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.f1855a.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().subscribServers(str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.airsharing.client.IAidlHwServerManager
            public void unsubscribServers() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.f1855a.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unsubscribServers();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAidlHwServerManager iAidlHwServerManager) {
            if (a.c != null || iAidlHwServerManager == null) {
                return false;
            }
            a.c = iAidlHwServerManager;
            return true;
        }

        public static IAidlHwServerManager getDefaultImpl() {
            return a.c;
        }
    }
}
