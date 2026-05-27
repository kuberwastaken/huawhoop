package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class vwn extends vwq {
    public String g;
    public vvt i;
    public int h = -99;

    @SerializedName("returnDesc")
    private String d = null;

    public void b(String str) {
        this.g = str;
    }

    @Override // defpackage.vwq
    public String b() {
        return this.d;
    }

    @Override // defpackage.vwq
    public void a(String str) {
        this.d = str;
    }

    public void d(int i) {
        this.h = i;
    }
}
