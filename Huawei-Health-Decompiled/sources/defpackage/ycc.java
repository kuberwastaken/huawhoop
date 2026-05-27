package defpackage;

import org.eclipse.californium.core.coap.CoAP;

/* JADX INFO: loaded from: classes8.dex */
public class ycc extends ycf {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ycn f19232a;
    private final boolean b;
    private final int c;
    private final CoAP.ResponseCode d;
    private final int e;

    public ycc(String str, ycn ycnVar, int i, int i2, boolean z) {
        this(str, ycnVar, i, i2, z, CoAP.ResponseCode.BAD_OPTION);
    }

    public ycc(String str, ycn ycnVar, int i, int i2, boolean z, CoAP.ResponseCode responseCode) {
        super(str);
        this.f19232a = ycnVar;
        this.c = i;
        this.e = i2;
        this.b = z;
        this.d = responseCode;
    }

    public ycn e() {
        return this.f19232a;
    }

    public final boolean a() {
        return this.c > -1;
    }

    public final int d() {
        return this.c;
    }

    public final int c() {
        return this.e;
    }

    public final CoAP.ResponseCode b() {
        return this.d;
    }

    public final boolean i() {
        return this.b;
    }
}
