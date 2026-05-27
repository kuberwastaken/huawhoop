package com.huawei.profile.account;

import android.accounts.AccountManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.utils.HMSPackageManager;

/* JADX INFO: loaded from: classes7.dex */
public final class AccountUtil {
    private static final int HAS_LOGGED_IN = 1;
    private static final String HAS_LOGIN_COLUMN = "hasLogin";
    private static final String URI_HAS_LOGIN = "content://com.huawei.hwid.api.provider/has_login";

    private AccountUtil() {
    }

    public static boolean hasLogin(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(URI_HAS_LOGIN), null, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    boolean z = cursorQuery.getInt(cursorQuery.getColumnIndex(HAS_LOGIN_COLUMN)) == 1;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return z;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        android.accounts.Account[] accountsByType = AccountManager.get(context).getAccountsByType(HMSPackageManager.getInstance(context).getHMSPackageName());
        return accountsByType != null && accountsByType.length > 0;
    }
}
