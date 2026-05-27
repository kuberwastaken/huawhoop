package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.sport.model.WorkoutRecord;

/* JADX INFO: loaded from: classes10.dex */
public class gjm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("completionRate")
    private float f13495a;

    @SerializedName("defineType")
    private int b;

    @SerializedName("courseId")
    private String c;

    @SerializedName("completionValue")
    private float d;

    @SerializedName("modifiedTime")
    private long e;

    @SerializedName(WorkoutRecord.Extend.COURSE_TARGET_TYPE)
    private int h;

    @SerializedName(WorkoutRecord.Extend.COURSE_TARGET_VALUE)
    private float i;

    @SerializedName("courseName")
    private String j;

    public String toString() {
        return "RecordCourseSummary{mCourseId='" + this.c + "', mCourseName='" + this.j + "', mCompletionRate='" + this.f13495a + "', mCourseTargetType=" + this.h + ", mCourseTargetValue=" + this.i + ", mCompletionValue=" + this.d + ", mCourseDefineType=" + this.b + ", mCourseModifiedTime=" + this.e + '}';
    }
}
