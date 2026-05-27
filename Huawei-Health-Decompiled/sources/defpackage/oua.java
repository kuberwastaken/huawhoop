package defpackage;

import android.view.View;
import com.huawei.health.R;
import com.huawei.skinner.attrentry.SkinAttr;
import com.huawei.skinner.theme.ThemeServiceInterceptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class oua {
    private ThemeServiceInterceptor b;
    private WeakReference<View> c;
    private boolean e;
    public boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<SkinAttr> f16556a = new ArrayList();

    public void c(boolean z) {
        View viewCCQ_;
        if (out.b(this.f16556a) || (viewCCQ_ = cCQ_()) == null) {
            return;
        }
        viewCCQ_.setTag(R.id.hw_tag_animate_enable, Boolean.valueOf(this.d));
        for (SkinAttr skinAttr : this.f16556a) {
            if (!skinAttr.isCancled) {
                skinAttr.apply(viewCCQ_, z);
            }
        }
    }

    public void b() {
        ThemeServiceInterceptor themeServiceInterceptor;
        View viewCCQ_ = cCQ_();
        if (viewCCQ_ == null || !this.e || (themeServiceInterceptor = this.b) == null) {
            return;
        }
        themeServiceInterceptor.process(viewCCQ_);
    }

    public View cCQ_() {
        WeakReference<View> weakReference = this.c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void cCR_(View view) {
        Object tag = view.getTag(R.id.hw_theme_service_tag);
        if ((tag instanceof String) && "hwThemeServiceEnable".equals((String) tag)) {
            this.e = true;
        }
        this.c = new WeakReference<>(view);
    }

    public List<SkinAttr> a() {
        return this.f16556a;
    }

    public ThemeServiceInterceptor e() {
        return this.b;
    }

    public void d(ThemeServiceInterceptor themeServiceInterceptor) {
        this.b = themeServiceInterceptor;
    }

    public void c() {
        if (out.b(this.f16556a)) {
            return;
        }
        Iterator<SkinAttr> it = this.f16556a.iterator();
        while (it.hasNext()) {
            it.next().setCancled(true);
        }
        this.f16556a.clear();
    }

    public String toString() {
        View viewCCQ_ = cCQ_();
        StringBuilder sb = new StringBuilder("SkinnableView [view=");
        sb.append(viewCCQ_ != null ? viewCCQ_.getClass().getSimpleName() : "Unknow");
        sb.append(", attrs=");
        sb.append(this.f16556a);
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        View viewCCQ_ = cCQ_();
        return viewCCQ_ != null ? viewCCQ_.hashCode() : super.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof oua) {
            oua ouaVar = (oua) obj;
            if (super.equals(obj)) {
                return true;
            }
            View viewCCQ_ = cCQ_();
            View viewCCQ_2 = ouaVar.cCQ_();
            if (viewCCQ_ != null && viewCCQ_.equals(viewCCQ_2)) {
                return true;
            }
        }
        return false;
    }
}
