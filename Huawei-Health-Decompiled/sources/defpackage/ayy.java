package defpackage;

import android.graphics.LinearGradient;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes10.dex */
public class ayy extends LinearGradient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shader.TileMode f385a;
    private final float b;
    private final int[] c;
    private final float d;
    private final float[] e;
    private final float g;
    private final float h;

    public ayy(float f, float f2, float f3, float f4, int[] iArr, float[] fArr, Shader.TileMode tileMode) {
        super(f, f2, f3, f4, iArr, fArr, tileMode);
        this.d = f;
        this.h = f2;
        this.b = f3;
        this.g = f4;
        this.c = iArr;
        this.e = fArr;
        this.f385a = tileMode;
    }

    public float b() {
        return this.d;
    }

    public float j() {
        return this.h;
    }

    public float a() {
        return this.b;
    }

    public float f() {
        return this.g;
    }

    public int[] e() {
        return this.c;
    }

    public float[] d() {
        return this.e;
    }

    public Shader.TileMode hy_() {
        return this.f385a;
    }
}
