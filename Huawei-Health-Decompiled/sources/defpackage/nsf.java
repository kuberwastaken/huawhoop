package defpackage;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.transformer.ExportException;
import com.apprichtap.haptic.base.PrebakedEffectId;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.huawei.android.airsharing.api.IEventListener;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.login.ui.login.MainLoginCallBack;
import com.huawei.operation.ble.BleConstants;
import com.huawei.pluginachievement.manager.model.KakaConstants;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class nsf {
    private final int eh;
    private final String ei;
    private final int ej;
    public static final nsf an = c("firstUseDate", 9001);
    public static final nsf dq = a(ParsedFieldTag.TOTAL_DAYS, 9002);
    public static final nsf eg = a("totalActiveDaysCurrentYear", 10015);
    public static final nsf dt = a(BleConstants.TOTAL_CALORIES, 6005);
    public static final nsf ab = a("distanceCompare", 9009);
    public static final nsf f = a("caloriesCompare", 9010);
    public static final nsf dv = a("totalStep", 3001);
    public static final nsf eb = a("totalStepDistance", 3002);
    public static final nsf bv = a("maxStepContinuousDays", 10026);
    public static final nsf di = a("stepCompare", IEventListener.EVENT_ID_DEVICE_SCAN_FINISH);
    public static final nsf dg = a("stepOverTenThousand", IEventListener.EVENT_ID_DEVICE_RTSP_CONN);
    public static final nsf bs = a("maxStep", 3003);
    public static final nsf bt = g("maxStepDay", 3004);
    public static final nsf ac = g("exceedTenThousandStepList", 10072);
    public static final nsf aw = g("fullYearSportDuration", 9011);
    public static final nsf bq = g("maxSportDurationMonths", 9012);
    public static final nsf by = a("maxWalkMonth", IEventListener.EVENT_ID_DEVICE_DISCONN_SUCC);
    public static final nsf bx = a("maxWalkSeason", IEventListener.EVENT_ID_DEVICE_UPDATE);
    public static final nsf bn = a("maxWalkSeasonSteps", 3009);
    public static final nsf ee = a("walkCount", 3010);
    public static final nsf cx = a(KakaConstants.SLEEP_DURATION, 8002);
    public static final nsf cz = a("sleepCount", MainLoginCallBack.MSG_START_APK_SERVICE_ERROR);
    public static final nsf da = d("sleepScore", 8001);
    public static final nsf df = d("maxSleepScoreOfSeason", 10017);
    public static final nsf db = d("maxSleepScoreValueOfSeason", 10018);
    public static final nsf dc = d("fallAsleepTimeLess24", 10019);
    public static final nsf cw = d("minSleepDurationDay", 10020);
    public static final nsf cf = d("minSleepDuration", 10021);
    public static final nsf ct = g("fallAsleepTime", MainLoginCallBack.MSG_HWID_ACCOUNT_NOT_LOGIN);
    public static final nsf de = g("wakeupTime", MainLoginCallBack.MSG_NO_NETWORK);
    public static final nsf cr = d("breLevel", MainLoginCallBack.MSG_HMS_VERSION_ERROR);
    public static final nsf cy = a("sleepScoreCompare", MainLoginCallBack.MSG_SHOW_HMS_DIALOG);
    public static final nsf dw = a("totalRunDistance", 2001);
    public static final nsf co = a("runDistanceCompare", 2007);
    public static final nsf cv = a("runNumberOfTimes", 2002);
    public static final nsf cs = a("runNumberOfDays", 10022);
    public static final nsf cm = a("maxRunContinuousDays", 10023);
    public static final nsf cj = a("bestPace", 10024);
    public static final nsf cp = a("bestPaceCompare", 10025);
    public static final nsf cq = a("runMaxDistance", 2003);
    public static final nsf cn = c("runMaxDistanceDay", 2004);
    public static final nsf cu = a("timeOfDay", 2005);
    public static final nsf ay = a("halfMarathonCount", 9004);
    public static final nsf ao = a("fullMarathonCount", 9005);
    public static final nsf av = a("halfMarathonBestPace", 2008);
    public static final nsf bc = c("halfMarathonTimestamp", 2009);
    public static final nsf bi = a("marathonBestPace", 2010);
    public static final nsf bm = c("marathonTimestamp", 2011);
    public static final nsf dr = a("totalCycleDistance", 1001);
    public static final nsf y = a("cycleDistanceCompare", 1005);
    public static final nsf z = a("cycleNumberOfTimes", 1002);
    public static final nsf bo = a("maxCycleContinuousDays", PrebakedEffectId.RT_SPEED_UP);
    public static final nsf u = a("cycleMaxDistance", 1003);
    public static final nsf v = c("cycleMaxDistanceDay", 1004);
    public static final nsf dz = a("totalDuration", 4001);
    public static final nsf dy = a("totalDurationExcludeRunCourse", PrebakedEffectId.RT_JUMP);
    public static final nsf ds = a("totalCourseDay", 10029);
    public static final nsf am = a("maxFitnessContinuousDays", PrebakedEffectId.RT_COIN_DROP);
    public static final nsf ae = g("favoriteCourseName", PrebakedEffectId.RT_HEARTBEAT);
    public static final nsf dh = a("maxSwimContinuousDays", 10032);
    public static final nsf ap = a("fitnessNumberOfTimes", 4002);
    public static final nsf ak = a("fitnessDurationCompare", 4006);
    public static final nsf ar = a("fitnessMaxDuration", 4003);
    public static final nsf bp = c("fitnessMaxDurationDay", 4004);
    public static final nsf af = a("favoriteCourses", 4007);
    public static final nsf al = g("favoriteSportType", WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED);
    public static final nsf ag = a("favoriteSportSumDuration", 4013);
    public static final nsf aq = e("fitnessTypeMap", 4014);
    public static final nsf bw = c("swimMaxDistanceDay", 4009);
    public static final nsf bu = a("swimMaxDistance", 4010);

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final nsf f126do = a("swimSumDistance", 4011);
    public static final nsf dm = a("swimSumTime", PrebakedEffectId.RT_FOOTSTEP);
    public static final nsf dp = a("swimSumDistanceCompare", PrebakedEffectId.RT_ICE);
    public static final nsf dn = a("swimSumCount", 4012);
    public static final nsf cb = g("medalIdList", 5001);
    public static final nsf as = a("annualFlagNum", PrebakedEffectId.RT_DRAWING_ARROW);
    public static final nsf ci = a("annualReachFlagNum", 10034);
    public static final nsf ba = a("headlineNum", 10035);
    public static final nsf p = a("maxContinuousHeadlineDay", PrebakedEffectId.RT_SNIPER_RIFLE);
    public static final nsf az = a("headlineDayNum", PrebakedEffectId.RT_ASSAULT_RIFLE);
    public static final nsf bb = a("hypnoticMusicNum", 10038);
    public static final nsf ah = a("favoriteHypnoticMusicType", 10039);
    public static final nsf dx = g("totalNumOfMusicType", 10050);
    public static final nsf aj = c("firstBeVipTime", PrebakedEffectId.RT_FAST_MOVING);
    public static final nsf x = a("currentVipstatus", PrebakedEffectId.RT_FLY);
    public static final nsf bd = a("joinActivityNum", 10001);
    public static final nsf bf = b("JoinActivityCompletionRate", 10002);
    public static final nsf ai = a("favoriteActivityType", 10003);
    public static final nsf dk = e("starAcquired", 6006);
    public static final nsf du = a(BleConstants.TOTAL_DISTANCE, 9003);
    public static final nsf e = a("bloodPressureTotalNum", 10004);
    public static final nsf b = a("bloodPressureNormalNum", 10005);
    public static final nsf d = b("bloodPressureNormalRatio", 10006);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nsf f16156a = b("bloodPressureNormalRatioCompare", 10007);
    public static final nsf g = a("bloodSugarTotalNum", 10008);
    public static final nsf j = a("bloodSugarNormalNum", 10009);
    public static final nsf i = b("bloodSugarNormalRatio", 10010);
    public static final nsf h = b("bloodSugarNormalRatioCompare", 10011);
    public static final nsf c = d("averageWeightThisYear", 10012);
    public static final nsf ec = a("weightMeasureTimes", 10013);
    public static final nsf ed = b("BMI", PrebakedEffectId.RT_LIGHTNING);
    public static final nsf ea = d("weightCompare", PrebakedEffectId.RT_CALENDAR_DATE);
    public static final nsf aa = a("dietRecordDayNum", 10016);
    public static final nsf dl = c("threeRingReachNum", PrebakedEffectId.RT_SPRING);
    public static final nsf br = a("maxContinuousThreeRingDay", PrebakedEffectId.RT_SWING);
    public static final nsf ce = a("perfectCloverReachNum", PrebakedEffectId.RT_WIND);
    public static final nsf bk = a("maxContinuousPerfectCloverDay", PrebakedEffectId.RT_VICTORY);
    public static final nsf s = a("cloverLeafReachNum", PrebakedEffectId.RT_AWARD);
    public static final nsf m = a("climbHillCount", 10051);
    public static final nsf k = a("climbHillDistance", 10052);
    public static final nsf n = b("climbHillAltitude", 10053);
    public static final nsf l = b("climbHillMaxAltitude", 10054);
    public static final nsf q = c("climbHillMaxAltitudeDay", 10055);
    public static final nsf r = a("climbHillMaxAltitudeDistance", 10056);
    public static final nsf t = a("climbHillMaxAltitudeDuration", 10057);
    public static final nsf o = b("climbHillMaxAltitudeCreepingWave", 10058);
    public static final nsf cd = a("playBadmintonCount", 10059);
    public static final nsf ck = a("playBadmintonDuration", 10060);
    public static final nsf cl = a("playBadmintonMaxDuration", 10061);
    public static final nsf ch = c("playBadmintonMaxDurationDay", 10062);
    public static final nsf bh = a("jumpRopeCount", 10063);
    public static final nsf bj = c("jumpRopeNum", 10064);
    public static final nsf be = a("jumpRopeMaxNum", 10065);
    public static final nsf bl = c("jumpRopeMaxNumDay", 10066);
    public static final nsf bg = a("jumpRopeMaxContinuousDays", 10067);
    public static final nsf ca = d("maxWeightThisYear", ExportException.ERROR_CODE_MUXING_TIMEOUT);
    public static final nsf cg = d("minWeightThisYear", ExportException.ERROR_CODE_MUXING_APPEND);
    public static final nsf ad = g("emotionData", 10068);
    public static final nsf dj = g("stressData", 10069);
    public static final nsf bz = g("microCheckupData", 10070);
    public static final nsf w = g("cycleCalendarData", 10071);
    public static final nsf cc = g("newlyTriedSports", 4015);
    public static final nsf dd = g("sportTypeMap", 4016);
    public static final nsf at = d("fullYearGolfCount", 10073);
    public static final nsf ax = d("fullYearGolfSwingCount", 10074);
    public static final nsf au = d("fullYearGolfDuration", 10075);

    public nsf(String str, int i2, int i3) {
        Preconditions.checkNotNull(str);
        this.ei = str;
        this.ej = i2;
        this.eh = i3;
    }

    public int d() {
        return this.eh;
    }

    public String a() {
        return this.ei;
    }

    public int e() {
        return this.ej;
    }

    public String toString() {
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[2];
        objArr[0] = this.ei;
        objArr[1] = this.eh == 1 ? CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT : "f";
        return String.format(locale, "%s(%s)", objArr);
    }

    public static nsf a(String str, int i2) {
        return new nsf(str, i2, 1);
    }

    public static nsf b(String str, int i2) {
        return new nsf(str, i2, 2);
    }

    public static nsf g(String str, int i2) {
        return new nsf(str, i2, 3);
    }

    public static nsf c(String str, int i2) {
        return new nsf(str, i2, 4);
    }

    public static nsf d(String str, int i2) {
        return new nsf(str, i2, 5);
    }

    public static nsf e(String str, int i2) {
        return new nsf(str, i2, 6);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof nsf)) {
            return false;
        }
        nsf nsfVar = (nsf) obj;
        return this.ei.equals(nsfVar.ei) && this.eh == nsfVar.eh;
    }

    public final int hashCode() {
        return this.ei.hashCode();
    }
}
