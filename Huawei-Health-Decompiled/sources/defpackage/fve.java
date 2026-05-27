package defpackage;

import com.huawei.haf.application.BaseApplication;
import com.huawei.login.ui.login.LoginInit;
import health.compact.a.GRSManager;

/* JADX INFO: loaded from: classes4.dex */
public class fve {
    public static String ad() {
        return e(cq() + "/getFilters");
    }

    public static String d() {
        return e(cn() + "/getAggregatePageByType");
    }

    public static String al() {
        return e(ck() + "/getWorkoutList");
    }

    public static String am() {
        return e(ck() + "/getWorkoutInfo");
    }

    public static String ao() {
        return e(ck() + "/getWorkoutPackageInfo");
    }

    public static String aq() {
        return e(ck() + "/getWorkoutsInfo");
    }

    public static String s() {
        return e(ck() + "/getActionList");
    }

    public static String ab() {
        return e(ck() + "/getFitnessActionInfo");
    }

    public static String z() {
        return e(ck() + "/getFitnessPackage");
    }

    public static String h() {
        return ck() + "/createFitnessPlan";
    }

    public static String bf() {
        return ck() + "/postRunPlan";
    }

    public static String as() {
        return e(ck() + "/getWorkoutUrl");
    }

    public static String az() {
        return ck() + "/postBhavior";
    }

    public static String ae() {
        return ck() + "/getMyPlan";
    }

    public static String m() {
        return ck() + "/finishExercise";
    }

    public static String ag() {
        return ck() + "/getPlanProgress";
    }

    public static String r() {
        return ck() + "/finishPlan";
    }

    public static String bo() {
        return ck() + "/queryPlanStatistics";
    }

    public static String bv() {
        return ck() + "/queryTrainStatistics";
    }

    public static String bt() {
        return ck() + "/queryTrainCount";
    }

    public static String bn() {
        return ck() + "/queryTrainCountByWorkoutId";
    }

    public static String aj() {
        return ck() + "/getUserBestRecords";
    }

    public static String bc() {
        return ck() + "/postBestRecord";
    }

    public static String be() {
        return ck() + "/postTrainBestRecords";
    }

    public static String af() {
        return e(ck() + "/getMultiLanguage");
    }

    public static String bp() {
        return e(ck() + "/queryTopicList");
    }

    public static String ar() {
        return e(ck() + "/getWorkoutsByTopicId");
    }

    public static String f() {
        return ck() + "/collectBehavior";
    }

    public static String g() {
        return ck() + "/deleteBehavior";
    }

    public static String v() {
        return ck() + "/getBehaviorList";
    }

    public static String k() {
        return ck() + "/deleteUserWorkout";
    }

    public static String l() {
        return ck() + "/deleteLogs";
    }

    public static String ak() {
        return e(ck() + "/getRunRecoWorkout");
    }

    public static String bm() {
        return ck() + "/queryFitnessPlanSummary";
    }

    public static String bk() {
        return ck() + "/queryFitnessPlanDetail";
    }

    public static String bj() {
        return ck() + "/queryMyDoingFitnessPlan";
    }

    public static String ba() {
        return ck() + "/myFinishPlans";
    }

    public static String an() {
        return e(ck() + "/getRecommendWorkout");
    }

    public static String ai() {
        return ck() + "/getRecWorkoutByCourseTypeAnon";
    }

    public static String bw() {
        return ck() + "/queryTrainList";
    }

    public static String bh() {
        return ck() + "/postPlanRemind";
    }

    public static String ax() {
        return ck() + "/modifyPlanName";
    }

    public static String by() {
        return ck() + "/updateFitnessPlan";
    }

    public static String a() {
        return co() + "/allowCreateOldPlan";
    }

    public static String bq() {
        return ck() + "/queryOperationPage";
    }

    public static String ap() {
        return e(ck() + "/getWorkoutsByType");
    }

    public static String q() {
        return e(ck() + "/getActionInfo");
    }

    public static String p() {
        return e(co() + "/getAllPlans");
    }

    public static String e() {
        return co() + "/achievementForecast";
    }

    public static String i() {
        return co() + "/createPlan";
    }

