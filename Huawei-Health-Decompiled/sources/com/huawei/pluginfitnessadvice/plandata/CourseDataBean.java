package com.huawei.pluginfitnessadvice.plandata;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.sport.model.WorkoutRecord;
import defpackage.nzq;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class CourseDataBean implements Serializable, Cloneable {
    private static final long serialVersionUID = 774731271769351368L;

    @SerializedName("clockFlag")
    private int b;

    @SerializedName("courseInfo")
    private nzq c;

    @SerializedName("courseId")
    private String d;

    @SerializedName(WorkoutRecord.Extend.FIT_EXTEND_COURSE_TYPE)
    private int e;

    public nzq b() {
        return this.c;
    }

    public int e() {
        return this.e;
    }

    public String a() {
        return this.d;
    }

    public void a(boolean z) {
        if (z) {
            this.b = 1;
        } else {
            this.b = 0;
        }
    }

    public boolean c() {
        return this.b == 1;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public enum PlanCourseType {
        RACE_DAY(0),
        RUN_COURSE(1),
        STRENGHT_COURSE(2);

        int mValue;

        PlanCourseType(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }
}
