package defpackage;

import org.eclipse.californium.scandium.dtls.AlertMessage;

/* JADX INFO: loaded from: classes8.dex */
public class yhx extends Exception {
    private static final long serialVersionUID = 1123415935894222594L;
    private final AlertMessage e;

    public yhx(String str, AlertMessage alertMessage) {
        super(str);
        if (alertMessage == null) {
            throw new NullPointerException("Alert must not be null!");
        }
        this.e = alertMessage;
    }

    public yhx(String str, AlertMessage alertMessage, Throwable th) {
        super(str, th);
        if (alertMessage == null) {
            throw new NullPointerException("Alert must not be null!");
        }
        this.e = alertMessage;
    }

    public AlertMessage e() {
        return this.e;
    }
}
