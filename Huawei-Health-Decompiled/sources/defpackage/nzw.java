package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.ble.BleConstants;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class nzw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(BleConstants.TOTAL_DISTANCE)
    private float f16251a;

    @SerializedName("totalDuration")
    private int b;

    @SerializedName("targetClockInDayList")
    private List<Integer> c;

    @SerializedName("realClockInDayList")
    private List<Integer> d;

    @SerializedName("totalCalorie")
    private float e;

    @SerializedName("trainCompleteRate")
    private float h;

    public float j() {
        return this.h;
    }

    public void b(float f) {
        this.h = f;
    }

    public int e() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public float b() {
        return this.e;
    }

    public List<Integer> d() {
        return this.c;
    }

    public void a(List<Integer> list) {
        this.c = list;
    }

    public List<Integer> a() {
        return this.d;
    }

    public void e(List<Integer> list) {
        this.d = list;
    }

    public float c() {
        return this.f16251a;
    }

    public void c(float f) {
        this.f16251a = f;
    }

    public void d(float f) {
        this.e = f;
    }
}
