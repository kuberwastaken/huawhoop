package defpackage;

import com.huawei.animationkit.computationalwallpaper.coloranalysis.ColorResult;
import java.util.function.Function;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class awq implements Function {
    public final /* synthetic */ ColorResult d;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.d.formatColor((awi) obj);
    }

    public /* synthetic */ awq(ColorResult colorResult) {
        this.d = colorResult;
    }
}
