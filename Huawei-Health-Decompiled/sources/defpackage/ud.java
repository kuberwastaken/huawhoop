package defpackage;

import com.huawei.hms.network.embedded.g4;
import com.huawei.watchface.utils.constants.WatchFaceConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/braintreepayments/api/HttpResponseTiming;", "", "startTime", "", "endTime", "(JJ)V", "getEndTime", "()J", "setEndTime", "(J)V", "getStartTime", "setStartTime", "component1", "component2", "copy", "equals", "", "other", WatchFaceConstant.HASHCODE, "", "toString", "", "SharedUtils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class ud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f18267a;
    private long c;

    public ud(long j, long j2) {
        this.c = j;
        this.f18267a = j2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getC() {
        return this.c;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final long getF18267a() {
        return this.f18267a;
    }

    public String toString() {
        return "HttpResponseTiming(startTime=" + this.c + ", endTime=" + this.f18267a + g4.l;
    }

    public int hashCode() {
        return (Long.hashCode(this.c) * 31) + Long.hashCode(this.f18267a);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ud)) {
            return false;
        }
        ud udVar = (ud) other;
        return this.c == udVar.c && this.f18267a == udVar.f18267a;
    }
}
