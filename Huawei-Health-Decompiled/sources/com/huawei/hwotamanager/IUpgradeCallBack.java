package com.huawei.hwotamanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes6.dex */
public interface IUpgradeCallBack extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hwotamanager.IUpgradeCallBack";

    void onUpgradeStatus(String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements IUpgradeCallBack {
        static final int TRANSACTION_onUpgradeStatus = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IUpgradeCallBack.DESCRIPTOR);
        }

        public static IUpgradeCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IUpgradeCallBack.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IUpgradeCallBack)) {
                return (IUpgradeCallBack) iInterfaceQueryLocalInterface;
            }
            return new e(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IUpgradeCallBack.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IUpgradeCallBack.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onUpgradeStatus(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class e implements IUpgradeCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6611a;

            e(IBinder iBinder) {
                this.f6611a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6611a;
            }

            @Override // com.huawei.hwotamanager.IUpgradeCallBack
            public void onUpgradeStatus(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IUpgradeCallBack.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f6611a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
