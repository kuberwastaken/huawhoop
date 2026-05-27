package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ISubscribeListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hihealth.ISubscribeListener";

    public static class Default implements ISubscribeListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hihealth.ISubscribeListener
        public void onChange(int i, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j) throws RemoteException {
        }

        @Override // com.huawei.hihealth.ISubscribeListener
        public void onResult(List list, List list2) throws RemoteException {
        }
    }

    void onChange(int i, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j) throws RemoteException;

    void onResult(List list, List list2) throws RemoteException;

    public static abstract class Stub extends Binder implements ISubscribeListener {
        static final int TRANSACTION_onChange = 2;
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISubscribeListener.DESCRIPTOR);
        }

        public static ISubscribeListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISubscribeListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISubscribeListener)) {
                return (ISubscribeListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISubscribeListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISubscribeListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                ClassLoader classLoader = getClass().getClassLoader();
                onResult(parcel.readArrayList(classLoader), parcel.readArrayList(classLoader));
                parcel2.writeNoException();
            } else if (i == 2) {
                onChange(parcel.readInt(), (HiHealthClient) _Parcel.bBU_(parcel, HiHealthClient.CREATOR), parcel.readString(), (HiHealthData) _Parcel.bBU_(parcel, HiHealthData.CREATOR), parcel.readLong());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class Proxy implements ISubscribeListener {
            private IBinder e;

            Proxy(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.hihealth.ISubscribeListener
            public void onResult(List list, List list2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISubscribeListener.DESCRIPTOR);
                    parcelObtain.writeList(list);
                    parcelObtain.writeList(list2);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hihealth.ISubscribeListener
            public void onChange(int i, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISubscribeListener.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    _Parcel.bBV_(parcelObtain, hiHealthClient, 0);
                    parcelObtain.writeString(str);
                    _Parcel.bBV_(parcelObtain, hiHealthData, 0);
                    parcelObtain.writeLong(j);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T bBU_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void bBV_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
