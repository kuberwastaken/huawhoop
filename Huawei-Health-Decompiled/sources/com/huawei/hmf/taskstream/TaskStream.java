package com.huawei.hmf.taskstream;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes10.dex */
public interface TaskStream<TResult> {
    Disposable subscribe(Consumer<TResult> consumer);

    Disposable subscribe(Consumer<TResult> consumer, Consumer<? super Exception> consumer2);

    void subscribe(Observer<TResult> observer);

    void subscribe(Executor executor, Observer<TResult> observer);
}
