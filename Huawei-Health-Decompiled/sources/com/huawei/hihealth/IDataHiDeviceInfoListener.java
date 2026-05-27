package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IDataHiDeviceInfoListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hihealth.IDataHiDeviceInfoListener";

    public static class Default implements IDataHiDeviceInfoListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hihealth.IDataHiDeviceInfoListener
        public void onResult(List list) throws RemoteException {
        }
    }

    void onResult(List list) throws RemoteException;

    public static abstract class Stub extends Binder implements IDataHiDeviceInfoListener {
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IDataHiDeviceInfoListener.DESCRIPTOR);
        }

        public static IDataHiDeviceInfoListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDataHiDeviceInfoListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDataHiDeviceInfoListener)) {
                return (IDataHiDeviceInfoListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDataHiDeviceInfoListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDataHiDeviceInfoListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResult(parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class Proxy implements IDataHiDeviceInfoListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f4202a;

            Proxy(IBinder iBinder) {
                this.f4202a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4202a;
            }

            @Override // com.huawei.hihealth.IDataHiDeviceInfoListener
            public void onResult(List list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDataHiDeviceInfoListener.DESCRIPTOR);
                    parcelObtain.writeList(list);
                    this.f4202a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
