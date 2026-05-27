package defpackage;

import org.eclipse.californium.core.coap.CoAP;

/* JADX INFO: loaded from: classes8.dex */
public class ybz {
    private ycj c;

    protected ybz(ycj ycjVar) {
        if (ycjVar == null) {
            throw new NullPointerException("Response must not be null!");
        }
        this.c = ycjVar;
    }

    public CoAP.ResponseCode e() {
        return this.c.b();
    }

    public String b() {
        return this.c.getPayloadString();
    }

    public ycj d() {
        return this.c;
    }

    public String toString() {
        return this.c.toString();
    }
}
