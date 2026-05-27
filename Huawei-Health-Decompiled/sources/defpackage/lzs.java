package defpackage;

import com.huawei.hwdevice.phoneprocess.mgr.hwcontactsyncmgr.contacts.sync.utils.ContactsDatabaseUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class lzs implements ContactsDatabaseUtils.ResultCallback {
    public final /* synthetic */ List c;

    @Override // com.huawei.hwdevice.phoneprocess.mgr.hwcontactsyncmgr.contacts.sync.utils.ContactsDatabaseUtils.ResultCallback
    public final void onResult(Object obj) {
        this.c.add((mam) obj);
    }

    public /* synthetic */ lzs(List list) {
        this.c = list;
    }
}
