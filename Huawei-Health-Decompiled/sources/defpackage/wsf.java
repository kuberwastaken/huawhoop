package defpackage;

import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.monitor.MonitorDataCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class wsf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18902a;
    private int b;
    private MonitorDataCallback c;
    private int d;
    private Device e;

    public wsf(int i, int i2, MonitorDataCallback monitorDataCallback, Device device, String str) {
        this.d = i;
        this.b = i2;
        this.c = monitorDataCallback;
        this.e = device;
        this.f18902a = str;
    }

    public int d() {
        return this.d;
    }

    public int a() {
        return this.b;
    }

    public Device c() {
        return this.e;
    }

    public String b() {
        return this.f18902a;
    }

    public MonitorDataCallback e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof wsf) {
            wsf wsfVar = (wsf) obj;
            return this.d == wsfVar.d && this.b == wsfVar.b;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.d), Integer.valueOf(this.b));
    }
}
