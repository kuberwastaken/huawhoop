package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.huawei.hianalytics.visual.autocollect.instrument.FragmentInstrumentation;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes10.dex */
public class g extends Fragment {
    public static final WeakHashMap<Activity, WeakReference<g>> b = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<WeakReference<ExecuteResult<?>>> f4412a = new ArrayList();

    public static void a(Activity activity, ExecuteResult executeResult) {
        g gVar;
        g gVar2;
        g gVar3;
        WeakReference<g> weakReference = b.get(activity);
        if (weakReference == null || weakReference.get() == null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            g gVar4 = null;
            try {
                gVar = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
                if (gVar == null) {
                    try {
                        gVar3 = new g();
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        fragmentManager.beginTransaction().add(gVar3, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                        gVar4 = gVar3;
                    } catch (Exception e2) {
                        e = e2;
                        gVar4 = gVar3;
                        try {
                            Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
                        } catch (ClassCastException e3) {
                            e = e3;
                            Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                            gVar2 = gVar;
                        }
                    }
                } else {
                    gVar4 = gVar;
                }
                b.put(activity, new WeakReference<>(gVar4));
                gVar2 = gVar4;
            } catch (ClassCastException e4) {
                e = e4;
                gVar = gVar4;
            }
        } else {
            gVar2 = weakReference.get();
        }
        if (gVar2 != null) {
            gVar2.a(executeResult);
        }
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        FragmentInstrumentation.setUserVisibleHintByFragment(this, z);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentInstrumentation.onViewCreatedByFragment(this, view, bundle);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        synchronized (this.f4412a) {
            Iterator<WeakReference<ExecuteResult<?>>> it = this.f4412a.iterator();
            while (it.hasNext()) {
                ExecuteResult<?> executeResult = it.next().get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f4412a.clear();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentInstrumentation.onResumeByFragment(this);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentInstrumentation.onPauseByFragment(this);
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        FragmentInstrumentation.onHiddenChangedByFragment(this, z);
    }

    public final void a(ExecuteResult executeResult) {
        synchronized (this.f4412a) {
            this.f4412a.add(new WeakReference<>(executeResult));
        }
    }
}
