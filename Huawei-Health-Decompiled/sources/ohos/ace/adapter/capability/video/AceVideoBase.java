package ohos.ace.adapter.capability.video;

import com.huawei.openalliance.ad.constant.ParamConstants;
import java.util.HashMap;
import java.util.Map;
import ohos.ace.adapter.ALog;
import ohos.ace.adapter.IAceOnCallResourceMethod;
import ohos.ace.adapter.IAceOnResourceEvent;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AceVideoBase {
    private static final String EVENT = "event";
    private static final String LOG_TAG = "AceVideoBase";
    private static final String METHOD = "method";
    private static final String PARAM_AND = "#HWJS-&-#";
    private static final String PARAM_BEGIN = "#HWJS-?-#";
    private static final String PARAM_EQUALS = "#HWJS-=-#";
    private static final String VIDEO_FLAG = "video@";
    private final Map<String, IAceOnCallResourceMethod> callMethodMap;
    private final IAceOnResourceEvent callback;
    private final long id;
    private boolean isAutoPlay = false;
    private boolean isMute = false;
    private boolean isLooping = false;
    private float speed = 1.0f;

    public abstract String enableLooping(Map<String, String> map);

    public abstract String getPosition(Map<String, String> map);

    public abstract void onActivityPause();

    public abstract void onActivityResume();

    public abstract String pause(Map<String, String> map);

    public abstract void release();

    public abstract String runAsync(Runnable runnable);

    public abstract String seekTo(Map<String, String> map);

    public abstract String setDirection(Map<String, String> map);

    public abstract String setLandscape(Map<String, String> map);

    public abstract String setSpeed(Map<String, String> map);

    public abstract String setSurface(Map<String, String> map);

    public abstract String setVolume(Map<String, String> map);

    public abstract String start(Map<String, String> map);

    /* JADX INFO: renamed from: stop, reason: merged with bridge method [inline-methods] */
    public abstract String m1411lambda$null$0$ohosaceadaptercapabilityvideoAceVideoBase(Map<String, String> map);

    /* JADX INFO: renamed from: updateResource, reason: merged with bridge method [inline-methods] */
    public abstract String m1412lambda$null$2$ohosaceadaptercapabilityvideoAceVideoBase(Map<String, String> map);

    public AceVideoBase(long j, IAceOnResourceEvent iAceOnResourceEvent) {
        this.id = j;
        this.callback = iAceOnResourceEvent;
        HashMap map = new HashMap();
        this.callMethodMap = map;
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#init#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.1
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.1.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.initMediaPlayer(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#start#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.2
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.2.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.start(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#pause#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.3
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.3.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.pause(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#stop#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase$$ExternalSyntheticLambda2
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map2) {
                return this.f$0.m1409lambda$new$1$ohosaceadaptercapabilityvideoAceVideoBase(map2);
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#getposition#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.4
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.4.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.getPosition(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#seekto#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.5
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.5.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.seekTo(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#setvolume#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.6
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.6.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.setVolume(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#enablelooping#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.7
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.7.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.enableLooping(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#setspeed#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.8
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.8.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.setSpeed(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#setdirection#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.9
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.9.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.setDirection(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#setlandscape#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.10
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.10.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.setLandscape(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#setsurface#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase.11
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                AceVideoBase.this.runAsync(new InnerProcessor(map2) { // from class: ohos.ace.adapter.capability.video.AceVideoBase.11.1
                    {
                        AceVideoBase aceVideoBase = AceVideoBase.this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AceVideoBase.this.setSurface(this.param);
                    }
                });
                return "";
            }
        });
        map.put(VIDEO_FLAG + j + "method#HWJS-=-#updateresource#HWJS-?-#", new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.video.AceVideoBase$$ExternalSyntheticLambda3
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public final String onCall(Map map2) {
                return this.f$0.m1410lambda$new$3$ohosaceadaptercapabilityvideoAceVideoBase(map2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$1$ohos-ace-adapter-capability-video-AceVideoBase, reason: not valid java name */
    /* synthetic */ String m1409lambda$new$1$ohosaceadaptercapabilityvideoAceVideoBase(final Map map) {
        return runAsync(new Runnable() { // from class: ohos.ace.adapter.capability.video.AceVideoBase$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1411lambda$null$0$ohosaceadaptercapabilityvideoAceVideoBase(map);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$3$ohos-ace-adapter-capability-video-AceVideoBase, reason: not valid java name */
    /* synthetic */ String m1410lambda$new$3$ohosaceadaptercapabilityvideoAceVideoBase(final Map map) {
        return runAsync(new Runnable() { // from class: ohos.ace.adapter.capability.video.AceVideoBase$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1412lambda$null$2$ohosaceadaptercapabilityvideoAceVideoBase(map);
            }
        });
    }

    /* JADX INFO: loaded from: classes11.dex */
    public abstract class InnerProcessor implements Runnable {
        Map<String, String> param;

        public InnerProcessor(Map<String, String> map) {
            this.param = map;
        }
    }

    public Map<String, IAceOnCallResourceMethod> getCallMethod() {
        return this.callMethodMap;
    }

    public String initMediaPlayer(Map<String, String> map) {
        try {
            if (map.containsKey("mute") && Integer.parseInt(map.get("mute")) == 1) {
                this.isMute = true;
            }
            if (map.containsKey("autoplay") && Integer.parseInt(map.get("autoplay")) == 1) {
                this.isAutoPlay = true;
            }
            if (!map.containsKey("speed")) {
                return "success";
            }
            this.speed = Float.parseFloat(map.get("speed"));
            return "success";
        } catch (NumberFormatException unused) {
            ALog.e(LOG_TAG, "NumberFormatException");
            return ParamConstants.CallbackMethod.ON_FAIL;
        }
    }

    public long getId() {
        return this.id;
    }

    public boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public boolean isMute() {
        return this.isMute;
    }

    public void setIsMute(boolean z) {
        this.isMute = z;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public boolean isLooping() {
        return this.isLooping;
    }

    public void setLooping(boolean z) {
        this.isLooping = z;
    }

    public void firePrepared(int i, int i2, int i3, boolean z, boolean z2) {
        String str = "width=" + i + "&height=" + i2 + "&duration=" + i3 + "&isplaying=" + (z ? 1 : 0) + "&needRefreshForce=" + (z2 ? 1 : 0);
        this.callback.onEvent(VIDEO_FLAG + this.id + "event#HWJS-=-#prepared#HWJS-?-#", str);
    }

    public void fireError() {
        this.callback.onEvent(VIDEO_FLAG + this.id + "event#HWJS-=-#error#HWJS-?-#", "");
    }

    public void fireCompletion() {
        this.callback.onEvent(VIDEO_FLAG + this.id + "event#HWJS-=-#completion#HWJS-?-#", "");
    }

    public void fireSeekComplete(int i) {
        this.callback.onEvent(VIDEO_FLAG + this.id + "event#HWJS-=-#seekcomplete#HWJS-?-#", "currentpos=" + i);
    }

    public void fireBufferingUpdate(int i) {
        this.callback.onEvent(VIDEO_FLAG + this.id + "event#HWJS-=-#bufferingupdate#HWJS-?-#", "percent=" + i);
    }

    public void firePlayStatusChange(boolean z) {
        this.callback.onEvent(VIDEO_FLAG + this.id + "event#HWJS-=-#onplaystatus#HWJS-?-#", "isplaying=" + (z ? 1 : 0));
    }

    public void fireGetCurrenttime(int i) {
        this.callback.onEvent(VIDEO_FLAG + this.id + "event#HWJS-=-#ongetcurrenttime#HWJS-?-#", "currentpos=" + i);
    }
}
