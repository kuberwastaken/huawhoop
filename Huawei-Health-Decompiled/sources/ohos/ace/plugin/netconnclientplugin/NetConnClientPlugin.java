package ohos.ace.plugin.netconnclientplugin;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class NetConnClientPlugin {
    private static final String LOG_TAG = "NetConnClientPlugin";
    private ConnectivityManager connectivity;
    private Map<Long, NetworkCallbackImpl> observer = new HashMap();

    protected native void nativeInit();

    protected native void nativeOnAvailable(long j, int i);

    protected native void nativeOnCapabilitiesChanged(NetworkCapabilities networkCapabilities, long j, int i);

    protected native void nativeOnLost(long j, int i);

    protected native void nativeOnUnavailable(long j);

    public NetConnClientPlugin(Context context) {
        new NetConnClientPlugin(context, true);
    }

    public NetConnClientPlugin(Context context, boolean z) {
        if (context != null) {
            Object systemService = context.getSystemService("connectivity");
            if (systemService instanceof ConnectivityManager) {
                this.connectivity = (ConnectivityManager) systemService;
                Log.i(LOG_TAG, "enable to get ConnectivityManager service");
            } else {
                Log.e(LOG_TAG, "unable to get ConnectivityManager service");
                this.connectivity = null;
            }
        } else {
            Log.e(LOG_TAG, "context is null");
            this.connectivity = null;
        }
        if (z) {
            nativeInit();
        }
    }

    public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
        public NetworkCallbackImpl() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            NetConnClientPlugin.this.nativeOnAvailable(NetConnClientPlugin.this.getCallbackKey(this), getNetworkId(network));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            NetConnClientPlugin.this.nativeOnUnavailable(NetConnClientPlugin.this.getCallbackKey(this));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            NetConnClientPlugin.this.nativeOnLost(NetConnClientPlugin.this.getCallbackKey(this), getNetworkId(network));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            NetConnClientPlugin.this.nativeOnCapabilitiesChanged(networkCapabilities, NetConnClientPlugin.this.getCallbackKey(this), getNetworkId(network));
        }

        private int getNetworkId(Network network) {
            try {
                Method method = Network.class.getMethod("getNetId", new Class[0]);
                if (method == null) {
                    Log.e(NetConnClientPlugin.LOG_TAG, "getNetId method is null");
                    return 0;
                }
                Object objInvoke = method.invoke(network, new Object[0]);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
                return 0;
            } catch (IllegalAccessException | NoSuchMethodError | NoSuchMethodException | InvocationTargetException unused) {
                Log.e(NetConnClientPlugin.LOG_TAG, "NoSuchMethodError");
                return 0;
            }
        }
    }

    public void registerDefaultNetConnCallback(long j) {
        if (this.observer.get(Long.valueOf(j)) != null) {
            return;
        }
        NetworkCallbackImpl networkCallbackImpl = new NetworkCallbackImpl();
        this.connectivity.registerDefaultNetworkCallback(networkCallbackImpl);
        this.observer.put(Long.valueOf(j), networkCallbackImpl);
        if (this.connectivity.getActiveNetwork() == null) {
            networkCallbackImpl.onUnavailable();
        }
    }

    public void registerNetConnCallback(long j, int[] iArr) {
        if (this.observer.get(Long.valueOf(j)) != null) {
            return;
        }
        NetworkCallbackImpl networkCallbackImpl = new NetworkCallbackImpl();
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i : iArr) {
            builder = builder.addTransportType(i);
        }
        this.connectivity.registerNetworkCallback(builder.build(), networkCallbackImpl);
        this.observer.put(Long.valueOf(j), networkCallbackImpl);
        Network activeNetwork = this.connectivity.getActiveNetwork();
        if (activeNetwork == null) {
            networkCallbackImpl.onUnavailable();
            return;
        }
        NetworkCapabilities networkCapabilities = this.connectivity.getNetworkCapabilities(activeNetwork);
        boolean z = true;
        for (int i2 : iArr) {
            if (networkCapabilities.hasTransport(i2)) {
                z = false;
            }
        }
        if (z) {
            networkCallbackImpl.onUnavailable();
        }
    }

    public void unregisterNetConnCallback(long j) {
        NetworkCallbackImpl networkCallbackImpl = this.observer.get(Long.valueOf(j));
        if (networkCallbackImpl != null) {
            this.observer.remove(Long.valueOf(j));
        }
        this.connectivity.unregisterNetworkCallback(networkCallbackImpl);
    }

    public boolean isDefaultNetworkActive() {
        return this.connectivity.getActiveNetwork() != null;
    }

    public long getCallbackKey(NetworkCallbackImpl networkCallbackImpl) {
        Iterator<Long> it = this.observer.keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (this.observer.get(Long.valueOf(jLongValue)) == networkCallbackImpl) {
                Log.i("LOG_TAG", "getCallbackKey successfull!");
                return jLongValue;
            }
        }
        return 0L;
    }
}
