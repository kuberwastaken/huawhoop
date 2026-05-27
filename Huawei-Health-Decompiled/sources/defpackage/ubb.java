package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class ubb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f18250a;
    private int c;
    private long e;

    private ubb(c cVar) {
        this.f18250a = cVar.b;
        this.e = cVar.c;
        this.c = cVar.d;
    }

    public long a() {
        return this.f18250a;
    }

    public long c() {
        return this.e;
    }

    public int b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ubb)) {
            return false;
        }
        ubb ubbVar = (ubb) obj;
        return ubbVar.a() == this.f18250a && ubbVar.c() == this.e && ubbVar.b() == this.c;
    }

    public int hashCode() {
        return Long.valueOf(this.f18250a).hashCode() + Long.valueOf(this.e).hashCode() + Integer.valueOf(this.c).hashCode();
    }

    public static class c {
        private long b;
        private long c;
        private int d;

        public ubb a() {
            return new ubb(this);
        }

        public c b(long j) {
            this.b = j;
            return this;
        }

        public c d(long j) {
            this.c = j;
            return this;
        }

        public c b(int i) {
            this.d = i;
            return this;
        }
    }

    public String toString() {
        return "startTIme = " + this.f18250a + ", endTime = " + this.e + ", sportType = " + this.c;
    }
}
