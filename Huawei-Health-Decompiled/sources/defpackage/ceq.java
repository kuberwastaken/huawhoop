package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.devicesdk.entity.ConnectMode;

/* JADX INFO: loaded from: classes3.dex */
public class ceq {

    @SerializedName("mIsHandshakeRunning")
    private boolean c;

    @SerializedName("connectmode")
    private ConnectMode d;

    @SerializedName("deviceIdentity")
    private String e;

    public void e(String str) {
        this.e = str;
    }

    public ConnectMode a() {
        return this.d;
    }

    public void b(ConnectMode connectMode) {
        this.d = connectMode;
    }

    public boolean b() {
        return this.c;
    }

    public void d(boolean z) {
        this.c = z;
    }
}
