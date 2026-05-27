package defpackage;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fbp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12888a;
    private List<View.OnClickListener> d;
    private List<String> e;

    public fbp(List<String> list, List<View.OnClickListener> list2, int i) {
        this.e = list;
        this.d = list2;
        this.f12888a = i;
    }

    public List<String> b() {
        return this.e;
    }

    public List<View.OnClickListener> a() {
        return this.d;
    }

    public int d() {
        return this.f12888a;
    }
}
