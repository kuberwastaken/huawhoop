package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lui {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mPpgDataList")
    List<Integer> f15479a;

    @SerializedName("mSysTick")
    long b;

    @SerializedName("mAccDataList")
    List<Integer> e;

    public void a(long j) {
        this.b = j;
    }

    public void a(List<Integer> list) {
        this.e = list;
    }

    public void d(List<Integer> list) {
        this.f15479a = list;
    }
}
