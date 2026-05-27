package defpackage;

import com.huawei.hwdevice.phoneprocess.mgr.hwcontactsyncmgr.contacts.sync.utils.ContactsDatabaseUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class lpx implements ContactsDatabaseUtils.ResultCallback {
    public final /* synthetic */ List b;

    @Override // com.huawei.hwdevice.phoneprocess.mgr.hwcontactsyncmgr.contacts.sync.utils.ContactsDatabaseUtils.ResultCallback
    public final void onResult(Object obj) {
        this.b.add((String) obj);
    }
}
