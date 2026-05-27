package com.huawei.hwcommonmodel.utils;

import com.huawei.hwlogsmodel.LogUtil;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleChain {
    private Emitter b;
    private final String d;
    private volatile boolean e;
    private final LinkedList<INext> c = new LinkedList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f6463a = new AtomicBoolean(false);

    public interface INext {
        void onNext(Emitter emitter, Object... objArr);
    }

    private SimpleChain(String str) {
        this.d = "SimpleChain_" + str;
    }

    public static SimpleChain e(String str) {
        return new SimpleChain(str);
    }

    public SimpleChain c(INext iNext) {
        if (this.f6463a.get()) {
            throw new IllegalStateException("SimpleChain isSubscribed, next");
        }
        this.c.add(iNext);
        return this;
    }

    public void d(Emitter emitter, Object... objArr) {
        if (this.f6463a.getAndSet(true)) {
            throw new IllegalStateException("SimpleChain isSubscribed, subscribe");
        }
        LogUtil.b(this.d, "subscribe start");
        this.b = emitter;
        c(objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object... objArr) {
        if (this.e) {
            LogUtil.j(this.d, "doNext isDisposed");
        } else if (this.c.isEmpty()) {
            this.b.onSuccess(objArr);
        } else {
            this.c.removeFirst().onNext(new b(), objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (this.e) {
            LogUtil.j(this.d, "doError isDisposed");
        } else {
            this.b.onError(str);
        }
    }

    class b implements Emitter {
        private final AtomicBoolean b = new AtomicBoolean(false);

        b() {
        }

        @Override // com.huawei.hwcommonmodel.utils.SimpleChain.Emitter
        public void onSuccess(Object... objArr) {
            if (this.b.getAndSet(true)) {
                LogUtil.j(SimpleChain.this.d, "doNext isDone onSuccess");
            } else {
                SimpleChain.this.c(objArr);
            }
        }

        @Override // com.huawei.hwcommonmodel.utils.SimpleChain.Emitter
        public void onError(String str) {
            if (this.b.getAndSet(true)) {
                LogUtil.j(SimpleChain.this.d, "doNext isDone onError");
            } else {
                SimpleChain.this.d(str);
            }
        }
    }

    public interface Emitter {
        void onSuccess(Object... objArr);

        default void onError(String str) {
            LogUtil.j("SimpleChain_Emitter", "onError: ", str);
        }
    }
}
