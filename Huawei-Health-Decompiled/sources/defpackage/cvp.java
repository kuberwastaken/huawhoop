package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwlogsmodel.LogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cvp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("bundleName")
    private String f12051a;

    @SerializedName("createTime")
    private long b;

    @SerializedName("deviceModel")
    private String c;

    @SerializedName("abilityName")
    private String d;

    @SerializedName("deviceCategory")
    private String e;

    @SerializedName("deviceName")
    private String f;

    @SerializedName("featureName")
    private String g;

    @SerializedName("effectiveTime")
    private long h;

    @SerializedName("featureType")
    private int i;

    @SerializedName("expirationTime")
    private long j;

    @SerializedName("formName")
    private String k;

    @SerializedName("formDimension")
    private String l;

    @SerializedName("moduleName")
    private String m;

    @SerializedName("messageId")
    private String n;

    @SerializedName("messageName")
    private String o;

    @SerializedName("timeZone")
    private String q;

    @SerializedName("timePeriods")
    private List<e> s;

    public static class e {
        private long c;
        private long e;

        public e(long j, long j2) {
            this.c = j;
            this.e = j2;
            if (j2 - j > 5400000) {
                LogUtil.j("TimePeriod", "TimePeriod too large, startTime: ", Long.valueOf(j), ", endTime: ", Long.valueOf(j2));
                this.e = this.c + 5400000;
            }
        }

        public void c(long j, long j2) {
            this.c = j;
            if (j2 - j > 5400000) {
                j2 = j + 5400000;
            }
            this.e = j2;
        }

        public long d() {
            return this.c;
        }

        public long a() {
            return this.e;
        }

        public String toString() {
            return "TimePeriod{mStartTime=" + this.c + ", mEndTime=" + this.e + '}';
        }
    }

    public cvp(c cVar) {
        this.o = cVar.l;
        this.n = cVar.m;
        this.c = cVar.c;
        this.e = cVar.f12052a;
        this.f = cVar.h;
        this.i = cVar.g;
        this.q = cVar.r;
        this.b = cVar.b;
        this.h = cVar.j;
        this.j = cVar.i;
        this.f12051a = cVar.e;
        this.m = cVar.o;
        this.d = cVar.d;
        this.l = cVar.k;
        this.k = cVar.n;
        this.g = cVar.f;
        this.s = cVar.t;
    }

    public String k() {
        return this.o;
    }

    public String n() {
        return this.n;
    }

    public String b() {
        return this.c;
    }

    public String a() {
        return this.e;
    }

    public String j() {
        return this.f;
    }

    public int h() {
        return this.i;
    }

    public String t() {
        return this.q;
    }

    public long d() {
        return this.b;
    }

    public long g() {
        return this.h;
    }

    public long i() {
        return this.j;
    }

    public String c() {
        return this.f12051a;
    }

    public String m() {
        return this.m;
    }

    public String e() {
        return this.d;
    }

    public String l() {
        return this.l;
    }

    public String o() {
        return this.k;
    }

    public String f() {
        return this.g;
    }

    public List<e> r() {
        return this.s;
    }

    public String toString() {
        return "DonateBean{MessageName=" + this.o + ", MessageId=" + this.n + ", DeviceModel=" + this.c + ", DeviceCategory=" + this.e + ", DeviceName=" + this.f + ", FeatureType=" + this.i + ", TimeZone=" + this.q + ", CreateTime=" + this.b + ", EffectiveTime=" + this.h + ", ExpirationTime=" + this.j + ", BundleName=" + this.f12051a + ", ModuleName=" + this.m + ", AbilityName=" + this.d + ", FormDimension=" + this.l + ", FormName=" + this.k + ", FeatureName=" + this.g + ", TimePeriods=" + this.s;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12052a;
        private long b;
        private String c;
        private String d;
        private String e;
        private String f;
        private int g;
        private String h;
        private long i;
        private long j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String o;
        private String r;
        private List<e> t;

        public cvp b() {
            return new cvp(this);
        }

        public c f(String str) {
            this.l = str;
            return this;
        }

        public c j(String str) {
            this.m = str;
            return this;
        }

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c a(String str) {
            this.f12052a = str;
            return this;
        }

        public c e(String str) {
            this.h = str;
            return this;
        }

        public c a(int i) {
            this.g = i;
            return this;
        }

        public c m(String str) {
            this.r = str;
            return this;
        }

        public c e(long j) {
            this.b = j;
            return this;
        }

        public c c(long j) {
            this.j = j;
            return this;
        }

        public c a(long j) {
            this.i = j;
            return this;
        }

        public c d(String str) {
            this.e = str;
            return this;
        }

        public c l(String str) {
            this.o = str;
            return this;
        }

        public c b(String str) {
            this.d = str;
            return this;
        }

        public c i(String str) {
            this.k = str;
            return this;
        }

        public c g(String str) {
            this.n = str;
            return this;
        }

        public c h(String str) {
            this.f = str;
            return this;
        }

        public c b(List<e> list) {
            this.t = list;
            return this;
        }
    }
}
