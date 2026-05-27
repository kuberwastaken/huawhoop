package defpackage;

import com.huawei.multisimsdk.multidevicemanager.common.AbsPairedDevice;
import com.huawei.multisimsdk.multidevicemanager.common.AbsPrimaryDevice;
import com.huawei.multisimsdk.multidevicemanager.common.AuthParam;

/* JADX INFO: loaded from: classes6.dex */
public class mzs {
    private AbsPrimaryDevice b;
    private AuthParam d;
    private AbsPairedDevice e;

    private mzs() {
    }

    static class d {
        private static final mzs c = new mzs();
    }

    public static mzs e() {
        return d.c;
    }

    public void a(AuthParam authParam, AbsPrimaryDevice absPrimaryDevice, AbsPairedDevice absPairedDevice) {
        this.d = authParam;
        this.b = absPrimaryDevice;
        this.e = absPairedDevice;
    }

    public AuthParam d() {
        return this.d;
    }

    public AbsPrimaryDevice b() {
        return this.b;
    }

    public AbsPairedDevice a() {
        return this.e;
    }
}
