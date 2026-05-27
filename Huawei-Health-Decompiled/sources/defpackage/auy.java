package defpackage;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public class auy {
    public static boolean d(Context context) {
        try {
            return (e(context, "syncFeatureSwitch") & 32) == 32;
        } catch (Exception e) {
            avi.c("BaseQueryHwCloud", "isSupportSyncDownloadPartical error: " + e.toString());
            return false;
        }
    }

    public static int e(Context context, String str) {
        try {
            if (context == null) {
                avi.d("BaseQueryHwCloud", "getSyncFeature context is null");
                return 0;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                avi.d("BaseQueryHwCloud", "getSyncFeature packageManager is null");
                return 0;
            }
            int i = packageManager.getApplicationInfo("com.huawei.hidisk", 128).metaData.getInt(str, 0);
            avi.b("BaseQueryHwCloud", "getSyncFeature key: " + str + " value: " + i);
            return i;
        } catch (Exception e) {
            avi.c("BaseQueryHwCloud", "getSyncFeature error: " + e.toString());
            return 0;
        }
    }

    public static boolean e(Context context) {
        try {
            return (e(context, "syncFeatureSwitch") & 8) == 8;
        } catch (Exception e) {
            avi.c("BaseQueryHwCloud", "isSupportReportPrepare error: " + e.toString());
            return false;
        }
    }

    public static int c(Context context) {
        try {
            if (context == null) {
                avi.d("BaseQueryHwCloud", "getCloudMateDateVersionCode context is null");
                return 0;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                avi.d("BaseQueryHwCloud", "getCloudMateDateVersionCode packageManager is null");
                return 0;
            }
            int i = packageManager.getApplicationInfo("com.huawei.hidisk", 128).metaData.getInt("com.huawei.hicloud.ability.version", 0);
            avi.b("BaseQueryHwCloud", "metata ability.version: " + i);
            return i;
        } catch (Exception e) {
            avi.c("BaseQueryHwCloud", "getCloudMateDateVersionCode: " + e.toString());
            return 0;
        }
    }

    public static int ge_(String str, String str2, Context context, Uri uri) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        avi.b("BaseQueryHwCloud", "reportPreByProvider, syncType = " + str);
        if (context == null) {
            avi.c("BaseQueryHwCloud", "reportPreByProvider error: context is null");
            return 1;
        }
        if (TextUtils.isEmpty(str2)) {
            avi.c("BaseQueryHwCloud", "reportPreByProvider error: reportString is empty");
            return 1;
        }
        ContentProviderClient contentProviderClient = null;
        try {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    avi.c("BaseQueryHwCloud", "reportPreByProvider error: contentResolver is null");
                    return 1;
                }
                contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                try {
                    if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                        avi.c("BaseQueryHwCloud", "Query hiCloud Login status error: cpClient is null");
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                        }
                        return 1;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("report_param", str2);
                    contentResolver.call(uri, "reportPrepare", (String) null, bundle);
                    if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                        return 0;
                    }
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return 0;
                } catch (Exception e) {
                    e = e;
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                    avi.c("BaseQueryHwCloud", "reportPreByProvider error: " + e.getClass().getName());
                    if (contentProviderClient != null) {
                        contentProviderClient.release();
                    }
                    return 1;
                } catch (Throwable th) {
                    th = th;
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                contentProviderClientAcquireUnstableContentProviderClient = null;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
