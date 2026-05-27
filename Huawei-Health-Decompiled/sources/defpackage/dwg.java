package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class dwg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("heartRateControl")
    private boolean f12462a;

    @SerializedName("marketing")
    private boolean c;

    @SerializedName("historyRecords")
    private boolean d;

    @SerializedName("lightEffectSetting")
    private boolean e;

    @SerializedName("personalPerformance")
    private c f;

    @SerializedName("uuid")
    private String h;

    @SerializedName("menuItems")
    private e g = new e();

    @SerializedName("modes")
    private a i = new a();

    @SerializedName("enhanceMode")
    private d b = new d();

    public boolean b() {
        return this.f12462a;
    }

    public boolean f() {
        return this.d;
    }

    public boolean j() {
        return this.c;
    }

    public boolean g() {
        return this.e;
    }

    public e a() {
        return this.g;
    }

    public a c() {
        return this.i;
    }

    public d e() {
        return this.b;
    }

    public c d() {
        return this.f;
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("authorizeHeightWeight")
        private boolean f12465a;

        @SerializedName("deleteDevice")
        private boolean b;

        @SerializedName("ota")
        private C0314e c;

        @SerializedName("deviceInfo")
        private boolean e;

        public boolean d() {
            return this.b;
        }

        public C0314e a() {
            return this.c;
        }

        public boolean e() {
            return this.e;
        }

        public boolean b() {
            return this.f12465a;
        }

        /* JADX INFO: renamed from: dwg$e$e, reason: collision with other inner class name */
        public static class C0314e {

            @SerializedName("otaRedPoint")
            private boolean d;

            public boolean c() {
                return this.d;
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("caloriesMode")
        private boolean f12463a;

        @SerializedName("countingMode")
        private boolean b;

        @SerializedName("fancyMode")
        private boolean c;

        @SerializedName("distanceMode")
        private boolean d;

        @SerializedName("freeMode")
        private boolean e;

        @SerializedName("timingMode")
        private boolean f;

        public boolean c() {
            return this.e;
        }

        public boolean g() {
            return this.f;
        }

        public boolean b() {
            return this.d;
        }

        public boolean e() {
            return this.f12463a;
        }

        public boolean d() {
            return this.b;
        }

        public boolean a() {
            return this.c;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("intervalTraining")
        private boolean f12464a;

        @SerializedName("multiplayer")
        private boolean b;

        @SerializedName("musicJumpSetting")
        private boolean c;

        @SerializedName("music")
        private boolean d;

        @SerializedName("courseJumpSetting")
        private boolean e;

        @SerializedName("ropeSetting")
        private boolean f;

        @SerializedName("warmUp")
        private boolean h;

        public boolean f() {
            return this.h;
        }

        public boolean c() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }

        public boolean a() {
            return this.c;
        }

        public boolean b() {
            return this.f12464a;
        }

        public boolean g() {
            return this.f;
        }

        public boolean d() {
            return this.b;
        }
    }

    public static class c {

        @SerializedName("ropePerformance ")
        private boolean b;

        public boolean b() {
            return this.b;
        }
    }
}
