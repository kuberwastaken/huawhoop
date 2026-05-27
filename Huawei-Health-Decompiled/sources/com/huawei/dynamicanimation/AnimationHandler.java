package com.huawei.dynamicanimation;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class AnimationHandler {
    public static final ThreadLocal<AnimationHandler> c = new ThreadLocal<>();
    private AnimationFrameCallbackProvider h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<AnimationFrameCallback, Long> f2003a = new HashMap<>();
    private final ArrayList<AnimationFrameCallback> b = new ArrayList<>();
    private final c e = new c();
    private long d = 0;
    private boolean g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long j);
    }

    AnimationHandler() {
    }

    class c {
        c() {
        }

        void e() {
            AnimationHandler.this.d = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.c(animationHandler.d);
            if (AnimationHandler.this.b.size() > 0) {
                AnimationHandler.this.b().postFrameCallback();
            }
        }
    }

    public static AnimationHandler d() {
        ThreadLocal<AnimationHandler> threadLocal = c;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        return threadLocal.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationFrameCallbackProvider b() {
        if (this.h == null) {
            this.h = new e(this.e);
        }
        return this.h;
    }

    public void d(AnimationFrameCallback animationFrameCallback, long j) {
        if (this.b.size() == 0) {
            b().postFrameCallback();
        }
        if (!this.b.contains(animationFrameCallback)) {
            this.b.add(animationFrameCallback);
        }
        if (j > 0) {
            this.f2003a.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void e(AnimationFrameCallback animationFrameCallback) {
        this.f2003a.remove(animationFrameCallback);
        int iIndexOf = this.b.indexOf(animationFrameCallback);
        if (iIndexOf >= 0) {
            this.b.set(iIndexOf, null);
            this.g = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.b.size(); i++) {
            AnimationFrameCallback animationFrameCallback = this.b.get(i);
            if (animationFrameCallback != null && e(animationFrameCallback, jUptimeMillis)) {
                animationFrameCallback.doAnimationFrame(j);
            }
        }
        c();
    }

    private boolean e(AnimationFrameCallback animationFrameCallback, long j) {
        if (this.f2003a.get(animationFrameCallback) == null) {
            return true;
        }
        if (this.f2003a.get(animationFrameCallback).longValue() >= j) {
            return false;
        }
        this.f2003a.remove(animationFrameCallback);
        return true;
    }

    private void c() {
        if (this.g) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                if (this.b.get(size) == null) {
                    this.b.remove(size);
                }
            }
            this.g = false;
        }
    }

    static class e extends AnimationFrameCallbackProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Choreographer f2004a;
        private final Choreographer.FrameCallback e;

        e(c cVar) {
            super(cVar);
            this.f2004a = Choreographer.getInstance();
            this.e = new Choreographer.FrameCallback() { // from class: com.huawei.dynamicanimation.AnimationHandler.e.4
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    e.this.mDispatcher.e();
                }
            };
        }

        @Override // com.huawei.dynamicanimation.AnimationHandler.AnimationFrameCallbackProvider
        void postFrameCallback() {
            this.f2004a.postFrameCallback(this.e);
        }
    }

    static abstract class AnimationFrameCallbackProvider {
        final c mDispatcher;

        abstract void postFrameCallback();

        AnimationFrameCallbackProvider(c cVar) {
            this.mDispatcher = cVar;
        }
    }
}
