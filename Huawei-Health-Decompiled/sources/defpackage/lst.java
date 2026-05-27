package defpackage;

import com.huawei.health.devicemgr.business.entity.DeviceInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lst {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15444a;
    private DeviceInfo b;
    private String c;
    private long d;
    private int e;
    private int f;
    private List<lsx> j = new ArrayList(16);

    public void d(long j) {
        this.d = j;
    }

    public int a() {
        return this.f15444a;
    }

    public void e(int i) {
        this.f15444a = i;
    }

    public int e() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public int d() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public void e(String str) {
        this.c = str;
    }

    public List<lsx> b() {
        return this.j;
    }

    public DeviceInfo c() {
        return this.b;
    }

    public void d(DeviceInfo deviceInfo) {
        this.b = deviceInfo;
    }

    public String toString() {
        return "{mDictTypeId:" + this.f15444a + this.j + "}";
    }
}
