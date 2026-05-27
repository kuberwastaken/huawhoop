package defpackage;

import android.view.View;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class vcy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f18582a;
    private List<String> b;
    private View.OnClickListener c;
    private View.OnClickListener d;
    private long e;
    private String j;

    public Object e() {
        return this.f18582a;
    }

    public void c(Object obj) {
        this.f18582a = obj;
    }

    public String f() {
        return this.j;
    }

    public void a(String str) {
        this.j = str;
    }

    public List<String> b() {
        return this.b;
    }

    public void e(List<String> list) {
        this.b = list;
    }

    public View.OnClickListener erY_() {
        return this.d;
    }

    public void esa_(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public long d() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public View.OnClickListener erZ_() {
        return this.c;
    }

    public void esb_(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vcy)) {
            return false;
        }
        vcy vcyVar = (vcy) obj;
        return this.e == vcyVar.e && Objects.equals(this.f18582a, vcyVar.f18582a) && Objects.equals(this.j, vcyVar.j) && Objects.equals(this.b, vcyVar.b);
    }

    public int hashCode() {
        return Objects.hash(this.f18582a, this.j, this.b, Long.valueOf(this.e));
    }
}
