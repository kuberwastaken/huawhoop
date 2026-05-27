package defpackage;

import java.util.Date;

/* JADX INFO: loaded from: classes11.dex */
public class vea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f18598a;
    private int b;
    private int d;

    public void e(long j) {
        this.f18598a = j;
    }

    public int e() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.d = i;
    }

    public String toString() {
        return "stressEndTime = " + kqy.d(new Date(this.f18598a * 1000)) + " stressScore = " + this.d + " stressGrade = " + this.d;
    }
}
