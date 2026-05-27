package defpackage;

import com.huawei.hwcommonmodel.fitnessdatatype.DataTotalMotion;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetect;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class kwc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14954a;
    private List<DataTotalMotion> c = new ArrayList(16);
    private HeartRateDetect e = new HeartRateDetect();

    public int e() {
        return this.f14954a;
    }

    public void a(int i) {
        this.f14954a = i;
    }

    public List<DataTotalMotion> a() {
        return this.c;
    }

    public void b(HeartRateDetect heartRateDetect) {
        this.e = heartRateDetect;
    }
}
