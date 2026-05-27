package com.huawei.android.appbundle.splitinstall.protocol;

import android.os.IBinder;
import android.os.IInterface;
import com.huawei.android.appbundle.binder.BinderWrapper;
import com.huawei.android.bundlecore.install.protocol.ISplitInstallService;
import defpackage.ash;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SplitInstallServiceHolder extends BinderWrapper implements SplitInstallServiceProxy {
    protected SplitInstallServiceHolder(String str) {
        super(str);
    }

    public static SplitInstallServiceProxy queryLocalInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISplitInstallService.DESCRIPTOR);
        return iInterfaceQueryLocalInterface instanceof SplitInstallServiceProxy ? (SplitInstallServiceProxy) iInterfaceQueryLocalInterface : new ash(iBinder);
    }
}
