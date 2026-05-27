package com.huawei.openalliance.ad.views.feedback;

import android.view.View;
import com.huawei.openalliance.ad.hq;
import com.huawei.openalliance.ad.utils.bj;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class e {
    private int b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<View> f8354a = new ArrayList();
    private int c = 0;

    public void a(View view) {
        this.f8354a.add(view);
        if (this.b < view.getMeasuredHeight()) {
            this.b = view.getMeasuredHeight();
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (bj.a(this.f8354a)) {
            return;
        }
        if (i == -1) {
            int measuredWidth = i3 + (i5 - this.c) + i2 + i6;
            for (int size = this.f8354a.size() - 1; size >= 0; size--) {
                this.f8354a.get(size).layout(measuredWidth, i4, this.f8354a.get(size).getMeasuredWidth() + measuredWidth, this.f8354a.get(size).getMeasuredHeight() + i4);
                measuredWidth += this.f8354a.get(size).getMeasuredWidth() + i6;
            }
            return;
        }
        if (i == 0) {
            int size2 = ((((this.f8354a.size() - 1) * i6) + i5) - this.c) / (this.f8354a.size() + 1);
            for (View view : this.f8354a) {
                int i7 = i3 + size2;
                view.layout(i7, i4, view.getMeasuredWidth() + i7, view.getMeasuredHeight() + i4);
                i3 = i7 + view.getMeasuredWidth();
            }
            return;
        }
        if (i != 1) {
            hq.b("FlowLayoutLine", "lineMode error");
            return;
        }
        for (View view2 : this.f8354a) {
            view2.layout(i3, i4, view2.getMeasuredWidth() + i3, view2.getMeasuredHeight() + i4);
            i3 += view2.getMeasuredWidth() + i6;
        }
    }

    public void a(int i) {
        this.c = i;
    }

    public int a() {
        return this.b;
    }
}
