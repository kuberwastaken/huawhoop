package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class mqi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15813a;
    private int b;
    private int[] c;
    private long d;
    private long e;
    private int f;
    private int g;
    private int h;

    private mqi(a aVar) {
        this.h = aVar.j;
        this.f = aVar.g;
        this.d = aVar.e;
        this.e = aVar.b;
        this.b = aVar.f15814a;
        this.g = aVar.f;
        this.f15813a = aVar.c;
        this.c = aVar.d;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15814a;
        private long b;
        private int c;
        private int[] d;
        private long e;
        private int f;
        private int g;
        private int j;

        public mqi c() {
            return new mqi(this);
        }

        public a a(int i) {
            this.j = i;
            return this;
        }

        public a b(int i) {
            this.g = i;
            return this;
        }

        public a c(long j) {
            this.e = j;
            return this;
        }

        public a d(long j) {
            this.b = j;
            return this;
        }

        public a e(int i) {
            this.f15814a = i;
            return this;
        }

        public a d(int i) {
            this.f = i;
            return this;
        }

        public a c(int[] iArr) {
            if (iArr != null) {
                this.d = (int[]) iArr.clone();
            }
            return this;
        }
    }

    public int j() {
        return this.h;
    }

    public int h() {
        return this.f;
    }

    public long c() {
        return this.d;
    }

    public long a() {
        return this.e;
    }

    public int b() {
        return this.b;
    }

    public int i() {
        return this.g;
    }

    public int e() {
        return this.f15813a;
    }

    public int[] d() {
        int[] iArr = this.c;
        if (iArr != null) {
            return (int[]) iArr.clone();
        }
        return null;
    }

    public String toString() {
        return "SportRecordQueryParam{mType=" + this.h + ", mSubType=" + this.f + ", mStartTime=" + this.d + ", mEndTime=" + this.e + ", mCount=" + this.b + ", mTimeUnit=" + this.g + ", mSortOrderType=" + this.f15813a + ", mMultiType=" + Arrays.toString(this.c) + '}';
    }
}
