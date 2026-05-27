package com.huawei.hwsmartinteractmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.hwsmartinteractmgr.data.SmartMsgDbObject;

/* JADX INFO: loaded from: classes.dex */
public interface ISmartMsgReadResultListener extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hwsmartinteractmgr.ISmartMsgReadResultListener";

    void onResult(int i, SmartMsgDbObject smartMsgDbObject) throws RemoteException;

    public static abstract class Stub extends Binder implements ISmartMsgReadResultListener {
        static final int TRANSACTION_onResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISmartMsgReadResultListener.DESCRIPTOR);
        }

        public static ISmartMsgReadResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISmartMsgReadResultListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISmartMsgReadResultListener)) {
                return (ISmartMsgReadResultListener) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISmartMsgReadResultListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISmartMsgReadResultListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResult(parcel.readInt(), (SmartMsgDbObject) c.bZx_(parcel, SmartMsgDbObject.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: loaded from: classes6.dex */
        static class d implements ISmartMsgReadResultListener {
            private IBinder d;

            d(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.hwsmartinteractmgr.ISmartMsgReadResultListener
            public void onResult(int i, SmartMsgDbObject smartMsgDbObject) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISmartMsgReadResultListener.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    c.bZy_(parcelObtain, smartMsgDbObject, 0);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T bZx_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void bZy_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
