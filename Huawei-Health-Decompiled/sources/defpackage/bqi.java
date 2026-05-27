package defpackage;

import android.util.SparseArray;
import com.huawei.basichealthmodel.listener.TaskDataListener;
import com.huawei.hwbasemgr.ResponseCallback;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class bqi implements ResponseCallback {
    public final /* synthetic */ TaskDataListener b;

    @Override // com.huawei.hwbasemgr.ResponseCallback
    public final void onResponse(int i, Object obj) {
        this.b.onDataChange(i, (SparseArray) obj);
    }
}
