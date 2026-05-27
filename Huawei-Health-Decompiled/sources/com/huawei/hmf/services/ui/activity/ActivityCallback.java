package com.huawei.hmf.services.ui.activity;

import android.app.Activity;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ActivityCallback<T> {
    private Activity mActivity;

    public abstract void onResult(int i, T t);

    public void onResult(Activity activity, int i, T t) {
        this.mActivity = activity;
        onResult(i, t);
    }

    public <R extends Activity> R getActivity() {
        return (R) this.mActivity;
    }
}
