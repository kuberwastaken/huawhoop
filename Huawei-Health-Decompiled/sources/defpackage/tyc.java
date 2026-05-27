package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes8.dex */
public class tyc extends CloudCommonReponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("userAccount")
    private String f18215a;

    @SerializedName("codeCreatedUserId")
    private Long c;

    public Long b() {
        return this.c;
    }
}
