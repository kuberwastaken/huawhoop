package com.huawei.haf.common.exception;

import health.compact.a.LogConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.security.acl.NotOwnerException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.IdentityHashMap;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.jar.JarException;

/* JADX INFO: loaded from: classes.dex */
public final class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static void b(Throwable th, PrintStream printStream, boolean z) {
        new WrappedThrowable(th).b(printStream, z);
    }

    public static void d(Throwable th, PrintWriter printWriter, boolean z) {
        new WrappedThrowable(th).d(printWriter, z);
    }

    public static String a(Throwable th) {
        return e(th, !LogConfig.b(), !(th instanceof ClassNotFoundException));
    }

    public static String e(Throwable th, boolean z, boolean z2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Throwable th) {
        if (th instanceof FileNotFoundException) {
            return "*** Exception 10001 ***";
        }
        if (e(th) || c(th)) {
            return th.getClass().getName() + "：******";
        }
        return th.toString();
    }

    private static boolean c(Throwable th) {
        return (th instanceof SocketTimeoutException) || (th instanceof ConnectException);
    }

    public static void a(Thread thread, Throwable th, PrintStream printStream) {
        if (th != null) {
            b(th, printStream, true);
        } else {
            WrappedThrowable.b(thread.getStackTrace(), new WrappedPrintStream(printStream));
        }
        printStream.flush();
    }

    public static void b(Thread thread, Throwable th, PrintWriter printWriter) {
        if (th != null) {
            d(th, printWriter, true);
        } else {
            WrappedThrowable.b(thread.getStackTrace(), new WrappedPrintWriter(printWriter));
        }
        printWriter.flush();
    }

    public static boolean e(Throwable th) {
        if (th instanceof Exception) {
            return j(th);
        }
        if (th instanceof Error) {
            return h(th);
        }
        return false;
    }

    private static boolean j(Throwable th) {
        if (th instanceof IOException) {
            return g(th);
        }
        if (th instanceof RuntimeException) {
            return f(th);
        }
        return (th instanceof NotOwnerException) || (th instanceof SQLException);
    }

    private static boolean g(Throwable th) {
        return (th instanceof FileNotFoundException) || (th instanceof JarException) || (th instanceof BindException);
    }

    private static boolean f(Throwable th) {
        return (th instanceof MissingResourceException) || (th instanceof ConcurrentModificationException);
    }

    private static boolean h(Throwable th) {
        return (th instanceof OutOfMemoryError) || (th instanceof StackOverflowError);
    }

    static class WrappedThrowable {
        private final Throwable b;
        private Set<Throwable> e;

        WrappedThrowable(Throwable th) {
            this.b = th;
        }

        void d(PrintWriter printWriter, boolean z) {
            if (z) {
                e(new WrappedPrintWriter(printWriter));
            } else {
                this.b.printStackTrace(printWriter);
            }
        }

        void b(PrintStream printStream, boolean z) {
            if (z) {
                e(new WrappedPrintStream(printStream));
            } else {
                this.b.printStackTrace(printStream);
            }
        }

        static void b(StackTraceElement[] stackTraceElementArr, PrintStreamOrWriter printStreamOrWriter) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                printStreamOrWriter.append("\tat ").println(stackTraceElement);
            }
        }

        private void e(PrintStreamOrWriter printStreamOrWriter) {
            Set<Throwable> setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            this.e = setNewSetFromMap;
            setNewSetFromMap.add(this.b);
            synchronized (printStreamOrWriter.lock()) {
                printStreamOrWriter.println(ExceptionUtils.d(this.b));
                StackTraceElement[] stackTrace = this.b.getStackTrace();
                b(stackTrace, printStreamOrWriter);
                for (Throwable th : this.b.getSuppressed()) {
                    b(th, printStreamOrWriter, stackTrace, "Suppressed: ", "\t");
                }
                Throwable cause = this.b.getCause();
                if (cause != null) {
                    b(cause, printStreamOrWriter, stackTrace, "Caused by: ", "");
                }
            }
        }

        private void b(Throwable th, PrintStreamOrWriter printStreamOrWriter, StackTraceElement[] stackTraceElementArr, String str, String str2) {
            if (this.e.contains(th)) {
                printStreamOrWriter.append("\t[CIRCULAR REFERENCE:").append(ExceptionUtils.d(th)).println("]");
                return;
            }
            this.e.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length - 1;
            for (int length2 = stackTraceElementArr.length - 1; length >= 0 && length2 >= 0 && stackTrace[length].equals(stackTraceElementArr[length2]); length2--) {
                length--;
            }
            int length3 = (stackTrace.length - 1) - length;
            printStreamOrWriter.append(str2).append(str).println(ExceptionUtils.d(th));
            for (int i = 0; i <= length; i++) {
                printStreamOrWriter.append(str2).append("\tat ").println(stackTrace[i]);
            }
            if (length3 != 0) {
                printStreamOrWriter.append(str2).append("\t... ").append(String.valueOf(length3)).println(" more");
            }
            for (Throwable th2 : th.getSuppressed()) {
                b(th2, printStreamOrWriter, stackTrace, "Suppressed: ", str2 + "\t");
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                b(cause, printStreamOrWriter, stackTrace, "Caused by: ", str2);
            }
        }
    }

    static abstract class PrintStreamOrWriter {
        abstract PrintStreamOrWriter append(String str);

        abstract Object lock();

        abstract void println(Object obj);

        private PrintStreamOrWriter() {
        }
    }

    static class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream b;

        WrappedPrintStream(PrintStream printStream) {
            super();
            this.b = printStream;
        }

        @Override // com.huawei.haf.common.exception.ExceptionUtils.PrintStreamOrWriter
        Object lock() {
            return this.b;
        }

        @Override // com.huawei.haf.common.exception.ExceptionUtils.PrintStreamOrWriter
        void println(Object obj) {
            this.b.println(obj);
        }

        @Override // com.huawei.haf.common.exception.ExceptionUtils.PrintStreamOrWriter
        PrintStreamOrWriter append(String str) {
            this.b.append((CharSequence) str);
            return this;
        }
    }

    static class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter b;

        WrappedPrintWriter(PrintWriter printWriter) {
            super();
            this.b = printWriter;
        }

        @Override // com.huawei.haf.common.exception.ExceptionUtils.PrintStreamOrWriter
        Object lock() {
            return this.b;
        }

        @Override // com.huawei.haf.common.exception.ExceptionUtils.PrintStreamOrWriter
        void println(Object obj) {
            this.b.println(obj);
        }

        @Override // com.huawei.haf.common.exception.ExceptionUtils.PrintStreamOrWriter
        PrintStreamOrWriter append(String str) {
            this.b.append((CharSequence) str);
            return this;
        }
    }
}
