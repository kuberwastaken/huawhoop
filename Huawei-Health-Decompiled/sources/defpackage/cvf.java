package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class cvf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12036a;
    private String b;
    private String c;
    private int d;
    private int e;

    public cvf(e eVar) {
        this.c = eVar.d;
        this.f12036a = eVar.c;
        this.d = eVar.e;
        this.e = eVar.b;
        this.b = eVar.f12037a;
    }

    public String d() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int a() {
        return this.f12036a;
    }

    public int e() {
        return this.e;
    }

    public String b() {
        return this.b;
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12037a;
        private int b;
        private int c;
        private String d;
        private int e;

        public e(String str, String str2) {
            this.d = str;
            this.f12037a = str2;
        }

        public e a(int i) {
            this.e = i;
            return this;
        }

        public e b(int i) {
            this.c = i;
            return this;
        }

        public e d(int i) {
            this.b = i;
            return this;
        }

        public cvf b() {
            return new cvf(this);
        }
    }

    public String toString() {
        return "SleepMonitorParam{mId='" + this.c + "', mGender=" + this.d + ", mAge=" + this.f12036a + ", mMaxSleepDuration=" + this.e + ", mActivityName='" + this.b + "'}";
    }
}
