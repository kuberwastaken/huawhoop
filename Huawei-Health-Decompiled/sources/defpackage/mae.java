package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public class mae {
    private static int b;
    private static mae c;
    private static final Object d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteBuffer f15565a;
    private mae e;

    private mae(int i) {
        this.f15565a = ByteBuffer.allocate(i);
    }

    public ByteBuffer d() {
        return this.f15565a;
    }

    public static mae c(int i) {
        synchronized (d) {
            mae maeVar = c;
            if (maeVar != null) {
                c = maeVar.e;
                maeVar.e = null;
                b--;
                if (maeVar.f15565a.capacity() != i) {
                    maeVar.f15565a = ByteBuffer.allocate(i);
                }
                return maeVar;
            }
            return new mae(i);
        }
    }

    public void a() {
        this.f15565a.clear();
        synchronized (d) {
            int i = b;
            if (i < 1) {
                this.e = c;
                c = this;
                b = i + 1;
            }
        }
    }
}
