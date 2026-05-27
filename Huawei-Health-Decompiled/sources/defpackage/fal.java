package defpackage;

import com.huawei.ui.commonui.listener.OnClickSectionListener;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fal {
    private List<String> b;
    private List<String> c;
    private OnClickSectionListener d;
    private List<Object> e;

    public List<Object> b() {
        return this.e;
    }

    public void b(List<Object> list) {
        this.e = list;
    }

    public List<String> a() {
        return this.c;
    }

    public void a(List<String> list) {
        this.c = list;
    }

    public List<String> c() {
        return this.b;
    }

    public void d(List<String> list) {
        this.b = list;
    }

    public OnClickSectionListener e() {
        return this.d;
    }

    public void b(OnClickSectionListener onClickSectionListener) {
        this.d = onClickSectionListener;
    }
}
