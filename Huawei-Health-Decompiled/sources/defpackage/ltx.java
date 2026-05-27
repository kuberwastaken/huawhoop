package defpackage;

import com.huawei.hwlogsmodel.LogUtil;

/* JADX INFO: loaded from: classes6.dex */
public class ltx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15470a;
    private long b;
    private long c;
    private boolean d;
    private int e;
    private long j;

    public long g() {
        return this.j;
    }

    public long a() {
        return this.c;
    }

    public long d() {
        return this.f15470a;
    }

    public long b() {
        return this.b;
    }

    public int c() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public boolean e() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void c(int i, long j) {
        if (i != 101) {
            if (i != 102) {
                if (i != 301) {
                    if (i != 302) {
                        switch (i) {
                            case 401:
                                this.f15470a = j;
                                break;
                            case 402:
                                this.b = j;
                                break;
                            case 403:
                                this.f15470a = j;
                                this.b = j;
                                break;
                            default:
                                LogUtil.j("MenstrualData setTimeContent error", new Object[0]);
                                break;
                        }
                    }
                }
            }
            this.c = j;
            return;
        }
        this.j = j;
    }
}
