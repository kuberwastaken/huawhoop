package defpackage;

import java.io.FileNotFoundException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.security.acl.NotOwnerException;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;
import java.util.MissingResourceException;
import java.util.jar.JarException;

/* JADX INFO: loaded from: classes3.dex */
public class cgv {
    public static String c(Throwable th) {
        return c(th, true, true);
    }

    private static String c(Throwable th, boolean z, boolean z2) {
        if (th == null) {
            return "";
        }
        Throwable cause = th.getCause();
        if (cause == null || !z2) {
            return c(th, z);
        }
        return c(th, z) + ", Caused by: " + c(cause, z);
    }

    private static String c(Throwable th, boolean z) {
        if (z) {
            return d(th);
        }
        return th.toString();
    }

    private static String d(Throwable th) {
        if (th instanceof FileNotFoundException) {
            return "*** Exception 10001 ***";
        }
        if (b(th) || a(th)) {
            return th.getClass().getName() + "：******";
        }
        return th.toString();
    }

    public static boolean b(Throwable th) {
        if (th instanceof Error) {
            return e(th);
        }
        if (th instanceof Exception) {
            return h(th);
        }
        return false;
    }

    private static boolean e(Throwable th) {
        return (th instanceof OutOfMemoryError) || (th instanceof StackOverflowError);
    }

    private static boolean h(Throwable th) {
        return (th instanceof FileNotFoundException) || (th instanceof JarException) || (th instanceof BindException) || (th instanceof MissingResourceException) || (th instanceof ConcurrentModificationException) || (th instanceof NotOwnerException) || (th instanceof SQLException);
    }

    private static boolean a(Throwable th) {
        return (th instanceof SocketTimeoutException) || (th instanceof ConnectException);
    }
}
