package defpackage;

import android.content.Context;
import android.opengl.GLES20;

/* JADX INFO: loaded from: classes5.dex */
public class iuy extends iuw {
    protected int[] b;
    protected int[] c;

    public iuy(Context context, int i, int i2) {
        super(context, i, i2);
    }

    @Override // defpackage.iuw
    protected void b() {
        this.g.clear();
        this.g.put(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    @Override // defpackage.iuw
    public void d(int i, int i2, int i3, int i4) {
        super.d(i, i2, i3, i4);
        c();
    }

    private void c() {
        if (this.b != null) {
            d();
        }
        int[] iArr = new int[1];
        this.b = iArr;
        GLES20.glGenFramebuffers(1, iArr, 0);
        int[] iArr2 = new int[1];
        this.c = iArr2;
        ivc.c(iArr2);
        GLES20.glBindTexture(3553, this.c[0]);
        GLES20.glTexImage2D(3553, 0, 6408, this.i, this.j, 0, 6408, 5121, null);
        GLES20.glBindFramebuffer(36160, this.b[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.c[0], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void d() {
        int[] iArr = this.c;
        if (iArr != null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            this.c = null;
        }
        int[] iArr2 = this.b;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(1, iArr2, 0);
            this.b = null;
        }
    }
}
