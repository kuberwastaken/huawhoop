package com.huawei.health;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.health.ITrackDataReport;

/* JADX INFO: loaded from: classes.dex */
public interface ITrackSportManager extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.ITrackSportManager";

    int isTrackWorking() throws RemoteException;

    void pauseSport() throws RemoteException;

    void registerDataCallback(ITrackDataReport iTrackDataReport) throws RemoteException;

    void resumeSport() throws RemoteException;

    void startSport() throws RemoteException;

    void stopSport() throws RemoteException;

    void unRegisterDataCallback(ITrackDataReport iTrackDataReport) throws RemoteException;

    public static abstract class Stub extends Binder implements ITrackSportManager {
        static final int TRANSACTION_isTrackWorking = 1;
        static final int TRANSACTION_pauseSport = 5;
        static final int TRANSACTION_registerDataCallback = 2;
        static final int TRANSACTION_resumeSport = 7;
        static final int TRANSACTION_startSport = 4;
        static final int TRANSACTION_stopSport = 6;
        static final int TRANSACTION_unRegisterDataCallback = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ITrackSportManager.DESCRIPTOR);
        }

        public static ITrackSportManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITrackSportManager.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ITrackSportManager)) {
                return (ITrackSportManager) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITrackSportManager.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ITrackSportManager.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    int iIsTrackWorking = isTrackWorking();
                    parcel2.writeNoException();
                    parcel2.writeInt(iIsTrackWorking);
                    return true;
                case 2:
                    registerDataCallback(ITrackDataReport.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    unRegisterDataCallback(ITrackDataReport.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    startSport();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    pauseSport();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    stopSport();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    resumeSport();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: loaded from: classes3.dex */
        static class a implements ITrackSportManager {
            private IBinder b;

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.huawei.health.ITrackSportManager
            public int isTrackWorking() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackSportManager.DESCRIPTOR);
                    this.b.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackSportManager
            public void registerDataCallback(ITrackDataReport iTrackDataReport) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackSportManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTrackDataReport);
                    this.b.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackSportManager
            public void unRegisterDataCallback(ITrackDataReport iTrackDataReport) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackSportManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTrackDataReport);
                    this.b.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackSportManager
            public void startSport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackSportManager.DESCRIPTOR);
                    this.b.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackSportManager
            public void pauseSport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackSportManager.DESCRIPTOR);
                    this.b.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackSportManager
            public void stopSport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackSportManager.DESCRIPTOR);
                    this.b.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.ITrackSportManager
            public void resumeSport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITrackSportManager.DESCRIPTOR);
                    this.b.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
