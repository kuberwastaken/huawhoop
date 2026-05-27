package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceCallbackProxy;
import com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceProxy;
import com.huawei.android.bundlecore.install.protocol.ISplitInstallService;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ash extends arg implements SplitInstallServiceProxy {
    public ash(IBinder iBinder) {
        super(iBinder, ISplitInstallService.DESCRIPTOR);
    }

    @Override // com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceProxy
    public final void startInstall(String str, List<Bundle> list, Bundle bundle, SplitInstallServiceCallbackProxy splitInstallServiceCallbackProxy) throws RemoteException {
        Parcel parcelFh_ = fh_();
        parcelFh_.writeString(str);
        parcelFh_.writeTypedList(list);
        arh.fl_(parcelFh_, bundle);
        arh.fk_(parcelFh_, splitInstallServiceCallbackProxy);
        fi_(1, parcelFh_);
    }

    @Override // com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceProxy
    public void cancelInstall(String str, int i, Bundle bundle, SplitInstallServiceCallbackProxy splitInstallServiceCallbackProxy) throws RemoteException {
        Parcel parcelFh_ = fh_();
        parcelFh_.writeString(str);
        parcelFh_.writeInt(i);
        arh.fl_(parcelFh_, bundle);
        arh.fk_(parcelFh_, splitInstallServiceCallbackProxy);
        fi_(2, parcelFh_);
    }

    @Override // com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceProxy
    public void getSessionState(String str, int i, SplitInstallServiceCallbackProxy splitInstallServiceCallbackProxy) throws RemoteException {
        Parcel parcelFh_ = fh_();
        parcelFh_.writeString(str);
        parcelFh_.writeInt(i);
        arh.fk_(parcelFh_, splitInstallServiceCallbackProxy);
        fi_(3, parcelFh_);
    }

    @Override // com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceProxy
    public void getSessionStates(String str, SplitInstallServiceCallbackProxy splitInstallServiceCallbackProxy) throws RemoteException {
        Parcel parcelFh_ = fh_();
        parcelFh_.writeString(str);
        arh.fk_(parcelFh_, splitInstallServiceCallbackProxy);
        fi_(4, parcelFh_);
    }

    @Override // com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceProxy
    public void deferredInstall(String str, List<Bundle> list, Bundle bundle, SplitInstallServiceCallbackProxy splitInstallServiceCallbackProxy) throws RemoteException {
        Parcel parcelFh_ = fh_();
        parcelFh_.writeString(str);
        parcelFh_.writeTypedList(list);
        arh.fl_(parcelFh_, bundle);
        arh.fk_(parcelFh_, splitInstallServiceCallbackProxy);
        fi_(5, parcelFh_);
    }

    @Override // com.huawei.android.appbundle.splitinstall.protocol.SplitInstallServiceProxy
    public void deferredUninstall(String str, List<Bundle> list, Bundle bundle, SplitInstallServiceCallbackProxy splitInstallServiceCallbackProxy) throws RemoteException {
        Parcel parcelFh_ = fh_();
        parcelFh_.writeString(str);
        parcelFh_.writeTypedList(list);
        arh.fl_(parcelFh_, bundle);
        arh.fk_(parcelFh_, splitInstallServiceCallbackProxy);
        fi_(6, parcelFh_);
    }
}
