package defpackage;

import com.huawei.devicesdk.connect.handshake.HandshakeCommandBase;

/* JADX INFO: loaded from: classes3.dex */
public class cev {
    private boolean b;
    private HandshakeCommandBase c;

    public cev(boolean z) {
        this(z, null);
    }

    public cev(boolean z, HandshakeCommandBase handshakeCommandBase) {
        this.b = z;
        this.c = handshakeCommandBase;
    }

    public boolean c() {
        return this.b;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public HandshakeCommandBase b() {
        return this.c;
    }

    public void a(HandshakeCommandBase handshakeCommandBase) {
        this.c = handshakeCommandBase;
    }
}
