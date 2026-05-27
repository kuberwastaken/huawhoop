package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.wear.oversea.account.ProcessDataSyncHelper;

/* JADX INFO: loaded from: classes8.dex */
public final class vvo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f18809a = new byte[0];
    private static volatile vvo d;
    private SharedPreferences b;
    private Context c;
    private String e;

    private vvo(Context context) {
        this.b = null;
        this.c = context;
        if (context != null) {
            this.e = "swipecard_wallet_account";
            this.b = context.getSharedPreferences("swipecard_wallet_account", 0);
        }
    }

    public static vvo a(Context context) {
        if (d == null) {
            synchronized (f18809a) {
                if (d == null) {
                    d = new vvo(context.getApplicationContext());
                }
            }
        }
        return d;
    }

    public boolean b(String str, String str2) {
        if (this.b == null) {
            return false;
        }
        if ("user_id".equals(str)) {
            vwc.b("AccountPref", "putString key is userid");
            return false;
        }
        if ("last_user_id".equals(str)) {
            vwc.b("AccountPref", "putString key is userid");
            return false;
        }
        ProcessDataSyncHelper.b(this.c).e(this.c, this.e, str, str2);
        return this.b.edit().putString(str, str2).commit();
    }

    public String d(String str, String str2) {
        if (this.b == null) {
            return str2;
        }
        if ("user_id".equals(str)) {
            vwc.b("AccountPref", "getString key is userid");
            return "";
        }
        if ("last_user_id".equals(str)) {
            vwc.b("AccountPref", "getString key is userid");
            return "";
        }
        return this.b.getString(str, str2);
    }
}
