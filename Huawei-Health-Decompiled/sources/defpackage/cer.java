package defpackage;

import com.huawei.devicesdk.callback.FrameReceiver;
import com.huawei.devicesdk.entity.DeviceInfo;

/* JADX INFO: loaded from: classes3.dex */
public class cer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private cem f616a;
    private int b;
    private FrameReceiver c;
    private int d;
    private DeviceInfo e;
    private long h;

    public cer(FrameReceiver frameReceiver, DeviceInfo deviceInfo, cem cemVar, int i) {
        this.c = frameReceiver;
        this.e = deviceInfo;
        this.f616a = cemVar;
        this.b = i;
    }

    public void c(long j, int i) {
        this.h = j;
        this.d = i;
    }

    public long j() {
        return this.h;
    }

    public int b() {
        return this.d;
    }

    public FrameReceiver a() {
        return this.c;
    }

    public DeviceInfo e() {
        return this.e;
    }

    public cem c() {
        return this.f616a;
    }

    public int d() {
        return this.b;
    }
}
