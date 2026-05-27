package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public final class np {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1301a;
    public String b;
    public int d;
    public long e;
    public short g;
    public boolean h;
    public int c = -113;
    public long f = 0;

    public np(boolean z) {
        this.h = z;
    }

    public final String a() {
        return this.h + "#" + this.f1301a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public np clone() {
        np npVar = new np(this.h);
        npVar.f1301a = this.f1301a;
        npVar.b = this.b;
        npVar.c = this.c;
        npVar.d = this.d;
        npVar.e = this.e;
        npVar.f = this.f;
        npVar.g = this.g;
        npVar.h = this.h;
        return npVar;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f1301a + ", ssid='" + this.b + "', rssi=" + this.c + ", frequency=" + this.d + ", timestamp=" + this.e + ", lastUpdateUtcMills=" + this.f + ", freshness=" + ((int) this.g) + ", connected=" + this.h + '}';
    }

    public static String a(long j) {
        if (j < 0 || j > 281474976710655L) {
            return null;
        }
        return nx.a(nx.a(j), ":");
    }

    public static long a(String str) {
        long j;
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i = 0;
        long j2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long jCharAt = str.charAt(length);
            if (jCharAt < 48 || jCharAt > 57) {
                long j3 = 97;
                if (jCharAt < 97 || jCharAt > 102) {
                    j3 = 65;
                    if (jCharAt < 65 || jCharAt > 70) {
                        if (jCharAt != 58 && jCharAt != 124) {
                            return 0L;
                        }
                    }
                }
                j = (jCharAt - j3) + 10;
            } else {
                j = jCharAt - 48;
            }
            j2 += j << i;
            i += 4;
        }
        if (i != 48) {
            return 0L;
        }
        return j2;
    }
}
