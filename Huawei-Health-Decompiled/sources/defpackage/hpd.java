package defpackage;

import com.huawei.health.basesport.wearengine.SportHiWearBusinessType;
import defpackage.cxe;
import defpackage.hpc;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class hpd {
    private List<byte[]> e = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public void d(byte[] bArr) {
        this.e.add(bArr);
    }

    public byte[] a() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(d());
        Iterator<byte[]> it = this.e.iterator();
        while (it.hasNext()) {
            byteBufferAllocate.put(it.next());
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate.array();
    }

    public int d() {
        Iterator<byte[]> it = this.e.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length;
        }
        return length;
    }

    public static class b {
        private byte[] b;
        private int c;
        private int d;
        private cxe.c e = new cxe.c().b(SportHiWearBusinessType.FITNESS_RUN_PLAN_INFO_FILE.getTypeValue()).d(1);
        private hpc.d f = new hpc.d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<byte[]> f13913a = new ArrayList();

        public b b(int i) {
            this.e.e(i);
            return this;
        }

        public b c(int i) {
            this.e.b(i);
            return this;
        }

        public b c(byte[] bArr) {
            if (bArr != null) {
                this.b = (byte[]) bArr.clone();
                int length = bArr.length;
                this.d = length;
                this.f.d(length);
            }
            return this;
        }

        public b e(byte[] bArr, int i) {
            if (bArr != null) {
                this.f13913a.add(bArr);
                this.c += bArr.length;
                this.f.e(new hpc.e(bArr.length, i));
            }
            return this;
        }

        public hpd d() {
            hpd hpdVar = new hpd();
            hpc hpcVarE = this.f.e();
            this.e.a(this.c + this.d).c(hpcVarE.e());
            hpdVar.d(this.e.e().c());
            hpdVar.d(hpcVarE.d());
            byte[] bArr = this.b;
            if (bArr != null) {
                hpdVar.d(bArr);
            }
            Iterator<byte[]> it = this.f13913a.iterator();
            while (it.hasNext()) {
                hpdVar.d(it.next());
            }
            return hpdVar;
        }
    }
}
