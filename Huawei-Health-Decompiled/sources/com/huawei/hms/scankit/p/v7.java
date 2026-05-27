package com.huawei.hms.scankit.p;

import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public abstract class v7 {
    public static List a(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int size = list.size() - 1; size > i; size--) {
                if (((s6) list.get(i)).k().equals(((s6) list.get(size)).k()) && a(r2.j(), r3.j()) > 0.5d) {
                    list.remove(size);
                }
            }
        }
        return list;
    }

    public static float a(u6[] u6VarArr, u6[] u6VarArr2) {
        float fB = Float.MIN_VALUE;
        float fB2 = Float.MAX_VALUE;
        float fB3 = Float.MIN_VALUE;
        float fC = Float.MIN_VALUE;
        float fB4 = Float.MAX_VALUE;
        float fC2 = Float.MAX_VALUE;
        for (u6 u6Var : u6VarArr) {
            if (u6Var.b() > fB3) {
                fB3 = u6Var.b();
            }
            if (u6Var.b() < fB4) {
                fB4 = u6Var.b();
            }
            if (u6Var.c() > fC) {
                fC = u6Var.c();
            }
            if (u6Var.c() < fC2) {
                fC2 = u6Var.c();
            }
        }
        float fC3 = Float.MIN_VALUE;
        float fC4 = Float.MAX_VALUE;
        for (u6 u6Var2 : u6VarArr2) {
            if (u6Var2.b() > fB) {
                fB = u6Var2.b();
            }
            if (u6Var2.b() < fB2) {
                fB2 = u6Var2.b();
            }
            if (u6Var2.c() > fC3) {
                fC3 = u6Var2.c();
            }
            if (u6Var2.c() < fC4) {
                fC4 = u6Var2.c();
            }
        }
        float f = (fB < fB3 ? fB : fB3) - (fB2 > fB4 ? fB2 : fB4);
        float f2 = (fC3 < fC ? fC3 : fC) - (fC4 > fC2 ? fC4 : fC2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = f * f2;
        return f3 / ((((fB3 - fB4) * (fC - fC2)) + ((fB - fB2) * (fC3 - fC4))) - f3);
    }
}
