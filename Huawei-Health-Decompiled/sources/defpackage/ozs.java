package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ozs {

    @SerializedName("coreCardIds")
    private List<Integer> e = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("topCardIds")
    private List<Integer> f16578a = new ArrayList();

    @SerializedName("domainTopCardIds")
    private List<ozq> b = new ArrayList();

    @SerializedName("domainCards")
    private List<ozp> c = new ArrayList();

    public List<Integer> e() {
        return this.f16578a;
    }

    public List<ozq> a() {
        return this.b;
    }

    public List<ozp> d() {
        return this.c;
    }

    public String toString() {
        return "Highlights{mCoreCardIdList=" + this.e + ", mTopCardIdList=" + this.f16578a + ", mDomainTopCardIdList=" + this.b + ", mDomainCardList=" + this.c + '}';
    }
}
