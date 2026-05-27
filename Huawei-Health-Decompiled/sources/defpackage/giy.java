package defpackage;

import com.huawei.basefitnessadvice.model.DayInfo;
import com.huawei.basefitnessadvice.model.PlanWorkout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class giy {
    private int b;
    private List<PlanWorkout> c = new ArrayList();
    private boolean d;
    private DayInfo e;

    public giy(int i, DayInfo dayInfo) {
        this.b = i;
        this.e = dayInfo;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public List<PlanWorkout> b() {
        return this.c;
    }
}
