package com.huawei.hmf.orb.aidl.client;

import android.os.Looper;
import com.huawei.hmf.orb.aidl.client.Result;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public abstract class PendingResult<R extends Result> {
    public abstract R await();

    public abstract R await(long j, TimeUnit timeUnit);

    public abstract void setResultCallback(Looper looper, ResultCallback<R> resultCallback);

    public abstract void setResultCallback(ResultCallback<R> resultCallback);
}
