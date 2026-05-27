package com.huawei.hwarkuix.oHBrigdePlugin.device.capability;

import com.huawei.health.devicemgr.business.entity.DeviceCapability;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class WearSpecialCapability {
    private static final ArrayList<IGetCapability> getCapabilityArrayList = new AnonymousClass1();

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getOutGoingCall(DeviceCapability deviceCapability) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getSmartCare(DeviceCapability deviceCapability) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getSmartWatchVersionTypeValue(DeviceCapability deviceCapability) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getThirdAppPushNotification(DeviceCapability deviceCapability) {
        return false;
    }

    /* JADX INFO: renamed from: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1, reason: invalid class name */
    class AnonymousClass1 extends ArrayList<IGetCapability> {
        AnonymousClass1() {
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda0
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportLegalPrivacy();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda13
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportLegalUserAgreement();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda14
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportLegalOpenSource();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda15
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportLegalServiceStatement();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda1
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportLegalSourceStatement();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda2
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportSelfUploadDeviceLog();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda3
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportCoreSleepNewFile();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda4
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportRriNewFile();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda5
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportUploadGpsAndPdrFile();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda6
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return WearSpecialCapability.getSmartWatchVersionTypeValue(deviceCapability);
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda7
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isHmsAutoUpdate();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda8
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isHmsAutoUpdateWifi();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda9
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isHmsNotifyUpdate();
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda10
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return WearSpecialCapability.getThirdAppPushNotification(deviceCapability);
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda11
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return WearSpecialCapability.getSmartCare(deviceCapability);
                }
            });
            add(new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearSpecialCapability$1$$ExternalSyntheticLambda12
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return WearSpecialCapability.getOutGoingCall(deviceCapability);
                }
            });
        }
    }

    public static void addGetCapabilityMethod(IGetCapability iGetCapability) {
        getCapabilityArrayList.add(iGetCapability);
    }

    public static boolean getWearCapability(int i, DeviceCapability deviceCapability) {
        if (i < 0) {
            return false;
        }
        ArrayList<IGetCapability> arrayList = getCapabilityArrayList;
        if (i >= arrayList.size()) {
            return false;
        }
        return arrayList.get(i).getWearCapability(deviceCapability);
    }
}
