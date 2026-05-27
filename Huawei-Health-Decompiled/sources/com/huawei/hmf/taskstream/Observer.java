package com.huawei.hmf.taskstream;

/* JADX INFO: loaded from: classes10.dex */
public interface Observer<TResult> {
    void onComplete();

    void onFailure(Exception exc);

    void onNext(TResult tresult);

    void onSubscribe(Disposable disposable);
}
