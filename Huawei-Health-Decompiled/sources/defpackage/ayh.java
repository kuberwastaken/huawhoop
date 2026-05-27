package defpackage;

import com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable;
import java.util.Random;

/* JADX INFO: loaded from: classes10.dex */
public class ayh implements Variable {
    private final Random b = new Random();

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public float nextFloat(String str, float f, float f2) {
        return (this.b.nextFloat() * (f2 - f)) + f;
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public int nextInt(String str, int i, int i2) {
        return this.b.nextInt(i2 - i) + i;
    }
}
