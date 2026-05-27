package defpackage;

import org.eclipse.californium.core.coap.CoAP;

/* JADX INFO: loaded from: classes8.dex */
public class ydh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19257a;
    private final CoAP.Type b;
    private final ycn c;
    private final int d;
    private final int e;
    private final int g;

    public ydh(int i, CoAP.Type type, ycn ycnVar, int i2, int i3, int i4) {
        this.g = i;
        this.b = type;
        this.c = ycnVar;
        this.f19257a = i2;
        this.e = i3;
        this.d = i4;
    }

    public int d() {
        int i = this.d;
        if (i >= 0) {
            return i;
        }
        throw new IllegalStateException("body length not available!");
    }

    public CoAP.Type b() {
        return this.b;
    }

    public ycn c() {
        return this.c;
    }

    public int a() {
        return this.f19257a;
    }

    public int e() {
        return this.e;
    }
}
