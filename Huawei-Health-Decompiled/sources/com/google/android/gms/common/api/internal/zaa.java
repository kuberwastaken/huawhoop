package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C0035zaa> zacl;

    public zaa(Activity activity) {
        this(C0035zaa.zaa(activity));
    }

    private zaa(C0035zaa c0035zaa) {
        this.zacl = new WeakReference<>(c0035zaa);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0035zaa c0035zaa = this.zacl.get();
        if (c0035zaa == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        c0035zaa.zaa(runnable);
        return this;
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.zaa$zaa, reason: collision with other inner class name */
    static class C0035zaa extends LifecycleCallback {
        private List<Runnable> zacm;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0035zaa zaa(Activity activity) {
            C0035zaa c0035zaa;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                c0035zaa = (C0035zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0035zaa.class);
                if (c0035zaa == null) {
                    c0035zaa = new C0035zaa(fragment);
                }
            }
            return c0035zaa;
        }

        private C0035zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.zacm = new ArrayList();
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zaa(Runnable runnable) {
            synchronized (this) {
                this.zacm.add(runnable);
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zacm;
                this.zacm = new ArrayList();
            }
            Iterator<Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }
}
