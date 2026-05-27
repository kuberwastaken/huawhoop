package com.huawei.haf.mediaprocess;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.work.Data;
import health.compact.a.LogUtil;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes.dex */
public class TextureRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[] f2169a = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private int b;
    private FloatBuffer f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int m;
    private float[] d = new float[16];
    private float[] c = new float[16];
    private int e = -12345;

    public TextureRenderer(int i) {
        this.m = i;
        float[] fArr = f2169a;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.c, 0);
    }

    public int a() {
        return this.e;
    }

    public void AJ_(SurfaceTexture surfaceTexture, boolean z) throws IOException {
        e("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.c);
        if (z) {
            float[] fArr = this.c;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glUseProgram(this.b);
        e("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.e);
        this.f.position(0);
        GLES20.glVertexAttribPointer(this.i, 3, 5126, false, 20, (Buffer) this.f);
        e("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.i);
        e("glEnableVertexAttribArray maPositionHandle");
        this.f.position(3);
        GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 20, (Buffer) this.f);
        e("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.g);
        e("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.j, 1, false, this.c, 0);
        GLES20.glUniformMatrix4fv(this.h, 1, false, this.d, 0);
        GLES20.glDrawArrays(5, 0, 4);
        e("glDrawArrays");
        GLES20.glFinish();
    }

    public void c() throws IOException {
        int iA = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.b = iA;
        if (iA == 0) {
            throw new IOException("failed creating program");
        }
        this.i = GLES20.glGetAttribLocation(iA, "aPosition");
        e("glGetAttribLocation aPosition");
        if (this.i == -1) {
            throw new IOException("Could not get attrib location for aPosition");
        }
        this.g = GLES20.glGetAttribLocation(this.b, "aTextureCoord");
        e("glGetAttribLocation aTextureCoord");
        if (this.g == -1) {
            throw new IOException("Could not get attrib location for aTextureCoord");
        }
        this.h = GLES20.glGetUniformLocation(this.b, "uMVPMatrix");
        e("glGetUniformLocation uMVPMatrix");
        if (this.h == -1) {
            throw new IOException("Could not get attrib location for uMVPMatrix");
        }
        this.j = GLES20.glGetUniformLocation(this.b, "uSTMatrix");
        e("glGetUniformLocation uSTMatrix");
        if (this.j == -1) {
            throw new IOException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.e = i;
        GLES20.glBindTexture(36197, i);
        e("glBindTexture mTextureId");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        e("glTexParameter");
        Matrix.setIdentityM(this.d, 0);
        int i2 = this.m;
        if (i2 != 0) {
            Matrix.rotateM(this.d, 0, i2, 0.0f, 0.0f, 1.0f);
        }
    }

    private int a(int i, String str) throws IOException {
        int iGlCreateShader = GLES20.glCreateShader(i);
        e("glCreateShader type=" + i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    private int a(String str, String str2) throws IOException {
        int iA;
        int iA2 = a(35633, str);
        if (iA2 == 0 || (iA = a(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        e("glCreateProgram");
        if (iGlCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, iA2);
        e("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iA);
        e("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public void e(String str) throws IOException {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        LogUtil.d("TextureRenderer", str, ": glError ", Integer.valueOf(iGlGetError));
        throw new IOException(str + ": glError " + iGlGetError);
    }
}
