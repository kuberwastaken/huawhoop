package defpackage;

import android.view.Choreographer;
import com.huawei.animationkit.computationalwallpaper.pattern.variable.ObservableVariable;
import com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable;
import com.huawei.animationkit.computationalwallpaper.pattern.variable.VariableType;

/* JADX INFO: loaded from: classes10.dex */
public class ayb extends ObservableVariable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f371a = 0.0f;
    private float b = 0.0f;
    private float e = 0.0f;
    private final Choreographer.FrameCallback c = new Choreographer.FrameCallback() { // from class: ayb.2
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            if (Math.abs(ayb.this.b - ayb.this.e) > 1.0f) {
                ayb.this.e += Math.signum(ayb.this.b - ayb.this.e) * 1.0f;
                Choreographer.getInstance().postFrameCallback(this);
            } else {
                ayb aybVar = ayb.this;
                aybVar.e = aybVar.b;
            }
            ayb.this.notifyObserver(VariableType.Crown.SMOOTH_DEGREE.getKey());
        }
    };

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public void updateFloat(String str, float f) {
        if (VariableType.Crown.SCROLL.getKey().equals(str)) {
            c(str, f);
            b(str, f);
            return;
        }
        throw new Variable.b(str);
    }

    private void c(String str, float f) {
        this.f371a = f;
        this.b += f;
        notifyObserver(VariableType.Crown.SCROLL.getKey());
        notifyObserver(VariableType.Crown.DEGREE.getKey());
    }

    private void b(String str, float f) {
        if (getObservers(VariableType.Crown.SMOOTH_DEGREE.getKey()).isPresent()) {
            this.f371a = f;
            this.b += f;
            Choreographer.getInstance().postFrameCallback(this.c);
        }
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public float nextFloat(String str, float f, float f2) {
        if (VariableType.Crown.SCROLL.getKey().equals(str)) {
            return this.f371a;
        }
        if (VariableType.Crown.DEGREE.getKey().equals(str)) {
            return e(str, f, f2);
        }
        if (VariableType.Crown.SMOOTH_DEGREE.getKey().equals(str)) {
            return a(str, f, f2);
        }
        throw new Variable.b(str);
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public int nextInt(String str, int i, int i2) {
        float fA;
        if (VariableType.Crown.DEGREE.getKey().equals(str)) {
            fA = e(str, i, i2);
        } else if (VariableType.Crown.SMOOTH_DEGREE.getKey().equals(str)) {
            fA = a(str, i, i2);
        } else {
            throw new Variable.b(str);
        }
        return (int) fA;
    }

    @Override // com.huawei.animationkit.computationalwallpaper.pattern.variable.Variable
    public float nextFraction(String str) {
        float fAbs;
        if (VariableType.Crown.DEGREE.getKey().equals(str)) {
            fAbs = Math.abs(this.b);
        } else if (VariableType.Crown.SMOOTH_DEGREE.getKey().equals(str)) {
            fAbs = Math.abs(this.e);
        } else {
            throw new Variable.b(str);
        }
        return (fAbs % 360.0f) / 360.0f;
    }

    private float e(String str, float f, float f2) {
        if (this.b < 0.0f && f < 0.0f) {
            return Math.min(0.0f, f2) - (nextFraction(str) * (Math.min(0.0f, f2) - f));
        }
        return (nextFraction(str) * (f2 - Math.max(0.0f, f))) + Math.max(0.0f, f);
    }

    private float a(String str, float f, float f2) {
        if (this.e < 0.0f && f < 0.0f) {
            return Math.min(0.0f, f2) - (nextFraction(str) * (Math.min(0.0f, f2) - f));
        }
        return (nextFraction(str) * (f2 - Math.max(0.0f, f))) + Math.max(0.0f, f);
    }
}
