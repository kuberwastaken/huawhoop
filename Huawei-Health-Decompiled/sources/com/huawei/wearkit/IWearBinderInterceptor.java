package com.huawei.wearkit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IWearBinderInterceptor extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearkit.IWearBinderInterceptor";

    IBinder getServiceBinder(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IWearBinderInterceptor {
        static final int TRANSACTION_getServiceBinder = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IWearBinderInterceptor.DESCRIPTOR);
        }

        public static IWearBinderInterceptor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWearBinderInterceptor.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IWearBinderInterceptor)) {
                return (IWearBinderInterceptor) iInterfaceQueryLocalInterface;
            }
            return new b(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWearBinderInterceptor.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IWearBinderInterceptor.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                IBinder serviceBinder = getServiceBinder(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(serviceBinder);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: loaded from: classes11.dex */
        static class b implements IWearBinderInterceptor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f11775a;

            b(IBinder iBinder) {
                this.f11775a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11775a;
            }

            @Override // com.huawei.wearkit.IWearBinderInterceptor
            public IBinder getServiceBinder(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearBinderInterceptor.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.f11775a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
