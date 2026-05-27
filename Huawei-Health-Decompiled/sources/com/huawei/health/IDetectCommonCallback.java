package com.huawei.health;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IDetectCommonCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.IDetectCommonCallback";

    void onResponse(int i, List list, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IDetectCommonCallback {
        static final int TRANSACTION_onResponse = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IDetectCommonCallback.DESCRIPTOR);
        }

        public static IDetectCommonCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDetectCommonCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDetectCommonCallback)) {
                return (IDetectCommonCallback) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDetectCommonCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDetectCommonCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResponse(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class a implements IDetectCommonCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f2210a;

            a(IBinder iBinder) {
                this.f2210a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2210a;
            }

            @Override // com.huawei.health.IDetectCommonCallback
            public void onResponse(int i, List list, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDetectCommonCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeList(list);
                    parcelObtain.writeString(str);
                    this.f2210a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
