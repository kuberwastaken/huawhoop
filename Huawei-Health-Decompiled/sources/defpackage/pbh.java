package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes7.dex */
public class pbh extends CloudCommonReponse {

    @SerializedName("activeWeek")
    pbg b;

    @SerializedName("perfectMonth")
    pbg c;

    @SerializedName("perfectWeek")
    pbg e;

    public pbg d() {
        return this.b;
    }

    public pbg e() {
        return this.e;
    }

    public pbg c() {
        return this.c;
    }
}
