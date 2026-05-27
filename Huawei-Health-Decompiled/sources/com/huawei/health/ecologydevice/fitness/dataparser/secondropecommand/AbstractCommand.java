package com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractCommand {
    protected byte mCode;
    protected byte mCommand;
    protected byte mHead;
    protected byte mOrder;

    public abstract byte getCheck();

    public abstract byte[] getPara();

    public abstract byte[] getParameterLength();

    public abstract byte[] toByteArray();

    public byte getHead() {
        return this.mHead;
    }

    public byte getOrder() {
        return this.mOrder;
    }

    public byte getCommand() {
        return this.mCommand;
    }

    public byte getCode() {
        return this.mCode;
    }

    public int toByteArray(byte[] bArr) {
        bArr[0] = this.mHead;
        bArr[1] = this.mOrder;
        bArr[2] = this.mCommand;
        bArr[3] = this.mCode;
        return 3;
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f2336a;
        public byte b;
        public byte c;
        public byte d;

        public e(byte b) {
            this.b = b;
        }

        public void c(byte b) {
            this.b = b;
        }

        public void b(int i) {
            this.d = (byte) (i & 255);
        }

        public void e(byte b) {
            this.d = b;
        }

        public void c(int i) {
            this.f2336a = (byte) (i & 255);
        }

        public void d(byte b) {
            this.f2336a = b;
        }

        public void a(byte b) {
            this.c = b;
        }

        public int d(byte[] bArr) {
            this.b = bArr[0];
            this.c = bArr[1];
            this.d = bArr[2];
            this.f2336a = bArr[3];
            return 3;
        }
    }
}
