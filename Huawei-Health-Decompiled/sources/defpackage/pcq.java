package defpackage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import androidx.work.Data;
import com.huawei.ucd.medal.MedalViewCallback;

/* JADX INFO: loaded from: classes11.dex */
public class pcq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16626a = "TextureHelper";

    public static int cGv_(Bitmap bitmap, pcp pcpVar, boolean z) {
        pcj.b(f16626a, "initTextureID(Bitmap bitmap, TextureOptions options, boolean recycleBmp)");
        if (pcpVar == null) {
            pcpVar = pcp.a();
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, pcpVar.d);
        GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, pcpVar.f16624a);
        GLES20.glTexParameterf(3553, 10242, pcpVar.b);
        GLES20.glTexParameterf(3553, 10243, pcpVar.e);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        if (pcpVar.c) {
            GLES20.glGenerateMipmap(3553);
        }
        if (z) {
            bitmap.recycle();
        }
        return i;
    }

    public static void cGt_(Bitmap bitmap) {
        GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
    }

    public static int cGw_(Bitmap bitmap, pcp pcpVar, boolean z, MedalViewCallback medalViewCallback) {
        int i;
        String str = f16626a;
        pcj.b(str, "initTextureID(Bitmap bitmap, TextureOptions options, boolean recycleBmp)");
        if (pcpVar == null) {
            pcpVar = pcp.a();
        }
        int[] iArr = new int[1];
        int i2 = 0;
        try {
            GLES20.glGenTextures(1, iArr, 0);
            i = iArr[0];
        } catch (Exception e) {
            e = e;
        }
        try {
            GLES20.glBindTexture(3553, i);
            GLES20.glTexParameterf(3553, 10241, pcpVar.d);
            GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, pcpVar.f16624a);
            GLES20.glTexParameterf(3553, 10242, pcpVar.b);
            GLES20.glTexParameterf(3553, 10243, pcpVar.e);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            boolean z2 = pcpVar.c;
            pcj.b(str, "initTextureID useMipmap=" + z2);
            if (z2) {
                GLES20.glGenerateMipmap(3553);
            }
            if (z) {
                bitmap.recycle();
            }
            GLES20.glFinish();
            medalViewCallback.onResponse(200, "initTextureID texImage2D success.");
            return i;
        } catch (Exception e2) {
            e = e2;
            i2 = i;
            pcj.b(f16626a, "initTextureID Exception error.");
            medalViewCallback.onResponse(-1, e.getMessage());
            return i2;
        }
    }

    public static void cGu_(Bitmap bitmap, MedalViewCallback medalViewCallback) {
        pcj.b(f16626a, "changeTextureImage");
        try {
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            GLES20.glFinish();
            medalViewCallback.onResponse(200, "changeTextureImage texImage2D success.");
        } catch (Exception e) {
            pcj.b(f16626a, "changeTextureImage Exception error.");
            medalViewCallback.onResponse(-1, e.getMessage());
        }
    }
}
