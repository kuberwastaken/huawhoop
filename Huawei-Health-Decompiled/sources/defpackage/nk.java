package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.o0.b;
import java.util.Random;

/* JADX INFO: loaded from: classes9.dex */
public class nk {
    public static String c() {
        String strE = nj.e("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(strE)) {
            strE = nj.e("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(strE) ? d() : strE;
    }

    public static String e() {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNanoTime = (int) System.nanoTime();
        int iNextInt = new Random().nextInt();
        int iNextInt2 = new Random().nextInt();
        byte[] bArrD = nh.d(iCurrentTimeMillis);
        byte[] bArrD2 = nh.d(iNanoTime);
        byte[] bArrD3 = nh.d(iNextInt);
        byte[] bArrD4 = nh.d(iNextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bArrD, 0, bArr, 0, 4);
        System.arraycopy(bArrD2, 0, bArr, 4, 4);
        System.arraycopy(bArrD3, 0, bArr, 8, 4);
        System.arraycopy(bArrD4, 0, bArr, 12, 4);
        return b.d(bArr, 2);
    }

    public static String d() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(Context context) {
        String strC = ng.a(null) ? c() : null;
        return ng.a(strC) ? e() : strC;
    }

    public static String c(Context context) {
        return "";
    }
}
