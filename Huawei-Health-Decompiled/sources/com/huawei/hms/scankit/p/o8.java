package com.huawei.hms.scankit.p;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes10.dex */
public abstract class o8 {
    private static u6 a(float f, float f2, float f3, float f4, float f5, float f6) {
        return new u6((f + f5) - f3, (f2 + f6) - f4);
    }

    public static float b(int i, int i2, u6[] u6VarArr) {
        float fAbs;
        float fAbs2;
        float f = 1.0f;
        if (u6VarArr.length < 3) {
            return 1.0f;
        }
        float fB = u6VarArr[0].b();
        float fB2 = u6VarArr[1].b();
        float fB3 = u6VarArr[2].b();
        float fC = u6VarArr[0].c();
        float fC2 = u6VarArr[1].c();
        float fC3 = u6VarArr[2].c();
        float fMax = Math.max(Math.max(fB, fB2), fB3);
        float fMin = Math.min(Math.min(fB, fB2), fB3);
        float fMax2 = Math.max(Math.max(fC, fC2), fC3);
        float fMin2 = Math.min(Math.min(fC, fC2), fC3);
        int iMin = (int) (Math.min(i2, i) * 0.1f);
        Rect rect = new Rect(iMin, iMin, i - iMin, i2 - iMin);
        if (fMin < rect.left && fMin2 < rect.top && fMax > rect.right && fMax2 > rect.bottom) {
            return 1.0f;
        }
        float fAbs3 = Math.abs(fMax - rect.right);
        float fAbs4 = Math.abs(fMax2 - rect.bottom);
        float fAbs5 = Math.abs(fMin2 - rect.top);
        float fAbs6 = Math.abs(fMin - rect.left);
        float f2 = (rect.left + rect.right) / 2.0f;
        float f3 = (rect.top + rect.bottom) / 2.0f;
        float fMin3 = Math.min(Math.min(Math.min(fAbs6, fAbs3), fAbs5), fAbs4);
        if (0.01f > Math.abs(fAbs6 - fMin3)) {
            fAbs = Math.abs(f2 - rect.left);
            fAbs2 = Math.abs(f2 - fMin);
        } else if (0.01f > Math.abs(fAbs3 - fMin3)) {
            fAbs = Math.abs(f2 - rect.right);
            fAbs2 = Math.abs(f2 - fMax);
        } else if (0.01f > Math.abs(fAbs5 - fMin3)) {
            fAbs = Math.abs(f3 - rect.top);
            fAbs2 = Math.abs(f3 - fMin2);
        } else {
            if (0.01f > Math.abs(fAbs4 - fMin3)) {
                fAbs = Math.abs(f3 - rect.bottom);
                fAbs2 = Math.abs(f3 - fMax2);
            }
            return Math.min(f, 2.0f) * 0.9f;
        }
        f = fAbs / fAbs2;
        return Math.min(f, 2.0f) * 0.9f;
    }

    public static float a(int i, int i2, u6[] u6VarArr) {
        float fAbs;
        float fAbs2;
        float f = 1.0f;
        if (u6VarArr.length < 3) {
            return 1.0f;
        }
        int i3 = 0;
        for (u6 u6Var : u6VarArr) {
            if (u6Var.d()) {
                i3++;
            }
        }
        if (r3.f6055a && !r3.b && i3 < 2) {
            return 1.0f;
        }
        float fB = u6VarArr[0].b();
        float fB2 = u6VarArr[1].b();
        float fB3 = u6VarArr[2].b();
        float fC = u6VarArr[0].c();
        float fC2 = u6VarArr[1].c();
        float fC3 = u6VarArr[2].c();
        u6 u6VarA = a(fB, fC, fB2, fC2, fB3, fC3);
        float fB4 = u6VarA.b();
        float fC4 = u6VarA.c();
        float fMax = Math.max(Math.max(Math.max(fB, fB2), fB3), fB4);
        float fMin = Math.min(Math.min(Math.min(fB, fB2), fB3), fB4);
        float fMax2 = Math.max(Math.max(Math.max(fC, fC2), fC3), fC4);
        float fMin2 = Math.min(Math.min(Math.min(fC, fC2), fC3), fC4);
        int iMin = (int) (Math.min(i2, i) * 0.85f);
        int i4 = (i - iMin) / 2;
        int i5 = (i2 - iMin) / 2;
        Rect rect = new Rect(i4, i5, iMin + i4, iMin + i5);
        if (fMin < rect.left && fMin2 < rect.top && fMax > rect.right && fMax2 > rect.bottom) {
            return 1.0f;
        }
        float fAbs3 = Math.abs(fMin2 - rect.top);
        float fAbs4 = Math.abs(fMin - rect.left);
        float fAbs5 = Math.abs(fMax - rect.right);
        float fAbs6 = Math.abs(fMax2 - rect.bottom);
        float f2 = (rect.left + rect.right) / 2.0f;
        float f3 = (rect.top + rect.bottom) / 2.0f;
        float fMin3 = Math.min(Math.min(Math.min(fAbs4, fAbs5), fAbs3), fAbs6);
        if (0.01f > Math.abs(fAbs4 - fMin3)) {
            fAbs = Math.abs(f2 - rect.left) * 1.0f;
            fAbs2 = Math.abs(f2 - fMin);
        } else if (0.01f > Math.abs(fAbs5 - fMin3)) {
            fAbs = Math.abs(f2 - rect.right) * 1.0f;
            fAbs2 = Math.abs(f2 - fMax);
        } else if (0.01f > Math.abs(fAbs3 - fMin3)) {
            fAbs = Math.abs(f3 - rect.top) * 1.0f;
            fAbs2 = Math.abs(f3 - fMin2);
        } else {
            if (0.01f > Math.abs(fAbs6 - fMin3)) {
                fAbs = Math.abs(f3 - rect.bottom) * 1.0f;
                fAbs2 = Math.abs(f3 - fMax2);
            }
            return Math.min(f, 2.0f) * 0.9f;
        }
        f = fAbs / fAbs2;
        return Math.min(f, 2.0f) * 0.9f;
    }
}
