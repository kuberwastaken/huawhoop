package com.huawei.phoneservice.feedback.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hianalytics.visual.autocollect.instrument.ViewClickInstrumentation;
import com.huawei.phoneservice.faq.base.util.r;

/* JADX INFO: loaded from: classes6.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private final SparseArray<View> c;
    private a d;
    private b e;

    public interface a {
        void a(c cVar, int i);
    }

    public interface b {
        void a(c cVar, int i);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        b bVar = this.e;
        if (bVar == null) {
            return false;
        }
        bVar.a(this, getLayoutPosition());
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (r.cjR_(view)) {
            ViewClickInstrumentation.clickOnView(view);
            return;
        }
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(this, getLayoutPosition());
        }
        ViewClickInstrumentation.clickOnView(view);
    }

    public <T extends View> T clG_(int i) {
        T t = (T) this.c.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i);
        this.c.put(i, t2);
        return t2;
    }

    public c(View view) {
        super(view);
        this.c = new SparseArray<>();
    }
}
