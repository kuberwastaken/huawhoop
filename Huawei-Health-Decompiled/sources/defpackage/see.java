package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class see extends sea {

    @SerializedName("taskList")
    private List<a> b;

    public String h() {
        return o() ? "" : this.b.get(0).a();
    }

    public int f() {
        if (o()) {
            return -1;
        }
        return this.b.get(0).j();
    }

    public int j() {
        if (o()) {
            return -1;
        }
        return this.b.get(0).b();
    }

    public int b() {
        if (o()) {
            return -1;
        }
        return this.b.get(0).c();
    }

    public int i() {
        if (o()) {
            return -1;
        }
        return this.b.get(0).e();
    }

    public int a() {
        if (o()) {
            return -1;
        }
        return this.b.get(0).d();
    }

    public int c() {
        if (o()) {
            return -1;
        }
        return ((c) this.b.get(0).f().get(0)).e();
    }

    public int g() {
        if (o()) {
            return -1;
        }
        return ((c) this.b.get(0).f().get(0)).d();
    }

    public boolean o() {
        return mgx.d(this.b) || mgx.d(this.b.get(0).f());
    }

    @Override // defpackage.sea
    public String toString() {
        return "ThreeCircleTaskResponse{resultCode=" + e() + ", resultDesc=" + d() + ", ThreeRingTaskInfo=" + this.b + '}';
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("days")
        private int f17678a;

        @SerializedName("taskBeginTime")
        private long b;

        @SerializedName("subscriptionStatus")
        private int c;

        @SerializedName("lastAcquirePoints")
        private int d;

        @SerializedName("dayGoalMap")
        private Map<String, Integer> e;

        @SerializedName("taskPoints")
        private int f;

        @SerializedName("taskId")
        private String g;

        @SerializedName(ParsedFieldTag.TASK_NAME)
        private String h;

        @SerializedName("taskDays")
        private int i;

        @SerializedName("taskEndTime")
        private long j;

        @SerializedName("taskSubscribeEndTime")
        private long k;

        @SerializedName("taskScenarios")
        private int m;

        @SerializedName(ParsedFieldTag.KAKA_TASK_RULE)
        private int n;

        @SerializedName("userPeriodInfos")
        private List<c> o;

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int j() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int b() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int e() {
            return this.i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int c() {
            return this.f17678a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d() {
            return this.d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<c> f() {
            return this.o;
        }

        public String toString() {
            return " ThreeRingTaskInfo{taskId=" + this.g + ", taskName=" + this.h + ", taskScenarios=" + this.m + "taskRule=" + this.n + ", taskPoints=" + this.f + ", taskBeginTime=" + this.b + ", taskEndTime=" + this.j + ", taskDays=" + this.i + "taskSubscribeEndTime=" + this.k + ", subscriptionStatus=" + this.c + ", days=" + this.f17678a + "dayGoalMap=" + this.e + ", userPeriodInfo=" + this.o + '}';
        }
    }

    public static class c {

        @SerializedName("periodTaskPoints")
        private int b;

        @SerializedName("periodTaskStatus")
        private int e;

        /* JADX INFO: Access modifiers changed from: private */
        public int e() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d() {
            return this.e;
        }

        public String toString() {
            return "UserPeriodInfo{PeriodTaskPoints=" + this.b + ", periodTaskStatus=" + this.e + '}';
        }
    }
}
