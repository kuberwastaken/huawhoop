package defpackage;

import net.openid.appauth.Clock;

/* JADX INFO: loaded from: classes8.dex */
public class xyn implements Clock {
    public static final xyn e = new xyn();

    private xyn() {
    }

    @Override // net.openid.appauth.Clock
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
