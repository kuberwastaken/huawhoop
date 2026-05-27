package defpackage;

import com.huawei.health.suggestion.ui.voice.IVoiceContentConstructor;

/* JADX INFO: loaded from: classes5.dex */
public class hmg implements IVoiceContentConstructor {
    private static volatile hmg b;

    @Override // com.huawei.health.suggestion.ui.voice.IVoiceContentConstructor
    public Object constructContent(int i, Object obj) {
        return null;
    }

    private hmg() {
    }

    public static hmg e() {
        if (b == null) {
            synchronized (hmg.class) {
                if (b == null) {
                    b = new hmg();
                }
            }
        }
        return b;
    }
}
