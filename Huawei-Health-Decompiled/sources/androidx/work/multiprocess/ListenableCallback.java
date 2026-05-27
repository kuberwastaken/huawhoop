package androidx.work.multiprocess;

import android.os.RemoteException;
import androidx.work.Logger;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ListenableCallback<I> {
    final IWorkManagerImplCallback mCallback;
    final Executor mExecutor;
    final ListenableFuture<I> mFuture;

    public abstract byte[] toByteArray(I i);

    public ListenableCallback(Executor executor, IWorkManagerImplCallback iWorkManagerImplCallback, ListenableFuture<I> listenableFuture) {
        this.mExecutor = executor;
        this.mCallback = iWorkManagerImplCallback;
        this.mFuture = listenableFuture;
    }

    public void dispatchCallbackSafely() {
        this.mFuture.addListener(new ListenableCallbackRunnable(this), this.mExecutor);
    }

    public static class ListenableCallbackRunnable<I> implements Runnable {
        private static final String TAG = Logger.tagWithPrefix("ListenableCallbackRbl");
        private final ListenableCallback<I> mCallback;

        public ListenableCallbackRunnable(ListenableCallback<I> listenableCallback) {
            this.mCallback = listenableCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                reportSuccess(this.mCallback.mCallback, this.mCallback.toByteArray(this.mCallback.mFuture.get()));
            } catch (Throwable th) {
                reportFailure(this.mCallback.mCallback, th);
            }
        }

        public static void reportSuccess(IWorkManagerImplCallback iWorkManagerImplCallback, byte[] bArr) {
            try {
                iWorkManagerImplCallback.onSuccess(bArr);
            } catch (RemoteException e) {
                Logger.get().error(TAG, "Unable to notify successful operation", e);
            }
        }

        public static void reportFailure(IWorkManagerImplCallback iWorkManagerImplCallback, Throwable th) {
            try {
                iWorkManagerImplCallback.onFailure(th.getMessage());
            } catch (RemoteException e) {
                Logger.get().error(TAG, "Unable to notify failures in operation", e);
            }
        }
    }
}
