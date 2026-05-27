package androidx.media3.effect;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DefaultVideoCompositor$$ExternalSyntheticLambda1 implements VideoFrameProcessingTaskExecutor.Task {
    public final /* synthetic */ DefaultVideoCompositor f$0;

    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
    public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
        this.f$0.maybeComposite();
    }

    public /* synthetic */ DefaultVideoCompositor$$ExternalSyntheticLambda1(DefaultVideoCompositor defaultVideoCompositor) {
        this.f$0 = defaultVideoCompositor;
    }
}
