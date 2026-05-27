package defpackage;

import android.content.Context;
import com.huawei.ui.homehealth.runcard.trackfragments.models.SportNounChildData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class rkt {
    private SportNounChildData c;
    private boolean b = false;
    private String e = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<rkv> f17391a = new ArrayList(10);

    public rkt(String str, int i, Context context) {
        this.c = new SportNounChildData(context);
        a(str, i);
    }

    private void a(String str, int i) {
        d(str);
        switch (i) {
            case 0:
                this.f17391a = this.c.d();
                break;
            case 1:
                this.f17391a = this.c.j();
                break;
            case 2:
                this.f17391a = this.c.h();
                break;
            case 3:
                this.f17391a = this.c.k();
                break;
            case 4:
                this.f17391a = this.c.g();
                break;
            case 5:
                this.f17391a = this.c.c();
                break;
            case 6:
                this.f17391a = this.c.i();
                break;
            case 7:
                this.f17391a = this.c.a();
                break;
        }
    }

    public int e() {
        List<rkv> list = this.f17391a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public rkv d(int i) {
        if (mgx.e((Collection<?>) this.f17391a, i)) {
            return null;
        }
        return this.f17391a.get(i);
    }

    public void a(boolean z) {
        this.b = z;
    }

    public String d() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }
}
