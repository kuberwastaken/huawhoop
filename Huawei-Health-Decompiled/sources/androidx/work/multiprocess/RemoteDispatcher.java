package androidx.work.multiprocess;

/* JADX INFO: loaded from: classes3.dex */
public interface RemoteDispatcher<T> {
    void execute(T t, IWorkManagerImplCallback iWorkManagerImplCallback) throws Throwable;
}
