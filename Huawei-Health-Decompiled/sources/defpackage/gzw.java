package defpackage;

import com.huawei.health.marketing.views.IViewVisibilityChange;

/* JADX INFO: loaded from: classes5.dex */
public class gzw {
    private boolean b;
    private IViewVisibilityChange d;

    public boolean b() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
        IViewVisibilityChange iViewVisibilityChange = this.d;
        if (iViewVisibilityChange != null) {
            iViewVisibilityChange.onVisibilityChange(z);
        }
    }

    public void e(IViewVisibilityChange iViewVisibilityChange) {
        this.d = iViewVisibilityChange;
    }
}
