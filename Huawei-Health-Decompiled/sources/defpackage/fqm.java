package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.constant.RewardMethods;

/* JADX INFO: loaded from: classes4.dex */
public class fqm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("title")
    private String f13095a;

    @SerializedName(RewardMethods.SHOW_CLOSE)
    private boolean c;

    @SerializedName("aiDeclare")
    private String d;

    public String b() {
        return this.f13095a;
    }

    public boolean a() {
        return this.c;
    }
}
