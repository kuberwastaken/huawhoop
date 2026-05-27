package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.ble.BleConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class oiv {

    @SerializedName(BleConstants.SPORT_TYPE)
    private int c;

    @SerializedName("lastEnterTime")
    private long e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("backgroundList")
    private List<Integer> f16403a = new ArrayList();

    @SerializedName("recommendList")
    private List<Integer> b = new ArrayList();

    @SerializedName("stickerList")
    private List<Integer> d = new ArrayList();

    @SerializedName("watermarkList")
    private List<Integer> h = new ArrayList();

    public oiv(int i) {
        this.c = i;
    }

    public void d(long j) {
        this.e = j;
    }

    public List<Integer> d() {
        return this.b;
    }

    public void b(List<Integer> list) {
        this.b = list;
    }

    public List<Integer> e() {
        return this.f16403a;
    }

    public void c(List<Integer> list) {
        this.f16403a = list;
    }

    public List<Integer> b() {
        return this.h;
    }

    public void a(List<Integer> list) {
        this.h = list;
    }

    public List<Integer> a() {
        return this.d;
    }

    public void d(List<Integer> list) {
        this.d = list;
    }

    public List<Integer> d(int i) {
        if (i == 1) {
            return this.b;
        }
        if (i == 2) {
            return this.f16403a;
        }
        if (i == 3) {
            return this.h;
        }
        if (i == 4) {
            return this.d;
        }
        return Collections.emptyList();
    }
}
