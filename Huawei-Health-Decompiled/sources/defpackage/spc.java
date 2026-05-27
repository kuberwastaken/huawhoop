package defpackage;

import com.huawei.ui.commonui.linechart.icommon.ISupportRangePresentation;
import com.huawei.ui.main.stories.fitness.activity.heartrate.helper.HeartRateDetailData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class spc implements ISupportRangePresentation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<HeartRateDetailData> f17783a;
    private long b;
    private int c;
    private long d;
    private int e;

    public void b(long j, long j2) {
        this.d = j;
        this.b = j2;
    }

    public void a(int i, int i2) {
        this.e = i;
        this.c = i2;
    }

    @Override // com.huawei.ui.commonui.linechart.icommon.ISupportRangePresentation
    public long getStartX() {
        return this.d;
    }

    @Override // com.huawei.ui.commonui.linechart.icommon.ISupportRangePresentation
    public long getEndX() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int b() {
        return this.e;
    }

    public ArrayList<HeartRateDetailData> e() {
        return this.f17783a;
    }

    public void b(ArrayList<HeartRateDetailData> arrayList) {
        this.f17783a = arrayList;
    }
}
