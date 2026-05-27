package defpackage;

import android.os.Bundle;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class lje {

    @SerializedName("interval")
    private long c;

    @SerializedName("value")
    private int d;

    public void bPD_(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.c = ((Long) kqt.e(Long.valueOf(bundle.getLong("interval", -1L)))).longValue();
        this.d = ((Integer) kqt.e(Integer.valueOf(bundle.getInt("value", -1)))).intValue();
    }
}
