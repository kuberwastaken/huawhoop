package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class cwk {

    @SerializedName("version")
    private String b;

    @SerializedName("sportWordsList")
    private ArrayList<cwo> e;

    cwk() {
    }

    public String d() {
        return this.b;
    }

    public ArrayList<cwo> b() {
        return (ArrayList) this.e.clone();
    }
}
