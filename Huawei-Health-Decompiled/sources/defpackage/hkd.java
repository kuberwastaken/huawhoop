package defpackage;

import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class hkd {
    public static void aPy_(View view, float f, float f2, int i) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "Alpha", f, f2);
        objectAnimatorOfFloat.setDuration(i);
        objectAnimatorOfFloat.start();
    }
}
