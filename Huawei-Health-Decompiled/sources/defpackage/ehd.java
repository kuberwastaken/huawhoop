package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes4.dex */
public class ehd {
    private static ehd e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BluetoothAdapter f12592a;

    private ehd() {
    }

    public static ehd a() {
        if (e == null) {
            e = new ehd();
        }
        return e;
    }

    public int e(Context context) {
        if (this.f12592a == null) {
            LogUtil.a("BluetoothHelper", "getBluetoothEnabledStatus init bluetoothAdapter is null");
            BluetoothManager bluetoothManager = context.getSystemService("bluetooth") instanceof BluetoothManager ? (BluetoothManager) context.getSystemService("bluetooth") : null;
            if (bluetoothManager == null) {
                LogUtil.c("BluetoothHelper", "getBluetoothEnabledStatus no BT Manager in this phone");
                return 0;
            }
            this.f12592a = bluetoothManager.getAdapter();
        }
        BluetoothAdapter bluetoothAdapter = this.f12592a;
        if (bluetoothAdapter == null) {
            LogUtil.c("BluetoothHelper", "getBluetoothEnabledStatus no BT in this phone");
            return 0;
        }
        if (bluetoothAdapter.isEnabled()) {
            return 1;
        }
        LogUtil.a("BluetoothHelper", "getBluetoothEnabledStatus is no enabled");
        return 2;
    }

    public void e() {
        e = null;
    }
}
