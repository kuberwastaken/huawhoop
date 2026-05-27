package androidx.media3.exoplayer.source.preload;

/* JADX INFO: loaded from: classes9.dex */
public interface TargetPreloadStatusControl<T> {

    public interface PreloadStatus {
        int getStage();

        long getValue();
    }

    PreloadStatus getTargetPreloadStatus(T t);
}
