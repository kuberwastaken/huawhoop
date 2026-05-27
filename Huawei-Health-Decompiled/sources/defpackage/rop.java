package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class rop {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17456a;
    private Drawable b;
    private CharSequence c;
    private View.OnClickListener d;
    private int e;
    private Map<String, Object> f;
    private String g;
    private Drawable h;
    private CharSequence i;

    public void e(rop ropVar) {
        if (ropVar == null) {
            return;
        }
        this.f17456a = ropVar.d();
        this.e = ropVar.a();
        this.b = ropVar.dAv_();
        this.c = ropVar.c();
        this.i = ropVar.h();
        this.h = ropVar.dAw_();
        this.d = ropVar.dAu_();
        this.g = ropVar.j();
        this.f = ropVar.g();
    }

    public int d() {
        return this.f17456a;
    }

    public void a(int i) {
        this.f17456a = i;
    }

    public int a() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public Drawable dAv_() {
        return this.b;
    }

    public void dAy_(Drawable drawable) {
        this.b = drawable;
    }

    public CharSequence c() {
        return this.c;
    }

    public void a(CharSequence charSequence) {
        this.c = charSequence;
    }

    public CharSequence h() {
        return this.i;
    }

    public void e(CharSequence charSequence) {
        this.i = charSequence;
    }

    public Drawable dAw_() {
        return this.h;
    }

    public void dAz_(Drawable drawable) {
        this.h = drawable;
    }

    public View.OnClickListener dAu_() {
        return this.d;
    }

    public void dAx_(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public String j() {
        return this.g;
    }

    public void a(String str) {
        this.g = str;
    }

    public Map<String, Object> g() {
        return this.f;
    }

    public void a(Map<String, Object> map) {
        this.f = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rop)) {
            return false;
        }
        rop ropVar = (rop) obj;
        return d() == ropVar.d() && a() == ropVar.a() && Objects.equals(dAv_(), ropVar.dAv_()) && a(c(), ropVar.c()) && a(h(), ropVar.h()) && Objects.equals(dAw_(), ropVar.dAw_()) && Objects.equals(dAu_(), ropVar.dAu_()) && Objects.equals(j(), ropVar.j()) && Objects.equals(g(), ropVar.g());
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(d()), Integer.valueOf(a()), dAv_(), c(), h(), dAw_(), dAu_(), j(), g());
    }

    private boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        return (charSequence == null || charSequence2 == null || !charSequence.toString().equals(charSequence2.toString())) ? false : true;
    }
}
