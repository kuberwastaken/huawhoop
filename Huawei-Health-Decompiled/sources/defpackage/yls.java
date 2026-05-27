package defpackage;

import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;

/* JADX INFO: loaded from: classes8.dex */
public class yls {
    static MDCAdapter c;

    private static MDCAdapter e() throws NoClassDefFoundError {
        try {
            return StaticMDCBinder.getSingleton().getMDCA();
        } catch (NoSuchMethodError unused) {
            return StaticMDCBinder.SINGLETON.getMDCA();
        }
    }

    static {
        try {
            c = e();
        } catch (Exception e) {
            yma.a("MDC binding unsuccessful.", e);
        } catch (NoClassDefFoundError e2) {
            c = new ymb();
            String message = e2.getMessage();
            if (message != null && message.contains("StaticMDCBinder")) {
                yma.e("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                yma.e("Defaulting to no-operation MDCAdapter implementation.");
                yma.e("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
                return;
            }
            throw e2;
        }
    }

    public static void d(String str, String str2) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        MDCAdapter mDCAdapter = c;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        mDCAdapter.put(str, str2);
    }

    public static void c() {
        MDCAdapter mDCAdapter = c;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        mDCAdapter.clear();
    }
}
