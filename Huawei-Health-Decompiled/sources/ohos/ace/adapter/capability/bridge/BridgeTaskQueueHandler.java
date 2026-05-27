package ohos.ace.adapter.capability.bridge;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import ohos.ace.adapter.ALog;
import ohos.ace.adapter.capability.bridge.BridgeTaskQueue;

/* JADX INFO: loaded from: classes8.dex */
public class BridgeTaskQueueHandler implements BridgeTaskQueue {
    private static final String LOG_TAG = "BridgeTaskQueueHandler";
    private final ExecutorService executorService_;
    private AtomicBoolean isExecute_ = new AtomicBoolean(false);
    private ConcurrentLinkedQueue<Runnable> queue_ = new ConcurrentLinkedQueue<>();
    private TaskOption taskOption_;
    private BridgeTaskQueue.TaskTag taskTag_;

    public BridgeTaskQueueHandler(ExecutorService executorService, BridgeTaskQueue.TaskTag taskTag, TaskOption taskOption) {
        this.taskTag_ = taskTag;
        this.taskOption_ = taskOption;
        this.executorService_ = executorService;
    }

    @Override // ohos.ace.adapter.capability.bridge.BridgeTaskQueue
    public BridgeTaskQueue.TaskTag getTag() {
        return this.taskTag_;
    }

    @Override // ohos.ace.adapter.capability.bridge.BridgeTaskQueue
    public void dispatch(Runnable runnable) {
        if (this.taskOption_.getTaskOption()) {
            this.queue_.add(runnable);
            this.executorService_.execute(new Runnable() { // from class: ohos.ace.adapter.capability.bridge.BridgeTaskQueueHandler$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1390lambda$dispatch$0$ohosaceadaptercapabilitybridgeBridgeTaskQueueHandler();
                }
            });
        } else {
            this.executorService_.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loopRefresh, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void m1391lambda$loopRefresh$1$ohosaceadaptercapabilitybridgeBridgeTaskQueueHandler() {
        if (this.isExecute_.compareAndSet(false, true)) {
            try {
                Runnable runnablePoll = this.queue_.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            } finally {
                this.isExecute_.set(false);
                if (!this.queue_.isEmpty()) {
                    this.executorService_.execute(new Runnable() { // from class: ohos.ace.adapter.capability.bridge.BridgeTaskQueueHandler$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m1391lambda$loopRefresh$1$ohosaceadaptercapabilitybridgeBridgeTaskQueueHandler();
                        }
                    });
                }
            }
        }
    }

    public void dump() {
        ALog.i(LOG_TAG, "BridgeTaskQueueHandler dump called");
        ALog.i(LOG_TAG, "TaskOption: " + String.valueOf(this.taskOption_.getTaskOption()));
        ALog.i(LOG_TAG, "Queue size: " + String.valueOf(this.queue_.size()));
        for (Runnable runnable : this.queue_) {
            ALog.i(LOG_TAG, "Task type: " + runnable.getClass().getSimpleName());
            ALog.i(LOG_TAG, "Task status: " + runnable.toString());
        }
    }
}
