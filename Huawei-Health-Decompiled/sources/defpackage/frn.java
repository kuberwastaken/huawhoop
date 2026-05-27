package defpackage;

import com.huawei.basefitnessadvice.model.intplan.PlanTimeInfo;
import com.huawei.health.plan.model.intplan.PlanTimeInfoBean;

/* JADX INFO: loaded from: classes4.dex */
public class frn implements PlanTimeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f13113a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long j;

    @Override // com.huawei.basefitnessadvice.model.intplan.PlanTimeInfo
    public long getCreateTime() {
        return this.d;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.PlanTimeInfo
    public long getFinishTime() {
        return this.b;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.PlanTimeInfo
    public long getModifyTime() {
        return this.f13113a;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.PlanTimeInfo
    public long getRemindTime() {
        return this.f;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.PlanTimeInfo
    public long getBeginDate() {
        return this.e;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.PlanTimeInfo
    public long getEndDate() {
        return this.c;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.PlanTimeInfo
    public long getReportTime() {
        return this.j;
    }

    public void e(long j) {
        this.d = j;
    }

    public void b(long j) {
        this.f13113a = j;
    }

    public void c(long j) {
        this.f = j;
    }

    public void d(long j) {
        this.e = j;
    }

    public void a(long j) {
        this.c = j;
    }

    public void f(long j) {
        this.j = j;
    }

    public frn b(PlanTimeInfoBean planTimeInfoBean) {
        if (planTimeInfoBean != null) {
            d(planTimeInfoBean.getBeginDate());
            e(planTimeInfoBean.getCreateTime());
            a(planTimeInfoBean.getEndDate());
            c(planTimeInfoBean.getRemindTime());
            f(planTimeInfoBean.getReportTime());
        }
        return this;
    }
}
