package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class iff {

    @SerializedName("cycleAutoSuspendSwitch")
    private String e;

    public boolean c() {
        return "1".equals(this.e);
    }

    public void b(boolean z) {
        if (z) {
            this.e = "1";
        } else {
            this.e = "0";
        }
    }
}
