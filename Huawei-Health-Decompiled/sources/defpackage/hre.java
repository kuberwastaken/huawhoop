package defpackage;

import com.huawei.health.tradeservice.pay.ReservedInfor;

/* JADX INFO: loaded from: classes5.dex */
public class hre {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13940a;
    private int b;
    private ReservedInfor c;
    private String d;

    public ReservedInfor a() {
        return this.c;
    }

    public void b(ReservedInfor reservedInfor) {
        this.c = reservedInfor;
    }

    public void a(String str) {
        this.d = str;
    }

    public String e() {
        return this.d;
    }

    public void e(int i) {
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public void d(String str) {
        this.f13940a = str;
    }

    public String c() {
        return this.f13940a;
    }

    public String toString() {
        return "ProductId = " + this.d + " PriceType = " + this.b + " AppPayLoad = " + this.f13940a + " ReservedInfor = " + this.c;
    }
}
