package defpackage;

import com.huawei.health.hwuserlabelmgr.manager.LabelMatcher;

/* JADX INFO: loaded from: classes4.dex */
public class exo implements LabelMatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f12837a;
    private String b;
    private double c;

    public exo(double d, double d2, String str) {
        this.c = d;
        this.f12837a = d2;
        this.b = str;
    }

    @Override // com.huawei.health.hwuserlabelmgr.manager.LabelMatcher
    public String getMatchResult(double d) {
        if (d <= this.c || d > this.f12837a) {
            return null;
        }
        return this.b;
    }
}
