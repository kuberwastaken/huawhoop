package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class ax extends ar {
    private static final PointF p = new PointF();
    private final a n;
    private boolean o;
    private PointF q;
    private PointF r;
    private PointF s;
    private PointF t;

    public interface a {
        void a(ax axVar);
    }

    public static class b implements a {
        @Override // com.amap.api.col.3sl.ax.a
        public void a(ax axVar) {
        }
    }

    public ax(Context context, a aVar) {
        super(context);
        this.s = new PointF();
        this.t = new PointF();
        this.n = aVar;
    }

    @Override // com.amap.api.col.p0003sl.as
    protected final void a(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i != 5) {
            return;
        }
        a();
        this.g = MotionEvent.obtain(motionEvent);
        this.k = 0L;
        a(motionEvent);
        boolean zA = a(motionEvent, i2, i3);
        this.o = zA;
        if (zA) {
            return;
        }
        this.f = true;
    }

    @Override // com.amap.api.col.p0003sl.as
    protected final void a(int i, MotionEvent motionEvent) {
        if (i == 3) {
            a();
        } else {
            if (i != 6) {
                return;
            }
            a(motionEvent);
            if (!this.o) {
                this.n.a(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003sl.as
    protected final void a() {
        super.a();
        this.o = false;
        this.s.x = 0.0f;
        this.t.x = 0.0f;
        this.s.y = 0.0f;
        this.t.y = 0.0f;
    }

    @Override // com.amap.api.col.p0003sl.ar, com.amap.api.col.p0003sl.as
    protected final void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        this.q = b(motionEvent);
        this.r = b(motionEvent2);
        this.t = this.g.getPointerCount() != motionEvent.getPointerCount() ? p : new PointF(this.q.x - this.r.x, this.q.y - this.r.y);
        this.s.x += this.t.x;
        this.s.y += this.t.y;
    }

    public final float d() {
        return this.s.x;
    }

    public final float e() {
        return this.s.y;
    }
}
