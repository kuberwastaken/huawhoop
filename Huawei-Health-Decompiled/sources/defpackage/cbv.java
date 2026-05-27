package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.featureuserprofile.route.hwgpxmodel.Wpt;
import com.huawei.hms.network.embedded.w9;

/* JADX INFO: loaded from: classes10.dex */
public class cbv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("status")
    private int f565a;

    @SerializedName(w9.o)
    private boolean c;

    @SerializedName(Wpt.MODE)
    private int e;

    public void d(int i) {
        this.e = i;
    }

    public void b(int i) {
        this.f565a = i;
    }

    public void c(boolean z) {
        this.c = z;
    }
}
