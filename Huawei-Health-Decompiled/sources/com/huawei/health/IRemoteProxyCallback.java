package com.huawei.health;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface IRemoteProxyCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.IRemoteProxyCallback";

    void requestWearTask(Map map) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteProxyCallback {
        static final int TRANSACTION_requestWearTask = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IRemoteProxyCallback.DESCRIPTOR);
        }

        public static IRemoteProxyCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteProxyCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteProxyCallback)) {
                return (IRemoteProxyCallback) iInterfaceQueryLocalInterface;
            }
            return new b(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IRemoteProxyCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IRemoteProxyCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                requestWearTask(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class b implements IRemoteProxyCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f2212a;

            b(IBinder iBinder) {
                this.f2212a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2212a;
            }

            @Override // com.huawei.health.IRemoteProxyCallback
            public void requestWearTask(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteProxyCallback.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    this.f2212a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
