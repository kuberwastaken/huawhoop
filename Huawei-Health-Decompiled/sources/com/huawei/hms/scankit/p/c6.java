package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes10.dex */
public class c6 implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j2 f5943a;
    public int b;

    public c6(j2 j2Var, int i) {
        this.f5943a = j2Var;
        this.b = i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c6 c6Var) {
        return Float.compare((-c6Var.f5943a.g()) + c6Var.f5943a.h(), (-this.f5943a.g()) + this.f5943a.h());
    }
}
