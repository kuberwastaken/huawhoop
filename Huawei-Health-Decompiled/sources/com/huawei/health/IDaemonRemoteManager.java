package com.huawei.health;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.health.IRealStepDataReport;
import com.huawei.health.IResultCallback;
import com.huawei.health.IStepDataReport;

/* JADX INFO: loaded from: classes.dex */
public interface IDaemonRemoteManager extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.IDaemonRemoteManager";

    void flushCacheToDB(IResultCallback iResultCallback) throws RemoteException;

    void getDebugInfo(IResultCallback iResultCallback) throws RemoteException;

    int getDeviceOriginalClass() throws RemoteException;

    boolean getGoalNotifiState() throws RemoteException;

    boolean getNotificationSupport() throws RemoteException;

    void getSleepData(IResultCallback iResultCallback) throws RemoteException;

    void getStandSteps(IResultCallback iResultCallback) throws RemoteException;

    int getStepCountAuthPermission() throws RemoteException;

    int getStepCounterClass() throws RemoteException;

    boolean getStepCounterSwitchStatus() throws RemoteException;

    boolean getStepsNotifiState() throws RemoteException;

    void getTodaySportData(IResultCallback iResultCallback) throws RemoteException;

    String getVersion() throws RemoteException;

    void isNeedPromptKeepAlive(IResultCallback iResultCallback) throws RemoteException;

    boolean isNotificationShown() throws RemoteException;

    boolean isStepCounterWorking() throws RemoteException;

    void makePromptNoSense() throws RemoteException;

    void notifyUserInfoChanged() throws RemoteException;

    boolean registerRealTimeStepReport(IRealStepDataReport iRealStepDataReport, int i) throws RemoteException;

    boolean registerStepReportCallback(IStepDataReport iStepDataReport) throws RemoteException;

    void setBaseData(long j, int i, int i2, int i3) throws RemoteException;

    void setGoalNotifiEnable(boolean z) throws RemoteException;

    void setNotificationEnable(boolean z) throws RemoteException;

    void setStepCounterSwitchStatus(boolean z) throws RemoteException;

    void setStepsNotifiEnable(boolean z) throws RemoteException;

    void setUserInfo(Bundle bundle) throws RemoteException;

    void switchTrackMonitor(boolean z) throws RemoteException;

    void tickTrackDog() throws RemoteException;

    boolean unRegisterRealTimeStepReport() throws RemoteException;

    boolean unRegisterStepReportCallback(IStepDataReport iStepDataReport) throws RemoteException;

    public static abstract class Stub extends Binder implements IDaemonRemoteManager {
        static final int TRANSACTION_flushCacheToDB = 11;
        static final int TRANSACTION_getDebugInfo = 15;
        static final int TRANSACTION_getDeviceOriginalClass = 27;
        static final int TRANSACTION_getGoalNotifiState = 23;
        static final int TRANSACTION_getNotificationSupport = 19;
        static final int TRANSACTION_getSleepData = 13;
        static final int TRANSACTION_getStandSteps = 24;
        static final int TRANSACTION_getStepCountAuthPermission = 30;
        static final int TRANSACTION_getStepCounterClass = 5;
        static final int TRANSACTION_getStepCounterSwitchStatus = 3;
        static final int TRANSACTION_getStepsNotifiState = 22;
        static final int TRANSACTION_getTodaySportData = 14;
        static final int TRANSACTION_getVersion = 1;
        static final int TRANSACTION_isNeedPromptKeepAlive = 28;
        static final int TRANSACTION_isNotificationShown = 10;
        static final int TRANSACTION_isStepCounterWorking = 4;
        static final int TRANSACTION_makePromptNoSense = 29;
        static final int TRANSACTION_notifyUserInfoChanged = 16;
        static final int TRANSACTION_registerRealTimeStepReport = 18;
        static final int TRANSACTION_registerStepReportCallback = 6;
        static final int TRANSACTION_setBaseData = 8;
        static final int TRANSACTION_setGoalNotifiEnable = 21;
        static final int TRANSACTION_setNotificationEnable = 9;
        static final int TRANSACTION_setStepCounterSwitchStatus = 2;
        static final int TRANSACTION_setStepsNotifiEnable = 20;
        static final int TRANSACTION_setUserInfo = 12;
        static final int TRANSACTION_switchTrackMonitor = 25;
        static final int TRANSACTION_tickTrackDog = 26;
        static final int TRANSACTION_unRegisterRealTimeStepReport = 7;
        static final int TRANSACTION_unRegisterStepReportCallback = 17;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IDaemonRemoteManager.DESCRIPTOR);
        }

        public static IDaemonRemoteManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDaemonRemoteManager.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDaemonRemoteManager)) {
                return (IDaemonRemoteManager) iInterfaceQueryLocalInterface;
            }
            return new b(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDaemonRemoteManager.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDaemonRemoteManager.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    String version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(version);
                    return true;
                case 2:
                    setStepCounterSwitchStatus(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    boolean stepCounterSwitchStatus = getStepCounterSwitchStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(stepCounterSwitchStatus ? 1 : 0);
                    return true;
                case 4:
                    boolean zIsStepCounterWorking = isStepCounterWorking();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsStepCounterWorking ? 1 : 0);
                    return true;
                case 5:
                    int stepCounterClass = getStepCounterClass();
                    parcel2.writeNoException();
                    parcel2.writeInt(stepCounterClass);
                    return true;
                case 6:
                    boolean zRegisterStepReportCallback = registerStepReportCallback(IStepDataReport.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterStepReportCallback ? 1 : 0);
                    return true;
                case 7:
                    boolean zUnRegisterRealTimeStepReport = unRegisterRealTimeStepReport();
                    parcel2.writeNoException();
                    parcel2.writeInt(zUnRegisterRealTimeStepReport ? 1 : 0);
                    return true;
                case 8:
                    setBaseData(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    setNotificationEnable(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    boolean zIsNotificationShown = isNotificationShown();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsNotificationShown ? 1 : 0);
                    return true;
                case 11:
                    flushCacheToDB(IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    setUserInfo((Bundle) d.Ci_(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    getSleepData(IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    getTodaySportData(IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    getDebugInfo(IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    notifyUserInfoChanged();
                    parcel2.writeNoException();
                    return true;
                case 17:
                    boolean zUnRegisterStepReportCallback = unRegisterStepReportCallback(IStepDataReport.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zUnRegisterStepReportCallback ? 1 : 0);
                    return true;
                case 18:
                    boolean zRegisterRealTimeStepReport = registerRealTimeStepReport(IRealStepDataReport.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterRealTimeStepReport ? 1 : 0);
                    return true;
                case 19:
                    boolean notificationSupport = getNotificationSupport();
                    parcel2.writeNoException();
                    parcel2.writeInt(notificationSupport ? 1 : 0);
                    return true;
                case 20:
                    setStepsNotifiEnable(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    setGoalNotifiEnable(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    boolean stepsNotifiState = getStepsNotifiState();
                    parcel2.writeNoException();
                    parcel2.writeInt(stepsNotifiState ? 1 : 0);
                    return true;
                case 23:
                    boolean goalNotifiState = getGoalNotifiState();
                    parcel2.writeNoException();
                    parcel2.writeInt(goalNotifiState ? 1 : 0);
                    return true;
                case 24:
                    getStandSteps(IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    switchTrackMonitor(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    tickTrackDog();
                    parcel2.writeNoException();
                    return true;
                case 27:
                    int deviceOriginalClass = getDeviceOriginalClass();
                    parcel2.writeNoException();
                    parcel2.writeInt(deviceOriginalClass);
                    return true;
                case 28:
                    isNeedPromptKeepAlive(IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    makePromptNoSense();
                    parcel2.writeNoException();
                    return true;
                case 30:
                    int stepCountAuthPermission = getStepCountAuthPermission();
                    parcel2.writeNoException();
                    parcel2.writeInt(stepCountAuthPermission);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: loaded from: classes3.dex */
        static class b implements IDaemonRemoteManager {
            private IBinder b;

            b(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public String getVersion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void setStepCounterSwitchStatus(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.b.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean getStepCounterSwitchStatus() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean isStepCounterWorking() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public int getStepCounterClass() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean registerStepReportCallback(IStepDataReport iStepDataReport) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iStepDataReport);
                    this.b.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean unRegisterRealTimeStepReport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void setBaseData(long j, int i, int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.b.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void setNotificationEnable(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.b.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean isNotificationShown() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void flushCacheToDB(IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iResultCallback);
                    this.b.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void setUserInfo(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    d.Cj_(parcelObtain, bundle, 0);
                    this.b.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void getSleepData(IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iResultCallback);
                    this.b.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void getTodaySportData(IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iResultCallback);
                    this.b.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void getDebugInfo(IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iResultCallback);
                    this.b.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void notifyUserInfoChanged() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean unRegisterStepReportCallback(IStepDataReport iStepDataReport) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iStepDataReport);
                    this.b.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean registerRealTimeStepReport(IRealStepDataReport iRealStepDataReport, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iRealStepDataReport);
                    parcelObtain.writeInt(i);
                    this.b.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean getNotificationSupport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void setStepsNotifiEnable(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.b.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void setGoalNotifiEnable(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.b.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean getStepsNotifiState() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public boolean getGoalNotifiState() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void getStandSteps(IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iResultCallback);
                    this.b.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void switchTrackMonitor(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.b.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void tickTrackDog() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public int getDeviceOriginalClass() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void isNeedPromptKeepAlive(IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iResultCallback);
                    this.b.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public void makePromptNoSense() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.health.IDaemonRemoteManager
            public int getStepCountAuthPermission() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDaemonRemoteManager.DESCRIPTOR);
                    this.b.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T Ci_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void Cj_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
