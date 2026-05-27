package com.huawei.hms.mlsdk.asr.energy;

import com.huawei.hms.mlsdk.asr.energy.vo.DetectResult;
import com.huawei.hms.mlsdk.asr.energy.vo.SampleBuffer;
import com.huawei.hms.mlsdk.asr.energy.vo.VoiceDetectParams;
import com.huawei.hms.mlsdk.asr.engine.utils.SmartLogger;
import com.huawei.hms.mlsdk.asr.o.a;

/* JADX INFO: loaded from: classes5.dex */
public class NativeVadDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5243a = new Object().hashCode();

    public NativeVadDetector() {
        try {
            System.loadLibrary("ml-vadenergy");
        } catch (UnsatisfiedLinkError e) {
            StringBuilder sbA = a.a("loadLibrary e = ");
            sbA.append(e.getMessage());
            SmartLogger.e("NativeVadDetector", sbA.toString());
        }
    }

    public native DetectResult detect(SampleBuffer sampleBuffer);

    public int getTag() {
        return this.f5243a;
    }

    public native boolean init(VoiceDetectParams voiceDetectParams);

    public native void release();
}
