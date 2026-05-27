package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes7.dex */
public class pjs {
    private View b;
    private View c;
    private View d;
    private View e;

    public View cRD_(ViewGroup viewGroup, int i) {
        if (this.d == null) {
            View view = new View(viewGroup.getContext());
            this.d = view;
            view.setBackgroundResource(i);
            viewGroup.addView(this.d, 0);
        }
        return this.d;
    }

    public View cRH_() {
        return this.d;
    }

    public void cRL_(ViewGroup viewGroup) {
        View view = this.d;
        if (view != null) {
            viewGroup.removeView(view);
            this.d = null;
        }
    }

    public View cRA_(ViewGroup viewGroup, int i) {
        if (this.e == null) {
            View view = new View(viewGroup.getContext());
            this.e = view;
            view.setBackgroundResource(i);
            viewGroup.addView(this.e, 0);
        }
        return this.e;
    }

    public View cRF_() {
        return this.e;
    }

    public void cRJ_(ViewGroup viewGroup) {
        View view = this.e;
        if (view != null) {
            viewGroup.removeView(view);
            this.e = null;
        }
    }

    public View cRB_(ViewGroup viewGroup, int i) {
        if (this.b == null) {
            View view = new View(viewGroup.getContext());
            this.b = view;
            view.setBackgroundResource(i);
            viewGroup.addView(this.b, 0);
        }
        return this.b;
    }

    public View cRG_() {
        return this.b;
    }

    public void cRK_(ViewGroup viewGroup) {
        View view = this.b;
        if (view != null) {
            viewGroup.removeView(view);
            this.b = null;
        }
    }

    public View cRC_(ViewGroup viewGroup, int i) {
        if (this.c == null) {
            View view = new View(viewGroup.getContext());
            this.c = view;
            view.setBackgroundResource(i);
            viewGroup.addView(this.c, 0);
        }
        return this.c;
    }

    public View cRE_() {
        return this.c;
    }

    public void cRI_(ViewGroup viewGroup) {
        View view = this.c;
        if (view != null) {
            viewGroup.removeView(view);
            this.c = null;
        }
    }
}
