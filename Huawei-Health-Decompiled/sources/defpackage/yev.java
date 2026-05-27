package defpackage;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.MessageCallback;

/* JADX INFO: loaded from: classes8.dex */
public final class yev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InetSocketAddress f19280a;
    public final byte[] b;
    private final MessageCallback c;
    private final EndpointContext d;
    private final boolean e;
    private final long i;

    private yev(byte[] bArr, EndpointContext endpointContext, MessageCallback messageCallback, boolean z, long j, InetSocketAddress inetSocketAddress) {
        if (bArr == null) {
            throw new NullPointerException("Data must not be null");
        }
        if (endpointContext == null) {
            throw new NullPointerException("Peer's EndpointContext must not be null");
        }
        this.b = bArr;
        this.d = endpointContext;
        this.c = messageCallback;
        this.e = z;
        this.i = j;
        this.f19280a = inetSocketAddress;
    }

    public static yev d(byte[] bArr, EndpointContext endpointContext, boolean z, long j, InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress == null) {
            throw new NullPointerException("Connectors's address must not be null");
        }
        return new yev(bArr, endpointContext, null, z, j, inetSocketAddress);
    }

    public static yev a(byte[] bArr, EndpointContext endpointContext, MessageCallback messageCallback, boolean z) {
        return new yev(bArr, endpointContext, messageCallback, z, 0L, null);
    }

    public byte[] d() {
        return this.b;
    }

    public int i() {
        return this.b.length;
    }

    public long b() {
        return this.i;
    }

    public boolean j() {
        return this.e;
    }

    public InetSocketAddress c() {
        return this.f19280a;
    }

    public InetSocketAddress e() {
        return this.d.getPeerAddress();
    }

    public EndpointContext a() {
        return this.d;
    }

    public void f() {
        MessageCallback messageCallback = this.c;
        if (messageCallback != null) {
            messageCallback.onConnecting();
        }
    }

    public void b(int i) {
        MessageCallback messageCallback = this.c;
        if (messageCallback != null) {
            messageCallback.onDtlsRetransmission(i);
        }
    }

    public void b(EndpointContext endpointContext) {
        MessageCallback messageCallback = this.c;
        if (messageCallback != null) {
            messageCallback.onContextEstablished(endpointContext);
        }
    }

    public void h() {
        MessageCallback messageCallback = this.c;
        if (messageCallback != null) {
            messageCallback.onSent();
        }
    }

    public void a(Throwable th) {
        if (this.c != null) {
            if (th == null) {
                th = new UnknownError();
            }
            this.c.onError(th);
        }
    }
}
