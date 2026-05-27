package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class jpx extends jpv {
    public jpx() {
        this(0, null, 0L, 0L);
    }

    public jpx(int i, long j, long j2) {
        setType(i);
        setStartTime(j);
        setEndTime(j2);
    }

    public jpx(int i, String str, long j, long j2) {
        setType(i);
        setStartTime(j);
        setEndTime(j2);
        setMetaData(str);
    }
}
