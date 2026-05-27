package defpackage;

import android.os.Parcel;
import com.huawei.health.devicemgr.business.entity.DeviceCapability;

/* JADX INFO: loaded from: classes4.dex */
public class dsb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dsa f12391a = new dsa();

    private int c(boolean z) {
        return z ? 1 : 0;
    }

    private void OY_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureHmsNotifyUpdate(parcel.readByte() == 1);
    }

    private void OX_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureHmsAutoUpdateWifi(parcel.readByte() == 1);
    }

    private void OW_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureHmsAutoUpdate(parcel.readByte() == 1);
    }

    private void Pa_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportNotifyDeviceNewVersion(parcel.readByte() == 1);
    }

    private void OZ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportDeviceRequestCheck(parcel.readByte() == 1);
    }

    private void Pj_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportHiWear(parcel.readByte() == 1);
    }

    private void Pt_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWearEngine(parcel.readByte() == 1);
    }

    private void Pe_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWearEngine(parcel.readByte() == 1);
    }

    private void Pu_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWorkoutTrustHeartRate(parcel.readByte() == 1);
    }

    private void Pg_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportCoreSleepNewFile(parcel.readByte() == 1);
    }

    private void Pm_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportRriNewFile(parcel.readByte() == 1);
    }

    private void PR_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportUploadGpsAndPdrFile(parcel.readByte() == 1);
    }

    private void Pl_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportRestHeartRateControls(parcel.readByte() == 1);
    }

    private void PB_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportDeviceFutureWeatherCapability(parcel.readByte() == 1);
    }

    private void Ph_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureCycleBloodOxygenSwitch(parcel.readByte() == 1);
    }

    private void Pd_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureBloodOxygenDownRemind(parcel.readByte() == 1);
    }

    private void Pn_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureRunPaceSetCapability(parcel.readByte() == 1);
    }

    private void PQ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportTide(parcel.readByte() == 1);
    }

    private void Pc_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportAppId(parcel.readByte() == 1);
    }

    private void Ps_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWalletOpenCard(parcel.readByte() == 1);
    }

    private void PM_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportSendSwitchStatus(parcel.readByte() == 1);
    }

    private void PU_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportZoneId(parcel.readByte() == 1);
    }

    private void PJ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportMarketParams(parcel.readByte() == 1);
    }

    private void PC_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportHttps(parcel.readByte() == 1);
    }

    private void PA_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportChangePhonePair(parcel.readByte() == 1);
    }

    private void Py_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportAccountSwitch(parcel.readByte() == 1);
    }

    private void Po_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSyncContacts(parcel.readByte() == 1);
    }

    private void Pp_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSyncHiCall(parcel.readByte() == 1);
    }

    private void PP_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportSyncAccount(parcel.readByte() == 1);
    }

    private void PN_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportSettingRelated(parcel.readByte() == 1);
    }

    private void PE_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportLegalPrivacy(parcel.readByte() == 1);
    }

    private void PI_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportLegalUserAgreement(parcel.readByte() == 1);
    }

    private void PD_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportOpenSourceOpen(parcel.readByte() == 1);
    }

    private void PF_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportLegalServiceStatement(parcel.readByte() == 1);
    }

    private void PG_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportLegalSourceStatement(parcel.readByte() == 1);
    }

    private void PH_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportLegalSystemWebView(parcel.readByte() == 1);
    }

    private void Pk_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportNewEsim(parcel.readByte() == 1);
    }

    private void PL_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportSelfUploadDeviceLog(parcel.readByte() == 1);
    }

    private void PS_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportUserSetting(parcel.readByte() == 1);
    }

    private void Pv_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWatchFaceAppId(parcel.readByte() == 1);
    }

    private void PO_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportSmartWatchVersionStatus(parcel.readByte() == 1);
    }

    private void PT_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportWeatherErrorCode(parcel.readByte() == 1);
    }

    private void Pb_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSmartWatchVersionTypeValue(parcel.readInt());
    }

    private void Px_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureHideWalletEntrance(parcel.readByte() == 1);
    }

    private void Pw_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportEcgAuth(parcel.readByte() == 1);
    }

    private void Pz_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportActivityRecognitionStatus(parcel.readByte() == 1);
    }

    private void PK_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportMediumToHighStrengthPreValue(parcel.readByte() == 1);
    }

    private void Pq_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportSyncTime(parcel.readByte() == 1);
    }

    private void Pf_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportConnectStatus(parcel.readByte() == 1);
    }

    private void Pi_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportExpandCapability(parcel.readByte() == 1);
    }

    private void Pr_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportSyncWifi(parcel.readByte() == 1);
    }

    private void OU_(Parcel parcel, DeviceCapability deviceCapability) {
        PB_(parcel, deviceCapability);
        PQ_(parcel, deviceCapability);
        Pc_(parcel, deviceCapability);
        Ps_(parcel, deviceCapability);
        PM_(parcel, deviceCapability);
        PU_(parcel, deviceCapability);
        PJ_(parcel, deviceCapability);
        PC_(parcel, deviceCapability);
        Pj_(parcel, deviceCapability);
        Pp_(parcel, deviceCapability);
        Po_(parcel, deviceCapability);
        PP_(parcel, deviceCapability);
        PN_(parcel, deviceCapability);
        PE_(parcel, deviceCapability);
        PI_(parcel, deviceCapability);
        PD_(parcel, deviceCapability);
        PF_(parcel, deviceCapability);
        PG_(parcel, deviceCapability);
        Pk_(parcel, deviceCapability);
        PL_(parcel, deviceCapability);
        PA_(parcel, deviceCapability);
        Py_(parcel, deviceCapability);
        PS_(parcel, deviceCapability);
        Pv_(parcel, deviceCapability);
        PO_(parcel, deviceCapability);
        Pb_(parcel, deviceCapability);
        Px_(parcel, deviceCapability);
        Pw_(parcel, deviceCapability);
        Pu_(parcel, deviceCapability);
        Pz_(parcel, deviceCapability);
        Pl_(parcel, deviceCapability);
        Pa_(parcel, deviceCapability);
        OZ_(parcel, deviceCapability);
        Ph_(parcel, deviceCapability);
        Pd_(parcel, deviceCapability);
        PT_(parcel, deviceCapability);
        Pn_(parcel, deviceCapability);
        PK_(parcel, deviceCapability);
        Pg_(parcel, deviceCapability);
        Pq_(parcel, deviceCapability);
        OW_(parcel, deviceCapability);
        OX_(parcel, deviceCapability);
        OY_(parcel, deviceCapability);
        Pm_(parcel, deviceCapability);
        PR_(parcel, deviceCapability);
        Pf_(parcel, deviceCapability);
        Pt_(parcel, deviceCapability);
        OV_(parcel, deviceCapability);
    }

    private void OV_(Parcel parcel, DeviceCapability deviceCapability) {
        Pi_(parcel, deviceCapability);
        Pr_(parcel, deviceCapability);
        Pe_(parcel, deviceCapability);
        PH_(parcel, deviceCapability);
    }

    public DeviceCapability PX_(Parcel parcel) {
        DeviceCapability deviceCapability = new DeviceCapability();
        if (parcel == null) {
            return deviceCapability;
        }
        this.f12391a.Sy_(parcel, deviceCapability);
        this.f12391a.Sz_(parcel, deviceCapability);
        this.f12391a.SA_(parcel, deviceCapability);
        OU_(parcel, deviceCapability);
        return deviceCapability;
    }

    public void PY_(Parcel parcel, DeviceCapability deviceCapability) {
        if (parcel == null || deviceCapability == null) {
            return;
        }
        this.f12391a.SB_(parcel, deviceCapability);
        this.f12391a.SC_(parcel, deviceCapability);
        this.f12391a.SD_(parcel, deviceCapability);
        PV_(parcel, deviceCapability);
    }

    private void PV_(Parcel parcel, DeviceCapability deviceCapability) {
        parcel.writeByte((byte) c(deviceCapability.isSupportSosTransmission()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSendSosSms()));
        parcel.writeByte((byte) c(deviceCapability.isSupportDeviceFutureWeatherCapability()));
        parcel.writeByte((byte) c(deviceCapability.isSupportTide()));
        parcel.writeByte((byte) c(deviceCapability.isSupportAppId()));
        parcel.writeByte((byte) c(deviceCapability.isSupportWalletOpenCard()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSendSwitchStatus()));
        parcel.writeByte((byte) c(deviceCapability.isSupportZoneId()));
        parcel.writeByte((byte) c(deviceCapability.isSupportMarketParams()));
        parcel.writeByte((byte) c(deviceCapability.isSupportHttps()));
        parcel.writeByte((byte) c(deviceCapability.isSupportHiWear()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSyncHiCall()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSyncContacts()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSyncAccount()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSettingRelated()));
        parcel.writeByte((byte) c(deviceCapability.isSupportLegalPrivacy()));
        parcel.writeByte((byte) c(deviceCapability.isSupportLegalUserAgreement()));
        parcel.writeByte((byte) c(deviceCapability.isSupportLegalOpenSource()));
        parcel.writeByte((byte) c(deviceCapability.isSupportLegalServiceStatement()));
        parcel.writeByte((byte) c(deviceCapability.isSupportLegalSourceStatement()));
        parcel.writeByte((byte) c(deviceCapability.isSupportNewEsim()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSelfUploadDeviceLog()));
        parcel.writeByte((byte) c(deviceCapability.isSupportChangePhonePair()));
        parcel.writeByte((byte) c(deviceCapability.isSupportAccountSwitch()));
        parcel.writeByte((byte) c(deviceCapability.isSupportUserSetting()));
        parcel.writeByte((byte) c(deviceCapability.isSupportWatchFaceAppId()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSmartWatchVersionStatus()));
        parcel.writeInt(deviceCapability.getSmartWatchVersionTypeValue());
        parcel.writeByte((byte) c(deviceCapability.isHideWalletEntrance()));
        parcel.writeByte((byte) c(deviceCapability.isSupportEcgAuth()));
        parcel.writeByte((byte) c(deviceCapability.isSupportWorkoutTrustHeartRate()));
        parcel.writeByte((byte) c(deviceCapability.isSupportActivityRecognitionStatus()));
        parcel.writeByte((byte) c(deviceCapability.isSupportRestHeartRateControls()));
        parcel.writeByte((byte) c(deviceCapability.getIsSupportNotifyDeviceNewVersion()));
        parcel.writeByte((byte) c(deviceCapability.getIsSupportDeviceRequestCheck()));
        parcel.writeByte((byte) c(deviceCapability.isSupportCycleBloodOxygenSwitch()));
        parcel.writeByte((byte) c(deviceCapability.isSupportBloodOxygenDownRemind()));
        parcel.writeByte((byte) c(deviceCapability.isSupportWeatherErrorCode()));
        parcel.writeByte((byte) c(deviceCapability.isSupportRunPaceSetCapability()));
        parcel.writeByte((byte) c(deviceCapability.isSupportMediumToHighStrengthPreValue()));
        parcel.writeByte((byte) c(deviceCapability.isSupportCoreSleepNewFile()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSyncTime()));
        parcel.writeByte((byte) c(deviceCapability.isHmsAutoUpdate()));
        parcel.writeByte((byte) c(deviceCapability.isHmsAutoUpdateWifi()));
        parcel.writeByte((byte) c(deviceCapability.isHmsNotifyUpdate()));
        PW_(parcel, deviceCapability);
    }

    private void PW_(Parcel parcel, DeviceCapability deviceCapability) {
        parcel.writeByte((byte) c(deviceCapability.isSupportRriNewFile()));
        parcel.writeByte((byte) c(deviceCapability.isSupportUploadGpsAndPdrFile()));
        parcel.writeByte((byte) c(deviceCapability.isSupportConnectStatus()));
        parcel.writeByte((byte) c(deviceCapability.isSupportWearEngine()));
        parcel.writeByte((byte) c(deviceCapability.isSupportExpandCapability()));
        parcel.writeByte((byte) c(deviceCapability.isSupportSyncWifi()));
        parcel.writeByte((byte) c(deviceCapability.isSupportCheckDeviceSpace()));
        parcel.writeByte((byte) c(deviceCapability.isSupportLegalSystemWebView()));
    }

    public void e(DeviceCapability deviceCapability) {
        this.f12391a.c(deviceCapability);
        this.f12391a.e(deviceCapability);
        this.f12391a.d(deviceCapability);
        d(deviceCapability);
    }

    private void d(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportSendSosSms(false);
        deviceCapability.setSupportDeviceFutureWeatherCapability(false);
        deviceCapability.setSupportTide(false);
        deviceCapability.configureSupportAppId(false);
        deviceCapability.configureSupportWalletOpenCard(false);
        deviceCapability.setSupportSendSwitchStatus(false);
        deviceCapability.configureSupportZoneId(false);
        deviceCapability.setSupportMarketParams(false);
        deviceCapability.configureSupportHttps(false);
        deviceCapability.configureSupportHiWear(false);
        deviceCapability.configureSyncHiCall(false);
        deviceCapability.configureSyncContacts(false);
        deviceCapability.setSupportSyncAccount(false);
        deviceCapability.configureSupportSettingRelated(false);
        deviceCapability.configureSupportLegalPrivacy(false);
        deviceCapability.configureSupportLegalUserAgreement(false);
        deviceCapability.configureSupportOpenSourceOpen(false);
        deviceCapability.configureSupportLegalServiceStatement(false);
        deviceCapability.configureSupportLegalSourceStatement(false);
        deviceCapability.configureSupportNewEsim(false);
        deviceCapability.setSupportSelfUploadDeviceLog(false);
        deviceCapability.configureSupportChangePhonePair(false);
        deviceCapability.configureSupportAccountSwitch(false);
        deviceCapability.configureSupportUserSetting(false);
        deviceCapability.configureSupportWatchFaceAppId(false);
        deviceCapability.setSupportSmartWatchVersionStatus(false);
        deviceCapability.configureSmartWatchVersionTypeValue(0);
        deviceCapability.configureHideWalletEntrance(false);
        deviceCapability.configureSupportEcgAuth(false);
        deviceCapability.configureSupportWorkoutTrustHeartRate(false);
        deviceCapability.setSupportActivityRecognitionStatus(false);
        deviceCapability.configureSupportRestHeartRateControls(false);
        deviceCapability.configureIsSupportNotifyDeviceNewVersion(false);
        deviceCapability.configureIsSupportDeviceRequestCheck(false);
        deviceCapability.configureCycleBloodOxygenSwitch(false);
        deviceCapability.configureBloodOxygenDownRemind(false);
        deviceCapability.setSupportWeatherErrorCode(false);
        deviceCapability.configureRunPaceSetCapability(false);
        deviceCapability.configureSupportMediumToHighStrengthPreValue(false);
        deviceCapability.configureSupportCoreSleepNewFile(false);
        deviceCapability.configureSupportSyncTime(false);
        deviceCapability.configureHmsAutoUpdate(false);
        deviceCapability.configureHmsAutoUpdateWifi(false);
        deviceCapability.configureHmsNotifyUpdate(false);
        deviceCapability.configureSupportRriNewFile(false);
        deviceCapability.configureIsSupportUploadGpsAndPdrFile(false);
        deviceCapability.configureSupportConnectStatus(false);
        a(deviceCapability);
    }

    private void a(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWearEngine(false);
        deviceCapability.configureSupportExpandCapability(false);
        deviceCapability.configureSupportSyncWifi(false);
        deviceCapability.configureSupportCheckDeviceSpace(false);
        deviceCapability.configureSupportLegalSystemWebView(false);
    }
}
