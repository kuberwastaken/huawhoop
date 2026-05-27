package com.huawei.android.powerkit.adapter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.android.powerkit.adapter.IStateSink;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface IPowerKitApi extends IInterface {
    boolean applyForAlarmAdjustInterval(String str, List<String> list, boolean z, long j) throws RemoteException;

    boolean applyForAlarmExemption(String str, List<String> list, boolean z) throws RemoteException;

    boolean applyForResourceUse(String str, boolean z, String str2, int i, long j, String str3) throws RemoteException;

    void clearCycleUsedInfo(String str) throws RemoteException;

    boolean disableStateEvent(int i) throws RemoteException;

    boolean enableStateEvent(int i) throws RemoteException;

    List<PowerUsageState> getAppPowerUsage(String str, String str2, long j, long j2) throws RemoteException;

    List<AppCycleUsedInfo> getAppsCycleUsedInfo(String str, List<String> list) throws RemoteException;

    Map getAppsUnusedTime(String str) throws RemoteException;

    int getCurrentFps(String str) throws RemoteException;

    float getCurrentResolutionRatio(String str) throws RemoteException;

    String getPowerKitVersion(String str) throws RemoteException;

    int getPowerMode(String str) throws RemoteException;

    int getPowerOptimizeType(String str) throws RemoteException;

    boolean isUserSleeping(String str) throws RemoteException;

    boolean notifyCallingModules(String str, String str2, List<String> list) throws RemoteException;

    boolean registerMaintenanceTime(String str, boolean z, String str2, long j, long j2) throws RemoteException;

    boolean registerSink(IStateSink iStateSink) throws RemoteException;

    boolean setActiveState(String str, int i, int i2) throws RemoteException;

    int setFps(String str, int i) throws RemoteException;

    boolean setPowerOptimizeType(String str, boolean z, int i, int i2) throws RemoteException;

    boolean setPushMessageType(String str, String str2, int i) throws RemoteException;

    boolean unregisterSink(IStateSink iStateSink) throws RemoteException;

    public static abstract class Stub extends Binder implements IPowerKitApi {
        private static final String DESCRIPTOR = "com.huawei.android.powerkit.adapter.IPowerKitApi";
        static final int TRANSACTION_applyForAlarmAdjustInterval = 19;
        static final int TRANSACTION_applyForAlarmExemption = 20;
        static final int TRANSACTION_applyForResourceUse = 9;
        static final int TRANSACTION_clearCycleUsedInfo = 22;
        static final int TRANSACTION_disableStateEvent = 8;
        static final int TRANSACTION_enableStateEvent = 7;
        static final int TRANSACTION_getAppPowerUsage = 18;
        static final int TRANSACTION_getAppsCycleUsedInfo = 21;
        static final int TRANSACTION_getAppsUnusedTime = 17;
        static final int TRANSACTION_getCurrentFps = 3;
        static final int TRANSACTION_getCurrentResolutionRatio = 2;
        static final int TRANSACTION_getPowerKitVersion = 1;
        static final int TRANSACTION_getPowerMode = 12;
        static final int TRANSACTION_getPowerOptimizeType = 15;
        static final int TRANSACTION_isUserSleeping = 11;
        static final int TRANSACTION_notifyCallingModules = 10;
        static final int TRANSACTION_registerMaintenanceTime = 13;
        static final int TRANSACTION_registerSink = 5;
        static final int TRANSACTION_setActiveState = 16;
        static final int TRANSACTION_setFps = 4;
        static final int TRANSACTION_setPowerOptimizeType = 14;
        static final int TRANSACTION_setPushMessageType = 23;
        static final int TRANSACTION_unregisterSink = 6;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPowerKitApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPowerKitApi)) {
                return (IPowerKitApi) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
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
                    String powerKitVersion = getPowerKitVersion(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(powerKitVersion);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    float currentResolutionRatio = getCurrentResolutionRatio(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeFloat(currentResolutionRatio);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int currentFps = getCurrentFps(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(currentFps);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int fps = setFps(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(fps);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRegisterSink = registerSink(IStateSink.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterSink ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUnregisterSink = unregisterSink(IStateSink.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zUnregisterSink ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zEnableStateEvent = enableStateEvent(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zEnableStateEvent ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zDisableStateEvent = disableStateEvent(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDisableStateEvent ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zApplyForResourceUse = applyForResourceUse(parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zApplyForResourceUse ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zNotifyCallingModules = notifyCallingModules(parcel.readString(), parcel.readString(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    parcel2.writeInt(zNotifyCallingModules ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsUserSleeping = isUserSleeping(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsUserSleeping ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    int powerMode = getPowerMode(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(powerMode);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRegisterMaintenanceTime = registerMaintenanceTime(parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterMaintenanceTime ? 1 : 0);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean powerOptimizeType = setPowerOptimizeType(parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(powerOptimizeType ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    int powerOptimizeType2 = getPowerOptimizeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(powerOptimizeType2);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean activeState = setActiveState(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(activeState ? 1 : 0);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    Map appsUnusedTime = getAppsUnusedTime(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeMap(appsUnusedTime);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<PowerUsageState> appPowerUsage = getAppPowerUsage(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(appPowerUsage);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zApplyForAlarmAdjustInterval = applyForAlarmAdjustInterval(parcel.readString(), parcel.createStringArrayList(), parcel.readInt() != 0, parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zApplyForAlarmAdjustInterval ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zApplyForAlarmExemption = applyForAlarmExemption(parcel.readString(), parcel.createStringArrayList(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(zApplyForAlarmExemption ? 1 : 0);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<AppCycleUsedInfo> appsCycleUsedInfo = getAppsCycleUsedInfo(parcel.readString(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(appsCycleUsedInfo);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearCycleUsedInfo(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean pushMessageType = setPushMessageType(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(pushMessageType ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        static class c implements IPowerKitApi {
            private IBinder d;

            c(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public String getPowerKitVersion(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public float getCurrentResolutionRatio(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readFloat();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public int getCurrentFps(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public int setFps(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.d.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean registerSink(IStateSink iStateSink) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iStateSink != null ? iStateSink.asBinder() : null);
                    this.d.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean unregisterSink(IStateSink iStateSink) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iStateSink != null ? iStateSink.asBinder() : null);
                    this.d.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean enableStateEvent(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.d.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean disableStateEvent(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.d.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean applyForResourceUse(String str, boolean z, String str2, int i, long j, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str3);
                    this.d.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean notifyCallingModules(String str, String str2, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringList(list);
                    this.d.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean isUserSleeping(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public int getPowerMode(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean registerMaintenanceTime(String str, boolean z, String str2, long j, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    this.d.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean setPowerOptimizeType(String str, boolean z, int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.d.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public int getPowerOptimizeType(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean setActiveState(String str, int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.d.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public Map getAppsUnusedTime(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public List<PowerUsageState> getAppPowerUsage(String str, String str2, long j, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    this.d.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(PowerUsageState.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean applyForAlarmAdjustInterval(String str, List<String> list, boolean z, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeLong(j);
                    this.d.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean applyForAlarmExemption(String str, List<String> list, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.d.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public List<AppCycleUsedInfo> getAppsCycleUsedInfo(String str, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    this.d.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(AppCycleUsedInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public void clearCycleUsedInfo(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.d.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean setPushMessageType(String str, String str2, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    this.d.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
