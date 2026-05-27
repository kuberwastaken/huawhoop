package defpackage;

import com.huawei.animationkit.computationalwallpaper.pattern.UpdateListener;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class axw implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((UpdateListener) obj).onUpdate();
    }
}
