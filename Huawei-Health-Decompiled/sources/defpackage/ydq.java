package defpackage;

import org.eclipse.californium.core.coap.CoAP;

/* JADX INFO: loaded from: classes8.dex */
public class ydq extends Exception {
    private static final long serialVersionUID = 1357;
    private final boolean b;
    private final CoAP.ResponseCode d;

    public ydq(String str) {
        super(str);
        this.b = false;
        this.d = null;
    }

    public ydq(String str, CoAP.ResponseCode responseCode) {
        super(str);
        this.b = false;
        this.d = responseCode;
    }

    public ydq(String str, boolean z) {
        super(str);
        this.b = z;
        this.d = null;
    }

    public boolean b() {
        return this.b;
    }

    public CoAP.ResponseCode a() {
        return this.d;
    }
}
