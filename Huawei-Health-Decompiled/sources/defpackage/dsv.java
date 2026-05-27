package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dsv extends dsx {
    private List<dsw> mConfigInfoList = new ArrayList(5);

    public List<dsw> getConfigInfoList() {
        return this.mConfigInfoList;
    }

    public void setConfigInfoList(List<dsw> list) {
        this.mConfigInfoList = list;
    }

    private String getConfigInfoString() {
        List<dsw> list = this.mConfigInfoList;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(5);
        Iterator<dsw> it = this.mConfigInfoList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(", ");
        }
        return sb.toString();
    }

    @Override // defpackage.dsx
    public String toString() {
        return "SampleConfig {mSrcPkgName=" + getSrcPkgName() + ", mWearPkgName=" + getWearPkgName() + ", mCommandId=" + getCommandId() + ", mConfigInfoList=" + getConfigInfoString() + '}';
    }
}
