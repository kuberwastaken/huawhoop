package defpackage;

import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class dfx {
    private UUID b;
    private UUID c;
    private byte[] d;

    private dfx(d dVar) {
        this.b = dVar.c;
        this.c = dVar.f12214a;
        this.d = dVar.e;
    }

    public UUID d() {
        return this.b;
    }

    public UUID b() {
        return this.c;
    }

    public byte[] e() {
        byte[] bArr = this.d;
        return bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private UUID f12214a;
        private UUID c;
        private byte[] e;

        public d b(String str) {
            UUID uuidFromString = UUID.fromString(str);
            this.c = uuidFromString;
            UUID uuidD = ddy.d(uuidFromString);
            if (uuidD == null) {
                uuidD = null;
            }
            this.f12214a = uuidD;
            return this;
        }

        public d a(UUID uuid) {
            this.c = uuid;
            UUID uuidD = ddy.d(uuid);
            if (uuidD == null) {
                uuidD = null;
            }
            this.f12214a = uuidD;
            return this;
        }

        public d c(byte[] bArr) {
            if (bArr != null) {
                this.e = (byte[]) bArr.clone();
            }
            return this;
        }

        public dfx e() {
            return new dfx(this);
        }
    }
}
