package defpackage;

import com.huawei.basefitnessadvice.model.intplan.StatInfo;

/* JADX INFO: loaded from: classes4.dex */
public class fro implements StatInfo {
    private String d;
    private Object e;

    public fro(String str, Object obj) {
        this.d = str;
        this.e = obj;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.StatInfo
    public String getStatType() {
        return this.d;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.StatInfo
    public <T> T getValue() {
        return (T) this.e;
    }
}
