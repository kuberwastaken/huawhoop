package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class glh extends CloudCommonReponse {

    @SerializedName("voiceBroadcastLists")
    private List<glf> b = new ArrayList();

    public List<glf> d() {
        return this.b;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "VoiceBroadcastListResponse{mVoiceBroadcastList=" + this.b + ", super='" + super.toString() + "'}";
    }
}
