package com.huawei.ui.commonui.activetips;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.health.R;
import defpackage.plo;

/* JADX INFO: loaded from: classes7.dex */
public class ActiveTipsView extends RelativeLayout {
    private View b;
    private Context c;
    private TextView d;
    private TextView e;

    public ActiveTipsView(Context context) {
        super(context);
        this.c = context;
        b();
    }

    public ActiveTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = context;
        b();
    }

    public ActiveTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = context;
        b();
    }

    private void b() {
        View viewInflate = LayoutInflater.from(this.c).inflate(R.layout.active_tips, this);
        this.b = viewInflate;
        if (viewInflate == null) {
            return;
        }
        this.e = (TextView) viewInflate.findViewById(R.id.active_tips_text);
        this.d = (TextView) this.b.findViewById(R.id.goto_active_center);
        Typeface typefaceCWu_ = plo.cWu_();
        this.e.setTypeface(typefaceCWu_);
        this.d.setTypeface(typefaceCWu_);
    }

    public void setActiveBtText(String str) {
        this.d.setText(str);
    }

    public void setTipsText(String str) {
        this.e.setText(str);
    }

    public void setClickActiveListener(View.OnClickListener onClickListener) {
        this.d.setOnClickListener(onClickListener);
    }

    public void setClickBannerListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }
}
