package health.compact.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.huawei.pluginachievement.manager.model.MedalConstants;

/* JADX INFO: loaded from: classes.dex */
public class DataAccessLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13735a;
    private static final String[] b = {MedalConstants.EVENT_KEY, "value"};
    private static final String c;
    private static Uri d;

    static {
        String strH = CommonUtils.h(".version.provider");
        c = strH;
        f13735a = "content://" + strH + "/";
        a();
    }

    private DataAccessLayer() {
    }

    private static void a() {
        d = bYm_("module_200007_keyvaldb");
    }

    public static boolean b(Context context) throws Throwable {
        if (context == null) {
            Log.w("LogUtil_DataAccessLayer", "context is null");
            return false;
        }
        String strA = a(context, "have_cloud_or_not");
        Log.i("LogUtil_DataAccessLayer", "getValue(KEY_UI_ID_IS_OVERSEA_OR_NOT): " + strA);
        if ("1".equalsIgnoreCase(strA)) {
            Log.i("LogUtil_DataAccessLayer", "getOverseaFlagFromDB false");
            return false;
        }
        Log.i("LogUtil_DataAccessLayer", "getOverseaFlagFromDB true");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059 A[PHI: r1 r8
      0x0059: PHI (r1v3 java.lang.String) = (r1v7 java.lang.String), (r1v8 java.lang.String), (r1v5 java.lang.String) binds: [B:28:0x004f, B:31:0x0057, B:21:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x0059: PHI (r8v8 android.database.Cursor) = (r8v6 android.database.Cursor), (r8v7 android.database.Cursor), (r8v9 android.database.Cursor) binds: [B:28:0x004f, B:31:0x0057, B:21:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "LogUtil_DataAccessLayer"
            r1 = 0
            if (r9 != 0) goto Lb
            java.lang.String r8 = "getValue null"
            android.util.Log.w(r0, r8)
            return r1
        Lb:
            java.lang.String[] r6 = new java.lang.String[]{r9}
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47 android.database.SQLException -> L50
            android.net.Uri r3 = health.compact.a.DataAccessLayer.d     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47 android.database.SQLException -> L50
            java.lang.String[] r4 = health.compact.a.DataAccessLayer.b     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47 android.database.SQLException -> L50
            java.lang.String r5 = "key = ?"
            r7 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47 android.database.SQLException -> L50
            if (r8 != 0) goto L2c
            java.lang.String r9 = "cursor == null, return null"
            android.util.Log.w(r0, r9)     // Catch: java.lang.Exception -> L48 android.database.SQLException -> L51 java.lang.Throwable -> L5d
            if (r8 == 0) goto L2b
            r8.close()
        L2b:
            return r1
        L2c:
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Exception -> L48 android.database.SQLException -> L51 java.lang.Throwable -> L5d
            if (r9 != 0) goto L3d
            java.lang.String r9 = "cursor moveToFirst failed, return null"
            android.util.Log.w(r0, r9)     // Catch: java.lang.Exception -> L48 android.database.SQLException -> L51 java.lang.Throwable -> L5d
            if (r8 == 0) goto L3c
            r8.close()
        L3c:
            return r1
        L3d:
            r9 = 1
            java.lang.String r1 = r8.getString(r9)     // Catch: java.lang.Exception -> L48 android.database.SQLException -> L51 java.lang.Throwable -> L5d
            if (r8 == 0) goto L5c
            goto L59
        L45:
            r8 = move-exception
            goto L60
        L47:
            r8 = r1
        L48:
            java.lang.String r9 = "catch CursorWindowAllocationException"
            android.util.Log.e(r0, r9)     // Catch: java.lang.Throwable -> L5d
            if (r8 == 0) goto L5c
            goto L59
        L50:
            r8 = r1
        L51:
            java.lang.String r9 = "queryStorage error"
            android.util.Log.e(r0, r9)     // Catch: java.lang.Throwable -> L5d
            if (r8 == 0) goto L5c
        L59:
            r8.close()
        L5c:
            return r1
        L5d:
            r9 = move-exception
            r1 = r8
            r8 = r9
        L60:
            if (r1 == 0) goto L65
            r1.close()
        L65:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: health.compact.a.DataAccessLayer.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private static Uri bYm_(String str) {
        return Uri.parse(new StringBuffer().append(f13735a).append(str).toString());
    }
}
