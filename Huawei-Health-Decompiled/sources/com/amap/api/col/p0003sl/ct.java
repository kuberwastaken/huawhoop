package com.amap.api.col.p0003sl;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes3.dex */
public class ct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f880a;
    public int b;
    public int c;
    private boolean d;

    public final void a() {
        int i = this.f880a;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        int i2 = this.b;
        if (i2 >= 0) {
            GLES20.glDeleteShader(i2);
        }
        int i3 = this.c;
        if (i3 >= 0) {
            GLES20.glDeleteShader(i3);
        }
        this.d = true;
    }
}
