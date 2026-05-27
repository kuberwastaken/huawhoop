package defpackage;

import org.ahocorasick.interval.Intervalable;

/* JADX INFO: loaded from: classes8.dex */
public class ybl implements Intervalable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19226a;
    private int e;

    public ybl(int i, int i2) {
        this.e = i;
        this.f19226a = i2;
    }

    @Override // org.ahocorasick.interval.Intervalable
    public int getStart() {
        return this.e;
    }

    @Override // org.ahocorasick.interval.Intervalable
    public int getEnd() {
        return this.f19226a;
    }

    @Override // org.ahocorasick.interval.Intervalable
    public int size() {
        return (this.f19226a - this.e) + 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Intervalable)) {
            return false;
        }
        Intervalable intervalable = (Intervalable) obj;
        return this.e == intervalable.getStart() && this.f19226a == intervalable.getEnd();
    }

    public int hashCode() {
        return (this.e % 100) + (this.f19226a % 100);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof Intervalable)) {
            return -1;
        }
        Intervalable intervalable = (Intervalable) obj;
        int start = this.e - intervalable.getStart();
        return start != 0 ? start : this.f19226a - intervalable.getEnd();
    }

    public String toString() {
        return this.e + ":" + this.f19226a;
    }
}
