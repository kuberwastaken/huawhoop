package defpackage;

import com.huawei.pluginfitnessadvice.pricetagbean.PriceTagBean;
import com.huawei.ui.commonui.listener.OnClickSectionListener;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class fau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f12876a;
    private OnClickSectionListener b;
    private List<Object> c;
    private List<String> d;
    private List<List<PriceTagBean>> e;

    public List<Object> c() {
        return this.c;
    }

    public void d(List<Object> list) {
        this.c = list;
    }

    public List<String> e() {
        return this.d;
    }

    public void b(List<String> list) {
        this.d = list;
    }

    public List<String> b() {
        return this.f12876a;
    }

    public void a(List<String> list) {
        this.f12876a = list;
    }

    public List<List<PriceTagBean>> a() {
        return this.e;
    }

    public void e(List<List<PriceTagBean>> list) {
        this.e = list;
    }

    public OnClickSectionListener d() {
        return this.b;
    }

    public void a(OnClickSectionListener onClickSectionListener) {
        this.b = onClickSectionListener;
    }
}
