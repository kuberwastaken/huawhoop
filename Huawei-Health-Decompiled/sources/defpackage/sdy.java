package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.haf.application.BaseApplication;
import com.huawei.login.ui.login.LoginInit;
import com.huawei.operation.utils.CloudParamKeys;

/* JADX INFO: loaded from: classes7.dex */
public class sdy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("country")
    private String f17673a;

    @SerializedName(CloudParamKeys.CLIENT_TYPE)
    private int b;

    @SerializedName("timestamp")
    private long c;

    @SerializedName("timeZone")
    private String d;

    public sdy() {
        c(kql.q(System.currentTimeMillis()));
        a(System.currentTimeMillis());
        b(plt.d());
        b(LoginInit.getInstance(BaseApplication.a()).getAccountInfo(1010));
    }

    public void a(long j) {
        this.c = j;
    }

    public void c(String str) {
        this.d = str;
    }

    public void b(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.f17673a = str;
    }
}
