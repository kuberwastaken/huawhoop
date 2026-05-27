package defpackage;

import com.huawei.basefitnessadvice.model.intplan.UserProfile;
import com.huawei.health.plan.model.intplan.UserProfileBean;

/* JADX INFO: loaded from: classes4.dex */
public class frq implements UserProfile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13114a;
    private float b;
    private float c;
    private int d;
    private int e;

    @Override // com.huawei.basefitnessadvice.model.intplan.UserProfile
    public int getGender() {
        return this.f13114a;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.UserProfile
    public int getAge() {
        return this.e;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.UserProfile
    public int getHeight() {
        return this.d;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.UserProfile
    public float getWeight() {
        return this.c;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.UserProfile
    public float getBfr() {
        return this.b;
    }

    public void c(int i) {
        this.f13114a = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public void e(int i) {
        this.d = i;
    }

    public void c(float f) {
        this.c = f;
    }

    public void d(float f) {
        this.b = f;
    }

    public frq e(UserProfileBean userProfileBean) {
        if (userProfileBean != null) {
            b(userProfileBean.getAge());
            d(userProfileBean.getBfr());
            c(userProfileBean.getGender());
            e(userProfileBean.getHeight());
            c(userProfileBean.getWeight());
        }
        return this;
    }
}
