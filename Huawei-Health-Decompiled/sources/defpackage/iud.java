package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class iud extends itz {
    private List<irt> e = null;
    private boolean d = false;
    private List<Integer> c = null;

    public void a(List<irt> list) {
        if (this.e == null) {
            this.e = new ArrayList(16);
        }
        this.e.addAll(list);
    }

    public List<irt> i() {
        return this.e;
    }

    public boolean f() {
        return this.d;
    }

    public List<Integer> h() {
        return this.c;
    }
}
