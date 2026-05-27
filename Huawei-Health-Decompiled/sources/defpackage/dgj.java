package defpackage;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;
import com.huawei.health.device.kit.wsp.task.BleTaskQueueUtil;
import com.huawei.health.device.kit.wsp.task.IAsynBleTaskCallback;

/* JADX INFO: loaded from: classes4.dex */
public class dgj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAsynBleTaskCallback f12225a;
    private c b;
    private Bundle c;
    private boolean d;
    private byte[] e;
    private BleTaskQueueUtil.TaskType f;
    private int g;
    private int j;

    public dgj(BleTaskQueueUtil.TaskType taskType, byte[] bArr) {
        this(taskType, bArr, false, -1);
    }

    public dgj(BleTaskQueueUtil.TaskType taskType, byte[] bArr, boolean z) {
        this(taskType, bArr, z, -1);
    }

    public dgj(BleTaskQueueUtil.TaskType taskType, byte[] bArr, boolean z, int i) {
        this(taskType, bArr, z, i, true);
    }

    public dgj(BleTaskQueueUtil.TaskType taskType, byte[] bArr, boolean z, int i, boolean z2) {
        this.j = 0;
        this.f = taskType;
        this.e = bArr == null ? null : (byte[]) bArr.clone();
        this.d = z;
        this.g = i;
        this.b = new c(z2) { // from class: dgj.5
            {
                b(new byte[][]{BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, BluetoothGattDescriptor.ENABLE_INDICATION_VALUE});
            }
        };
    }

    public BleTaskQueueUtil.TaskType j() {
        return this.f;
    }

    public byte[] c() {
        byte[] bArr = this.e;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public boolean i() {
        return this.d;
    }

    public int f() {
        return this.g;
    }

    public IAsynBleTaskCallback e() {
        return this.f12225a;
    }

    public void a(IAsynBleTaskCallback iAsynBleTaskCallback) {
        this.f12225a = iAsynBleTaskCallback;
    }

    public int a() {
        return this.j;
    }

    public void e(int i) {
        this.j = i;
    }

    public c b() {
        return this.b;
    }

    public void b(c cVar) {
        this.b = cVar;
    }

    public void HE_(Bundle bundle) {
        this.c = bundle;
    }

    public Bundle HD_() {
        return this.c;
    }

    public class c {
        private byte[][] c;
        private boolean e;

        public c(boolean z) {
            this.e = z;
        }

        public void b(byte[][] bArr) {
            if (bArr != null) {
                this.c = (byte[][]) bArr.clone();
            }
        }

        public byte[][] a() {
            byte[][] bArr = this.c;
            return bArr != null ? (byte[][]) bArr.clone() : new byte[0][];
        }

        public boolean c() {
            return this.e;
        }
    }
}
