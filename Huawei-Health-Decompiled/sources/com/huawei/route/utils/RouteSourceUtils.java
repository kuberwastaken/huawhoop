package com.huawei.route.utils;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.text.TextUtils;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes7.dex */
public class RouteSourceUtils {
    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String MY_ROUTE_PATH = "route";
    public static final String RUNNING_ROUTE_ANALYSIS_1040087 = "1040087";
    public static final String RUNNING_ROUTE_ANALYSIS_1040088 = "1040088";
    public static final String RUNNING_ROUTE_ANALYSIS_1040120 = "1040120";
    private static final String TAG = "Track_RouteSourceUtils";
    public static final int TYPE_KOMOOT_ROUTE = 3;
    public static final int TYPE_LOCAL_ROUTE = 1;
    public static final int TYPE_MOTION_ROUTE = 2;
    private static final String UTC = "UTC";

    private RouteSourceUtils() {
    }

    public static String longTimeToString(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.ROOT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date(j));
    }

    public static String getTrackFileName(Cursor cursor) {
        String string = "";
        if (cursor == null || cursor.getCount() == 0) {
            LogUtil.j(TAG, "file does not exist.");
            return "";
        }
        try {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex == -1) {
                LogUtil.b(TAG, "display_name does not exist");
            } else {
                LogUtil.b(TAG, "display_name:", Integer.valueOf(columnIndex));
                string = cursor.getString(columnIndex);
            }
            if (TextUtils.isEmpty(string)) {
                LogUtil.b(TAG, "file name is empty,get from _data");
                int columnIndex2 = cursor.getColumnIndex("_data");
                if (columnIndex2 == -1) {
                    LogUtil.b(TAG, "_data column does not exist.");
                    return string;
                }
                String string2 = cursor.getString(columnIndex2);
                if (TextUtils.isEmpty(string2)) {
                    LogUtil.b(TAG, "path is empty");
                    return string;
                }
                string = string2.trim().substring(string2.lastIndexOf("/") + 1);
            }
            LogUtil.b(TAG, "fileName:", string);
            return string;
        } catch (CursorIndexOutOfBoundsException e) {
            ReleaseLogUtil.c(TAG, "cursorIndexOutOfBoundsException: ", e.getMessage());
            return "";
        } finally {
            cursor.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.os.ParcelFileDescriptor] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [android.os.ParcelFileDescriptor] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [android.os.ParcelFileDescriptor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String parseFileCopyToRoutePath(android.net.Uri r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "fis IOException"
            java.lang.String r1 = "parcelFileDescriptor IOException"
            java.lang.String r2 = "Track_RouteSourceUtils"
            android.content.Context r3 = com.huawei.haf.application.BaseApplication.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.io.File r5 = r3.getFilesDir()
            r4.append(r5)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            java.lang.String r5 = "route"
            r4.append(r5)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            r4 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
            java.lang.String r5 = "r"
            android.os.ParcelFileDescriptor r8 = r3.openFileDescriptor(r8, r5)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
            java.io.FileDescriptor r3 = r8.getFileDescriptor()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L97
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L97
            r5.<init>(r3)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L97
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
            boolean r4 = defpackage.vsr.e(r3)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
            if (r4 == 0) goto L4e
            com.huawei.haf.common.os.FileUtils.e(r5, r3)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
        L4e:
            if (r8 == 0) goto L5b
            r8.close()     // Catch: java.io.IOException -> L54
            goto L5b
        L54:
            java.lang.Object[] r8 = new java.lang.Object[]{r1}
            com.huawei.hwlogsmodel.LogUtil.a(r2, r8)
        L5b:
            r5.close()     // Catch: java.io.IOException -> L5f
            goto L96
        L5f:
            java.lang.Object[] r8 = new java.lang.Object[]{r0}
            com.huawei.hwlogsmodel.LogUtil.a(r2, r8)
            goto L96
        L67:
            r9 = move-exception
            r4 = r5
            goto L98
        L6a:
            r4 = r5
            goto L71
        L6c:
            r8 = move-exception
            r9 = r8
            r8 = r4
            goto L9b
        L70:
            r8 = r4
        L71:
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L97
            java.lang.String r5 = "IOException"
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L97
            com.huawei.hwlogsmodel.LogUtil.a(r2, r3)     // Catch: java.lang.Throwable -> L97
            if (r8 == 0) goto L89
            r8.close()     // Catch: java.io.IOException -> L82
            goto L89
        L82:
            java.lang.Object[] r8 = new java.lang.Object[]{r1}
            com.huawei.hwlogsmodel.LogUtil.a(r2, r8)
        L89:
            if (r4 == 0) goto L96
            r4.close()     // Catch: java.io.IOException -> L8f
            goto L96
        L8f:
            java.lang.Object[] r8 = new java.lang.Object[]{r0}
            com.huawei.hwlogsmodel.LogUtil.a(r2, r8)
        L96:
            return r9
        L97:
            r9 = move-exception
        L98:
            r7 = r4
            r4 = r8
            r8 = r7
        L9b:
            if (r4 == 0) goto La8
            r4.close()     // Catch: java.io.IOException -> La1
            goto La8
        La1:
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            com.huawei.hwlogsmodel.LogUtil.a(r2, r1)
        La8:
            if (r8 == 0) goto Lb5
            r8.close()     // Catch: java.io.IOException -> Lae
            goto Lb5
        Lae:
            java.lang.Object[] r8 = new java.lang.Object[]{r0}
            com.huawei.hwlogsmodel.LogUtil.a(r2, r8)
        Lb5:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.route.utils.RouteSourceUtils.parseFileCopyToRoutePath(android.net.Uri, java.lang.String):java.lang.String");
    }
}
