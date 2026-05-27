package defpackage;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.provider.CalendarContract;
import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class pke {
    public static boolean b(Context context) {
        return context != null && context.checkSelfPermission("android.permission.WRITE_CALENDAR") == 0 && context.checkSelfPermission("android.permission.READ_CALENDAR") == 0;
    }

    public static boolean cVk_(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return false;
        }
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient("com.huawei.calendar");
        Object[] objArr = new Object[2];
        objArr[0] = "isSupportHWCalendarService:";
        objArr[1] = Boolean.valueOf(contentProviderClientAcquireUnstableContentProviderClient != null);
        LogUtil.a("AsyncCalendarUtils", objArr);
        return contentProviderClientAcquireUnstableContentProviderClient != null;
    }

    public static int d(Context context) {
        int iC = c(context);
        if (iC < 0) {
            return 1;
        }
        LogUtil.a("AsyncCalendarUtils", "current id of CalendarAccount：" + iC);
        return iC;
    }

    private static int c(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, null, null, null, null);
            try {
                if (cursorQuery == null) {
                    LogUtil.c("AsyncCalendarUtils", "userCursor null in checking CalendarAccount");
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return 1;
                }
                if (cursorQuery.getCount() <= 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return 1;
                }
                cursorQuery.moveToFirst();
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return i;
            } finally {
            }
        } catch (SQLException unused) {
            LogUtil.d("AsyncCalendarUtils", "checkCalendarAccount error");
            return 1;
        }
    }
}
