package defpackage;

import android.os.IBinder;
import com.huawei.android.appbundle.remote.RemoteCall;
import com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceHolder;
import com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceProxy;

/* JADX INFO: loaded from: classes10.dex */
public class asi implements RemoteCall<SplitInstallServiceProxy> {
    static final RemoteCall d = new asi();

    private asi() {
    }

    @Override // com.huawei.android.appbundle.remote.RemoteCall
    /* JADX INFO: renamed from: fy_, reason: merged with bridge method [inline-methods] */
    public SplitInstallServiceProxy asInterface(IBinder iBinder) {
        return SplitInstallServiceHolder.queryLocalInterface(iBinder);
    }
}
