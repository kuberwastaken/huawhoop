package com.huawei.health.suggestion.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes10.dex */
public class FoldView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3543a;
    private View b;

    public FoldView(Context context) {
        this(context, null);
    }

    public FoldView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setView(View view) {
        this.b = view;
        addView(view);
    }

    public void setFiexdHeight(int i) {
        this.f3543a = i;
    }

    private void setAnimatedHeight(int i) {
        if (this.b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.height = i;
            this.b.setLayoutParams(layoutParams);
        }
    }
}
