package defpackage;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class mkt extends mku {
    private mkt() {
        super(1, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque(), "AccountPicker-FileSystem-Pool");
    }

    static class b {
        private static final mkt c = new mkt();
    }

    public static mkt d() {
        return b.c;
    }
}
