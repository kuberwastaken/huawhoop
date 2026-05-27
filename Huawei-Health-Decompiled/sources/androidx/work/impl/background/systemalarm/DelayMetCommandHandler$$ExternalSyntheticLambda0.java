package androidx.work.impl.background.systemalarm;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class DelayMetCommandHandler$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DelayMetCommandHandler f$0;

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.stopWork();
    }

    public /* synthetic */ DelayMetCommandHandler$$ExternalSyntheticLambda0(DelayMetCommandHandler delayMetCommandHandler) {
        this.f$0 = delayMetCommandHandler;
    }
}
