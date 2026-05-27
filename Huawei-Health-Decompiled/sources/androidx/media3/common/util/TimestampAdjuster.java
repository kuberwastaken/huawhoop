package androidx.media3.common.util;

import androidx.media3.common.C;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class TimestampAdjuster {
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    public static final long MODE_NO_OFFSET = Long.MAX_VALUE;
    public static final long MODE_SHARED = 9223372036854775806L;
    private long firstSampleTimestampUs;
    private long lastUnadjustedTimestampUs;
    private final ThreadLocal<Long> nextSampleTimestampUs = new ThreadLocal<>();
    private long timestampOffsetUs;

    public TimestampAdjuster(long j) {
        reset(j);
    }

    public void sharedInitializeOrWait(boolean z, long j, long j2) throws InterruptedException, TimeoutException {
        synchronized (this) {
            Assertions.checkState(this.firstSampleTimestampUs == MODE_SHARED);
            if (isInitialized()) {
                return;
            }
            if (z) {
                this.nextSampleTimestampUs.set(Long.valueOf(j));
            } else {
                long jElapsedRealtime = 0;
                long j3 = j2;
                while (!isInitialized()) {
                    if (j2 == 0) {
                        wait();
                    } else {
                        Assertions.checkState(j3 > 0);
                        long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                        wait(j3);
                        jElapsedRealtime += android.os.SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        if (jElapsedRealtime >= j2 && !isInitialized()) {
                            throw new TimeoutException("TimestampAdjuster failed to initialize in " + j2 + " milliseconds");
                        }
                        j3 = j2 - jElapsedRealtime;
                    }
                }
            }
        }
    }

    public long getFirstSampleTimestampUs() {
        long j;
        synchronized (this) {
            j = this.firstSampleTimestampUs;
            if (j == Long.MAX_VALUE || j == MODE_SHARED) {
                j = C.TIME_UNSET;
            }
        }
        return j;
    }

    public long getLastAdjustedTimestampUs() {
        long firstSampleTimestampUs;
        synchronized (this) {
            long j = this.lastUnadjustedTimestampUs;
            if (j != C.TIME_UNSET) {
                firstSampleTimestampUs = j + this.timestampOffsetUs;
            } else {
                firstSampleTimestampUs = getFirstSampleTimestampUs();
            }
        }
        return firstSampleTimestampUs;
    }

    public long getTimestampOffsetUs() {
        long j;
        synchronized (this) {
            j = this.timestampOffsetUs;
        }
        return j;
    }

    public void reset(long j) {
        synchronized (this) {
            this.firstSampleTimestampUs = j;
            this.timestampOffsetUs = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
            this.lastUnadjustedTimestampUs = C.TIME_UNSET;
        }
    }

    public long adjustTsTimestamp(long j) {
        synchronized (this) {
            if (j == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            long j2 = this.lastUnadjustedTimestampUs;
            if (j2 != C.TIME_UNSET) {
                long jUsToNonWrappedPts = usToNonWrappedPts(j2);
                long j3 = (4294967296L + jUsToNonWrappedPts) / MAX_PTS_PLUS_ONE;
                long j4 = ((j3 - 1) * MAX_PTS_PLUS_ONE) + j;
                j += j3 * MAX_PTS_PLUS_ONE;
                if (Math.abs(j4 - jUsToNonWrappedPts) < Math.abs(j - jUsToNonWrappedPts)) {
                    j = j4;
                }
            }
            return adjustSampleTimestamp(ptsToUs(j));
        }
    }

    public long adjustTsTimestampGreaterThanPreviousTimestamp(long j) {
        synchronized (this) {
            if (j == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            long j2 = this.lastUnadjustedTimestampUs;
            if (j2 != C.TIME_UNSET) {
                long jUsToNonWrappedPts = usToNonWrappedPts(j2);
                long j3 = jUsToNonWrappedPts / MAX_PTS_PLUS_ONE;
                long j4 = (j3 * MAX_PTS_PLUS_ONE) + j;
                j += (j3 + 1) * MAX_PTS_PLUS_ONE;
                if (j4 >= jUsToNonWrappedPts) {
                    j = j4;
                }
            }
            return adjustSampleTimestamp(ptsToUs(j));
        }
    }

    public long adjustSampleTimestamp(long j) {
        synchronized (this) {
            if (j == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            if (!isInitialized()) {
                long jLongValue = this.firstSampleTimestampUs;
                if (jLongValue == MODE_SHARED) {
                    jLongValue = ((Long) Assertions.checkNotNull(this.nextSampleTimestampUs.get())).longValue();
                }
                this.timestampOffsetUs = jLongValue - j;
                notifyAll();
            }
            this.lastUnadjustedTimestampUs = j;
            return j + this.timestampOffsetUs;
        }
    }

    public boolean isInitialized() {
        boolean z;
        synchronized (this) {
            z = this.timestampOffsetUs != C.TIME_UNSET;
        }
        return z;
    }

    public static long ptsToUs(long j) {
        return (j * 1000000) / 90000;
    }

    public static long usToWrappedPts(long j) {
        return usToNonWrappedPts(j) % MAX_PTS_PLUS_ONE;
    }

    public static long usToNonWrappedPts(long j) {
        return (j * 90000) / 1000000;
    }
}
