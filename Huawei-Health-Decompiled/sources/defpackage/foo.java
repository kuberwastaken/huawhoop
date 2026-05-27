package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class foo implements Serializable {

    @SerializedName("hotPathAutoParticipateSwitch")
    private String b;

    @SerializedName("hotPathAutoParticipatePushSwitch")
    private String c;

    public String d() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.b = z ? "1" : "0";
    }

    public String a() {
        return this.c;
    }

    public void c(boolean z) {
        this.c = z ? "1" : "0";
    }

    public String toString() {
        return "PathAutoSwitchInfo{mHotPathAutoParticipateSwitch='" + this.b + "', mHotPathAutoParticipatePushSwitch=" + this.c + '}';
    }
}
