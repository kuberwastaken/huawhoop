package com.huawei.haf.common.utils;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import health.compact.a.CommonUtils;
import health.compact.a.LogUtil;
import health.compact.a.ReleaseLogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkUtil {
    private static volatile Boolean b;
    private static volatile Boolean c;
    private static volatile Boolean e;
    private static volatile Boolean f;
    private static volatile Boolean g;
    private static volatile ConnectivityManager.NetworkCallback j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<ConnectivityManager.NetworkCallback, Object> f2143a = new WeakHashMap<>();
    private static ConnectivityManager d = CommonUtils.ze_();

    static {
        l();
    }

    private NetworkUtil() {
    }

    public static void zo_(ConnectivityManager.NetworkCallback networkCallback) {
        if (networkCallback == null) {
            return;
        }
        WeakHashMap<ConnectivityManager.NetworkCallback, Object> weakHashMap = f2143a;
        synchronized (weakHashMap) {
            RuntimeException runtimeExceptionL = l();
            if (runtimeExceptionL != null) {
                throw runtimeExceptionL;
            }
            weakHashMap.put(networkCallback, Boolean.TRUE);
            LogUtil.a("HAF_NetworkUtil", "registerNetworkCallback size=", Integer.valueOf(weakHashMap.size()));
        }
    }

    public static void zp_(ConnectivityManager.NetworkCallback networkCallback) {
        if (networkCallback == null) {
            return;
        }
        WeakHashMap<ConnectivityManager.NetworkCallback, Object> weakHashMap = f2143a;
        synchronized (weakHashMap) {
            weakHashMap.remove(networkCallback);
        }
    }

    public static boolean g() {
        return i() || n() || j() || m();
    }

    public static boolean f() {
        return g();
    }

    public static boolean i() {
        if (b != null) {
            return b.booleanValue();
        }
        try {
            ConnectivityManager connectivityManager = d;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                if (networkCapabilities.hasTransport(0)) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e2) {
            ReleaseLogUtil.a("HAF_NetworkUtil", "isMobileConnected getNetworkCapabilities fail: ", LogUtil.c(e2));
            NetworkInfo activeNetworkInfo = d.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
        }
    }

    public static boolean n() {
        if (g != null) {
            return g.booleanValue();
        }
        try {
            ConnectivityManager connectivityManager = d;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return networkCapabilities.hasTransport(1);
        } catch (SecurityException e2) {
            ReleaseLogUtil.a("HAF_NetworkUtil", "isWifiConnected getNetworkCapabilities fail: ", LogUtil.c(e2));
            NetworkInfo activeNetworkInfo = d.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        }
    }

    public static boolean j() {
        if (f != null) {
            return f.booleanValue();
        }
        try {
            ConnectivityManager connectivityManager = d;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return networkCapabilities.hasTransport(4);
        } catch (SecurityException e2) {
            ReleaseLogUtil.a("HAF_NetworkUtil", "isVpnConnected getNetworkCapabilities fail: ", LogUtil.c(e2));
            NetworkInfo activeNetworkInfo = d.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 17;
        }
    }

    private static boolean m() {
        if (e != null) {
            return e.booleanValue();
        }
        try {
            ConnectivityManager connectivityManager = d;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return zm_(networkCapabilities);
        } catch (SecurityException e2) {
            ReleaseLogUtil.a("HAF_NetworkUtil", "isOtherConnected getNetworkCapabilities fail: ", LogUtil.c(e2));
            NetworkInfo activeNetworkInfo = d.getActiveNetworkInfo();
            return activeNetworkInfo != null && zn_(activeNetworkInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zm_(NetworkCapabilities networkCapabilities) {
        boolean z = true;
        boolean z2 = networkCapabilities.hasTransport(2) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(5);
        if (Build.VERSION.SDK_INT < 27) {
            return z2;
        }
        if (!z2 && !networkCapabilities.hasTransport(6)) {
            z = false;
        }
        return z;
    }

    private static boolean zn_(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 6 || type == 7 || type == 9 || type == 8 || type == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<ConnectivityManager.NetworkCallback> o() {
        List<ConnectivityManager.NetworkCallback> arrayList = Collections.EMPTY_LIST;
        WeakHashMap<ConnectivityManager.NetworkCallback, Object> weakHashMap = f2143a;
        synchronized (weakHashMap) {
            if (!weakHashMap.isEmpty()) {
                arrayList = new ArrayList<>(weakHashMap.keySet());
            }
        }
        return arrayList;
    }

    private static RuntimeException l() {
        if (j != null) {
            return null;
        }
        try {
            NetworkCallbackAdpter networkCallbackAdpter = new NetworkCallbackAdpter();
            d.registerDefaultNetworkCallback(networkCallbackAdpter);
            j = networkCallbackAdpter;
            ReleaseLogUtil.d("HAF_NetworkUtil", "registerDefaultNetworkCallback is success.");
            return null;
        } catch (Exception e2) {
            ReleaseLogUtil.d("HAF_NetworkUtil", "registerDefaultNetworkCallback fail, downgrade process, ex=", LogUtil.c(e2));
            if (e2 instanceof RuntimeException) {
                return (RuntimeException) e2;
            }
            return null;
        }
    }

    static class NetworkCallbackAdpter extends ConnectivityManager.NetworkCallback {
        private NetworkCallbackAdpter() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            Iterator it = NetworkUtil.o().iterator();
            while (it.hasNext()) {
                ((ConnectivityManager.NetworkCallback) it.next()).onAvailable(network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            super.onLosing(network, i);
            Iterator it = NetworkUtil.o().iterator();
            while (it.hasNext()) {
                ((ConnectivityManager.NetworkCallback) it.next()).onLosing(network, i);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            zr_(network);
            Iterator it = NetworkUtil.o().iterator();
            while (it.hasNext()) {
                ((ConnectivityManager.NetworkCallback) it.next()).onLost(network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            Iterator it = NetworkUtil.o().iterator();
            while (it.hasNext()) {
                ((ConnectivityManager.NetworkCallback) it.next()).onUnavailable();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            zq_(network, networkCapabilities);
            Iterator it = NetworkUtil.o().iterator();
            while (it.hasNext()) {
                ((ConnectivityManager.NetworkCallback) it.next()).onCapabilitiesChanged(network, networkCapabilities);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            super.onLinkPropertiesChanged(network, linkProperties);
            Iterator it = NetworkUtil.o().iterator();
            while (it.hasNext()) {
                ((ConnectivityManager.NetworkCallback) it.next()).onLinkPropertiesChanged(network, linkProperties);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z) {
            super.onBlockedStatusChanged(network, z);
            if (Build.VERSION.SDK_INT >= 29) {
                Iterator it = NetworkUtil.o().iterator();
                while (it.hasNext()) {
                    ((ConnectivityManager.NetworkCallback) it.next()).onBlockedStatusChanged(network, z);
                }
            }
        }

        private void zq_(Network network, NetworkCapabilities networkCapabilities) {
            Boolean bool = NetworkUtil.b;
            Boolean unused = NetworkUtil.b = Boolean.valueOf(networkCapabilities.hasTransport(0));
            boolean z = !NetworkUtil.b.equals(bool);
            Boolean bool2 = NetworkUtil.g;
            Boolean unused2 = NetworkUtil.g = Boolean.valueOf(networkCapabilities.hasTransport(1));
            boolean z2 = z || !NetworkUtil.g.equals(bool2);
            Boolean bool3 = NetworkUtil.f;
            Boolean unused3 = NetworkUtil.f = Boolean.valueOf(networkCapabilities.hasTransport(4));
            boolean z3 = z2 || !NetworkUtil.f.equals(bool3);
            Boolean bool4 = NetworkUtil.e;
            Boolean unused4 = NetworkUtil.e = Boolean.valueOf(NetworkUtil.zm_(networkCapabilities));
            boolean z4 = z3 || !NetworkUtil.e.equals(bool4);
            Boolean bool5 = NetworkUtil.c;
            Boolean unused5 = NetworkUtil.c = Boolean.valueOf(networkCapabilities.hasCapability(16));
            if (z4 || !NetworkUtil.c.equals(bool5)) {
                ReleaseLogUtil.d("HAF_NetworkUtil", "network available: mobile=", NetworkUtil.b, ", wifi=", NetworkUtil.g, ", vpn=", NetworkUtil.f, ", other=", NetworkUtil.e, ", network=", network, ", internet=", Boolean.valueOf(networkCapabilities.hasCapability(12)), ", validated=", NetworkUtil.c);
            }
        }

        private void zr_(Network network) {
            ReleaseLogUtil.d("HAF_NetworkUtil", "network lost: network=", network);
            Boolean unused = NetworkUtil.b = false;
            Boolean unused2 = NetworkUtil.g = false;
            Boolean unused3 = NetworkUtil.f = false;
            Boolean unused4 = NetworkUtil.e = false;
            Boolean unused5 = NetworkUtil.c = false;
        }
    }
}
