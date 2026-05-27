package ohos.ace.adapter.capability.web;

import android.view.MotionEvent;
import android.webkit.WebBackForwardList;
import com.huawei.operation.utils.Constants;
import java.util.HashMap;
import java.util.Map;
import ohos.ace.adapter.ALog;
import ohos.ace.adapter.IAceOnCallResourceMethod;
import ohos.ace.adapter.IAceOnResourceEvent;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AceWebBase {
    private static final String EVENT = "event";
    private static final String LOG_TAG = "AceWebBase";
    private static final String METHOD = "method";
    private static final String PARAM_AND = "#HWJS-&-#";
    private static final String PARAM_BEGIN = "#HWJS-?-#";
    private static final String PARAM_EQUALS = "#HWJS-=-#";
    private static final String PARAM_NONE = "";
    private static final String PARAM_VALUE = "value";
    private static final String RESULT_FAIL = "fail";
    private static final String WEB_FLAG = "web@";
    private Map<String, IAceOnCallResourceMethod> callMethodMap = new HashMap();
    private final IAceOnResourceEvent callback;
    private final long id;

    private native void nativeOnObjectEvent(String str, String str2, Object obj);

    private native boolean nativeOnObjectEventWithBoolReturn(String str, String str2, Object obj);

    private native Object nativeOnObjectEventWithObjectReturn(String str, String str2, Object obj);

    /* JADX INFO: renamed from: accessBackward, reason: merged with bridge method [inline-methods] */
    public abstract String m1429lambda$callMethodMapPutXWardMethod$16$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: accessForward, reason: merged with bridge method [inline-methods] */
    public abstract String m1430lambda$callMethodMapPutXWardMethod$17$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: accessStep, reason: merged with bridge method [inline-methods] */
    public abstract String m1416lambda$callMethodMapPutLoadMethod$21$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: backgroundColor, reason: merged with bridge method [inline-methods] */
    public abstract String m1442lambda$callMethodMapWebAtrribute$5$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: backward, reason: merged with bridge method [inline-methods] */
    public abstract String m1427lambda$callMethodMapPutXWardMethod$14$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: blockNetwork, reason: merged with bridge method [inline-methods] */
    public abstract String m1446lambda$callMethodMapWebAtrribute$9$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: cacheMode, reason: merged with bridge method [inline-methods] */
    public abstract String m1437lambda$callMethodMapWebAtrribute$12$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract void cancel(long j, String str);

    /* JADX INFO: renamed from: changePageUrl, reason: merged with bridge method [inline-methods] */
    public abstract String m1425lambda$callMethodMapPutPageChange$32$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract void clearCache(boolean z);

    /* JADX INFO: renamed from: clearHistory, reason: merged with bridge method [inline-methods] */
    public abstract String m1421lambda$callMethodMapPutPageChange$28$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract void closeWebMessagePort(String str);

    public abstract String[] createWebMessagePorts();

    public abstract void deleteJavaScriptRegister(String str);

    /* JADX INFO: renamed from: domStorageAccess, reason: merged with bridge method [inline-methods] */
    public abstract String m1436lambda$callMethodMapWebAtrribute$11$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract void evaluateJavascript(String str, long j);

    public abstract void evaluateJavascriptExt(String str, long j);

    /* JADX INFO: renamed from: forward, reason: merged with bridge method [inline-methods] */
    public abstract String m1428lambda$callMethodMapPutXWardMethod$15$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: geolocationAccess, reason: merged with bridge method [inline-methods] */
    public abstract String m1445lambda$callMethodMapWebAtrribute$8$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract WebBackForwardList getBackForwardEntries();

    public abstract int getContentHeight();

    /* JADX INFO: renamed from: getHitTest, reason: merged with bridge method [inline-methods] */
    public abstract String m1420lambda$callMethodMapPutPageChange$27$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract String getOriginalUrl();

    public abstract String getTitle();

    public abstract String getUrl();

    public abstract String getUserAgentString();

    public abstract void goBackOrForward(int i);

    /* JADX INFO: renamed from: horizontalScrollBarAccess, reason: merged with bridge method [inline-methods] */
    public abstract String m1440lambda$callMethodMapWebAtrribute$3$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: imageAccess, reason: merged with bridge method [inline-methods] */
    public abstract String m1438lambda$callMethodMapWebAtrribute$13$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: javascriptAccess, reason: merged with bridge method [inline-methods] */
    public abstract String m1434lambda$callMethodMapWebAtrribute$1$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: loadData, reason: merged with bridge method [inline-methods] */
    public abstract String m1415lambda$callMethodMapPutLoadMethod$20$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract void loadUrl(String str, Map<String, String> map);

    /* JADX INFO: renamed from: mediaPlayGestureAccess, reason: merged with bridge method [inline-methods] */
    public abstract String m1443lambda$callMethodMapWebAtrribute$6$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: minFontSize, reason: merged with bridge method [inline-methods] */
    public abstract String m1439lambda$callMethodMapWebAtrribute$2$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: mixedMode, reason: merged with bridge method [inline-methods] */
    public abstract String m1435lambda$callMethodMapWebAtrribute$10$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: onActive, reason: merged with bridge method [inline-methods] */
    public abstract String m1431lambda$callMethodMapPutXactive$25$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract void onActivityPause();

    public abstract void onActivityResume();

    /* JADX INFO: renamed from: onInactive, reason: merged with bridge method [inline-methods] */
    public abstract String m1432lambda$callMethodMapPutXactive$26$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract int onWebMessagePortEvent(long j, String str);

    public abstract int onWebMessagePortEventExt(long j, String str);

    /* JADX INFO: renamed from: onlineImageAccess, reason: merged with bridge method [inline-methods] */
    public abstract String m1444lambda$callMethodMapWebAtrribute$7$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract String pageDown(boolean z);

    /* JADX INFO: renamed from: pagePathInvalid, reason: merged with bridge method [inline-methods] */
    public abstract String m1426lambda$callMethodMapPutPageChange$33$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract void pageUp(boolean z);

    public abstract int postMessageEvent(String str, String str2);

    public abstract int postMessageEventExt(String str, String str2);

    public abstract String postUrl(String str, byte[] bArr);

    public abstract void postWebMessage(String str, String[] strArr, String str2);

    public abstract void registerJavaScriptProxy(String str, String[] strArr, String[] strArr2, String str2);

    public abstract void release();

    /* JADX INFO: renamed from: reload, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract String m1417lambda$callMethodMapPutLoadMethod$22$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: requestFocus, reason: merged with bridge method [inline-methods] */
    public abstract String m1422lambda$callMethodMapPutPageChange$29$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: routerBack, reason: merged with bridge method [inline-methods] */
    public abstract String m1424lambda$callMethodMapPutPageChange$31$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract String scrollBy(Map<String, String> map);

    public abstract String scrollTo(Map<String, String> map);

    public abstract void setTouchEvent(MotionEvent motionEvent);

    public abstract void setUserAgentString(String str);

    public abstract void setWebDebuggingAccess(boolean z);

    public abstract void start(long j, String str, String str2);

    public abstract void startDownload(long j, String str);

    /* JADX INFO: renamed from: stopLoading, reason: merged with bridge method [inline-methods] */
    public abstract String m1418lambda$callMethodMapPutLoadMethod$23$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: touchCancel, reason: merged with bridge method [inline-methods] */
    public abstract String m1450lambda$callMethodMapWebPlugin$37$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: touchDown, reason: merged with bridge method [inline-methods] */
    public abstract String m1447lambda$callMethodMapWebPlugin$34$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: touchMove, reason: merged with bridge method [inline-methods] */
    public abstract String m1449lambda$callMethodMapWebPlugin$36$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: touchUp, reason: merged with bridge method [inline-methods] */
    public abstract String m1448lambda$callMethodMapWebPlugin$35$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: updateLayout, reason: merged with bridge method [inline-methods] */
    public abstract String m1451lambda$callMethodMapWebPlugin$38$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: updateUrl, reason: merged with bridge method [inline-methods] */
    public abstract String m1423lambda$callMethodMapPutPageChange$30$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: updateWebLayout, reason: merged with bridge method [inline-methods] */
    public abstract String m1413lambda$callMethodMapPutLoadMethod$18$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: verticalScrollBarAccess, reason: merged with bridge method [inline-methods] */
    public abstract String m1441lambda$callMethodMapWebAtrribute$4$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: zoom, reason: merged with bridge method [inline-methods] */
    public abstract String m1419lambda$callMethodMapPutLoadMethod$24$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    /* JADX INFO: renamed from: zoomAccess, reason: merged with bridge method [inline-methods] */
    public abstract String m1433lambda$callMethodMapWebAtrribute$0$ohosaceadaptercapabilitywebAceWebBase(Map<String, String> map);

    public abstract String zoomIn();

    public abstract String zoomOut();

    public AceWebBase(long j, IAceOnResourceEvent iAceOnResourceEvent) {
        this.id = j;
        this.callback = iAceOnResourceEvent;
        callMethodMapPutXWardMethod();
        callMethodMapPutLoadMethod();
        callMethodMapPutXactive();
        callMethodMapPutPageChange();
        callMethodMapWebPlugin();
        callMethodMapWebAtrribute();
    }

    private void callMethodMapWebAtrribute() {
        IAceOnCallResourceMethod iAceOnCallResourceMethod = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda36
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1433lambda$callMethodMapWebAtrribute$0$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#zoomAccess#HWJS-?-#", iAceOnCallResourceMethod);
        IAceOnCallResourceMethod iAceOnCallResourceMethod2 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda3
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1434lambda$callMethodMapWebAtrribute$1$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#javascriptAccess#HWJS-?-#", iAceOnCallResourceMethod2);
        IAceOnCallResourceMethod iAceOnCallResourceMethod3 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda4
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1439lambda$callMethodMapWebAtrribute$2$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#minFontSize#HWJS-?-#", iAceOnCallResourceMethod3);
        IAceOnCallResourceMethod iAceOnCallResourceMethod4 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda5
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1440lambda$callMethodMapWebAtrribute$3$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#horizontalScrollBarAccess#HWJS-?-#", iAceOnCallResourceMethod4);
        IAceOnCallResourceMethod iAceOnCallResourceMethod5 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda6
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1441lambda$callMethodMapWebAtrribute$4$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#verticalScrollBarAccess#HWJS-?-#", iAceOnCallResourceMethod5);
        IAceOnCallResourceMethod iAceOnCallResourceMethod6 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda7
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1442lambda$callMethodMapWebAtrribute$5$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#backgroundColor#HWJS-?-#", iAceOnCallResourceMethod6);
        IAceOnCallResourceMethod iAceOnCallResourceMethod7 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda8
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1443lambda$callMethodMapWebAtrribute$6$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#mediaPlayGestureAccess#HWJS-?-#", iAceOnCallResourceMethod7);
        IAceOnCallResourceMethod iAceOnCallResourceMethod8 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda9
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1444lambda$callMethodMapWebAtrribute$7$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#onlineImageAccess#HWJS-?-#", iAceOnCallResourceMethod8);
        IAceOnCallResourceMethod iAceOnCallResourceMethod9 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda10
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1445lambda$callMethodMapWebAtrribute$8$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#geolocationAccess#HWJS-?-#", iAceOnCallResourceMethod9);
        IAceOnCallResourceMethod iAceOnCallResourceMethod10 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda12
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1446lambda$callMethodMapWebAtrribute$9$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#blockNetwork#HWJS-?-#", iAceOnCallResourceMethod10);
        IAceOnCallResourceMethod iAceOnCallResourceMethod11 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda37
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1435lambda$callMethodMapWebAtrribute$10$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#mixedMode#HWJS-?-#", iAceOnCallResourceMethod11);
        IAceOnCallResourceMethod iAceOnCallResourceMethod12 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda38
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1436lambda$callMethodMapWebAtrribute$11$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#domStorageAccess#HWJS-?-#", iAceOnCallResourceMethod12);
        IAceOnCallResourceMethod iAceOnCallResourceMethod13 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda1
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1437lambda$callMethodMapWebAtrribute$12$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#cacheMode#HWJS-?-#", iAceOnCallResourceMethod13);
        IAceOnCallResourceMethod iAceOnCallResourceMethod14 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda2
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1438lambda$callMethodMapWebAtrribute$13$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#imageAccess#HWJS-?-#", iAceOnCallResourceMethod14);
    }

    private void callMethodMapPutXWardMethod() {
        IAceOnCallResourceMethod iAceOnCallResourceMethod = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda26
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1427lambda$callMethodMapPutXWardMethod$14$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#backward#HWJS-?-#", iAceOnCallResourceMethod);
        IAceOnCallResourceMethod iAceOnCallResourceMethod2 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda27
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1428lambda$callMethodMapPutXWardMethod$15$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#forward#HWJS-?-#", iAceOnCallResourceMethod2);
        IAceOnCallResourceMethod iAceOnCallResourceMethod3 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda28
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1429lambda$callMethodMapPutXWardMethod$16$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#accessBackward#HWJS-?-#", iAceOnCallResourceMethod3);
        IAceOnCallResourceMethod iAceOnCallResourceMethod4 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda29
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1430lambda$callMethodMapPutXWardMethod$17$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#accessForward#HWJS-?-#", iAceOnCallResourceMethod4);
    }

    private void callMethodMapPutLoadMethod() {
        IAceOnCallResourceMethod iAceOnCallResourceMethod = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda18
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1413lambda$callMethodMapPutLoadMethod$18$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#layout#HWJS-?-#", iAceOnCallResourceMethod);
        IAceOnCallResourceMethod iAceOnCallResourceMethod2 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda19
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1414lambda$callMethodMapPutLoadMethod$19$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#reload#HWJS-?-#", iAceOnCallResourceMethod2);
        IAceOnCallResourceMethod iAceOnCallResourceMethod3 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda20
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1415lambda$callMethodMapPutLoadMethod$20$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#loadData#HWJS-?-#", iAceOnCallResourceMethod3);
        IAceOnCallResourceMethod iAceOnCallResourceMethod4 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda21
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1416lambda$callMethodMapPutLoadMethod$21$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#accessStep#HWJS-?-#", iAceOnCallResourceMethod4);
        IAceOnCallResourceMethod iAceOnCallResourceMethod5 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda23
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1417lambda$callMethodMapPutLoadMethod$22$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#refresh#HWJS-?-#", iAceOnCallResourceMethod5);
        IAceOnCallResourceMethod iAceOnCallResourceMethod6 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda24
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1418lambda$callMethodMapPutLoadMethod$23$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#stop#HWJS-?-#", iAceOnCallResourceMethod6);
        IAceOnCallResourceMethod iAceOnCallResourceMethod7 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda25
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1419lambda$callMethodMapPutLoadMethod$24$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#zoom#HWJS-?-#", iAceOnCallResourceMethod7);
    }

    private void callMethodMapPutXactive() {
        IAceOnCallResourceMethod iAceOnCallResourceMethod = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda30
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1431lambda$callMethodMapPutXactive$25$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#onActive#HWJS-?-#", iAceOnCallResourceMethod);
        IAceOnCallResourceMethod iAceOnCallResourceMethod2 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda31
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1432lambda$callMethodMapPutXactive$26$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#onInactive#HWJS-?-#", iAceOnCallResourceMethod2);
    }

    private void callMethodMapPutPageChange() {
        IAceOnCallResourceMethod iAceOnCallResourceMethod = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda0
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1420lambda$callMethodMapPutPageChange$27$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#getHitTest#HWJS-?-#", iAceOnCallResourceMethod);
        IAceOnCallResourceMethod iAceOnCallResourceMethod2 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda11
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1421lambda$callMethodMapPutPageChange$28$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#clearHistory#HWJS-?-#", iAceOnCallResourceMethod2);
        IAceOnCallResourceMethod iAceOnCallResourceMethod3 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda22
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1422lambda$callMethodMapPutPageChange$29$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#requestFocus#HWJS-?-#", iAceOnCallResourceMethod3);
        IAceOnCallResourceMethod iAceOnCallResourceMethod4 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda32
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1423lambda$callMethodMapPutPageChange$30$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#updateUrl#HWJS-?-#", iAceOnCallResourceMethod4);
        IAceOnCallResourceMethod iAceOnCallResourceMethod5 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda33
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1424lambda$callMethodMapPutPageChange$31$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#routerBack#HWJS-?-#", iAceOnCallResourceMethod5);
        IAceOnCallResourceMethod iAceOnCallResourceMethod6 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda34
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1425lambda$callMethodMapPutPageChange$32$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#changePageUrl#HWJS-?-#", iAceOnCallResourceMethod6);
        IAceOnCallResourceMethod iAceOnCallResourceMethod7 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda35
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1426lambda$callMethodMapPutPageChange$33$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#pagePathInvalid#HWJS-?-#", iAceOnCallResourceMethod7);
    }

    private void callMethodMapWebPlugin() {
        IAceOnCallResourceMethod iAceOnCallResourceMethod = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda13
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1447lambda$callMethodMapWebPlugin$34$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#touchDown#HWJS-?-#", iAceOnCallResourceMethod);
        IAceOnCallResourceMethod iAceOnCallResourceMethod2 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda14
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1448lambda$callMethodMapWebPlugin$35$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#touchUp#HWJS-?-#", iAceOnCallResourceMethod2);
        IAceOnCallResourceMethod iAceOnCallResourceMethod3 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda15
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1449lambda$callMethodMapWebPlugin$36$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#touchMove#HWJS-?-#", iAceOnCallResourceMethod3);
        IAceOnCallResourceMethod iAceOnCallResourceMethod4 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda16
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1450lambda$callMethodMapWebPlugin$37$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#touchCancel#HWJS-?-#", iAceOnCallResourceMethod4);
        IAceOnCallResourceMethod iAceOnCallResourceMethod5 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.web.AceWebBase$$ExternalSyntheticLambda17
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map) {
                return this.f$0.m1451lambda$callMethodMapWebPlugin$38$ohosaceadaptercapabilitywebAceWebBase(map);
            }
        };
        this.callMethodMap.put(WEB_FLAG + this.id + "method#HWJS-=-#updateLayout#HWJS-?-#", iAceOnCallResourceMethod5);
    }

    public Map<String, IAceOnCallResourceMethod> getCallMethod() {
        return this.callMethodMap;
    }

    public long getId() {
        return this.id;
    }

    public void firePageStarted(String str) {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onPageStarted#HWJS-?-#", str);
    }

    private String makeEventHash(String str) {
        return WEB_FLAG + this.id + "event#HWJS-=-#" + str + PARAM_BEGIN;
    }

    public void fireDownloadStart(Object obj) {
        nativeOnObjectEvent(makeEventHash("onDownloadStart"), "onDownloadStart", obj);
    }

    public void fireJSInvokeMethod(Object obj) {
        nativeOnObjectEvent(makeEventHash("onJSInvokeMethod"), "onJSInvokeMethod", obj);
    }

    public void fireRunJSRecvValue(String str) {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onRunJSRecvValue#HWJS-?-#", str);
    }

    public void fireRefreshHistory(Object obj) {
        nativeOnObjectEvent(makeEventHash("onRefreshAccessedHistory"), "onRefreshAccessedHistory", obj);
    }

    public void fireFullScreenEnter(Object obj) {
        nativeOnObjectEvent(makeEventHash("onFullScreenEnter"), "onFullScreenEnter", obj);
    }

    public void fireFullScreenExit(Object obj) {
        nativeOnObjectEvent(makeEventHash("onFullScreenExit"), "onFullScreenExit", obj);
    }

    public boolean fireUrlLoadIntercept(Object obj) {
        return nativeOnObjectEventWithBoolReturn(makeEventHash("onLoadIntercept"), "onLoadIntercept", obj);
    }

    public Object fireShouldInterceptRequest(Object obj) {
        return nativeOnObjectEventWithObjectReturn(makeEventHash("onInterceptRequest"), "onInterceptRequest", obj);
    }

    public void fireRenderExited(int i) {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onRenderExited#HWJS-?-#", String.valueOf(i));
    }

    public void fireError(String str, int i, String str2) {
        String str3 = Constants.SUFFIX_URL + str + "&errorCode=" + i + "&description=" + str2;
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onPageError#HWJS-?-#", str3);
    }

    public void firePageVisible(String str) {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onPageVisible#HWJS-?-#", str);
    }

    public void firePageFinished(String str) {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onPageFinished#HWJS-?-#", str);
    }

    public void firePageChanged(int i) {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onProgressChanged#HWJS-?-#", String.valueOf(i));
    }

    public void fireScrollChanged(Object obj) {
        nativeOnObjectEvent(WEB_FLAG + this.id + "event#HWJS-=-#onScroll#HWJS-?-#", "onScroll", obj);
    }

    public void fireScaleChanged(Object obj) {
        nativeOnObjectEvent(WEB_FLAG + this.id + "event#HWJS-=-#onScaleChange#HWJS-?-#", "onScaleChange", obj);
    }

    public void firePageRecvTitle(String str) {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onReceivedTitle#HWJS-?-#", str);
    }

    public void firePageGeoHidePermission() {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onGeoHidePermission#HWJS-?-#", "origin");
    }

    public void firePageGeoPermission(Object obj) {
        nativeOnObjectEvent(WEB_FLAG + this.id + "event#HWJS-=-#onGeoPermission#HWJS-?-#", "onGeoPermission", obj);
    }

    public void firePageOnCommonDialog(String str, Object obj) {
        nativeOnObjectEvent(WEB_FLAG + this.id + "event#HWJS-=-#onCommonDialog#HWJS-?-#", str, obj);
    }

    public boolean firePageOnConsoleMessage(Object obj) {
        return nativeOnObjectEventWithBoolReturn(WEB_FLAG + this.id + "event#HWJS-=-#onConsoleMessage#HWJS-?-#", "onConsoleMessage", obj);
    }

    public boolean firePageOnShowFileChooser(Object obj) {
        return nativeOnObjectEventWithBoolReturn(WEB_FLAG + this.id + "event#HWJS-=-#onShowFileChooser#HWJS-?-#", "onShowFileChooser", obj);
    }

    public void fireErrorReceive(Object obj) {
        ALog.i(LOG_TAG, "jcz OnErrorReceive");
        nativeOnObjectEvent(WEB_FLAG + this.id + "event#HWJS-=-#onErrorReceive#HWJS-?-#", "onErrorReceive", obj);
    }

    public void fireHttpErrorReceive(Object obj) {
        nativeOnObjectEvent(WEB_FLAG + this.id + "event#HWJS-=-#onHttpErrorReceive#HWJS-?-#", "onHttpErrorReceive", obj);
    }

    public void fireHttpAuthRequestReceive(Object obj) {
        nativeOnObjectEventWithBoolReturn(WEB_FLAG + this.id + "event#HWJS-=-#onHttpAuthRequest#HWJS-?-#", "onHttpAuthRequest", obj);
    }

    public void firePermissionRequest(Object obj) {
        nativeOnObjectEventWithBoolReturn(WEB_FLAG + this.id + "event#HWJS-=-#onPermissionRequest#HWJS-?-#", "onPermissionRequest", obj);
    }

    public boolean fireJsPrompt(Object obj) {
        return nativeOnObjectEventWithBoolReturn(WEB_FLAG + this.id + "event#HWJS-=-#onPrompt#HWJS-?-#", "onPrompt", obj);
    }

    public boolean fireJsAlert(Object obj) {
        return nativeOnObjectEventWithBoolReturn(WEB_FLAG + this.id + "event#HWJS-=-#onAlert#HWJS-?-#", "onAlert", obj);
    }

    public boolean fireJsConfirm(Object obj) {
        return nativeOnObjectEventWithBoolReturn(WEB_FLAG + this.id + "event#HWJS-=-#onConfirm#HWJS-?-#", "onConfirm", obj);
    }

    public void fireRouterPush(String str) {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#routerPush#HWJS-?-#", str);
    }

    public boolean fireJsBeforeUnload(Object obj) {
        return nativeOnObjectEventWithBoolReturn(makeEventHash("onBeforeUnload"), "onBeforeUnload", obj);
    }

    public void firePostMessage(String str) {
        this.callback.onEvent(WEB_FLAG + this.id + "event#HWJS-=-#onMessage#HWJS-?-#", str);
    }
}
