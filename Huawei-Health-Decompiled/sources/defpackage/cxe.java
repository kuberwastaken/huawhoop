package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public class cxe {
    private static d b = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12068a;
    private int c;
    private int d;
    private int e;
    private int h;

    public static int e() {
        return 36;
    }

    private cxe() {
    }

    public cxe(byte[] bArr) {
        if (bArr == null || bArr.length != e()) {
            return;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        this.e = byteBufferWrap.getInt();
        this.h = byteBufferWrap.getInt();
        this.c = byteBufferWrap.getInt();
        this.d = byteBufferWrap.getInt();
        this.f12068a = byteBufferWrap.getInt();
    }

    public int a() {
        return this.e;
    }

    public int h() {
        return this.c;
    }

    public int d() {
        return this.f12068a;
    }

    public static int b() {
        return b.e();
    }

    public byte[] c() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(e());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(this.e);
        byteBufferAllocate.putInt(this.h);
        byteBufferAllocate.putInt(this.c);
        byteBufferAllocate.putInt(this.d);
        byteBufferAllocate.putInt(this.f12068a);
        byteBufferAllocate.flip();
        return byteBufferAllocate.array();
    }

    public String toString() {
        return "MsgHeader{mBusinessType=" + this.e + ", mVersion=" + this.h + ", mTotalLength=" + this.c + ", mBusinessHeadLength=" + this.d + ", mMessageId=" + this.f12068a + '}';
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f12069a;
        private int b;
        private int c;
        private int d;
        private int e;

        public c b(int i) {
            this.d = i;
            return this;
        }

        public c d(int i) {
            this.f12069a = i;
            return this;
        }

        public c c(int i) {
            this.c = i;
            return this;
        }

        public c a(int i) {
            this.e = i;
            return this;
        }

        public c e(int i) {
            this.b = i;
            return this;
        }

        public cxe e() {
            cxe cxeVar = new cxe();
            cxeVar.e = this.d;
            cxeVar.h = this.f12069a;
            cxeVar.c = cxe.e() + this.c + this.e;
            cxeVar.d = this.c;
            cxeVar.f12068a = this.b;
            return cxeVar;
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12070a;

        private d() {
            this.f12070a = 0;
        }

        protected int e() {
            int i;
            synchronized (this) {
                int i2 = this.f12070a + 1;
                this.f12070a = i2;
                i = i2 % 1000000;
                this.f12070a = i;
            }
            return i;
        }
    }
}
