package defpackage;

import com.huawei.ui.commonui.listener.OnClickSectionListener;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fbg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f12884a;
    private List<Long> b;
    private List<String> c;
    private List<String> d;
    private List<Double> e;
    private OnClickSectionListener f;

    public List<String> d() {
        return this.f12884a;
    }

    public void c(List<String> list) {
        this.f12884a = list;
    }

    public List<String> e() {
        return this.d;
    }

    public void a(List<String> list) {
        this.d = list;
    }

    public List<String> b() {
        return this.c;
    }

    public void e(List<String> list) {
        this.c = list;
    }

    public List<Double> c() {
        return this.e;
    }

    public void d(List<Double> list) {
        this.e = list;
    }

    public List<Long> a() {
        return this.b;
    }

    public void b(List<Long> list) {
        this.b = list;
    }

    public OnClickSectionListener f() {
        return this.f;
    }

    public void c(OnClickSectionListener onClickSectionListener) {
        this.f = onClickSectionListener;
    }
}
