package com.huawei.wearkit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.wearkit.IBaseCallback;
import com.huawei.wearkit.IDetectCommonCallback;
import com.huawei.wearkit.IRealTimeCallback;
import com.huawei.wearkit.IWearCommonCallback;
import com.huawei.wearkit.IWearReadCallback;
import com.huawei.wearkit.IWearWriteCallback;
import com.huawei.wearkit.model.HealthLogOption;

/* JADX INFO: loaded from: classes2.dex */
public interface IWearKit extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearkit.IWearKit";

    void captureLog(HealthLogOption healthLogOption, IWearCommonCallback iWearCommonCallback) throws RemoteException;

    void getDeviceList(int i, IRealTimeCallback iRealTimeCallback) throws RemoteException;

    void getList(int i, IDetectCommonCallback iDetectCommonCallback) throws RemoteException;

    void goIntoPage(String str, int i, IDetectCommonCallback iDetectCommonCallback) throws RemoteException;

    void isLatestVersion(int i, IDetectCommonCallback iDetectCommonCallback) throws RemoteException;

    void isSwitchOn(int i, IDetectCommonCallback iDetectCommonCallback) throws RemoteException;

    void pushMsgToWearable(String str, String str2, IWearCommonCallback iWearCommonCallback) throws RemoteException;

    void readFromWearable(String str, String str2, IWearReadCallback iWearReadCallback) throws RemoteException;

    void requestAuthorization(int i, IBaseCallback iBaseCallback) throws RemoteException;

    void sendDeviceCommand(int i, String str, IRealTimeCallback iRealTimeCallback) throws RemoteException;

    void writeToWearable(String str, String str2, byte[] bArr, String str3, IWearWriteCallback iWearWriteCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IWearKit {
        static final int TRANSACTION_captureLog = 11;
        static final int TRANSACTION_getDeviceList = 1;
        static final int TRANSACTION_getList = 8;
        static final int TRANSACTION_goIntoPage = 10;
        static final int TRANSACTION_isLatestVersion = 9;
        static final int TRANSACTION_isSwitchOn = 7;
        static final int TRANSACTION_pushMsgToWearable = 4;
        static final int TRANSACTION_readFromWearable = 3;
        static final int TRANSACTION_requestAuthorization = 5;
        static final int TRANSACTION_sendDeviceCommand = 6;
        static final int TRANSACTION_writeToWearable = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IWearKit.DESCRIPTOR);
        }

        public static IWearKit asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWearKit.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IWearKit)) {
                return (IWearKit) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWearKit.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IWearKit.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    getDeviceList(parcel.readInt(), IRealTimeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    writeToWearable(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readString(), IWearWriteCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    readFromWearable(parcel.readString(), parcel.readString(), IWearReadCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    pushMsgToWearable(parcel.readString(), parcel.readString(), IWearCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    requestAuthorization(parcel.readInt(), IBaseCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    sendDeviceCommand(parcel.readInt(), parcel.readString(), IRealTimeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    isSwitchOn(parcel.readInt(), IDetectCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    getList(parcel.readInt(), IDetectCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    isLatestVersion(parcel.readInt(), IDetectCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    goIntoPage(parcel.readString(), parcel.readInt(), IDetectCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    captureLog((HealthLogOption) c.fDY_(parcel, HealthLogOption.CREATOR), IWearCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: loaded from: classes11.dex */
        static class d implements IWearKit {
            private IBinder c;

            d(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.wearkit.IWearKit
            public void getDeviceList(int i, IRealTimeCallback iRealTimeCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iRealTimeCallback);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void writeToWearable(String str, String str2, byte[] bArr, String str3, IWearWriteCallback iWearWriteCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongInterface(iWearWriteCallback);
                    this.c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void readFromWearable(String str, String str2, IWearReadCallback iWearReadCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iWearReadCallback);
                    this.c.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void pushMsgToWearable(String str, String str2, IWearCommonCallback iWearCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iWearCommonCallback);
                    this.c.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void requestAuthorization(int i, IBaseCallback iBaseCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iBaseCallback);
                    this.c.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void sendDeviceCommand(int i, String str, IRealTimeCallback iRealTimeCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iRealTimeCallback);
                    this.c.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void isSwitchOn(int i, IDetectCommonCallback iDetectCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iDetectCommonCallback);
                    this.c.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void getList(int i, IDetectCommonCallback iDetectCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iDetectCommonCallback);
                    this.c.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void isLatestVersion(int i, IDetectCommonCallback iDetectCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iDetectCommonCallback);
                    this.c.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void goIntoPage(String str, int i, IDetectCommonCallback iDetectCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iDetectCommonCallback);
                    this.c.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearkit.IWearKit
            public void captureLog(HealthLogOption healthLogOption, IWearCommonCallback iWearCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWearKit.DESCRIPTOR);
                    c.fDZ_(parcelObtain, healthLogOption, 0);
                    parcelObtain.writeStrongInterface(iWearCommonCallback);
                    this.c.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    /* JADX INFO: loaded from: classes9.dex */
    public static class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fDY_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fDZ_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
