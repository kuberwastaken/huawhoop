package ohos.ace.adapter;

import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class ArkUIXPluginRegistry implements IPluginRegistry {
    private static final String LOG_TAG = "ArkUIXPluginRegistry";
    private PluginContext pluginContext;
    private Map<String, IArkUIXPlugin> pluginMap = new ConcurrentHashMap();

    public ArkUIXPluginRegistry(PluginContext pluginContext) {
        this.pluginContext = pluginContext;
    }

    @Override // ohos.ace.adapter.IPluginRegistry
    public void registryPlugin(String str) {
        Log.d(LOG_TAG, "registry plugin: " + str);
        try {
            Class<?> cls = Class.forName(str);
            try {
                if (hasPlugin(str)) {
                    Log.e(LOG_TAG, "plugin:" + str + "already registered");
                } else {
                    IArkUIXPlugin iArkUIXPlugin = (IArkUIXPlugin) cls.newInstance();
                    this.pluginMap.put(str, iArkUIXPlugin);
                    iArkUIXPlugin.onRegistry(this.pluginContext);
                    Log.d(LOG_TAG, "plugin: " + str + "is successfully registered");
                }
            } catch (IllegalAccessException e) {
                Log.e(LOG_TAG, "registry plugin fail: " + e.getMessage());
            } catch (InstantiationException e2) {
                Log.e(LOG_TAG, "registry plugin fail: " + e2.getMessage());
            }
        } catch (ClassNotFoundException e3) {
            Log.e(LOG_TAG, "pluginClass do not found: " + e3.getMessage());
        }
    }

    @Override // ohos.ace.adapter.IPluginRegistry
    public void registryPlugins(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            registryPlugin(it.next());
        }
    }

    @Override // ohos.ace.adapter.IPluginRegistry
    public void unRegistryPlugin(String str) {
        IArkUIXPlugin iArkUIXPlugin = this.pluginMap.get(str);
        if (iArkUIXPlugin != null) {
            Log.d(LOG_TAG, "unregistry plugin: " + str);
            iArkUIXPlugin.onUnRegistry(this.pluginContext);
            this.pluginMap.remove(str);
        }
    }

    @Override // ohos.ace.adapter.IPluginRegistry
    public void unRegistryPlugins(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            unRegistryPlugin(it.next());
        }
    }

    @Override // ohos.ace.adapter.IPluginRegistry
    public void unRegistryAllPlugins() {
        unRegistryPlugins(new HashSet(this.pluginMap.keySet()));
        this.pluginMap.clear();
    }

    @Override // ohos.ace.adapter.IPluginRegistry
    public boolean hasPlugin(String str) {
        return this.pluginMap.containsKey(str);
    }

    @Override // ohos.ace.adapter.IPluginRegistry
    public IArkUIXPlugin getPlugin(String str) {
        if (hasPlugin(str)) {
            return this.pluginMap.get(str);
        }
        Log.e(LOG_TAG, "get plugin: " + str + " failed!");
        return null;
    }
}
