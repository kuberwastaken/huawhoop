package com.huawei.hmf.taskstream.impl;

import com.huawei.hmf.taskstream.ExecuteResult;
import com.huawei.hmf.taskstream.Observer;

/* JADX INFO: loaded from: classes10.dex */
public class NextExecuteResult<TResult> implements ExecuteResult {
    private TResult result;

    NextExecuteResult(TResult tresult) {
        this.result = tresult;
    }

    @Override // com.huawei.hmf.taskstream.ExecuteResult
    public final void onComplete(Observer observer) {
        if (observer != null) {
            observer.onNext(this.result);
        }
    }
}
