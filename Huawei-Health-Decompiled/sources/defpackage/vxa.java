package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.wear.oversea.account.ProcessDataSyncHelper;

/* JADX INFO: loaded from: classes8.dex */
public final class vxa {
    private static final byte[] c = new byte[0];
    private static volatile vxa e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18821a = "NFC_Properties";
    private Context b;
    private SharedPreferences d;

    private vxa(Context context) {
        this.d = null;
        this.b = context;
        this.d = context.getSharedPreferences("NFC_Properties", 0);
    }

    public static vxa c(Context context) {
        if (e == null) {
            synchronized (c) {
                if (e == null) {
                    e = new vxa(context.getApplicationContext());
                }
            }
        }
        return e;
    }

    public String c(String str, String str2) {
        return this.d.getString(str, str2);
    }

    public int d(String str, int i) {
        return this.d.getInt(str, i);
    }

    public Long b(String str, Long l) {
        return Long.valueOf(this.d.getLong(str, l.longValue()));
    }

    public boolean c(String str, Long l) {
        ProcessDataSyncHelper.b(this.b).e(this.b, this.f18821a, str, l);
        return this.d.edit().putLong(str, l.longValue()).commit();
    }

    public boolean b(String str, String str2) {
        ProcessDataSyncHelper.b(this.b).e(this.b, this.f18821a, str, str2);
        return this.d.edit().putString(str, str2).commit();
    }

    public boolean e(String str, int i) {
        ProcessDataSyncHelper.b(this.b).e(this.b, this.f18821a, str, Integer.valueOf(i));
        return this.d.edit().putInt(str, i).commit();
    }

    public boolean b(String str) {
        return this.d.contains(str);
    }

    public boolean d(String str) {
        ProcessDataSyncHelper.b(this.b).d(this.b, this.f18821a, str);
        return this.d.edit().remove(str).commit();
    }
}
