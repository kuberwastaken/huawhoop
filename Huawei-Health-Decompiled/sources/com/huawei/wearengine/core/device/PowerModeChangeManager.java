package com.huawei.wearengine.core.device;

import com.huawei.wearengine.utils.Singleton;
import defpackage.wro;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public class PowerModeChangeManager {
    private static final Singleton<PowerModeChangeManager> d = new Singleton<PowerModeChangeManager>() { // from class: com.huawei.wearengine.core.device.PowerModeChangeManager.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.huawei.wearengine.utils.Singleton
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public PowerModeChangeManager create() {
            return new PowerModeChangeManager();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f11756a;
    private final AtomicBoolean c;
    private final AtomicBoolean e;

    /* JADX INFO: loaded from: classes11.dex */
    public interface HandlePowerModeChange {
        void startClearData(String str);
    }

    private PowerModeChangeManager() {
        this.e = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.f11756a = Executors.newSingleThreadExecutor();
    }

    public static PowerModeChangeManager d() {
        return d.get();
    }

    public void b() {
        this.e.set(true);
    }

    public boolean e() {
        return this.c.get();
    }

    public boolean e(boolean z) {
        if (!e()) {
            return false;
        }
        wro.a("PowerModeChangeManager", "checkIsPowerModeChanging powerMode in changing");
        if (z) {
            throw new IllegalStateException(String.valueOf(20));
        }
        return true;
    }
}
