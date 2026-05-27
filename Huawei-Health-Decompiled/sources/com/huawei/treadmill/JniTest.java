package com.huawei.treadmill;

/* JADX INFO: loaded from: classes7.dex */
public class JniTest {
    public native int getCurrentStepSource();

    public native int initAlg(int[] iArr);

    public native int[] processAlg(int[] iArr, int[] iArr2);

    public native void stopAlg();

    static {
        System.loadLibrary("native-lib");
    }
}
