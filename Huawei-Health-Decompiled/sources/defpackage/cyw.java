package defpackage;

import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.pluginmgr.EzPluginConfigBase;

/* JADX INFO: loaded from: classes10.dex */
final class cyw extends EzPluginConfigBase {
    private final String b;
    private final String c;

    cyw(String str, String str2, boolean z) {
        super(str2);
        this.b = str;
        this.c = z ? "Beta_plugin_index_bundle_version" : "plugin_index_bundle_version";
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getPluginConfigId() {
        return this.b;
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getPluginQueryString(String str) {
        return "version=" + getVersion();
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getIndexFileFiled() {
        return this.c;
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getIndexSaveKey() {
        return "index_bundle_" + getVersion();
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getPluginSaveKey(String str) {
        return "appbundle-" + str + Constants.LINK + getVersion();
    }
}
