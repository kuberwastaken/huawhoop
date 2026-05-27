package com.huawei.healthcloud.plugintrack.ui.view.glrender.filter;

import android.content.Context;
import android.opengl.GLES20;
import com.huawei.health.R;
import defpackage.iuy;
import java.nio.Buffer;

/* JADX INFO: loaded from: classes5.dex */
public class CameraFilter extends iuy {
    protected int r;
    private float[] s;
    protected float[] t;

    @Override // defpackage.iuy, defpackage.iuw
    public void b() {
    }

    public CameraFilter(Context context) {
        super(context, R.raw._2131886145_res_0x7f120041, R.raw._2131886144_res_0x7f120040);
        this.r = GLES20.glGetUniformLocation(this.o, "uMVPMatrix");
    }

    @Override // defpackage.iuw
    public int a(int i) {
        GLES20.glViewport(0, 0, this.i, this.j);
        GLES20.glBindFramebuffer(36160, this.b[0]);
        GLES20.glUseProgram(this.o);
        this.f.position(0);
        GLES20.glVertexAttribPointer(this.l, 2, 5126, false, 0, (Buffer) this.f);
        GLES20.glEnableVertexAttribArray(this.l);
        this.g.position(0);
        GLES20.glVertexAttribPointer(this.f14307a, 2, 5126, false, 0, (Buffer) this.g);
        GLES20.glEnableVertexAttribArray(this.f14307a);
        GLES20.glUniformMatrix4fv(this.h, 1, false, this.t, 0);
        GLES20.glUniformMatrix4fv(this.r, 1, false, this.s, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(this.n, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(36197, 0);
        return this.c[0];
    }

    public void d(float[] fArr) {
        if (fArr != null) {
            this.t = (float[]) fArr.clone();
        }
    }

    public void c(float[] fArr) {
        if (fArr != null) {
            this.s = (float[]) fArr.clone();
        }
    }
}
