package com.huawei.hwotamanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hwotamanager.ICheckCallback;
import com.huawei.hwotamanager.IDeviceListCallback;
import com.huawei.hwotamanager.IUpgradeCallBack;
import com.huawei.hwotamanager.IUpgradeStatusCallBack;

/* JADX INFO: loaded from: classes6.dex */
public interface IWearHwUpdateServiceAIDL extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hwotamanager.IWearHwUpdateServiceAIDL";

    void doUpgrade(String str, String str2, IUpgradeCallBack iUpgradeCallBack) throws RemoteException;

    void getConnectedDevices(IDeviceListCallback iDeviceListCallback) throws RemoteException;

    void getDeviceNewVersion(String str, ICheckCallback iCheckCallback) throws RemoteException;

    void getUpgradeStatus(String str, IUpgradeStatusCallBack iUpgradeStatusCallBack) throws RemoteException;

    void registerUpgradeListener(String str, IUpgradeStatusCallBack iUpgradeStatusCallBack) throws RemoteException;

    void unRegisterUpgradeListener(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IWearHwUpdateServiceAIDL {
        static final int TRANSACTION_doUpgrade = 3;
        static final int TRANSACTION_getConnectedDevices = 1;
        static final int TRANSACTION_getDeviceNewVersion = 2;
        static final int TRANSACTION_getUpgradeStatus = 4;
        static final int TRANSACTION_registerUpgradeListener = 5;
        static final int TRANSACTION_unRegisterUpgradeListener = 6;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IWearHwUpdateServiceAIDL.DESCRIPTOR);
        }

        public static IWearHwUpdateServiceAIDL asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWearHwUpdateServiceAIDL.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IWearHwUpdateServiceAIDL)) {
                return (IWearHwUpdateServiceAIDL) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWearHwUpdateServiceAIDL.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IWearHwUpdateServiceAIDL.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    getConnectedDevices(IDeviceListCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    getDeviceNewVersion(parcel.readString(), ICheckCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    doUpgrade(parcel.readString(), parcel.readString(), IUpgradeCallBack.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    getUpgradeStatus(parcel.readString(), IUpgradeStatusCallBack.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    registerUpgradeListener(parcel.readString(), IUpgradeStatusCallBack.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    unRegisterUpgradeListener(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: loaded from: classes11.dex */
        static class a implements IWearHwUpdateServiceAIDL {
            private IBinder d;

            a(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.hwotamanager.IWearHwUpdateServiceAIDL
            public void getConnectedDevices(IDeviceListCallback iDeviceListCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearHwUpdateServiceAIDL.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iDeviceListCallback);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwotamanager.IWearHwUpdateServiceAIDL
            public void getDeviceNewVersion(String str, ICheckCallback iCheckCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearHwUpdateServiceAIDL.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iCheckCallback);
                    this.d.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwotamanager.IWearHwUpdateServiceAIDL
            public void doUpgrade(String str, String str2, IUpgradeCallBack iUpgradeCallBack) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearHwUpdateServiceAIDL.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iUpgradeCallBack);
                    this.d.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwotamanager.IWearHwUpdateServiceAIDL
            public void getUpgradeStatus(String str, IUpgradeStatusCallBack iUpgradeStatusCallBack) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearHwUpdateServiceAIDL.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iUpgradeStatusCallBack);
                    this.d.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwotamanager.IWearHwUpdateServiceAIDL
            public void registerUpgradeListener(String str, IUpgradeStatusCallBack iUpgradeStatusCallBack) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearHwUpdateServiceAIDL.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iUpgradeStatusCallBack);
                    this.d.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hwotamanager.IWearHwUpdateServiceAIDL
            public void unRegisterUpgradeListener(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearHwUpdateServiceAIDL.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
