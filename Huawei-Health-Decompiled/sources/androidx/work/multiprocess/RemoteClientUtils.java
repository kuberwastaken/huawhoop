package androidx.work.multiprocess;

import androidx.arch.core.util.Function;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class RemoteClientUtils {
    public static final Function<byte[], Void> sVoidMapper = new Function<byte[], Void>() { // from class: androidx.work.multiprocess.RemoteClientUtils.1
        @Override // androidx.arch.core.util.Function
        public Void apply(byte[] bArr) {
            return null;
        }
    };

    private RemoteClientUtils() {
    }

    public static <I, O> ListenableFuture<O> map(final ListenableFuture<I> listenableFuture, final Function<I, O> function, Executor executor) {
        final SettableFuture settableFutureCreate = SettableFuture.create();
        listenableFuture.addListener(new Runnable() { // from class: androidx.work.multiprocess.RemoteClientUtils.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    settableFutureCreate.set(function.apply(listenableFuture.get()));
                } catch (Throwable th) {
                    th = th;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    settableFutureCreate.setException(th);
                }
            }
        }, executor);
        return settableFutureCreate;
    }
}
