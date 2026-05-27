package com.huawei.ui.commonui.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.health.R;
import com.huawei.ui.commonui.R$styleable;

/* JADX INFO: loaded from: classes7.dex */
public class HealthDivider extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9175a;
    private View c;
    private View d;

    public HealthDivider(Context context) {
        this(context, null);
    }

    public HealthDivider(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet);
        this.f9175a = 0;
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.health_common_divider_layout, this);
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.health_divider)) != null) {
            this.f9175a = typedArrayObtainStyledAttributes.getInteger(R$styleable.health_divider_dividerType, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f9175a == 1) {
            this.c = viewInflate.findViewById(R.id.health_divider_splitter);
            this.d = viewInflate.findViewById(R.id.health_divider_line);
            this.c.setVisibility(0);
            this.d.setVisibility(8);
        }
    }

    public void setDividerBackground(int i) {
        View view = this.d;
        if (view != null) {
            view.setBackgroundColor(i);
        }
        View view2 = this.c;
        if (view2 != null) {
            view2.setBackgroundColor(i);
        }
    }
}
