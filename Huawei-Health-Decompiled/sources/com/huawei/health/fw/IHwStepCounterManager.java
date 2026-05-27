package com.huawei.health.fw;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.health.fw.IReportCallback;

/* JADX INFO: loaded from: classes.dex */
public interface IHwStepCounterManager extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.fw.IHwStepCounterManager";

    int closeStepCounter() throws RemoteException;

    int[] getAbility() throws RemoteException;

    boolean getHistoryData(long j, long j2, IReportCallback iReportCallback) throws RemoteException;

    String getVersion() throws RemoteException;

    boolean insertDiffStep(Bundle bundle) throws RemoteException;

    int openStepCounter() throws RemoteException;

    void registerDataCallback(IReportCallback iReportCallback) throws RemoteException;

    void registerLogCallback(IReportCallback iReportCallback) throws RemoteException;

    void unRegisterDataCallback(IReportCallback iReportCallback) throws RemoteException;

    void unRegisterLogCallback(IReportCallback iReportCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IHwStepCounterManager {
        static final int TRANSACTION_closeStepCounter = 4;
        static final int TRANSACTION_getAbility = 2;
        static final int TRANSACTION_getHistoryData = 8;
        static final int TRANSACTION_getVersion = 1;
        static final int TRANSACTION_insertDiffStep = 7;
        static final int TRANSACTION_openStepCounter = 3;
        static final int TRANSACTION_registerDataCallback = 5;
        static final int TRANSACTION_registerLogCallback = 9;
        static final int TRANSACTION_unRegisterDataCallback = 6;
        static final int TRANSACTION_unRegisterLogCallback = 10;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IHwStepCounterManager.DESCRIPTOR);
        }

        public static IHwStepCounterManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IHwStepCounterManager.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IHwStepCounterManager)) {
                return (IHwStepCounterManager) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IHwStepCounterManager.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IHwStepCounterManager.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    String version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(version);
                    return true;
                case 2:
                    int[] ability = getAbility();
                    parcel2.writeNoException();
                    parcel2.writeIntArray(ability);
                    return true;
                case 3:
                    int iOpenStepCounter = openStepCounter();
                    parcel2.writeNoException();
                    parcel2.writeInt(iOpenStepCounter);
                    return true;
                case 4:
                    int iCloseStepCounter = closeStepCounter();
                    parcel2.writeNoException();
                    parcel2.writeInt(iCloseStepCounter);
                    return true;
                case 5:
                    registerDataCallback(IReportCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    unRegisterDataCallback(IReportCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    boolean zInsertDiffStep = insertDiffStep((Bundle) d.Zx_(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zInsertDiffStep ? 1 : 0);
                    return true;
                case 8:
                    boolean historyData = getHistoryData(parcel.readLong(), parcel.readLong(), IReportCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(historyData ? 1 : 0);
                    return true;
                case 9:
                    registerLogCallback(IReportCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    unRegisterLogCallback(IReportCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: loaded from: classes4.dex */
        static class c implements IHwStepCounterManager {
            private IBinder c;

            c(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public String getVersion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public int[] getAbility() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    this.c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createIntArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public int openStepCounter() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    this.c.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public int closeStepCounter() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    this.c.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public void registerDataCallback(IReportCallback iReportCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iReportCallback);
                    this.c.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public void unRegisterDataCallback(IReportCallback iReportCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iReportCallback);
                    this.c.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public boolean insertDiffStep(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    d.Zy_(parcelObtain, bundle, 0);
                    this.c.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public boolean getHistoryData(long j, long j2, IReportCallback iReportCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeStrongInterface(iReportCallback);
                    this.c.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public void registerLogCallback(IReportCallback iReportCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iReportCallback);
                    this.c.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.fw.IHwStepCounterManager
            public void unRegisterLogCallback(IReportCallback iReportCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwStepCounterManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iReportCallback);
                    this.c.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T Zx_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void Zy_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
