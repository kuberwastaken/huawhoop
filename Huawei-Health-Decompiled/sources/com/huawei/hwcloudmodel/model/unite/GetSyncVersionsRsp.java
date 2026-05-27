package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class GetSyncVersionsRsp extends CloudCommonReponse {
    private List<SyncKey> versions;

    public List<SyncKey> getVersions() {
        return this.versions;
    }

    public void setVersions(List<SyncKey> list) {
        this.versions = list;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "GetSyncVersionsRsp{versions=" + this.versions + '}';
    }
}
