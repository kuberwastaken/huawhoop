package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class vbm {

    @SerializedName("mediaEvaluationSwitch")
    private boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("countryBlocklist")
    private List<String> f18554a = new ArrayList();

    public boolean c() {
        return this.d;
    }

    public List<String> b() {
        return this.f18554a;
    }

    public String toString() {
        return "BetaSubmissionConfigBean MediaEvaluationSwitch = " + this.d + " CountryBlocklist = " + this.f18554a;
    }
}
