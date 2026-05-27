package defpackage;

import com.huawei.hihealthservice.sync.syncerrormgr.ErrorHandlingBase;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes9.dex */
public class kgh implements ErrorHandlingBase {
    @Override // com.huawei.hihealthservice.sync.syncerrormgr.ErrorHandlingBase
    public void dealError(CloudCommonReponse cloudCommonReponse) throws kgm {
        throw new kgm(kgi.b(cloudCommonReponse.getResultCode().intValue()) + cloudCommonReponse.getResultDesc());
    }
}
