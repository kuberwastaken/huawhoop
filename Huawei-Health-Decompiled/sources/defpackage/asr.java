package defpackage;

import com.huawei.haf.handler.HandlerCenter;

/* JADX INFO: loaded from: classes10.dex */
final class asr {
    static void c(Runnable runnable) {
        HandlerCenter.a().e(runnable, "mod_ins");
    }

    static void b(Runnable runnable) {
        HandlerCenter.a().e(runnable, "mod_oat");
    }
}
