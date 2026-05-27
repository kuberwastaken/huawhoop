package defpackage;

import android.content.Context;
import com.huawei.hihealthkit.context.H5ProAppInfo;
import com.huawei.hihealthkit.context.OutOfBandContext;

/* JADX INFO: loaded from: classes5.dex */
public class jpo extends OutOfBandContext {
    private H5ProAppInfo e;

    public jpo(Context context, H5ProAppInfo h5ProAppInfo) {
        super(context);
        this.e = h5ProAppInfo;
    }

    @Override // com.huawei.hihealthkit.context.OutOfBandContext
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public H5ProAppInfo getOutOfBandData() {
        return this.e;
    }
}
