package defpackage;

import com.google.common.primitives.SignedBytes;
import com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand;

/* JADX INFO: loaded from: classes4.dex */
public class dvn extends AbstractCommand {
    private byte[] b;
    byte d;

    public dvn(d dVar) {
        this.mHead = dVar.b;
        this.mOrder = dVar.c;
        this.mCommand = dVar.d;
        this.mCode = dVar.f2336a;
        this.b = dVar.j;
        this.d = dVar.e;
    }

    @Override // com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand
    public byte[] toByteArray() {
        byte[] bArr = new byte[this.b.length + 5];
        int byteArray = super.toByteArray(bArr);
        int i = 0;
        while (true) {
            byte[] bArr2 = this.b;
            if (i < bArr2.length) {
                byteArray++;
                bArr[byteArray] = bArr2[i];
                i++;
            } else {
                bArr[byteArray + 1] = this.d;
                return bArr;
            }
        }
    }

    @Override // com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand
    public byte getCheck() {
        return this.d;
    }

    public static class d extends AbstractCommand.e {
        byte e;
        private byte[] j;

        public d() {
            super(SignedBytes.MAX_POWER_OF_TWO);
            this.j = new byte[0];
        }

        public void b(byte b) {
            this.e = b;
        }

        public void b(byte[] bArr) {
            this.j = bArr;
        }

        public dvn b() {
            return new dvn(this);
        }

        public dvn a(byte[] bArr) {
            int iD = super.d(bArr) + 1;
            this.j = new byte[(bArr.length - 1) - iD];
            int i = 0;
            while (iD < bArr.length - 1) {
                this.j[i] = bArr[iD];
                i++;
                iD++;
            }
            this.e = bArr[bArr.length - 1];
            return new dvn(this);
        }
    }

    @Override // com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand
    public byte[] getPara() {
        return this.b;
    }

    @Override // com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand
    public byte[] getParameterLength() {
        return new byte[0];
    }
}
