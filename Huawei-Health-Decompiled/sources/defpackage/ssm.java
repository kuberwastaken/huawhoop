package defpackage;

import com.huawei.ui.commonui.dialog.ThreeCircleShareCallback;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ssm implements ThreeCircleShareCallback, Serializable {
    public final /* synthetic */ int b;

    @Override // com.huawei.ui.commonui.dialog.ThreeCircleShareCallback
    public final void onCallback(boolean z) {
        ssl.c(this.b, z);
    }

    public /* synthetic */ ssm(int i) {
        this.b = i;
    }
}
