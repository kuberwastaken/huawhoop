package com.huawei.uikit.phone.hwhorizontalscrollview.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.uikit.phone.hwunifiedinteract.widget.HwGenericEventDetector;

/* JADX INFO: loaded from: classes8.dex */
public class HwHorizontalScrollView extends com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView {
    public HwHorizontalScrollView(Context context) {
        this(context, null);
    }

    public HwHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public HwGenericEventDetector e() {
        return new HwGenericEventDetector(getContext());
    }

    public HwHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
