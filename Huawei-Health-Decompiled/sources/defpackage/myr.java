package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.health.R;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class myr {
    private static HashMap<String, String> b = new HashMap<>();
    private static ArrayList<String> d = new ArrayList<>();

    static class e {
        private static final myr d = new myr();
    }

    public static myr b() {
        return e.d;
    }

    private myr() {
    }

    public void d(Context context) {
        if (context == null) {
            return;
        }
        String[] stringArray = context.getResources().getStringArray(R.array._2130968654_res_0x7f04004e);
        String[] stringArray2 = context.getResources().getStringArray(R.array._2130968653_res_0x7f04004d);
        if (stringArray2.length != stringArray.length) {
            return;
        }
        int length = stringArray2.length;
        for (int i = 0; i < length; i++) {
            String str = stringArray2[i];
            if (!d.contains(str)) {
                d.add(str);
            }
            if (!b.containsKey(str)) {
                b.put(str, stringArray[i]);
            }
        }
    }

    public String c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strD = d(context, str);
        return !TextUtils.isEmpty(str) ? b.get(strD) : strD;
    }

    private String d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (d.isEmpty()) {
            d(context);
        }
        int size = d.size();
        for (int i = 0; i < size; i++) {
            String str2 = d.get(i);
            if (str.matches(str2)) {
                return str2;
            }
        }
        return null;
    }
}
