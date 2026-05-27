package defpackage;

import com.google.common.primitives.UnsignedBytes;
import com.huawei.health.device.open.data.HealthDataParser;
import com.huawei.health.device.open.data.model.HealthData;

/* JADX INFO: loaded from: classes4.dex */
public class dxt implements HealthDataParser {
    protected byte[] b;
    private int d;

    private int a(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    private int b(int i) {
        return i & 15;
    }

    private int b(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        return (i & i3) != 0 ? (i3 - (i & (i3 - 1))) * (-1) : i;
    }

    public void c(int i) {
        this.d = i;
    }

    @Override // com.huawei.health.device.open.data.HealthDataParser
    public HealthData parseData(byte[] bArr) {
        ebx ebxVar = new ebx();
        ebxVar.setHeartRate(c(bArr));
        return ebxVar;
    }

    private int d(byte b, byte b2) {
        return a(b) + (a(b2) << 8);
    }

    private int b(byte b, byte b2, byte b3, byte b4) {
        return a(b) + (a(b2) << 8) + (a(b3) << 16) + (a(b4) << 24);
    }

    private Integer e(int i, int i2) {
        int iB = b(i);
        byte[] bArr = this.b;
        if (iB + i2 > bArr.length) {
            return null;
        }
        if (i == 17) {
            return Integer.valueOf(a(bArr[i2]));
        }
        if (i == 18) {
            return Integer.valueOf(d(bArr[i2], bArr[i2 + 1]));
        }
        if (i == 20) {
            return Integer.valueOf(b(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]));
        }
        if (i == 36) {
            return Integer.valueOf(b(b(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]), 32));
        }
        if (i == 33) {
            return Integer.valueOf(b(a(bArr[i2]), 8));
        }
        if (i != 34) {
            return null;
        }
        return Integer.valueOf(b(d(bArr[i2], bArr[i2 + 1]), 16));
    }

    private Integer c(byte[] bArr) {
        this.b = bArr;
        return e((this.d & 1) != 0 ? 18 : 17, 1);
    }
}
