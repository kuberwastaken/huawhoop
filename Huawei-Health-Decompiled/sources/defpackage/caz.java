package defpackage;

import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class caz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f562a;
    private ArrayList<Integer> c = new ArrayList<>(16);
    private long e;

    public void d(long j) {
        this.f562a = j;
    }

    public long a() {
        return this.f562a;
    }

    public void e(long j) {
        this.e = j;
    }

    public long d() {
        return ((Long) kqt.e(Long.valueOf(this.e))).longValue();
    }

    public void a(String str) {
        int length = str.length();
        this.c = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            try {
                this.c.add(i, Integer.valueOf(Integer.parseInt(str.substring(i, i + 1))));
            } catch (NumberFormatException unused) {
                ReleaseLogUtil.c("BTSYNC_CoreSleep_SleepStatusFrame", "setStatusList parseString NumberFormatException");
            }
        }
        LogUtil.b("SleepStatusFrame", "integerArrayList:", Integer.valueOf(this.c.size()));
    }

    public ArrayList<Integer> b() {
        return this.c;
    }

    public String toString() {
        return "SleepStatusFrame{startTime = " + this.f562a + "endTime = " + this.e + "statusList = " + this.c.toString() + "}";
    }
}
