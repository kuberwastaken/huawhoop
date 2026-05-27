package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class hpc {
    private int b;
    private List<e> c = new ArrayList();
    private int d;

    protected hpc(d dVar) {
        this.b = dVar.d;
        this.d = dVar.e.size();
        this.c.addAll(dVar.e);
    }

    public int e() {
        return (this.c.size() * 8) + 8;
    }

    public byte[] d() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(e());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(this.b);
        byteBufferAllocate.putInt(this.d);
        for (e eVar : this.c) {
            byteBufferAllocate.putInt(eVar.d);
            byteBufferAllocate.putInt(eVar.b);
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate.array();
    }

    public static class e {
        private int b;
        private int d;

        public e(int i, int i2) {
            this.d = i;
            this.b = i2;
        }
    }

    public static class d {
        private int d;
        private List<e> e = new ArrayList();

        public d d(int i) {
            this.d = i;
            return this;
        }

        public d e(e eVar) {
            if (eVar != null) {
                this.e.add(eVar);
            }
            return this;
        }

        public hpc e() {
            return new hpc(this);
        }
    }
}
