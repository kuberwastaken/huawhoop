package defpackage;

import com.huawei.ui.commonui.listener.OnClickSectionListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class faf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Object> f12869a;
    private OnClickSectionListener b;
    private List<Object> c;
    private List<Object> d;
    private List<Object> e;
    private List<Map<Object, Object>> j;

    public faf(List<Object> list, List<Object> list2, List<Object> list3, List<Map<Object, Object>> list4, List<Object> list5, OnClickSectionListener onClickSectionListener) {
        this.e = list;
        this.c = list2;
        this.d = list3;
        this.j = list4;
        this.f12869a = list5;
        this.b = onClickSectionListener;
    }

    public List<Object> c() {
        return this.e;
    }

    public List<Object> d() {
        return this.c;
    }

    public List<Object> b() {
        return this.d;
    }

    public List<Map<Object, Object>> h() {
        return this.j;
    }

    public List<Object> e() {
        return this.f12869a;
    }

    public OnClickSectionListener a() {
        return this.b;
    }
}
