package defpackage;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class gls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("sportMode")
    private int f13524a;

    @SerializedName("managers")
    private List<glt> b;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String c;

    @SerializedName("producers")
    private List<glt> d;

    @SerializedName("sources")
    private List<glt> e;

    @SerializedName("sportTypeName")
    private String f;

    @SerializedName("sportTypeRes")
    private String g;

    @SerializedName("sportTypeId")
    private int i;

    gls() {
    }

    public List<glt> b() {
        return this.b;
    }

    public List<glt> c() {
        return this.d;
    }

    public List<glt> d() {
        return this.e;
    }

    public boolean b(int i, int i2) {
        return this.i == i && this.f13524a == i2;
    }

    public void c(gls glsVar) {
        if (glsVar == null) {
            return;
        }
        this.b = c(glsVar.b, this.b);
        this.d = c(glsVar.d, this.d);
        this.e = c(glsVar.e, this.e);
    }

    private <T> List<T> c(List<T> list, List<T> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }
}
