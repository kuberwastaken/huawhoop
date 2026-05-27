package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes10.dex */
public interface ICustomLayerDelegate extends IInterface {

    public static class Default implements ICustomLayerDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.maps.model.internal.ICustomLayerDelegate
        public void remove() {
        }
    }

    void remove();

    public static abstract class Stub extends Binder implements ICustomLayerDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
                return true;
            }
            parcel.enforceInterface("com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
            remove();
            parcel2.writeNoException();
            return true;
        }

        static class Proxy implements ICustomLayerDelegate {
            public static ICustomLayerDelegate sDefaultImpl;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5208a;

            @Override // com.huawei.hms.maps.model.internal.ICustomLayerDelegate
            public void remove() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
                    if (this.f5208a.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().remove();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.ICustomLayerDelegate";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5208a;
            }

            Proxy(IBinder iBinder) {
                this.f5208a = iBinder;
            }
        }

        public static boolean setDefaultImpl(ICustomLayerDelegate iCustomLayerDelegate) {
            if (Proxy.sDefaultImpl != null || iCustomLayerDelegate == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCustomLayerDelegate;
            return true;
        }

        public static ICustomLayerDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICustomLayerDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICustomLayerDelegate)) ? new Proxy(iBinder) : (ICustomLayerDelegate) iInterfaceQueryLocalInterface;
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.ICustomLayerDelegate");
        }
    }
}
