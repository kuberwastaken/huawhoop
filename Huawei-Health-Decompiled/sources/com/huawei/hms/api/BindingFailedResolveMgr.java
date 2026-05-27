package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class BindingFailedResolveMgr {
    static final BindingFailedResolveMgr b = new BindingFailedResolveMgr();
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<Activity> f4590a = new ArrayList(1);

    BindingFailedResolveMgr() {
    }

    void a(Activity activity) {
        synchronized (c) {
            for (Activity activity2 : this.f4590a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f4590a.add(activity);
        }
    }

    void b(Activity activity) {
        synchronized (c) {
            this.f4590a.remove(activity);
        }
    }
}
