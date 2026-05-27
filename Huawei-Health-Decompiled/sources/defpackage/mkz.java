package defpackage;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class mkz extends mku {
    public mkz() {
        super(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), "AccountPicker-global-task-Pool");
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final mkz f15697a = new mkz();
    }

    public static mkz d() {
        return b.f15697a;
    }
}
