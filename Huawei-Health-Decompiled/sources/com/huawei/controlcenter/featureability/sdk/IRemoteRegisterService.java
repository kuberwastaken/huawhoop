package com.huawei.controlcenter.featureability.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.controlcenter.featureability.sdk.IAuthCallback;
import com.huawei.controlcenter.featureability.sdk.IConnectCallback;
import com.huawei.controlcenter.featureability.sdk.model.ExtraParams;

/* JADX INFO: loaded from: classes3.dex */
public interface IRemoteRegisterService extends IInterface {
    boolean authReq(String str, IAuthCallback iAuthCallback) throws RemoteException;

    int register(String str, IBinder iBinder, ExtraParams extraParams, IConnectCallback iConnectCallback) throws RemoteException;

    boolean requestBeckonCallback(String str) throws RemoteException;

    boolean showDeviceList(int i, ExtraParams extraParams) throws RemoteException;

    boolean unRequestBeckonCallback(String str) throws RemoteException;

    boolean unregister(int i) throws RemoteException;

    boolean updateConnectStatus(int i, String str, int i2) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteRegisterService {
        private static final String DESCRIPTOR = "com.huawei.controlcenter.featureability.sdk.IRemoteRegisterService";
        static final int TRANSACTION_authReq = 5;
        static final int TRANSACTION_register = 1;
        static final int TRANSACTION_requestBeckonCallback = 6;
        static final int TRANSACTION_showDeviceList = 4;
        static final int TRANSACTION_unRequestBeckonCallback = 7;
        static final int TRANSACTION_unregister = 2;
        static final int TRANSACTION_updateConnectStatus = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteRegisterService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteRegisterService)) {
                return (IRemoteRegisterService) iInterfaceQueryLocalInterface;
            }
            return new e(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRegister = register(parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? ExtraParams.CREATOR.createFromParcel(parcel) : null, IConnectCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRegister);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUnregister = unregister(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zUnregister ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUpdateConnectStatus = updateConnectStatus(parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zUpdateConnectStatus ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zShowDeviceList = showDeviceList(parcel.readInt(), parcel.readInt() != 0 ? ExtraParams.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zShowDeviceList ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zAuthReq = authReq(parcel.readString(), IAuthCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zAuthReq ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRequestBeckonCallback = requestBeckonCallback(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestBeckonCallback ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUnRequestBeckonCallback = unRequestBeckonCallback(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zUnRequestBeckonCallback ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        static class e implements IRemoteRegisterService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IRemoteRegisterService f1974a;
            private IBinder e;

            e(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.controlcenter.featureability.sdk.IRemoteRegisterService
            public int register(String str, IBinder iBinder, ExtraParams extraParams, IConnectCallback iConnectCallback) throws RemoteException {
                int iRegister;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iBinder);
                    if (extraParams != null) {
                        parcelObtain.writeInt(1);
                        extraParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iConnectCallback != null ? iConnectCallback.asBinder() : null);
                    if (!this.e.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        iRegister = Stub.getDefaultImpl().register(str, iBinder, extraParams, iConnectCallback);
                    } else {
                        parcelObtain2.readException();
                        iRegister = parcelObtain2.readInt();
                    }
                    return iRegister;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.controlcenter.featureability.sdk.IRemoteRegisterService
            public boolean unregister(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.e.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().unregister(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.controlcenter.featureability.sdk.IRemoteRegisterService
            public boolean updateConnectStatus(int i, String str, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i2);
                    if (!this.e.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateConnectStatus(i, str, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.controlcenter.featureability.sdk.IRemoteRegisterService
            public boolean showDeviceList(int i, ExtraParams extraParams) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (extraParams != null) {
                        parcelObtain.writeInt(1);
                        extraParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.e.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().showDeviceList(i, extraParams);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.controlcenter.featureability.sdk.IRemoteRegisterService
            public boolean authReq(String str, IAuthCallback iAuthCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iAuthCallback != null ? iAuthCallback.asBinder() : null);
                    if (!this.e.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().authReq(str, iAuthCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.controlcenter.featureability.sdk.IRemoteRegisterService
            public boolean requestBeckonCallback(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.e.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestBeckonCallback(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.controlcenter.featureability.sdk.IRemoteRegisterService
            public boolean unRequestBeckonCallback(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.e.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().unRequestBeckonCallback(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemoteRegisterService iRemoteRegisterService) {
            if (e.f1974a != null || iRemoteRegisterService == null) {
                return false;
            }
            e.f1974a = iRemoteRegisterService;
            return true;
        }

        public static IRemoteRegisterService getDefaultImpl() {
            return e.f1974a;
        }
    }
}
