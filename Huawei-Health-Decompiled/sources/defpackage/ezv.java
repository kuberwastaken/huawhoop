package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.ui.commonui.viewpager.HealthPagerAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class ezv extends HealthPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<View> f12861a;
    private Context d;

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public ezv(ArrayList<View> arrayList, Context context) {
        new ArrayList(10);
        this.f12861a = arrayList;
        this.d = context;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getCount() {
        if (mgx.d(this.f12861a)) {
            return 0;
        }
        return this.f12861a.size();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (mgx.a(this.f12861a, i)) {
            viewGroup.removeView(this.f12861a.get(i));
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (!mgx.a(this.f12861a, i)) {
            return null;
        }
        View view = this.f12861a.get(i);
        if (view == null) {
            return view;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        viewGroup.addView(view);
        return view;
    }
}
