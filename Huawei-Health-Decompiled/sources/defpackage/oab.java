package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes7.dex */
public class oab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("planTime")
    private long f16257a;

    @SerializedName(AsCache.FEED_BACK_CACHE_FILE_NAME)
    private String b;

    @SerializedName("dayNumber")
    private int c;

    @SerializedName("planId")
    private String d;

    @SerializedName(ParsedFieldTag.TASK_COMPLETE_TIME)
    private long e;

    @SerializedName("weekNumber")
    private int i;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String j;

    public String b() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.j = str;
    }

    public void b(long j) {
        this.e = j;
    }

    public void d(String str) {
        this.b = str;
    }

    public void d(int i) {
        this.i = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public void e(long j) {
        this.f16257a = j;
    }

    public long a() {
        return this.f16257a;
    }
}
