package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes7.dex */
public class nqr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(ParsedFieldTag.ACTION_TYPE)
    private final int f16126a;

    @SerializedName("timestamp")
    private long aa;

    @SerializedName("endTime")
    private final String b;

    @SerializedName(ParsedFieldTag.GAIN_COUNT)
    private final int c;

    @SerializedName(ParsedFieldTag.FIRST_TAB_DESC)
    private String d;

    @SerializedName(ParsedFieldTag.FIRST_TAB_PRIORITY)
    private int e;

    @SerializedName(ParsedFieldTag.GRAY_DESC)
    private final String f;

    @SerializedName(ParsedFieldTag.GOAL)
    private int g;

    @SerializedName(ParsedFieldTag.LIGHT_DESC)
    private final String h;

    @SerializedName("gainTime")
    private final String i;

    @SerializedName(ParsedFieldTag.GRAY_PRO_NAME)
    private String j;

    @SerializedName(ParsedFieldTag.LIGHT_PRO_NAME)
    private String k;

    @SerializedName(ParsedFieldTag.MEDAL_ID)
    private final String l;

    @SerializedName("medalName")
    private final String m;

    @SerializedName(ParsedFieldTag.MEDAL_LEVEL)
    private int n;

    @SerializedName("medalLabel")
    private final int o;

    @SerializedName("message")
    private final String p;

    @SerializedName(ParsedFieldTag.MEDAL_WEIGHT)
    private int q;

    @SerializedName("medalUnit")
    private final int r;

    @SerializedName(ParsedFieldTag.MEDAL_TYPE)
    private final String s;

    @SerializedName(ParsedFieldTag.REPEATABLE)
    private int t;

    @SerializedName("status")
    private int u;

    @SerializedName(ParsedFieldTag.SECOND_TAB_PRIORITY)
    private int v;

    @SerializedName("startTime")
    private final String w;

    @SerializedName(ParsedFieldTag.SECOND_TAB_DESC)
    private String x;

    @SerializedName(ParsedFieldTag.TAKE_DATE)
    private final String y;

    private nqr(c cVar) {
        this.l = cVar.n;
        this.m = cVar.m;
        this.p = cVar.s;
        this.h = cVar.f;
        this.f = cVar.j;
        this.c = cVar.c;
        this.i = cVar.i;
        this.r = cVar.t;
        this.s = cVar.r;
        this.o = cVar.l;
        this.f16126a = cVar.e;
        this.w = cVar.y;
        this.b = cVar.d;
        this.y = cVar.v;
        this.aa = cVar.ad;
        this.j = cVar.h;
        this.k = cVar.o;
        this.g = cVar.g;
        this.n = cVar.k;
        this.t = cVar.q;
        this.u = cVar.x;
        this.e = cVar.b;
        this.d = cVar.f16127a;
        this.v = cVar.w;
        this.x = cVar.u;
        this.q = cVar.p;
    }

    public String d() {
        return this.l;
    }

    public String c() {
        return this.m;
    }

    public String i() {
        return this.p;
    }

    public String a() {
        return this.h;
    }

    public String b() {
        return this.i;
    }

    public String e() {
        return this.s;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f16127a;
        private long ad;
        private int b;
        private int c;
        private String d;
        private int e;
        private String f;
        private int g;
        private String h;
        private String i;
        private String j;
        private int k;
        private int l;
        private String m;
        private final String n;
        private String o;
        private int p;
        private int q;
        private String r;
        private String s;
        private int t;
        private String u;
        private String v;
        private int w;
        private int x;
        private String y;

        public c(String str) {
            this.n = str;
        }

        public c f(String str) {
            this.m = str;
            return this;
        }

        public c h(String str) {
            this.s = str;
            return this;
        }

        public c j(String str) {
            this.f = str;
            return this;
        }

        public c i(String str) {
            this.j = str;
            return this;
        }

        public c e(int i) {
            this.c = i;
            return this;
        }

        public c e(String str) {
            this.i = str;
            return this;
        }

        public c m(String str) {
            this.r = str;
            return this;
        }

        public c a(long j) {
            this.ad = j;
            return this;
        }

        public c j(int i) {
            this.t = i;
            return this;
        }

        public c c(int i) {
            this.l = i;
            return this;
        }

        public c b(int i) {
            this.e = i;
            return this;
        }

        public c g(String str) {
            this.y = str;
            return this;
        }

        public c c(String str) {
            this.d = str;
            return this;
        }

        public c l(String str) {
            this.v = str;
            return this;
        }

        public c b(String str) {
            this.h = str;
            return this;
        }

        public c a(String str) {
            this.o = str;
            return this;
        }

        public c a(int i) {
            this.g = i;
            return this;
        }

        public c h(int i) {
            this.k = i;
            return this;
        }

        public c g(int i) {
            this.q = i;
            return this;
        }

        public c n(int i) {
            this.x = i;
            return this;
        }

        public c d(int i) {
            this.b = i;
            return this;
        }

        public c d(String str) {
            this.f16127a = str;
            return this;
        }

        public c i(int i) {
            this.w = i;
            return this;
        }

        public c n(String str) {
            this.u = str;
            return this;
        }

        public c f(int i) {
            this.p = i;
            return this;
        }

        public nqr b() {
            return new nqr(this);
        }
    }
}
