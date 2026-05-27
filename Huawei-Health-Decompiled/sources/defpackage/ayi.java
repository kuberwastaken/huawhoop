package defpackage;

import android.util.ArrayMap;
import com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable;
import com.huawei.animationkit.computationalwallpaper.pattern.variable.VariableType;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes10.dex */
public class ayi implements Variable {
    private static final ayi b = new ayi();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Variable> f375a = new ArrayMap();

    public static ayi b() {
        return b;
    }

    private ayi() {
        c(VariableType.Random.RANDOM.getKey(), new ayh());
        ayb aybVar = new ayb();
        c(VariableType.Crown.SCROLL.getKey(), aybVar);
        c(VariableType.Crown.DEGREE.getKey(), aybVar);
        c(VariableType.Crown.SMOOTH_DEGREE.getKey(), aybVar);
    }

    public void c(String str, Variable variable) {
        this.f375a.put(str, variable);
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public void updateFloat(String str, float f) {
        d(str).updateFloat(str, f);
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public void updateInt(String str, int i) {
        d(str).updateInt(str, i);
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public int nextInt(String str, int i, int i2) {
        return d(str).nextInt(str, i, i2);
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public float nextFloat(String str, float f, float f2) {
        return d(str).nextFloat(str, f, f2);
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public float nextFraction(String str) {
        return d(str).nextFraction(str);
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public void addUpdateObserver(String str, Variable.VariableObserver variableObserver) {
        d(str).addUpdateObserver(str, variableObserver);
    }

    private Variable d(final String str) {
        return (Variable) Optional.ofNullable(this.f375a.get(str)).orElseThrow(new Supplier() { // from class: ayg
            @Override // java.util.function.Supplier
            public final Object get() {
                return ayi.a(str);
            }
        });
    }

    static /* synthetic */ Variable.a a(String str) {
        return new Variable.a(str);
    }
}
