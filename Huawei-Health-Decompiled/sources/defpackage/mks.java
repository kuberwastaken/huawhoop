package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.support.picker.common.AccountPickerUtil;

/* JADX INFO: loaded from: classes6.dex */
public class mks {
    private Context b;
    private String c;
    private volatile SharedPreferences d;

    public mks(Context context, String str) {
        this.c = "";
        this.b = context.getApplicationContext();
        this.c = str;
        a();
    }

    private boolean a() {
        if (AccountPickerUtil.isPhoneStillInLockMode(this.b)) {
            mly.a("HwIdCeSharedPreferences", "Phone Still In Lock Mode", true);
            return false;
        }
        this.d = this.b.getSharedPreferences(this.c, 0);
        boolean z = this.d == null;
        mly.a("HwIdCeSharedPreferences", "createSharedPreferences: " + z, false);
        return z;
    }

    private boolean e() {
        if (this.b == null) {
            mly.b("HwIdCeSharedPreferences", "mContext is null, can not use SharedPreferences.", true);
            return false;
        }
        if (this.d == null) {
            mly.b("HwIdCeSharedPreferences", "mSharedPreferences is null, need init.", true);
            synchronized (mks.class) {
                if (this.d == null) {
                    return a();
                }
            }
        }
        return true;
    }

    public String e(String str, String str2) {
        mly.a("HwIdCeSharedPreferences", "getString, key:" + str, false);
        return !e() ? str2 : this.d.getString(str, str2);
    }

    public boolean b(String str, String str2) {
        SharedPreferences.Editor editorEdit;
        mly.a("HwIdCeSharedPreferences", "setString, key:" + str, false);
        if (!e() || (editorEdit = this.d.edit()) == null) {
            return false;
        }
        return editorEdit.putString(str, str2).commit();
    }

    public long a(String str, long j) {
        mly.a("HwIdCeSharedPreferences", "getLong, key:" + str, false);
        return !e() ? j : this.d.getLong(str, j);
    }

    public boolean b(String str, long j) {
        SharedPreferences.Editor editorEdit;
        mly.a("HwIdCeSharedPreferences", "saveLong, key:" + str, false);
        if (!e() || (editorEdit = this.d.edit()) == null) {
            return false;
        }
        return editorEdit.putLong(str, j).commit();
    }

    public int b(String str, int i) {
        mly.a("HwIdCeSharedPreferences", "getLong, key:" + str, false);
        return !e() ? i : this.d.getInt(str, i);
    }

    public boolean b(String str, boolean z) {
        mly.a("HwIdCeSharedPreferences", "getBoolean, key:" + str, false);
        return !e() ? z : this.d.getBoolean(str, z);
    }

    public boolean e(String str, boolean z) {
        SharedPreferences.Editor editorEdit;
        mly.a("HwIdCeSharedPreferences", "saveBoolean, key:" + str, false);
        if (!e() || (editorEdit = this.d.edit()) == null) {
            return false;
        }
        return editorEdit.putBoolean(str, z).commit();
    }

    public void b(String str) {
        SharedPreferences.Editor editorEdit;
        mly.a("HwIdCeSharedPreferences", "deleteKey, key:" + str, false);
        if (e() && (editorEdit = this.d.edit()) != null) {
            editorEdit.remove(str).commit();
        }
    }
}
