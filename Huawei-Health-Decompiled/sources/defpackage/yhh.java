package defpackage;

import org.eclipse.californium.scandium.dtls.ConnectionIdGenerator;

/* JADX INFO: loaded from: classes8.dex */
public class yhh extends ygc {
    public static final yhh e = new yhh(ygc.d);

    public static boolean e(ConnectionIdGenerator connectionIdGenerator) {
        return connectionIdGenerator != null;
    }

    public yhh(byte[] bArr) {
        super(bArr);
    }

    @Override // defpackage.ygc
    public String toString() {
        return "CID=" + d();
    }

    public static boolean b(ConnectionIdGenerator connectionIdGenerator) {
        return connectionIdGenerator != null && connectionIdGenerator.useConnectionId();
    }

    public static boolean a(yhh yhhVar) {
        return (yhhVar == null || yhhVar.b()) ? false : true;
    }
}
