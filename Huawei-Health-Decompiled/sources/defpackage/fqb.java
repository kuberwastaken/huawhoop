package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fqb {

    @SerializedName("controlDatas")
    private List<fqh> b;

    @SerializedName("button")
    private fqj d;

    public fqb(List<fqh> list, fqj fqjVar) {
        this.b = list;
        this.d = fqjVar;
    }

    public fqj c() {
        return this.d;
    }
}
