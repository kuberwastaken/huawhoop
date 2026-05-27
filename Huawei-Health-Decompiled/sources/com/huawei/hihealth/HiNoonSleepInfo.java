package com.huawei.hihealth;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HiNoonSleepInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("noonSleepTimeIntervalList")
    private List<TimeInterval> f4198a;

    @SerializedName("noonSleepTotalTime")
    private double b;

    public void a(double d) {
        this.b = d;
    }

    public void b(List<TimeInterval> list) {
        this.f4198a = list;
    }

    public static class TimeInterval {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("timeZone")
        private final String f4199a;

        @SerializedName("startTime")
        private final long c;

        @SerializedName("endTime")
        private final long e;

        public TimeInterval(long j, long j2, String str) {
            this.c = j;
            this.e = j2;
            this.f4199a = str;
        }
    }
}
