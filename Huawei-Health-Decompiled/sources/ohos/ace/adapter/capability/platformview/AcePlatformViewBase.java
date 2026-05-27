package ohos.ace.adapter.capability.platformview;

import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;
import ohos.ace.adapter.IAceOnCallResourceMethod;
import ohos.ace.adapter.IAceOnResourceEvent;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AcePlatformViewBase {
    private static final String EVENT = "event";
    private static final String LOG_TAG = "AcePlatformViewBase";
    private static final String METHOD = "method";
    private static final String PARAM_AND = "#HWJS-&-#";
    private static final String PARAM_BEGIN = "#HWJS-?-#";
    private static final String PARAM_EQUALS = "#HWJS-=-#";
    private static final String PLATFORM_VIEW_FLAG = "platformview@";
    private final Map<String, IAceOnCallResourceMethod> callMethodMap;
    private final IAceOnResourceEvent callback;
    private final long id;

    /* JADX INFO: renamed from: dispose, reason: merged with bridge method [inline-methods] */
    public abstract String m1400lambda$new$4$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(Map<String, String> map);

    public abstract void onActivityPause();

    public abstract void onActivityResume();

    public abstract String registerPlatformView(Map<String, String> map);

    public abstract void release();

    public abstract String runAsync(Runnable runnable);

    public abstract void setTouchEvent(MotionEvent motionEvent);

    /* JADX INFO: renamed from: touchCancel, reason: merged with bridge method [inline-methods] */
    public abstract String m1399lambda$new$3$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(Map<String, String> map);

    /* JADX INFO: renamed from: touchDown, reason: merged with bridge method [inline-methods] */
    public abstract String m1396lambda$new$0$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(Map<String, String> map);

    /* JADX INFO: renamed from: touchMove, reason: merged with bridge method [inline-methods] */
    public abstract String m1398lambda$new$2$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(Map<String, String> map);

    /* JADX INFO: renamed from: touchUp, reason: merged with bridge method [inline-methods] */
    public abstract String m1397lambda$new$1$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(Map<String, String> map);

    public abstract String updateLayout(Map<String, String> map);

    public AcePlatformViewBase(long j, IAceOnResourceEvent iAceOnResourceEvent) {
        this.id = j;
        this.callback = iAceOnResourceEvent;
        HashMap map = new HashMap();
        this.callMethodMap = map;
        map.put(PLATFORM_VIEW_FLAG + j + "method#HWJS-=-#registerPlatformView#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.platformview.AcePlatformViewBase.1
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AcePlatformViewBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.platformview.AcePlatformViewBase.1.1
                    {
                        AcePlatformViewBase acePlatformViewBase = AcePlatformViewBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AcePlatformViewBase.this.registerPlatformView(this.param);
                    }
                });
                return "";
            }
        });
        map.put(PLATFORM_VIEW_FLAG + j + "method#HWJS-=-#updateLayout#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.platformview.AcePlatformViewBase.2
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AcePlatformViewBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.platformview.AcePlatformViewBase.2.1
                    {
                        AcePlatformViewBase acePlatformViewBase = AcePlatformViewBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AcePlatformViewBase.this.updateLayout(this.param);
                    }
                });
                return "";
            }
        });
        map.put(PLATFORM_VIEW_FLAG + j + "method#HWJS-=-#touchDown#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.platformview.AcePlatformViewBase$$ExternalSyntheticLambda0
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map2) {
                return this.f$0.m1396lambda$new$0$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(map2);
            }
        });
        map.put(PLATFORM_VIEW_FLAG + j + "method#HWJS-=-#touchUp#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.platformview.AcePlatformViewBase$$ExternalSyntheticLambda1
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map2) {
                return this.f$0.m1397lambda$new$1$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(map2);
            }
        });
        map.put(PLATFORM_VIEW_FLAG + j + "method#HWJS-=-#touchMove#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.platformview.AcePlatformViewBase$$ExternalSyntheticLambda2
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map2) {
                return this.f$0.m1398lambda$new$2$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(map2);
            }
        });
        map.put(PLATFORM_VIEW_FLAG + j + "method#HWJS-=-#touchCancel#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.platformview.AcePlatformViewBase$$ExternalSyntheticLambda3
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map2) {
                return this.f$0.m1399lambda$new$3$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(map2);
            }
        });
        map.put(PLATFORM_VIEW_FLAG + j + "method#HWJS-=-#dispose#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.platformview.AcePlatformViewBase$$ExternalSyntheticLambda4
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map2) {
                return this.f$0.m1400lambda$new$4$ohosaceadaptercapabilityplatformviewAcePlatformViewBase(map2);
            }
        });
    }

    public Map<String, IAceOnCallResourceMethod> getCallMethod() {
        return this.callMethodMap;
    }

    public long getId() {
        return this.id;
    }

    public void platformViewReady() {
        this.callback.onEvent(PLATFORM_VIEW_FLAG + this.id + "event#HWJS-=-#platformViewReady#HWJS-?-#", "");
    }

    /* JADX INFO: loaded from: classes11.dex */
    public abstract class InnerProcessor implements Runnable {
        Map<String, String> param;

        public InnerProcessor(Map<String, String> map) {
            this.param = map;
        }
    }
}
