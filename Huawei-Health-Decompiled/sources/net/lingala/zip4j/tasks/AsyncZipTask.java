package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AsyncZipTask<T> {
    private final ExecutorService executorService;
    private final ProgressMonitor progressMonitor;
    private final boolean runInThread;

    protected abstract long calculateTotalWork(T t) throws ZipException;

    protected abstract void executeTask(T t, ProgressMonitor progressMonitor) throws IOException;

    protected abstract ProgressMonitor.Task getTask();

    public AsyncZipTask(b bVar) {
        this.progressMonitor = bVar.e;
        this.runInThread = bVar.c;
        this.executorService = bVar.b;
    }

    public void execute(final T t) throws ZipException {
        if (this.runInThread && ProgressMonitor.State.BUSY.equals(this.progressMonitor.d())) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        initProgressMonitor();
        if (this.runInThread) {
            this.progressMonitor.b(calculateTotalWork(t));
            this.executorService.execute(new Runnable() { // from class: net.lingala.zip4j.tasks.AsyncZipTask.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncZipTask asyncZipTask = AsyncZipTask.this;
                        asyncZipTask.performTaskWithErrorHandling(t, asyncZipTask.progressMonitor);
                    } catch (ZipException unused) {
                    } catch (Throwable th) {
                        AsyncZipTask.this.executorService.shutdown();
                        throw th;
                    }
                    AsyncZipTask.this.executorService.shutdown();
                }
            });
            return;
        }
        performTaskWithErrorHandling(t, this.progressMonitor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performTaskWithErrorHandling(T t, ProgressMonitor progressMonitor) throws ZipException {
        try {
            executeTask(t, progressMonitor);
            progressMonitor.c();
        } catch (ZipException e) {
            progressMonitor.d(e);
            throw e;
        } catch (Exception e2) {
            progressMonitor.d(e2);
            throw new ZipException(e2);
        }
    }

    protected void verifyIfTaskIsCancelled() throws ZipException {
        if (this.progressMonitor.a()) {
            this.progressMonitor.e(ProgressMonitor.Result.CANCELLED);
            this.progressMonitor.d(ProgressMonitor.State.READY);
            throw new ZipException("Task cancelled", ZipException.Type.TASK_CANCELLED_EXCEPTION);
        }
    }

    private void initProgressMonitor() {
        this.progressMonitor.e();
        this.progressMonitor.d(ProgressMonitor.State.BUSY);
        this.progressMonitor.e(getTask());
    }

    public static class b {
        private final ExecutorService b;
        private final boolean c;
        private final ProgressMonitor e;

        public b(ExecutorService executorService, boolean z, ProgressMonitor progressMonitor) {
            this.b = executorService;
            this.c = z;
            this.e = progressMonitor;
        }
    }
}
