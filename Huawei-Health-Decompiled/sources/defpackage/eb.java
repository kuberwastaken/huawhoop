package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.LottieListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes3.dex */
public class eb<T> {
    public static Executor e = Executors.newCachedThreadPool(new je());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ee<T> f12519a;
    private final Set<LottieListener<T>> b;
    private final Set<LottieListener<Throwable>> c;
    private final Handler d;

    public eb(Callable<ee<T>> callable) {
        this(callable, false);
    }

    public eb(T t) {
        this.b = new LinkedHashSet(1);
        this.c = new LinkedHashSet(1);
        this.d = new Handler(Looper.getMainLooper());
        this.f12519a = null;
        d(new ee<>(t));
    }

    public eb(Callable<ee<T>> callable, boolean z) {
        this.b = new LinkedHashSet(1);
        this.c = new LinkedHashSet(1);
        this.d = new Handler(Looper.getMainLooper());
        this.f12519a = null;
        if (z) {
            try {
                d(callable.call());
                return;
            } catch (Throwable th) {
                d(new ee<>(th));
                return;
            }
        }
        e.execute(new e(this, callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ee<T> eeVar) {
        if (this.f12519a != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f12519a = eeVar;
        c();
    }

    public eb<T> d(LottieListener<T> lottieListener) {
        synchronized (this) {
            ee<T> eeVar = this.f12519a;
            if (eeVar != null && eeVar.a() != null) {
                lottieListener.onResult(eeVar.a());
            }
            this.b.add(lottieListener);
        }
        return this;
    }

    public eb<T> b(LottieListener<T> lottieListener) {
        synchronized (this) {
            this.b.remove(lottieListener);
        }
        return this;
    }

    public eb<T> a(LottieListener<Throwable> lottieListener) {
        synchronized (this) {
            ee<T> eeVar = this.f12519a;
            if (eeVar != null && eeVar.e() != null) {
                lottieListener.onResult(eeVar.e());
            }
            this.c.add(lottieListener);
        }
        return this;
    }

    public eb<T> e(LottieListener<Throwable> lottieListener) {
        synchronized (this) {
            this.c.remove(lottieListener);
        }
        return this;
    }

    public ee<T> b() {
        return this.f12519a;
    }

    private void c() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            e();
        } else {
            this.d.post(new Runnable() { // from class: eh
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12591a.e();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ee<T> eeVar = this.f12519a;
        if (eeVar == null) {
            return;
        }
        if (eeVar.a() != null) {
            c(eeVar.a());
        } else {
            e(eeVar.e());
        }
    }

    private void c(T t) {
        synchronized (this) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((LottieListener) it.next()).onResult(t);
            }
        }
    }

    private void e(Throwable th) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList(this.c);
            if (arrayList.isEmpty()) {
                iy.e("Lottie encountered an error but no failure listener was added:", th);
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((LottieListener) it.next()).onResult(th);
            }
        }
    }

    static class e<T> extends FutureTask<ee<T>> {
        private eb<T> c;

        e(eb<T> ebVar, Callable<ee<T>> callable) {
            super(callable);
            this.c = ebVar;
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                if (isCancelled()) {
                    return;
                }
                try {
                    this.c.d(get());
                } catch (InterruptedException | ExecutionException e) {
                    this.c.d(new ee(e));
                }
            } finally {
                this.c = null;
            }
        }
    }
}