    public static String bd() {
        return co() + "/postFeedback";
    }

    public static String ah() {
        return co() + "/getPlanReport";
    }

    public static String y() {
        return co() + "/getCoachAdvice";
    }

    public static String x() {
        return co() + "/getCurrentReportIndex";
    }

    public static String cf() {
        return co() + "/updatePlan";
    }

    public static String cc() {
        return co() + "/updatePlanDate";
    }

    public static String ce() {
        return co() + "/updatePlanReport";
    }

    public static String cg() {
        return ck() + "/workoutCompletionPunch";
    }

    private static String e(String str) {
        if (!LoginInit.getInstance(BaseApplication.a()).isBrowseMode()) {
            return str;
        }
        return str + "Anon";
    }

    private static String ck() {
        return GRSManager.b(BaseApplication.a()).getUrl("sportSuggestUrl");
    }

    private static String co() {
        return ck() + "/intRunningPlan";
    }

    private static String ci() {
        return GRSManager.b(BaseApplication.a()).getUrl("marketingGateWayUrl") + "/healthFitnessPlan/app/v1/plans";
    }

    public static String br() {
        return e(ci());
    }

    public static String bl() {
        return GRSManager.b(BaseApplication.a()).getUrl("marketingGateWayUrl") + "/healthFitnessPlan/app/v1/myCompetitions";
    }

    public static String b(String str) {
        return e(ci() + "/" + str + "/status");
    }

    public static String bs() {
        return GRSManager.b(BaseApplication.a()).getUrl("activityUrl") + "/activity/setEvent";
    }

    private static String cp() {
        return ck() + "/intPlan";
    }

    public static String aw() {
        return cp() + "/updateCustomAction";
    }

    public static String av() {
        return cp() + "/postFeedback";
    }

    public static String u() {
        return cp() + "/getDoingPlan";
    }

    public static String j() {
        return cp() + "/createPlan";
    }

    public static String cb() {
        return cp() + "/stopPlan";
    }

    public static String ca() {
        return cp() + "/updatePlan";
    }

    public static String bg() {
        return cp() + "/postPlanReport";
    }

    public static String ac() {
        return cp() + "/getPlanReport";
    }

    public static String t() {
        return cp() + "/generateReport";
    }

    public static String bx() {
        return cp() + "/updatePlanProperty";
    }

    public static String bz() {
        return cp() + "/updatePlanDayRecord";
    }

    public static String n() {
        return cp() + "/deletePlanExerciseRecord";
    }

    public static String bu() {
        return cp() + "/replacePlanSchedule";
    }

    public static String at() {
        return cp() + "/v1/leavePlan";
    }

    public static String b() {
        return cp() + "/v1/cancelLeave";
    }

    public static String cd() {
        return cp() + "/v1/updatePlanCalendar";
    }

    public static String c() {
        return ck() + "/addUserDefinedWorkout";
    }

    public static String au() {
        return ck() + "/modifyUserDefinedWorkout";
    }

    public static String cj() {
        return ck() + "/deleteUserDefinedWorkout";
    }

    public static String ch() {
        return cq() + "/getFilterTab";
    }

    private static String cn() {
        return ck() + "/v1";
    }

    private static String cq() {
        return ck() + "/v2";
    }

    private static String cm() {
        return GRSManager.b(BaseApplication.a()).getUrl("messageCenterUrl") + "/messageCenter";
    }

    private static String a(String str, boolean z) {
        if (LoginInit.getInstance(BaseApplication.a()).isBrowseMode() && z) {
            return str;
        }
        return "/user" + str;
    }

    public static String bi() {
        return cm() + a("/queryAudiosPackageBySeriesId", true);
    }

    public static String w() {
        return cm() + a("/getBehaviorList", false);
    }

    public static String ay() {
        return cm() + "/operateFavoriteAudio";
    }

    public static String o() {
        return cm() + a("/deletePlayRecord", false);
    }

    public static String bb() {
        return ck() + "/v2" + a("/getNavigationCourseList", true);
    }

    public static String aa() {
        return ck() + "/getSnapShotAndAlgorithmAnon";
    }

    public static String cl() {
        return ck() + "/queryMaxScore";
    }
}
