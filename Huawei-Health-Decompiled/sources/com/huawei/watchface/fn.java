package com.huawei.watchface;

import android.os.Handler;
import android.os.Looper;
import com.huawei.watchface.utils.HwLog;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public abstract class fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f11542a = new HashSet();
    private Looper b = Looper.getMainLooper();

    public abstract void a();

    public abstract void a(String str);

    public boolean b(String str) {
        synchronized (this) {
            HwLog.d("PermissionsResultAction", "Permission not found: " + str);
        }
        return true;
    }

    protected final boolean a(String str, int i) {
        synchronized (this) {
            if (i == 0) {
                return a(str, fl.GRANTED);
            }
            return a(str, fl.DENIED);
        }
    }

    protected final boolean a(String str, fl flVar) {
        synchronized (this) {
            this.f11542a.remove(str);
            if (flVar == fl.GRANTED) {
                return b();
            }
            if (flVar == fl.DENIED) {
                return c(str);
            }
            if (flVar != fl.NOT_FOUND) {
                return false;
            }
            if (b(str)) {
                return b();
            }
            return c(str);
        }
    }

    private boolean b() {
        if (!this.f11542a.isEmpty()) {
            return false;
        }
        new Handler(this.b).post(new Runnable() { // from class: com.huawei.watchface.fn.1
            @Override // java.lang.Runnable
            public void run() {
                fn.this.a();
            }
        });
        return true;
    }

    private boolean c(final String str) {
        new Handler(this.b).post(new Runnable() { // from class: com.huawei.watchface.fn.2
            @Override // java.lang.Runnable
            public void run() {
                fn.this.a(str);
            }
        });
        return true;
    }
}
