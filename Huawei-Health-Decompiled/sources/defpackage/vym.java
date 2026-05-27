package defpackage;

import com.huawei.hms.framework.common.ExceptionCode;
import java.util.Date;

/* JADX INFO: loaded from: classes8.dex */
public final class vym {
    public static String d() {
        int iNextInt = (vyo.d().nextInt(ExceptionCode.CRASH_EXCEPTION) + ExceptionCode.CRASH_EXCEPTION) % ExceptionCode.CRASH_EXCEPTION;
        if (iNextInt < 1000000) {
            iNextInt += 1000000;
        }
        return vyp.b(new Date(System.currentTimeMillis()), "yyyyMMddHHmmssSSS") + iNextInt;
    }
}
