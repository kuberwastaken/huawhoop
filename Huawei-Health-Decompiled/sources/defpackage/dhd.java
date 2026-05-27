package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcommonmodel.fitnessdatatype.ResultUtils;

/* JADX INFO: loaded from: classes10.dex */
public class dhd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12246a;

    @SerializedName("offbodyValue")
    private int b;
    private int c;

    @SerializedName("heartRete")
    private int d;
    private int e;
    private int i;

    public void b(String str) {
        this.f12246a = (String) ResultUtils.commonFunc(str);
    }

    public void b(int i) {
        this.e = ((Integer) ResultUtils.commonFunc(Integer.valueOf(i))).intValue();
    }

    public void c(int i) {
        this.b = ((Integer) ResultUtils.commonFunc(Integer.valueOf(i))).intValue();
    }

    public void e(int i) {
        this.d = ((Integer) ResultUtils.commonFunc(Integer.valueOf(i))).intValue();
    }

    public void a(int i) {
        this.c = ((Integer) ResultUtils.commonFunc(Integer.valueOf(i))).intValue();
    }

    public void d(int i) {
        this.i = ((Integer) ResultUtils.commonFunc(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "PostureResult{postureId='" + this.f12246a + "', completion=" + this.e + ", offBodyValue=" + this.b + ", heartRate=" + this.d + ", calorie=" + this.c + ", userTime=" + this.i + '}';
    }
}
