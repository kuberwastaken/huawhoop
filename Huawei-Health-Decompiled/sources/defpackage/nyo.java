package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes7.dex */
public class nyo extends CloudCommonReponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("percentRank")
    private double f16239a;

    @SerializedName("topRank")
    private int e;

    public int d() {
        return this.e;
    }
}
