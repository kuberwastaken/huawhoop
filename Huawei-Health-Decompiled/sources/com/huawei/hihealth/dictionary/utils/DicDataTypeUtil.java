package com.huawei.hihealth.dictionary.utils;

import com.huawei.haf.bundle.extension.ComponentInfo;
import com.huawei.health.device.api.IndoorEquipManagerApi;
import com.huawei.hiai.awareness.AwarenessConstants;
import com.huawei.hihealth.dictionary.HiHealthDictManager;
import com.huawei.hihealth.dictionary.model.HealthDataStatPolicy;
import com.huawei.hihealth.dictionary.model.HiHealthDictField;
import com.huawei.hms.network.embedded.r3;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hwarkuix.oHBrigdePlugin.health.NativeInvokeEmotionBridge;
import com.huawei.hwarkuix.oHBrigdePlugin.health.NativeInvokeHeartRateBridge;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.operation.ble.BleConstants;
import com.huawei.operation.h5pro.jsmodules.device.MatterDataContans;
import com.huawei.operation.jsoperation.JsUtil;
import com.huawei.pluginachievement.manager.model.MedalConstants;
import health.compact.a.HuaweiHealth;
import health.compact.a.util.LogUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DicDataTypeUtil {
    private static HiHealthDictManager d;

    public static class BgRemindResult {
    }

    public static class Rri {
    }

    public static class ThirdWorkoutData {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(int i, String str) {
        HiHealthDictManager hiHealthDictManagerE = HiHealthDictManager.e(HuaweiHealth.b());
        d = hiHealthDictManagerE;
        hiHealthDictManagerE.e(false);
        HiHealthDictField hiHealthDictFieldE = d.e(i, str);
        if (hiHealthDictFieldE == null) {
            LogUtil.c("HiH_DicDataTypeUtil", "dictField is null, type id is ", Integer.valueOf(i), ", filedName is ", str);
            return -1;
        }
        return hiHealthDictFieldE.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, String str, String str2) {
        Objects.requireNonNull(d, "need execute getHealthType first!");
        return d.c(i, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, String str, double d2) {
        Objects.requireNonNull(d, "need execute getHealthType first!");
        return d.b(i, str, d2);
    }

    public static class NonDictDataTransUtil {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Map<Integer, String> f4295a;

        static {
            HashMap map = new HashMap(16);
            f4295a = map;
            map.put(300010035, "lthrHr");
            map.put(300010036, "lthrPace");
            map.put(300010037, "sportHeartPosture");
            map.put(300010038, "recoveryTime");
            map.put(300010039, "aerobicTime");
            map.put(300010040, "rhythmTime");
            map.put(300010041, "lactateTime");
            map.put(300010042, HwExerciseConstants.JSON_NAME_MAX_OXYGEN_TIME);
            map.put(300010043, HwExerciseConstants.JSON_NAME_ANAEROBIC_TIME);
            map.put(300010044, "spurtTime");
            map.put(300010048, "mAvgForeFootStrikePattern");
            map.put(300010049, "mAvgWholeFootStrikePattern");
            map.put(300010050, "mAvgHindFootStrikePattern");
            map.put(300010051, "mAvgGroundContactTime");
            map.put(300010052, "mAverageHangTime");
            map.put(300010053, "mGroundHangTimeRate");
            map.put(300010054, "mAvgEversionExcursion");
            map.put(300010055, "mAvgSwingAngle");
            map.put(300010056, "avg_i_p");
            map.put(300010057, "avg_v_i_r");
            map.put(300010058, "avg_gc_tb");
            map.put(300010059, "avg_v_osc");
            map.put(300010060, "avg_v_s_r");
            map.put(300010061, "recordFlag");
            map.put(300010079, "rowMachinePowerModeTime");
            map.put(300010100, "skipNum");
            map.put(300010101, "stumblingRope");
            map.put(300010102, "maxSkippingTimes");
            map.put(300010103, "skipSpeed");
            map.put(300010104, "interruptTimes");
            map.put(300010105, "singleShakeNum");
            map.put(300010106, "doubleShakeNum");
            map.put(300010107, "tripleShakeNum");
            map.put(300010108, "reversedSkipNum");
            map.put(300010109, "maxSkipSpeed");
            map.put(300010110, "minSkipSpeed");
            map.put(300010111, "targetDuration");
            map.put(300010112, "targetSkipNum");
            map.put(300010113, "targetSegmentNum");
            map.put(300010114, "targetSegmentDuration");
            map.put(300010115, "targetSegmentSkipNum");
            map.put(300010116, "skippingMode");
            map.put(300010117, "mWorkoutTypeOrigin");
            map.put(300010118, "maxSkipSpeedRank");
            map.put(300010119, "enduranceAbility");
            map.put(300010120, "enduranceAbilityRank");
            map.put(300010121, "enduranceTimeAbility");
            map.put(300010122, "enduranceTimeAbilityRank");
            map.put(300010123, "skipNumAbilityRank");
            map.put(300010124, "maxSkippingTimesAbilityRank");
            map.put(300010150, "avgHeartRate");
            map.put(300010151, "coordinate");
            map.put(300010152, "hotPathId");
            map.put(300010153, "hotPathName");
            map.put(300010154, "finishState");
            map.put(300010155, "cpPunchState");
            map.put(300010156, "routeType");
            map.put(300010157, "finishedGroups");
            map.put(300010158, "trainingActionCount");
            map.put(300010159, HwExerciseConstants.JSON_NAME_ACTIVECALORIE);
            map.put(300010202, "avgSlope");
            map.put(300010203, "maxSlope");
            map.put(300010204, "minSlope");
            map.put(300010205, "avgAnalogPower");
            map.put(300010206, "avgPower");
            map.put(300010207, "maxPower");
            map.put(300010208, "avgCadence");
            map.put(300010209, "maxCadence");
            map.put(300010212, "avgAnalogCadence");
            map.put(300010213, "avgPushFrequency");
            map.put(300010214, "avgPushDistance");
            map.put(300010215, "totalPushes");
            map.put(300010225, "analogRecoveryTime");
            map.put(300010226, "analogAerobicTime");
            map.put(300010227, "analogRhythmTime");
            map.put(300010228, "analogLactateTime");
            map.put(300010229, "analogMaxOxygenTime");
            map.put(300010230, "analogAnaerobicTime");
            map.put(300010231, "analogSpurtTime");
            map.put(300010224, "maxAnalogPower");
            map.put(300010216, "competitionId");
            map.put(300010217, "competitionCategory");
            map.put(300010218, "targetDistance");
            map.put(300010219, "targetTime");
            map.put(300010222, "aerobicLoadPeak");
            map.put(300010223, "anaerobicLoadPeak");
            map.put(300010232, "loadPeakLevel");
            map.put(300010301, "golfCourseName");
            map.put(300010302, "tripleBogey");
            map.put(300010303, "clubNumber");
            map.put(300010299, "avgFloorSpeed");
            map.put(300010242, "maxShotSpeed");
            map.put(300010243, "overhandStroke");
            map.put(300010244, "underhandStroke");
            map.put(300010245, "actionCount");
            map.put(300010246, "actionName");
            map.put(300010247, "totalTrainingVolume");
            map.put(300010248, "totalActionGroups");
            map.put(300010249, "trainingWeight");
            map.put(300010250, "rpe");
            map.put(300010251, "forehandDrop");
            map.put(300010252, "forehandBackspin");
            map.put(300010253, "forehandVolley");
            map.put(300010254, "forehandDrive");
            map.put(300010255, "backhandDrop");
            map.put(300010256, "backhandBackspin");
            map.put(300010257, "backhandVolley");
            map.put(300010258, "backhandDrive");
            map.put(300010259, "swingSpeed");
            map.put(300010260, "swingTimes");
            map.put(300010261, "maxContinuousRally");
            map.put(300010262, "serve");
            map.put(300010263, "forehand");
            map.put(300010264, "forehandTopspin");
            map.put(300010265, "forehandFlat");
            map.put(300010266, "forehandBackspin");
            map.put(300010267, "forehandVolley");
            map.put(300010268, "backhand");
            map.put(300010269, "backhandTopspin");
            map.put(300010270, "backhandBackspin");
            map.put(300010271, "backhandVolley");
            map.put(300010272, "swingTimes");
            map.put(300010273, "maxContinuousRally");
            map.put(300010274, "jumpTimes");
            map.put(300010275, "maxJumpHeight");
            map.put(300010276, "sprintTimes");
            map.put(300010277, "maxAcceleration");
            map.put(300010278, "turnSpeedUpTimes");
            map.put(300010279, "swerveSpeedUpTimes");
            map.put(300010280, "playerPosition");
            map.put(300010281, "goalsTimes");
            map.put(300010282, "assistsTimes");
            map.put(300010283, "savesTimes");
            map.put(300010300, "loadPeak");
        }

        private NonDictDataTransUtil() {
        }

        public static String e(int i) {
            return f4295a.get(Integer.valueOf(i));
        }
    }

    public enum DataType {
        BODY_TEMPERATURE_SET(400011),
        BODY_TEMPERATURE(DicDataTypeUtil.a(400011, "bodyTemperature")),
        MAX_BODY_TEMPERATURE(DicDataTypeUtil.b(400011, "bodyTemperature", "MAX")),
        MIN_BODY_TEMPERATURE(DicDataTypeUtil.b(400011, "bodyTemperature", "MIN")),
        AVG_BODY_TEMPERATURE(DicDataTypeUtil.b(400011, "bodyTemperature", HealthDataStatPolicy.AVG)),
        COUNT_BODY_TEMPERATURE(DicDataTypeUtil.b(400011, "bodyTemperature", HealthDataStatPolicy.COUNT)),
        SKIN_TEMPERATURE_SET(400012),
        SKIN_TEMPERATURE(DicDataTypeUtil.a(400012, "skinTemperature")),
        MAX_SKIN_TEMPERATURE(DicDataTypeUtil.b(400012, "skinTemperature", "MAX")),
        MIN_SKIN_TEMPERATURE(DicDataTypeUtil.b(400012, "skinTemperature", "MIN")),
        AVG_SKIN_TEMPERATURE(DicDataTypeUtil.b(400012, "skinTemperature", HealthDataStatPolicy.AVG)),
        COUNT_SKIN_TEMPERATURE(DicDataTypeUtil.b(400012, "skinTemperature", HealthDataStatPolicy.COUNT)),
        ENVIRONMENT_TEMPERATURE_SET(400013),
        ENVIRONMENT_TEMPERATURE(DicDataTypeUtil.a(400013, "environmentTemperature")),
        MAX_ENV_TEMPERATURE(DicDataTypeUtil.b(400013, "environmentTemperature", "MAX")),
        MIN_ENV_TEMPERATURE(DicDataTypeUtil.b(400013, "environmentTemperature", "MIN")),
        AVG_ENV_TEMPERATURE(DicDataTypeUtil.b(400013, "environmentTemperature", HealthDataStatPolicy.AVG)),
        COUNT_ENV_TEMPERATURE(DicDataTypeUtil.b(400013, "environmentTemperature", HealthDataStatPolicy.COUNT)),
        HIGH_BODY_TEMPERATURE_ALARM_SET(400014),
        HIGH_BODY_TEMPERATURE_ALARM(DicDataTypeUtil.a(400014, "highBodyTemperatureAlarm")),
        EMOTION_SET(NativeInvokeEmotionBridge.EMOTION_TYPE),
        EMOTION_STATUS(DicDataTypeUtil.a(NativeInvokeEmotionBridge.EMOTION_TYPE, "emotionStatus")),
        EMOTION_STATUS_ALL_COUNT(DicDataTypeUtil.b(NativeInvokeEmotionBridge.EMOTION_TYPE, "emotionStatus", HealthDataStatPolicy.COUNT)),
        EMOTION_STATUS_HAPPY_COUNT(DicDataTypeUtil.b(NativeInvokeEmotionBridge.EMOTION_TYPE, "emotionStatus", 3.0d)),
        EMOTION_STATUS_PEACE_COUNT(DicDataTypeUtil.b(NativeInvokeEmotionBridge.EMOTION_TYPE, "emotionStatus", 2.0d)),
        EMOTION_STATUS_UNHAPPY_COUNT(DicDataTypeUtil.b(NativeInvokeEmotionBridge.EMOTION_TYPE, "emotionStatus", 1.0d)),
        VALENCE_CHARACTER(DicDataTypeUtil.a(NativeInvokeEmotionBridge.EMOTION_TYPE, "valenceCharacter")),
        ORIGIN_STATUS(DicDataTypeUtil.a(NativeInvokeEmotionBridge.EMOTION_TYPE, "originStatus")),
        AROUSAL_CHARACTER(DicDataTypeUtil.a(NativeInvokeEmotionBridge.EMOTION_TYPE, "arousalCharacter")),
        OVARY_HEALTH_DAILY_STATUS_SET(500032),
        STATUS(DicDataTypeUtil.a(500032, "status")),
        PROGRESS(DicDataTypeUtil.a(500032, "progress")),
        OVARY_HEALTH_RESULT_SET(500033),
        PERIODIC_START_DATE(DicDataTypeUtil.a(500033, "periodicStartDate")),
        PERIODIC_END_DATE(DicDataTypeUtil.a(500033, "periodicEndDate")),
        RISK_LEVEL(DicDataTypeUtil.a(500033, "riskLevel")),
        SCORE(DicDataTypeUtil.a(500033, JsUtil.SCORE)),
        PCOS_RISK_LEVEL(DicDataTypeUtil.a(500033, "pcosRiskLevel")),
        LOW_BODY_TEMPERATURE_ALARM_SET(400015),
        LOW_BODY_TEMPERATURE_ALARM(DicDataTypeUtil.a(400015, "lowBodyTemperatureAlarm")),
        LOW_SKIN_TEMPERATURE_ALARM_SET(400016),
        LOW_SKIN_TEMPERATURE_ALARM(DicDataTypeUtil.a(400016, "lowSkinTemperatureAlarm")),
        SUSPECTED_HIGH_TEMPERATURE_ALARM_SET(400025),
        SUSPECTED_HIGH_TEMPERATURE_ALARM(DicDataTypeUtil.a(400025, "suspectedHighTemperatureAlarm")),
        SUSPECTED_HIGH_TEMPERATURE_SET(400026),
        SUSPECTED_HIGH_TEMPERATURE_VALUE(DicDataTypeUtil.a(400026, "highTemperature")),
        SUSPECTED_HIGH_TEMPERATURE(DicDataTypeUtil.a(400026, "suspectedHighTemperature")),
        MAX_SUSPECTED_HIGH_TEMPERATURE(DicDataTypeUtil.b(400026, "suspectedHighTemperature", "MAX")),
        MIN_SUSPECTED_HIGH_TEMPERATURE(DicDataTypeUtil.b(400026, "suspectedHighTemperature", "MIN")),
        BREATH_TRAIN_SET(500001),
        BREATH_TRAIN(DicDataTypeUtil.a(500001, "breathTrain")),
        CONTINUE_BLOODSUGAR_SET(500035),
        CONTINUE_BLOODSUGAR_VALUE(DicDataTypeUtil.a(500035, "continueBloodSugar")),
        CONTINUE_BLOODSUGAR_STATUS(DicDataTypeUtil.a(500035, "status")),
        URGENT_HYPOGLYCEMIA(500036),
        URGENT_HYPOGLYCEMIA_VALUE(DicDataTypeUtil.a(500036, "urgentHypoglycemia")),
        URGENT_HYPOGLYCEMIA_THRESHOLD(DicDataTypeUtil.a(500036, "urgentHypoglycemiaThreshold")),
        MAX_URGENT_HYPOGLYCEMIA(DicDataTypeUtil.b(500036, "urgentHypoglycemia", "MAX")),
        MIN_URGENT_HYPOGLYCEMIA(DicDataTypeUtil.b(500036, "urgentHypoglycemia", "MIN")),
        APPROACHING_HYPOGLYCEMIA(500037),
        APPROACHING_HYPOGLYCEMIA_VALUE(DicDataTypeUtil.a(500037, "approachingHypoglycemia")),
        APPROACHING_HYPOGLYCEMIA_THRESHOLD(DicDataTypeUtil.a(500037, "approachingHypoglycemiaThreshold")),
        MAX_APPROACHING_HYPOGLYCEMIA(DicDataTypeUtil.b(500037, "approachingHypoglycemia", "MAX")),
        MIN_APPROACHING_HYPOGLYCEMIA(DicDataTypeUtil.b(500037, "approachingHypoglycemia", "MIN")),
        HYPOGLYCEMIA(500038),
        HYPOGLYCEMIA_VALUE(DicDataTypeUtil.a(500038, "hypoglycemia")),
        HYPOGLYCEMIA_THRESHOLD(DicDataTypeUtil.a(500038, MatterDataContans.HYPOGLYCEMIA_THRESHOLD_KEY)),
        MAX_HYPOGLYCEMIA(DicDataTypeUtil.b(500038, "hypoglycemia", "MAX")),
        MIN_HYPOGLYCEMIA(DicDataTypeUtil.b(500038, "hypoglycemia", "MIN")),
        HYPERGLYCEMIA(500039),
        HYPERGLYCEMIA_VALUE(DicDataTypeUtil.a(500039, "hyperglycemia")),
        HYPERGLYCEMIA_THRESHOLD(DicDataTypeUtil.a(500039, MatterDataContans.HYPERGLYCEMIA_THRESHOLD_KEY)),
        MAX_HYPERGLYCEMIA(DicDataTypeUtil.b(500039, "hyperglycemia", "MAX")),
        MIN_HYPERGLYCEMIA(DicDataTypeUtil.b(500039, "hyperglycemia", "MIN")),
        BLOODSUGAR_RISE(500040),
        BLOODSUGAR_RISE_VALUE(DicDataTypeUtil.a(500040, "bloodGlucoseRise")),
        BLOODSUGAR_RISING_RATE(DicDataTypeUtil.a(500040, "bloodGlucoseRisingRate")),
        BLOODSUGAR_LOWER_THRESHOLD(DicDataTypeUtil.a(500040, "lowerThreshold")),
        MAX_BLOODSUGAR_RISE_VALUE(DicDataTypeUtil.b(500040, "bloodGlucoseRise", "MAX")),
        MIN_BLOODSUGAR_RISE_VALUE(DicDataTypeUtil.b(500040, "bloodGlucoseRise", "MIN")),
        MAX_BLOODSUGAR_RISING_RATE(DicDataTypeUtil.b(500040, "bloodGlucoseRisingRate", "MAX")),
        MIN_BLOODSUGAR_RISING_RATE(DicDataTypeUtil.b(500040, "bloodGlucoseRisingRate", "MIN")),
        BLOODSUGAR_DECREASE(500041),
        BLOODSUGAR_DECREASE_VALUE(DicDataTypeUtil.a(500041, "bloodGlucoseDecrease")),
        BLOODSUGAR_DECREASE_RATE(DicDataTypeUtil.a(500041, "bloodGlucoseDecreaseRate")),
        BLOODSUGAR_UPPER_THRESHOLD(DicDataTypeUtil.a(500041, "upperThreshold")),
        MAX_BLOODSUGAR_DECREASE_VALUE(DicDataTypeUtil.b(500041, "bloodGlucoseDecrease", "MAX")),
        MIN_BLOODSUGAR_DECREASE_VALUE(DicDataTypeUtil.b(500041, "bloodGlucoseDecrease", "MIN")),
        MAX_BLOODSUGAR_DECREASE_RATE(DicDataTypeUtil.b(500041, "bloodGlucoseDecreaseRate", "MAX")),
        MIN_BLOODSUGAR_DECREASE_RATE(DicDataTypeUtil.b(500041, "bloodGlucoseDecreaseRate", "MIN")),
        BLOOD_GLUCOSE_TREND_SET(500043),
        BLOOD_GLUCOSE_TREND(DicDataTypeUtil.a(500043, "bloodGlucoseTrend")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT(500045),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_Day_Sbp_Avg(DicDataTypeUtil.a(500045, "daySbpAvg")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_Day_Dbp_Avg(DicDataTypeUtil.a(500045, "dayDbpAvg")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_Day_Risk_Status(DicDataTypeUtil.a(500045, "dayRiskStatus")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_Night_Sbp_Avg(DicDataTypeUtil.a(500045, "nightSbpAvg")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_Night_Dbp_Avg(DicDataTypeUtil.a(500045, "nightDbpAvg")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_Night_Risk_Status(DicDataTypeUtil.a(500045, "nightRiskStatus")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_All_Sbp_Avg(DicDataTypeUtil.a(500045, "allSbpAvg")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_All_Dbp_Avg(DicDataTypeUtil.a(500045, "allDbpAvg")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_All_Risk_Status(DicDataTypeUtil.a(500045, "allRiskStatus")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_Bp_Risk_Res(DicDataTypeUtil.a(500045, "bpRiskRes")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_StartTime_Stamp(DicDataTypeUtil.a(500045, "startTimestamp")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_Alg_Type(DicDataTypeUtil.a(500045, "algType")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_EndTime_Stamp(DicDataTypeUtil.a(500045, "endTimestamp")),
        BLOODPRESSURE_RISK_RESEARCH_RESULT_RANGE(DicDataTypeUtil.a(500045, "range")),
        BLOODPRESSURE_RISK_RESULT(500046),
        BLOODPRESSURE_RISK_RESULT_Day_Sbp_Avg(DicDataTypeUtil.a(500046, "daySbpAvg")),
        BLOODPRESSURE_RISK_RESULT_Day_Dbp_Avg(DicDataTypeUtil.a(500046, "dayDbpAvg")),
        BLOODPRESSURE_RISK_RESULT_Day_Risk_Status(DicDataTypeUtil.a(500046, "dayRiskStatus")),
        BLOODPRESSURE_RISK_RESULT_Night_Sbp_Avg(DicDataTypeUtil.a(500046, "nightSbpAvg")),
        BLOODPRESSURE_RISK_RESULT_Night_Dbp_Avg(DicDataTypeUtil.a(500046, "nightDbpAvg")),
        BLOODPRESSURE_RISK_RESULT_Night_Risk_Status(DicDataTypeUtil.a(500046, "nightRiskStatus")),
        BLOODPRESSURE_RISK_RESULT_All_Sbp_Avg(DicDataTypeUtil.a(500046, "allSbpAvg")),
        BLOODPRESSURE_RISK_RESULT_All_Dbp_Avg(DicDataTypeUtil.a(500046, "allDbpAvg")),
        BLOODPRESSURE_RISK_RESULT_All_Risk_Status(DicDataTypeUtil.a(500046, "allRiskStatus")),
        BLOODPRESSURE_RISK_RESULT_Bp_Risk_Res(DicDataTypeUtil.a(500046, "bpRiskRes")),
        BLOODPRESSURE_RISK_RESULT_StartTime_Stamp(DicDataTypeUtil.a(500046, "startTimestamp")),
        BLOODPRESSURE_RISK_RESULT_Alg_Type(DicDataTypeUtil.a(500046, "algType")),
        BLOODPRESSURE_RISK_RESULT_EndTime_Stamp(DicDataTypeUtil.a(500046, "endTimestamp")),
        BLOODPRESSURE_RISK_RESULT_RANGE(DicDataTypeUtil.a(500046, "range")),
        AVERAGE_WRIST_TEMPERATURE_ALL_NIGHT(500048),
        AVERAGE_WRIST_TEMPERATURE_ALL_NIGHT_VALUE(DicDataTypeUtil.a(500048, "averageWristTemperatureAllNight")),
        AFIB_BURDEN_RESULT_RESEARCH(500051),
        AFIB_START_TIME_STAMP_VALUE(DicDataTypeUtil.a(500051, "startTimeStamp")),
        AFIB_NUM_VALUE(DicDataTypeUtil.a(500051, "afibNum")),
        AFIB_NORMAL_NUM_VALUE(DicDataTypeUtil.a(500051, "normalNum")),
        AFIB_MEASURE_NUM_VALUE(DicDataTypeUtil.a(500051, "measureNum")),
        AFIB_PERCENT_VALUE(DicDataTypeUtil.a(500051, "afibPercent")),
        AFIB_END_TIME_STAMP_VALUE(DicDataTypeUtil.a(500051, "endTimeStamp")),
        LIGHT_FASTING_SET(600001),
        LIGHT_FASTING(DicDataTypeUtil.a(600001, "lightFasting")),
        DIET_RECORD_SET(600002),
        DIET_RECORD(DicDataTypeUtil.a(600002, "dietRecord")),
        FASTING_LITE_PHASE_SET(600003),
        FASTINGLITE_STARTTIME(DicDataTypeUtil.a(600003, "fastingLiteStartTime")),
        FASTINGLITE_ENDTIME(DicDataTypeUtil.a(600003, "fastingLiteEndTime")),
        NEXT_EAT_WINDOW_TIME(DicDataTypeUtil.a(600003, "nextEatingWindowTime")),
        FASTINGLITE_IS_EATING(DicDataTypeUtil.a(600003, "fastingLiteIsEating")),
        FASTINGLITE_RECORD_ID(DicDataTypeUtil.a(600003, "recordId")),
        BLOOD_PRESSURE_SET(10002),
        BLOOD_PRESSURE_DIASTOLIC(DicDataTypeUtil.a(10002, "BLOOD_PRESSURE_DIASTOLIC")),
        BLOOD_PRESSURE_SYSTOLIC(DicDataTypeUtil.a(10002, "BLOOD_PRESSURE_SYSTOLIC")),
        BLOOD_PRESSURE_SPHYGMUS(DicDataTypeUtil.a(10002, BleConstants.BLOODPRESSURE_SPHYGMUS)),
        WEIGHT_BODYFAT_BROAD(10006),
        BODY_WEIGHT(DicDataTypeUtil.a(10006, "bodyWeight")),
        BODY_FAT_RATE(DicDataTypeUtil.a(10006, BleConstants.BODY_FAT_RATE)),
        BODY_FAT(DicDataTypeUtil.a(10006, "bodyFat")),
        IMPEDANCE(DicDataTypeUtil.a(10006, BleConstants.IMPEDANCE)),
        BMI(DicDataTypeUtil.a(10006, BleConstants.BMI)),
        MUSCLE_MASS(DicDataTypeUtil.a(10006, BleConstants.MUSCLE_MASS)),
        BASAL_METABOLISM(DicDataTypeUtil.a(10006, BleConstants.BASAL_METABOLISM)),
        MOISTURE(DicDataTypeUtil.a(10006, BleConstants.MOISTURE)),
        MOISTURE_RATE(DicDataTypeUtil.a(10006, BleConstants.MOISTURE_RATE)),
        VISCERAL_FAT_LEVEL(DicDataTypeUtil.a(10006, BleConstants.VISCERAL_FAT_LEVEL)),
        BONE_SALT(DicDataTypeUtil.a(10006, BleConstants.BONE_SALT)),
        PROTEIN_RATE(DicDataTypeUtil.a(10006, BleConstants.PROTEIN_RATE)),
        BODY_SCORE(DicDataTypeUtil.a(10006, BleConstants.BODY_SCORE)),
        BODY_AGE(DicDataTypeUtil.a(10006, BleConstants.BODY_AGE)),
        HEART_RATE(DicDataTypeUtil.a(10006, IndoorEquipManagerApi.KEY_HEART_RATE)),
        PRESSURE(DicDataTypeUtil.a(10006, "pressure")),
        SKELETAL_MUSCLEL_MASS(DicDataTypeUtil.a(10006, "skeletalMusclelMass")),
        GENDER(DicDataTypeUtil.a(10006, CommonConstant.KEY_GENDER)),
        AGE(DicDataTypeUtil.a(10006, "age")),
        HEIGHT(DicDataTypeUtil.a(10006, "height")),
        HEALTHY_WEIGHT(DicDataTypeUtil.a(10006, "healthyWeight")),
        HEALTHY_FATRATE(DicDataTypeUtil.a(10006, "healthyFatRate")),
        BODY_SIZE(DicDataTypeUtil.a(10006, "bodySize")),
        RIGHTLEG_MUSCLEMASS(DicDataTypeUtil.a(10006, "rightLegMuscleMass")),
        LEFTLEG_MUSCLEMASS(DicDataTypeUtil.a(10006, "leftLegMuscleMass")),
        RIGHTARM_MUSCLEMASS(DicDataTypeUtil.a(10006, "rightArmMuscleMass")),
        LEFTARM_MUSCLEMASS(DicDataTypeUtil.a(10006, "leftArmMuscleMass")),
        TRUNK_MUSCLEMASS(DicDataTypeUtil.a(10006, "trunkMuscleMass")),
        RIGHTLEG_FATMASS(DicDataTypeUtil.a(10006, "rightLegFatMass")),
        LEFTLEG_FATMASS(DicDataTypeUtil.a(10006, "leftLegFatMass")),
        RIGHTARM_FATMASS(DicDataTypeUtil.a(10006, "rightArmFatMass")),
        LEFTARM_FATMASS(DicDataTypeUtil.a(10006, "leftArmFatMass")),
        TRUNK_FATMASS(DicDataTypeUtil.a(10006, "trunkFatMass")),
        WAIST_HIPRATIO(DicDataTypeUtil.a(10006, "waistHipRatio")),
        WEIGHT_BODY_SHAPE(DicDataTypeUtil.a(10006, "bodyShape")),
        RASM(DicDataTypeUtil.a(10006, "rasm")),
        FAT_BALANCE(DicDataTypeUtil.a(10006, "fatBalance")),
        MUSCLE_BALANCE(DicDataTypeUtil.a(10006, "muscleBalance")),
        POLE(DicDataTypeUtil.a(10006, "pole")),
        LHRH_IMPEDANCE(DicDataTypeUtil.a(10006, "lhrhImpedance")),
        LHLF_IMPEDANCE(DicDataTypeUtil.a(10006, "lhlfImpedance")),
        LHRF_IMPEDANCE(DicDataTypeUtil.a(10006, "lhrfImpedance")),
        RHLF_IMPEDANCE(DicDataTypeUtil.a(10006, "rhlfImpedance")),
        RHRF_IMPEDANCE(DicDataTypeUtil.a(10006, "rhrfImpedance")),
        LFRF_IMPEDANCE(DicDataTypeUtil.a(10006, "lfrfImpedance")),
        WAIST_HIPRATIO_USER(DicDataTypeUtil.a(10006, "waistHipRatioUser")),
        LHRH_HF_IMPEDANCE(DicDataTypeUtil.a(10006, "lhrhHfImpedance")),
        LHLF_HF_IMPEDANCE(DicDataTypeUtil.a(10006, "lhlfHfImpedance")),
        LHRF_HF_IMPEDANCE(DicDataTypeUtil.a(10006, "lhrfHfImpedance")),
        RHLF_HF_IMPEDANCE(DicDataTypeUtil.a(10006, "rhlfHfImpedance")),
        RHRF_HF_IMPEDANCE(DicDataTypeUtil.a(10006, "rhrfHfImpedance")),
        LFRF_HF_IMPEDANCE(DicDataTypeUtil.a(10006, "lfrfHfImpedance")),
        CONFLICT_FLAG(DicDataTypeUtil.a(10006, "conflictFlag")),
        PROTEIN(DicDataTypeUtil.a(10006, "protein")),
        BLOOD_PRESSURE_REMINDER(DicDataTypeUtil.a(10002, "measurementReminder")),
        BLOOD_PRESSURE_ABNORMAL(DicDataTypeUtil.a(10002, "measurementAnomalyFlag")),
        BLOOD_BEFORE_ACTIVITY(DicDataTypeUtil.a(10002, "beforeMeasureActivity")),
        OSA_SET(500002),
        OSA_LEVEL(DicDataTypeUtil.a(500002, "osaLevel")),
        OSA_DETAIL_HALF_HOUR(DicDataTypeUtil.a(500002, "osaDetailHalfHour")),
        OSA_AVG_CNT_PER_HOUR(DicDataTypeUtil.a(500002, "osaAvgCntPerHour")),
        FATTY_LIVER_SET(500027),
        FATTY_LIVER_RISK(DicDataTypeUtil.a(500027, "fattyLiverRisk")),
        FATTY_LIVER_GRADE(DicDataTypeUtil.a(500027, "fattyLiverGrade")),
        MEDICATION_RULE(AwarenessConstants.ERROR_NO_PERMISSION_CODE),
        MEDICATION_RULE_ID(DicDataTypeUtil.a(AwarenessConstants.ERROR_NO_PERMISSION_CODE, "medicationRuleId")),
        MEDICATION_RULE_SOURCE(DicDataTypeUtil.a(AwarenessConstants.ERROR_NO_PERMISSION_CODE, "medicationRuleSource")),
        MEDICATION_RULE_DRUG(DicDataTypeUtil.a(AwarenessConstants.ERROR_NO_PERMISSION_CODE, "medicationRuleDrug")),
        MEDICATION_RULE_EXPECTED_TIME(DicDataTypeUtil.a(AwarenessConstants.ERROR_NO_PERMISSION_CODE, "medicationRuleExpectedTime")),
        MEDICATION_RULE_TYPE(DicDataTypeUtil.a(AwarenessConstants.ERROR_NO_PERMISSION_CODE, "medicationRuleType")),
        MEDICATION_RULE_START_TIME(DicDataTypeUtil.a(AwarenessConstants.ERROR_NO_PERMISSION_CODE, "medicationRuleStartTime")),
        MEDICATION_RULE_END_TIME(DicDataTypeUtil.a(AwarenessConstants.ERROR_NO_PERMISSION_CODE, "medicationRuleEndTime")),
        MEDICATION_RULE_NAME(DicDataTypeUtil.a(AwarenessConstants.ERROR_NO_PERMISSION_CODE, "medicationName")),
        MEDICATION_RULE_MARK(DicDataTypeUtil.a(AwarenessConstants.ERROR_NO_PERMISSION_CODE, "medicationMark")),
        MEDICATION_PUNCHING(AwarenessConstants.ERROR_INVALID_FREQUENCY_CODE),
        MEDICATION_PUNCH_SOURCE(DicDataTypeUtil.a(AwarenessConstants.ERROR_INVALID_FREQUENCY_CODE, "medicationPunchSource")),
        MEDICATION_PUNCH_TASK_ID(DicDataTypeUtil.a(AwarenessConstants.ERROR_INVALID_FREQUENCY_CODE, "medicationPunchTaskId")),
        MEDICATION_PUNCH_STATUS(DicDataTypeUtil.a(AwarenessConstants.ERROR_INVALID_FREQUENCY_CODE, "medicationPunchStatus")),
        MEDICATION_PUNCH_DRUG(DicDataTypeUtil.a(AwarenessConstants.ERROR_INVALID_FREQUENCY_CODE, "medicationPunchDrug")),
        MEDICATION_PUNCH_EXPECTED_TIME(DicDataTypeUtil.a(AwarenessConstants.ERROR_INVALID_FREQUENCY_CODE, "medicationPunchExpectedTime")),
        MEDICATION_PUNCH_TIME(DicDataTypeUtil.a(AwarenessConstants.ERROR_INVALID_FREQUENCY_CODE, "medicationPunchTime")),
        ENVIRONMENT_NOISE_TYPE(700001),
        ARRHYTHMIA_PPG_TYPE(NativeInvokeHeartRateBridge.DATA_SEQUENCE_PPG_OF_ARRHYTHMIA),
        DYNAMIC_BP_REPORT(700019),
        COURSE_RECORD(700014),
        MEDICAL_EXAM_REPORT(700017),
        MEDICAL_EXAM_REPORT_RESEARCH(700022),
        CORONARY_HEART_DISEASE_RISK_STUDY(700023),
        CORONARY_ASSESS_RESULT_TYPE_VALUE(DicDataTypeUtil.a(700023, "assessResultType")),
        CORONARY_ASSESS_ECG_COUNT_VALUE(DicDataTypeUtil.a(700023, "assessEcgCount")),
        CORONARY_RESERVED_VALUE(DicDataTypeUtil.a(700023, "reserved")),
        RRI(700021),
        MINDFULNESS_TYPE(700011),
        VENTILATOR_RECORD_TYPE(700012),
        ELECTROCARDIOGRAM(NativeInvokeHeartRateBridge.DATA_SEQUENCE_ELECTROCARDIOGRAM),
        LAKELOUISE_AMS_SCORE_SET(500006),
        LAKELOUISE_HEADACHE(DicDataTypeUtil.a(500006, "headache")),
        LAKELOUISE_STOMACHACHE(DicDataTypeUtil.a(500006, "stomachache")),
        LAKELOUISE_WEAK(DicDataTypeUtil.a(500006, "weak")),
        LAKELOUISE_SCORE(DicDataTypeUtil.a(500006, "lakeLouiseScore")),
        LAKELOUISE_DIZZINESS(DicDataTypeUtil.a(500006, "dizziness")),
        SLEEP_DETAILS(700013),
        SLEEP_RDI(DicDataTypeUtil.a(700013, "rdi")),
        SLEEP_DATA_QUALITY(DicDataTypeUtil.a(700013, "sleepDataQuality")),
        DEEP_PART(DicDataTypeUtil.a(700013, "deepPart")),
        SNORE_FREQ(DicDataTypeUtil.a(700013, "snoreFreq")),
        SLEEP_LATENCY(DicDataTypeUtil.a(700013, "sleepLatency")),
        SLEEPDETAILS_WAKE_COUNT(DicDataTypeUtil.a(700013, "wakeCount")),
        SLEEPDETAILS_SLEEP_SCORE(DicDataTypeUtil.a(700013, "sleepScore")),
        TURNOVER_COUNT(DicDataTypeUtil.a(700013, "turnOverCount")),
        SLEEPDETAILS_BED_TIME(DicDataTypeUtil.a(700013, "bedTime")),
        SLEEPDETAILS_RISING_TIME(DicDataTypeUtil.a(700013, "risingTime")),
        FALLASLEEP_TIME(DicDataTypeUtil.a(700013, "fallAsleepTime")),
        SLEEPDETAILS_WAKEUP_TIME(DicDataTypeUtil.a(700013, "wakeupTime")),
        SLEEPDETAILS_PREPARE_SLEEP_TIME(DicDataTypeUtil.a(700013, "prepareSleepTime")),
        SLEEP_DETAILS_SLEEP_EFFICIENCY(DicDataTypeUtil.a(700013, "sleepEfficiency")),
        SLEEP_DETAILS_VALID_DATA(DicDataTypeUtil.a(700013, "validData")),
        SLEEP_DETAILS_MIN_HEARTRATE(DicDataTypeUtil.a(700013, "minHeartrate")),
        SLEEP_DETAILS_MAX_HEARTRATE(DicDataTypeUtil.a(700013, "maxHeartrate")),
        SLEEP_DETAILS_MIN_OXYGEN_SATURATION(DicDataTypeUtil.a(700013, "minOxygenSaturation")),
        SLEEP_DETAILS_MAX_OXYGEN_SATURATION(DicDataTypeUtil.a(700013, "maxOxygenSaturation")),
        SLEEP_DETAILS_MIN_BREATHRATE(DicDataTypeUtil.a(700013, "minBreathrate")),
        SLEEP_DETAILS_MAX_BREATHRATE(DicDataTypeUtil.a(700013, "maxBreathrate")),
        SLEEP_DETAILS_WAKEUP_FEELING(DicDataTypeUtil.a(700013, "wakeUpFeeling")),
        SLEEP_DETAILS_AVG_HEARTRATE(DicDataTypeUtil.a(700013, "avgHeartrate")),
        SLEEP_DETAILS_MIN_HEARTRATE_BASELINE(DicDataTypeUtil.a(700013, "minHeartrateBaseline")),
        SLEEP_DETAILS_MAX_HEARTRATE_BASELINE(DicDataTypeUtil.a(700013, "maxHeartrateBaseline")),
        SLEEP_DETAILS_HEARTRATE_DAY_TO_BASELINE(DicDataTypeUtil.a(700013, "heartrateDayToBaseline")),
        SLEEP_DETAILS_AVG_OXYGEN_SATURATION(DicDataTypeUtil.a(700013, "avgOxygenSaturation")),
        SLEEP_DETAILS_MIN_OXYGEN_SATURATION_BASELINE(DicDataTypeUtil.a(700013, "minOxygenSaturationBaseline")),
        SLEEP_DETAILS_MAX_OXYGEN_SATURATION_BASELINE(DicDataTypeUtil.a(700013, "maxOxygenSaturationBaseline")),
        SLEEP_DETAILS_OXYGEN_SATURATION_DAY_TO_BASELINE(DicDataTypeUtil.a(700013, "oxygenSaturationDayToBaseline")),
        SLEEP_DETAILS_AVG_BREATHRATE(DicDataTypeUtil.a(700013, "avgBreathrate")),
        SLEEP_DETAILS_MIN_BREATHRATE_BASELINE(DicDataTypeUtil.a(700013, "minBreathrateBaseline")),
        SLEEP_DETAILS_MAX_BREATHRATE_BASELINE(DicDataTypeUtil.a(700013, "maxBreathrateBaseline")),
        SLEEP_DETAILS_BREATHRATE_DAY_TO_BASELINE(DicDataTypeUtil.a(700013, "breathrateDayToBaseline")),
        SLEEP_DETAILS_AVG_HRV(DicDataTypeUtil.a(700013, "avgHrv")),
        SLEEP_DETAILS_MIN_HRV_BASELINE(DicDataTypeUtil.a(700013, "minHrvBaseline")),
        SLEEP_DETAILS_MAX_HRV_BASELINE(DicDataTypeUtil.a(700013, "maxHrvBaseline")),
        SLEEP_DETAILS_HRV_DAY_TO_BASELINE(DicDataTypeUtil.a(700013, "hrvDayToBaseline")),
        SLEEP_DETAILS_STABLE_SLEEP_RATIO(DicDataTypeUtil.a(700013, "stableSleepRatio")),
        THIRD_WORKOUT_DETAILS(30001),
        ARRHYTHMIA_RESULT_TYPE(500007),
        ARRHYTHMIA_SAVE_TIME(DicDataTypeUtil.a(500007, "saveTime")),
        ARRHYTHMIA_MEASURE_TYPE(DicDataTypeUtil.a(500007, "measureType")),
        PPG_IRREGULAR_HEARTBEAT(DicDataTypeUtil.a(500007, "ppgIrregularHeartbeat")),
        SLEEP_ON_OFF_BED_RECORD(500010),
        SLEEP_ON_OFF_BED_RECORD_BED_TIME(DicDataTypeUtil.a(500010, "bedTime")),
        SLEEP_ON_OFF_BED_RECORD_RISING_TIME(DicDataTypeUtil.a(500010, "risingTime")),
        SLEEP_ON_OFF_BED_RECORD_FALL_ASLEEP_TIME(DicDataTypeUtil.a(500010, "fallAsleepTime")),
        SLEEP_ON_OFF_BED_RECORD_WAKEUP_TIME(DicDataTypeUtil.a(500010, "wakeupTime")),
        PHYSIOLOGICAL_CYCLE(400018),
        PHYSIOLOGICAL_CYCLE_MOOD(DicDataTypeUtil.a(400018, "mood")),
        PHYSIOLOGICAL_CYCLE_SKIN(DicDataTypeUtil.a(400018, "skin")),
        PHYSIOLOGICAL_CYCLE_SEXUALITY(DicDataTypeUtil.a(400018, "sexuality")),
        PHYSIOLOGICAL_CYCLE_OVULATION(DicDataTypeUtil.a(400018, "ovulationTestPaper")),
        PHYSIOLOGICAL_CYCLE_REMARKS(DicDataTypeUtil.a(400018, "remarks")),
        PHYSIOLOGICAL_CYCLE_MUCUS(DicDataTypeUtil.a(400018, "cervicalMucus")),
        PHYSIOLOGICAL_CYCLE_QUANTITY(DicDataTypeUtil.a(400018, "quantity")),
        PHYSIOLOGICAL_CYCLE_DYSMENORRHEA(DicDataTypeUtil.a(400018, "dysmenorrhea")),
        BODY_SHAPE(400020),
        BODY_SHAPE_BUST_GIRTH(DicDataTypeUtil.a(400020, "bustGirth")),
        BODY_SHAPE_WAIST_GIRTH(DicDataTypeUtil.a(400020, "waistGirth")),
        BODY_SHAPE_HIPLINE(DicDataTypeUtil.a(400020, "hipline")),
        BODY_SHAPE_THIGH_GIRTH(DicDataTypeUtil.a(400020, "thighGirth")),
        BODY_SHAPE_CALVES(DicDataTypeUtil.a(400020, "calves")),
        BODY_SHAPE_ARM_CIRCUMFERENCE(DicDataTypeUtil.a(400020, "armCircumference")),
        BODY_SHAPE_HEAD_CIRCUMFERENCE(DicDataTypeUtil.a(400020, "headCircumference")),
        BODY_SHAPE_LEG_LENGTH(DicDataTypeUtil.a(400020, "legLength")),
        BODY_SHAPE_ARM_LENGTH(DicDataTypeUtil.a(400020, "armLength")),
        BODY_SHAPE_SHOULDER_WIDTH(DicDataTypeUtil.a(400020, "shoulderWidth")),
        BODY_SHAPE_WAIST_HIP_RATIO(DicDataTypeUtil.a(400020, "waistHipRatio")),
        BODY_SHAPE_BODY_FORM(DicDataTypeUtil.a(400020, "bodyForm")),
        BODY_SHAPE_USER_MODIFY_VALUE(DicDataTypeUtil.a(400020, "userModifyValue")),
        ALTITUDE_TYPE_SET(AwarenessConstants.ERROR_TIMEOUT_CODE),
        ALTITUDE_TYPE(DicDataTypeUtil.a(AwarenessConstants.ERROR_TIMEOUT_CODE, "altitude")),
        RESTING_METABOLISM_SET(500018),
        RESTING_METABOLISM(DicDataTypeUtil.a(500018, BleConstants.BASAL_METABOLISM)),
        CURRENT_BASAL_METABOLISM_SET(500019),
        CURRENT_BASAL_METABOLISM(DicDataTypeUtil.a(500019, "currentBasalMetabolism")),
        BASAL_METABOLISM_AFTER_EXERCISE_SET(500025),
        BASAL_METABOLISM_AFTER_EXERCISE(DicDataTypeUtil.a(500025, "basalMetabolismAfterExercise")),
        DRINK_WATER_SET(AwarenessConstants.ERROR_UNKNOWN_CODE),
        DRINK_WATER(DicDataTypeUtil.a(AwarenessConstants.ERROR_UNKNOWN_CODE, "drinkWater")),
        ACTIVE_HOUR(AwarenessConstants.ERROR_LIMITED_REGISTRY_CODE),
        ACTIVE_HOUR_IS_ACTIVE(DicDataTypeUtil.a(AwarenessConstants.ERROR_LIMITED_REGISTRY_CODE, r3.B)),
        ACTIVE_HOUR_IS_ACTIVE_COUNT(DicDataTypeUtil.b(AwarenessConstants.ERROR_LIMITED_REGISTRY_CODE, r3.B, HealthDataStatPolicy.COUNT)),
        PHYSIOLOGICAL_CYCLE_BUSINESS(400019),
        PHYSIOLOGICAL_CYCLE_LINKAGES(DicDataTypeUtil.a(400019, "linkages")),
        GOLF_COURSE_MODEL_TYPE(30287),
        GOLF_COURSE_MODEL_SPORT_TYPE(286),
        ONE_SECOND_SPORT_DATA_TYPE(34001),
        ONE_SECOND_SPORT_DATA_TYPE_BIKE(34260),
        ONE_SECOND_SPORT_DATA_TYPE_INDOOR_BIKE(34266),
        ONE_SECOND_SPORT_DATA_TYPE_RUN(34259),
        ONE_SECOND_SPORT_DATA_TYPE_TREADMILL(34265),
        ONE_SECOND_SPORT_DATA_TYPE_MARATHON(34228),
        AVG_GOLF_SWING_COUNT(DicDataTypeUtil.b(30287, "golfSwingCount", HealthDataStatPolicy.AVG)),
        SUM_GOLF_SWING_COUNT(DicDataTypeUtil.b(30287, "golfSwingCount", HealthDataStatPolicy.SUM)),
        AVG_PUTTS(DicDataTypeUtil.b(30287, "putts", HealthDataStatPolicy.AVG)),
        AVG_GIR(DicDataTypeUtil.b(30287, "gir", HealthDataStatPolicy.AVG)),
        SUM_PAR(DicDataTypeUtil.b(30287, "par", HealthDataStatPolicy.SUM)),
        SUM_EAGLE(DicDataTypeUtil.b(30287, "eagle", HealthDataStatPolicy.SUM)),
        SUM_BIRDIE(DicDataTypeUtil.b(30287, "birdie", HealthDataStatPolicy.SUM)),
        SENSE_SPORT_TYPE(30291),
        SENSE_SPORT_SPORT_TYPE(290),
        SLEEP_RECORD(500005),
        SLEEP_SCORE(DicDataTypeUtil.a(500005, "sleepScore")),
        WAKE_COUNT(DicDataTypeUtil.a(500005, "wakeCount")),
        TURN_OVER_COUNT(DicDataTypeUtil.a(500005, "turnOverCount")),
        BED_TIME(DicDataTypeUtil.a(500005, "bedTime")),
        RISING_TIME(DicDataTypeUtil.a(500005, "risingTime")),
        SLEEP_END_REASON(DicDataTypeUtil.a(500005, "sleepEndReason")),
        SLEEP_SYMPTOMS(DicDataTypeUtil.a(500005, "sleepSymptoms")),
        EFFECTIVE_SLEEP_DURATION(DicDataTypeUtil.a(500005, "effectiveSleepDuration")),
        EFFECTIVE_SLEEP_CYCLES(DicDataTypeUtil.a(500005, "effectiveSleepCycles")),
        WAKE_UP_FEELING(DicDataTypeUtil.a(500005, "wakeUpFeeling")),
        NOON_SLEEP_INFO(DicDataTypeUtil.a(500005, "noonSleepInfo")),
        FALL_ASLEEP_TIME(DicDataTypeUtil.a(500005, "fallAsleepTime")),
        WAKEUP_TIME(DicDataTypeUtil.a(500005, "wakeupTime")),
        PREPARE_SLEEP_TIME(DicDataTypeUtil.a(500005, "prepareSleepTime")),
        DAILY_SLEEP_PROBLEM(DicDataTypeUtil.a(500005, "dailySleepProblem")),
        DAILY_SLEEP_DEGREE(DicDataTypeUtil.a(500005, "dailySleepDegree")),
        DAILY_SLEEP_INTERPRET(DicDataTypeUtil.a(500005, "dailySleepInterpretParam")),
        DAILY_TARGET_PROBLEM(DicDataTypeUtil.a(500005, "dailyTargetProblem")),
        DAILY_SLEEP_TASKS(DicDataTypeUtil.a(500005, "dailySleepTasks")),
        SLEEP_RECORD_QUALITY(DicDataTypeUtil.a(500005, "sleepRecordQuality")),
        DAY_SLEEP_RECORD_QUALITY(DicDataTypeUtil.b(500005, "sleepRecordQuality", "MIN")),
        DAILY_SLEEP_LATENCY(DicDataTypeUtil.a(500005, "latency")),
        MONTHLY_SLEEP(500013),
        RHYTHM_TYPE(DicDataTypeUtil.a(500013, "rhythmType")),
        MONTHLY_SLEEP_PROBLEM(DicDataTypeUtil.a(500013, "monthlySleepProblem")),
        MONTHLY_SLEEP_DEGREE(DicDataTypeUtil.a(500013, "monthlySleepDegree")),
        MONTHLY_SLEEP_TASKS(DicDataTypeUtil.a(500013, "monthlySleepTasks")),
        MONTHLY_SLEEP_INTERPRET(DicDataTypeUtil.a(500013, "monthlySleepInterpretParam")),
        BG_DAILY_RESULT(500012),
        BG_DAILY_RESULT_TIMESTAMP(DicDataTypeUtil.a(500012, "timestamp")),
        BG_DAILY_RESULT_TOTAL_NUMS(DicDataTypeUtil.a(500012, "totalNums")),
        BG_DAILY_RESULT_ABNORMAL_NUMS(DicDataTypeUtil.a(500012, "abnormalNums")),
        BG_DAILY_SLP_RESULT(500015),
        BG_REMIND(500029),
        BG_REMIND_VALUE(DicDataTypeUtil.a(500029, "bloodGlucoseRemind")),
        BG_COUNT_BLOOD_REMIND(DicDataTypeUtil.b(500029, "countBloodRemind", HealthDataStatPolicy.COUNT)),
        BG_REMIND_TYPE(DicDataTypeUtil.a(500029, "RemindType")),
        BG_REMIND_THRESHOLD(DicDataTypeUtil.a(500029, "RemindThreshold")),
        BG_DAILY_SLP_RESULT_SLP_START_TIME(DicDataTypeUtil.a(500015, "slpStartTime")),
        BG_DAILY_SLP_RESULT_SLP_END_TIME(DicDataTypeUtil.a(500015, "slpEndTime")),
        BG_DAILY_SLP_RESULT_TOTAL_NUMS(DicDataTypeUtil.a(500015, "totalNums")),
        BG_DAILY_SLP_RESULT_ABNORMAL_NUMS(DicDataTypeUtil.a(500015, "abnormalNums")),
        BG_RISK_GROUP_RESULT(500014),
        BG_RISK_GROUP_RESULT_START_TIMESTAMP(DicDataTypeUtil.a(500014, "startTimestamp")),
        BG_RISK_GROUP_RESULT_END_TIMESTAMP(DicDataTypeUtil.a(500014, "endTimestamp")),
        BG_RISK_GROUP_RESULT_RISK_LEVEL(DicDataTypeUtil.a(500014, "riskLevel")),
        SPORT_BLOOD_PRESSURE_RESULT(500034),
        CARDIOVASCULAR_RISK_LEVEL_SBR(DicDataTypeUtil.a(500034, "cardiovascularRiskLevel")),
        BLOOD_PRESSUE_RISK(DicDataTypeUtil.a(500034, "bloodPressureRisk")),
        PERCEIVED_EXERTION(DicDataTypeUtil.a(500034, "perceivedExertion")),
        SYMPTOM(DicDataTypeUtil.a(500034, "symptom")),
        ECG_RESULT(DicDataTypeUtil.a(500034, "ecgResult")),
        ECG_AVG_HEART_RATE(DicDataTypeUtil.a(500034, "ecgAvgHeartRate")),
        SBP_BEFORE_SPORT(DicDataTypeUtil.a(500034, "sbpBeforeSport")),
        DBP_BEFORE_SPORT(DicDataTypeUtil.a(500034, "dbpBeforeSport")),
        SBP_AFTER_SPORT(DicDataTypeUtil.a(500034, "sbpAfterSport")),
        DBP_AFTER_SPORT(DicDataTypeUtil.a(500034, "dbpAfterSport")),
        SBP_AFTER_SPORT_THREE_MIN(DicDataTypeUtil.a(500034, "sbpAfterSportThreeMin")),
        DBP_AFTER_SPORT_THREE_MIN(DicDataTypeUtil.a(500034, "dbpAfterSportThreeMin")),
        SBP_AFTER_SPORT_SIX_MIN(DicDataTypeUtil.a(500034, "sbpAfterSportSixMin")),
        DBP_AFTER_SPORT_SIX_MIN(DicDataTypeUtil.a(500034, "dbpAfterSportSixMin")),
        SPORT_TYPE(DicDataTypeUtil.a(500034, BleConstants.SPORT_TYPE)),
        TOTAL_DISTANCE(DicDataTypeUtil.a(500034, BleConstants.TOTAL_DISTANCE)),
        TOTAL_TIME(DicDataTypeUtil.a(500034, "totalTime")),
        AVG_PACE(DicDataTypeUtil.a(500034, "avgPace")),
        AVG_HEART_RATE(DicDataTypeUtil.a(500034, "avgHeartRate")),
        MAX_HEART_RATE(DicDataTypeUtil.a(500034, "maxHeartRate")),
        START_TIME_STAMP(DicDataTypeUtil.a(500034, "startTimestamp")),
        END_TIME_STAMP(DicDataTypeUtil.a(500034, "endTimestamp")),
        BP_LABEL(DicDataTypeUtil.a(500034, "bpLabel")),
        ECG_START_TIME(DicDataTypeUtil.a(500034, "ecgStartTime")),
        ECG_END_TIME(DicDataTypeUtil.a(500034, "ecgEndTime")),
        BP_BEFORE_SPORT_TIME(DicDataTypeUtil.a(500034, "bpBeforeSportTime")),
        BP_AFTER_SPORT_TIME(DicDataTypeUtil.a(500034, "bpAfterSportTime")),
        BP_AFTER_SPORT_THREE_MIN_TIME(DicDataTypeUtil.a(500034, "bpAfterSportThreeMinTime")),
        BP_AFTER_SPORT_SIX_MIN_TIME(DicDataTypeUtil.a(500034, "bpAfterSportSixMinTime")),
        VASCULAR_HEALTH(NativeInvokeHeartRateBridge.DATA_VASCULAR_HEALTH),
        PULSE_WAVE_VELOCITY(DicDataTypeUtil.a(NativeInvokeHeartRateBridge.DATA_VASCULAR_HEALTH, "pulseWaveVelocity")),
        VASCULAR_PULSE(DicDataTypeUtil.a(NativeInvokeHeartRateBridge.DATA_VASCULAR_HEALTH, "vascularPulse")),
        ARTERIAL_ELASTICITY(DicDataTypeUtil.a(NativeInvokeHeartRateBridge.DATA_VASCULAR_HEALTH, "arterialElasticity")),
        ACTIVITY_RECORD(DicDataTypeUtil.a(NativeInvokeHeartRateBridge.DATA_VASCULAR_HEALTH, "activityRecord")),
        VASCULAR_AGE(DicDataTypeUtil.a(NativeInvokeHeartRateBridge.DATA_VASCULAR_HEALTH, "vascularAge")),
        CARDIOVASCULAR_RISK_LEVEL(DicDataTypeUtil.a(NativeInvokeHeartRateBridge.DATA_VASCULAR_HEALTH, "cardiovascularRiskLevel")),
        VASCULAR_HEALTH_HEART_RATE_VARIABILITY(DicDataTypeUtil.a(NativeInvokeHeartRateBridge.DATA_VASCULAR_HEALTH, "heartRateVariability")),
        VASCULAR_HEALTH_RESULT(400023),
        PULSE_WAVE_VELOCITY_RES(DicDataTypeUtil.a(400023, "pulseWaveVelocity")),
        VASCULAR_PULSE_RES(DicDataTypeUtil.a(400023, "vascularPulse")),
        ARTERIAL_ELASTICITY_RES(DicDataTypeUtil.a(400023, "arterialElasticity")),
        ACTIVITY_RECORD_RES(DicDataTypeUtil.a(400023, "activityRecord")),
        VASCULAR_AGE_RES(DicDataTypeUtil.a(400023, "vascularAge")),
        CARDIOVASCULAR_RISK_LEVEL_RES(DicDataTypeUtil.a(400023, "cardiovascularRiskLevel")),
        HEART_RATE_VARIABILITY_RES(DicDataTypeUtil.a(400023, "heartRateVariability")),
        ECG_START_TIME_RES(DicDataTypeUtil.a(400023, "ecgStartTime")),
        ECG_END_TIME_RES(DicDataTypeUtil.a(400023, "ecgEndTime")),
        RISK(DicDataTypeUtil.a(400023, "risk")),
        PPG_OF_VASCULAR_HEALTH(700002),
        ECG_OF_VASCULAR_HEALTH(700003),
        SPO2_RESP_INFECTION(700005),
        RRI_RESP_INFECTION(700006),
        BG_DAILY_PROB_WIN(700015),
        BG_COMBINED_PPG_FEATURE(700016),
        MARK_POINT(700018),
        TEMPERATURE_RESP_INFECTION(700007),
        SLEEP_FRAGMENT_RESP_INFECTION(700008),
        CNTBPORIGINPPGDATA(700010),
        DIVING_TYPE(30288),
        DIVING_SPORT_TYPE(287),
        SCUBA_DIVING_TYPE(30292),
        SCUBA_DIVING_SPORT_TYPE(ComponentInfo.PluginPay_A_N),
        BREATH_HOLDING_TRAIN_TYPE(30289),
        BREATH_HOLDING_TRAIN_SPORT_TYPE(288),
        BREATH_HOLDING_TEST_TYPE(30290),
        BREATH_HOLDING_TEST_SPORT_TYPE(289),
        ADVENTURES_TYPE(30223),
        ADVENTURES_SPORT_TYPE(222),
        SPORT_GOAL_ACHIEVEMENT_DATA(300002),
        SPORT_GOAL_ACHIEVEMENT_DATA_STEP_GOAL_VALUE(DicDataTypeUtil.a(300002, "stepGoalValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_STEP_USER_VALUE(DicDataTypeUtil.a(300002, "stepUserValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_STEP_GOAL_STATE(DicDataTypeUtil.a(300002, "stepGoalState")),
        SPORT_GOAL_ACHIEVEMENT_DATA_STEP_IS_RING(DicDataTypeUtil.a(300002, "stepIsRing")),
        SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_GOAL_VALUE(DicDataTypeUtil.a(300002, "calorieGoalValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_USER_VALUE(DicDataTypeUtil.a(300002, "calorieUserValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_GOAL_STATE(DicDataTypeUtil.a(300002, "calorieGoalState")),
        SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_IS_RING(DicDataTypeUtil.a(300002, "calorieIsRing")),
        SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_GOAL_VALUE(DicDataTypeUtil.a(300002, "durationGoalValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_USER_VALUE(DicDataTypeUtil.a(300002, "durationUserValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_GOAL_STATE(DicDataTypeUtil.a(300002, "durationGoalState")),
        SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_IS_RING(DicDataTypeUtil.a(300002, "durationIsRing")),
        SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_GOAL_VALUE(DicDataTypeUtil.a(300002, "activeGoalValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_USER_VALUE(DicDataTypeUtil.a(300002, "activeUserValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_GOAL_STATE(DicDataTypeUtil.a(300002, "activeGoalState")),
        SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_IS_RING(DicDataTypeUtil.a(300002, "activeIsRing")),
        SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_IS_RING_NEW(DicDataTypeUtil.a(300002, "calorieIsRingNew")),
        SPORT_GOAL_ACHIEVEMENT_DATA_CLIMB_USER_VALUE(DicDataTypeUtil.a(300002, "climbUserValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_DISTANCE_USER_VALUE(DicDataTypeUtil.a(300002, "distanceUserValue")),
        SPORT_GOAL_ACHIEVEMENT_DATA_PUSHES_VAL(DicDataTypeUtil.a(300002, "pushesVal")),
        SPORT_GOAL_ACHIEVEMENT_DATA_MICRO_WORKOUT(DicDataTypeUtil.a(300002, "microWorkout")),
        SPORT_GOAL_ACHIEVEMENT_DATA_STEP_GOAL_VALUE_STAT(DicDataTypeUtil.b(300002, "stepGoalValue", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_STEP_USER_VALUE_STAT(DicDataTypeUtil.b(300002, "stepUserValue", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_STEP_GOAL_STATE_STAT(DicDataTypeUtil.b(300002, "stepGoalState", "MAX")),
        SPORT_GOAL_ACHIEVEMENT_DATA_STEP_IS_RING_STAT(DicDataTypeUtil.b(300002, "stepIsRing", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_GOAL_VALUE_STAT(DicDataTypeUtil.b(300002, "calorieGoalValue", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_USER_VALUE_STAT(DicDataTypeUtil.b(300002, "calorieUserValue", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_GOAL_STATE_STAT(DicDataTypeUtil.b(300002, "calorieGoalState", "MAX")),
        SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_IS_RING_STAT(DicDataTypeUtil.b(300002, "calorieIsRingNew", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_GOAL_VALUE_STAT(DicDataTypeUtil.b(300002, "durationGoalValue", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_USER_VALUE_STAT(DicDataTypeUtil.b(300002, "durationUserValue", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_GOAL_STATE_STAT(DicDataTypeUtil.b(300002, "durationGoalState", "MAX")),
        SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_IS_RING_STAT(DicDataTypeUtil.b(300002, "durationIsRing", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_GOAL_VALUE_STAT(DicDataTypeUtil.b(300002, "activeGoalValue", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_USER_VALUE_STAT(DicDataTypeUtil.b(300002, "activeUserValue", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_GOAL_STATE_STAT(DicDataTypeUtil.b(300002, "activeGoalState", "MAX")),
        SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_IS_RING_STAT(DicDataTypeUtil.b(300002, "activeIsRing", HealthDataStatPolicy.LAST)),
        SPORT_GOAL_ACHIEVEMENT_DATA_PUSHES_VAL_STAT(DicDataTypeUtil.b(300002, "pushesVal", HealthDataStatPolicy.LAST)),
        ALTITUDE_MAX_STAT(DicDataTypeUtil.b(AwarenessConstants.ERROR_TIMEOUT_CODE, "altitude", "MAX")),
        ALTITUDE_MIN_STAT(DicDataTypeUtil.b(AwarenessConstants.ERROR_TIMEOUT_CODE, "altitude", "MIN")),
        DAILY_ACTIVITY_RECORD(300003),
        DAILY_ACTIVITY_RECORD_STEPS(DicDataTypeUtil.a(300003, MedalConstants.EVENT_STEPS)),
        DAILY_ACTIVITY_RECORD_CALORIE(DicDataTypeUtil.a(300003, "calorie")),
        DAILY_ACTIVITY_RECORD_DURATION(DicDataTypeUtil.a(300003, "duration")),
        DAILY_ACTIVITY_RECORD_ACTIVE_HOUR(DicDataTypeUtil.a(300003, "activeHour")),
        TODAY_ACTIVITY_RECORD(300004),
        TODAY_ACTIVITY_RECORD_STEPS(DicDataTypeUtil.a(300004, MedalConstants.EVENT_STEPS)),
        TODAY_ACTIVITY_RECORD_ACTIVE_CALORIE(DicDataTypeUtil.a(300004, HwExerciseConstants.JSON_NAME_ACTIVECALORIE)),
        TODAY_ACTIVITY_RECORD_DURATION(DicDataTypeUtil.a(300004, "duration")),
        TODAY_ACTIVITY_RECORD_ACTIVE_HOUR(DicDataTypeUtil.a(300004, "activeHour")),
        TODAY_ACTIVITY_RECORD_DISTANCE(DicDataTypeUtil.a(300004, "distance")),
        TODAY_ACTIVITY_RECORD_CLIMB(DicDataTypeUtil.a(300004, "climb")),
        TODAY_ACTIVITY_RECORD_PUSHES(DicDataTypeUtil.a(300004, "pushes")),
        TODAY_ACTIVITY_RECORD_MICRO_WORKOUT(DicDataTypeUtil.a(300004, "microWorkout")),
        REALTIME_SPORT_DATA(300001),
        REALTIME_SPORT_DATA_WALK_OR_RUN(DicDataTypeUtil.a(300001, "walkOrRun")),
        REALTIME_SPORT_DATA_STEPS(DicDataTypeUtil.a(300001, MedalConstants.EVENT_STEPS)),
        REALTIME_SPORT_DATA_EVERSION(DicDataTypeUtil.a(300001, "eversion")),
        REALTIME_SPORT_DATA_FORE_STEPS(DicDataTypeUtil.a(300001, "foreSteps")),
        REALTIME_SPORT_DATA_WHOLE_STEPS(DicDataTypeUtil.a(300001, "wholeSteps")),
        REALTIME_SPORT_DATA_HIND_STEPS(DicDataTypeUtil.a(300001, "hindSteps")),
        REALTIME_GROUND_IMPACT_ACCELERATION(DicDataTypeUtil.a(300001, "groundImpactAcceleration")),
        REALTIME_SPORT_VERTICAL_RATIO(DicDataTypeUtil.a(300001, "verticalRatio")),
        REALTIME_SPORT_DATA_ACTIVE_PEAK(DicDataTypeUtil.a(300001, "activePeak")),
        REALTIME_SPORT_DATA_VERTICAL_LOADING_RATE(DicDataTypeUtil.a(300001, "verticalLoadingRate")),
        REALTIME_SPORT_DATA_SPEED(DicDataTypeUtil.a(300001, "speed")),
        REALTIME_SPORT_DATA_STEP_RATE(DicDataTypeUtil.a(300001, "stepRate")),
        REALTIME_SPORT_DATA_STRIDE(DicDataTypeUtil.a(300001, "stride")),
        REALTIME_SPORT_DATA_GROUND_CONTACT_TIME(DicDataTypeUtil.a(300001, "groundContactTime")),
        REALTIME_SPORT_DATA_HANG_TIME(DicDataTypeUtil.a(300001, "hangTime")),
        REALTIME_SPORT_DATA_FLIGHT_RATIO(DicDataTypeUtil.a(300001, "flightRatio")),
        REALTIME_SPORT_DATA_SWING_ANGLE(DicDataTypeUtil.a(300001, "swingAngle")),
        REALTIME_SPORT_DATA_VERTICAL_OSCILLATION(DicDataTypeUtil.a(300001, "verticalOscillation")),
        REALTIME_SPORT_DATA_GC_TIME_BALANCE(DicDataTypeUtil.a(300001, "GCTimeBalance")),
        REALTIME_SPORT_DATA_CADENCE(DicDataTypeUtil.a(300001, "cadence")),
        REALTIME_SPORT_DATA_DELTA_CIRCLE(DicDataTypeUtil.a(300001, "deltaCircle")),
        REALTIME_SPORT_DATA_SUM_CIRCLE(DicDataTypeUtil.a(300001, "sumCircle")),
        BREATH_RATE(500030),
        BREATH_RATE_VALUE(DicDataTypeUtil.a(500030, "breathRate")),
        MAX_BREATH_RATE(DicDataTypeUtil.b(500030, "breathRate", "MAX")),
        MIN_BREATH_RATE(DicDataTypeUtil.b(500030, "breathRate", "MIN")),
        AVG_BREATH_RATE(DicDataTypeUtil.b(500030, "breathRate", HealthDataStatPolicy.AVG)),
        HEART_RATE_VARIABILITY(NativeInvokeHeartRateBridge.DATA_RATE_HEALTH_HRV),
        HEART_RATE_VARIABILITY_RMSSD(DicDataTypeUtil.a(NativeInvokeHeartRateBridge.DATA_RATE_HEALTH_HRV, "heartRateVariabilityRMSSD")),
        HEART_RATE_VARIABILITY_RMSSD_MAX(DicDataTypeUtil.b(NativeInvokeHeartRateBridge.DATA_RATE_HEALTH_HRV, "maxHrv", "MAX")),
        HEART_RATE_VARIABILITY_RMSSD_MIN(DicDataTypeUtil.b(NativeInvokeHeartRateBridge.DATA_RATE_HEALTH_HRV, "minHrv", "MIN")),
        HEART_RATE_VARIABILITY_RMSSD_LAST(DicDataTypeUtil.b(NativeInvokeHeartRateBridge.DATA_RATE_HEALTH_HRV, "lastHrv", HealthDataStatPolicy.LAST)),
        MICRO_WORKOUT(300014),
        MICRO_WORKOUT_MOUTH_MOVEMENTS_TIMES(DicDataTypeUtil.a(300014, "mouthMovementsTimes")),
        MICRO_WORKOUT_PUFFING_CHEEKS_TIMES(DicDataTypeUtil.a(300014, "puffingCheeksTimes")),
        MICRO_WORKOUT_MASSETER_MASSAGING_TIMES(DicDataTypeUtil.a(300014, "masseterMassagingTimes")),
        MICRO_WORKOUT_EYE_MOVEMENTS_TIMES(DicDataTypeUtil.a(300014, "eyeMovementsTimes")),
        MICRO_WORKOUT_TEMPLES_MASSAGING_TIMES(DicDataTypeUtil.a(300014, "templesMassagingTimes")),
        MICRO_WORKOUT_FENGCHI_ACUPINTS_MASSAGING_TIMES(DicDataTypeUtil.a(300014, "fengchiAcupointsMassagingTimes")),
        MICRO_WORKOUT_NECK_ROTATION_TIMES(DicDataTypeUtil.a(300014, "neckRotationTimes")),
        MICRO_WORKOUT_ANTERIOR_NECK_STRETCH_TIMES(DicDataTypeUtil.a(300014, "anteriorNeckStretchTimes")),
        MICRO_WORKOUT_POSTERIOR_NECK_STRETCH_TIMES(DicDataTypeUtil.a(300014, "posteriorNeckStretchTimes")),
        MICRO_WORKOUT_LATERAL_NECK_STRETCH_TIMES(DicDataTypeUtil.a(300014, "lateralNeckStretchTimes")),
        MICRO_WORKOUT_CHIN_TUCKS_TIMES(DicDataTypeUtil.a(300014, "chinTucksTimes")),
        MICRO_WORKOUT_SHOULDER_CIRCLES_TIMES(DicDataTypeUtil.a(300014, "shoulderCirclesTimes")),
        MICRO_WORKOUT_SHOULDER_EXTERNAL_ROTATION_TIMES(DicDataTypeUtil.a(300014, "shoulderExternalRotationTimes")),
        MICRO_WORKOUT_HAND_BEHIND_BACK_STRETCH_TIMES(DicDataTypeUtil.a(300014, "handBehindBackStretchTimes")),
        MICRO_WORKOUT_SPINE_ROTATION_TIMES(DicDataTypeUtil.a(300014, "spineRotationTimes")),
        MICRO_WORKOUT_LATPULLDOWN_TIMES(DicDataTypeUtil.a(300014, "LatpulldownTimes")),
        MICRO_WORKOUT_CHEST_STRETCH_TIMES(DicDataTypeUtil.a(300014, "chestStretchTimes")),
        MICRO_WORKOUT_QUICK_HAND_RUBBING_TIMES(DicDataTypeUtil.a(300014, "quickHandRubbingTimes")),
        MICRO_WORKOUT_ARM_PRAYER_STRETCH_TIMES(DicDataTypeUtil.a(300014, "armPrayerStretchTimes")),
        MICRO_WORKOUT_WRIST_FLEXION_AND_EXTENSION_TIMES(DicDataTypeUtil.a(300014, "wristFlexionAndExtensionTimes")),
        MICRO_WORKOUT_SEATED_ARM_EXTENSION_TIMES(DicDataTypeUtil.a(300014, "seatedArmExtensionTimes")),
        MICRO_WORKOUT_LATERAL_STRETCH_TIMES(DicDataTypeUtil.a(300014, "lateralStretchTimes")),
        MICRO_WORKOUT_KNEE_PULL_INS_TIMES(DicDataTypeUtil.a(300014, "kneePullInsTimes")),
        MICRO_WORKOUT_SEATED_GLUTE_STRETCH_TIMES(DicDataTypeUtil.a(300014, "seatedGluteStretchTimes")),
        MICRO_WORKOUT_SIDE_LEG_RAISE_TIMES(DicDataTypeUtil.a(300014, "sideLegRaiseTimes")),
        MICRO_WORKOUT_ANKLE_MOVEMENTS_TIMES(DicDataTypeUtil.a(300014, "ankleMovementsTimes")),
        MICRO_WORKOUT_SEATED_LEG_STRETCH_TIMES(DicDataTypeUtil.a(300014, "seatedLegStretchTimes")),
        MICRO_WORKOUT_SEATED_KNEE_EXTENSION_TIMES(DicDataTypeUtil.a(300014, "seatedKneeExtensionTimes")),
        MICRO_WORKOUT_SINGLE_LEG_STANCE_TIMES(DicDataTypeUtil.a(300014, "singleLegStanceTimes")),
        MICRO_WORKOUT_HEEL_RAISE_AND_STRETCH_TIMES(DicDataTypeUtil.a(300014, "heelRaiseAndStretchTimes")),
        MICRO_WORKOUT_HEAD_AND_NECK_PART_TIMES(DicDataTypeUtil.a(300014, "headAndNeckPartTimes")),
        MICRO_WORKOUT_SHOULDER_PART_TIMES(DicDataTypeUtil.a(300014, "shoulderPartTimes")),
        MICRO_WORKOUT_BACK_PART_TIMES(DicDataTypeUtil.a(300014, "backPartTimes")),
        MICRO_WORKOUT_CHEST_PART_TIMES(DicDataTypeUtil.a(300014, "chestPartTimes")),
        MICRO_WORKOUT_ARM_PART_TIMES(DicDataTypeUtil.a(300014, "armPartTimes")),
        MICRO_WORKOUT_WAIST_PART_TIMES(DicDataTypeUtil.a(300014, "waistPartTimes")),
        MICRO_WORKOUT_ABDOMEN_PART_TIMES(DicDataTypeUtil.a(300014, "abdomenPartTimes")),
        MICRO_WORKOUT_GLUTE_PART_TIMES(DicDataTypeUtil.a(300014, "glutePartTimes")),
        MICRO_WORKOUT_LEG_PART_TIMES(DicDataTypeUtil.a(300014, "legPartTimes")),
        MICRO_WORKOUT_FULL_BODY_TIMES(DicDataTypeUtil.a(300014, "fullBodyTimes")),
        MICRO_WORKOUT_TOTAL_MOUTH_MOVEMENTS_TIMES(DicDataTypeUtil.b(300014, "mouthMovementsTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_PUFFING_CHEEKS_TIMES(DicDataTypeUtil.b(300014, "puffingCheeksTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_MASSETER_MASSAGING_TIMES(DicDataTypeUtil.b(300014, "masseterMassagingTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_EYE_MOVEMENTS_TIMES(DicDataTypeUtil.b(300014, "eyeMovementsTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_TEMPLES_MASSAGING_TIMES(DicDataTypeUtil.b(300014, "templesMassagingTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_FENGCHI_ACUPINTS_MASSAGING_TIMES(DicDataTypeUtil.b(300014, "fengchiAcupointsMassagingTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_NECK_ROTATION_TIMES(DicDataTypeUtil.b(300014, "neckRotationTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_ANTERIOR_NECK_STRETCH_TIMES(DicDataTypeUtil.b(300014, "anteriorNeckStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_POSTERIOR_NECK_STRETCH_TIMES(DicDataTypeUtil.b(300014, "posteriorNeckStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_LATERAL_NECK_STRETCH_TIMES(DicDataTypeUtil.b(300014, "lateralNeckStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_CHIN_TUCKS_TIMES(DicDataTypeUtil.b(300014, "chinTucksTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SHOULDER_CIRCLES_TIMES(DicDataTypeUtil.b(300014, "shoulderCirclesTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SHOULDER_EXTERNAL_ROTATION_TIMES(DicDataTypeUtil.b(300014, "shoulderExternalRotationTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_HAND_BEHIND_BACK_STRETCH_TIMES(DicDataTypeUtil.b(300014, "handBehindBackStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SPINE_ROTATION_TIMES(DicDataTypeUtil.b(300014, "spineRotationTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_LATPULLDOWN_TIMES(DicDataTypeUtil.b(300014, "LatpulldownTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_CHEST_STRETCH_TIMES(DicDataTypeUtil.b(300014, "chestStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_QUICK_HAND_RUBBING_TIMES(DicDataTypeUtil.b(300014, "quickHandRubbingTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_ARM_PRAYER_STRETCH_TIMES(DicDataTypeUtil.b(300014, "armPrayerStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_WRIST_FLEXION_AND_EXTENSION_TIMES(DicDataTypeUtil.b(300014, "wristFlexionAndExtensionTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SEATED_ARM_EXTENSION_TIMES(DicDataTypeUtil.b(300014, "seatedArmExtensionTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_LATERAL_STRETCH_TIMES(DicDataTypeUtil.b(300014, "lateralStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_KNEE_PULL_INS_TIMES(DicDataTypeUtil.b(300014, "kneePullInsTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SEATED_GLUTE_STRETCH_TIMES(DicDataTypeUtil.b(300014, "seatedGluteStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SIDE_LEG_RAISE_TIMES(DicDataTypeUtil.b(300014, "sideLegRaiseTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_ANKLE_MOVEMENTS_TIMES(DicDataTypeUtil.b(300014, "ankleMovementsTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SEATED_LEG_STRETCH_TIMES(DicDataTypeUtil.b(300014, "seatedLegStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SEATED_KNEE_EXTENSION_TIMES(DicDataTypeUtil.b(300014, "seatedKneeExtensionTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SINGLE_LEG_STANCE_TIMES(DicDataTypeUtil.b(300014, "singleLegStanceTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_HEEL_RAISE_AND_STRETCH_TIMES(DicDataTypeUtil.b(300014, "heelRaiseAndStretchTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_HEAD_AND_NECK_PART_TIMES(DicDataTypeUtil.b(300014, "headAndNeckPartTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_SHOULDER_PART_TIMES(DicDataTypeUtil.b(300014, "shoulderPartTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_BACK_PART_TIMES(DicDataTypeUtil.b(300014, "backPartTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_CHEST_PART_TIMES(DicDataTypeUtil.b(300014, "chestPartTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_ARM_PART_TIMES(DicDataTypeUtil.b(300014, "armPartTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_WAIST_PART_TIMES(DicDataTypeUtil.b(300014, "waistPartTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_ABDOMEN_PART_TIMES(DicDataTypeUtil.b(300014, "abdomenPartTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_GLUTE_PART_TIMES(DicDataTypeUtil.b(300014, "glutePartTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_LEG_PART_TIMES(DicDataTypeUtil.b(300014, "legPartTimes", HealthDataStatPolicy.SUM)),
        MICRO_WORKOUT_TOTAL_FULL_BODY_TIMES(DicDataTypeUtil.b(300014, "fullBodyTimes", HealthDataStatPolicy.SUM));

        private final int mDataType;

        DataType(int i) {
            this.mDataType = i;
        }

        public int value() {
            return this.mDataType;
        }
    }

    public static class BodyTemperature {
        private BodyTemperature() {
        }
    }

    public static class SkinTemperature {
        private SkinTemperature() {
        }
    }

    public static class EnvironmentTemperature {
        private EnvironmentTemperature() {
        }
    }

    public static class Emotion {
        private Emotion() {
        }
    }

    public static class OvaryHealthDailyStatus {
        private OvaryHealthDailyStatus() {
        }
    }

    public static class OvaryHealthResult {
        private OvaryHealthResult() {
        }
    }

    public static class HighBodyTemperatureAlarm {
        private HighBodyTemperatureAlarm() {
        }
    }

    public static class LowBodyTemperatureAlarm {
        private LowBodyTemperatureAlarm() {
        }
    }

    public static class LowSkinTemperatureAlarm {
        private LowSkinTemperatureAlarm() {
        }
    }

    public static class SuspectedHighTemperatureAlarm {
        private SuspectedHighTemperatureAlarm() {
        }
    }

    public static class SuspectedHighTemperature {
        private SuspectedHighTemperature() {
        }
    }

    public static class ContinueBloodsugar {
        private ContinueBloodsugar() {
        }
    }

    public static class UrgentHypoglycemia {
        private UrgentHypoglycemia() {
        }
    }

    public static class ApproachingHypoglycemia {
        private ApproachingHypoglycemia() {
        }
    }

    public static class Hypoglycemia {
        private Hypoglycemia() {
        }
    }

    public static class Hyperglycemia {
        private Hyperglycemia() {
        }
    }

    public static class BloodsugarRise {
        private BloodsugarRise() {
        }
    }

    public static class BloodsugarDecrease {
        private BloodsugarDecrease() {
        }
    }

    public static class BloodGlucoseTrend {
        private BloodGlucoseTrend() {
        }
    }

    public static class BloodPressureRiskResearchResult {
        private BloodPressureRiskResearchResult() {
        }
    }

    public static class BloodPressureRiskResult {
        private BloodPressureRiskResult() {
        }
    }

    public static class AverageWristTemperatureAllNight {
        private AverageWristTemperatureAllNight() {
        }
    }

    public static class AFIB_BURDEN_RESULT {
        private AFIB_BURDEN_RESULT() {
        }
    }

    public static class BreathTrain {
        private BreathTrain() {
        }
    }

    public static class LightFasting {
        private LightFasting() {
        }
    }

    public static class DietRecord {
        private DietRecord() {
        }
    }

    public static class BloodPressure {
        private BloodPressure() {
        }
    }

    public static class ObstructiveSleepApnea {
        private ObstructiveSleepApnea() {
        }
    }

    public static class FattyLiver {
        private FattyLiver() {
        }
    }

    public static class FastingLitePhase {
        private FastingLitePhase() {
        }
    }

    static class MedicationRule {
        private MedicationRule() {
        }
    }

    static class MedicationPunching {
        private MedicationPunching() {
        }
    }

    static class LakeLouiseAmsScore {
        private LakeLouiseAmsScore() {
        }
    }

    static class PhysiologicalCycle {
        private PhysiologicalCycle() {
        }
    }

    public static class BodyShape {
        private BodyShape() {
        }
    }

    public static class WeightBodyfatBroad {
        private WeightBodyfatBroad() {
        }
    }

    static class ArrhythmiaResult {
        private ArrhythmiaResult() {
        }
    }

    public static class SleepOnOffBedRecord {
        private SleepOnOffBedRecord() {
        }
    }

    static class Altitude {
        private Altitude() {
        }
    }

    static class PhysiologicalCycleBusiness {
        private PhysiologicalCycleBusiness() {
        }
    }

    static class RestingMetabolism {
        private RestingMetabolism() {
        }
    }

    static class CurrentBasalMetabolism {
        private CurrentBasalMetabolism() {
        }
    }

    static class BasalMetabolismAfterExercise {
        private BasalMetabolismAfterExercise() {
        }
    }

    static class DrinkWater {
        private DrinkWater() {
        }
    }

    static class ActiveHour {
        private ActiveHour() {
        }
    }

    public static class EnvironmentNoise {
        private EnvironmentNoise() {
        }
    }

    public static class ArrhythmiaPpg {
        private ArrhythmiaPpg() {
        }
    }

    public static class DynamicBpReport {
        private DynamicBpReport() {
        }
    }

    public static class CourseRecord {
        private CourseRecord() {
        }
    }

    public static class MedicalExamReport {
        private MedicalExamReport() {
        }
    }

    public static class Mindfulness {
        private Mindfulness() {
        }
    }

    public static class VentilatorRecord {
        private VentilatorRecord() {
        }
    }

    public static class Electrocardiogram {
        private Electrocardiogram() {
        }
    }

    public static class SleepDetails {
        private SleepDetails() {
        }
    }

    public static class GolfCourseModel {
        private GolfCourseModel() {
        }
    }

    public static class SleepRecord {
        private SleepRecord() {
        }
    }

    public static class VascularHealth {
        private VascularHealth() {
        }
    }

    public static class VascularHealthResult {
        private VascularHealthResult() {
        }
    }

    public static class SportBloodPressureResult {
        private SportBloodPressureResult() {
        }
    }

    public static class MonthlySleep {
        private MonthlySleep() {
        }
    }

    public static class BgDailyResult {
        private BgDailyResult() {
        }
    }

    public static class BgDailySlpResult {
        private BgDailySlpResult() {
        }
    }

    public static class BgRiskGroupResult {
        private BgRiskGroupResult() {
        }
    }

    public static class PpgOfVascularHealth {
        private PpgOfVascularHealth() {
        }
    }

    public static class EcgOfVascularHealth {
        private EcgOfVascularHealth() {
        }
    }

    public static class Spo2RespInfection {
        private Spo2RespInfection() {
        }
    }

    public static class RriRespInfection {
        private RriRespInfection() {
        }
    }

    public static class BgDailyProbWin {
        private BgDailyProbWin() {
        }
    }

    public static class BgCombinedPpgFeature {
        private BgCombinedPpgFeature() {
        }
    }

    public static class MarkPoint {
        private MarkPoint() {
        }
    }

    public static class TemperatureRespInfection {
        private TemperatureRespInfection() {
        }
    }

    public static class SleepFragmentRespInfection {
        private SleepFragmentRespInfection() {
        }
    }

    public static class CntbpOriginPpgData {
        private CntbpOriginPpgData() {
        }
    }

    public static class Diving {
        private Diving() {
        }
    }

    public static class ScubaDiving {
        private ScubaDiving() {
        }
    }

    public static class BreathHoldingTrain {
        private BreathHoldingTrain() {
        }
    }

    public static class SenseSport {
        private SenseSport() {
        }
    }

    public static class BreathHoldingTest {
        private BreathHoldingTest() {
        }
    }

    public static class Adventures {
        private Adventures() {
        }
    }

    public static class RealtimeSportData {
        private RealtimeSportData() {
        }
    }

    public static class SportGoalAchievementData {
        private SportGoalAchievementData() {
        }
    }

    public static class DailyActivityRecord {
        private DailyActivityRecord() {
        }
    }

    public static class TodayActivityRecord {
        private TodayActivityRecord() {
        }
    }

    public static class MicroWorkout {
        private MicroWorkout() {
        }
    }

    public static class BreathRate {
        private BreathRate() {
        }
    }

    public static class HeartRateVariability {
        private HeartRateVariability() {
        }
    }

    public static class MedicalExamReportResearch {
        private MedicalExamReportResearch() {
        }
    }

    public static class CoronaryHeartDiseaseRiskStudy {
        private CoronaryHeartDiseaseRiskStudy() {
        }
    }

    public static class OneSecondSportDataBike {
        private OneSecondSportDataBike() {
        }
    }

    public static class oneSecondSportData {
        private oneSecondSportData() {
        }
    }

    public static class OneSecondSportDataIndoorBike {
        private OneSecondSportDataIndoorBike() {
        }
    }

    public static class OneSecondSportDataRun {
        private OneSecondSportDataRun() {
        }
    }

    public static class OneSecondSportDataTreadmill {
        private OneSecondSportDataTreadmill() {
        }
    }

    public static class OneSecondSportDataMarathon {
        private OneSecondSportDataMarathon() {
        }
    }

    public static class PickleBall {
        private PickleBall() {
        }
    }
}
