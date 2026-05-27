package com.huawei.hwcloudjs.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes11.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.huawei.hwcloudjs.a.a$a, reason: collision with other inner class name */
    public static class C0172a implements a {
        @Override // com.huawei.hwcloudjs.a.a
        public int a(Bundle bundle) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    int a(Bundle bundle) throws RemoteException;

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f6384a = "com.huawei.hwcloudjs.aidl.IConnectionSdk";
        static final int b = 1;

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
                parcel2.writeString(f6384a);
                return true;
            }
            parcel.enforceInterface(f6384a);
            int iA = a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(iA);
            return true;
        }

        /* JADX INFO: renamed from: com.huawei.hwcloudjs.a.a$b$a, reason: collision with other inner class name */
        static class C0173a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f6385a;
            private IBinder b;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            public String a() {
                return b.f6384a;
            }

            @Override // com.huawei.hwcloudjs.a.a
            public int a(Bundle bundle) throws RemoteException {
                int iA;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f6384a);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || b.a() == null) {
                        parcelObtain2.readException();
                        iA = parcelObtain2.readInt();
                    } else {
                        iA = b.a().a(bundle);
                    }
                    return iA;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            C0173a(IBinder iBinder) {
                this.b = iBinder;
            }
        }

        public static boolean a(a aVar) {
            if (C0173a.f6385a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0173a.f6385a = aVar;
            return true;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f6384a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0173a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a a() {
            return C0173a.f6385a;
        }

        public b() {
            attachInterface(this, f6384a);
        }
    }
}
