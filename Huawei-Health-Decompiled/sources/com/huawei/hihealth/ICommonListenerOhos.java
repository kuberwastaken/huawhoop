package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ICommonListenerOhos extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hihealth.ICommonListenerOhos";

    public static class Default implements ICommonListenerOhos {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hihealth.ICommonListenerOhos
        public void onFailure(int i, List<String> list) throws RemoteException {
        }

        @Override // com.huawei.hihealth.ICommonListenerOhos
        public void onSuccess(int i, List<String> list) throws RemoteException {
        }
    }

    void onFailure(int i, List<String> list) throws RemoteException;

    void onSuccess(int i, List<String> list) throws RemoteException;

    public static abstract class Stub extends Binder implements ICommonListenerOhos {
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onSuccess = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ICommonListenerOhos.DESCRIPTOR);
        }

        public static ICommonListenerOhos asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICommonListenerOhos.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ICommonListenerOhos)) {
                return (ICommonListenerOhos) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ICommonListenerOhos.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ICommonListenerOhos.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess(parcel.readInt(), parcel.createStringArrayList());
                parcel2.writeNoException();
            } else if (i == 2) {
                onFailure(parcel.readInt(), parcel.createStringArrayList());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class Proxy implements ICommonListenerOhos {
            private IBinder c;

            Proxy(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.hihealth.ICommonListenerOhos
            public void onSuccess(int i, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICommonListenerOhos.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStringList(list);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hihealth.ICommonListenerOhos
            public void onFailure(int i, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICommonListenerOhos.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStringList(list);
                    this.c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
