package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class erl {

    @SerializedName("groupList")
    private List<ern> mGroupLists;

    @SerializedName("version")
    private long mVersion;

    public long getVersion() {
        return this.mVersion;
    }

    public List<ern> getGroupLists() {
        return this.mGroupLists;
    }
}
