package com.huawei.health;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.health.IBaseCommonCallback;
import com.huawei.health.ITrackDataForDeveloper;
import com.huawei.hihealth.StartSportParam;
import com.huawei.hihealth.StopSportParam;

/* JADX INFO: loaded from: classes3.dex */
public interface ITrackManagerForDeveloper extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.ITrackManagerForDeveloper";

    void connectSportDevice(int i, IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    Bundle getSportData() throws RemoteException;

    int getSportState() throws RemoteException;

    void pauseSport(IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    boolean registerRealtimeSportCallback(ITrackDataForDeveloper iTrackDataForDeveloper) throws RemoteException;

    void resumeSport(IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    void sendDeviceControlinstruction(String str, IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    void startSport(int i, IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    void startSportEnhance(StartSportParam startSportParam, IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    void stopSport(IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    void stopSportEnhance(StopSportParam stopSportParam, IBaseCommonCallback iBaseCommonCallback) throws RemoteException;

    boolean unregisterRealtimeSportCallback(ITrackDataForDeveloper iTrackDataForDeveloper) throws RemoteException;

    public static abstract class Stub extends Binder implements ITrackManagerForDeveloper {
        static final int TRANSACTION_connectSportDevice = 11;
        static final int TRANSACTION_getSportData = 4;
        static final int TRANSACTION_getSportState = 3;
        static final int TRANSACTION_pauseSport = 9;
        static final int TRANSACTION_registerRealtimeSportCallback = 1;
        static final int TRANSACTION_resumeSport = 10;
        static final int TRANSACTION_sendDeviceControlinstruction = 8;
        static final int TRANSACTION_startSport = 5;
        static final int TRANSACTION_startSportEnhance = 7;
        static final int TRANSACTION_stopSport = 6;
        static final int TRANSACTION_stopSportEnhance = 12;
        static final int TRANSACTION_unregisterRealtimeSportCallback = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ITrackManagerForDeveloper.DESCRIPTOR);
        }

        public static ITrackManagerForDeveloper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITrackManagerForDeveloper.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ITrackManagerForDeveloper)) {
                return (ITrackManagerForDeveloper) iInterfaceQueryLocalInterface;
            }
            return new d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITrackManagerForDeveloper.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ITrackManagerForDeveloper.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    boolean zRegisterRealtimeSportCallback = registerRealtimeSportCallback(ITrackDataForDeveloper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterRealtimeSportCallback ? 1 : 0);
                    return true;
                case 2:
                    boolean zUnregisterRealtimeSportCallback = unregisterRealtimeSportCallback(ITrackDataForDeveloper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zUnregisterRealtimeSportCallback ? 1 : 0);
                    return true;
                case 3:
                    int sportState = getSportState();
                    parcel2.writeNoException();
                    parcel2.writeInt(sportState);
                    return true;
                case 4:
                    Bundle sportData = getSportData();
                    parcel2.writeNoException();
                    d.CH_(parcel2, sportData, 1);
                    return true;
                case 5:
                    startSport(parcel.readInt(), IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    stopSport(IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    startSportEnhance((StartSportParam) d.CG_(parcel, StartSportParam.CREATOR), IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    sendDeviceControlinstruction(parcel.readString(), IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    pauseSport(IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    resumeSport(IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    connectSportDevice(parcel.readInt(), IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    stopSportEnhance((StopSportParam) d.CG_(parcel, StopSportParam.CREATOR), IBaseCommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: loaded from: classes9.dex */
        static class d implements ITrackManagerForDeveloper {
            private IBinder c;

            d(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public boolean registerRealtimeSportCallback(ITrackDataForDeveloper iTrackDataForDeveloper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTrackDataForDeveloper);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public boolean unregisterRealtimeSportCallback(ITrackDataForDeveloper iTrackDataForDeveloper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTrackDataForDeveloper);
                    this.c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public int getSportState() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    this.c.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public Bundle getSportData() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    this.c.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) d.CG_(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public void startSport(int i, IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.c.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public void stopSport(IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.c.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public void startSportEnhance(StartSportParam startSportParam, IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    d.CH_(parcelObtain, startSportParam, 0);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.c.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public void sendDeviceControlinstruction(String str, IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.c.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public void pauseSport(IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.c.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public void resumeSport(IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.c.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public void connectSportDevice(int i, IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.c.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackManagerForDeveloper
            public void stopSportEnhance(StopSportParam stopSportParam, IBaseCommonCallback iBaseCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackManagerForDeveloper.DESCRIPTOR);
                    d.CH_(parcelObtain, stopSportParam, 0);
                    parcelObtain.writeStrongInterface(iBaseCommonCallback);
                    this.c.transact(12, parcelObtain, parcelObtain2, 0);
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
        public static <T> T CG_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void CH_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
