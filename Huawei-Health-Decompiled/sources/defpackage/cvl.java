package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class cvl {
    private long b;
    private long c;
    private long e;

    public cvl(c cVar) {
        this.c = cVar.d;
        this.e = cVar.c;
        this.b = cVar.e;
    }

    public long d() {
        return this.c;
    }

    public long a() {
        return this.e;
    }

    public long b() {
        return this.b;
    }

    public String toString() {
        return "SleepRegularParam{mSleepBeginTime=" + this.c + ", mSleepEndTime=" + this.e + ", mSleepValidTime=" + this.b + '}';
    }

    public static class c {
        private long c;
        private long d;
        private long e;

        public c e(long j) {
            this.d = j;
            return this;
        }

        public c a(long j) {
            this.c = j;
            return this;
        }

        public c b(long j) {
            this.e = j;
            return this;
        }

        public cvl d() {
            return new cvl(this);
        }
    }
}
