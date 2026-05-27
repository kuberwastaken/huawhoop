package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cqm extends CloudCommonReponse {

    @SerializedName(ParsedFieldTag.GOAL)
    private List<cqi> e;

    public List<cqi> a() {
        return this.e;
    }

    public void b(List<cqi> list) {
        this.e = list;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GetActiveTargetsRsp{goal=");
        stringBuffer.append(this.e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
