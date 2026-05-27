package com.huawei.openalliance.ad;

import com.huawei.openalliance.ad.constant.Constants;
import com.iab.omid.library.huawei.adsession.Owner;

/* JADX INFO: loaded from: classes6.dex */
public enum mm {
    NATIVE(Constants.NATIVE_CACHE),
    JAVASCRIPT("javascript"),
    NONE("none");

    private static boolean d;
    private final String e;

    @Override // java.lang.Enum
    public String toString() {
        return this.e;
    }

    public static boolean a() {
        return d;
    }

    public static Owner a(mm mmVar) {
        if (!d) {
            return null;
        }
        int i = AnonymousClass1.f7520a[mmVar.ordinal()];
        if (i == 1) {
            return Owner.NATIVE;
        }
        if (i == 2) {
            return Owner.JAVASCRIPT;
        }
        if (i != 3) {
            return null;
        }
        return Owner.NONE;
    }

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.mm$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7520a;

        static {
            int[] iArr = new int[mm.values().length];
            f7520a = iArr;
            try {
                iArr[mm.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7520a[mm.JAVASCRIPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7520a[mm.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    mm(String str) {
        this.e = str;
    }

    static {
        d = false;
        d = mc.a("com.iab.omid.library.huawei.adsession.Owner");
    }
}
