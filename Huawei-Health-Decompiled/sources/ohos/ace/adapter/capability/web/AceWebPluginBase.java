package ohos.ace.adapter.capability.web;

import android.webkit.WebBackForwardList;
import com.huawei.openalliance.ad.constant.ClickDestination;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import ohos.ace.adapter.AceResourcePlugin;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AceWebPluginBase extends AceResourcePlugin {
    private static final int CAN_NOT_POST_MESSAGE = 17100010;
    private static final int CAN_NOT_REGISTER_MESSAGE_EVENT = 17100006;
    private static final String LOG_TAG = "AceWebPluginBase";
    private static boolean hasInit = false;
    private static Map<Long, AceWebBase> objectMap;
    private final AtomicLong nextWebId;

    protected static native void onBeforeDownloadObject(long j, Object obj);

    protected static native void onDownloadFailedObject(long j, Object obj);

    protected static native void onDownloadFinishObject(long j, Object obj);

    protected static native void onDownloadUpdatedObject(long j, Object obj);

    protected static native void onMessage(long j, String str, String str2);

    protected static native void onMessageEventExt(long j, String str, String str2);

    protected static native Object onReceiveJavascriptExecuteCall(String str, String str2, Object[] objArr);

    protected static native void onReceiveRunJavaScriptExtValue(String str, long j);

    protected static native void onReceiveValue(String str, long j);

    @Override // ohos.ace.adapter.AceResourcePlugin
    public abstract long create(Map<String, String> map);

    protected native void nativeInit();

    protected native void nativeInitStatic();

    protected native void nativeInitWebDataBase();

    protected native void nativeInitWebDownloadItem();

    public AceWebPluginBase() {
        super(ClickDestination.WEB, 1.0f);
        this.nextWebId = new AtomicLong(0L);
        objectMap = new HashMap();
    }

    public long getAtomicId() {
        return this.nextWebId.getAndIncrement();
    }

    public void addResource(long j, AceWebBase aceWebBase, boolean z) {
        objectMap.put(Long.valueOf(j), aceWebBase);
        registerCallMethod(aceWebBase.getCallMethod());
        if (hasInit || z) {
            return;
        }
        nativeInit();
        nativeInitWebDataBase();
        nativeInitWebDownloadItem();
        hasInit = true;
    }

    public void addResourceStatic(boolean z) {
        if (z) {
            return;
        }
        nativeInitStatic();
    }

    @Override // ohos.ace.adapter.AceResourcePlugin
    public Object getObject(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            return objectMap.get(Long.valueOf(j));
        }
        return null;
    }

    public static Map<Long, AceWebBase> getObjectMap() {
        return objectMap;
    }

    public void onActivityResume() {
        Iterator<Map.Entry<Long, AceWebBase>> it = objectMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onActivityResume();
        }
    }

    public void onActivityPause() {
        Iterator<Map.Entry<Long, AceWebBase>> it = objectMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onActivityPause();
        }
    }

    @Override // ohos.ace.adapter.AceResourcePlugin
    public boolean release(long j) {
        if (!objectMap.containsKey(Long.valueOf(j))) {
            return false;
        }
        AceWebBase aceWebBase = objectMap.get(Long.valueOf(j));
        unregisterCallMethod(aceWebBase.getCallMethod());
        aceWebBase.release();
        objectMap.remove(Long.valueOf(j));
        return true;
    }

    @Override // ohos.ace.adapter.AceResourcePlugin
    public void release() {
        Iterator<Map.Entry<Long, AceWebBase>> it = objectMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().release();
        }
    }

    public void loadUrl(long j, String str, HashMap<String, String> map) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).loadUrl(str, map);
        }
    }

    public void loadData(long j, HashMap<String, String> map) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).m1415lambda$callMethodMapPutLoadMethod$20$ohosaceadaptercapabilitywebAceWebBase(map);
        }
    }

    public String getUrl(long j) {
        return objectMap.containsKey(Long.valueOf(j)) ? objectMap.get(Long.valueOf(j)).getUrl() : "";
    }

    public String accessForward(long j) {
        if (!objectMap.containsKey(Long.valueOf(j))) {
            return "";
        }
        return objectMap.get(Long.valueOf(j)).m1430lambda$callMethodMapPutXWardMethod$17$ohosaceadaptercapabilitywebAceWebBase(new HashMap());
    }

    public void forward(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).m1428lambda$callMethodMapPutXWardMethod$15$ohosaceadaptercapabilitywebAceWebBase(new HashMap());
        }
    }

    public String accessBackward(long j) {
        if (!objectMap.containsKey(Long.valueOf(j))) {
            return "";
        }
        return objectMap.get(Long.valueOf(j)).m1429lambda$callMethodMapPutXWardMethod$16$ohosaceadaptercapabilitywebAceWebBase(new HashMap());
    }

    public void backward(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).m1427lambda$callMethodMapPutXWardMethod$14$ohosaceadaptercapabilitywebAceWebBase(new HashMap());
        }
    }

    public void refresh(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).m1417lambda$callMethodMapPutLoadMethod$22$ohosaceadaptercapabilitywebAceWebBase(new HashMap());
        }
    }

    public void evaluateJavascript(long j, String str, long j2) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).evaluateJavascript(str, j2);
        }
    }

    public void evaluateJavascriptExt(long j, String str, long j2) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).evaluateJavascriptExt(str, j2);
        }
    }

    public WebBackForwardList getBackForwardEntries(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            return objectMap.get(Long.valueOf(j)).getBackForwardEntries();
        }
        return null;
    }

    public void removeCache(long j, boolean z) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).clearCache(z);
        }
    }

    public void pageDown(long j, boolean z) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).pageDown(z);
        }
    }

    public void postUrl(long j, String str, byte[] bArr) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).postUrl(str, bArr);
        }
    }

    public void backOrForward(long j, int i) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).goBackOrForward(i);
        }
    }

    public String getTitle(long j) {
        return objectMap.containsKey(Long.valueOf(j)) ? objectMap.get(Long.valueOf(j)).getTitle() : "";
    }

    public int getPageHeight(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            return objectMap.get(Long.valueOf(j)).getContentHeight();
        }
        return -1;
    }

    public String accessStep(long j, int i) {
        if (!objectMap.containsKey(Long.valueOf(j))) {
            return "";
        }
        HashMap map = new HashMap();
        map.put("accessStep", Integer.toString(i));
        return objectMap.get(Long.valueOf(j)).m1416lambda$callMethodMapPutLoadMethod$21$ohosaceadaptercapabilitywebAceWebBase(map);
    }

    public void scrollTo(long j, int i, int i2) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            HashMap map = new HashMap();
            map.put("scroll_to_x", Integer.toString(i));
            map.put("scroll_to_y", Integer.toString(i2));
            objectMap.get(Long.valueOf(j)).scrollTo(map);
        }
    }

    public void scrollBy(long j, int i, int i2) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            HashMap map = new HashMap();
            map.put("scroll_by_deltax", Integer.toString(i));
            map.put("scroll_by_deltay", Integer.toString(i2));
            objectMap.get(Long.valueOf(j)).scrollBy(map);
        }
    }

    public void zoom(long j, float f) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            HashMap map = new HashMap();
            map.put("zoom_factor", Float.toString(f));
            objectMap.get(Long.valueOf(j)).m1419lambda$callMethodMapPutLoadMethod$24$ohosaceadaptercapabilitywebAceWebBase(map);
        }
    }

    public void zoomIn(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).zoomIn();
        }
    }

    public void zoomOut(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).zoomOut();
        }
    }

    public void stop(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).m1418lambda$callMethodMapPutLoadMethod$23$ohosaceadaptercapabilitywebAceWebBase(new HashMap());
        }
    }

    public String getOriginalUrl(long j) {
        return objectMap.containsKey(Long.valueOf(j)) ? objectMap.get(Long.valueOf(j)).getOriginalUrl() : "";
    }

    public void pageUp(long j, boolean z) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).pageUp(z);
        }
    }

    public void clearHistory(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).m1421lambda$callMethodMapPutPageChange$28$ohosaceadaptercapabilitywebAceWebBase(new HashMap());
        }
    }

    public void setCustomUserAgent(long j, String str) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).setUserAgentString(str);
        }
    }

    public String getCustomUserAgent(long j) {
        return objectMap.containsKey(Long.valueOf(j)) ? objectMap.get(Long.valueOf(j)).getUserAgentString() : "";
    }

    @Override // ohos.ace.adapter.AceResourcePlugin
    public void notifyLifecycleChanged(Boolean bool) {
        if (bool.booleanValue()) {
            onActivityPause();
        } else {
            onActivityResume();
        }
    }

    public String[] createWebMessagePorts(long j) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            return objectMap.get(Long.valueOf(j)).createWebMessagePorts();
        }
        return new String[]{"", ""};
    }

    public void postWebMessage(long j, String str, String[] strArr, String str2) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).postWebMessage(str, strArr, str2);
        }
    }

    public void closeWebMessagePort(long j, String str) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).closeWebMessagePort(str);
        }
    }

    public int postMessageEvent(long j, String str, String str2) {
        return objectMap.containsKey(Long.valueOf(j)) ? objectMap.get(Long.valueOf(j)).postMessageEvent(str, str2) : CAN_NOT_POST_MESSAGE;
    }

    public int postMessageEventExt(long j, String str, String str2) {
        return objectMap.containsKey(Long.valueOf(j)) ? objectMap.get(Long.valueOf(j)).postMessageEventExt(str, str2) : CAN_NOT_POST_MESSAGE;
    }

    public int onWebMessagePortEvent(long j, String str) {
        return objectMap.containsKey(Long.valueOf(j)) ? objectMap.get(Long.valueOf(j)).onWebMessagePortEvent(j, str) : CAN_NOT_REGISTER_MESSAGE_EVENT;
    }

    public void startDownload(long j, String str) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).startDownload(j, str);
        }
    }

    public void start(long j, String str, String str2) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).start(j, str, str2);
        }
    }

    public void cancel(long j, String str) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).cancel(j, str);
        }
    }

    public int onWebMessagePortEventExt(long j, String str) {
        return objectMap.containsKey(Long.valueOf(j)) ? objectMap.get(Long.valueOf(j)).onWebMessagePortEventExt(j, str) : CAN_NOT_REGISTER_MESSAGE_EVENT;
    }

    public void registerJavaScriptProxy(long j, String str, String[] strArr, String[] strArr2, String str2) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).registerJavaScriptProxy(str, strArr, strArr2, str2);
        }
    }

    public void deleteJavaScriptRegister(long j, String str) {
        if (objectMap.containsKey(Long.valueOf(j))) {
            objectMap.get(Long.valueOf(j)).deleteJavaScriptRegister(str);
        }
    }
}
