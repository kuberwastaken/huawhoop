package defpackage;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class mne {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadLocal<SimpleDateFormat> f15731a = new ThreadLocal<>();

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = f15731a.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        f15731a.set(simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static String c(Date date) {
        return a().format(date);
    }
}
