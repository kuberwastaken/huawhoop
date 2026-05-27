package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* JADX INFO: loaded from: classes8.dex */
public class vyl {
    public static boolean b() {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) vvn.a().getSystemService("connectivity");
        } catch (RuntimeException unused) {
            vwc.b("BaseOverSeaUtil", "isNetworkConnected error Runtime");
        } catch (Exception unused2) {
            vwc.b("BaseOverSeaUtil", "isNetworkConnected error");
        }
        if (connectivityManager == null) {
            vwc.c("BaseOverSeaUtil", "isNetworkConnected has no ConnectivityManager");
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected()) || fwz_(connectivityManager);
    }

    private static boolean fwz_(ConnectivityManager connectivityManager) {
        vwc.c("BaseOverSeaUtil", "judgeNetAgain start");
        if (Build.VERSION.SDK_INT >= 29) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                vwc.c("BaseOverSeaUtil", "judgeNetAgain has no NetworkCapabilities");
                return false;
            }
            if (networkCapabilities.hasCapability(12)) {
                vwc.c("BaseOverSeaUtil", "judgeNetAgain true 12");
                return true;
            }
        }
        return false;
    }
}
