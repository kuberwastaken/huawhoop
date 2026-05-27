package defpackage;

import com.huawei.basefitnessadvice.model.intplan.Goal;
import com.huawei.health.plan.model.intplan.GoalBean;

/* JADX INFO: loaded from: classes4.dex */
public class frh implements Goal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f13107a;
    private String b;
    private Object c;
    private Object d;
    private Object e;

    @Override // com.huawei.basefitnessadvice.model.intplan.Goal
    public String getStatType() {
        return this.b;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.Goal
    public Object getGoalSrc() {
        return this.f13107a;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.Goal
    public Object getGoalDst() {
        return this.d;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.Goal
    public Object getGoalEstimate() {
        return this.c;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.Goal
    public Object getGoalActual() {
        return this.e;
    }

    public void a(String str) {
        this.b = str;
    }

    public void c(Object obj) {
        this.d = obj;
    }

    public frh b(GoalBean goalBean) {
        if (goalBean != null) {
            a(goalBean.getType());
            c(goalBean.getValue());
        }
        return this;
    }
}
