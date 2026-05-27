package ohos.ace.adapter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes8.dex */
public class ExecutorServiceInstance {
    private static volatile ExecutorServiceInstance INSTANCE;
    private static final Object INSTANCE_LOCK = new Object();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    private ExecutorServiceInstance() {
    }

    public static ExecutorServiceInstance getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (INSTANCE_LOCK) {
            if (INSTANCE != null) {
                return INSTANCE;
            }
            INSTANCE = new ExecutorServiceInstance();
            return INSTANCE;
        }
    }

    public ExecutorService getExecutorService() {
        return this.executor;
    }
}
