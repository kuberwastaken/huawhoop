package defpackage;

import com.huawei.health.sportservice.SportLifecycle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ifw implements SportLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private irs[] f14095a;
    private irs d;
    private List<irs> b = new ArrayList();
    private int c = 0;
    private boolean e = false;

    public void a(irs irsVar) {
        if (irsVar == null) {
            return;
        }
        if (this.e) {
            this.b.clear();
            irs irsVar2 = this.d;
            if (irsVar2 != null) {
                this.f14095a = new irs[]{irsVar2, irsVar};
            }
            this.e = false;
        } else {
            this.f14095a = null;
        }
        this.b.add(irsVar);
        this.d = irsVar;
    }

    @Override // com.huawei.health.sportservice.SportLifecycle
    public void onStartSport() {
        this.c = 1;
    }

    @Override // com.huawei.health.sportservice.SportLifecycle
    public void onResumeSport() {
        if (this.c != 1) {
            this.c = 1;
            this.e = true;
        }
    }

    @Override // com.huawei.health.sportservice.SportLifecycle
    public void onPauseSport() {
        if (this.c != 2) {
            this.c = 2;
            this.e = false;
        }
    }

    public List<irs> b() {
        return this.b;
    }

    public irs[] e() {
        return this.f14095a;
    }

    public String toString() {
        return "TrackDrawGpsData{mBasePointList=" + this.b.size() + ", mLastSportStatus=" + this.c + ", mLastPoint=" + this.d + ", mPauseLine=" + Arrays.toString(this.f14095a) + ", mIsResumeSport=" + this.e + '}';
    }
}
