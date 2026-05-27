package androidx.media3.effect;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
final class VideoFrameProcessingTaskExecutor {
    private static final long EXECUTOR_SERVICE_TIMEOUT_MS = 500;
    private final ErrorListener errorListener;
    private boolean shouldCancelTasks;
    private final boolean shouldShutdownExecutorService;
    private final ExecutorService singleThreadExecutorService;
    private final Future<Thread> threadFuture;
    private final Object lock = new Object();
    private final Queue<Task> highPriorityTasks = new ArrayDeque();

    interface ErrorListener {
        void onError(VideoFrameProcessingException videoFrameProcessingException);
    }

    interface Task {
        void run() throws VideoFrameProcessingException, GlUtil.GlException;
    }

    static /* synthetic */ void lambda$submitWithHighPriority$1() throws VideoFrameProcessingException, GlUtil.GlException {
    }

    public VideoFrameProcessingTaskExecutor(ExecutorService executorService, boolean z, ErrorListener errorListener) {
        this.singleThreadExecutorService = executorService;
        this.threadFuture = executorService.submit(new Callable() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Thread.currentThread();
            }
        });
        this.shouldShutdownExecutorService = z;
        this.errorListener = errorListener;
    }

    public void submit(Task task) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks) {
                return;
            }
            try {
                wrapTaskAndSubmitToExecutorService(task, false);
                e = null;
            } catch (RejectedExecutionException e) {
                e = e;
            }
            if (e != null) {
                handleException(e);
            }
        }
    }

    public void invoke(final Task task) throws InterruptedException {
        try {
            if (Thread.currentThread() == this.threadFuture.get(500L, TimeUnit.MILLISECONDS)) {
                try {
                    task.run();
                    return;
                } catch (Exception e) {
                    handleException(e);
                    return;
                }
            }
            try {
                this.singleThreadExecutorService.submit(new Runnable() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m122lambda$invoke$0$androidxmedia3effectVideoFrameProcessingTaskExecutor(task);
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
            } catch (RuntimeException | ExecutionException | TimeoutException e2) {
                handleException(e2);
            }
        } catch (InterruptedException e3) {
            throw e3;
        } catch (Exception e4) {
            handleException(e4);
        }
    }

    /* JADX INFO: renamed from: lambda$invoke$0$androidx-media3-effect-VideoFrameProcessingTaskExecutor, reason: not valid java name */
    /* synthetic */ void m122lambda$invoke$0$androidxmedia3effectVideoFrameProcessingTaskExecutor(Task task) {
        try {
            task.run();
        } catch (Exception e) {
            handleException(e);
        }
    }

    public void submitWithHighPriority(Task task) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks) {
                return;
            }
            this.highPriorityTasks.add(task);
            submit(new Task() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda1
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    VideoFrameProcessingTaskExecutor.lambda$submitWithHighPriority$1();
                }
            });
        }
    }

    public void flush() throws InterruptedException {
        synchronized (this.lock) {
            this.shouldCancelTasks = true;
            this.highPriorityTasks.clear();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        wrapTaskAndSubmitToExecutorService(new Task() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m121lambda$flush$2$androidxmedia3effectVideoFrameProcessingTaskExecutor(countDownLatch);
            }
        }, true);
        countDownLatch.await();
    }

    /* JADX INFO: renamed from: lambda$flush$2$androidx-media3-effect-VideoFrameProcessingTaskExecutor, reason: not valid java name */
    /* synthetic */ void m121lambda$flush$2$androidxmedia3effectVideoFrameProcessingTaskExecutor(CountDownLatch countDownLatch) throws VideoFrameProcessingException, GlUtil.GlException {
        synchronized (this.lock) {
            this.shouldCancelTasks = false;
        }
        countDownLatch.countDown();
    }

    public void release(Task task) throws InterruptedException {
        synchronized (this.lock) {
            this.shouldCancelTasks = true;
            this.highPriorityTasks.clear();
        }
        wrapTaskAndSubmitToExecutorService(task, true);
        if (this.shouldShutdownExecutorService) {
            this.singleThreadExecutorService.shutdown();
            if (this.singleThreadExecutorService.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
                return;
            }
            this.errorListener.onError(new VideoFrameProcessingException("Release timed out. OpenGL resources may not be cleaned up properly."));
        }
    }

    private Future<?> wrapTaskAndSubmitToExecutorService(final Task task, final boolean z) {
        return this.singleThreadExecutorService.submit(new Runnable() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m123lambda$wrapTaskAndSubmitToExecutorService$3$androidxmedia3effectVideoFrameProcessingTaskExecutor(z, task);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$wrapTaskAndSubmitToExecutorService$3$androidx-media3-effect-VideoFrameProcessingTaskExecutor, reason: not valid java name */
    /* synthetic */ void m123lambda$wrapTaskAndSubmitToExecutorService$3$androidxmedia3effectVideoFrameProcessingTaskExecutor(boolean z, Task task) {
        Task taskPoll;
        try {
            synchronized (this.lock) {
                if (this.shouldCancelTasks && !z) {
                    return;
                }
                while (true) {
                    synchronized (this.lock) {
                        taskPoll = this.highPriorityTasks.poll();
                    }
                    if (taskPoll != null) {
                        taskPoll.run();
                    } else {
                        task.run();
                        return;
                    }
                }
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleException(Exception exc) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks) {
                return;
            }
            this.shouldCancelTasks = true;
            this.errorListener.onError(VideoFrameProcessingException.from(exc));
        }
    }
}
