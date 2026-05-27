package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class dsy extends dsx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12412a = -1;
    private int b = -1;
    private byte[] e = null;

    public long c() {
        return this.f12412a;
    }

    public void e(long j) {
        this.f12412a = j;
    }

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public byte[] e() {
        return this.e;
    }

    public void a(byte[] bArr) {
        this.e = bArr;
    }

    @Override // defpackage.dsx
    public String toString() {
        return "SampleEvent{mSrcPkgName=" + getSrcPkgName() + ", mWearPkgName=" + getWearPkgName() + ", mCommandId=" + getCommandId() + ", mEventId=" + this.f12412a + ", mEventLevel=" + this.b + ", mEventData=" + chk.e(chj.b(this.e)) + '}';
    }
}
