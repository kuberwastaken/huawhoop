package defpackage;

import com.huawei.animation.physical2.ParamTransfer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class avu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f362a = 0;
    private List<avy> b = new ArrayList();
    private ParamTransfer<Float> c;
    private float e;

    private avu(ParamTransfer<Float> paramTransfer) {
        this.c = paramTransfer;
    }

    public static avu a(int i, int i2, float f, ParamTransfer<Float> paramTransfer) {
        if (i <= 0 || paramTransfer == null) {
            throw new IllegalArgumentException("illegal parameter");
        }
        avu avuVar = new avu(paramTransfer);
        avuVar.c = paramTransfer;
        avuVar.e = f;
        for (int i3 = 0; i3 < i; i3++) {
            avuVar.b.add(new avy(i2, paramTransfer.transfer(Float.valueOf(avuVar.e), i3).floatValue()));
        }
        return avuVar;
    }

    public float e(int i, float f) {
        if (i < 0 || i >= this.b.size() || this.b.get(i) == null) {
            throw new IllegalArgumentException("parameter out of range");
        }
        return this.b.get(i).getRate(f);
    }

    public void b(int i) {
        if (i == this.f362a) {
            return;
        }
        this.f362a = i;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            avy avyVar = this.b.get(i2);
            if (avyVar != null) {
                avyVar.b(this.c.transfer(Float.valueOf(this.e), Math.abs(i2 - i)).floatValue());
            }
        }
    }
}
