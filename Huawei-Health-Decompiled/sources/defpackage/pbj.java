package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class pbj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16610a;
    private Map<String, List<String>> c;
    private List<String> d;
    private String e;

    public String d() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public String b() {
        return this.f16610a;
    }

    public void a(String str) {
        this.f16610a = str;
    }

    public Map<String, List<String>> a() {
        return this.c;
    }

    public void c(Map<String, List<String>> map) {
        this.c = map;
    }

    public List<String> c() {
        return this.d;
    }

    public void e(List<String> list) {
        this.d = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("ThreeCircleRulesBean{mPromptType=");
        sb.append(this.e);
        sb.append(",mCategory=");
        sb.append(this.f16610a);
        sb.append(",mRuleSet=");
        sb.append(this.c);
        sb.append(",mTotalParams=");
        sb.append(this.d);
        return sb.toString();
    }
}
