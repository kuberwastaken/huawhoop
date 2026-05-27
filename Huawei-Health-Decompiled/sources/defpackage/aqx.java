package defpackage;

import android.util.Log;
import com.huawei.algorithm.peeranalysis.PeerPercentage;

/* JADX INFO: loaded from: classes3.dex */
public class aqx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f273a;
    private float b;
    private float c;
    private float d;
    private int e;
    private int f;
    private float g;
    private float h;
    private float i;
    private int j;

    public aqx() {
    }

    public aqx(int i, int i2, int i3, float f, float f2, float f3, int i4, float f4, float f5) {
        this.b = f;
        this.e = i;
        this.j = i2;
        this.d = i + (i2 / 12.0f);
        this.f = i3;
        this.f273a = f2;
        this.c = f3;
        this.h = i4;
        this.g = f4;
        this.i = f5;
    }

    public int l() {
        int i;
        double d = this.b;
        if (d < 0.5d || d > 2.5d) {
            return -3;
        }
        int i2 = this.e;
        if (i2 < 6 || i2 > 80 || (i = this.j) < 0 || i > 11) {
            return -4;
        }
        if (this.f > 1) {
            return -5;
        }
        float f = this.f273a;
        if (f < 10.0f || f > 45.0f) {
            return -7;
        }
        float f2 = this.c;
        if (f2 > 1.0d || f2 < 0.0f) {
            return -7;
        }
        float f3 = this.h;
        if (f3 > 50.0f || f3 < 0.0f || this.g < 0.0f) {
            return -7;
        }
        float f4 = this.i;
        return (f4 < 4.0f || f4 > 20.0f) ? -7 : 0;
    }

    public int m() {
        int i;
        double d = this.b;
        if (d < 0.5d || d > 2.5d) {
            return -3;
        }
        int i2 = this.e;
        if (i2 < 6 || i2 > 80 || (i = this.j) < 0 || i > 11) {
            return -4;
        }
        if (this.f > 1) {
            return -5;
        }
        float f = this.f273a;
        if (f < 10.0f || f > 45.0f) {
            return -7;
        }
        float f2 = this.c;
        if (f2 > 1.0d || f2 < 0.0f) {
            return -7;
        }
        float f3 = this.h;
        return (f3 > 50.0f || f3 < 0.0f || this.g < 0.0f) ? -7 : 0;
    }

    public float d() {
        return new PeerPercentage().GetBMIMean(this.d, this.f);
    }

    public float e() {
        return new PeerPercentage().GetBFRMean(this.d, this.f);
    }

    public float i() {
        return new PeerPercentage().GetVFLMean(this.d, this.f);
    }

    public float f() {
        return new PeerPercentage().GetSMMMean(this.d, this.f, this.b);
    }

    public float b() {
        return new PeerPercentage().GetRASMMean(this.d, this.f);
    }

    public float c() {
        return new PeerPercentage().GetBMIPeerPercent(this.e, this.f, this.f273a);
    }

    public float a() {
        return new PeerPercentage().GetBFRPeerPercent(this.e, this.f, this.c);
    }

    public float g() {
        return new PeerPercentage().GetVFLPeerPercent(this.e, this.f, this.h);
    }

    public float j() {
        return new PeerPercentage().GetSMMPeerPercent(this.e, this.f, this.b, this.g);
    }

    public float h() {
        return new PeerPercentage().GetRASMPeerPercent(this.e, this.f, this.i);
    }

    static {
        System.loadLibrary("peeranalysis");
        Log.d("PeerPercentageUtil", "load lib success");
    }
}
