package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class dbh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12139a;
    private long c;
    private int e;

    private dbh(int i, long j, String str) {
        this.e = i;
        this.c = j;
        this.f12139a = str;
    }

    public int c() {
        return ((Integer) dne.b(Integer.valueOf(this.e))).intValue();
    }

    public long e() {
        return ((Long) dne.b(Long.valueOf(this.c))).longValue();
    }

    public String b() {
        return (String) dne.b(this.f12139a);
    }

    public static final class e {
        private static final int[] c = {1, 2, 4, 8, 16, 32};
        private int d = 1;
        private long e = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12140a = "no";

        public e b(int i) {
            for (int i2 : c) {
                if (i2 == i) {
                    this.d = i;
                    return this;
                }
            }
            throw new IllegalArgumentException("invalid scan type " + i);
        }

        public e e(long j, TimeUnit timeUnit) {
            if (j < 0 && j != -1) {
                throw new IllegalArgumentException("invalid scan duration " + j);
            }
            this.e = j > 0 ? (int) timeUnit.toMillis(j) : -1L;
            return this;
        }

        public e d(String str) {
            this.f12140a = str;
            return this;
        }

        public dbh c() {
            return new dbh(this.d, this.e, this.f12140a);
        }
    }
}
