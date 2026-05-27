package com.huawei.uikit.hwcommon.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Pair;
import com.huawei.uikit.hwcommon.drawable.HwDrawableWrapper;
import defpackage.vnp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class HwGradientAnimatorMgr implements HwDrawableWrapper.OnStateChangedListener {
    private Animator c;
    private Map<String, Pair<Integer, Integer>> d = new HashMap(16);
    private OnAnimatorListener e;

    public interface OnAnimatorListener {
        void onAnimationCancel(Animator animator, String str);

        void onAnimationEnd(Animator animator, String str);

        void onAnimationStart(Animator animator, String str);

        void onAnimationUpdate(Animator animator, String str, int i);

        boolean onPrepareAnimation(int[] iArr, int[] iArr2, int i, int i2, Map<String, Pair<Integer, Integer>> map);
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (HwGradientAnimatorMgr.this.e != null) {
                Iterator it = HwGradientAnimatorMgr.this.d.keySet().iterator();
                while (it.hasNext()) {
                    HwGradientAnimatorMgr.this.e.onAnimationCancel(animator, (String) it.next());
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (HwGradientAnimatorMgr.this.e != null) {
                Iterator it = HwGradientAnimatorMgr.this.d.keySet().iterator();
                while (it.hasNext()) {
                    HwGradientAnimatorMgr.this.e.onAnimationEnd(animator, (String) it.next());
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (HwGradientAnimatorMgr.this.e != null) {
                Iterator it = HwGradientAnimatorMgr.this.d.keySet().iterator();
                while (it.hasNext()) {
                    HwGradientAnimatorMgr.this.e.onAnimationStart(animator, (String) it.next());
                }
            }
        }
    }

    public Animator ezn_(Map<String, Pair<Integer, Integer>> map) {
        this.d = map;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "GradientValue", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(vnp.c());
        objectAnimatorOfFloat.setDuration(50L);
        objectAnimatorOfFloat.addListener(new c());
        return objectAnimatorOfFloat;
    }

    @Override // com.huawei.uikit.hwcommon.drawable.HwDrawableWrapper.OnStateChangedListener
    public void onStateChanged(int[] iArr, int[] iArr2, int i, int i2) {
        if (this.e == null || iArr == null || iArr2 == null) {
            return;
        }
        HashMap map = new HashMap(16);
        if (this.e.onPrepareAnimation(iArr, iArr2, i, i2, map)) {
            Animator animator = this.c;
            if (animator != null && animator.isRunning()) {
                this.c.cancel();
            }
            Animator animatorEzn_ = ezn_(map);
            this.c = animatorEzn_;
            animatorEzn_.start();
        }
    }
}
