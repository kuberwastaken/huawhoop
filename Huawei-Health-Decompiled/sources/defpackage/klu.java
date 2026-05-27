package defpackage;

import android.bluetooth.BluetoothDevice;
import com.huawei.hwbtsdk.btdatatype.callback.BtDeviceStateCallback;

/* JADX INFO: loaded from: classes5.dex */
public class klu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BluetoothDevice f14745a;
    private String b;
    private int c;
    private BtDeviceStateCallback d;
    private String e;
    private int f;

    public int e() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public BluetoothDevice bJz_() {
        return this.f14745a;
    }

    public void bJA_(BluetoothDevice bluetoothDevice) {
        this.f14745a = bluetoothDevice;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public String a() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public BtDeviceStateCallback b() {
        return this.d;
    }

    public void c(BtDeviceStateCallback btDeviceStateCallback) {
        this.d = btDeviceStateCallback;
    }

    public int j() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }
}
