package defpackage;

import android.graphics.drawable.Drawable;
import com.huawei.ui.commonui.listener.OnClickSectionListener;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fbf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Integer> f12883a;
    private List<String> b;
    private List<Drawable> c;
    private List<String> d;
    private OnClickSectionListener e;
    private List<String> f;
    private List<String> g;
    private List<Integer> h;

    public fbf(List<Drawable> list, List<String> list2, List<String> list3, List<String> list4, List<Integer> list5, List<String> list6, List<Integer> list7, OnClickSectionListener onClickSectionListener) {
        this.c = list;
        this.d = list2;
        this.g = list3;
        this.b = list4;
        this.f12883a = list5;
        this.f = list6;
        this.h = list7;
        this.e = onClickSectionListener;
    }

    public List<Drawable> e() {
        return this.c;
    }

    public List<String> a() {
        return this.d;
    }

    public List<String> b() {
        return this.b;
    }

    public List<Integer> d() {
        return this.f12883a;
    }

    public List<String> j() {
        return this.f;
    }

    public List<Integer> h() {
        return this.h;
    }

    public OnClickSectionListener c() {
        return this.e;
    }
}
