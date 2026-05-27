package defpackage;

import com.huawei.ads.fund.util.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class aph {
    private String b;
    private int c;
    private int d;
    private int e;

    public void b() {
        this.c++;
    }

    public void d() {
        this.e++;
    }

    public void d(String str) {
        this.b = str;
    }

    public void c(int i) {
        this.d = i;
    }

    public String e() {
        if (StringUtils.isBlank(this.b)) {
            return null;
        }
        return this.b + "," + this.e + "," + this.c + "," + this.d;
    }
}
