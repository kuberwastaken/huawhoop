package ohos.ace.adapter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class AceResourceRegister {
    private static final String LOG_TAG = "AceResourceRegister";
    private static final String PARAM_AND = "#HWJS-&-#";
    private static final String PARAM_AT = "@";
    private static final String PARMA_EQUALS = "#HWJS-=-#";
    private static final int SPLIT_COUNT = 2;
    private long aceRegisterPtr;
    AceResourceRegister self = this;
    private Map<String, AceResourcePlugin> pluginMap = new HashMap();
    private Map<String, IAceOnCallResourceMethod> callMethodMap = new HashMap();
    private IAceOnResourceEvent callbackHandler = new IAceOnResourceEvent() { // from class: ohos.ace.adapter.AceResourceRegister.1
        @Override // ohos.ace.adapter.IAceOnResourceEvent
        public void onEvent(String str, String str2) {
            AceResourceRegister.this.self.onEvent(str, str2);
        }
    };

    private native void nativeOnEvent(long j, String str, String str2);

    public Map<String, AceResourcePlugin> getPluginMap() {
        return this.pluginMap;
    }

    public void registerPlugin(AceResourcePlugin aceResourcePlugin) {
        if (aceResourcePlugin == null) {
            ALog.e(LOG_TAG, "null plugin");
            return;
        }
        if (this.pluginMap.containsKey(aceResourcePlugin.pluginType())) {
            if (aceResourcePlugin.version() <= this.pluginMap.get(aceResourcePlugin.pluginType()).version()) {
                return;
            }
        }
        ALog.i(LOG_TAG, "register plugin " + aceResourcePlugin.pluginType());
        this.pluginMap.put(aceResourcePlugin.pluginType(), aceResourcePlugin);
        aceResourcePlugin.setEventCallback(this, this.callbackHandler);
    }

    public void setRegisterPtr(long j) {
        this.aceRegisterPtr = j;
    }

    public long createResource(String str, String str2) {
        ALog.i(LOG_TAG, "createResource " + str + " called");
        if (!this.pluginMap.containsKey(str)) {
            return -1L;
        }
        AceResourcePlugin aceResourcePlugin = this.pluginMap.get(str);
        if (aceResourcePlugin != null) {
            return aceResourcePlugin.create(buildParamMap(str2));
        }
        ALog.e(LOG_TAG, "createResource " + str + " failed!");
        return -1L;
    }

    public boolean releaseResource(String str) {
        AceResourcePlugin aceResourcePlugin;
        try {
            String[] strArrSplit = str.split(PARAM_AT);
            if (strArrSplit.length == 2 && this.pluginMap.containsKey(strArrSplit[0]) && (aceResourcePlugin = this.pluginMap.get(strArrSplit[0])) != null) {
                return aceResourcePlugin.release(Long.parseLong(strArrSplit[1]));
            }
        } catch (NumberFormatException unused) {
            ALog.e(LOG_TAG, "Number format exception");
        }
        return false;
    }

    public Object getObject(String str) {
        AceResourcePlugin aceResourcePlugin;
        try {
            String[] strArrSplit = str.split(PARAM_AT);
            if (strArrSplit.length == 2 && this.pluginMap.containsKey(strArrSplit[0]) && (aceResourcePlugin = this.pluginMap.get(strArrSplit[0])) != null) {
                return aceResourcePlugin.getObject(Long.parseLong(strArrSplit[1]));
            }
            return null;
        } catch (NumberFormatException unused) {
            ALog.e(LOG_TAG, "Number format exception");
            return null;
        }
    }

    public Object getObject(String str, long j) {
        AceResourcePlugin aceResourcePlugin;
        if (!this.pluginMap.containsKey(str) || (aceResourcePlugin = this.pluginMap.get(str)) == null) {
            return null;
        }
        return aceResourcePlugin.getObject(j);
    }

    public void onEvent(String str, String str2) {
        long j = this.aceRegisterPtr;
        if (j != 0) {
            nativeOnEvent(j, str, str2);
        }
    }

    public String onCallMethod(String str, String str2) {
        IAceOnCallResourceMethod iAceOnCallResourceMethod = this.callMethodMap.containsKey(str) ? this.callMethodMap.get(str) : null;
        return iAceOnCallResourceMethod != null ? iAceOnCallResourceMethod.onCall(buildParamMap(str2)) : "no method found";
    }

    public void registerCallMethod(String str, IAceOnCallResourceMethod iAceOnCallResourceMethod) {
        this.callMethodMap.put(str, iAceOnCallResourceMethod);
    }

    public void unregisterCallMethod(String str) {
        this.callMethodMap.remove(str);
    }

    public void release() {
        Iterator<Map.Entry<String, AceResourcePlugin>> it = this.pluginMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().release();
        }
        this.pluginMap.clear();
        this.aceRegisterPtr = 0L;
    }

    public void notifyLifecycleChanged(Boolean bool) {
        Iterator<Map.Entry<String, AceResourcePlugin>> it = this.pluginMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().notifyLifecycleChanged(bool);
        }
    }

    private Map<String, String> buildParamMap(String str) {
        HashMap map = new HashMap();
        if (str != null && !str.isEmpty()) {
            for (String str2 : str.split(PARAM_AND)) {
                String[] strArrSplit = str2.split(PARMA_EQUALS);
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        return map;
    }
}
