package defpackage;

import com.huawei.hihealth.HiHealthData;
import health.compact.a.HiCommonUtil;
import health.compact.a.util.LogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class jwv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f14482a;
    private long b;
    private List<Integer> c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j;
    private int k;

    public jwv() {
    }

    public jwv(int i) {
        this.d = i;
    }

    public jwv(String str) {
        this.j = str;
    }

    public jwv(int i, String str) {
        this.d = i;
        this.j = str;
    }

    public jwv(int i, int i2) {
        this.d = i;
        this.k = i2;
    }

    public jwv(int i, int i2, int i3, int i4) {
        this.d = i;
        this.f = i2;
        this.k = i3;
        this.e = i4;
    }

    public jwv(int i, int i2, int i3) {
        this.d = i3;
        this.f = i2;
        this.k = i;
    }

    public int j() {
        return this.i;
    }

    public void i(int i) {
        this.i = i;
    }

    public String h() {
        return this.j;
    }

    public int b() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public int d() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public int c() {
        return this.f;
    }

    public void e(int i) {
        this.f = i;
    }

    public int i() {
        return this.k;
    }

    public void h(int i) {
        this.k = i;
    }

    public long e() {
        return this.b;
    }

    public void c(long j) {
        this.b = j;
    }

    public void a(int i) {
        this.g = i;
    }

    public int g() {
        return this.g;
    }

    public List<Integer> a() {
        return this.c;
    }

    public void b(List<Integer> list) {
        this.c = list;
    }

    public void c(int i) {
        this.h = i;
    }

    public int f() {
        return this.h;
    }

    public void a(long j) {
        this.f14482a = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiHealthContext{app=");
        stringBuffer.append(this.d);
        stringBuffer.append(", device=").append(this.f);
        stringBuffer.append(", client=").append(this.e);
        stringBuffer.append(", who=").append(this.k);
        stringBuffer.append(", packageName='").append(this.j).append("', syncType=");
        stringBuffer.append(this.i);
        stringBuffer.append(", cloudDevice=").append(this.b);
        stringBuffer.append(", needUploadData=").append(this.g);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public static void e(HiHealthData hiHealthData, jwv jwvVar) {
        if (HiCommonUtil.a(hiHealthData)) {
            LogUtil.c("HiH_HiHealthContext", "setSource hiHealthDatas == null");
            return;
        }
        if (HiCommonUtil.a(jwvVar)) {
            LogUtil.c("HiH_HiHealthContext", "setSource hiContext == null");
            return;
        }
        hiHealthData.setUserId(jwvVar.i());
        hiHealthData.setAppId(jwvVar.d());
        hiHealthData.setDeviceId(jwvVar.c());
        hiHealthData.setClientId(jwvVar.b());
        hiHealthData.setSyncStatus(jwvVar.j());
    }
}
