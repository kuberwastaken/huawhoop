package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class knd extends CloudCommonReponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("maxPartSize")
    private int f14768a;

    @SerializedName("minPartSize")
    private int c;

    @SerializedName("fileUploadList")
    private List<kmy> d;
}
