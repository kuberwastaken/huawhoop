package com.huawei.animationkit.computationalwallpaper.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import defpackage.awb;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AsyncExecutor<T, R> {
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    protected abstract void finishOnUiThread(R r, awb awbVar);

    protected abstract R runInBackground(T t) throws awb;

    public void execute(T t) {
        this.mExecutorService.submit(new b(t));
    }

    class b implements Runnable {
        private final T e;

        private b(T t) {
            this.e = t;
        }

        @Override // java.lang.Runnable
        public void run() throws awb {
            Object objRunInBackground = null;
            try {
                e = null;
                objRunInBackground = AsyncExecutor.this.runInBackground(this.e);
            } catch (awb e) {
                e = e;
                Log.e("ExecuteRunnable", "run generate task failed");
            }
            AsyncExecutor.this.mHandler.post(new a(objRunInBackground, e));
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final awb f1889a;
        private final R b;

        public a(R r, awb awbVar) {
            this.b = r;
            this.f1889a = awbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncExecutor.this.finishOnUiThread(this.b, this.f1889a);
        }
    }
}
