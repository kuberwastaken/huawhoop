package com.huawei.health;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.health.IBaseCommonCallback;
import com.huawei.health.IGetbindDeviceCommonCallback;
import com.huawei.health.IRemoteProxyCallback;
import com.huawei.health.devicemgr.business.entity.legacy.DeviceInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ICallbackInterface extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.ICallbackInterface";

    void getCommonData(int i, IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    void getDeviceList(IGetbindDeviceCommonCallback iGetbindDeviceCommonCallback) throws RemoteException;

    void getDeviceListSize(IGetbindDeviceCommonCallback iGetbindDeviceCommonCallback) throws RemoteException;

    void isHealthSupportWearDevice(IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    boolean onResponse(Map map) throws RemoteException;

    void registerBinder(IBinder iBinder, String str, String str2) throws RemoteException;

    void registerRemoteCallback(IRemoteProxyCallback iRemoteProxyCallback) throws RemoteException;

    void registerRemoteCallbackForHealth(String str, IRemoteProxyCallback iRemoteProxyCallback) throws RemoteException;

    void sendDataToHealth(String str, IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    void setDeviceCapability(String str) throws RemoteException;

    void setDeviceCapabilityForHealth(String str) throws RemoteException;

    void setUsedDeviceList(List<DeviceInfo> list) throws RemoteException;

    void setUsedDeviceListForHealth(List<DeviceInfo> list) throws RemoteException;

    void unRegisterRemoteCallback(IRemoteProxyCallback iRemoteProxyCallback) throws RemoteException;

    void unbindAllDevice(IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements ICallbackInterface {
        static final int TRANSACTION_getCommonData = 12;
        static final int TRANSACTION_getDeviceList = 8;
        static final int TRANSACTION_getDeviceListSize = 11;
        static final int TRANSACTION_isHealthSupportWearDevice = 9;
        static final int TRANSACTION_onResponse = 3;
        static final int TRANSACTION_registerBinder = 6;
        static final int TRANSACTION_registerRemoteCallback = 1;
        static final int TRANSACTION_registerRemoteCallbackForHealth = 15;
        static final int TRANSACTION_sendDataToHealth = 10;
        static final int TRANSACTION_setDeviceCapability = 5;
        static final int TRANSACTION_setDeviceCapabilityForHealth = 14;
        static final int TRANSACTION_setUsedDeviceList = 4;
        static final int TRANSACTION_setUsedDeviceListForHealth = 13;
        static final int TRANSACTION_unRegisterRemoteCallback = 2;
        static final int TRANSACTION_unbindAllDevice = 7;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ICallbackInterface.DESCRIPTOR);
        }

        public static ICallbackInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICallbackInterface.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ICallbackInterface)) {
                return (ICallbackInterface) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ICallbackInterface.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ICallbackInterface.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    registerRemoteCallback(IRemoteProxyCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    unRegisterRemoteCallback(IRemoteProxyCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    boolean zOnResponse = onResponse(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zOnResponse ? 1 : 0);
                    return true;
                case 4:
                    setUsedDeviceList(parcel.createTypedArrayList(DeviceInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    setDeviceCapability(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    registerBinder(parcel.readStrongBinder(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    unbindAllDevice(IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    getDeviceList(IGetbindDeviceCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    isHealthSupportWearDevice(IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    sendDataToHealth(parcel.readString(), IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    getDeviceListSize(IGetbindDeviceCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    getCommonData(parcel.readInt(), IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    setUsedDeviceListForHealth(parcel.createTypedArrayList(DeviceInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    setDeviceCapabilityForHealth(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    registerRemoteCallbackForHealth(parcel.readString(), IRemoteProxyCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        static class c implements ICallbackInterface {
            private IBinder b;

            c(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.huawei.health.ICallbackInterface
            public void registerRemoteCallback(IRemoteProxyCallback iRemoteProxyCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iRemoteProxyCallback);
                    this.b.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void unRegisterRemoteCallback(IRemoteProxyCallback iRemoteProxyCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iRemoteProxyCallback);
                    this.b.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public boolean onResponse(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    this.b.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void setUsedDeviceList(List<DeviceInfo> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    a.Ce_(parcelObtain, list, 0);
                    this.b.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void setDeviceCapability(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.b.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void registerBinder(IBinder iBinder, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.b.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void unbindAllDevice(IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.b.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void getDeviceList(IGetbindDeviceCommonCallback iGetbindDeviceCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iGetbindDeviceCommonCallback);
                    this.b.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void isHealthSupportWearDevice(IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.b.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void sendDataToHealth(String str, IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.b.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void getDeviceListSize(IGetbindDeviceCommonCallback iGetbindDeviceCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iGetbindDeviceCommonCallback);
                    this.b.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void getCommonData(int i, IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.b.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void setUsedDeviceListForHealth(List<DeviceInfo> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    a.Ce_(parcelObtain, list, 0);
                    this.b.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void setDeviceCapabilityForHealth(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.b.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ICallbackInterface
            public void registerRemoteCallbackForHealth(String str, IRemoteProxyCallback iRemoteProxyCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICallbackInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iRemoteProxyCallback);
                    this.b.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class a {
        private static <T extends Parcelable> void Cf_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void Ce_(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Cf_(parcel, list.get(i2), i);
            }
        }
    }
}
