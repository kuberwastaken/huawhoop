package defpackage;

import android.content.Context;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class iuw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f14307a;
    private Context b;
    protected int d;
    protected String e;
    protected final FloatBuffer f;
    protected final FloatBuffer g;
    protected int h;
    protected int i;
    protected int j;
    protected String k;
    protected int l;
    protected int m;
    protected int n;
    protected int o;
    protected int p;
    protected int q;

    protected void b() {
    }

    public iuw(Context context, int i, int i2) {
        this.b = context;
        this.m = i;
        this.d = i2;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.clear();
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f});
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.g = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.clear();
        floatBufferAsFloatBuffer2.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        c(context);
    }

    private void c(Context context) {
        this.k = ivc.a(context, this.m);
        String strA = ivc.a(context, this.d);
        this.e = strA;
        int iD = ivc.d(this.k, strA);
        this.o = iD;
        this.l = GLES20.glGetAttribLocation(iD, "vPosition");
        this.f14307a = GLES20.glGetAttribLocation(this.o, "vCoord");
        this.h = GLES20.glGetUniformLocation(this.o, "vMatrix");
        this.n = GLES20.glGetUniformLocation(this.o, "vTexture");
        b();
    }

    public void d(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i2;
        this.p = i3;
        this.q = i4;
    }

    public int a(int i) {
        GLES20.glViewport(this.p, this.q, this.i, this.j);
        GLES20.glUseProgram(this.o);
        this.f.position(0);
        GLES20.glVertexAttribPointer(this.l, 2, 5126, false, 0, (Buffer) this.f);
        GLES20.glEnableVertexAttribArray(this.l);
        this.g.position(0);
        GLES20.glVertexAttribPointer(this.f14307a, 2, 5126, false, 0, (Buffer) this.g);
        GLES20.glEnableVertexAttribArray(this.f14307a);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.n, 0);
        GLES20.glDrawArrays(5, 0, 4);
        return i;
    }

    public void e() {
        GLES20.glDeleteProgram(this.o);
    }
}
