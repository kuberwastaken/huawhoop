package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.openplatform.abl.log.util.h;

/* JADX INFO: loaded from: classes6.dex */
public class nec {
    public static String a() {
        String strA = h.a("ro.product.model");
        return TextUtils.isEmpty(strA) ? Build.MODEL : strA;
    }
}
