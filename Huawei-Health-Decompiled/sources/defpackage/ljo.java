package defpackage;

import health.compact.a.util.LogUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class ljo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SocketChannel f15242a;
    private long b;
    private long c;
    private final boolean d;
    private final LinkedList<ByteBuffer> e;
    private long f;
    private long g;
    private final int h;
    private final String i;
    private final AtomicBoolean j;

    public ljo(SocketChannel socketChannel, String str, int i, boolean z) {
        this.j = new AtomicBoolean(false);
        this.e = new LinkedList<>();
        this.d = z;
        this.f15242a = socketChannel;
        this.i = str;
        this.h = i;
        this.b = -1L;
        this.c = -1L;
        this.f = 0L;
        this.g = 0L;
    }

    public ljo(boolean z) {
        this(null, "", -1, z);
    }

    public String f() {
        return this.i;
    }

    public int j() {
        return this.h;
    }

    public SocketChannel h() {
        return this.f15242a;
    }

    public void o() {
        this.j.set(true);
    }

    public boolean g() {
        return this.j.get();
    }

    public boolean k() {
        return this.d;
    }

    public void d(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            LogUtil.c("DistributionNetworkTcpConduit", "appendWrite buffer is null");
            return;
        }
        synchronized (this.e) {
            this.e.add(byteBuffer);
        }
    }

    public boolean m() {
        boolean z;
        synchronized (this.e) {
            z = !this.e.isEmpty();
        }
        return z;
    }

    public int n() throws IOException {
        int iWrite;
        synchronized (this.e) {
            iWrite = 0;
            while (!this.e.isEmpty()) {
                ByteBuffer first = this.e.getFirst();
                iWrite += h().write(first);
                if (first.hasRemaining()) {
                    break;
                }
                this.e.removeFirst();
            }
        }
        return iWrite;
    }

    public long d() {
        return this.b;
    }

    public void b(long j) {
        this.b = j;
    }

    public long a() {
        return this.c;
    }

    public void c(long j) {
        this.c = j;
    }

    public long i() {
        return this.f;
    }

    public void d(long j) {
        this.f = j;
    }

    public long e() {
        return this.g;
    }

    public void a(long j) {
        this.g = j;
    }

    public long c() {
        if (a() < 0) {
            return 0L;
        }
        return a() + 1;
    }

    public long b() {
        if (d() < 0) {
            return 0L;
        }
        return d() + 1;
    }
}
