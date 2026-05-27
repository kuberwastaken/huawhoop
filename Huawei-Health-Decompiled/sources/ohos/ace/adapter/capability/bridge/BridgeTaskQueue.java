package ohos.ace.adapter.capability.bridge;

/* JADX INFO: loaded from: classes8.dex */
public interface BridgeTaskQueue {

    /* JADX INFO: loaded from: classes11.dex */
    public enum TaskTag {
        INPUT,
        OUTPUT
    }

    void dispatch(Runnable runnable);

    TaskTag getTag();
}
