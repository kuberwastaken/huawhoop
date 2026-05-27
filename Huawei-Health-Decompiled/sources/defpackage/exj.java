package defpackage;

import com.huawei.health.hwuserlabelmgr.manager.LabelMatcher;

/* JADX INFO: loaded from: classes4.dex */
public class exj implements LabelMatcher {
    private double c;
    private String e;

    public exj(double d, String str) {
        this.c = d;
        this.e = str;
    }

    @Override // com.huawei.health.hwuserlabelmgr.manager.LabelMatcher
    public String getMatchResult(double d) {
        if (Math.abs(d - this.c) < 1.0E-6d) {
            return this.e;
        }
        return null;
    }
}
