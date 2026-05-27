package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class oe {
    public final String c;
    public final String d;

    public oe(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public JSONObject e() {
        if (TextUtils.isEmpty(this.d)) {
            return null;
        }
        try {
            return new JSONObject(this.d);
        } catch (Exception e) {
            ov.b(e);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.c, this.d);
    }
}
