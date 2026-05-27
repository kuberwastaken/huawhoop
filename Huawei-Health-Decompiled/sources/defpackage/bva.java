package defpackage;

import com.huawei.hihealth.data.listener.HiDataOperateListener;
import com.huawei.hwbasemgr.ResponseCallback;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class bva implements HiDataOperateListener {
    public final /* synthetic */ ResponseCallback b;

    @Override // com.huawei.hihealth.data.listener.HiDataOperateListener
    public final void onResult(int i, Object obj) {
        this.b.onResponse(i, obj);
    }
}
