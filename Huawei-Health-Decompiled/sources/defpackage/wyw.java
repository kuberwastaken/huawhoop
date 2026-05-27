package defpackage;

import com.huawei.wisesecurity.kfs.validation.constrains.KfsSize;

/* JADX INFO: loaded from: classes8.dex */
public class wyw {
    public static void d(KfsSize kfsSize) throws www {
        int iMin = kfsSize.min();
        int iMax = kfsSize.max();
        if (iMin < 0) {
            throw new www("min can't be negative");
        }
        if (iMax < 0) {
            throw new www("max can't be negative");
        }
        if (iMax < iMin) {
            throw new www("max should be bigger than min");
        }
    }
}
