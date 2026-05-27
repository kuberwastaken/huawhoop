package com.huawei.iconnect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes11.dex */
public interface IWearConnectService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.iconnect.IWearConnectService";

    String getHuaweiPhoneIndex() throws RemoteException;

    public static abstract class Stub extends Binder implements IWearConnectService {
        static final int TRANSACTION_getHuaweiPhoneIndex = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IWearConnectService.DESCRIPTOR);
        }

        public static IWearConnectService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWearConnectService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IWearConnectService)) {
                return (IWearConnectService) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWearConnectService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IWearConnectService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String huaweiPhoneIndex = getHuaweiPhoneIndex();
                parcel2.writeNoException();
                parcel2.writeString(huaweiPhoneIndex);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class a implements IWearConnectService {
            private IBinder e;

            a(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.iconnect.IWearConnectService
            public String getHuaweiPhoneIndex() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearConnectService.DESCRIPTOR);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
