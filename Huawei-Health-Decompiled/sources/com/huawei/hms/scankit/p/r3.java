package com.huawei.hms.scankit.p;

import java.util.Stack;

/* JADX INFO: loaded from: classes10.dex */
public abstract class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6055a = true;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static boolean f = true;
    public static boolean g = false;
    public static boolean h = false;
    public static float i = -1.0f;
    public static int j = 0;
    public static int k = 0;
    public static boolean l = false;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean o = false;
    public static boolean p = false;
    public static boolean q = false;
    public static boolean r = false;
    public static boolean s = false;
    public static boolean t = false;
    public static boolean u = false;
    public static boolean[] v = new boolean[8];
    public static Stack w = new Stack();
    public static boolean x = true;
    public static float[] y = new float[4];
    public static int z = 0;
    public static boolean A = false;

    public static void a(x6 x6Var) {
        a();
        boolean z2 = x6Var.e;
        c = z2;
        x = x6Var.g;
        if (!z2) {
            a(x6Var.f);
        } else {
            a(1);
        }
    }

    public static void a() {
        h = false;
        i = -1.0f;
        j = 0;
        p = false;
        q = false;
        r = false;
        t = false;
        m = false;
        n = false;
        o = false;
        s = false;
        v = new boolean[8];
        w = new Stack();
        x = true;
        e = false;
        d = false;
    }

    public static void a(int i2) {
        if (i2 % 2 == 1) {
            p = true;
        }
        if (i2 % 3 == 2) {
            q = true;
        }
        if (i2 % 5 == 4) {
            r = true;
        }
    }
}
