package defpackage;

import com.huawei.trade.datatype.ProductSummary;
import com.huawei.trade.datatype.TradeViewInfo;
import com.huawei.ui.commonui.utils.versioncontrol.VersionControlUtil;

/* JADX INFO: loaded from: classes4.dex */
public class guk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13628a;
    private boolean b;
    private boolean c;
    private ProductSummary d;
    private int e;
    private ProductSummary f;
    private TradeViewInfo g;

    public int d() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public boolean j() {
        return this.c;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.b;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public boolean g() {
        if (this.d != null) {
            return true;
        }
        return this.f13628a;
    }

    public ProductSummary c() {
        return this.f;
    }

    public void b(ProductSummary productSummary) {
        this.f = productSummary;
    }

    public ProductSummary a() {
        return this.d;
    }

    public void c(ProductSummary productSummary) {
        this.d = productSummary;
    }

    public TradeViewInfo e() {
        return this.g;
    }

    public void b(TradeViewInfo tradeViewInfo) {
        this.g = tradeViewInfo;
    }

    public boolean h() {
        if (f()) {
            return true;
        }
        return !VersionControlUtil.isSupportOperationAccount();
    }

    public boolean f() {
        int i = this.e;
        if (i == 0) {
            return true;
        }
        if (this.c && i == 2) {
            return true;
        }
        return i == 1 && this.b;
    }

    public boolean o() {
        return this.e == 2 && !this.c;
    }

    public boolean m() {
        return (this.e != 1 || g() || this.b) ? false : true;
    }

    public boolean n() {
        return this.e == 1 && g() && !this.c && !this.b;
    }

    public boolean l() {
        return this.e == 1 && g() && this.c && !this.b;
    }

    public boolean i() {
        return this.e == 1 && g() && !this.b;
    }
}
