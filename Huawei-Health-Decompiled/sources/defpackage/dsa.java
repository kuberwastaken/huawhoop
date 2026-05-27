package defpackage;

import android.os.Parcel;
import com.huawei.health.devicemgr.business.entity.DeviceCapability;

/* JADX INFO: loaded from: classes4.dex */
public class dsa {
    private int e(boolean z) {
        return z ? 1 : 0;
    }

    private void PZ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(parcel.readByte() == 1);
    }

    private void Rr_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportGetFirmwareVersion(parcel.readByte() == 1);
    }

    private void Rq_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportGetBattery(parcel.readByte() == 1);
    }

    private void Qc_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureAutoLightScreen(parcel.readByte() == 1);
    }

    private void Qd_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureAvoidDisturb(parcel.readByte() == 1);
    }

    private void Qo_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureFactoryReset(parcel.readByte() == 1);
    }

    private void RP_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportPairDevice(parcel.readByte() == 1);
    }

    private void Rs_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportGetHandsetInfo(parcel.readByte() == 1);
    }

    private void RN_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportNotificationIntervalInfo(parcel.readByte() == 1);
    }

    private void Rc_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportActivityType(parcel.readByte() == 1);
    }

    private void Rg_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportAuthenticDevice(parcel.readByte() == 1);
    }

    private void Qs_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureGoldCard(parcel.readByte() == 1);
    }

    private void RU_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportRemoteCamera(parcel.readByte() == 1);
    }

    private void QL_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureMessageAlert(parcel.readByte() == 1);
    }

    private void RG_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportMessageAlertInfo(parcel.readByte() == 1);
    }

    private void RJ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportMessageSupportInfo(parcel.readByte() == 1);
    }

    private void RH_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureupportMessageCenterPushDevice(parcel.readByte() == 1);
    }

    private void Se_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWearMessagePush(parcel.readByte() == 1);
    }

    private void Qj_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureContacts(parcel.readByte() == 1);
    }

    private void Ri_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportCallingOperationType(parcel.readByte() == 1);
    }

    private void QM_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureMotionGoalCap(parcel.readInt());
    }

    private void Qp_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureFitnessFrameType(parcel.readInt());
    }

    private void Qa_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureActivityReminder(parcel.readByte() == 1);
    }

    private void RX_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportSetUserInfoEncrypt(parcel.readByte() == 1);
    }

    private void RW_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportSampleFrame(parcel.readByte() == 1);
    }

    private void Sc_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportThreshold(parcel.readByte() == 1);
    }

    private void QQ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureReserveSync(parcel.readByte() == 1);
    }

    private void Qy_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportHeartRateZone(parcel.readByte() == 1);
    }

    private void Qw_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportCoreSleep(parcel.readByte() == 1);
    }

    private void Rt_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportGetUserInfo(parcel.readByte() == 1);
    }

    private void QE_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportSendCoreSleepOutState(parcel.readByte() == 1);
    }

    private void QD_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(parcel.readByte() == 1);
    }

    private void Qm_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureEventAlarm(parcel.readByte() == 1);
    }

    private void Qn_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureEventAlarmNum(parcel.readInt());
    }

    private void QY_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSmartAlarm(parcel.readByte() == 1);
    }

    private void QN_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureOtaUpdate(parcel.readByte() == 1);
    }

    private void QI_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureMaintenance(parcel.readByte() == 1);
    }

    private void QK_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureMaintenanceInTime(parcel.readByte() == 1);
    }

    private void QJ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureMaintenanceGetData(parcel.readByte() == 1);
    }

    private void Rd_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportAntiLost(parcel.readByte() == 1);
    }

    private void Qe_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureBluetoothOffAlert(parcel.readByte() == 1);
    }

    private void QH_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureLanguage(parcel.readByte() == 1);
    }

    private void So_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureWeatherPush(parcel.readByte() == 1);
    }

    private void Sd_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportUnitWeather(parcel.readByte() == 1);
    }

    private void Qb_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureAtmosphereSupportExpand(parcel.readByte() == 1);
    }

    private void Sp_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureWeatherSupportErrorCode(parcel.readByte() == 1);
    }

    private void Rm_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportExerciseAdvice(parcel.readByte() == 1);
    }

    private void Ro_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportExerciseAdviceTime(parcel.readByte() == 1);
    }

    private void Rn_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportExerciseAdviceMonitor(parcel.readByte() == 1);
    }

    private void Sg_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWorkout(parcel.readByte() == 1);
    }

    private void Sj_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWorkoutInfo(parcel.readByte() == 1);
    }

    private void Sr_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWorkoutReminder(parcel.readByte() == 1);
    }

    private void Sk_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWorkoutRecord(parcel.readByte() == 1);
    }

    private void Si_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(parcel.readByte() == 1);
    }

    private void Sl_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWorkoutRecordPaceMap(parcel.readByte() == 1);
    }

    private void Sh_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWorkoutCapabilicy(parcel.readByte() == 1);
    }

    private void Rv_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportGpsLocation(parcel.readByte() == 1);
    }

    private void Ru_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportGpsData(parcel.readByte() == 1);
    }

    private void Ry_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportGpsSetParameter(parcel.readByte() == 1);
    }

    private void Rw_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportGpsPostProcessing(parcel.readByte() == 1);
    }

    private void RA_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportHeartRateInfo(parcel.readByte() == 1);
    }

    private void QV_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSleep(parcel.readByte() == 1);
    }

    private void Qi_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureClimb(parcel.readByte() == 1);
    }

    private void QR_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureRiding(parcel.readByte() == 1);
    }

    private void QZ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureStand(parcel.readByte() == 1);
    }

    private void QX_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSleepShallow(parcel.readByte() == 1);
    }

    private void QW_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSleepDeep(parcel.readByte() == 1);
    }

    private void Sn_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureWalk(parcel.readByte() == 1);
    }

    private void QT_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureRun(parcel.readByte() == 1);
    }

    private void Ra_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureStep(parcel.readByte() == 1);
    }

    private void Qg_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureCalorie(parcel.readByte() == 1);
    }

    private void Qk_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureDistance(parcel.readByte() == 1);
    }

    private void Qx_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportHeartRate(parcel.readByte() == 1);
    }

    private void QP_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configurePromptPush(parcel.readInt());
    }

    private void Qf_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureCallMute(parcel.readByte() == 1);
    }

    private void Qz_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportHelp(parcel.readByte() == 1);
    }

    private void Ql_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureDistanceDetail(parcel.readByte() == 1);
    }

    private void Rl_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportEsim(parcel.readByte() == 1);
    }

    private void RL_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportMultiSim(parcel.readByte() == 1);
    }

    private void RQ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportPay(parcel.readByte() == 1);
    }

    private void Rz_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureisSupportHeartRateEnable(parcel.readByte() == 1);
    }

    private void QS_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureRotateSwitchScreen(parcel.readByte() == 1);
    }

    private void RT_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportQueryAllowDisturbContent(parcel.readByte() == 1);
    }

    private void RE_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportLeftRightHandWearMode(parcel.readByte() == 1);
    }

    private void Sb_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportStress(parcel.readByte() == 1);
    }

    private void RK_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportMidware(parcel.readByte() == 1);
    }

    private void Sa_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportSportTotal(parcel.readByte() == 1);
    }

    private void Rb_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportAccount(parcel.readByte() == 1);
    }

    private void RO_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportOneLevelMenu(parcel.readByte() == 1);
    }

    private void Rk_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportDeleteMsg(parcel.readByte() == 1);
    }

    private void RS_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportPosture(parcel.readByte() == 1);
    }

    private void RM_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportMusicControl(parcel.readByte() == 1);
    }

    private void QO_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configruePressAutoMonitor(parcel.readByte() == 1);
    }

    private void Rj_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportContinueHeartRate(parcel.readByte() == 1);
    }

    private void Re_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportAtmosphere(parcel.readByte() == 1);
    }

    private void Rh_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportAutoDetectMode(parcel.readByte() == 1);
    }

    private void Rp_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportFootWear(parcel.readByte() == 1);
    }

    private void RV_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportRunPosture(parcel.readByte() == 1);
    }

    private void Qu_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureHeartRateRaiseAlarm(parcel.readByte() == 1);
    }

    private void Qq_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureGetHeartRateRaiseAlarmNumber(parcel.readByte() == 1);
    }

    private void Qr_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureGetHighAndMiddleSport(parcel.readByte() == 1);
    }

    private void Ss_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportDefaultSwitch(parcel.readByte() == 1);
    }

    private void Qt_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureHeartRateDownAlarm(parcel.readByte() == 1);
    }

    private void Qh_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureChangeAlarm(parcel.readByte() == 1);
    }

    private void RD_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportIntelligentHomeLinkage(parcel.readByte() == 1);
    }

    private void Sm_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSyncBeforeOta(parcel.readByte() == 1);
    }

    private void QC_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportPhonesInfo(parcel.readByte() == 1);
    }

    private void QB_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportNotifyDeviceBroadCast(parcel.readByte() == 1);
    }

    private void Rf_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportAtrialOperator(parcel.readByte() == 1);
    }

    private void QU_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSetHrrHeartRateCapability(parcel.readByte() == 1);
    }

    private void Sx_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportWatchFace(parcel.readByte() == 1);
    }

    private void Su_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportMarketFace(parcel.readByte() == 1);
    }

    private void RC_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportInformCloseOrOpen(parcel.readByte() == 1);
    }

    private void QF_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportStressAppToDevice(parcel.readByte() == 1);
    }

    private void QA_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportMusicInfoList(parcel.readByte() == 1);
    }

    private void Sv_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportOneTouch(parcel.readByte() == 1);
    }

    private void Sw_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportTws(parcel.readByte() == 1);
    }

    private void RY_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportSleepBreathe(parcel.readByte() == 1);
    }

    private void RB_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportHiCarDriverRemind(parcel.readByte() == 1);
    }

    private void RI_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportMessageFeedback(parcel.readByte() == 1);
    }

    private void Sf_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportWearStatus(parcel.readByte() == 1);
    }

    private void RR_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportPhd(parcel.readByte() == 1);
    }

    private void Qv_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportAutoUpdate(parcel.readByte() == 1);
    }

    private void Rx_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportGpsSearchStarOptimization(parcel.readByte() == 1);
    }

    private void QG_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureIsSupportUpdateChange(parcel.readByte() == 1);
    }

    private void St_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.setSupportElectronicCard(parcel.readByte() == 1);
    }

    private void Sq_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureWeatherSupportFutureInfo(parcel.readByte() == 1);
    }

    private void RF_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportMenstrual(parcel.readByte() == 1);
    }

    private void RZ_(Parcel parcel, DeviceCapability deviceCapability) {
        deviceCapability.configureSupportSosTransmission(parcel.readByte() == 1);
        deviceCapability.configureSupportSendSosSms(parcel.readByte() == 1);
    }

    public void Sy_(Parcel parcel, DeviceCapability deviceCapability) {
        if (parcel == null || deviceCapability == null) {
            return;
        }
        PZ_(parcel, deviceCapability);
        Rr_(parcel, deviceCapability);
        Rq_(parcel, deviceCapability);
        Qc_(parcel, deviceCapability);
        Qd_(parcel, deviceCapability);
        Qo_(parcel, deviceCapability);
        RP_(parcel, deviceCapability);
        Rs_(parcel, deviceCapability);
        RN_(parcel, deviceCapability);
        Rc_(parcel, deviceCapability);
        Rg_(parcel, deviceCapability);
        Qs_(parcel, deviceCapability);
        RU_(parcel, deviceCapability);
        QL_(parcel, deviceCapability);
        RG_(parcel, deviceCapability);
        RJ_(parcel, deviceCapability);
        RH_(parcel, deviceCapability);
        Se_(parcel, deviceCapability);
        Qj_(parcel, deviceCapability);
        Ri_(parcel, deviceCapability);
        QM_(parcel, deviceCapability);
        Qp_(parcel, deviceCapability);
        Qa_(parcel, deviceCapability);
        RX_(parcel, deviceCapability);
        RW_(parcel, deviceCapability);
        Sc_(parcel, deviceCapability);
        QQ_(parcel, deviceCapability);
        Qy_(parcel, deviceCapability);
        Qw_(parcel, deviceCapability);
        Rt_(parcel, deviceCapability);
        QE_(parcel, deviceCapability);
        QD_(parcel, deviceCapability);
        Qm_(parcel, deviceCapability);
        Qn_(parcel, deviceCapability);
        QY_(parcel, deviceCapability);
        QN_(parcel, deviceCapability);
        QI_(parcel, deviceCapability);
        QK_(parcel, deviceCapability);
        QJ_(parcel, deviceCapability);
    }

    public void Sz_(Parcel parcel, DeviceCapability deviceCapability) {
        if (parcel == null || deviceCapability == null) {
            return;
        }
        Rd_(parcel, deviceCapability);
        Qe_(parcel, deviceCapability);
        QH_(parcel, deviceCapability);
        So_(parcel, deviceCapability);
        Sd_(parcel, deviceCapability);
        Qb_(parcel, deviceCapability);
        Sp_(parcel, deviceCapability);
        Rm_(parcel, deviceCapability);
        Ro_(parcel, deviceCapability);
        Rn_(parcel, deviceCapability);
        Sg_(parcel, deviceCapability);
        Sj_(parcel, deviceCapability);
        Sr_(parcel, deviceCapability);
        Sk_(parcel, deviceCapability);
        Si_(parcel, deviceCapability);
        Sl_(parcel, deviceCapability);
        Sh_(parcel, deviceCapability);
        Rv_(parcel, deviceCapability);
        Ru_(parcel, deviceCapability);
        Ry_(parcel, deviceCapability);
        Rw_(parcel, deviceCapability);
        RA_(parcel, deviceCapability);
        QV_(parcel, deviceCapability);
        Qi_(parcel, deviceCapability);
        QR_(parcel, deviceCapability);
        QZ_(parcel, deviceCapability);
        QX_(parcel, deviceCapability);
        QW_(parcel, deviceCapability);
        Sn_(parcel, deviceCapability);
        QT_(parcel, deviceCapability);
        Ra_(parcel, deviceCapability);
        Qg_(parcel, deviceCapability);
        Qk_(parcel, deviceCapability);
        Qx_(parcel, deviceCapability);
        QP_(parcel, deviceCapability);
        Qf_(parcel, deviceCapability);
        Qz_(parcel, deviceCapability);
        Ql_(parcel, deviceCapability);
        Rl_(parcel, deviceCapability);
        RL_(parcel, deviceCapability);
        RQ_(parcel, deviceCapability);
        Rz_(parcel, deviceCapability);
        QS_(parcel, deviceCapability);
        RT_(parcel, deviceCapability);
        RE_(parcel, deviceCapability);
    }

    public void SA_(Parcel parcel, DeviceCapability deviceCapability) {
        if (parcel == null || deviceCapability == null) {
            return;
        }
        Sb_(parcel, deviceCapability);
        RK_(parcel, deviceCapability);
        Sa_(parcel, deviceCapability);
        Rb_(parcel, deviceCapability);
        RO_(parcel, deviceCapability);
        Rk_(parcel, deviceCapability);
        RS_(parcel, deviceCapability);
        RM_(parcel, deviceCapability);
        QO_(parcel, deviceCapability);
        Rj_(parcel, deviceCapability);
        Re_(parcel, deviceCapability);
        Rh_(parcel, deviceCapability);
        Rp_(parcel, deviceCapability);
        RV_(parcel, deviceCapability);
        Qu_(parcel, deviceCapability);
        Qq_(parcel, deviceCapability);
        Qr_(parcel, deviceCapability);
        Ss_(parcel, deviceCapability);
        Qt_(parcel, deviceCapability);
        Qh_(parcel, deviceCapability);
        RD_(parcel, deviceCapability);
        Sm_(parcel, deviceCapability);
        QC_(parcel, deviceCapability);
        QB_(parcel, deviceCapability);
        Rf_(parcel, deviceCapability);
        QU_(parcel, deviceCapability);
        Sx_(parcel, deviceCapability);
        Su_(parcel, deviceCapability);
        RC_(parcel, deviceCapability);
        QF_(parcel, deviceCapability);
        QA_(parcel, deviceCapability);
        Sv_(parcel, deviceCapability);
        Sw_(parcel, deviceCapability);
        RY_(parcel, deviceCapability);
        RB_(parcel, deviceCapability);
        RI_(parcel, deviceCapability);
        Sf_(parcel, deviceCapability);
        RR_(parcel, deviceCapability);
        Qv_(parcel, deviceCapability);
        Rx_(parcel, deviceCapability);
        QG_(parcel, deviceCapability);
        St_(parcel, deviceCapability);
        Sq_(parcel, deviceCapability);
        RF_(parcel, deviceCapability);
        RZ_(parcel, deviceCapability);
    }

    public void SB_(Parcel parcel, DeviceCapability deviceCapability) {
        if (parcel == null || deviceCapability == null) {
            return;
        }
        parcel.writeByte((byte) e(deviceCapability.isSupportTimeSetting()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGetFirmwareVersion()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGetBattery()));
        parcel.writeByte((byte) e(deviceCapability.isSupportAutoLightScreen()));
        parcel.writeByte((byte) e(deviceCapability.isAvoidDisturb()));
        parcel.writeByte((byte) e(deviceCapability.isFactoryReset()));
        parcel.writeByte((byte) e(deviceCapability.isSupportPairDevice()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGetHandsetInfo()));
        parcel.writeByte((byte) e(deviceCapability.isSupportNotificationIntervalInfo()));
        parcel.writeByte((byte) e(deviceCapability.isSupportActivityType()));
        parcel.writeByte((byte) e(deviceCapability.isSupportAuthenticDevice()));
        parcel.writeByte((byte) e(deviceCapability.isGoldCard()));
        parcel.writeByte((byte) e(deviceCapability.isSupportRemoteCamera()));
        parcel.writeByte((byte) e(deviceCapability.isMessageAlert()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMessageAlertInfo()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMessageSupportInfo()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMessageCenterPushDevice()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWearMessagePush()));
        parcel.writeByte((byte) e(deviceCapability.isContacts()));
        parcel.writeByte((byte) e(deviceCapability.isSupportCallingOperationType()));
        parcel.writeInt(deviceCapability.getMotionGoalCap());
        parcel.writeInt(deviceCapability.getFitnessFrameType());
        parcel.writeByte((byte) e(deviceCapability.isActivityReminder()));
        parcel.writeByte((byte) e(deviceCapability.isSupportSetUserInfoEncrypt()));
        parcel.writeByte((byte) e(deviceCapability.isSupportSampleFrame()));
        parcel.writeByte((byte) e(deviceCapability.isSupportThreshold()));
        parcel.writeByte((byte) e(deviceCapability.isReserveSync()));
        parcel.writeByte((byte) e(deviceCapability.isSupportHeartRateZone()));
        parcel.writeByte((byte) e(deviceCapability.isSupportCoreSleep()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGetUserInfo()));
        parcel.writeByte((byte) e(deviceCapability.isSupportSendCoreSleepOutState()));
        parcel.writeByte((byte) e(deviceCapability.isSupportQueryDeviceCoreSleepSwitch()));
        parcel.writeByte((byte) e(deviceCapability.isEventAlarm()));
        parcel.writeInt(deviceCapability.getEventAlarmNum());
        parcel.writeByte((byte) e(deviceCapability.isSmartAlarm()));
        parcel.writeByte((byte) e(deviceCapability.isOtaUpdate()));
        parcel.writeByte((byte) e(deviceCapability.isMaintenance()));
        parcel.writeByte((byte) e(deviceCapability.isMaintenanceInTime()));
        parcel.writeByte((byte) e(deviceCapability.isMaintenanceGetData()));
    }

    public void SC_(Parcel parcel, DeviceCapability deviceCapability) {
        if (parcel == null || deviceCapability == null) {
            return;
        }
        parcel.writeByte((byte) e(deviceCapability.isSupportAntiLost()));
        parcel.writeByte((byte) e(deviceCapability.isBluetoothOffAlert()));
        parcel.writeByte((byte) e(deviceCapability.isLanguage()));
        parcel.writeByte((byte) e(deviceCapability.isWeatherPush()));
        parcel.writeByte((byte) e(deviceCapability.isSupportUnitWeather()));
        parcel.writeByte((byte) e(deviceCapability.isAtmosphereSupportExpand()));
        parcel.writeByte((byte) e(deviceCapability.isWeatherSupportErrorCode()));
        parcel.writeByte((byte) e(deviceCapability.isSupportExerciseAdvice()));
        parcel.writeByte((byte) e(deviceCapability.isSupportExerciseAdviceTime()));
        parcel.writeByte((byte) e(deviceCapability.isSupportExerciseAdviceMonitor()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWorkout()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWorkoutInfo()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWorkoutReminder()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWorkoutRecord()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWorkoutExerciseDisplayLink()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWorkoutRecordPaceMap()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWorkoutCapabilicy()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGpsLocation()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGpsData()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGpsSetParameter()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGpsPostProcessing()));
        parcel.writeByte((byte) e(deviceCapability.isSupportHeartRateInfo()));
        parcel.writeByte((byte) e(deviceCapability.isSleep()));
        parcel.writeByte((byte) e(deviceCapability.isClimb()));
        parcel.writeByte((byte) e(deviceCapability.isRiding()));
        parcel.writeByte((byte) e(deviceCapability.isStand()));
        parcel.writeByte((byte) e(deviceCapability.isSleepShallow()));
        parcel.writeByte((byte) e(deviceCapability.isSleepDeep()));
        parcel.writeByte((byte) e(deviceCapability.isWalk()));
        parcel.writeByte((byte) e(deviceCapability.isRun()));
        parcel.writeByte((byte) e(deviceCapability.isStep()));
        parcel.writeByte((byte) e(deviceCapability.isCalorie()));
        parcel.writeByte((byte) e(deviceCapability.isDistance()));
        parcel.writeByte((byte) e(deviceCapability.isSupportHeartRate()));
        parcel.writeInt(deviceCapability.isPromptPush());
        parcel.writeByte((byte) e(deviceCapability.isSupportCallMute()));
        parcel.writeByte((byte) e(deviceCapability.isSupportHelp()));
        parcel.writeByte((byte) e(deviceCapability.getDistanceDetail()));
        parcel.writeByte((byte) e(deviceCapability.isSupportEsim()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMultiSim()));
        parcel.writeByte((byte) e(deviceCapability.isSupportPay()));
        parcel.writeByte((byte) e(deviceCapability.isSupportHeartRateEnable()));
        parcel.writeByte((byte) e(deviceCapability.isSupportRotateSwitchScreen()));
        parcel.writeByte((byte) e(deviceCapability.isSupportQueryAllowDisturbContent()));
        parcel.writeByte((byte) e(deviceCapability.isSupportLeftRightHandWearMode()));
    }

    public void SD_(Parcel parcel, DeviceCapability deviceCapability) {
        if (parcel == null || deviceCapability == null) {
            return;
        }
        parcel.writeByte((byte) e(deviceCapability.isSupportStress()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMidware()));
        parcel.writeByte((byte) e(deviceCapability.isSupportSportTotal()));
        parcel.writeByte((byte) e(deviceCapability.isSupportAccount()));
        parcel.writeByte((byte) e(deviceCapability.isSupportOneLevelMenu()));
        parcel.writeByte((byte) e(deviceCapability.isSupportDeleteMsg()));
        parcel.writeByte((byte) e(deviceCapability.isSupportPosture()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMusicControl()));
        parcel.writeByte((byte) e(deviceCapability.isSupportPressAutoMonitor()));
        parcel.writeByte((byte) e(deviceCapability.isSupportContinueHeartRate()));
        parcel.writeByte((byte) e(deviceCapability.isSupportAtmosphere()));
        parcel.writeByte((byte) e(deviceCapability.isSupportAutoDetectMode()));
        parcel.writeByte((byte) e(deviceCapability.isSupportFootWear()));
        parcel.writeByte((byte) e(deviceCapability.isSupportRunPosture()));
        parcel.writeByte((byte) e(deviceCapability.isSupportHeartRateRaiseAlarm()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGetHeartRateRaiseAlarmNumber()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGetHighAndMiddleSport()));
        parcel.writeByte((byte) e(deviceCapability.isSupportDefaultSwitch()));
        parcel.writeByte((byte) e(deviceCapability.isSupportHeartRateDownAlarm()));
        parcel.writeByte((byte) e(deviceCapability.isSupportChangeAlarm()));
        parcel.writeByte((byte) e(deviceCapability.isSupportIntelligentHomeLinkage()));
        parcel.writeByte((byte) e(deviceCapability.isNeedSyncBeforeOta()));
        parcel.writeByte((byte) e(deviceCapability.isSupportPhonesInfo()));
        parcel.writeByte((byte) e(deviceCapability.isSupportNotifyDeviceBroadCast()));
        parcel.writeByte((byte) e(deviceCapability.isSupportAtrialOperator()));
        parcel.writeByte((byte) e(deviceCapability.getIsSupportHrrHeartRateCapability()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWatchFace()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMarketFace()));
        parcel.writeByte((byte) e(deviceCapability.isSupportInformCloseOrOpen()));
        parcel.writeByte((byte) e(deviceCapability.isSupportStressAppToDevice()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMusicInfoList()));
        parcel.writeByte((byte) e(deviceCapability.isSupportOneTouch()));
        parcel.writeByte((byte) e(deviceCapability.isSupportTws()));
        parcel.writeByte((byte) e(deviceCapability.isSupportSleepBreathe()));
        parcel.writeByte((byte) e(deviceCapability.isSupportHiCarDriverRemind()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMessageFeedback()));
        parcel.writeByte((byte) e(deviceCapability.isSupportWearStatus()));
        parcel.writeByte((byte) e(deviceCapability.isSupportPhd()));
        parcel.writeByte((byte) e(deviceCapability.getIsSupportAutoUpdate()));
        parcel.writeByte((byte) e(deviceCapability.isSupportGpsSearchStarOptimization()));
        parcel.writeByte((byte) e(deviceCapability.getIsSupportUpdateChange()));
        parcel.writeByte((byte) e(deviceCapability.isSupportElectronicCard()));
        parcel.writeByte((byte) e(deviceCapability.isWeatherSupportFutureInfo()));
        parcel.writeByte((byte) e(deviceCapability.isSupportMenstrual()));
    }

    public void c(DeviceCapability deviceCapability) {
        if (deviceCapability == null) {
            return;
        }
        deviceCapability.configureSupportTimeSetting(false);
        deviceCapability.configureSupportGetFirmwareVersion(false);
        deviceCapability.configureSupportGetBattery(false);
        deviceCapability.configureAutoLightScreen(false);
        deviceCapability.configureAvoidDisturb(false);
        deviceCapability.configureFactoryReset(false);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(false);
        deviceCapability.configureSupportActivityType(false);
        deviceCapability.configureSupportAuthenticDevice(false);
        deviceCapability.configureGoldCard(false);
        deviceCapability.configureSupportRemoteCamera(false);
        deviceCapability.configureMessageAlert(false);
        deviceCapability.configureSupportMessageAlertInfo(false);
        deviceCapability.configureSupportMessageSupportInfo(false);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureSupportWearMessagePush(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitnessFrameType(0);
        deviceCapability.configureActivityReminder(false);
        deviceCapability.configureSupportSetUserInfoEncrypt(false);
        deviceCapability.configureSupportSampleFrame(false);
        deviceCapability.configureSupportThreshold(false);
        deviceCapability.configureReserveSync(false);
        deviceCapability.configureIsSupportHeartRateZone(false);
        deviceCapability.configureIsSupportCoreSleep(false);
        deviceCapability.configureSupportGetUserInfo(false);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEventAlarm(false);
        deviceCapability.configureEventAlarmNum(5);
        deviceCapability.configureSmartAlarm(false);
        deviceCapability.configureOtaUpdate(false);
        deviceCapability.configureMaintenance(false);
        deviceCapability.configureMaintenanceInTime(false);
        deviceCapability.configureMaintenanceGetData(false);
    }

    public void e(DeviceCapability deviceCapability) {
        if (deviceCapability == null) {
            return;
        }
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetoothOffAlert(false);
        deviceCapability.configureLanguage(false);
        deviceCapability.configureWeatherPush(false);
        deviceCapability.configureSupportUnitWeather(false);
        deviceCapability.configureAtmosphereSupportExpand(false);
        deviceCapability.configureWeatherSupportErrorCode(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportWorkoutCapabilicy(false);
        deviceCapability.configureSupportGpsLocation(false);
        deviceCapability.configureSupportGpsData(false);
        deviceCapability.configureSupportGpsSetParameter(false);
        deviceCapability.configureSupportGpsPostProcessing(false);
        deviceCapability.configureSupportHeartRateInfo(false);
        deviceCapability.configureSleep(false);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(false);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleepShallow(false);
        deviceCapability.configureSleepDeep(false);
        deviceCapability.configureWalk(false);
        deviceCapability.configureRun(false);
        deviceCapability.configureStep(false);
        deviceCapability.configureCalorie(false);
        deviceCapability.configureDistance(false);
        deviceCapability.configureIsSupportHeartRate(false);
        deviceCapability.configurePromptPush(0);
        deviceCapability.configureCallMute(false);
        deviceCapability.configureIsSupportHelp(false);
        deviceCapability.configureDistanceDetail(false);
        deviceCapability.configureSupportEsim(false);
        deviceCapability.configureSupportMultiSim(false);
        deviceCapability.configureSupportPay(false);
        deviceCapability.configureisSupportHeartRateEnable(false);
        deviceCapability.configureRotateSwitchScreen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
    }

    public void d(DeviceCapability deviceCapability) {
        if (deviceCapability == null) {
            return;
        }
        deviceCapability.configureSupportStress(false);
        deviceCapability.configureSupportMidware(false);
        deviceCapability.configureSupportSportTotal(false);
        deviceCapability.configureSupportAccount(false);
        deviceCapability.configureSupportOneLevelMenu(false);
        deviceCapability.configureSupportDeleteMsg(false);
        deviceCapability.configureSupportPosture(false);
        deviceCapability.configureSupportMusicControl(false);
        deviceCapability.configruePressAutoMonitor(false);
        deviceCapability.configureSupportContinueHeartRate(false);
        deviceCapability.configureSupportAtmosphere(false);
        deviceCapability.configureSupportAutoDetectMode(false);
        deviceCapability.configureSupportFootWear(false);
        deviceCapability.configureSupportRunPosture(false);
        deviceCapability.configureHeartRateRaiseAlarm(false);
        deviceCapability.configureGetHeartRateRaiseAlarmNumber(false);
        deviceCapability.configureGetHighAndMiddleSport(false);
        deviceCapability.setSupportDefaultSwitch(false);
        deviceCapability.configureHeartRateDownAlarm(false);
        deviceCapability.configureChangeAlarm(false);
        deviceCapability.configureSupportIntelligentHomeLinkage(false);
        deviceCapability.configureSyncBeforeOta(false);
        deviceCapability.configureIsSupportPhonesInfo(false);
        deviceCapability.configureIsSupportNotifyDeviceBroadCast(false);
        deviceCapability.configureSupportAtrialOperator(false);
        deviceCapability.configureSetHrrHeartRateCapability(false);
        deviceCapability.setSupportWatchFace(false);
        deviceCapability.setSupportMarketFace(false);
        deviceCapability.configureSupportInformCloseOrOpen(false);
        deviceCapability.configureIsSupportStressAppToDevice(false);
        deviceCapability.configureIsSupportMusicInfoList(false);
        deviceCapability.setSupportOneTouch(false);
        deviceCapability.setSupportTws(false);
        deviceCapability.configureSupportSleepBreathe(false);
        deviceCapability.configureSupportHiCarDriverRemind(false);
        deviceCapability.configureSupportMessageFeedback(false);
        deviceCapability.configureSupportWearStatus(false);
        deviceCapability.configureSupportPhd(false);
        deviceCapability.configureIsSupportAutoUpdate(false);
        deviceCapability.configureSupportGpsSearchStarOptimization(false);
        deviceCapability.configureIsSupportUpdateChange(false);
        deviceCapability.setSupportElectronicCard(false);
        deviceCapability.configureWeatherSupportFutureInfo(false);
        deviceCapability.configureSupportMenstrual(false);
        deviceCapability.configureSupportSosTransmission(false);
    }
}
