package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class nnp {
    private static volatile boolean b = true;

    public static Pair<Boolean, String> e(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context == null) {
            sb.append("isNetworkAvailable: context is null.");
            nni.e("NetWorkUtil", "isNetworkAvailable: context is null.");
            b = false;
            return new Pair<>(Boolean.valueOf(b), sb.toString());
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                sb.append('|');
                sb.append("Network no Available: ConnectivityManager is null.");
                nni.e("NetWorkUtil", "Network no Available: ConnectivityManager is null.");
                b = false;
                return new Pair<>(Boolean.valueOf(b), sb.toString());
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                sb.append('|');
                sb.append("Network no Available: ActiveNetwork is null.");
                nni.e("NetWorkUtil", "Network no Available: ActiveNetwork is null.");
                b = false;
                return new Pair<>(Boolean.valueOf(b), sb.toString());
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                sb.append('|');
                sb.append("Network no Available: NetworkCapabilities is null.");
                nni.e("NetWorkUtil", "Network no Available: NetworkCapabilities is null.");
                b = false;
                return new Pair<>(Boolean.valueOf(b), sb.toString());
            }
            if (networkCapabilities.hasCapability(16)) {
                b = true;
                return new Pair<>(Boolean.valueOf(b), sb.toString());
            }
            sb.append('|');
            sb.append("Network not has capability.");
            nni.e("NetWorkUtil", "Network not has capability.");
            b = connectivityManager.isDefaultNetworkActive();
            return new Pair<>(Boolean.valueOf(b), sb.toString());
        } catch (IncompatibleClassChangeError e) {
            String str = "isNetworkAvailable IncompatibleClassChangeError " + nni.d(e);
            sb.append('|');
            sb.append(str);
            nni.b("NetWorkUtil", str);
            b = false;
            return new Pair<>(Boolean.valueOf(b), sb.toString());
        } catch (SecurityException e2) {
            String str2 = "isNetworkAvailable SecurityException " + nni.d(e2);
            sb.append('|');
            sb.append(str2);
            nni.b("NetWorkUtil", str2);
            b = false;
            return new Pair<>(Boolean.valueOf(b), sb.toString());
        }
    }

    public static boolean b(Context context) {
        Boolean bool = e(context).first;
        return bool != null && bool.booleanValue();
    }
}
