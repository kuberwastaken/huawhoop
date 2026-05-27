package defpackage;

import android.content.Context;
import android.os.Build;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.huawei.openalliance.ad.constant.OsType;
import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public class lh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static lh f15151a = new lh();

    public String l() {
        return e("ro.kernel.qemu", "0");
    }

    public String k() {
        return Build.TAGS;
    }

    public String m() {
        return Build.VERSION.SDK;
    }

    public String o() {
        return Build.VERSION.RELEASE;
    }

    public String n() {
        return Build.PRODUCT;
    }

    public String f() {
        return Build.MODEL;
    }

    public String i() {
        return Build.MANUFACTURER;
    }

    public String g() {
        return Build.VERSION.INCREMENTAL;
    }

    public String j() {
        return Build.DISPLAY;
    }

    public String h() {
        return Build.DEVICE;
    }

    public String e() {
        return Build.BRAND;
    }

    public String a() {
        return Build.BOARD;
    }

    public boolean b() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i = 0; i < 5; i++) {
            try {
                if (new File(strArr[i] + CmcdConfiguration.KEY_STARTUP).exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public String c() {
        return OsType.ANDROID;
    }

    public boolean d(Context context) {
        try {
            if (!Build.HARDWARE.contains("goldfish") && !Build.PRODUCT.contains("sdk")) {
                if (!Build.FINGERPRINT.contains("generic")) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String e(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static lh d() {
        return f15151a;
    }
}
