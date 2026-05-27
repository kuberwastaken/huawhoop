package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cxn {

    @SerializedName("reminderPlans")
    private List<b> e;

    public List<b> c() {
        return this.e;
    }

    public void d(List<b> list) {
        this.e = list;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("dataType")
        private int f12074a;

        @SerializedName("endHour")
        private int b;

        @SerializedName("enabled")
        private int c;

        @SerializedName("daysOfWeek")
        private int d;

        @SerializedName("createTime")
        private long e;

        @SerializedName("hour")
        private int f;

        @SerializedName("remindInterval")
        private int g;

        @SerializedName("startHour")
        private int h;

        @SerializedName("endMinute")
        private int i;

        @SerializedName("minute")
        private int j;

        @SerializedName("startMinute")
        private int m;

        @SerializedName("updateTime")
        private long n;

        public void a(long j) {
            this.e = j;
        }

        public int e() {
            return this.d;
        }

        public void e(int i) {
            this.d = i;
        }

        public int a() {
            return this.c;
        }

        public void c(int i) {
            this.c = i;
        }

        public int d() {
            return this.f12074a;
        }

        public void a(int i) {
            this.f12074a = i;
        }

        public int i() {
            return this.f;
        }

        public void g(int i) {
            this.f = i;
        }

        public int f() {
            return this.j;
        }

        public void h(int i) {
            this.j = i;
        }

        public int h() {
            return this.h;
        }

        public void f(int i) {
            this.h = i;
        }

        public int j() {
            return this.m;
        }

        public void i(int i) {
            this.m = i;
        }

        public int b() {
            return this.b;
        }

        public void b(int i) {
            this.b = i;
        }

        public int c() {
            return this.i;
        }

        public void d(int i) {
            this.i = i;
        }

        public int g() {
            return this.g;
        }

        public void j(int i) {
            this.g = i;
        }

        public void e(long j) {
            this.n = j;
        }

        public String toString() {
            return "ReminderPlan{createTime=" + this.e + ",daysOfWeek=" + this.d + ",enabled=" + this.c + ",dataType=" + this.f12074a + ",hour=" + this.f + ",minute=" + this.j + ",startHour=" + this.h + ",startMinute=" + this.m + ",endHour=" + this.b + ",endMinute=" + this.i + ",remindInterval=" + this.g + ",updateTime=" + this.n + "}";
        }
    }
}
