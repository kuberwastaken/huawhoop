package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class bzn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("certFingerprint")
    private String f552a;

    @SerializedName("scopes")
    private List<b> e;

    public static class b {

        @SerializedName("permissions")
        private List<String> c;
    }
}
