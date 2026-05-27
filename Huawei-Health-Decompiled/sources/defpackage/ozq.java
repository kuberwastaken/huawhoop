package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ozq {

    @SerializedName("name")
    private String b;

    @SerializedName("cardId")
    private List<Integer> e = new ArrayList();

    public String c() {
        return this.b;
    }

    public List<Integer> b() {
        return this.e;
    }

    public String toString() {
        return "DomainTopCardId{mName=" + this.b + ", mCardIdList=" + this.e + '}';
    }
}
