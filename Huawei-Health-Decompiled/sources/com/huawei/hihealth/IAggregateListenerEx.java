package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IAggregateListenerEx extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hihealth.IAggregateListenerEx";

    public static class Default implements IAggregateListenerEx {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hihealth.IAggregateListenerEx
        public void onResult(List list, int i, int i2) throws RemoteException {
        }
    }

    void onResult(List list, int i, int i2) throws RemoteException;

    public static abstract class Stub extends Binder implements IAggregateListenerEx {
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IAggregateListenerEx.DESCRIPTOR);
        }

        public static IAggregateListenerEx asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAggregateListenerEx.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IAggregateListenerEx)) {
                return (IAggregateListenerEx) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAggregateListenerEx.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAggregateListenerEx.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResult(parcel.readArrayList(getClass().getClassLoader()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class Proxy implements IAggregateListenerEx {
            private IBinder c;

            Proxy(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.hihealth.IAggregateListenerEx
            public void onResult(List list, int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAggregateListenerEx.DESCRIPTOR);
                    parcelObtain.writeList(list);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
