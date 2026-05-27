package com.huawei.openalliance.ad;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes11.dex */
public class ef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[] f7080a;
    private static final float[] b;
    private static final FloatBuffer c;
    private static final FloatBuffer d;
    private final FloatBuffer e = c;
    private final FloatBuffer f = d;
    private final int g = 2;
    private final int h = f7080a.length / 2;

    int d() {
        return 8;
    }

    int e() {
        return 8;
    }

    int f() {
        return 2;
    }

    int c() {
        return this.h;
    }

    FloatBuffer b() {
        return this.f;
    }

    FloatBuffer a() {
        return this.e;
    }

    private static FloatBuffer a(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    static {
        float[] fArr = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        f7080a = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        b = fArr2;
        c = a(fArr);
        d = a(fArr2);
    }
}
