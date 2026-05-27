package defpackage;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import huawei.android.widget.HwSafeInsetsShareable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class vpv implements HwSafeInsetsShareable {
    private Map<View, c> e = new HashMap();

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f18721a;
        Rect b = new Rect();
        int e;

        c(View view, int i) {
            this.e = 1;
            this.f18721a = view;
            if (i == 2) {
                this.e = i;
            }
            d();
        }

        private void d() {
            View view = this.f18721a;
            if (this.e == 2) {
                this.b.set(vpv.this.eGC_(view));
            } else {
                this.b.set(vpv.this.eGB_(view));
            }
        }
    }

    private boolean d(c cVar, vpt vptVar) {
        View view = cVar.f18721a;
        Rect rectEGO_ = vptVar.eGO_(view, cVar.b);
        if (rectEGO_.equals(eGC_(view))) {
            return false;
        }
        view.setPadding(rectEGO_.left, rectEGO_.top, rectEGO_.right, rectEGO_.bottom);
        return true;
    }

    @Override // huawei.android.widget.HwSafeInsetsShareable
    public void addSharedView(View view, int i) {
        if (view == null || this.e.containsKey(view)) {
            return;
        }
        this.e.put(view, new c(view, i));
    }

    public void c(vpt vptVar) {
        Iterator<c> it = this.e.values().iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (e(it.next(), vptVar)) {
                z = true;
            }
        }
        if (z) {
            vptVar.b();
        }
    }

    public void eGD_(Configuration configuration) {
        c();
    }

    @Override // huawei.android.widget.HwSafeInsetsShareable
    public void removeSharedView(View view) {
        this.e.remove(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(vpv.c r9, defpackage.vpt r10) {
        /*
            r8 = this;
            android.view.View r0 = r9.f18721a
            int r1 = r0.getWidth()
            r2 = 0
            if (r1 == 0) goto L70
            int r1 = r0.getHeight()
            if (r1 != 0) goto L10
            goto L70
        L10:
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            boolean r3 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r3 != 0) goto L19
            return r2
        L19:
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            android.graphics.Rect r3 = r10.eGP_()
            android.graphics.Rect r9 = r9.b
            android.graphics.Rect r10 = r10.eGO_(r0, r9)
            android.graphics.Rect r4 = r8.eGB_(r0)
            int r5 = r3.left
            r6 = 1
            if (r5 != 0) goto L41
            int r7 = r3.right
            if (r7 != 0) goto L41
            boolean r10 = r9.equals(r4)
            if (r10 != 0) goto L6b
            int r10 = r9.left
            r1.leftMargin = r10
            int r9 = r9.right
            r1.rightMargin = r9
            goto L6a
        L41:
            if (r5 <= 0) goto L4c
            int r5 = r10.left
            int r7 = r4.left
            if (r5 <= r7) goto L55
            r1.leftMargin = r5
            goto L54
        L4c:
            int r5 = r4.left
            int r7 = r9.left
            if (r5 <= r7) goto L55
            r1.leftMargin = r7
        L54:
            r2 = r6
        L55:
            int r3 = r3.right
            if (r3 <= 0) goto L62
            int r9 = r10.right
            int r10 = r4.right
            if (r9 <= r10) goto L6b
            r1.rightMargin = r9
            goto L6a
        L62:
            int r10 = r4.right
            int r9 = r9.right
            if (r10 <= r9) goto L6b
            r1.rightMargin = r9
        L6a:
            r2 = r6
        L6b:
            if (r2 == 0) goto L70
            r0.setLayoutParams(r1)
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vpv.a(vpv$c, vpt):boolean");
    }

    private boolean e(c cVar, vpt vptVar) {
        int i = cVar.e;
        if (i == 1) {
            return a(cVar, vptVar);
        }
        if (i != 2) {
            return false;
        }
        return d(cVar, vptVar);
    }

    private void c() {
        Iterator<c> it = this.e.values().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private void b(c cVar) {
        View view = cVar.f18721a;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            Rect rect = cVar.b;
            marginLayoutParams.leftMargin = rect.left;
            marginLayoutParams.rightMargin = rect.right;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public void eGE_(View view, vpt vptVar) {
        c cVar = this.e.get(view);
        if (cVar != null) {
            e(cVar, vptVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect eGB_(View view) {
        Rect rect = new Rect();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            rect.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect eGC_(View view) {
        Rect rect = new Rect();
        if (view != null) {
            rect.set(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        return rect;
    }
}
