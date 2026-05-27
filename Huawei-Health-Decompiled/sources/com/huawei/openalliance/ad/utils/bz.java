package com.huawei.openalliance.ad.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.primitives.UnsignedBytes;
import com.huawei.openalliance.ad.hq;
import com.huawei.openalliance.ad.xt;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes6.dex */
public class bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7931a = null;
    private static String b = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, IBinder iBinder) {
        String packageName = context.getPackageName();
        if (f7931a == null) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & UnsignedBytes.MAX_VALUE) | 256).substring(1, 3));
                }
                String string = sb.toString();
                f7931a = string;
                return a(iBinder, packageName, string);
            } catch (Throwable th) {
                hq.c("OIdentifierManager", "realGetOUID ex: %s", th.getClass().getSimpleName());
            }
        }
        return a(iBinder, packageName, f7931a);
    }

    private static String a(IBinder iBinder, String str, String str2) {
        try {
            xt xtVar = (xt) xt.a.class.getDeclaredMethod("a", IBinder.class).invoke(null, iBinder);
            if (xtVar == null) {
                hq.c("OIdentifierManager", "IOpenID is null");
            }
            return xtVar.a(str, str2, "OUID");
        } catch (Throwable th) {
            hq.c("OIdentifierManager", "getSerId error: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public static String a(final Context context) {
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        try {
            if (!context.bindService(intent, new ServiceConnection() { // from class: com.huawei.openalliance.ad.utils.bz.1
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    hq.b("OIdentifierManager", "HeyTap IdentifyService disconnected");
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    hq.b("OIdentifierManager", "HeyTap IdentifyService connected");
                    try {
                        String strB = bz.b(context, iBinder);
                        if (strB == null || strB.length() == 0) {
                            hq.c("OIdentifierManager", "HeyTap OUID get failed");
                        } else {
                            String unused = bz.b = strB;
                        }
                        try {
                            context.unbindService(this);
                        } catch (Throwable th) {
                            hq.c("OIdentifierManager", "HeyTap IdentifyService, unbind service error: %s", th.getClass().getSimpleName());
                        }
                    } catch (Throwable th2) {
                        try {
                            hq.c("OIdentifierManager", "HeyTap IdentifyService, bind service error: %s", th2.getClass().getSimpleName());
                            try {
                                context.unbindService(this);
                            } catch (Throwable th3) {
                                hq.c("OIdentifierManager", "HeyTap IdentifyService, unbind service error: %s", th3.getClass().getSimpleName());
                            }
                        } catch (Throwable th4) {
                            try {
                                context.unbindService(this);
                            } catch (Throwable th5) {
                                hq.c("OIdentifierManager", "HeyTap IdentifyService, unbind service error: %s", th5.getClass().getSimpleName());
                            }
                            throw th4;
                        }
                    }
                }
            }, 1)) {
                hq.c("OIdentifierManager", "HeyTap IdentifyService bind failed");
            }
        } catch (Throwable th) {
            hq.c("OIdentifierManager", "get oaid error: %s", th.getClass().getSimpleName());
        }
        return b;
    }
}
