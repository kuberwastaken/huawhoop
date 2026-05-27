package ohos.ace.adapter;

import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public interface IPluginRegistry {
    IArkUIXPlugin getPlugin(String str);

    boolean hasPlugin(String str);

    void registryPlugin(String str);

    void registryPlugins(Set<String> set);

    void unRegistryAllPlugins();

    void unRegistryPlugin(String str);

    void unRegistryPlugins(Set<String> set);
}
