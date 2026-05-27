package defpackage;

import android.view.View;
import com.huawei.ui.commonui.viewpager.HealthViewPager;

/* JADX INFO: loaded from: classes7.dex */
public class ojl implements HealthViewPager.PageTransformer {
    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.PageTransformer
    public void transformPage(View view, float f) {
        view.setAlpha(1.0f - (Math.abs(f) * 0.0f));
    }
}
