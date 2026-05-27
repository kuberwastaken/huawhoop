package defpackage;

import android.app.Activity;
import huawei.android.widget.HwImmersiveMode;

/* JADX INFO: loaded from: classes8.dex */
public class voe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f18691a;
    private HwImmersiveMode c;

    public voe(Activity activity) {
        this.c = new HwImmersiveMode(activity);
        this.f18691a = activity;
    }

    public void e(boolean z) {
        this.c.setNavigationBarBlurEnable(z);
    }
}
