package defpackage;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class mkr extends mku {
    private mkr() {
        super(2, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque(), "AccountPicker-Core-Pool");
    }

    static class c {
        private static final mkr c = new mkr();
    }

    public static mkr e() {
        return c.c;
    }
}
