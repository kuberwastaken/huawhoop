package defpackage;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.wear.oversea.util.SystemPropertyValues;
import com.huawei.wisesecurity.kfs.log.ILogKfs;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
class wwz {
    private static int b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ILogKfs f18960a;
    private boolean d = true;

    wwz(ILogKfs iLogKfs) {
        this.f18960a = iLogKfs;
    }

    private static void d(int i) {
        b = i;
    }

    public void d() {
        this.d = false;
    }

    boolean d(Context context) {
        if (!this.d) {
            this.f18960a.i("BIChecker", "oobe check is off, report is on");
            return false;
        }
        if (!i()) {
            this.f18960a.i("BIChecker", "not huawei device, report is on");
            return false;
        }
        if (context == null) {
            return true;
        }
        if (b()) {
            return b == 0;
        }
        this.f18960a.i("BIChecker", "not ChinaROM");
        try {
            d(Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state"));
            this.f18960a.i("BIChecker", "hw_app_analytics_state value is " + b);
            return b != 1;
        } catch (Settings.SettingNotFoundException unused) {
            this.f18960a.i("BIChecker", "Get OOBE failed");
            return true;
        }
    }

    private boolean b() {
        String strA = a();
        if (!TextUtils.isEmpty(strA)) {
            return "cn".equalsIgnoreCase(strA);
        }
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            return strE.toLowerCase(Locale.US).contains("cn");
        }
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        return "cn".equalsIgnoreCase(strC);
    }

    private boolean i() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private String a() {
        return wxd.e("ro.product.locale.region", "");
    }

    private String e() {
        return wxd.e(SystemPropertyValues.PROP_LOCALE_KEY, "");
    }

    private String c() {
        return Locale.getDefault().getCountry();
    }
}
