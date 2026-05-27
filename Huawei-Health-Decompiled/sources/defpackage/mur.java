package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.health.R;
import com.huawei.ui.commonui.viewpager.HealthViewPager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mur implements HealthViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f15884a;
    private List<ImageView> b;
    private int c;
    private Context e;

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    public mur(Context context, LinearLayout linearLayout, int i) {
        this.e = context;
        this.f15884a = linearLayout;
        this.c = i;
        d();
    }

    private void d() {
        this.b = new ArrayList(0);
        for (int i = 0; i < this.c; i++) {
            ImageView imageView = new ImageView(this.e);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable._2131427605_res_0x7f0b0115);
            } else {
                imageView.setBackgroundResource(R.drawable._2131427604_res_0x7f0b0114);
            }
            this.f15884a.addView(imageView, layoutParams);
            this.b.add(imageView);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = 0;
        while (true) {
            int i3 = this.c;
            if (i2 >= i3) {
                return;
            }
            if (i % i3 == i2) {
                this.b.get(i2).setBackgroundResource(R.drawable._2131427605_res_0x7f0b0115);
            } else {
                this.b.get(i2).setBackgroundResource(R.drawable._2131427604_res_0x7f0b0114);
            }
            i2++;
        }
    }
}
