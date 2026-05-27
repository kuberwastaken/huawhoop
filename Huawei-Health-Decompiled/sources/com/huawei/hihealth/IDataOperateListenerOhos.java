package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IDataOperateListenerOhos extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hihealth.IDataOperateListenerOhos";

    public static class Default implements IDataOperateListenerOhos {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hihealth.IDataOperateListenerOhos
        public void onResult(int i, List<String> list) throws RemoteException {
        }
    }

    void onResult(int i, List<String> list) throws RemoteException;

    public static abstract class Stub extends Binder implements IDataOperateListenerOhos {
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IDataOperateListenerOhos.DESCRIPTOR);
        }

        public static IDataOperateListenerOhos asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDataOperateListenerOhos.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDataOperateListenerOhos)) {
                return (IDataOperateListenerOhos) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDataOperateListenerOhos.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDataOperateListenerOhos.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResult(parcel.readInt(), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class Proxy implements IDataOperateListenerOhos {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f4204a;

            Proxy(IBinder iBinder) {
                this.f4204a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4204a;
            }

            @Override // com.huawei.hihealth.IDataOperateListenerOhos
            public void onResult(int i, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDataOperateListenerOhos.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStringList(list);
                    this.f4204a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
