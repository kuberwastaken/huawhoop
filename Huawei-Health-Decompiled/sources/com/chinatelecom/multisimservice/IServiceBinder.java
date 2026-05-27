package com.chinatelecom.multisimservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.chinatelecom.multisimservice.model.ISmartWearServiceInfoCallback;

/* JADX INFO: loaded from: classes9.dex */
public interface IServiceBinder extends IInterface {
    public static final String DESCRIPTOR = "com.chinatelecom.multisimservice.IServiceBinder";

    IBinder getServiceBinder(String str, String str2) throws RemoteException;

    void getSmartWearServiceInfo() throws RemoteException;

    void registCallback(ISmartWearServiceInfoCallback iSmartWearServiceInfoCallback) throws RemoteException;

    void unRegistCallback(ISmartWearServiceInfoCallback iSmartWearServiceInfoCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IServiceBinder {
        static final int TRANSACTION_getServiceBinder = 1;
        static final int TRANSACTION_getSmartWearServiceInfo = 4;
        static final int TRANSACTION_registCallback = 2;
        static final int TRANSACTION_unRegistCallback = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IServiceBinder.DESCRIPTOR);
        }

        public static IServiceBinder asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IServiceBinder.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IServiceBinder)) {
                return (IServiceBinder) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IServiceBinder.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IServiceBinder.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                IBinder serviceBinder = getServiceBinder(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(serviceBinder);
            } else if (i == 2) {
                registCallback(ISmartWearServiceInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i == 3) {
                unRegistCallback(ISmartWearServiceInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i == 4) {
                getSmartWearServiceInfo();
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class a implements IServiceBinder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f1648a;

            a(IBinder iBinder) {
                this.f1648a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1648a;
            }

            @Override // com.chinatelecom.multisimservice.IServiceBinder
            public IBinder getServiceBinder(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IServiceBinder.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f1648a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.chinatelecom.multisimservice.IServiceBinder
            public void registCallback(ISmartWearServiceInfoCallback iSmartWearServiceInfoCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IServiceBinder.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSmartWearServiceInfoCallback);
                    this.f1648a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.chinatelecom.multisimservice.IServiceBinder
            public void unRegistCallback(ISmartWearServiceInfoCallback iSmartWearServiceInfoCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IServiceBinder.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSmartWearServiceInfoCallback);
                    this.f1648a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.chinatelecom.multisimservice.IServiceBinder
            public void getSmartWearServiceInfo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IServiceBinder.DESCRIPTOR);
                    this.f1648a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
