package defpackage;

import com.huawei.ads.adsrec.rank.sortation.IModelScoreData;
import com.huawei.ads.fund.util.ListUtil;
import com.huawei.ads.fund.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class aqc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f263a;
    private Integer b;
    private Integer c;
    private final List<String> d;
    private final String e;
    private String f;
    private String g;
    private final int h;
    private Integer i;
    private String j;
    private Map<String, aql> k;
    private String l;
    private Integer m;
    private int n = 0;
    private volatile IModelScoreData o;

    public String toString() {
        return "AdRecallParam{appPkgName='" + this.e + "', adSlotIds=" + this.d + ", maxCount=" + this.b + ", adType=" + this.h + ", clientRequestId='" + this.f + "'}";
    }

    public void b(Integer num) {
        this.i = num;
    }

    public void c(Integer num) {
        this.m = num;
    }

    public void d(String str) {
        this.j = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(Integer num) {
        this.c = num;
    }

    public void a(String str) {
        this.l = str;
    }

    public void a(List<String> list) {
        this.f263a = list;
    }

    public String k() {
        if (aps.e(this.k)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, aql> entry : this.k.entrySet()) {
            String key = entry.getKey();
            aql value = entry.getValue();
            if (value != null) {
                if (i > 0) {
                    sb.append(";");
                }
                Integer numD = value.d();
                Integer numC = value.c();
                sb.append(key);
                sb.append(",");
                sb.append(numD == null ? 0 : numD.intValue());
                sb.append(",");
                sb.append(numC == null ? 0 : numC.intValue());
                i++;
            }
        }
        return sb.toString();
    }

    public Integer o() {
        return this.i;
    }

    public Integer m() {
        return this.m;
    }

    public String l() {
        return this.j;
    }

    public Integer n() {
        return this.b;
    }

    public Integer i() {
        return this.c;
    }

    public String j() {
        return this.l;
    }

    public int g() {
        return this.h;
    }

    public String f() {
        return this.g;
    }

    public int h() {
        return this.n;
    }

    public IModelScoreData d() {
        return this.o;
    }

    public String b() {
        return this.f;
    }

    public String a() {
        String str = this.e;
        return str == null ? this.l : str;
    }

    public void b(String str, Integer num) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        e(str).b(num);
    }

    public void d(int i) {
        this.n = i;
    }

    public List<String> e() {
        return this.f263a;
    }

    public Integer b(String str) {
        aql aqlVarG = g(str);
        if (aqlVarG == null) {
            return null;
        }
        return aqlVarG.d();
    }

    public void a(String str, Integer num) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        e(str).e(num);
    }

    public void a(int i) {
        if (this.m == null) {
            this.m = Integer.valueOf(i);
        }
    }

    public List<String> c() {
        return this.d;
    }

    private void p() {
        if (ListUtil.isEmpty(this.d)) {
            return;
        }
        this.k = new HashMap(((int) (this.d.size() / 0.75f)) + 1);
        for (String str : this.d) {
            if (!StringUtils.isBlank(str)) {
                this.k.put(str, new aql());
            }
        }
    }

    private aql g(String str) {
        if (aps.e(this.k) || StringUtils.isBlank(str)) {
            return null;
        }
        return this.k.get(str);
    }

    private aql e(String str) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        aql aqlVar = this.k.get(str);
        if (aqlVar != null) {
            return aqlVar;
        }
        aql aqlVar2 = new aql();
        this.k.put(str, aqlVar2);
        return aqlVar2;
    }

    public aqc(String str, String str2, List<String> list, Integer num, int i) {
        this.e = str;
        this.f = str2;
        this.d = list;
        this.b = num;
        this.h = i;
        p();
    }
}
