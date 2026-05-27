package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class qze {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("newVersion")
    private String f17218a;

    @SerializedName("updateRecords")
    private List<d> b;

    @SerializedName("oldVersion")
    private String e;

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("type")
        private int f17219a;

        @SerializedName("cardIds")
        private List<String> b;
    }

    public String toString() {
        return "CardUpdateConfig{mOldVersion='" + this.e + "', mNewVersion='" + this.f17218a + "', mUpdateRecords=" + this.b + '}';
    }
}
