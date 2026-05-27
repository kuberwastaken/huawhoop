package defpackage;

import com.huawei.health.devicemgr.business.entity.DeviceInfo;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lsp {
    private DeviceInfo b;
    private List<lsr> c;
    private int e;

    public int e() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public DeviceInfo d() {
        return this.b;
    }

    public void c(DeviceInfo deviceInfo) {
        this.b = deviceInfo;
    }

    public List<lsr> b() {
        return this.c;
    }

    public void c(List<lsr> list) {
        this.c = list;
    }

    public String toString() {
        return "{mDigitTypeId:" + this.e + this.c + "}";
    }
}
