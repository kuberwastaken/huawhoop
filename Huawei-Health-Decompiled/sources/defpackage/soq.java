package defpackage;

import android.content.res.Resources;
import com.huawei.haf.application.BaseApplication;
import com.huawei.health.R;
import com.huawei.ui.main.stories.fitness.activity.heartrate.helper.HeartRateDetailData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class soq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f17778a;
    private float b;
    private float c;
    private ArrayList<HeartRateDetailData> d;
    private long e;

    public long a() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public long b() {
        return this.f17778a;
    }

    public void b(long j) {
        this.f17778a = j;
    }

    public void e(float f) {
        this.b = f;
    }

    public void d(float f) {
        this.c = f;
    }

    public void d(ArrayList<HeartRateDetailData> arrayList) {
        this.d = arrayList;
    }

    public ArrayList<HeartRateDetailData> e() {
        return this.d;
    }

    public String c() {
        Resources resources = BaseApplication.a().getResources();
        int i = (int) this.c;
        return resources.getQuantityString(R.plurals._2130903152_res_0x7f030070, i, Integer.valueOf(i), Integer.valueOf((int) this.b));
    }
}
