package defpackage;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.huawei.hwfabengine.FloatingActionButtonAnimationListener;

/* JADX INFO: loaded from: classes11.dex */
class mfv {

    class d extends Animatable2.AnimationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingActionButtonAnimationListener f15611a;
        final /* synthetic */ FloatingActionButtonAnimationListener b;
        final /* synthetic */ Animatable2 d;

        d(FloatingActionButtonAnimationListener floatingActionButtonAnimationListener, FloatingActionButtonAnimationListener floatingActionButtonAnimationListener2, Animatable2 animatable2) {
            this.b = floatingActionButtonAnimationListener;
            this.f15611a = floatingActionButtonAnimationListener2;
            this.d = animatable2;
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            this.b.onAnimationEnd();
            mfv.d(this.f15611a);
            this.d.unregisterAnimationCallback(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void bWw_(Drawable drawable, FloatingActionButtonAnimationListener floatingActionButtonAnimationListener, FloatingActionButtonAnimationListener floatingActionButtonAnimationListener2) {
        try {
            if (drawable instanceof Animatable2) {
                Log.i("FloatingActionButtonAnimationUtils", "It starts to do animation.");
                Animatable2 animatable2 = (Animatable2) drawable;
                animatable2.start();
                bWv_(animatable2, floatingActionButtonAnimationListener, floatingActionButtonAnimationListener2);
            }
        } catch (NoClassDefFoundError unused) {
            Log.e("FloatingActionButtonAnimationUtils", "It can not find the class Animatable2.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(FloatingActionButtonAnimationListener floatingActionButtonAnimationListener) {
        if (floatingActionButtonAnimationListener != null) {
            floatingActionButtonAnimationListener.onAnimationEnd();
        }
    }

    private static void bWv_(Animatable2 animatable2, FloatingActionButtonAnimationListener floatingActionButtonAnimationListener, FloatingActionButtonAnimationListener floatingActionButtonAnimationListener2) {
        if (floatingActionButtonAnimationListener == null) {
            return;
        }
        try {
            animatable2.registerAnimationCallback(new d(floatingActionButtonAnimationListener, floatingActionButtonAnimationListener2, animatable2));
        } catch (NoClassDefFoundError unused) {
            Log.e("FloatingActionButtonAnimationUtils", "It can not find the class Animatable2.");
        }
    }
}
