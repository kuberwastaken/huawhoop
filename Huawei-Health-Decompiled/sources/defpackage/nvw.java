package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class nvw implements Comparable {
    private ArrayList<c> b;
    private long c;
    private String e;

    public String d() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public void e(long j) {
        this.c = j;
    }

    public ArrayList<c> b() {
        return this.b;
    }

    public void e(ArrayList<c> arrayList) {
        this.b = arrayList;
    }

    public String toString() {
        return "HistoricalReportDataBean{mYearOrMonthTitle='" + this.e + "', mYearOrMonthTimestamp=" + this.c + ", mOneMonthOrWeekRecordList=" + this.b + '}';
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof nvw) {
            return Long.compare(((nvw) obj).c, this.c);
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof nvw) && this.c == ((nvw) obj).c;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public static class c implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f16201a;
        private int c;
        private String d;
        private long e;

        public long a() {
            return this.f16201a;
        }

        public void e(long j) {
            this.f16201a = j;
        }

        public long e() {
            return this.e;
        }

        public void d(long j) {
            this.e = j;
        }

        public void e(String str) {
            this.d = str;
        }

        public String d() {
            return this.d;
        }

        public int c() {
            return this.c;
        }

        public void e(int i) {
            this.c = i;
        }

        public String toString() {
            return "OneMonthOrWeekRecord{mStartTimestamp=" + this.f16201a + ", mEndTimestamp=" + this.e + ", mRecordTitle='" + this.d + "', mReportNumber=" + this.c + '}';
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            if (obj instanceof c) {
                return Long.compare(((c) obj).f16201a, this.f16201a);
            }
            return -1;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return (obj instanceof c) && this.f16201a == ((c) obj).f16201a;
        }

        public int hashCode() {
            return super.hashCode();
        }
    }
}
