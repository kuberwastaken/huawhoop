package com.huawei.appmarket.framework.coreservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {
    void call(Status status) throws RemoteException;

    /* JADX INFO: renamed from: com.huawei.appmarket.framework.coreservice.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0063a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
                return true;
            }
            parcel.enforceInterface("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
            call(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.huawei.appmarket.framework.coreservice.a$a$b */
        /* JADX INFO: loaded from: classes10.dex */
        static class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f1925a;
            private IBinder e;

            @Override // com.huawei.appmarket.framework.coreservice.a
            public void call(Status status) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
                    if (status != null) {
                        parcelObtain.writeInt(1);
                        status.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.e.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0063a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0063a.getDefaultImpl().call(status);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            b(IBinder iBinder) {
                this.e = iBinder;
            }
        }

        public static boolean setDefaultImpl(a aVar) {
            if (b.f1925a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            b.f1925a = aVar;
            return true;
        }

        public static a getDefaultImpl() {
            return b.f1925a;
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new b(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public AbstractBinderC0063a() {
            attachInterface(this, "com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
        }
    }
}
