package defpackage;

import android.os.Build;
import com.huawei.multisimsdk.multidevicemanager.common.AbsPrimaryDevice;

/* JADX INFO: loaded from: classes7.dex */
public class osj extends AbsPrimaryDevice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16542a;
    private String b;
    private String c;

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AbsPrimaryDevice
    public int getPrimaryIDType() {
        return 0;
    }

    public void a(String str) {
        this.f16542a = (String) kqt.e(str);
    }

    public String d() {
        return (String) kqt.e(this.f16542a);
    }

    public String a() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String b() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AbsPrimaryDevice
    public String getPrimaryID() {
        return d();
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AbsPrimaryDevice
    public String getTerminalId() {
        return a();
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AbsPrimaryDevice
    public String getTerminalVendor() {
        return Build.MANUFACTURER;
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AbsPrimaryDevice
    public String getTerminalModel() {
        return Build.MODEL;
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AbsPrimaryDevice
    public String getTerminalSwVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AbsPrimaryDevice
    public String getCompanionTerminalService() {
        return b();
    }
}
