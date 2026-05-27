package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class kcb {
    private List<String> scopeList;
    private long updateTimeStamp;

    public List<String> getScopeList() {
        if (this.scopeList == null) {
            this.scopeList = new ArrayList();
        }
        return this.scopeList;
    }

    public long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public void setUpdateTimeStamp(long j) {
        this.updateTimeStamp = j;
    }
}
