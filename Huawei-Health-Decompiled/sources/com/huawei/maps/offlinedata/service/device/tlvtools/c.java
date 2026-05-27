package com.huawei.maps.offlinedata.service.device.tlvtools;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    private int b;
    private int d;
    private long f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<byte[]> f6732a = new LinkedList();
    private List<byte[]> c = null;
    private List<byte[]> e = null;

    public static boolean b() {
        return true;
    }

    public c() {
        if (b()) {
            return;
        }
        this.f = Thread.currentThread().getId();
    }

    private void e() {
        if (!b() && Thread.currentThread().getId() != this.f) {
            throw new RuntimeException("TlvByteCommandUtil no support multi thread. please invoke one thread");
        }
    }

    public c a(int i) {
        e();
        if (this.e != null) {
            if (b()) {
                return this;
            }
            throw new RuntimeException("no continue invoke beginCreateList need invoke endCreateList at list finish");
        }
        if (i <= 0 || i >= 128) {
            if (b()) {
                return this;
            }
            throw new RuntimeException("beginCreateList is wrong : " + i);
        }
        this.e = new LinkedList();
        this.d = i;
        return this;
    }

    public byte[] a() {
        e();
        List<byte[]> list = this.e;
        int length = 0;
        if (list == null) {
            if (b()) {
                return new byte[]{(byte) (this.d + 128), 0};
            }
            throw new RuntimeException("need invoke endCreateList before invoke addStructToList");
        }
        if (list.isEmpty()) {
            return new byte[]{(byte) (this.d + 128), 0};
        }
        Iterator<byte[]> it = this.e.iterator();
        while (it.hasNext()) {
            length += it.next().length;
        }
        byte[] bArrF = a.f(this.d + 128);
        byte[] bArrD = a.d(length);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + bArrF.length + bArrD.length);
        byteBufferAllocate.put(bArrF).put(bArrD);
        Iterator<byte[]> it2 = this.e.iterator();
        while (it2.hasNext()) {
            byteBufferAllocate.put(it2.next());
        }
        this.e.clear();
        this.e = null;
        return byteBufferAllocate.array();
    }

    public c a(byte[] bArr) {
        e();
        List<byte[]> list = this.e;
        if (list == null) {
            if (b()) {
                return this;
            }
            throw new RuntimeException("need invoke beginCreateList before invoke addStructToList");
        }
        if (bArr != null && bArr.length != 0) {
            list.add(bArr);
        }
        return this;
    }

    public c b(int i) {
        e();
        if (this.c != null) {
            if (b()) {
                return this;
            }
            throw new RuntimeException("no continue invoke beginCreateStruct, need invoke endCreateStruct at struct finish");
        }
        if (i <= 0 || i >= 128) {
            if (b()) {
                return this;
            }
            throw new RuntimeException("createStructType is wrong : " + i);
        }
        this.c = new LinkedList();
        this.b = i;
        return this;
    }

    public byte[] c() {
        e();
        List<byte[]> list = this.c;
        int length = 0;
        if (list == null) {
            if (b()) {
                return new byte[]{(byte) (this.b + 128), 0};
            }
            throw new RuntimeException("need invoke beginCreateStruct before invoke endCreateStruct " + this.b);
        }
        if (list.isEmpty()) {
            return new byte[]{(byte) (this.b + 128), 0};
        }
        Iterator<byte[]> it = this.c.iterator();
        while (it.hasNext()) {
            length += it.next().length;
        }
        byte[] bArrF = a.f(this.b + 128);
        byte[] bArrD = a.d(length);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + bArrF.length + bArrD.length);
        byteBufferAllocate.put(bArrF).put(bArrD);
        Iterator<byte[]> it2 = this.c.iterator();
        while (it2.hasNext()) {
            byteBufferAllocate.put(it2.next());
        }
        this.c.clear();
        this.c = null;
        return byteBufferAllocate.array();
    }

    private byte[] e(int i, int i2) {
        byte[] bArrF = a.f(i);
        byte[] bArrE = a.e(i2);
        byte[] bArrD = a.d(bArrE.length);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrF.length + bArrD.length + bArrE.length);
        byteBufferAllocate.put(bArrF).put(bArrD).put(bArrE);
        return byteBufferAllocate.array();
    }

    public c a(int i, int i2) {
        e();
        this.f6732a.add(e(i, i2));
        return this;
    }

    private byte[] f(int i, int i2) {
        e();
        byte[] bArrF = a.f(i);
        byte[] bArr = {(byte) i2};
        byte[] bArrD = a.d(1);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrF.length + bArrD.length + 1);
        byteBufferAllocate.put(bArrF).put(bArrD).put(bArr);
        return byteBufferAllocate.array();
    }

    public c b(int i, int i2) {
        e();
        this.f6732a.add(f(i, i2));
        return this;
    }

    public c c(int i, int i2) {
        e();
        this.c.add(f(i, i2));
        return this;
    }

    private byte[] g(int i, int i2) {
        e();
        byte[] bArrF = a.f(i);
        byte[] bArrB = a.b(i2);
        byte[] bArrD = a.d(bArrB.length);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrF.length + bArrD.length + bArrB.length);
        byteBufferAllocate.put(bArrF).put(bArrD).put(bArrB);
        return byteBufferAllocate.array();
    }

    public c d(int i, int i2) {
        e();
        this.f6732a.add(g(i, i2));
        return this;
    }

    private byte[] b(int i, String str) {
        e();
        byte[] bArrF = a.f(i);
        byte[] bArrC = a.c(str);
        byte[] bArrD = a.d(bArrC.length);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrF.length + bArrD.length + bArrC.length);
        byteBufferAllocate.put(bArrF).put(bArrD).put(bArrC);
        return byteBufferAllocate.array();
    }

    public c a(int i, String str) {
        e();
        this.f6732a.add(b(i, str));
        return this;
    }

    private byte[] b(int i, long j) {
        byte[] bArrF = a.f(i);
        byte[] bArrA = a.a(j);
        byte[] bArrD = a.d(bArrA.length);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrF.length + bArrD.length + bArrA.length);
        byteBufferAllocate.put(bArrF).put(bArrD).put(bArrA);
        return byteBufferAllocate.array();
    }

    public c a(int i, long j) {
        e();
        this.c.add(b(i, j));
        return this;
    }

    public c b(byte[] bArr) {
        e();
        if (bArr != null) {
            this.f6732a.add(bArr);
        }
        return this;
    }

    public byte[] d() {
        e();
        Iterator<byte[]> it = this.f6732a.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        Iterator<byte[]> it2 = this.f6732a.iterator();
        while (it2.hasNext()) {
            byteBufferAllocate.put(it2.next());
        }
        this.f6732a.clear();
        return byteBufferAllocate.array();
    }
}
