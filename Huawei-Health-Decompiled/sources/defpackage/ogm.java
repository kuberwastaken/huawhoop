package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.ui.commonui.viewpager.HealthPagerAdapter;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ogm extends HealthPagerAdapter {
    private List<View> d;
    private Context e;

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public ogm(Context context, List<View> list) {
        this.e = context;
        this.d = list;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getCount() {
        if (mgx.d(this.d)) {
            return 0;
        }
        return this.d.size();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (mgx.e((Collection<?>) this.d, i)) {
            return null;
        }
        View view = this.d.get(i);
        viewGroup.addView(view);
        return view;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
