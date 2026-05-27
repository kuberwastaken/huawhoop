package defpackage;

import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class oes {
    private static String[] b = {"sr-Latn", "jv-Latn"};
    private static HashMap<String, String> e = new HashMap() { // from class: oes.3
        private static final long serialVersionUID = 1212859686823339267L;

        {
            put("sr-Latn", "b+sr+Latn");
            put("jv-Latn", "b+jv+Latn");
        }
    };

    public static String e() {
        return ody.b + "index_all" + File.separator + "done";
    }

    public static String b() {
        return ody.b + "index_all" + File.separator + "index_all.json";
    }

    public static String c() {
        return ody.b + "img_index_all" + File.separator;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return ody.b + str + File.separator;
    }
}
