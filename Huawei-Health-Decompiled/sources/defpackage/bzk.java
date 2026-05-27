package defpackage;

import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public class bzk {
    public static final Map<String, String> d = new ConcurrentHashMap(0);
    static final Timer e = new Timer("VoipResendHandle");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f550a = new HashMap();
    public final Map<String, String> c = new HashMap();
    private TimerTask b = null;

    public void c() {
        if (this.b != null) {
            LogUtil.b("VoipResendHandle", "onNotificationRemoved cleaResendLongVibrateCache timerTask cancel");
            this.b.cancel();
        } else {
            LogUtil.b("VoipResendHandle", "onNotificationRemoved clearResendLongVibrateCache timerTask is null");
        }
    }

    public void a() {
        this.f550a.put("com.whatsapp", "reject_call");
        this.f550a.put("jp.naver.line.android", "com.linecorp.intent.action.voip.default");
        this.f550a.put("com.instagram.android", "DECLINE");
        this.f550a.put("org.telegram.messenger", "org.telegram.messenger.DECLINE_CALL");
        this.f550a.put("com.facebook.orca", "com.facebook.intent.action.prod.RTC_DECLINE_CALL_ACTION");
        this.f550a.put("com.viber.voip", "com.viber.voip.action.REJECT_CALL");
        this.f550a.put("org.thoughtcrime.securesms", "org.thoughtcrime.securesms.service.webrtc.ActiveCallAction.DENY");
        this.c.put("com.whatsapp", "hangup_call");
        this.c.put("jp.naver.line.android", "com.linecorp.intent.action.voip.default");
        this.c.put("com.instagram.android", "LEAVE");
        this.c.put("org.telegram.messenger", "org.telegram.messenger.END_CALL");
        this.c.put("com.facebook.orca", "com.facebook.rtc.fbwebrtc.intent.action.HOSTED_FRAGMENT_SHOW_UI");
        this.c.put("org.thoughtcrime.securesms", "org.thoughtcrime.securesms.service.webrtc.ActiveCallAction.HANGUP");
    }

    public void d(String str) {
        LogUtil.a("VoipResendHandle", "createResendLongVibrateCache put  app=", str);
        Map<String, String> map = d;
        map.put(str, str);
        TimerTask timerTask = this.b;
        if (timerTask != null) {
            timerTask.cancel();
        }
        try {
            TimerTask timerTaskB = b(map, str);
            this.b = timerTaskB;
            e.schedule(timerTaskB, 60000L);
        } catch (IllegalArgumentException | IllegalStateException e2) {
            ReleaseLogUtil.c("VoipResendHandle", "activeClearMapTimerTaskAfterGap exception: ", ExceptionUtils.a(e2));
        }
    }

    private TimerTask b(final Map map, final String str) {
        return new TimerTask() { // from class: bzk.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                map.clear();
                ReleaseLogUtil.d("Notify_VoipResendHandle", str, " map been cleared");
            }
        };
    }
}
