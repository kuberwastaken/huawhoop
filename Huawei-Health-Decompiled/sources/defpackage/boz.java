package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class boz extends bot {

    @SerializedName("healthLifeChallengeBeans")
    private List<equ> b;

    public List<equ> e() {
        return this.b;
    }

    @Override // defpackage.bot
    public String toString() {
        return "HealthModelChallengesResponse{mHealthLifeChallengeBeans=" + this.b + "}";
    }
}
