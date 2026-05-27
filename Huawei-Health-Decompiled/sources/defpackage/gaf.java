package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class gaf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("grpID")
    private int f13361a;

    @SerializedName("srcType")
    private int b;

    @SerializedName("otherUserList")
    private List<d> c;

    @SerializedName(HwPayConstant.KEY_USER_ID)
    private String d;

    @SerializedName("dstUserID")
    private String e;

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.e = str;
    }

    public void b(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.f13361a = i;
    }

    public void c(List<d> list) {
        this.c = list;
    }

    /* JADX INFO: loaded from: classes10.dex */
    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("grpID")
        private int f13362a;

        @SerializedName("dstUserID")
        private int b;

        @SerializedName("srcType")
        private int e;

        d() {
        }
    }
}
