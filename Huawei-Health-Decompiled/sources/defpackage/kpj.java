package defpackage;

import com.huawei.hwcommonmodel.accessibility.AbstractTouchNode;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class kpj {
    private Class<? extends AbstractTouchNode> e;
    private final String d = "ChartTouchProvider";
    private List<AbstractTouchNode> c = new ArrayList();

    public kpj(Class<? extends AbstractTouchNode> cls) {
        this.e = cls;
    }

    public int d() {
        return this.c.size();
    }

    public int c(int i, int i2) {
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            if (this.c.get(i3).getRect().contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    public AbstractTouchNode d(int i) {
        if (i >= this.c.size()) {
            for (int size = this.c.size(); size <= i; size++) {
                e();
            }
        }
        return this.c.get(i);
    }

    public void b() {
        this.c.clear();
    }

    private void e() {
        try {
            this.c.add(this.e.newInstance());
        } catch (IllegalAccessException | InstantiationException unused) {
            ReleaseLogUtil.c("ChartTouchProvider", "reflect error");
        }
    }
}
