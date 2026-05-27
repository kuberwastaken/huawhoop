package com.huawei.ucd.helper.gles;

import android.opengl.Matrix;
import java.util.Stack;

/* JADX INFO: loaded from: classes11.dex */
public class MVPMatrixAider {
    private ProjectType f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f9093a = new float[16];
    private float[] i = new float[16];
    private float[] e = new float[16];
    private float[] c = new float[16];
    private float[] b = new float[16];
    private float[] g = new float[16];
    public Stack<float[]> d = new Stack<>();

    enum ProjectType {
        ORTHO,
        FRUSTUM
    }

    public void j() {
        this.d.push((float[]) this.e.clone());
    }

    public void g() {
        this.e = this.d.pop();
    }

    public void f() {
        this.f9093a = null;
        this.i = null;
        this.e = null;
        this.c = null;
        this.b = null;
        this.g = null;
    }

    public float[] h() {
        Matrix.multiplyMM(this.g, 0, this.f9093a, 0, this.i, 0);
        return (float[]) this.g.clone();
    }

    public float[] d() {
        Matrix.multiplyMM(this.b, 0, this.i, 0, this.e, 0);
        float[] fArr = this.b;
        Matrix.multiplyMM(fArr, 0, this.f9093a, 0, fArr, 0);
        return (float[]) this.b.clone();
    }

    public float[] c() {
        Matrix.multiplyMM(this.c, 0, this.i, 0, this.e, 0);
        return (float[]) this.c.clone();
    }

    public float[] a() {
        return (float[]) this.f9093a.clone();
    }

    public float[] e() {
        return (float[]) this.i.clone();
    }

    public float[] b() {
        return (float[]) this.e.clone();
    }

    public void i() {
        Matrix.setRotateM(this.e, 0, 0.0f, 1.0f, 0.0f, 0.0f);
    }

    public void e(float f, float f2, float f3) {
        Matrix.translateM(this.e, 0, f, f2, f3);
    }

    public void d(float f, float f2, float f3, float f4) {
        Matrix.rotateM(this.e, 0, f, f2, f3, f4);
    }

    public void a(float f, float f2, float f3) {
        Matrix.scaleM(this.e, 0, f, f2, f3);
    }

    public void c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        Matrix.setLookAtM(this.i, 0, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        Matrix.frustumM(this.f9093a, 0, f, f2, f3, f4, f5, f6);
        this.f = ProjectType.FRUSTUM;
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        Matrix.orthoM(this.f9093a, 0, f, f2, f3, f4, f5, f6);
        this.f = ProjectType.ORTHO;
    }
}
