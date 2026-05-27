package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ozt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("indexCardTextInfos")
    private List<ozr> f16579a = new ArrayList();

    @SerializedName("dataStatistics")
    private ozk c;

    public List<ozr> e() {
        return this.f16579a;
    }

    public ozk a() {
        return this.c;
    }

    public String toString() {
        return "IndexCard{dataStatistics=" + this.c + ", indexCardTextInfos=" + this.f16579a + '}';
    }
}
