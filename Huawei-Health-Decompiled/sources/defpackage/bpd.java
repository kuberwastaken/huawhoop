package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class bpd extends bot {

    @SerializedName("stats")
    private List<eqr> c;

    public List<eqr> e() {
        return this.c;
    }

    @Override // defpackage.bot
    public String toString() {
        return "HealthModelStatResponse{mStats=" + this.c + "}";
    }
}
