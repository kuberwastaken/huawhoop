package androidx.media3.transformer;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
public interface SampleConsumer {
    public static final int INPUT_RESULT_END_OF_STREAM = 3;
    public static final int INPUT_RESULT_SUCCESS = 1;
    public static final int INPUT_RESULT_TRY_AGAIN_LATER = 2;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputResult {
    }

    default DecoderInputBuffer getInputBuffer() {
        throw new UnsupportedOperationException();
    }

    default boolean queueInputBuffer() {
        throw new UnsupportedOperationException();
    }

    default int queueInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
        throw new UnsupportedOperationException();
    }

    default void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        throw new UnsupportedOperationException();
    }

    default int queueInputTexture(int i, long j) {
        throw new UnsupportedOperationException();
    }

    default Surface getInputSurface() {
        throw new UnsupportedOperationException();
    }

    default int getPendingVideoFrameCount() {
        throw new UnsupportedOperationException();
    }

    default boolean registerVideoFrame(long j) {
        throw new UnsupportedOperationException();
    }

    default void signalEndOfVideoInput() {
        throw new UnsupportedOperationException();
    }
}
