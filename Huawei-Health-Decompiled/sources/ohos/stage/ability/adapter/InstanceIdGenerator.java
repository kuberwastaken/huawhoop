package ohos.stage.ability.adapter;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes8.dex */
public final class InstanceIdGenerator {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    public static int getAndIncrement() {
        return ID_GENERATOR.getAndIncrement();
    }

    public static int get() {
        return ID_GENERATOR.get();
    }
}
