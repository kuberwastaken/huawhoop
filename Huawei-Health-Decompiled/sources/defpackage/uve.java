package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.ui.commonui.viewpager.HealthPagerAdapter;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class uve extends HealthPagerAdapter {
    private List<View> d;

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public uve(List<View> list) {
        this.d = list;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getCount() {
        return this.d.size();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (mgx.e((Collection<?>) this.d, i)) {
            return null;
        }
        View view = this.d.get(i);
        if (viewGroup != null) {
            viewGroup.addView(view, 0);
        }
        return view;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        List<View> list = this.d;
        if (list == null || viewGroup == null) {
            return;
        }
        viewGroup.removeView(list.get(i));
    }
}
