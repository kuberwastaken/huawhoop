package com.huawei.maps.offlinedata.health.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class SampleConfig extends SampleBase {
    private List<SampleConfigInfo> mConfigInfoList = new ArrayList(5);

    public List<SampleConfigInfo> getConfigInfoList() {
        return this.mConfigInfoList;
    }

    public void setConfigInfoList(List<SampleConfigInfo> list) {
        this.mConfigInfoList = list;
    }

    private String getConfigInfoString() {
        List<SampleConfigInfo> list = this.mConfigInfoList;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(5);
        Iterator<SampleConfigInfo> it = this.mConfigInfoList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(", ");
        }
        return sb.toString();
    }

    @Override // com.huawei.maps.offlinedata.health.sample.SampleBase
    public String toString() {
        return "SampleConfig {mSrcPkgName=" + getSrcPkgName() + ", mWearPkgName=" + getWearPkgName() + ", mCommandId=" + getCommandId() + ", mConfigInfoList=" + getConfigInfoString() + '}';
    }
}
