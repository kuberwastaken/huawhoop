package com.huawei.android.appbundle.splitinstall.protocol;

import android.os.Bundle;
import android.os.Parcel;
import com.huawei.android.appbundle.binder.BinderWrapper;
import com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback;
import defpackage.arh;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SplitInstallServiceCallback extends BinderWrapper implements SplitInstallServiceCallbackProxy {
    public SplitInstallServiceCallback() {
        super(ISplitInstallServiceCallback.DESCRIPTOR);
    }

    @Override // com.huawei.android.appbundle.binder.BinderWrapper
    public final boolean dispatchTransact(int i, Parcel parcel) {
        switch (i) {
            case 1:
                onStartInstall(parcel.readInt(), (Bundle) arh.fj_(parcel, Bundle.CREATOR));
                return true;
            case 2:
                int i2 = parcel.readInt();
                arh.fj_(parcel, Bundle.CREATOR);
                onCompleteInstall(i2);
                return true;
            case 3:
                onCancelInstall(parcel.readInt(), (Bundle) arh.fj_(parcel, Bundle.CREATOR));
                return true;
            case 4:
                onGetSession(parcel.readInt(), (Bundle) arh.fj_(parcel, Bundle.CREATOR));
                return true;
            case 5:
                onDeferredUninstall((Bundle) arh.fj_(parcel, Bundle.CREATOR));
                return true;
            case 6:
                onDeferredInstall((Bundle) arh.fj_(parcel, Bundle.CREATOR));
                return true;
            case 7:
                onGetSessionStates(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                onError((Bundle) arh.fj_(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
