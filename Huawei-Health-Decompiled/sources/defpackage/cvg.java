package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.huawei.hihealth.util.HiJsonUtil;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.operation.jsoperation.JsUtil;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cvg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("begin_time")
    private long f12038a;

    @SerializedName("awake_sleep_duration")
    private long b;

    @SerializedName("age")
    private int c;

    @SerializedName("deep_sleep_duration")
    private long d;

    @SerializedName("awake_count")
    private int e;

    @SerializedName("interupt_details")
    private List<c> f;

    @SerializedName("env_noise")
    private a g;

    @SerializedName(CommonConstant.KEY_GENDER)
    private int h;

    @SerializedName("end_time")
    private long i;

    @SerializedName("fallasleep_duration")
    private long j;

    @SerializedName("interup_duration")
    private long k;

    @SerializedName("sleepMerge")
    private d l;

    @SerializedName("period_details")
    private List<e> m;

    @SerializedName("rem_sleep_duration")
    private long n;

    @SerializedName("light_sleep_duration")
    private long o;

    @SerializedName("symptoms")
    private i p;

    @SerializedName("total_duration")
    private long q;

    @SerializedName("unknow_sleep_duration")
    private long r;

    @SerializedName("valid_sleep_duration")
    private long s;

    @SerializedName(JsUtil.SCORE)
    private int t;

    @SerializedName("voice_infos")
    private List<b> w;

    /* JADX INFO: loaded from: classes10.dex */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("sym1_lvl")
        private int f12041a;

        @SerializedName("sym1_idx")
        private int b;

        @SerializedName("envdblevel")
        private int c;

        @SerializedName("envdb")
        private int d;

        @SerializedName("interuptlevel")
        private int e;

        @SerializedName("sym2_idx")
        private int f;

        @SerializedName("starnum")
        private int g;

        @SerializedName("totalsleeptime")
        private int h;

        @SerializedName("sym2_lvl")
        private int i;

        @SerializedName("totalscore")
        private int j;

        public String toString() {
            return "SleepMerge{totalscore=" + this.j + ", starNumber=" + this.g + ", totalSleepTime=" + this.h + ", envDb=" + this.d + ", envDbLevel=" + this.c + ", interruptLevel=" + this.e + ", firstSymptomsId=" + this.b + ", firstSymptomsLevel=" + this.f12041a + ", secondSymptomsId=" + this.f + ", secondSymptomsLevel=" + this.i + '}';
        }
    }

    public class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("sym2_lvl")
        private int f12043a;

        @SerializedName("sym2_idx")
        private int b;

        @SerializedName("sym1_lvl")
        private int c;

        @SerializedName("sym1_idx")
        private int e;

        public String toString() {
            return "SleepSymptoms{firstSymptomsId=" + this.e + ", firstSymptomsLevel=" + this.c + ", secondSymptomsId=" + this.b + ", secondSymptomsLevel=" + this.f12043a + '}';
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("env_db_min")
        private int f12039a;

        @SerializedName("env_db_avg")
        private int b;

        @SerializedName("env_db_infos")
        private int[] c;

        @SerializedName("snore_avgdb")
        private int d;

        @SerializedName("env_db_max")
        private int e;

        @SerializedName("snore_duration")
        private long f;

        @SerializedName("snore_count")
        private int g;

        @SerializedName("snore_max_db")
        private int j;

        public int[] b() {
            int[] iArr = this.c;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public int a() {
            return this.b;
        }

        public int d() {
            return this.e;
        }

        public int c() {
            return this.f12039a;
        }

        public String toString() {
            return "EnvNoiseInfo{envDbInfos=" + Arrays.toString(this.c) + ", envDbAvg=" + this.b + ", envDbMax=" + this.e + ", envDbMin=" + this.f12039a + ", snoreCount=" + this.g + ", snoreAvgDb=" + this.d + ", snoreMaxDb=" + this.j + ", snoreDuration=" + this.f + '}';
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("period_type")
        private long f12042a;

        @SerializedName("period_duration")
        private long e;

        public long d() {
            return this.f12042a;
        }

        public long b() {
            return this.e;
        }

        public String toString() {
            return "PeriodInfo{periodType=" + this.f12042a + ", periodDuration=" + this.e + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("voice_duration")
        private int f12040a;

        @SerializedName("voice_start_time")
        private long b;

        @SerializedName("voice_filepath")
        private String d;

        @SerializedName("voice_type")
        private int e;

        public long a() {
            return this.b;
        }

        public int b() {
            return this.f12040a;
        }

        public String e() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public String toString() {
            return "SleepMonitorReportVoice{voiceStartTime=" + this.b + ", voiceDuration=" + this.f12040a + ", voiceFilepath='" + this.d + "', voiceType=" + this.e + '}';
        }

        public int hashCode() {
            String str = this.d;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.d == null && bVar.e() == null) {
                return true;
            }
            if (this.d != null || bVar.e() == null) {
                return e().equals(bVar.e());
            }
            return false;
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    public class c {

        @SerializedName("interupt_duration")
        private long b;

        @SerializedName("interupt_start_time")
        private long e;

        public String toString() {
            return "InterruptInfo{interruptStartTime=" + this.e + ", interruptDuration=" + this.b + '}';
        }
    }

    public long a() {
        return this.f12038a;
    }

    public long d() {
        return this.i;
    }

    public long h() {
        return this.s;
    }

    public int e() {
        return this.e;
    }

    public int i() {
        return this.t;
    }

    public List<b> f() {
        return this.w;
    }

    public List<e> b() {
        return this.m;
    }

    public a c() {
        return this.g;
    }

    public i j() {
        return this.p;
    }

    public String toString() {
        return "SleepMonitorReport{age=" + this.c + ", gender=" + this.h + ", beginTime=" + this.f12038a + ", endTime=" + this.i + ", totalDuration=" + this.q + ", fallSleepDuration=" + this.j + ", interruptDuration=" + this.k + ", deepSleepDuration=" + this.d + ", lightSleepDuration=" + this.o + ", remSleepDuration=" + this.n + ", awakeSleepDuration=" + this.b + ", unknowSleepDuration=" + this.r + ", validSleepDuration=" + this.s + ", awakeCount=" + this.e + ", sleepScore=" + this.t + ", interruptDetails=" + this.f + ", voiceInfos=" + this.w + ", periodDetails=" + this.m + ", envNoise=" + this.g + ", symptoms=" + this.p + '}';
    }

    public static cvg d(String str) {
        cvg cvgVar = new cvg();
        try {
            return (cvg) HiJsonUtil.b(str, cvg.class);
        } catch (JsonSyntaxException unused) {
            LogUtil.j("SleepMonitorReport", "SleepMonitorReport fromJson is jsonSyntaxException");
            return cvgVar;
        }
    }
}
