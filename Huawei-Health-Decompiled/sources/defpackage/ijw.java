package defpackage;

import android.opengl.GLES20;
import com.huawei.hwlogsmodel.LogUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class ijw {
    public static int d(String str, String str2) {
        int iB;
        int iB2 = b(35633, str);
        if (iB2 == 0 || (iB = b(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        c("glCreateProgram");
        if (iGlCreateProgram == 0) {
            LogUtil.a("Track_EncodeDecodeSurface", "Could not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, iB2);
        c("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iB);
        c("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        LogUtil.a("Track_EncodeDecodeSurface", "Could not link program: ");
        LogUtil.a("Track_EncodeDecodeSurface", GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public static int b(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        c("glCreateShader type=" + i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        LogUtil.a("Track_EncodeDecodeSurface", "Could not compile shader ", Integer.valueOf(i), ":");
        LogUtil.a("Track_EncodeDecodeSurface", " ", GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static void c(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        String str2 = str + ": glError 0x" + Integer.toHexString(iGlGetError);
        LogUtil.a("Track_EncodeDecodeSurface", str2);
        throw new ijr(str2);
    }

    public static FloatBuffer d(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
