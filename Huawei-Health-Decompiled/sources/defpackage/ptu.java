package defpackage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class ptu extends ptn {
    private static final long serialVersionUID = 3686256241400139560L;
    private Map<String, String> c = new HashMap(16);

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.c.put(str, str2);
    }

    public String e(String str) {
        return (!TextUtils.isEmpty(str) && this.c.containsKey(str)) ? this.c.get(str) : "";
    }
}
