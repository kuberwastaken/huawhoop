package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.utils.Constants;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class qzf {

    @SerializedName("groupType")
    private int c;

    @SerializedName("cardIds")
    private List<String> e;

    public int c() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public List<String> e() {
        return this.e;
    }

    public void a(List<String> list) {
        this.e = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CardShowGroup{mGroupType=");
        sb.append(this.c);
        sb.append(", mCardIds=");
        List<String> list = this.e;
        sb.append(list == null ? Constants.NULL : Arrays.toString(list.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
