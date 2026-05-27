package defpackage;

import android.util.Log;
import com.huawei.uikit.hwcolumnsystem.widget.akxao;

/* JADX INFO: loaded from: classes8.dex */
public class vni extends akxao {
    private static final String m = "avpbg";
    private int n;
    private int o;
    private int r;

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    public final float a(int i) {
        return (i * this.j) + ((i - 1) * this.f);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    public final int b() {
        return this.o;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    public int c() {
        return this.n;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    public int d() {
        return this.o;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    public void e() {
        int i = this.i;
        if (i == 0) {
            Log.e(m, "total column is 0");
            return;
        }
        this.j = ((this.f11115a - (this.e * 2)) - (this.f * (i - 1))) / (i * 1.0f);
        int iA = (int) (a(i) + 0.5f);
        this.r = iA;
        int i2 = this.g;
        if (i2 == -2) {
            this.o = iA + (this.e * 2);
        } else {
            this.o = (int) (a(i2) + c(true) + 0.5f);
        }
        int i3 = this.h;
        if (i3 == -2) {
            this.n = this.r + (this.e * 2);
        } else {
            this.n = (int) (a(i3) + c(false) + 0.5f);
        }
    }

    private int c(boolean z) {
        int i;
        if (!this.l) {
            return 0;
        }
        int i2 = this.k;
        if (i2 == 1 || i2 == 17) {
            if (this.i != 4 || !z) {
                return 0;
            }
            i = this.f;
        } else {
            if (i2 != 19) {
                return 0;
            }
            int i3 = this.i;
            if (i3 != 8 && i3 != 12) {
                return 0;
            }
            i = this.f;
        }
        return i * 2;
    }
}
