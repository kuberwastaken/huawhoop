package com.huawei.uikit.hweventbadge.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.health.R;
import defpackage.vny;
import defpackage.vpd;

/* JADX INFO: loaded from: classes11.dex */
public class HwEventBadge extends View {
    private vny c;

    public HwEventBadge(Context context) {
        this(context, null);
    }

    private static Context b(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwEventBadge);
    }

    public vny getHwEventBadgeDrawable() {
        return this.c;
    }

    public int getMode() {
        vny vnyVar = this.c;
        if (vnyVar != null) {
            return vnyVar.c();
        }
        return -1;
    }

    public TextPaint getTextPaint() {
        vny vnyVar = this.c;
        if (vnyVar == null) {
            return null;
        }
        return vnyVar.eBe_();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(d(getSuggestedMinimumWidth(), i), d(getSuggestedMinimumHeight(), i2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        vny vnyVar = this.c;
        if (vnyVar != null) {
            vnyVar.b(i);
        }
    }

    public void setCount(int i) {
        vny vnyVar = this.c;
        if (vnyVar == null || vnyVar.a() == i) {
            return;
        }
        this.c.d(i);
        if (this.c.c() == 2) {
            requestLayout();
            invalidate();
        }
    }

    public void setHwEventBadgeDrawable(vny vnyVar) {
        this.c = vnyVar;
    }

    public void setMode(int i) {
        vny vnyVar = this.c;
        if (vnyVar == null || vnyVar.c() == i) {
            return;
        }
        this.c.a(i);
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        vny vnyVar = this.c;
        if (vnyVar != null) {
            vnyVar.c(i);
        }
    }

    public HwEventBadge(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100484_res_0x7f060344);
    }

    private int d(int i, int i2) {
        return View.MeasureSpec.getMode(i2) != 1073741824 ? i : View.MeasureSpec.getSize(i2);
    }

    public HwEventBadge(Context context, AttributeSet attributeSet, int i) {
        super(b(context, i), attributeSet, i);
        vny vnyVar = new vny();
        this.c = vnyVar;
        vnyVar.eBf_(super.getContext(), attributeSet, i);
        setBackground(this.c);
    }

    public void setCount(int i, int i2) {
        vny vnyVar = this.c;
        if (vnyVar != null) {
            int iA = vnyVar.a();
            int iB = this.c.b();
            if (iA == i && iB == i2) {
                return;
            }
            this.c.a(i, i2);
            if (this.c.c() == 2) {
                requestLayout();
                invalidate();
            }
        }
    }
}
