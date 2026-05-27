package defpackage;

import org.eclipse.californium.elements.EndpointContext;

/* JADX INFO: loaded from: classes8.dex */
public final class yel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ycl f19278a;
    private final EndpointContext e;

    public yel(ycl yclVar, EndpointContext endpointContext) {
        if (yclVar == null) {
            throw new NullPointerException("request must not be null");
        }
        if (!yclVar.l()) {
            throw new IllegalArgumentException("request has no observe=0 option");
        }
        this.f19278a = yclVar;
        this.e = endpointContext;
    }

    public ycl e() {
        return this.f19278a;
    }

    public EndpointContext a() {
        return this.e;
    }

    public String toString() {
        return this.f19278a.toString();
    }
}
