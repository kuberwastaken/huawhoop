package defpackage;

import com.google.gson.annotations.Expose;
import java.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public class hkm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Expose
    private int f13867a;

    @Expose
    private long d;

    public int b() {
        return this.f13867a;
    }

    public void e(int i) {
        this.f13867a = i;
    }

    public long c() {
        return this.d;
    }

    public void e(long j) {
        this.d = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hkm hkmVar = (hkm) obj;
        return this.d == hkmVar.d && this.f13867a == hkmVar.f13867a;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.d), Integer.valueOf(this.f13867a));
    }

    public String toString() {
        return "SportData{mGolfTotalTimes=" + this.d + ", mGolfTotalScore=" + this.f13867a + '}';
    }
}
