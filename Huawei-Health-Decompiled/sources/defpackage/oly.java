package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class oly {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("pwrLevelConfigs")
    private List<oma> f16444a;

    @SerializedName("ftpRecord")
    private omb e;

    public omb a() {
        return this.e;
    }

    public List<oma> c() {
        return this.f16444a;
    }

    public String toString() {
        return "FtpDataRsp{ftpRecord=" + this.e + ", pwrLevelConfigs=" + this.f16444a + '}';
    }
}
