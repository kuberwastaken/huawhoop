package defpackage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.work.Data;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class ijy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[] f14166a;
    private static final FloatBuffer b;
    private static final FloatBuffer c;
    private static final float[] d;
    private float[] e;
    private int f;
    private int g;
    private int h;
    private float[] i;
    private int j;
    private int k;
    private int m;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        d = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        f14166a = fArr2;
        c = ijw.d(fArr);
        b = ijw.d(fArr2);
    }

    public ijy(int i, int i2) {
        this();
    }

    public ijy() {
        this.e = new float[16];
        float[] fArr = new float[16];
        this.i = fArr;
        this.j = -12345;
        Matrix.setIdentityM(fArr, 0);
    }

    public int e() {
        return this.j;
    }

    public void d() {
        int iD = ijw.d("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec4 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = uSTMatrix * aTextureCoord;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec4 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord.xy/vTextureCoord.z);}\n");
        this.f = iD;
        if (iD == 0) {
            throw new ijr("failed creating program");
        }
        this.h = GLES20.glGetAttribLocation(iD, "aPosition");
        this.g = GLES20.glGetAttribLocation(this.f, "aTextureCoord");
        this.k = GLES20.glGetUniformLocation(this.f, "uMVPMatrix");
        this.m = GLES20.glGetUniformLocation(this.f, "uSTMatrix");
        this.j = b();
    }

    public static int b() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, 9728);
        return iArr[0];
    }

    public void a() {
        GLES20.glUseProgram(this.f);
        GLES20.glEnableVertexAttribArray(this.h);
        GLES20.glVertexAttribPointer(this.h, 3, 5126, false, 12, (Buffer) c);
        GLES20.glEnableVertexAttribArray(this.g);
        GLES20.glVertexAttribPointer(this.g, 4, 5126, false, 16, (Buffer) b);
        Matrix.setIdentityM(this.e, 0);
        GLES20.glUniformMatrix4fv(this.k, 1, false, this.e, 0);
        GLES20.glUniformMatrix4fv(this.m, 1, false, this.i, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.h);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glUseProgram(0);
    }
}
