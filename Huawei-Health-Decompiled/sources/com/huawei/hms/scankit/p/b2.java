package com.huawei.hms.scankit.p;

import java.util.Formatter;

/* JADX INFO: loaded from: classes10.dex */
class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a0 f5929a;
    private final x0[] b;

    b2(a0 a0Var) {
        this.f5929a = new a0(a0Var);
        this.b = new x0[(a0Var.d() - a0Var.f()) + 1];
    }

    final x0 b(int i) {
        x0 x0Var;
        x0 x0Var2;
        x0 x0VarA = a(i);
        if (x0VarA != null) {
            return x0VarA;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iC = c(i) - i2;
            if (iC >= 0 && (x0Var2 = this.b[iC]) != null) {
                return x0Var2;
            }
            int iC2 = c(i) + i2;
            x0[] x0VarArr = this.b;
            if (iC2 < x0VarArr.length && (x0Var = x0VarArr[iC2]) != null) {
                return x0Var;
            }
        }
        return null;
    }

    final int c(int i) {
        return i - this.f5929a.f();
    }

    final a0 a() {
        return this.f5929a;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (x0 x0Var : this.b) {
                if (x0Var == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(x0Var.c()), Integer.valueOf(x0Var.e()));
                }
                i++;
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                formatter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    final x0[] b() {
        return this.b;
    }

    final x0 a(int i) {
        return this.b[c(i)];
    }

    final void a(int i, x0 x0Var) {
        this.b[c(i)] = x0Var;
    }
}
