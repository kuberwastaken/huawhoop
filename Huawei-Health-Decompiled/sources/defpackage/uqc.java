package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class uqc {
    private String dataTypeName;
    private long endTime;
    private long modifyTime;
    private long startTime;
    private List<uqg> value;

    public long getStartTime() {
        return this.startTime / 1000000;
    }

    public long getEndTime() {
        return this.endTime / 1000000;
    }

    public long getModifyTime() {
        return this.modifyTime;
    }

    public String getDataTypeName() {
        return this.dataTypeName;
    }

    public List<uqg> getValue() {
        return this.value;
    }
}
