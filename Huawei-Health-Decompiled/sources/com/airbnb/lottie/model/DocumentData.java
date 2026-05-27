package com.airbnb.lottie.model;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f723a;
    public float b;
    public PointF c;
    public PointF d;
    public String e;
    public int f;
    public boolean g;
    public float h;
    public Justification i;
    public float j;
    public float k;
    public String n;
    public int o;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        ag_(str, str2, f, justification, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public DocumentData() {
    }

    public void ag_(String str, String str2, float f, Justification justification, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.n = str;
        this.e = str2;
        this.h = f;
        this.i = justification;
        this.o = i;
        this.j = f2;
        this.b = f3;
        this.f723a = i2;
        this.f = i3;
        this.k = f4;
        this.g = z;
        this.d = pointF;
        this.c = pointF2;
    }

    public int hashCode() {
        int iHashCode = (int) ((((this.n.hashCode() * 31) + this.e.hashCode()) * 31) + this.h);
        int iOrdinal = this.i.ordinal();
        int i = this.o;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.j);
        return (((((((iHashCode * 31) + iOrdinal) * 31) + i) * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f723a;
    }
}
