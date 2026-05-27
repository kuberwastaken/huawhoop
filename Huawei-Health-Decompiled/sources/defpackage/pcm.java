package defpackage;

import android.content.Context;
import android.opengl.GLES20;

/* JADX INFO: loaded from: classes11.dex */
public class pcm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16621a = "ShaderHelper";

    public static int a(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        if (iGlCreateShader == 0) {
            String str2 = f16621a;
            pcj.b(str2, "getShader Error creating vertex shader.");
            throw new RuntimeException(str2 + pcj.a() + " Error creating vertex shader.");
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        StringBuilder sb = new StringBuilder();
        String str3 = f16621a;
        sb.append(str3);
        sb.append("_ES20_ERROR");
        pcj.b(sb.toString(), "Could not compile shader " + i + ":");
        pcj.b(str3 + "_ES20_ERROR", GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static int e(String str) {
        return a(35633, str);
    }

    public static int d(String str) {
        return a(35632, str);
    }

    public static int b(Context context, String str, String str2) {
        int iD;
        synchronized (pcm.class) {
            iD = d(pcf.d(context, str), pcf.d(context, str2));
        }
        return iD;
    }

    public static int d(String str, String str2) {
        return a(e(str), d(str2));
    }

    public static int a(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram == 0) {
            pcj.b(f16621a, "Error creating program..");
            throw new RuntimeException("Error creating program.");
        }
        GLES20.glAttachShader(iGlCreateProgram, i);
        pch.a("glAttachShader vertexShader");
        GLES20.glAttachShader(iGlCreateProgram, i2);
        pch.a("glAttachShader fragShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            StringBuilder sb = new StringBuilder();
            String str = f16621a;
            sb.append(str);
            sb.append("_ES20_ERROR");
            pcj.b(sb.toString(), pcj.a() + "Could not link program: ");
            pcj.b(str + "_ES20_ERROR", pcj.a() + GLES20.glGetProgramInfoLog(iGlCreateProgram));
            GLES20.glDeleteProgram(iGlCreateProgram);
            throw new RuntimeException("Error creating program.");
        }
        pcj.b(f16621a, pcj.a() + "program ID=" + iGlCreateProgram);
        GLES20.glDeleteShader(i);
        GLES20.glDeleteShader(i2);
        return iGlCreateProgram;
    }
}
