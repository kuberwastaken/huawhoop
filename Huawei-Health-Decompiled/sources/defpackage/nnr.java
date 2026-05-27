package defpackage;

import android.text.TextUtils;
import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes6.dex */
public class nnr {
    public static boolean b(String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals(Constants.NULL, str) || TextUtils.equals("NULL", str);
    }

    public static boolean d(String str) {
        return str == null || str.length() == 0;
    }
}
