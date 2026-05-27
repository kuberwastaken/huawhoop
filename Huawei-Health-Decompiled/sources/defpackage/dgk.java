package defpackage;

import android.content.ContentValues;
import com.huawei.health.devicemgr.business.entity.DeviceInfo;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dgk implements Comparable<dgk> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12227a;
    private DeviceInfo b;
    private ContentValues c;
    private long d;
    private int f;
    private int g;
    private List<dgk> h;
    private Object j;
    private boolean e = false;
    private boolean i = true;

    public boolean i() {
        return this.i;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public boolean h() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public Object f() {
        return dne.b(this.j);
    }

    public void d(Object obj) {
        this.j = dne.b(obj);
    }

    public ContentValues HJ_() {
        return this.c;
    }

    public void HK_(ContentValues contentValues) {
        this.c = contentValues;
    }

    public int d() {
        return ((Integer) dne.b(Integer.valueOf(this.g))).intValue();
    }

    public void a(int i) {
        this.g = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public long e() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public int j() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public String c() {
        return this.f12227a;
    }

    public void b(String str) {
        this.f12227a = str;
    }

    public List<dgk> g() {
        return this.h;
    }

    public void e(List<dgk> list) {
        this.h = list;
    }

    public DeviceInfo b() {
        return this.b;
    }

    public void d(DeviceInfo deviceInfo) {
        this.b = deviceInfo;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(dgk dgkVar) {
        if (dgkVar == null) {
            return 1;
        }
        return Long.compare(dgkVar.e(), this.d);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof dgk) && this.d == ((dgk) obj).e();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "DeviceGroupInfo{object=" + this.j + ", mContentValues=" + this.c + ", mDeviceType=" + this.g + ", line=" + this.e + ", mCompareTime=" + this.d + ", mDisplayType=" + this.f + ", mCommonDeviceName='" + this.f12227a + "', mSportDeviceList=" + this.h + '}';
    }
}
