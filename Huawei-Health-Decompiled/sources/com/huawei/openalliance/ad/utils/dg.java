package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.hq;
import com.huawei.openalliance.ad.utils.n;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7989a = "dg";

    public static <RESULT> RESULT c(Callable<RESULT> callable) {
        return (RESULT) a(new t(callable), null, 1L, TimeUnit.SECONDS);
    }

    public static <RESULT> RESULT b(Callable<RESULT> callable) {
        return (RESULT) a(callable, null, 1L, TimeUnit.SECONDS);
    }

    public static <RESULT> Future<RESULT> a(Callable<RESULT> callable) {
        if (callable == null) {
            return null;
        }
        return n.a(callable, n.a.SYNC_CALL);
    }

    public static <RESULT> RESULT a(Callable<RESULT> callable, RESULT result, long j, TimeUnit timeUnit) {
        String str;
        String str2;
        if (callable == null) {
            return result;
        }
        try {
            return (RESULT) n.a(callable, n.a.SYNC_CALL).get(j, timeUnit);
        } catch (InterruptedException unused) {
            str = f7989a;
            str2 = "call InterruptedException";
            hq.c(str, str2);
            return result;
        } catch (ExecutionException unused2) {
            str = f7989a;
            str2 = "call ExecutionException";
            hq.c(str, str2);
            return result;
        } catch (TimeoutException unused3) {
            str = f7989a;
            str2 = "call TimeoutException";
            hq.c(str, str2);
            return result;
        }
    }

    public static <RESULT> RESULT a(Callable<RESULT> callable, RESULT result) {
        return (RESULT) a(callable, result, 1L, TimeUnit.SECONDS);
    }

    public static <RESULT> RESULT a(Callable<RESULT> callable, long j, RESULT result) {
        return (RESULT) a(callable, result, j, TimeUnit.MILLISECONDS);
    }
}
