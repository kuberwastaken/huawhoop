package ohos.ace.adapter;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AceResourcePlugin {
    private IAceOnResourceEvent callback;
    protected AceResourceRegister resRegister = null;
    private final String tag;
    private final float version;

    public abstract long create(Map<String, String> map);

    public abstract Object getObject(long j);

    public void notifyLifecycleChanged(Boolean bool) {
    }

    public abstract void release();

    public abstract boolean release(long j);

    public AceResourcePlugin(String str, float f) {
        this.tag = str;
        this.version = f;
    }

    public void setEventCallback(AceResourceRegister aceResourceRegister, IAceOnResourceEvent iAceOnResourceEvent) {
        this.callback = iAceOnResourceEvent;
        this.resRegister = aceResourceRegister;
    }

    public IAceOnResourceEvent getEventCallback() {
        return this.callback;
    }

    public void registerCallMethod(String str, IAceOnCallResourceMethod iAceOnCallResourceMethod) {
        AceResourceRegister aceResourceRegister = this.resRegister;
        if (aceResourceRegister == null) {
            return;
        }
        aceResourceRegister.registerCallMethod(str, iAceOnCallResourceMethod);
    }

    public void registerCallMethod(Map<String, IAceOnCallResourceMethod> map) {
        if (this.resRegister == null) {
            return;
        }
        for (Map.Entry<String, IAceOnCallResourceMethod> entry : map.entrySet()) {
            this.resRegister.registerCallMethod(entry.getKey(), entry.getValue());
        }
    }

    public void unregisterCallMethod(String str) {
        AceResourceRegister aceResourceRegister = this.resRegister;
        if (aceResourceRegister == null) {
            return;
        }
        aceResourceRegister.unregisterCallMethod(str);
    }

    public void unregisterCallMethod(Map<String, IAceOnCallResourceMethod> map) {
        Iterator<Map.Entry<String, IAceOnCallResourceMethod>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.resRegister.unregisterCallMethod(it.next().getKey());
        }
    }

    public String pluginType() {
        return this.tag;
    }

    public float version() {
        return this.version;
    }
}
