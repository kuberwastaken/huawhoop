package defpackage;

import com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand;

/* JADX INFO: loaded from: classes4.dex */
public class dvp extends AbstractCommand {
    private final byte[] c;

    @Override // com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand
    public byte getCheck() {
        return (byte) 0;
    }

    public dvp(e eVar) {
        this.mHead = eVar.b;
        this.mOrder = eVar.c;
        this.mCommand = eVar.d;
        this.mCode = eVar.f2336a;
        this.c = eVar.e;
    }

    public static class e extends AbstractCommand.e {
        private byte[] e;

        public e() {
            super((byte) -64);
            this.e = new byte[0];
        }

        public void c(byte[] bArr) {
            this.e = bArr;
        }

        public dvp c() {
            return new dvp(this);
        }

        public dvp a(byte[] bArr) {
            int iD = super.d(bArr) + 1;
            this.e = new byte[bArr.length - iD];
            int i = 0;
            while (iD < bArr.length) {
                this.e[i] = bArr[iD];
                i++;
                iD++;
            }
            return new dvp(this);
        }
    }

    @Override // com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand
    public byte[] toByteArray() {
        byte[] bArr = new byte[20];
        int byteArray = super.toByteArray(bArr);
        int i = 0;
        while (true) {
            byte[] bArr2 = this.c;
            if (i >= bArr2.length) {
                return bArr;
            }
            byteArray++;
            bArr[byteArray] = bArr2[i];
            i++;
        }
    }

    @Override // com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand
    public byte[] getPara() {
        return this.c;
    }

    @Override // com.huawei.health.ecologydevice.fitness.dataparser.secondropecommand.AbstractCommand
    public byte[] getParameterLength() {
        return new byte[0];
    }
}
