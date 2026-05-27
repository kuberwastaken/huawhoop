package defpackage;

import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class evr {
    public static final Set<String> d = Collections.unmodifiableSet(new HashSet<String>() { // from class: evr.3
        private static final long serialVersionUID = -4982539112710710368L;

        {
            add("exercise_duration");
            add("distance");
            add("calorie");
            add("speed");
            add("pace");
            add("hr");
            add("avg_speed");
            add("avg_pace");
            add("total_rise");
            add("total_descend");
            add("altitude");
            add("aerobic_te");
            add("anaerobic_te");
            add("performance_condition");
            add("operator_type");
            add("running_course_number");
            add("running_course_action_count");
            add("running_course_action_id");
            add("running_course_left_type");
            add("running_course_content");
            add("step_cadence");
            add("step");
            add("linkage_cadence");
            add("linkage_pulp_frequency");
            add("linkage_slurry");
            add("linkage_power");
            add("linkage_resistance_level");
            add("linkage_resistance_level_max");
            add("linkage_resistance_level_min");
            add(HwExerciseConstants.JSON_NAME_ACTIVECALORIE);
            add("linkage_slope");
            add("linkage_analog_power");
            add("linkage_real_avg_power");
            add("linkage_real_avg_analog_power");
            add("linkage_analog_cadence");
            add("linkage_avg_cadence");
            add("linkage_avg_analog_cadence");
            add("linkage_three_sec_power");
            add("linkage_three_sec_analog_power");
            add("linkage_max_speed");
        }
    });
    public static final Map<String, Integer> b = Collections.unmodifiableMap(new HashMap<String, Integer>() { // from class: evr.2
        {
            put("exercise_duration", 50004396);
            put("distance", 50004765);
            put("calorie", 50004829);
            put("speed", 50004799);
            put("pace", 50004979);
            put("hr", 50004838);
            put("avg_speed", 50004858);
            put("avg_pace", 50004872);
            put("total_rise", 50004395);
            put("total_descend", 50004774);
            put("altitude", 50004286);
            put("aerobic_te", 50004172);
            put("anaerobic_te", 50004881);
            put("performance_condition", 50004011);
            put("operator_type", 50004770);
            put("running_course_number", 50004632);
            put("running_course_action_count", 50004251);
            put("running_course_action_id", 50004561);
            put("running_course_left_type", 50004992);
            put("running_course_content", 50004187);
            put("step_cadence", 50004721);
            put("step", 50004684);
            put("linkage_cadence", 50004254);
            put("linkage_pulp_frequency", 50004184);
            put("linkage_slurry", 50004232);
            put("linkage_power", 50004757);
            put("linkage_resistance_level", 50004861);
            put("linkage_resistance_level_max", 50004961);
            put("linkage_resistance_level_min", 50004199);
            put(HwExerciseConstants.JSON_NAME_ACTIVECALORIE, 50004617);
            put("linkage_slope", 50004934);
            put("linkage_analog_power", 50004749);
            put("linkage_real_avg_power", 50004559);
            put("linkage_real_avg_analog_power", 50004567);
            put("linkage_analog_cadence", 50004151);
            put("linkage_avg_cadence", 50004439);
            put("linkage_avg_analog_cadence", 50004929);
            put("linkage_three_sec_power", 50004086);
            put("linkage_three_sec_analog_power", 50004826);
            put("linkage_max_speed", 50004579);
        }
    });

    private static boolean e(int i) {
        return i != Integer.MIN_VALUE;
    }

    public static mgs c(String str, mxh mxhVar) {
        mgs mgsVar = new mgs();
        mgsVar.d(str + "#ANDROID21");
        mgsVar.a(((long) mxhVar.k()) * 1000);
        if (e(mxhVar.p())) {
            mgsVar.z(mxhVar.p());
        }
        if (e(mxhVar.ac())) {
            mgsVar.q(mxhVar.ac());
        }
        if (e(mxhVar.l())) {
            mgsVar.o(mxhVar.l());
        }
        if (e(mxhVar.q())) {
            mgsVar.n(mxhVar.q());
        }
        mgsVar.k(mxhVar.t());
        mgsVar.x(mxhVar.ah());
        mgsVar.h(mxhVar.m());
        if (e(mxhVar.aa())) {
            mgsVar.a(mxhVar.aa());
        }
        mgsVar.e(mxhVar.n());
        mgsVar.m(mxhVar.o());
        if (e(mxhVar.ak())) {
            mgsVar.ad(mxhVar.ak());
        }
        if (e(mxhVar.an())) {
            mgsVar.u(mxhVar.an());
        }
        if (e(mxhVar.am())) {
            mgsVar.v(mxhVar.am());
        }
        mgsVar.e(mxhVar.a());
        mgsVar.d(mxhVar.d());
        mgsVar.s(mxhVar.z());
        mgsVar.d(((long) mxhVar.al()) * 1000);
        mgsVar.r(mxhVar.v());
        mgsVar.c(mxhVar.ae());
        mgsVar.b(mxhVar.x());
        mgsVar.c(mxhVar.c());
        if (e(mxhVar.b())) {
            mgsVar.b(mxhVar.b());
        }
        if (e(mxhVar.i())) {
            mgsVar.j(mxhVar.i());
        }
        if (e(mxhVar.ab())) {
            mgsVar.t(mxhVar.ab());
        }
        if (e(mxhVar.ad())) {
            mgsVar.p(mxhVar.ad());
        }
        if (e(mxhVar.e())) {
            mgsVar.a(mxhVar.e());
        }
        if (e(mxhVar.h())) {
            mgsVar.i(mxhVar.h());
        }
        if (e(mxhVar.g())) {
            mgsVar.g(mxhVar.g());
        }
        if (e(mxhVar.af())) {
            mgsVar.y(mxhVar.af());
        }
        if (e(mxhVar.ai())) {
            mgsVar.w(mxhVar.ai());
        }
        if (e(mxhVar.j())) {
            mgsVar.f(mxhVar.j());
        }
        if (e(mxhVar.u())) {
            mgsVar.l(mxhVar.u());
        }
        return mgsVar;
    }
}
